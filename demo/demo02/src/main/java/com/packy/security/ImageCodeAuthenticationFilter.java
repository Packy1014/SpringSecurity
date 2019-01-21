package com.packy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ImageCodeAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    AuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (httpServletRequest.getRequestURI().contains("/securityLogin")) {
            try {
                String imageCode = httpServletRequest.getParameter("imageCode");
                String key = (String) httpServletRequest.getSession().getAttribute("key");
                if (StringUtils.isEmpty(imageCode)) {
                    throw new ImageCodeException("Code cannot be null");
                }
                if (!imageCode.trim().equals(key)) {
                    throw new ImageCodeException("Code cannot match");
                }
            } catch (AuthenticationException e) {
                authenticationFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
                return;
            }

        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

}
