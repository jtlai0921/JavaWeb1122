package com.study.web.mvc.controller;

import com.study.web.mvc.model.Prime;
import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mvc/prime/*")
public class PrimeServlet extends HttpServlet {

    private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mvc/view/prime.jsp");
        Prime prime = new Prime();
        switch(path) {
            case "/input":
                // 重導至空的 prime.jsp
                rd.forward(req, resp);
                break;
            case "/calc":
                // 計算 prime
                int n = Integer.parseInt(req.getParameter("number"));
                boolean result = prime.getResult(n);
                Map<Integer, Boolean> results = prime.getResults();
                // setAttribute
                req.setAttribute("n", n);
                req.setAttribute("result", result);
                req.setAttribute("results", results);
                // 重導至 prime.jsp
                rd.forward(req, resp);
                break; 
            case "/del":
                // 刪除
                int num = Integer.parseInt(req.getParameter("number"));
                prime.del(num);
                // setAttribute
                req.setAttribute("results", prime.getResults());
                // 重導至 prime.jsp
                rd.forward(req, resp);
                break;
            default:
                resp.getWriter().println("fail path !");
        }
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }
    
}
