package com.bf.util;

import java.util.logging.Logger;

import com.bf.entity.Menu;
import com.jfinal.log.Log4jLogFactory;

import net.sf.json.JSONObject;







/**
 * 菜单工具类
 * 
 * @author liufeng
 * @date 2013-10-17
 */
public class MenuUtil {

	// 创建菜单接口
	public final static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	// 获取菜单接口
	public final static String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	// 删除菜单接口
	public final static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	/**
	 * 创建菜单
	 * 
	 * @param menu �˵�ʵ��
	 * @param accessToken ƾ֤
	 * @return true�ɹ� falseʧ��
	 */
	public static boolean createMenu(Menu menu, String accessToken) {

		boolean result = false;
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
		// ���˵�����ת����json�ַ�
		String jsonMenu = JSONObject.fromObject(menu).toString();
		System.out.println(jsonMenu);
		// ����POST���󴴽��˵�
		JSONObject jsonObject = abc.httpsRequest(url, "POST", jsonMenu);

		if (null != jsonObject) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				result = true;
			} else {
				result = false;
				System.out.println(errorCode+ errorMsg);
				System.out.println("菜单创建失败 errcode:{} errmsg:{}"+errorCode+errorMsg);
			}
		}

		return result;
	}

	/**
	 * ��ѯ�˵�
	 * 
	 * @param accessToken ƾ֤
	 * @return
	 */
	public static String getMenu(String accessToken) {
		String result = null;
		String requestUrl = menu_get_url.replace("ACCESS_TOKEN", accessToken);
		// ����GET�����ѯ�˵�
		JSONObject jsonObject = abc.httpsRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			result = jsonObject.toString();
		}
		return result;
	}

	/**
	 * ɾ��˵�
	 * 
	 * @param accessToken ƾ֤
	 * @return true�ɹ� falseʧ��
	 */
	public static boolean deleteMenu(String accessToken) {
		boolean result = false;
		String requestUrl = menu_delete_url.replace("ACCESS_TOKEN", accessToken);
		// ����GET����ɾ��˵�
		JSONObject jsonObject = abc.httpsRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				result = true;
			} else {
				result = false;
				System.out.println("ɾ��˵�ʧ�� errcode:{} errmsg:{}"+ errorCode+ errorMsg);
			}
		}
		return result;
	}
}