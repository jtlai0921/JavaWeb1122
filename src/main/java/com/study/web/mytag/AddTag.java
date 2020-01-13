
package com.study.web.mytag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AddTag extends SimpleTagSupport implements DynamicAttributes {
    
    List<Integer> list = new ArrayList<>();

    @Override
    public void doTag() throws JspException, IOException {
        int sum = list.stream().mapToInt(value -> value).sum();
        this.getJspContext().getOut().print("sum: " + sum);
    }
    
    @Override
    public void setDynamicAttribute(String uri, String key, Object value) throws JspException {
        list.add(Integer.parseInt(value + ""));
    }
    
}
