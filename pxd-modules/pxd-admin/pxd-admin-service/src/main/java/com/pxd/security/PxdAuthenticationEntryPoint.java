package com.pxd.security;

import cn.hutool.json.JSONUtil;
import com.pxd.common.base.enums.ErrorCodeEnum;
import com.pxd.common.base.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class PxdAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        String message = authException.getMessage();
        if (authException instanceof InsufficientAuthenticationException) {
            message = "身份过期，请重新登录";
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(JSONUtil.toJsonStr(Result.error(ErrorCodeEnum.NOT_ACCESS_PERMISSION.getCode(), message)));
    }

}
