package com.bf.util;

public class StringZFzhuanx {
    /*
     * public static void main(String[] args){
	String info = "百d度,经3验,欢迎H你";
	info = info.replace(',',':');//将字符串,替换成":"
	System.out.println(info);//替换后输出
	info=info.replace("欢迎","需要");//将欢迎二字换成需要
	System.out.println(info);//替换后输出
	info=info.replaceAll("[0-9a-zA-Z]","\\$");//使用正则表达式将数字字母替换为$
	System.out.println(info);//输出结果
	info = info.replaceFirst("\\$","#"); //使用正则表达式将第一个$替换为#
	System.out.println(info);//输出结果
	}
     */
	
	/*
	 * 字符串转换
	 */
	
	public static String getSonversion(String info){
		info = info.replace('/',' ');//将字符串/替换成"  "
		System.out.println(info);
		return info;	
	}
	
	public static String getSonversio(String info){
		info=info.replace("欢迎","需要");//将欢迎二字换成需要
		System.out.println(info);
		return info;	
	}
	
	public static String getSonversi(String info){
		info=info.replaceAll("[0-9a-zA-Z]","\\$");//使用正则表达式将数字字母替换为$
		System.out.println(info);
		return info;	
	}
	
	public static String getSonvers(String info){
		info = info.replaceFirst("\\$","#"); //使用正则表达式将第一个$替换为#
		System.out.println(info);
		return info;	
	}
	
	public static void main(String[] args) {
		getSonversion("//////////////o");
		getSonversio("欢迎欢迎欢迎");
		getSonversi("大城市的322SSDCDS的山地车");
		getSonvers("$w$J$H$JJH$$HJ$JH$B$J");
	}
	
	

}
