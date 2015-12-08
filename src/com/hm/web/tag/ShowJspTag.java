package com.hm.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class ShowJspTag extends TagSupport {
/*
	@Override
	public int doStartTag() throws JspException {
		//检查是否有权限查看内容
		
		return Tag.SKIP_BODY;     //不输出
	}*/

	@Override
	public int doEndTag() throws JspException {
		
		return  Tag.SKIP_PAGE;    //标签后的内容都不执行
	}
	
}
