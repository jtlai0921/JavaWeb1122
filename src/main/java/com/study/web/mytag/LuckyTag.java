package com.study.web.mytag;

import java.io.PrintWriter;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class LuckyTag implements Tag {

    private PageContext pageContext;
    private Tag parentTag;
    private int n;

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

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    

    @Override
    public int doStartTag() throws JspException {
        return new Random().nextInt(2) == n ? Tag.EVAL_BODY_INCLUDE : Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {

    }

}