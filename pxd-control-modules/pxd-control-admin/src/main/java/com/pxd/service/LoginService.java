package com.pxd.service;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.core.util.IdUtil;
import com.pxd.common.constant.RedisKeyConstant;
import com.pxd.control.common.enums.ErrorCodeEnum;
import com.pxd.control.common.result.Result;
import com.pxd.dubbo.user.service.SysUserService;
import com.pxd.security.token.TokenUser;
import com.pxd.security.token.TokenUtil;
import com.pxd.vo.LoginUserVo;
import com.pxd.vo.LoginVo;
import com.pxd.vo.VerificationVo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class LoginService {

    @Resource
    RedissonClient redissonClient;
    @Resource
    AuthenticationManagerBuilder authenticationManagerBuilder;

    public Result<?> login(LoginVo loginVo) {
        RBucket<String> bucket = redissonClient.getBucket(RedisKeyConstant.ADMIN_VERIFICATION_IMAGE + loginVo.getCodeId());
        if (!bucket.isExists()) {
            return Result.result(ErrorCodeEnum.VERIFICATION_EXPIRED);
        }
        String code = bucket.get();
        bucket.delete();
        if (!Objects.equals(loginVo.getCode(), code)) {
            return Result.result(ErrorCodeEnum.VERIFICATION_FAIL);
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginVo.getUsername(), loginVo.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 生成令牌
        final TokenUser tokenUser = (TokenUser) authentication.getPrincipal();
        String token = TokenUtil.generateToken(tokenUser);
        LoginUserVo loginUserVo = new LoginUserVo();
        loginUserVo.setToken(token);
        loginUserVo.setUserId(tokenUser.getId());
        return Result.ok(loginUserVo);
    }

    public Result<VerificationVo> verification() {
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
        String simpleUUID = IdUtil.simpleUUID();
        RBucket<String> bucket = redissonClient.getBucket(RedisKeyConstant.ADMIN_VERIFICATION_IMAGE + simpleUUID);
        bucket.set(captcha.getCode(), 120, TimeUnit.SECONDS);
        return Result.ok(VerificationVo.init(captcha.getImageBase64(), simpleUUID));
    }

}
