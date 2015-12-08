package com.hm.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//控制标签下剩余的jsp是否执行
public class SimpleTagJsp extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		throw new SkipPageException();
	}
	
}
