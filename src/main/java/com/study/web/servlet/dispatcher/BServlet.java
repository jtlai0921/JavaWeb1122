package com.study.web.servlet.dispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/dispatcher/b")
public class BServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String money = req.getAttribute("money") + "";
        int result = 0;
        try {
            result = Integer.parseInt(money) * 30;
        } catch (Exception e) {
        }
        resp.getWriter().print("BServlet: " + result);
    }
    
}
