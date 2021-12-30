package com.pxd.controller;

import com.pxd.control.common.result.Result;
import com.pxd.service.LoginService;
import com.pxd.vo.LoginVo;
import com.pxd.vo.VerificationVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "登录相关接口")
@RestController
public class LoginController {

    @Resource
    LoginService loginService;

    @ApiOperation(value = "获取验证码")
    @GetMapping("/verification")
    public Result<VerificationVo> verification(){
        return loginService.verification();
    }


    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Result<?> login(@RequestBody LoginVo loginVo){
        return loginService.login(loginVo);
    }

}
