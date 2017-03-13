package com.bf.comm.config;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * BlogInterceptor
 * 此拦截器仅做为示例展示，在本 demo 中并不需要
 */
public class LoginInterceptor implements Interceptor {
	
	public void intercept(Invocation inv) {
		System.out.println("Before invoking " + inv.getActionKey());
		//String u=inv.getController().getSessionAttr("u").toString();
		
		if(inv.getController().getSessionAttr("username")!=null
			&&!inv.getController().getSessionAttr("username").toString().equals("")){
			inv.invoke();
		}else{  
		
			inv.getController().render("../index.jsp");
		}
	}
}
