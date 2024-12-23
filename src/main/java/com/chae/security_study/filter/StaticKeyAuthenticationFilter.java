package com.chae.security_study.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.io.IOException;
import java.util.logging.Logger;

@Component // 속상 파일에서 값을 주입할 수 있ㄷ로고 스프링 컨텍스트에 추가
public class StaticKeyAuthenticationFilter implements Filter {

    @Value("${authorization.key}")
    private String authorizationKey;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //필터 논리 작성

        var httpRequest = (HttpServletRequest) request;
        var httpResponse = (HttpServletResponse) response;

        String authentication = httpRequest.getHeader("Authorization");

        if(authorizationKey.equals(authentication)){
            chain.doFilter(request, response);
        } else {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
