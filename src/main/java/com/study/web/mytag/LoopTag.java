package com.study.web.mytag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

public class LoopTag implements IterationTag {
    private PageContext pageContext;
    private Tag parentTag;
    private int count;
    
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    @Override
    public int doStartTag() throws JspException {
        return  (count > 0) ? Tag.EVAL_BODY_INCLUDE : Tag.SKIP_BODY;
    }

    @Override
    public int doAfterBody() throws JspException {
        --count;
        return  (count > 0) ? IterationTag.EVAL_BODY_AGAIN : Tag.SKIP_BODY;
    }
    
    @Override
    public int doEndTag() throws JspException {
        return (count < 0) ? Tag.SKIP_PAGE : Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
        
    }
    
}