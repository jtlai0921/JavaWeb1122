package com.study.web.servlet.dispatcher;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/dispatcher/checkid")
public class CheckIDServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        
        req.setAttribute("id", id);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/servlet/dispatcher/verifyid");
        rd.include(req, resp);
        
        String result = req.getAttribute("result").toString();
        resp.getWriter().print(result);
        
    }

}
