package com.study.web.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/auth/*")
public class Filter1 extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("Hello Filter1 Begin");
        MyRequest myRequest = new MyRequest(req);
        String email = req.getParameter("email");
        if(email != null) {
            myRequest.setParameter("email", email.substring(0, email.indexOf("@")));
        }

        chain.doFilter(myRequest, res);
        System.out.println("Hello Filter1 End");
    }
    
}
