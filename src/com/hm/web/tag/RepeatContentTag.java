package com.hm.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
//控制标签体循环输出
public class RepeatContentTag extends TagSupport {
	private String num="";
	int x=5;
	@Override
	public int doStartTag() throws JspException {
		if(null!=this.getNum()){
			x=Integer.parseInt(this.getNum());
		}
		return Tag.EVAL_BODY_INCLUDE;     // 标签体执行
		
	}

	@Override
	public int doAfterBody() throws JspException {
		x--;
		if(x>0){
			return IterationTag.EVAL_BODY_AGAIN;  //如果大于0，继续执行
		}else{
			return IterationTag.SKIP_BODY;		//如果小于0，就不执行了。
		}
	}

	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}
	/**  
	 * 返回String类型数据。<br>
	 * 当前返回的该数据的参数名是 num
	 *  
	 * @return  String类型 
	 * @since   v1.0  
	 */
	
	public String getNum() {
		return num;
	}

	/**  
	 * 传入类型为String的参数。<br>
	 * 当前接收传入参数值得参数名为:num
	 * @param num 
	 *      将类型为String且传入参数名为num的值保存 
	 */
	public void setNum(String num) {
		this.num = num;
	}
}
