package com.bf.entity;

import java.util.List;

/**
 * 模板
 * 
 * @author liufeng
 * @date 2014-11-18
 */
public class Template {
	// 消息接收�?
	private String toUser;
	// 模板id
	private String templateId;
	// 模板消息详情链接
	private String url;
	// 消息顶部的颜�?
	private String topColor;
	// 参数列表
	private List<TemplateParam> templateParamList;

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTopColor() {
		return topColor;
	}

	public void setTopColor(String topColor) {
		this.topColor = topColor;
	}

	public List<TemplateParam> getTemplateParamList() {
		return templateParamList;
	}

	public void setTemplateParamList(List<TemplateParam> templateParamList) {
		this.templateParamList = templateParamList;
	}

	/**
	 * 将模板对象转换成json字符�?
	 * 
	 * @return String
	 */
	public String toJSON() {
		StringBuffer buffer = new StringBuffer();
		// 起始括号
		buffer.append("{");
		buffer.append(String.format("\"touser\":\"%s\"", this.toUser)).append(",");
		buffer.append(String.format("\"template_id\":\"%s\"", this.templateId)).append(",");
		buffer.append(String.format("\"url\":\"%s\"", this.url)).append(",");
		buffer.append(String.format("\"topcolor\":\"%s\"", this.topColor)).append(",");
		// 模板消息参数
		buffer.append("\"data\":{");
		TemplateParam param = null;
		for (int i = 0; i < this.templateParamList.size(); i++) {
			param = templateParamList.get(i);
			// 判断是否追加逗号
			if (i < this.templateParamList.size() - 1)
				buffer.append(String.format("\"%s\": {\"value\":\"%s\",\"color\":\"%s\"},", param.getName(), param.getValue(), param.getColor()));
			else
				buffer.append(String.format("\"%s\": {\"value\":\"%s\",\"color\":\"%s\"}", param.getName(), param.getValue(), param.getColor()));
		}
		buffer.append("}");
		// 结束括号
		buffer.append("}");
		return buffer.toString();
	}
}