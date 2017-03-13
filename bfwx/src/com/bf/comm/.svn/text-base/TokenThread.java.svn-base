package com.bf.comm;

import net.sf.json.JSONObject;

import com.jfinal.kit.PropKit;
import com.jfinal.log.Log;
import com.bf.entity.Token;
import com.bf.util.abc;

/**
 * 定时获取微信access_token的线程
 * 
 * @author liuyq
 * @date 2013-05-02
 */
public class TokenThread implements Runnable {
	private static final Log log = Log.getLog(TokenThread.class);// 日志文件
	
	// 第三方用户唯一凭证
	public static String appid="";
	// 第三方用户唯一凭证密钥
	public static String appsecret ="";
	public static Token token = null;
	public static String  jsapi_ticket="";
	public void run() {
		while (true) {
			try {
				token =abc.getToken(appid, appsecret);
				if (null != token) {
					//log.info("测试获取access_token成功，有效时长{}秒 token:{}", token.getExpiresIn(), token.getAccessToken());
					String requestUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";	
					requestUrl = requestUrl.replace("ACCESS_TOKEN", token.getAccessToken());
					JSONObject jsonTicket =abc.httpsRequest(requestUrl, "POST",null);
					jsapi_ticket=jsonTicket.getString("ticket");
					log.info("测试获取jsapi_ticket成功="+jsapi_ticket);
					log.info("测试获取access_token成功，有效时长{}秒 token:{}"+ token.getExpiresIn()+ token.getAccessToken());
					
				    // 开始
					System.out.println("===开始===");
					abc.httpRequest("http://localhost:80/bfwx/"+PropKit.get("kkurl"), "POST",null);
					System.out.println("===完成===");
					// 休眠7000秒
					Thread.sleep((token.getExpiresIn() - 200) * 1000);
				} else {
					// 如果access_token为null，60秒后再获取
					Thread.sleep(60 * 1000);
				}
			} catch (InterruptedException e) {
				try {
					Thread.sleep(60 * 1000);
				} catch (InterruptedException e1) {
					System.out.println("{}"+ e1);
				}
				System.out.println("{}"+ e);
			}
		}
	}
}
