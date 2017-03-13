package com.bf.util;

import java.io.InputStream;




import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;

import com.bf.entity.Article;
import com.bf.entity.ImageMessage;
import com.bf.entity.MusicMessage;
import com.bf.entity.NewsMessage;
import com.bf.entity.TextMessage;
import com.bf.entity.VideoMessage;
import com.bf.entity.VoiceMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * 消息处理工具�?
 * 
 * @author liufeng
 * @date 2013-09-15
 */
public class MessageUtil {
	// 请求消息类型：文�?
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";
	// 请求消息类型：图�?
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
	// 请求消息类型：语�?
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
	// 请求消息类型：视�?
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
	// 请求消息类型：地理位�?
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
	// 请求消息类型：链�?
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	// 请求消息类型：事件推�?
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	// 事件类型：subscribe(订阅)
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
	// 事件类型：unsubscribe(取消订阅)
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
	// 事件类型：scan(用户已关注时的扫描带参数二维�?
	public static final String EVENT_TYPE_SCAN = "SCAN";
	public static final String EVENT_TYPE_scancode_waitmsg = "scancode_waitmsg";
	//事件类型：location_select 用户点击菜单上传地理位置
	public static final String EVENT_TYPE_LOCATION_SELECT = "location_select";
	// 事件类型：LOCATION(上报地理位置)
	public static final String EVENT_TYPE_LOCATION = "LOCATION";
	// 事件类型：CLICK(自定义菜�?
	public static final String EVENT_TYPE_CLICK = "CLICK";
	// 响应消息类型：文�?
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";
	//响应转到多客服类型
	public static final String RESP_MESSAGE_TYPE_SERVICE= "transfer_customer_service";
	// 响应消息类型：图�?
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
	// 响应消息类型：语�?
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
	// 响应消息类型：视�?
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
	// 响应消息类型：音�?
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
	// 响应消息类型：图�?
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";

	/**
	 * 解析微信发来的请求（XML�?
	 * 
	 * @param request
	 * @return Map<String, String>
	 * @throws Exception
	 */
//	@SuppressWarnings("unchecked")
//	public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
//		// 将解析结果存储在HashMap�?
//		Map<String, String> map = new HashMap<String, String>();
//
//		// 从request中取得输入流
//		InputStream inputStream = request.getInputStream();
//		// 读取输入�?
//		SAXReader reader = new SAXReader();
//		Document document = reader.read(inputStream);
//		// 得到xml根元�?
//		Element root = document.getRootElement();
//		// 得到根元素的�?��子节�?
//		List<Element> elementList = root.elements();
//
//		// 遍历�?��子节�?
//		for (Element e : elementList){
//			map.put(e.getName(), e.getText());
//		   // System.out.println(e.getName()+"===="+e.getText());
//		  }
//		// 释放资源
//		inputStream.close();
//		inputStream = null;
//
//		return map;
//	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
		// 将解析结果存储在HashMap中
		Map<String, String> map = new HashMap<String, String>();

		// 从request中取得输入流
		InputStream inputStream = request.getInputStream();
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// 得到xml根元素
		Element root = document.getRootElement();
		// 遍历xml，得到叶子节点
		map = xmlParser(root, map);
		// 释放资源
		inputStream.close();
		inputStream = null;
		return map;
	}
	
	/**
	 * xml解析器
	 * @param element
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static Map<String, String> xmlParser(Element element, Map<String, String> map) {
		List<Element> elementList = element.elements();
		// 无子节点
		if (elementList.size() == 0) {
			map.put(element.getName(), element.getTextTrim());
			
		}
		// 有子节点
		else {
			for (Iterator<Element> it = elementList.iterator(); it.hasNext();) {
				Element e = it.next();
				// 递归遍历
				xmlParser(e, map);
			}
		}
		return map;
	}
	/**
	 * 扩展xstream使其支持CDATA
	 */
	private static XStream xstream = new XStream(new XppDriver() {
		@Override
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				@Override
				@SuppressWarnings("unchecked")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				@Override
				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});

	/**
	 * 文本消息对象转换成xml
	 * 
	 * @param textMessage 文本消息对象
	 * @return xml
	 */
	public static String messageToXml(TextMessage textMessage) {
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}

	/**
	 * 图片消息对象转换成xml
	 * 
	 * @param imageMessage 图片消息对象
	 * @return xml
	 */
	public static String messageToXml(ImageMessage imageMessage) {
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}

	/**
	 * 语音消息对象转换成xml
	 * 
	 * @param voiceMessage 语音消息对象
	 * @return xml
	 */
	public static String messageToXml(VoiceMessage voiceMessage) {
		xstream.alias("xml", voiceMessage.getClass());
		return xstream.toXML(voiceMessage);
	}

	/**
	 * 视频消息对象转换成xml
	 * 
	 * @param videoMessage 视频消息对象
	 * @return xml
	 */
	public static String messageToXml(VideoMessage videoMessage) {
		xstream.alias("xml", videoMessage.getClass());
		return xstream.toXML(videoMessage);
	}

	/**
	 * 音乐消息对象转换成xml
	 * 
	 * @param musicMessage 音乐消息对象
	 * @return xml
	 */
	public static String messageToXml(MusicMessage musicMessage) {
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}

	/**
	 * 图文消息对象转换成xml
	 * 
	 * @param newsMessage 图文消息对象
	 * @return xml
	 */
	public static String messageToXml(NewsMessage newsMessage) {
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsMessage);
	}
}
