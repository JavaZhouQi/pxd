package com.pxd.security.config;

import cn.hutool.json.JSONUtil;
import com.pxd.security.PxdAccessDeniedHandler;
import com.pxd.security.PxdAuthenticationEntryPoint;
import com.pxd.security.annotation.AnonymousAccess;
import com.pxd.security.token.TokenConfigurer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PxdAuthenticationEntryPoint pxdAuthenticationEntryPoint;
    private final PxdAccessDeniedHandler pxdAccessDeniedHandler;
    private final ApplicationContext applicationContext;

    public SecurityConfig(PxdAuthenticationEntryPoint pxdAuthenticationEntryPoint,
                          PxdAccessDeniedHandler pxdAccessDeniedHandler,
                          ApplicationContext applicationContext) {
        this.pxdAuthenticationEntryPoint = pxdAuthenticationEntryPoint;
        this.pxdAccessDeniedHandler = pxdAccessDeniedHandler;
        this.applicationContext = applicationContext;
    }

    /**
     * ??????????????????
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // ?????? CSRF
                .csrf().disable()
                // ????????????
                .exceptionHandling()
                .authenticationEntryPoint(pxdAuthenticationEntryPoint)
                .accessDeniedHandler(pxdAccessDeniedHandler)
                .and()
                // ??????iframe ????????????
                .headers()
                .frameOptions()
                .disable()
                // ???????????????
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // ??????????????????
                .antMatchers(
                        HttpMethod.GET,
                        "/*.html",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/webSocket/**"
                ).permitAll()
                // swagger ??????
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/*/api-docs").permitAll()
                .antMatchers("/v2/api-docs-ext").permitAll()
                .antMatchers(getAnonymousUrls().toArray(new String[0])).permitAll()
                // ???????????????????????????
                .anyRequest().authenticated()
                .and()
                .apply(securityConfigurerAdapter());
    }

    public Set<String> getAnonymousUrls() {
        Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = applicationContext.getBean(RequestMappingHandlerMapping.class).getHandlerMethods();
        Set<String> anonymousUrls = new HashSet<>();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> infoEntry : handlerMethodMap.entrySet()) {
            HandlerMethod handlerMethod = infoEntry.getValue();
            AnonymousAccess anonymousAccess = handlerMethod.getMethodAnnotation(AnonymousAccess.class);
            if (null != anonymousAccess) {
                anonymousUrls.addAll(infoEntry.getKey().getPatternsCondition().getPatterns());
            }
        }
        log.info("??????uris:{}", JSONUtil.toJsonStr(anonymousUrls));
        return anonymousUrls;
    }

    private TokenConfigurer securityConfigurerAdapter() {
        return new TokenConfigurer();
    }

}
