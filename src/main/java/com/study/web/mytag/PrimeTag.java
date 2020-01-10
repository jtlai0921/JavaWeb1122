package com.study.web.mytag;

import java.io.PrintWriter;
import java.util.stream.IntStream;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class PrimeTag implements Tag {
    private PageContext pageContext;
    private Tag parentTag;
    private int num;
    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        parentTag = tag;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    public Tag getParentTag() {
        return parentTag;
    }

    public void setParentTag(Tag parentTag) {
        this.parentTag = parentTag;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    @Override
    public int doStartTag() throws JspException {
        try {
            PrintWriter out = pageContext.getResponse().getWriter();
            boolean check = IntStream.rangeClosed(2, num/2).noneMatch(i -> num % i == 0);
            out.print(num + " : " + check);
        } catch (Exception e) {
        }
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
        
    }
    
}