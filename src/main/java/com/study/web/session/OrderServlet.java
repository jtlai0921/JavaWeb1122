package com.study.web.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/order")
public class OrderServlet extends HttpServlet {

    private static int instock = 100;

    protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        LinkedHashMap<Date, Integer> carts;
        
        synchronized(session) {
            if (session.getAttribute("carts") == null) {
                carts = new LinkedHashMap<>();
                session.setAttribute("carts", carts);
            }
            carts = (LinkedHashMap<Date, Integer>) session.getAttribute("carts");
        }
        
        int amount = 0;
        String message = "";
        synchronized (OrderServlet.class) {
            try {
                amount = Integer.parseInt(req.getParameter("amount"));
                if (instock >= amount) {
                    instock -= amount;
                    TimeUnit.MICROSECONDS.sleep(100);
                    carts.put(new Date(), amount);
                } else {
                    message = "庫存不足";
                }
            } catch (Exception e) {
                message = "請輸入數字";
            }
        }

        req.setAttribute("instock", instock);
        req.setAttribute("amount", amount);
        req.setAttribute("message", message);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/session/order.jsp");
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

}
