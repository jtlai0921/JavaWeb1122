package com.study.web.servlet.dispatcher;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/dispatcher/vote")
public class VoteServlet extends HttpServlet {
    static int sum1, sum2, sum3;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("amount1") != null) {
            sum1 += Integer.parseInt(req.getParameter("amount1"));
            sum1 = sum1 < 0 ? 0 : sum1;
        }
        if(req.getParameter("amount2") != null) {
            sum2 += Integer.parseInt(req.getParameter("amount2"));
            sum2 = sum2 < 0 ? 0 : sum2;
        }
        if(req.getParameter("amount3") != null) {
            sum3 += Integer.parseInt(req.getParameter("amount3"));
            sum3 = sum3 < 0 ? 0 : sum3;
        }
        System.out.printf("%d\n%d\n%d", sum1, sum2, sum3);
        
        req.setAttribute("sum1", sum1);
        req.setAttribute("sum2", sum2);
        req.setAttribute("sum3", sum3);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/vote.jsp");
        rd.forward(req, resp);
    }
    
}
