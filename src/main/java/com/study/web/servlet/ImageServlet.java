package com.study.web.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/image")
public class ImageServlet extends HttpServlet {

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
        // 寫入資料
        Files.copy(file.toPath(), resp.getOutputStream());
        
    }
    
}
