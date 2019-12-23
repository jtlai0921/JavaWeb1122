package com.study.web.servlet;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n = Integer.parseInt(req.getParameter("n"));
        if(n == 0) {
            resp.sendRedirect("../index.html");
            // 下列程式碼同等於 sendRedirect() 方法
            //resp.setStatus(302);
            //resp.setHeader("Location", "../index.html");
        } else {
            resp.sendError(500, "錯誤訊息...");
        }
        
    }
    
}
