package com.study.web.servlet.dispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/dispatcher/verifyid")
public class VerifyIDServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 然後再把每一個數字依序乘上1、9、8、7、6、5、4、3、2、1、1，最後再相加
        int[] dx = {1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1};
        
        String id = req.getAttribute("id").toString();
        int[] array = new int[11]; //{1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        switch(id.charAt(0)) {
            case 'A':
                array[0] = 1;array[1] = 0;break;
            case 'T':
                array[0] = 2;array[1] = 7;break;
        }
        
        for(int i=2;i<array.length;i++) {
            array[i] = id.charAt(i-1) - 48;
        }
        
        
        int sum = 0;
        for(int i=0;i<array.length;i++) {
            sum += array[i] * dx[i];
        }
        
        req.setAttribute("result", sum % 10 == 0 ? true : false);
    }

}
