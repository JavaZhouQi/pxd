package com.pxd.security.token;

import com.pxd.security.config.SecurityProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class TokenUtil {
    private static final String REDIS_TOKEN_KEY = "token:";
    private static final String REDIS_USER_KEY = "user:";

    private static SecurityProperties properties;
    private static RedissonClient redissonClient;

    public TokenUtil(SecurityProperties properties,
                     RedissonClient redissonClient) {
        TokenUtil.properties = properties;
        TokenUtil.redissonClient = redissonClient;
    }

    /**
     * 生成token
     */
    public static String generateToken(TokenUser tokenUser) {
        String secret = properties.getSecret();
        String token = Jwts.builder()
                .setSubject(tokenUser.getId().toString())
                .setExpiration(generateExpired())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        String key = REDIS_TOKEN_KEY + tokenUser.getId() + ":" + token;
        RBucket<String> bucket = redissonClient.getBucket(key);
        bucket.set(token, properties.getExpirationTime(), TimeUnit.SECONDS);
        putUserDetails(tokenUser);
        return token;
    }

    /**
     * 获取用户名
     */
    public static Long getId(String token) {
        Claims claims = getClaims(token);
        return claims != null ? Long.valueOf(claims.getSubject()) : null;
    }

    /**
     * 获取过期时间
     */
    public static Date getExpired(String token) {
        Claims claims = getClaims(token);
        return claims != null ? claims.getExpiration() : null;
    }

    /**
     * 计算过期时间
     */
    private static Date generateExpired() {
        return new Date(System.currentTimeMillis() + properties.getExpirationTime() * 1000);
    }

    /**
     * 判断 Token 是否过期
     */
    public static Boolean isTokenExpired(String token) {
        Date expirationDate = getExpired(token);
        return expirationDate.before(new Date());
    }

    /**
     * 获得 Claims
     */
    private static Claims getClaims(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(properties.getSecret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 移除 Token
     */
    public void removeToken(String token) {
        Long id = getId(token);
        RBucket<String> bucket = redissonClient.getBucket(REDIS_TOKEN_KEY + id + ":" + token);
        if (bucket.isExists()) {
            bucket.delete();
        }
        delUserDetails(id);
    }

    /**
     * 存储用户信息
     */
    private static void putUserDetails(TokenUser tokenUser) {
        RBucket<TokenUser> bucket = redissonClient.getBucket(REDIS_USER_KEY + tokenUser.getId());
        bucket.set(tokenUser, properties.getExpirationTime(), TimeUnit.SECONDS);
    }

    /**
     * 删除用户信息
     */
    private static void delUserDetails(Long id) {
        RBucket<TokenUser> bucket = redissonClient.getBucket(REDIS_USER_KEY + id);
        if (bucket.isExists()) {
            bucket.delete();
        }
    }

    /**
     * 获取用户信息
     */
    public static TokenUser getTokenUser(String token) {
        Long id = getId(token);
        RBucket<TokenUser> bucket = redissonClient.getBucket(REDIS_USER_KEY + id);
        return bucket.get();
    }

    public static String getToken(HttpServletRequest request) {
        return request.getHeader(properties.getHeader());
    }
}

