package com.bf.util;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MoreTime {	
	/*
	 * 比较时间大小
	 */
	public static int getMoreTime(Date dt1,Date dt2){
        if (dt1.getTime() > dt2.getTime()) {
//            System.out.println("dt1 在dt2前");
            return 1;
        } else if (dt1.getTime() < dt2.getTime()) {
//            System.out.println("dt1在dt2后");
            return -1;
        } else {//相等
            return 0;
        }
	}	
	public static void main(String[] args) throws Exception{
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//		String strDate = "2016-01-14 09:59:17";
////		String strDate1 = "2016-05-14 09:59:10";
//		Date date=sdf.parse(strDate);
//		Date date1=sdf.parse(getTime());
//		System.out.println(getMoreTime(date, date1));
//		System.out.println(getTime());
//		System.out.println(zhDate("2016-01-14 09:59:17"));
////		System.out.println(getMoreTime(zhDate("2016-01-14 09:59:17"), zhDate(getTime())));
//		System.out.println(dayForWeek("2013-02-13"));
		System.out.println((getNewDayNumDate1(MoreTime.getTime(), 100)));
	}
	
	/*
	 * string类型转出Date
	 */
	
	public static Date zhDate(String date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1=sdf.parse(date);
		return date1;	
	}
	
	/*
	 * string类型转出Date
	 */
	
	public static Date zhDate1(String date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date1=sdf.parse(date);
		return date1;	
	}

	/*
	 * 获取当前时间
	 */
	public static String getTime(){
		//得到long类型当前时间
		long l = System.currentTimeMillis();
		//new日期对象
	    Date date = new Date(l);
		//转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //
		return dateFormat.format(date);		
	}
	
	public static String getTime1(){
		//得到long类型当前时间
		long l = System.currentTimeMillis();
		//new日期对象
	    Date date = new Date(l);
		//转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);		
	}
	
	public static String getTime2(){
		//得到long类型当前时间
		long l = System.currentTimeMillis();
		//new日期对象
	    Date date = new Date(l);
		//转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);		
	}
	
	
	/**
     * 判断当前日期是星期几
     * 
     * @param pTime 修要判断的时间
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */
 public static String dayForWeek(String pTime) throws Exception {
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  Calendar c = Calendar.getInstance();
  c.setTime(format.parse(pTime));
  int dayForWeek = 0;
  if(c.get(Calendar.DAY_OF_WEEK) == 1){
   dayForWeek = 7;
  }else{
   dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
  }
  String dayForWeek1="";
  if (dayForWeek==1) {
	  dayForWeek1="一";
  }else if (dayForWeek==2) {
	  dayForWeek1="二";
  }else{
	  if (dayForWeek==3) {
		  dayForWeek1="三";
	}else {
		if (dayForWeek==4) {
			dayForWeek1="四";
		}else {
			if (dayForWeek==5) {
				dayForWeek1="五";
			}else {
				if (dayForWeek==6) {
					dayForWeek1="六";
				}else {
					dayForWeek1="日";
				}
			}
		}
	}
  }
  return dayForWeek1;
 }

 /*
	 * 获取当前时间（小时）
	 */
	public static String getTime3(){
		//得到long类型当前时间
		long l = System.currentTimeMillis();
		//new日期对象
	    Date date = new Date(l);
		//转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm"); //
		return dateFormat.format(date);		
	}
	
	/** 
     * 两个时间相差距离多少天多少小时多少分多少秒 
     * @param str1 时间参数 1 格式：1990-01-01 12:00:00 
     * @param str2 时间参数 2 格式：2009-01-01 12:00:00 
     * @return String 返回值为：xx天xx小时xx分xx秒 
     */  
    public static String getDistanceTime(String str1, String str2) {  
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date one;  
        Date two;  
        long day = 0;  
        long hour = 0;  
        long min = 0;  
        long sec = 0;  
        try {  
            one = df.parse(str1);  
            two = df.parse(str2);  
            long time1 = one.getTime();  
            long time2 = two.getTime();  
            long diff ;  
            if(time1<time2) {  
                diff = time2 - time1;  
            } else {  
                diff = time1 - time2;  
            }  
            day = diff / (24 * 60 * 60 * 1000);  
            hour = (diff / (60 * 60 * 1000) - day * 24);  
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);  
            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
//        return day*24 + "天" + hour + "小时" + min + "分" + sec + "秒";  
        return (day*24)+hour+"";//返回小时
    } 
    

    /**
* 得到当前日期 再加上你指定的年月日数 所得到的新日期
* @param days
* @return
* @throws ParseException 
*/
public static String getNewDayNumDate(String str,int day) throws ParseException{
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
Date dt=sdf.parse(str);
Calendar rightNow = Calendar.getInstance();
rightNow.setTime(dt);
rightNow.add(Calendar.DAY_OF_YEAR,-day);//日期减指定天数
//rightNow.add(Calendar.YEAR,-1);//日期减1年
//rightNow.add(Calendar.MONTH,3);//日期加3个月	
Date dt1=rightNow.getTime();
String reStr = sdf.format(dt1);
return reStr;

}  
/**
* 得到当前日期 再加上你指定的年月日数 所得到的新日期
* @param days
* @return
* @throws ParseException 
*/
public static String getNewDayNumDate1(String str,int day) throws ParseException{
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
Date dt=sdf.parse(str);
Calendar rightNow = Calendar.getInstance();
rightNow.setTime(dt);
rightNow.add(Calendar.DAY_OF_YEAR,day);//日期减指定天数
//rightNow.add(Calendar.YEAR,-1);//日期减1年
//rightNow.add(Calendar.MONTH,3);//日期加3个月	
Date dt1=rightNow.getTime();
String reStr = sdf.format(dt1);
return reStr;

}  
    
    
}  
	
	
	


