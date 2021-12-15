package com.pxd.gateway.filter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 权限过滤器
 *
 * @author 皮蛋 javazhouqi@163.com
 * @since 1.0.0
 */
@Configuration
@ConfigurationProperties(prefix = "pxd")
public class AuthFilter implements GlobalFilter {
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();
    /**
     * 不拦截的urls
     */
    private List<String> urls;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String requestUri = request.getPath().pathWithinApplication().value();
        //请求放行，无需验证权限
        if (pathMatcher(requestUri)) {
            return chain.filter(exchange);
        }
//        //获取用户token
//        String token = request.getHeaders().getFirst(Constant.TOKEN_HEADER);
//        if (StringUtils.isBlank(token)) {
//            token = request.getQueryParams().getFirst(Constant.TOKEN_HEADER);
//        }
//        //获取用户信息
//        UserDetail userDetail = result.getData();
//        if(userDetail != null){
//            //当前登录用户userId，添加到header中
//            ServerHttpRequest build = exchange.getRequest().mutate().header(Constant.USER_KEY, new String[] { userDetail.getId()+"" }).build();
//            return chain.filter(exchange.mutate().request(build).build());
//        }
        return chain.filter(exchange);
    }

    private Mono<Void> response(ServerWebExchange exchange, Object object) {
        String json = "";
        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(json.getBytes(StandardCharsets.UTF_8));
        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
        exchange.getResponse().setStatusCode(HttpStatus.OK);
        return exchange.getResponse().writeWith(Flux.just(buffer));
    }

    private boolean pathMatcher(String requestUri) {
        for (String url : urls) {
            if (antPathMatcher.match(url, requestUri)) {
                return true;
            }
        }
        return false;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}