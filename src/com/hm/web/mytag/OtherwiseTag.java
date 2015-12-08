package com.hm.web.mytag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//控制标签下剩余的jsp是否执行
public class OtherwiseTag extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		ChooseTag parent=(ChooseTag) this.getParent();
		if( !parent.isDo()){
			this.getJspBody().invoke(null);
			parent.setDo(true);
		}
	}
	
}
