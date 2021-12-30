package com.pxd.service;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.core.util.IdUtil;
import com.pxd.common.constant.RedisKeyConstant;
import com.pxd.control.common.result.Result;
import com.pxd.dubbo.user.service.SysUserService;
import com.pxd.vo.LoginVo;
import com.pxd.vo.VerificationVo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class LoginService {

    @Resource
    RedissonClient redissonClient;

    @DubboReference
    SysUserService sysUserService;

    public Result<?> login(LoginVo loginVo) {
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
