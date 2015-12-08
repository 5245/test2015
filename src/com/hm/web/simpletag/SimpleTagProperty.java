package com.hm.web.simpletag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//控制标签体是否执行   这里没有doStartTag()、doEndTag  所有都在doTag()里完成
public class SimpleTagProperty extends SimpleTagSupport {
	private int count;
	private Date date;

	public void setDate(Date date) {
		this.date = date;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment  jf=this.getJspBody();
		this.getJspContext().getOut().write(date.toLocaleString()+"<br/>");
		for(int i=0;i<count;i++){
			jf.invoke(this.getJspContext().getOut());  //等价于jf.invoke(null);如果去掉这行，就不输出了
		}
	}
	
}
