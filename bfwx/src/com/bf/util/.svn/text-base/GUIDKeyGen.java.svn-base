package com.bf.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class GUIDKeyGen {
	private static Date date = new Date();  
	  private static StringBuilder buf = new StringBuilder();  
	  private static int seq = 0;  
	  private static final int ROTATION = 99999;  
	private GUIDKeyGen() {

	}
	
	public static String getGUIDKey() {
		String str = UUID.randomUUID().toString();
		return str.substring(0, 8) + str.substring(9, 13)
				+ str.substring(14, 18) + str.substring(19, 23)
				+ str.substring(24, 36);
	}

	public static String getOnlyId() {

		Long timeNum = System.currentTimeMillis();

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
		String nowtime = dateFormat.format(now);
		int x=(int)(Math.random()*999899);
//		System.out.println(String.valueOf(nowtime + timeNum + "---������ˮ��"));

		return String.valueOf(nowtime + timeNum+x);
	}

	public static void main(String args[]) {
        for (int i = 0; i < 10; i++) {
        	System.out.println(getOnlyId()+"="+i+"=");
		}
		
	}

	  public static synchronized long next(){  
		    if (seq > ROTATION) seq = 0;  
		    buf.delete(0, buf.length());  
		    date.setTime(System.currentTimeMillis());  
		    String str = String.format("%1$tY%1$tm%1$td%1$tk%1$tM%1$tS%2$05d", date, seq++);  
		    return Long.parseLong(str);  
		  }  

}
