package com.pxd.service;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.pxd.common.constant.RedisKeyConstant;
import com.pxd.common.utils.PasswordUtil;
import com.pxd.control.common.enums.ErrorCodeEnum;
import com.pxd.control.common.result.Result;
import com.pxd.dubbo.user.dto.SysUserDto;
import com.pxd.dubbo.user.service.SysUserService;
import com.pxd.vo.LoginUserVo;
import com.pxd.vo.LoginVo;
import com.pxd.vo.VerificationVo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class LoginService {

    @Resource
    RedissonClient redissonClient;
    @DubboReference
    SysUserService sysUserService;

    public Result<?> login(LoginVo loginVo) {
        RBucket<String> bucket = redissonClient.getBucket(RedisKeyConstant.ADMIN_VERIFICATION_IMAGE + loginVo.getCodeId());
        if (!bucket.isExists()) {
            return Result.result(ErrorCodeEnum.VERIFICATION_EXPIRED);
        }
        if (!Objects.equals(loginVo.getCode(), bucket.get())) {
            return Result.result(ErrorCodeEnum.VERIFICATION_FAIL);
        }
        SysUserDto sysUserDto = sysUserService.findByUsername(loginVo.getUsername());
        if (sysUserDto == null) {
            return Result.result(ErrorCodeEnum.USER_USERNAME_NOT_NULL);
        }
        if (!PasswordUtil.verify(loginVo.getPassword(), sysUserDto.getPassword())) {
            return Result.result(ErrorCodeEnum.USER_PASSWORD_FAIL);
        }
        String simpleUUID = IdUtil.simpleUUID();
        LoginUserVo loginUserVo = new LoginUserVo();
        loginUserVo.setToken(simpleUUID);
        loginUserVo.setUserId(sysUserDto.getId());
        RMap<String, LoginUserVo> loginUserInfoMap = redissonClient.getMap(RedisKeyConstant.LOGIN_USER_INFO);
        loginUserInfoMap.put(simpleUUID, loginUserVo);
        return Result.ok();
    }

    public Result<VerificationVo> verification() {
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
        String simpleUUID = IdUtil.simpleUUID();
        RBucket<String> bucket = redissonClient.getBucket(RedisKeyConstant.ADMIN_VERIFICATION_IMAGE + simpleUUID);
        bucket.set(captcha.getCode(), 120, TimeUnit.SECONDS);
        return Result.ok(VerificationVo.init(captcha.getImageBase64(), simpleUUID));
    }

}
