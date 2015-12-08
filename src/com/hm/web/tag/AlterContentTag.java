package com.hm.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

//控制标签体循环输出
public class AlterContentTag extends BodyTagSupport {
	
	@Override
	public int doStartTag() throws JspException {
		return BodyTag.EVAL_BODY_BUFFERED;
	}
	
	@Override
	public int doEndTag() throws JspException {
		BodyContent bc=this.getBodyContent();   //得到标签体
		String content=bc.getString();
		content=content.toUpperCase();
		try {
			this.pageContext.getOut().write(content);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return Tag.EVAL_PAGE;
		
	}

	
	
	
}
