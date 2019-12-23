package com.study.web.servlet;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/openweather")
public class OpenWeather extends HttpServlet{
    private String json = "";
    private String city = "taipei";
    @Override
    public void init() throws ServletException {
        System.out.println("init()...");
        try {
            String url = "https://openweathermap.org/data/2.5/weather?q=%s&appid=b6907d289e10d714a6e88b30761fae22";
            url = String.format(url, city);
            json = new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A").next();
        } catch (Exception e) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("doGet()...");
        JsonElement jelement = new JsonParser().parse(json);
        JsonObject  root = jelement.getAsJsonObject();
        JsonObject  jobject = root.getAsJsonObject("main");
        double temp = jobject.get("temp").getAsDouble();
        double pressure = jobject.get("pressure").getAsDouble();
        double humidity = jobject.get("humidity").getAsDouble();
        double temp_min = jobject.get("temp_min").getAsDouble();
        double temp_max = jobject.get("temp_max").getAsDouble();
        String data = String.format("%s 即時天氣狀況:<br>溫度: %.2f<br>濕度: %.2f<br>最高溫度: %.2f<br>最低溫度: %.2f<br>氣壓: %.1f<br>",
                          city, temp, humidity, temp_max, temp_min, pressure);
        resp.getWriter().println(data);
        
        String icon = root.getAsJsonArray("weather").get(0).getAsJsonObject().get("icon").getAsString();
        String icon_url = String.format("http://openweathermap.org/img/wn/%s@2x.png", icon);
        resp.getWriter().printf("<img src='%s'>", icon_url);
    }

    
}
