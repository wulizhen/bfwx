package com.bf.comm;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import com.jfinal.kit.PropKit;


/**
 * 初始化servlet
 * 
 * @author laoyao
 * @date 2013-05-02
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		//设置通过TLSV1证书。
		System.setProperty("https.protocols", "TLSv1");
		// 获取web.xml中配置的参数
		TokenThread.appid = PropKit.get("appid");
		TokenThread.appsecret = PropKit.get("appsecret");

		System.out.println("weixin api appid:{}"+TokenThread.appid);
		System.out.println("weixin api appsecret:{}"+ TokenThread.appsecret);

		// 未配置appid、appsecret时给出提示
		if ("".equals(TokenThread.appid) || "".equals(TokenThread.appsecret)) {
			System.out.println("appid and appsecret configuration error, please check carefully.");
		} else {
			// 启动定时获取access_token的线程
			new Thread(new TokenThread()).start();
		}
	}
}