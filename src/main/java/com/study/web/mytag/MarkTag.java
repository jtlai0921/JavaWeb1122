package com.study.web.mytag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;

public class MarkTag implements BodyTag {
    private BodyContent bodyContent;
    private PageContext pageContext;
    private Tag parentTag;
    private String key;
    
    @Override
    public void setBodyContent(BodyContent bc) {
        this.bodyContent = bc;
    }

    @Override
    public void setPageContext(PageContext pc) {
        this.pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        this.parentTag = tag;
    }

    @Override
    public Tag getParent() {
        return this.parentTag;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    @Override
    public int doStartTag() throws JspException {
        return BodyTag.EVAL_BODY_BUFFERED;
    }

    @Override
    public void doInitBody() throws JspException {
        
    }

    @Override
    public int doAfterBody() throws JspException {
        JspWriter out = bodyContent.getEnclosingWriter();
        String text = bodyContent.getString();
        text = text.replaceAll(key, "<font color=red>" + key + "</font>");
        try {
            out.print(text);
        } catch (Exception e) {
        }
        return BodyTag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
        
    }

}