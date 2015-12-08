package com.hm.web.simpletag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//控制标签体是否执行   这里没有doStartTag()、doEndTag  所有都在doTag()里完成
public class SimpleTagAlter extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment  jf=this.getJspBody();
		StringWriter sw=new StringWriter();
		jf.invoke(sw);  //如果去掉这行，就不输出了
		
		String content=sw.toString();
		content=content.toUpperCase();
		
		this.getJspContext().getOut().write(content);
	}
	
}
