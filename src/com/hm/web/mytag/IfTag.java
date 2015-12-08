package com.hm.web.mytag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//控制标签下剩余的jsp是否执行
public class IfTag extends SimpleTagSupport {
	private boolean test;
	public void setTest(boolean test) {
		this.test = test;
	}
	@Override
	public void doTag() throws JspException, IOException {
		
		if(test){
			this.getJspBody().invoke(null);
		}
		
	}
	
}
