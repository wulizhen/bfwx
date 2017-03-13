package com.bf.entity;

/**
 * View��ť���Ӱ�ť��
 * 
 * @author liuyq
 * @date 2013-04-10
 */
public class ViewButton extends Button {
	private String type;
	private String url;
	private String key;
	
	

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
