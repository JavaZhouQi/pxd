package com.pxd.security.security;

import com.pxd.common.utils.SpringContextUtils;
import com.pxd.security.config.SecurityProperties;
import com.pxd.security.security.vo.OnlineUser;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author /
 */
@Slf4j
public class TokenFilter extends GenericFilterBean {

    private final TokenUtil tokenUtil;

    TokenFilter(TokenUtil tokenUtil) {
        this.tokenUtil = tokenUtil;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String requestRri = httpServletRequest.getRequestURI();

        // 验证 token 是否存在
        //OnlineUser onlineUser = null;
        String authToken = "";
        try {
            SecurityProperties properties = SpringContextUtils.getBean(SecurityProperties.class);
            //OnlineUserService onlineUserService = SpringContextUtils.getBean(OnlineUserService.class);
            authToken = tokenUtil.getToken(httpServletRequest);
            if (authToken == null) {
                filterChain.doFilter(httpServletRequest, servletResponse);
                return;
            }
            //onlineUser = onlineUserService.getOne(properties.getOnlineKey() + authToken);
        } catch (ExpiredJwtException e) {
            log.error(e.getMessage());
        }

        String username = StringUtils.isNotBlank(authToken) ? tokenUtil.getUsernameFromToken(authToken) : null;
        if (//onlineUser != null &&
                username != null && SecurityContextHolder.getContext().getAuthentication() == null && tokenUtil.validateToken(authToken)) {
            UserDetails userDetails = tokenUtil.getUserDetails(authToken);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            log.debug("set Authentication to security context for '{}', uri: {}", authentication.getName(), requestRri);
        } else {
            tokenUtil.removeToken(authToken);
            log.debug("no valid JWT token found, uri: {}", requestRri);
        }
        filterChain.doFilter(httpServletRequest, servletResponse);
    }
}