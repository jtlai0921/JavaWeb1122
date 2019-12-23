package com.study.web.mvc.controller;

import com.study.web.mvc.model.Add;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc/add")
public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String x = req.getParameter("x");
        String y = req.getParameter("y");
        Add add = new Add();
        int result = add.calc(Integer.parseInt(x), Integer.parseInt(y));
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mvc/view/add.jsp");
        req.setAttribute("x", x);
        req.setAttribute("y", y);
        req.setAttribute("result", result);
        rd.forward(req, resp);
        
        
    }
    
}
