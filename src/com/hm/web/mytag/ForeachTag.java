package com.hm.web.mytag;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//控制标签下剩余的jsp是否执行
public class ForeachTag extends SimpleTagSupport {
	private String var;  //相当于变量，记住迭代的对象
	private Object items;	//这个可以使集合、数组
	private Collection collection;
	public void setVar(String var) {
		this.var = var;
	}
	public void setItems(Object items) {
		this.items = items;
		if(items instanceof Collection){   //如果是单列集合(list 、set)  直接赋值给collection
			collection=(Collection) items;
		}
		if(items instanceof Map){			//如果是map集合，将map集合转换成单列集合
			Map map=(Map) items;
			collection=map.entrySet();
		}
		/*if(items instanceof Object[]){		//如果是数组，将数组转成单列集合
			Object obj[]=(Object[]) items;
			collection=Arrays.asList(obj);
		}*/
		if(items.getClass().isArray()){      //无论是对象数组，还是基本类型的数组，还是String数组，都可以判断，都可以用java.lang.reflect的Array来做处理
			this.collection=new ArrayList();
			int length=Array.getLength(items);
			for(int i=0;i<length;i++){
				Object value=Array.get(items, i);
				this.collection.add(value);
			}
		}
	}
	
	//这个可以迭代任何集合
	@Override
	public void doTag() throws JspException, IOException {
		Iterator it=this.collection.iterator();
		while(it.hasNext()){
			Object value=it.next();
			this.getJspContext().setAttribute(var, value);
			this.getJspBody().invoke(null);
		}
	}
	
	/*	这个只能迭代List
	 * @Override
	public void doTag() throws JspException, IOException {
		
		List list=(List) items;
		Iterator it=list.iterator();//拿到迭代器
		while(it.hasNext()){
			Object value=it.next();
			this.getJspContext().setAttribute(var, value);  //迭代一次，存一次，输出一次
			this.getJspBody().invoke(null);
		}
	}*/
	
}
