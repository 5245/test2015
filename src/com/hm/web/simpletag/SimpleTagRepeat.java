package com.hm.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//控制标签体是否执行   这里没有doStartTag()、doEndTag  所有都在doTag()里完成
public class SimpleTagRepeat extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment  jf=this.getJspBody();
		for(int i=0;i<5;i++){
			jf.invoke(this.getJspContext().getOut());  //等价于jf.invoke(null);如果去掉这行，就不输出了
		}
	}
	
}
