package com.study.web.servlet.dispatcher;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/dispatcher/a")
public class AServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String money = req.getParameter("money"); // ?money=100
        
        req.setAttribute("money", money);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/servlet/dispatcher/b");
        rd.forward(req, resp);
        
    }
    
}
