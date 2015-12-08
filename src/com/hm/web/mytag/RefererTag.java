package com.hm.web.mytag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//控制标签下剩余的jsp是否执行
public class RefererTag extends SimpleTagSupport {
	private String site;
	private String page;

	public void setSite(String site) {
		this.site = site;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Override
	public void doTag() throws JspException, IOException {
		//1.得到来访者的referer
		PageContext pageContext=(PageContext) this.getJspContext();
		HttpServletRequest request=(HttpServletRequest) pageContext.getRequest();
		HttpServletResponse response=(HttpServletResponse) pageContext.getResponse();
		
		String referer=request.getHeader("referer");
		//2.判断来访者的页面是不是要防盗链的网站
		if(referer==null || !referer.startsWith(site)){
			if(page.startsWith(request.getContextPath())){
				response.sendRedirect(page);
			}else if(page.startsWith("/")){
				response.sendRedirect(request.getContextPath()+page);
			}else{
				response.sendRedirect(request.getContextPath()+"/"+page);
			}
			throw new SkipPageException();    //如果是盗链者，剩下的jsp页面都不执行
		}else{
			//如果不是盗链者，什么都不做 ,直接执行
		}
		
		
		
	}
	
}
