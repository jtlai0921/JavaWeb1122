package com.study.web.mytag;

import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class FibTag implements Tag {

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
            JspWriter out = pageContext.getOut();
            long result = 0;
            if (num == 0 || num == 1) {
                result = num;
            } else {
                result = Stream.iterate(new long[]{1, 1}, f -> new long[]{f[1], f[0] + f[1]})
                        .limit(num)
                        .reduce((a, b) -> b)
                        .get()[0];
            }
            out.print(num + " : " + result);
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