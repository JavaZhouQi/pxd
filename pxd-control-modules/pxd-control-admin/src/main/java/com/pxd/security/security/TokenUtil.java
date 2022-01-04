
package com.pxd.security.security;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.pxd.security.config.SecurityProperties;
import com.pxd.security.security.vo.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Token 工具类
 *
 * @author lioncity
 */
@Slf4j
@Component
public class TokenUtil {

    @Autowired
    SecurityProperties properties;
    @Autowired
    RedissonClient redissonClient;

    /**
     * 权限缓存前缀
     */
    private static final String REDIS_PREFIX_AUTH = "auth:";

    /**
     * 用户信息缓存前缀
     */
    private static final String REDIS_PREFIX_USER = "user-details:";

    /**
     * 获取用户名
     *
     * @param token Token
     * @return String
     */
    public String getUsernameFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims != null ? claims.getSubject() : null;
    }

    /**
     * 获取过期时间
     *
     * @param token Token
     * @return Date
     */

    public Date getExpiredFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims != null ? claims.getExpiration() : null;
    }

    /**
     * 获得 Claims
     *
     * @param token Token
     * @return Claims
     */

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(properties.getSecret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.warn("getClaimsFromToken exception", e);
            claims = null;
        }
        return claims;
    }

    /**
     * 计算过期时间
     *
     * @return Date
     */
    private Date generateExpired() {
        return new Date(System.currentTimeMillis() + properties.getTokenValidityInSeconds() * 1000);
    }

    /**
     * 判断 Token 是否过期
     *
     * @param token Token
     * @return Boolean
     */
    private Boolean isTokenExpired(String token) {
        Date expirationDate = getExpiredFromToken(token);
        return expirationDate.before(new Date());
    }

    /**
     * 生成 Token
     *
     * @param userDetails 用户信息
     * @return String
     */
    public String generateToken(UserDetails userDetails) {
        String secret = properties.getSecret();
        String token = Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setExpiration(generateExpired())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

        String key = REDIS_PREFIX_AUTH + userDetails.getUsername() + ":" + token;
        redissonClient.getBucket(key).set(token, properties.getTokenValidityInSeconds() / 1000, TimeUnit.SECONDS);
        putUserDetails(userDetails);
        return token;
    }

    /**
     * 验证 Token
     *
     * @param token Token
     * @return Boolean
     */
    public Boolean validateToken(String token) {
        final String username = getUsernameFromToken(token);
        String key = REDIS_PREFIX_AUTH + username + ":" + token;
        RBucket<String> bucket = redissonClient.getBucket(key);
        String redisToken = bucket.isExists() ? bucket.get() : null;
        return StringUtils.isNotEmpty(token) && !isTokenExpired(token) && token.equals(redisToken);
    }

    /**
     * 移除 Token
     *
     * @param token Token
     */
    public void removeToken(String token) {
        final String username = getUsernameFromToken(token);
        String key = REDIS_PREFIX_AUTH + username + ":" + token;
        RBucket<String> bucket = redissonClient.getBucket(key);
        if (bucket.isExists()) {
            bucket.delete();
        }
        delUserDetails(username);
    }

    /**
     * 获得用户信息 Json 字符串
     *
     * @param token Token
     * @return String
     */
    protected String getUserDetailsString(String token) {
        final String username = getUsernameFromToken(token);
        String key = REDIS_PREFIX_USER + username;
        RBucket<String> bucket = redissonClient.getBucket(key);
        return bucket.isExists() ? bucket.get() : null;
    }

    /**
     * 获得用户信息
     *
     * @param token Token
     * @return UserDetails
     */
    public UserDetails getUserDetails(String token) {
        String userDetailsString = getUserDetailsString(token);
        if (userDetailsString != null) {
            return new Gson().fromJson(userDetailsString, JwtUser.class);
        }
        return null;
    }

    /**
     * 存储用户信息
     *
     * @param userDetails 用户信息
     */

    private void putUserDetails(UserDetails userDetails) {
        String key = REDIS_PREFIX_USER + userDetails.getUsername();
        redissonClient.getBucket(key).set(new Gson().toJson(userDetails), properties.getTokenValidityInSeconds() / 1000, TimeUnit.SECONDS);
    }


    /**
     * 删除用户信息
     *
     * @param username 用户名
     */

    private void delUserDetails(String username) {
        String key = REDIS_PREFIX_USER + username;
        RBucket<Object> bucket = redissonClient.getBucket(key);
        if (bucket.isExists()) {
            bucket.delete();
        }
    }

    public String getToken(HttpServletRequest request) {
        return request.getHeader(properties.getHeader());
    }
}
