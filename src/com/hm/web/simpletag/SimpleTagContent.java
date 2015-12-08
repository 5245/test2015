package com.hm.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//控制标签体是否执行   这里没有doStartTag()、doEndTag  所有都在doTag()里完成
public class SimpleTagContent extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment  jf=this.getJspBody();
		jf.invoke(this.getJspContext().getOut());  //如果去掉这行，就不输出了
	}
	
}
