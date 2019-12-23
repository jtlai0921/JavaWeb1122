package com.study.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet/header")
public class HeaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        
        out.println(req.getHeader("accept-language").contains("CN"));
        
        Collections.list(req.getHeaderNames())
                   .forEach(name -> out.println(name + " : " + req.getHeader(name)));
        
    }
    
}
