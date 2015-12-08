package com.hm.web.mytag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ChooseTag extends SimpleTagSupport {
	private boolean isDo;   //这个is开头的属性的setter和getter 方法是去掉is的（特殊）

	public boolean isDo() {
		return isDo;
	}

	public void setDo(boolean isDo) {
		this.isDo = isDo;
	}

	@Override
	public void doTag() throws JspException, IOException {
		this.getJspBody().invoke(null);
	}
}
