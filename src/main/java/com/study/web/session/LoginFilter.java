package com.study.web.session;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/session/*")
public class LoginFilter extends HttpFilter {

    private static Map<String, String> users;

    static {
        users = new LinkedHashMap<>();
        users.put("admin", "1234");
        users.put("mary", "1111");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("LoginFilter");
        HttpSession session = req.getSession();
        boolean pass = false;

        if (session.getAttribute("username") == null) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String remember = req.getParameter("remember");
            
            pass = check(username, password); // 登入驗證
            if (pass) { // 登入是否成功
                session.setAttribute("username", username); // 寫入 session 資料
                // Cookie 的加入
                Cookie cookie_username, cookie_password, cookie_remember;
                if (remember != null) { // 使用者有選擇 remember
                    cookie_username = new Cookie("username", username);
                    cookie_password = new Cookie("password", password);
                    cookie_remember = new Cookie("remember", "checked");
                    cookie_username.setMaxAge(7 * 24 * 60 * 60); // 一星期
                    cookie_password.setMaxAge(7 * 24 * 60 * 60); // 一星期
                    cookie_remember.setMaxAge(7 * 24 * 60 * 60); // 一星期
                } else {
                    cookie_username = new Cookie("username", "");
                    cookie_password = new Cookie("password", "");
                    cookie_remember = new Cookie("remember", "");
                }
                resp.addCookie(cookie_username);
                resp.addCookie(cookie_password);
                resp.addCookie(cookie_remember);
            }
        } else {
            // 此人已登入
            pass = true;
        }

        if (pass) {
            chain.doFilter(req, resp); // 重導到下一頁
        } else {
            session.invalidate(); // session 失效
            req.setAttribute("message", "登入錯誤或請重新登入");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/session/login.jsp");
            rd.forward(req, resp);
        }

    }

    private boolean check(String username, String password) {
        return users.get(username) != null && users.get(username).equals(password);
    }

}
