package com.study.web.servlet;

// 通用型

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LottoServlet extends GenericServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 顯示一組 Lotto 號碼
        Set<Integer> lottos = new HashSet<>();
        while(lottos.size() < 6) {
            int number = new Random().nextInt(49) + 1;
            lottos.add(number);
        }
        res.getWriter().println(lottos);
    }
    
}
