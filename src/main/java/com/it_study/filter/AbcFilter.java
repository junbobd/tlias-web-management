package com.it_study.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//filter执行顺序按类名排序
//@WebFilter(urlPatterns = "/*")
public class AbcFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Abc拦截到了请求 放行前逻辑");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("Abc拦截到了请求 放行后逻辑");
    }
}
