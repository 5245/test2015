package com.hm.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class ShowContentTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		//检查是否有权限查看内容
		
		//return Tag.EVAL_BODY_INCLUDE;  //根据返回值判断标签体是否执行输出
		return Tag.SKIP_BODY;     //不输出
	}
	
}
