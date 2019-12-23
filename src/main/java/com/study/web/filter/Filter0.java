package com.study.web.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/auth/*")
public class Filter0 extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("Hello Filter0 Begin");
        String email = req.getParameter("email");
        if(email != null && email.contains("yahoo.com.tw")) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect("../forms/auth_login.html");
        }
        System.out.println("Hello Filter0 End");
    }
    
}
