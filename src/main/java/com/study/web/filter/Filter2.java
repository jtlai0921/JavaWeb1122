package com.study.web.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/auth/*")
public class Filter2 extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("Hello Filter2 Begin");
        MyResponse myResponse = new MyResponse(res);
        chain.doFilter(req, myResponse);
        String html = myResponse.getHTMLString();
        html = html.replace("<body", "<body background=\"../images/watermark.jpg\"");
        res.getWriter().print(html);
        System.out.println("Hello Filter2 End");
    }
    
}
