package com.it_study.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {


    @Override //初始化的方法，只调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
        System.out.println("init 初始化方法执行了");
    }

    @Override //拦截请求之后都会调用，调用多次
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Demo拦截到了请求 放行前逻辑");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Demo拦截到了请求 放行后逻辑");
    }

    @Override //销毁方法，只调用一次
    public void destroy() {
//        Filter.super.destroy();
        System.out.println("destory 销毁方法执行了");
    }
}
