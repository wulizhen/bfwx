package com.bf.util;

import java.security.SecureRandom;
import java.text.DateFormat;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;

import com.bf.entity.MyX509TrustManager;
import com.bf.entity.Token;
import com.bf.entity.WeixinOauth2Token;
import com.bf.entity.WeixinUserInfo;
import com.bf.comm.TokenThread;
import com.thoughtworks.xstream.core.util.Base64Encoder;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Random;

public class abc {

	// 凭证获取（GET）
	public final static String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	public static String getRandomFileName() {
		return getTimestamp() + generateRandCode(3);
	}

	/**
	 * 得到当前时间�?
	 * 
	 * @return
	 */
	public static String getTimestamp() {
		// 17位的时间
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return df.format(new Date());
	}

	public static String getGUIDKey() {
		String str = UUID.randomUUID().toString();
		return str.substring(0, 8) + str.substring(9, 13)
				+ str.substring(14, 18) + str.substring(19, 23)
				+ str.substring(24, 36);
	}

	/**
	 * 得到当前时间�?
	 * 
	 * @return
	 */
	public static String getTimesmmss() {
		// 17位的时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date());
	}
	
	
	/**
	 * 得到当前时间�?
	 * 
	 * @return
	 */
	public static String getday() {
		// 17位的时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}


	/**
	 * 发送https请求
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式（GET、POST）
	 * @param outputStr
	 *            提交的数据
	 * @return 返回微信服务器响应的信息
	 */
	public static String httpsRequest2(String requestUrl, String requestMethod,
			String outputStr) {
		System.setProperty("https.protocols", "TLSv1");
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(requestMethod);
			conn.setRequestProperty("content-type",
					"application/x-www-form-urlencoded");
			// 当outputStr不为null时向输出流写数据
			if (null != outputStr) {
				OutputStream outputStream = conn.getOutputStream();
				// 注意编码格式
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
			// 从输入流读取返回内容
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			return buffer.toString();
		} catch (ConnectException ce) {
			// log.error("连接超时：{}", ce);
		} catch (Exception e) {
			// log.error("https请求异常：{}", e);
		}
		return null;
	}

	/**
	 * 发送https请求
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式（GET、POST）
	 * @param outputStr
	 *            提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpsRequest(String requestUrl,
			String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		// 设置通过TLSV1证书。
		System.setProperty("https.protocols", "TLSv1");
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");// SSL
																				// //TLSv1
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
	
			// System.setProperty("https.protocols", "TLSv1");
			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(requestMethod);

			// 当outputStr不为null时向输出流写数据
			if (null != outputStr) {
				OutputStream outputStream = conn.getOutputStream();
				// 注意编码格式
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 从输入流读取返回内容
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			// log.error("连接超时：{}", ce);
		} catch (Exception e) {
			// log.error("https请求异常：{}", e);
		}
		return jsonObject;
	}

	/**
	 * 生成指定位数的随机数
	 * 
	 * @param codeLen
	 *            (位数)
	 * @return
	 */
	public static String generateRandCode(int codeLen) {
		int count = 0;
		char str[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		StringBuffer randCode = new StringBuffer();
		Random random = new Random();
		while (count < codeLen) {
			int i = Math.abs(random.nextInt(10));
			if ((i >= 0) && (i < str.length)) {
				randCode.append(str[i]);
				count++;
			}
		}
		return randCode.toString();
	}

	/**
	 * 获取ip 地址
	 * 
	 * @param str
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			// ip = request.getRemoteAddr();
			ip = request.getRemoteAddr();
			if (ip.equals("127.0.0.1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ip = inet.getHostAddress();
			}
		}

		if (ip != null && ip.length() > 15) { // "***.***.***.***".length() = 15
			if (ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
			}
		}
		return ip;
	}

	/**
	 * URL编码（utf-8）
	 * 
	 * @param source
	 * @return
	 */
	public static String urlEncodeUTF8(String source) {
		String result = source;
		try {
			result = java.net.URLEncoder.encode(source, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 创建永久带参二维码
	 * 
	 * @param accessToken
	 *            接口访问凭证
	 * @param sceneId
	 *            场景ID
	 * @return ticket
	 */
	public static String createPermanentQRCode(String accessToken, String id) {
		String ticket = null;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		// 需要提交的json数据
		String jsonMsg = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \""
				+ id + "\"}}}";
		// 创建永久带参二维码
		JSONObject jsonObject = httpsRequest(requestUrl, "POST", jsonMsg);

		if (null != jsonObject) {
			try {
				ticket = jsonObject.getString("ticket");
				System.out.println("创建永久带参二维码成功 ticket:{}" + ticket);
			} catch (Exception e) {
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				System.out.println("创建永久带参二维码失败 errcode:{} errmsg:{}"
						+ errorCode + errorMsg);
			}
		}
		return ticket;
	}

	/**
	 * 根据ticket换取二维码
	 * 
	 * @param ticket
	 *            二维码ticket
	 * @param savePath
	 *            保存路径
	 */
	public static String getQRCode(String ticket, String savePath, String name) {
		String filePath = null;
		// 拼接请求地址
		String requestUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
		requestUrl = requestUrl.replace("TICKET", urlEncodeUTF8(ticket));
		try {
			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");

			if (!savePath.endsWith("/")) {
				savePath += "/";
			}
			// 将ticket作为文件名
			filePath = savePath + name + ".jpg";
			System.out.println(filePath + "filePath");
			// 将微信服务器返回的输入流写入文件
			BufferedInputStream bis = new BufferedInputStream(conn
					.getInputStream());
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1)
				fos.write(buf, 0, size);
			fos.close();
			bis.close();

			conn.disconnect();
			// log.info("根据ticket换取二维码成功，filePath=" + filePath);
		} catch (Exception e) {
			filePath = null;
			// log.error("根据ticket换取二维码失败：{}", e);
		}
		return filePath;
	}

	/**
	 * 获取接口访问凭证
	 * 
	 * @param appid
	 *            凭证
	 * @param appsecret
	 *            密钥
	 * @return
	 */
	public static Token getToken(String appid, String appsecret) {
		Token token = null;
		String requestUrl = token_url.replace("APPID", appid).replace(
				"APPSECRET", appsecret);
		// 发起GET请求获取凭证
		JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			try {
				token = new Token();
				token.setAccessToken(jsonObject.getString("access_token"));
				token.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (Exception e) {
				token = null;
				// 获取token失败
				System.out.println("获取token失败 errcode:{} errmsg:{}"
						+ jsonObject.getInt("errcode")
						+ jsonObject.getString("errmsg"));
			}
		}
		return token;
	}

	/**
	 * 根据内容类型判断文件扩展名
	 * 
	 * @param contentType
	 *            内容类型
	 * @return
	 */
	public static String getFileExt(String contentType) {
		String fileExt = "";
		if ("image/jpeg".equals(contentType))
			fileExt = ".jpg";
		else if ("audio/mpeg".equals(contentType))
			fileExt = ".mp3";
		else if ("audio/amr".equals(contentType))
			fileExt = ".amr";
		else if ("video/mp4".equals(contentType))
			fileExt = ".mp4";
		else if ("video/mpeg4".equals(contentType))
			fileExt = ".mp4";
		return fileExt;
	}

	/**
	 * 下载媒体文件
	 * 
	 * @param accessToken
	 *            接口访问凭证
	 * @param mediaId
	 *            媒体文件标识
	 * @param savePath
	 *            文件在服务器上的存储路径
	 * @return
	 */
	public static String getMedia(String accessToken, String mediaId,
			String savePath) {
		String filePath = null;
		// 拼接请求地址
		String requestUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace(
				"MEDIA_ID", mediaId);
		// System.out.println(requestUrl);
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");

			if (!savePath.endsWith("/")) {
				savePath += "/";
			}
			// 根据内容类型获取扩展名
			String fileExt = abc
					.getFileExt(conn.getHeaderField("Content-Type"));
			// 将mediaId作为文件名
			filePath = savePath + mediaId + fileExt;

			BufferedInputStream bis = new BufferedInputStream(conn
					.getInputStream());
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1)
				fos.write(buf, 0, size);
			fos.close();
			bis.close();

			conn.disconnect();
			// log.info("下载媒体文件成功，filePath=" + filePath);
		} catch (Exception e) {
			filePath = null;
			// log.error("下载媒体文件失败：{}", e);
		}
		return filePath;
	}

	/*
	 * 组建发送模板信息
	 * 
	 * @param openId 消息发送对象
	 * 
	 * @param template_id 模板的信息ID
	 * 
	 * @return
	 */
	public static String sendTemplateMessage(String accessToken, String jsonMsg) {
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		// boolean result = false;
		// 发送模板消息
		JSONObject jsonObject = abc.httpsRequest(requestUrl, "POST", jsonMsg);
		if (null != jsonObject) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				// result = true;
				// log.info("模板消息发送成功 errcode:{} errmsg:{}", errorCode,
				// errorMsg);
				return errorCode + "";
			} else {
				// log.error("模板消息发送失败 errcode:{} errmsg:{}", errorCode,
				// errorMsg);
				return errorCode + "";
			}
		}
		return "0";

	}

	/**
	 * 发起http请求获取返回结果
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @return
	 */
	public static String httpRequest(String requestUrl, String requestMethod,
			String outputStr) {
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url
					.openConnection();
			httpUrlConn.setDoOutput(false);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			httpUrlConn.setRequestMethod(requestMethod);
			httpUrlConn.connect();
			// 当outputStr不为null时向输出流写数据
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符�?
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();

		} catch (Exception e) {
		}
		return buffer.toString();
	}

	public String sendMessage(String message, String tel) {
		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer("http://api.duanxin.cm/?");
		// 向StringBuffer追加用户名
		sb.append("action=send&username=70210415");
		// 向StringBuffer追加密码（密码采用MD5 32位 小写）
		sb.append("&password=6eaecc9daa274faddb1f3102fd4e93e7");
		// 向StringBuffer追加手机号码
		sb.append("&phone=").append(tel);
		// 向StringBuffer追加消息内容转URL标准码
		try {
			sb.append("&content=" + URLEncoder.encode(message, "UTF-8"));
			sb.append("&encode=utf8");
			// 创建url对象
			URL url = new URL(sb.toString());
			// 打开url连接
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			// 设置url请求方式 ‘get’ 或者 ‘post’
			connection.setRequestMethod("POST");
			// 发送
			BufferedReader in = new BufferedReader(new InputStreamReader(url
					.openStream()));
			// 返回发送结果
			String inputline = in.readLine();
			// 返回结果为‘100’ 发送成功
			System.out.println(inputline);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * 获取用户信息
	 * 
	 * @param accessToken
	 *            接口访问凭证
	 * @param openId
	 *            用户标识
	 * @return WeixinUserInfo
	 */
	public static WeixinUserInfo getUserInfo(String accessToken, String openId) {
		WeixinUserInfo weixinUserInfo = null;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace(
				"OPENID", openId);
		// 获取用户信息
		JSONObject jsonObject = abc.httpsRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			try {
				weixinUserInfo = new WeixinUserInfo();
				// 用户的标识
				weixinUserInfo.setOpenId(jsonObject.getString("openid"));
				// 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
				weixinUserInfo.setSubscribe(jsonObject.getInt("subscribe"));
				// 用户关注时间
				weixinUserInfo.setSubscribeTime(jsonObject
						.getString("subscribe_time"));
				// 昵称
				weixinUserInfo.setNickname(jsonObject.getString("nickname"));
				// 用户的性别（1是男性，2是女性，0是未知）
				weixinUserInfo.setSex(jsonObject.getInt("sex"));
				// 用户所在国家
				weixinUserInfo.setCountry(jsonObject.getString("country"));
				// 用户所在省份
				weixinUserInfo.setProvince(jsonObject.getString("province"));
				// 用户所在城市
				weixinUserInfo.setCity(jsonObject.getString("city"));
				// 用户的语言，简体中文为zh_CN
				weixinUserInfo.setLanguage(jsonObject.getString("language"));
				// 用户头像
				weixinUserInfo
						.setHeadImgUrl(jsonObject.getString("headimgurl"));
			} catch (Exception e) {
				if (0 == weixinUserInfo.getSubscribe()) {
					// log.error("用户{}已取消关注", weixinUserInfo.getOpenId());
				} else {
					int errorCode = jsonObject.getInt("errcode");
					String errorMsg = jsonObject.getString("errmsg");
					// log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode,
					// errorMsg);
				}
			}
		}
		return weixinUserInfo;
	}

	/**
	 * 获取网页授权凭证
	 * 
	 * @param appId
	 *            公众账号的唯一标识
	 * @param appSecret
	 *            公众账号的密钥
	 * @param code
	 * @return WeixinAouth2Token
	 */
	public static WeixinOauth2Token getOauth2AccessToken(String appId,
			String appSecret, String code) {
		WeixinOauth2Token wat = null;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		requestUrl = requestUrl.replace("APPID", appId);
		requestUrl = requestUrl.replace("SECRET", appSecret);
		requestUrl = requestUrl.replace("CODE", code);
		// 获取网页授权凭证
		JSONObject jsonObject = abc.httpsRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			try {
				wat = new WeixinOauth2Token();
				wat.setAccessToken(jsonObject.getString("access_token"));
				wat.setExpiresIn(jsonObject.getInt("expires_in"));
				wat.setRefreshToken(jsonObject.getString("refresh_token"));
				wat.setOpenId(jsonObject.getString("openid"));
				wat.setScope(jsonObject.getString("scope"));
				System.out.println("==================suss==========");
			} catch (Exception e) {
				wat = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				System.out.println("==================fail==========");
				System.out.println("获取网页授权凭证失败 errcode:{} errmsg:{}"
						+ errorCode + errorMsg);
			}
		}
		return wat;
	}

	public static String dofilter(String str) {
		String str_Result = "", str_OneStr = "";
		for (int z = 0; z < str.length(); z++) {
			str_OneStr = str.substring(z, z + 1);
			if (str_OneStr.matches("[\u4e00-\u9fa5]+")
					|| str_OneStr.matches("[\\x00-\\x7F]+")) {
				str_Result = str_Result + str_OneStr;
			}
		}
		return str_Result;
	}

	/**
	 * 获取当前时间 yyyyMMddHHmmss
	 * 
	 * @return String
	 */
	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}

	public static boolean isEmpty(String v) {
		// TODO Auto-generated method stub
		if (v == null || v.equals("")) {
			return true;
		}
		return false;
	}

	public static String getLocationBytx(String lng, String lat) {
		// TODO Auto-generated method stub
		String location = null;
		// 设置参数
		String requestUrl = "http://apis.map.qq.com/ws/geocoder/v1/?location={lat},{lng}&key={ak}&get_poi=1";
		requestUrl = requestUrl.replace("{ak}",
				"ZTEBZ-BOVW4-TXKUU-DIOMG-IOVHH-WQBKK");
		requestUrl = requestUrl.replace("{lng}", lng);
		requestUrl = requestUrl.replace("{lat}", lat);
		// 发送请求
		String jsonResult = httpRequest(requestUrl);
		// 结果解析
		JSONObject jsonObject = JSONObject.fromObject(jsonResult);
		int status = jsonObject.getInt("status");

		if (0 == status) {
			JSONObject resultObject = (JSONObject) jsonObject.get("result");
			// 返回区，县，镇级别
			// System.out.println(resultObject);
			location = resultObject.get("address").toString();
		}
		return location;
	}

	/**
	 * 发起http请求获取返回结果
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @return
	 */
	public static String httpRequest(String requestUrl) {
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url
					.openConnection();

			httpUrlConn.setDoOutput(false);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);

			httpUrlConn.setRequestMethod("GET");
			httpUrlConn.connect();

			// 将返回的输入流转换成字符�?
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();

		} catch (Exception e) {
		}
		return buffer.toString();
	}

	/**
	 * 获取省市及其编码
	 * 
	 * @param lng
	 * @param lat
	 * @return
	 */
	public static com.alibaba.fastjson.JSONObject getLocation(String lng,
			String lat) {
		// TODO Auto-generated method stub
		com.alibaba.fastjson.JSONObject json = new com.alibaba.fastjson.JSONObject();
		String location = null;
		// 设置参数
		String requestUrl = "http://apis.map.qq.com/ws/geocoder/v1/?location={lat},{lng}&key={ak}&get_poi=1";
		requestUrl = requestUrl.replace("{ak}",
				"ZTEBZ-BOVW4-TXKUU-DIOMG-IOVHH-WQBKK");
		requestUrl = requestUrl.replace("{lng}", lng);
		requestUrl = requestUrl.replace("{lat}", lat);
		// 发送请求
		String jsonResult = httpRequest(requestUrl);
		// 结果解析
		JSONObject jsonObject = JSONObject.fromObject(jsonResult);
		int status = jsonObject.getInt("status");
		if (0 == status) {
			JSONObject resultObject = (JSONObject) jsonObject.get("result");
			// 返回区，县，镇级别
			// System.out.println(resultObject);
			location = resultObject.get("address").toString();
			String prov = JSONObject.fromObject(
					resultObject.get("address_component")).get("province")
					.toString();
			String city = JSONObject.fromObject(
					resultObject.get("address_component")).get("city")
					.toString();
			String code = JSONObject.fromObject(resultObject.get("ad_info"))
					.get("adcode").toString();
			String proCode = code.substring(0, 2) + "0000";
			String cityCode = code.substring(0, 4) + "00";
			json.put("prov", prov);
			json.put("city", city);
			json.put("proCode", proCode);
			json.put("cityCode", cityCode);
		}
		return json;
	}

	public static void main(String[] args) throws ParseException {
		int n=1;
		String ss=getday()+" ";
		java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
		Date date =  formatter.parse(ss);
		Calendar c=Calendar.getInstance();   
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");   
		c.setTime(date);   
		c.add(Calendar.DATE,n);   
		Date d2=c.getTime();   
		String s=df.format(d2);   
		System.out.println(s);
	}

	public static int getCompgetareDate(Date dt1, Date dt2) {
		if (dt1.getTime() > dt2.getTime()) {
			System.out.println("dt1 在dt2前");
			return 1;
		} else if (dt1.getTime() < dt2.getTime()) {
			System.out.println("dt1在dt2后");
			return -1;
		} else {// 相等
			return 0;
		}
	}
	
	//获取当前时间之后几天
	public static String afterNDay(String day,int n){   
		String ss=day+" ";
		java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
		Date date;
		try {
			date = formatter.parse(ss);
			Calendar c=Calendar.getInstance();   
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");   
			c.setTime(date);   
			c.add(Calendar.DATE,n);   
			Date d2=c.getTime();   
			String s=df.format(d2);    
			return s;   
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return "-1";
		}
	
	public static String get_JS_SDK(String accessToken, String url) {
		// TODO Auto-generated method stub
		String jsapi_ticket=TokenThread.jsapi_ticket;
		String noncestr=JsSdkUtil.create_nonce_str();
		String timestamp=JsSdkUtil.create_timestamp();
		Map<String, String> map =JsSdkUtil.sign(jsapi_ticket, url,noncestr,timestamp);
		System.out.println("signature="+map.get("signature"));
		String json = JSONArray.fromObject(map).toString();
		return json;
	}
	
	
	/**
	 * 下载图片
	 * 
	 */
	public static String getPic(String requestUrl, String savePath, String name) {
		String filePath = null;
		System.out.println("=======1======");
		try {
			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");

			if (!savePath.endsWith("/")) {
				savePath += "/";
			}
			// 将ticket作为文件名
			filePath = savePath + name + ".jpg";
			System.out.println(filePath + "filePath");
			// 将微信服务器返回的输入流写入文件
			BufferedInputStream bis = new BufferedInputStream(conn
					.getInputStream());
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1)
				fos.write(buf, 0, size);
			fos.close();
			bis.close();

			conn.disconnect();
			// log.info("根据ticket换取二维码成功，filePath=" + filePath);
		} catch (Exception e) {
			filePath = null;
			System.out.println("=======22======");
			// log.error("根据ticket换取二维码失败：{}", e);
		}
		return filePath;
	}

}
