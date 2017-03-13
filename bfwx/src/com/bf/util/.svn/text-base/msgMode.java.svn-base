package com.bf.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

public class msgMode {
	/**
	 * 手机短信发送模块
	 * @author 成祺
	 * 2016-05-25
	 * @param telphone接收人手机号码
	 * @param content短信内容（切记以【内容】开头）
	 * @throws Exception 
	 */
	public Map send(String telphone,String content) throws Exception{
		httpConnect http = new httpConnect();
		//userid:企业ID	account:发送用户账号	password:账号密码	mobile:被叫号码（多个号码,隔开）
		//content:发送内容 sendTime:定时发送时间	action:发送任务命令
		//接收回传xml字符串
		String re = http.sendPost("http://116.255.238.170:7518/smsGBK.aspx", "userid=104&account=cs05&password=12345678&mobile="+telphone+"&content="+content+"&sendTime=&action=send&extno=");
//		System.out.println("返回结果："+re);
		System.out.println(content+"=======");
		
		//解析XML字符串
//		try {
			Document document = new SAXBuilder().build(new InputSource(new StringReader(re)));
			//获取根节点
			Element root = document.getRootElement();
			//解析结果
			List<Element> childrenList =  root.getChildren();
//			for (Element e : childrenList) {
				Map elementMap = new HashMap<String, String>();
				elementMap.put("returnstatus", childrenList.get(0).getValue()); // 发送情况
				elementMap.put("message",  childrenList.get(1).getValue()); // 返回信息
				elementMap.put("remainpoint",  childrenList.get(2).getValue()); // 短信余额
				elementMap.put("taskID",  childrenList.get(3).getValue()); // 本次taskID
				elementMap.put("successCounts",  childrenList.get(4).getValue()); // 成功条数
//			}
			
			return elementMap;
		
		
    }   
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Map map = new msgMode().send("15260005794", " 【0936数据测试】接口测试，请忽略！");
		System.out.println("发送情况:"+map.get("returnstatus")+"\n返回信息:"+map.get("message")+"\n短信余额:"+map.get("remainpoint")+"\n本次taskID:"+map.get("taskID")+"\n成功条数:"+map.get("successCounts"));
	}
	
}
