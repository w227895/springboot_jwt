package com.kebo.springboot_jwt.filter;


import com.kebo.springboot_jwt.config.JwtHelper;
import io.jsonwebtoken.Claims;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-12-23 20:18
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request =(HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String token = request.getHeader("authorization"); //获取请求传来的token
        Claims claims = JwtHelper.verifyJwt(token); //验证token
        if (claims == null) {
            response.getWriter().write("token is invalid");
        }else {
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
