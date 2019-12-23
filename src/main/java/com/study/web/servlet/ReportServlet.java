package com.study.web.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/report")
public class ReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ReportServlet");
        req.setAttribute("email", req.getParameter("email"));
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/report.jsp");
        rd.forward(req, resp);
        
    }
    
}
