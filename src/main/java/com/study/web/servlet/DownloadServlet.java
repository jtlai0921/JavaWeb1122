package com.study.web.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        System.out.println("doHead()..");
        resp.addHeader("message", "I love U");
        doGet(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fn = req.getParameter("fn");
        // 檔案位置
        File file = new File("C:/temp/" + fn);
        // 取得檔案 mimeType
        String mimeType = Files.probeContentType(file.toPath());
        // 設定 ContentType
        resp.setContentType(mimeType);
        // 設定檔案大小
        resp.setContentLength((int)file.length());
        
        // 設定下載檔案標頭資料
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
        resp.setHeader(headerKey, headerValue);
         
        // 寫入資料
        Files.copy(file.toPath(), resp.getOutputStream());
        
    }
    
}
