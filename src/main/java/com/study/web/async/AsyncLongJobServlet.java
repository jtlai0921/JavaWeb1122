package com.study.web.async;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/job/async_long", asyncSupported = true) // <-- 注意設定
public class AsyncLongJobServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("1. 開始 Servlet 進入 " + new Date() + " <br>");
        out.flush();

        // 商業邏輯(長長長長...工作) !
        AsyncContext ctx = req.startAsync(); // 重要
        new Thread(new LongJob(ctx)).start();
        
        out.print("3. 自 Servlet 離開 " + new Date() + " <br>");
        out.flush();

    }

    class LongJob implements Runnable {

        private AsyncContext ctx = null;

        public LongJob(AsyncContext ctx) {
            this.ctx = ctx;
        }

        public void run() {
            try {
                PrintWriter out = ctx.getResponse().getWriter();
                // 等待10秒鐘，用來模擬任務所需要的時間
                out.println("2.任務處理開始的時間：" + new Date() + ".<p>");
                Thread.sleep(10000);
                out.println("2.任務處理完畢的時間：" + new Date() + ".<p>");
                out.flush();
                // 任務完成
                ctx.complete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
