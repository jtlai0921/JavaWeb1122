package com.study.web.filter;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper  {
    private Map<String, String> params = new HashMap<>();

    public MyRequest(HttpServletRequest request) {
        super(request);
    }
    
    public String getParameter(String name) {
        String value = params.get(name);
        if(value == null) {
            value = super.getParameter(name);
        }
        return value;
    }
    public void setParameter(String name, String value) {
        params.put(name, value);
    }

    
}
