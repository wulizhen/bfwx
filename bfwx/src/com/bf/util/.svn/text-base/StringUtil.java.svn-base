package com.bf.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;





public class StringUtil {
	private static final String EMPTY = null;
	private static final int PAD_LIMIT = 0;
	private static final int INDEX_NOT_FOUND = 0;
	public static void main(String[] args) {
//		System.out.println(changeToFull("$%$%^(*&(*yao滨海&$()*()*(*"));
//	    System.out.println(containsNone("我是中国人", '我'));
//		System.out.println(unicodeEscaped('w'));
//		System.out.println(toString(1112123324));
//		System.out.println(toString(null, "w"));
//		System.out.println(isEmpty("[]"));
//		System.out.println(removeStart("/w//w/w", "/w"));
//		System.out.println(removeEnd("abc", "bc"));
//		System.out.println(repeat("ww", 99));
//		System.out.println(repeat('q', 10));
//		System.out.println(repeat("dsadasd", ".", 4));
//		System.out.println(isAllUpperCase("AAAAAAAAAAAA"));
		
        System.out.print(gethaop());
			
	}
   
    //自动生成中文字符串  
    public static String getRandomHan() {
    	String nicheng ="" ;
    	int arr[]={3,4,5};
    	int index=(int)(Math.random()*arr.length);
    	int rand = arr[index];
    	for (int i = 0; i < rand; i++) { 
    		final int delta = 0x9fa5 - 0x4e00 + 1;
        	Random ran = new Random();
        	char f= (char)(0x4e00 + ran.nextInt(delta));
        	nicheng+= f;
		}
		return nicheng; 
    }
    //自动生成好评
    public static String gethaop() {
    	String app[]={"老公很喜欢，物美价廉啊！","可以看出来店家很用心","好用心啊～质量不错。",
    			"快递速度好快","第一次在他家买东西 物流很快第一天发 第二天就到了",
    			"和图片上的一样 , 这样的价格也很合适 感谢卖家 感谢快递","客服的态度还可以，服务很到位","感谢亲手写滴信，让我看到这家店滴诚意，明天我还会再拍几件滴",
    			"我很喜欢，物流也很快，服务也很好！","拍了三件，看上去质量不错图案也漂亮，是不会掉色的那种，好评",
    			"货已收到，物流超快，真正的货美价廉，质量完全没有问题","超赞，物美价廉啊！","给弟弟买的，买值了",
    			"老板也挺热情的","不敢相信有这么好的店家，但，这是真的！支持！支持！支持！","喜欢的亲快快下单吧！客服人也很好",
    			"卖家态度也超好 还写了很长的信 这真的是第一次看到 物流也快 价格又便宜","快递速度很快，东西很好哦",
    			"宝贝收到了，很喜欢哦","我很喜欢他们的服务态度也好，物流也很快。","今天收的几件货满意","店家很用心，还送小礼物！",
    			"这么用诚意 这么好心的老板","不想太啰嗦，买买买买买买"};
    	Random rad = new Random();
    	int index = rad.nextInt(app.length);
		return app[index];
    	
    }
	/**
	 * 功能：检查这个字符串是不是空字符串。<br/>
	 * 如果这个字符串为null或者trim后为空字符串则返回true，否则返回false。
	 * 
	 * @author 宋立君
	 * @date 2014年06月24日
	 * @param chkStr
	 *            被检查的字符串
	 * @return boolean
	 */
	public static boolean isEmpty(String chkStr) {
		if (chkStr == null) {
			return true;
		} else {
			return "".equals(chkStr.trim()) ? true : false;
		}
	}
		
	/**
	 * 功能：将半角的符号转换成全角符号.(即英文字符转中文字符)
	 * 
	 * @author 宋立君
	 * @param str
	 *   源字符串
	 * @return String
	 * @date 2014年06月24日
	 */
	public static String changeToFull(String str) {
		String source = "1234567890!@#$%^&*()abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_=+\\|[];:'\",<.>/?";
		String[] decode = { "１", "２", "３", "４", "５", "６", "７", "８", "９", "０",
				"！", "＠", "＃", "＄", "％", "︿", "＆", "＊", "（", "）", "ａ", "ｂ",
				"ｃ", "ｄ", "ｅ", "ｆ", "ｇ", "ｈ", "ｉ", "ｊ", "ｋ", "ｌ", "ｍ", "ｎ",
				"ｏ", "ｐ", "ｑ", "ｒ", "ｓ", "ｔ", "ｕ", "ｖ", "ｗ", "ｘ", "ｙ", "ｚ",
				"Ａ", "Ｂ", "Ｃ", "Ｄ", "Ｅ", "Ｆ", "Ｇ", "Ｈ", "Ｉ", "Ｊ", "Ｋ", "Ｌ",
				"Ｍ", "Ｎ", "Ｏ", "Ｐ", "Ｑ", "Ｒ", "Ｓ", "Ｔ", "Ｕ", "Ｖ", "Ｗ", "Ｘ",
				"Ｙ", "Ｚ", "－", "＿", "＝", "＋", "＼", "｜", "【", "】", "；", "：",
				"'", "\"", "，", "〈", "。", "〉", "／", "？" };
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			int pos = source.indexOf(str.charAt(i));
			if (pos != -1) {
				result += decode[pos];
			} else {
				result += str.charAt(i);
			}
		}
		return result;
	}
	
	/**
	 * 功能：cs串中是否一个都不包含字符数组searchChars中的字符。
	 * 
	 * @author 宋立君
	 * @param cs
	 *            字符串
	 * @param searchChars
	 *            字符数组
	 * @return boolean 都不包含返回true，否则返回false。
	 * @date 2014年06月24日
	 */
	public static boolean containsNone(CharSequence cs, char... searchChars) {
		if (cs == null || searchChars == null) {
			return true;
		}
		int csLen = cs.length();
		int csLast = csLen - 1;
		int searchLen = searchChars.length;
		int searchLast = searchLen - 1;
		for (int i = 0; i < csLen; i++) {
			char ch = cs.charAt(i);
			for (int j = 0; j < searchLen; j++) {
				if (searchChars[j] == ch) {
					if (Character.isHighSurrogate(ch)) {
						if (j == searchLast) {
							// missing low surrogate, fine, like
							// String.indexOf(String)
							return false;
						}
						if (i < csLast
								&& searchChars[j + 1] == cs.charAt(i + 1)) {
							return false;
						}
					} else {
						// ch is in the Basic Multilingual Plane
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * <p>
	 * 编码为Unicode，格式 '\u0020'.
	 * </p>
	 * 
	 * @author 宋立君
	 * 
	 *         <pre>
	 *   CharUtils.unicodeEscaped(' ') = "\u0020"
	 *   CharUtils.unicodeEscaped('A') = "\u0041"
	 * </pre>
	 * 
	 * @param ch
	 *            源字符串
	 * @return 转码后的字符串
	 * @date 2014年06月24日
	 */
	public static String unicodeEscaped(char ch) {
		if (ch < 0x10) {
			return "\\u000" + Integer.toHexString(ch);
		} else if (ch < 0x100) {
			return "\\u00" + Integer.toHexString(ch);
		} else if (ch < 0x1000) {
			return "\\u0" + Integer.toHexString(ch);
		}
		return "\\u" + Integer.toHexString(ch);
	}
	
	/**
	 * <p>
	 * 进行tostring操作，如果传入的是null，返回空字符串。
	 * </p>
	 *
	 * <pre>
	 * ObjectUtils.toString(null)         = ""
	 * ObjectUtils.toString("")           = ""
	 * ObjectUtils.toString("bat")        = "bat"
	 * ObjectUtils.toString(Boolean.TRUE) = "true"
	 * </pre>
	 *
	 * @param obj
	 *            源
	 * @return String
	 */
	public static String toString(Object obj) {
		return obj == null ? "" : obj.toString();
	}
	
	/**
	 * <p>
	 * 进行tostring操作，如果传入的是null，返回指定的默认值。
	 * </p>
	 *
	 * <pre>
	 * ObjectUtils.toString(null, null)           = null
	 * ObjectUtils.toString(null, "null")         = "null"
	 * ObjectUtils.toString("", "null")           = ""
	 * ObjectUtils.toString("bat", "null")        = "bat"
	 * ObjectUtils.toString(Boolean.TRUE, "null") = "true"
	 * </pre>
	 *
	 * @param obj
	 *            源
	 * @param nullStr
	 *            如果obj为null时返回这个指定值
	 * @return String
	 */
	public static String toString(Object obj, String nullStr) {
		return obj == null ? nullStr : obj.toString();
	}
	
	/**
	 * <p>
	 * 只从源字符串中移除指定开头子字符串.
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.removeStart(null, *)      = null
	 * StringUtil.removeStart("", *)        = ""
	 * StringUtil.removeStart(*, null)      = *
	 * StringUtil.removeStart("www.domain.com", "www.")   = "domain.com"
	 * StringUtil.removeStart("domain.com", "www.")       = "domain.com"
	 * StringUtil.removeStart("www.domain.com", "domain") = "www.domain.com"
	 * StringUtil.removeStart("abc", "")    = "abc"
	 * </pre>
	 *
	 * @param str
	 *            源字符串
	 * @param remove
	 *            将要被移除的子字符串
	 * @return String
	 */
	public static String removeStart(String str, String remove) {
		if (isEmpty(str) || isEmpty(remove)) {
			return str;
		}
		if (str.startsWith(remove)) {
			return str.substring(remove.length());
		}
		return str;
	}
	
	

	/**
	 * <p>
	 * 只从源字符串中移除指定结尾的子字符串.
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.removeEnd(null, *)      = null
	 * StringUtil.removeEnd("", *)        = ""
	 * StringUtil.removeEnd(*, null)      = *
	 * StringUtil.removeEnd("www.domain.com", ".com.")  = "www.domain.com"
	 * StringUtil.removeEnd("www.domain.com", ".com")   = "www.domain"
	 * StringUtil.removeEnd("www.domain.com", "domain") = "www.domain.com"
	 * StringUtil.removeEnd("abc", "")    = "abc"
	 * </pre>
	 *
	 * @param str
	 *            源字符串
	 * @param remove
	 *            将要被移除的子字符串
	 * @return String
	 */
	public static String removeEnd(String str, String remove) {
		if (isEmpty(str) || isEmpty(remove)) {
			return str;
		}
		if (str.endsWith(remove)) {
			return str.substring(0, str.length() - remove.length());
		}
		return str;
	}
	
	/**
	 * <p>
	 * 将一个字符串重复N次
	 * </p>
	 *
	 * <pre>
	 * StringUtil.repeat(null, 2) = null
	 * StringUtil.repeat("", 0)   = ""
	 * StringUtil.repeat("", 2)   = ""
	 * StringUtil.repeat("a", 3)  = "aaa"
	 * StringUtil.repeat("ab", 2) = "abab"
	 * StringUtil.repeat("a", -2) = ""
	 * </pre>
	 *
	 * @param str
	 *            源字符串
	 * @param repeat
	 *            重复的次数
	 * @return String
	 */
	public static String repeat(String str, int repeat) {
		// Performance tuned for 2.0 (JDK1.4)

		if (str == null) {
			return null;
		}
		if (repeat <= 0) {
			return EMPTY;
		}
		int inputLength = str.length();
		if (repeat == 1 || inputLength == 0) {
			return str;
		}
		if (inputLength == 1 && repeat <= PAD_LIMIT) {
			return repeat(str.charAt(0), repeat);
		}

		int outputLength = inputLength * repeat;
		switch (inputLength) {
		case 1:
			return repeat(str.charAt(0), repeat);
		case 2:
			char ch0 = str.charAt(0);
			char ch1 = str.charAt(1);
			char[] output2 = new char[outputLength];
			for (int i = repeat * 2 - 2; i >= 0; i--, i--) {
				output2[i] = ch0;
				output2[i + 1] = ch1;
			}
			return new String(output2);
		default:
			StringBuilder buf = new StringBuilder(outputLength);
			for (int i = 0; i < repeat; i++) {
				buf.append(str);
			}
			return buf.toString();
		}
	}
	/**
	 * <p>
	 * 将某个字符重复N次.
	 * </p>
	 *
	 * @param ch
	 *            某个字符
	 * @param repeat
	 *            重复次数
	 * @return String
	 */
	public static String repeat(char ch, int repeat) {
		char[] buf = new char[repeat];
		for (int i = repeat - 1; i >= 0; i--) {
			buf[i] = ch;
		}
		return new String(buf);
	}
	
	/**
	 * <p>
	 * 将一个字符串重复N次，并且中间加上指定的分隔符
	 * </p>
	 *
	 * <pre>
	 * StringUtil.repeat(null, null, 2) = null
	 * StringUtil.repeat(null, "x", 2)  = null
	 * StringUtil.repeat("", null, 0)   = ""
	 * StringUtil.repeat("", "", 2)     = ""
	 * StringUtil.repeat("", "x", 3)    = "xxx"
	 * StringUtil.repeat("?", ", ", 3)  = "?, ?, ?"
	 * </pre>
	 *
	 * @param str
	 *            源字符串
	 * @param separator
	 *            分隔符
	 * @param repeat
	 *            重复次数
	 * @return String
	 */
	public static String repeat(String str, String separator, int repeat) {
		if (str == null || separator == null) {
			return repeat(str, repeat);
		} else {
			// given that repeat(String, int) is quite optimized, better to rely
			// on it than try and splice this into it
			String result = repeat(str + separator, repeat);
			return removeEnd(result, separator);
		}			
	}
	
	/**
	 * <p>
	 * 检查是否都是大写.
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.isAllUpperCase(null)   = false
	 * StringUtil.isAllUpperCase("")     = false
	 * StringUtil.isAllUpperCase("  ")   = false
	 * StringUtil.isAllUpperCase("ABC")  = true
	 * StringUtil.isAllUpperCase("aBC") = false
	 * </pre>
	 *
	 * @param cs
	 *            源字符串
	 * @return String
	 */
	public static boolean isAllUpperCase(String cs) {
		if (cs == null || isEmpty(cs)) {
			return false;
		}
		int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isUpperCase(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * <p>
	 * 检查字符串是否全部为小写.
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.isAllLowerCase(null)   = false
	 * StringUtil.isAllLowerCase("")     = false
	 * StringUtil.isAllLowerCase("  ")   = false
	 * StringUtil.isAllLowerCase("abc")  = true
	 * StringUtil.isAllLowerCase("abC") = false
	 * </pre>
	 *
	 * @param cs
	 *            源字符串
	 * @return String
	 */
	public static boolean isAllLowerCase(String cs) {
		if (cs == null || isEmpty(cs)) {
			return false;
		}
		int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isLowerCase(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * <p>
	 * 反转字符串.
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.reverse(null)  = null
	 * StringUtil.reverse("")    = ""
	 * StringUtil.reverse("bat") = "tab"
	 * </pre>
	 *
	 * @param str
	 *            源字符串
	 * @return String
	 */
	public static String reverse(String str) {
		if (str == null) {
			return null;
		}
		return new StringBuilder(str).reverse().toString();
	}
    
	
	/**
	 * <p>
	 * 字符串达不到一定长度时在右边补空白.
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.rightPad(null, *)   = null
	 * StringUtil.rightPad("", 3)     = "   "
	 * StringUtil.rightPad("bat", 3)  = "bat"
	 * StringUtil.rightPad("bat", 5)  = "bat  "
	 * StringUtil.rightPad("bat", 1)  = "bat"
	 * StringUtil.rightPad("bat", -1) = "bat"
	 * </pre>
	 *
	 * @param str
	 *            源字符串
	 * @param size
	 *            指定的长度
	 * @return String
	 */
	public static String rightPad(String str, int size) {
		return rightPad(str, size, ' ');
	}
	
	/**
	 * <p>
	 * 字符串长度达不到指定长度时，在字符串右边补指定的字符.
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.rightPad(null, *, *)     = null
	 * StringUtil.rightPad("", 3, 'z')     = "zzz"
	 * StringUtil.rightPad("bat", 3, 'z')  = "bat"
	 * StringUtil.rightPad("bat", 5, 'z')  = "batzz"
	 * StringUtil.rightPad("bat", 1, 'z')  = "bat"
	 * StringUtil.rightPad("bat", -1, 'z') = "bat"
	 * </pre>
	 *
	 * @param str
	 *            源字符串
	 * @param size
	 *            指定的长度
	 * @param padChar
	 *            进行补充的字符
	 * @return String
	 */
	public static String rightPad(String str, int size, char padChar) {
		if (str == null) {
			return null;
		}
		int pads = size - str.length();
		if (pads <= 0) {
			return str; // returns original String when possible
		}
		if (pads > PAD_LIMIT) {
			return rightPad(str, size, String.valueOf(padChar));
		}
		return str.concat(repeat(padChar, pads));
	}
	
	/**
	 * <p>
	 * 扩大字符串长度，从左边补充指定字符
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.rightPad(null, *, *)      = null
	 * StringUtil.rightPad("", 3, "z")      = "zzz"
	 * StringUtil.rightPad("bat", 3, "yz")  = "bat"
	 * StringUtil.rightPad("bat", 5, "yz")  = "batyz"
	 * StringUtil.rightPad("bat", 8, "yz")  = "batyzyzy"
	 * StringUtil.rightPad("bat", 1, "yz")  = "bat"
	 * StringUtil.rightPad("bat", -1, "yz") = "bat"
	 * StringUtil.rightPad("bat", 5, null)  = "bat  "
	 * StringUtil.rightPad("bat", 5, "")    = "bat  "
	 * </pre>
	 *
	 * @param str
	 *            源字符串
	 * @param size
	 *            扩大后的长度
	 * @param padStr
	 *            在右边补充的字符串
	 * @return String
	 */
	public static String rightPad(String str, int size, String padStr) {
		if (str == null) {
			return null;
		}
		if (isEmpty(padStr)) {
			padStr = " ";
		}
		int padLen = padStr.length();
		int strLen = str.length();
		int pads = size - strLen;
		if (pads <= 0) {
			return str; // returns original String when possible
		}
		if (padLen == 1 && pads <= PAD_LIMIT) {
			return rightPad(str, size, padStr.charAt(0));
		}

		if (pads == padLen) {
			return str.concat(padStr);
		} else if (pads < padLen) {
			return str.concat(padStr.substring(0, pads));
		} else {
			char[] padding = new char[pads];
			char[] padChars = padStr.toCharArray();
			for (int i = 0; i < pads; i++) {
				padding[i] = padChars[i % padLen];
			}
			return str.concat(new String(padding));
		}
	}
	
	/**
	 * 从右边截取字符串.</p>
	 * 
	 * <pre>
	 * StringUtil.right(null, *)    = null
	 * StringUtil.right(*, -ve)     = ""
	 * StringUtil.right("", *)      = ""
	 * StringUtil.right("abc", 0)   = ""
	 * StringUtil.right("abc", 2)   = "bc"
	 * StringUtil.right("abc", 4)   = "abc"
	 * </pre>
	 * 
	 * @param str
	 *            源字符串
	 * @param len
	 *            长度
	 * @return String
	 */
	public static String right(String str, int len) {
		if (str == null) {
			return null;
		}
		if (len < 0) {
			return EMPTY;
		}
		if (str.length() <= len) {
			return str;
		}
		return str.substring(str.length() - len);
	}
	
	/**
	 * <p>
	 * 截取一个字符串的前几个.
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.left(null, *)    = null
	 * StringUtil.left(*, -ve)     = ""
	 * StringUtil.left("", *)      = ""
	 * StringUtil.left("abc", 0)   = ""
	 * StringUtil.left("abc", 2)   = "ab"
	 * StringUtil.left("abc", 4)   = "abc"
	 * </pre>
	 * 
	 * @param str
	 *            源字符串
	 * @param len
	 *            截取的长度
	 * @return the String
	 */
	public static String left(String str, int len) {
		if (str == null) {
			return null;
		}
		if (len < 0) {
			return EMPTY;
		}
		if (str.length() <= len) {
			return str;
		}
		return str.substring(0, len);
	}
	
	/**
	 * <p>
	 * 得到tag字符串中间的子字符串，只返回第一个匹配项。
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.substringBetween(null, *)            = null
	 * StringUtil.substringBetween("", "")             = ""
	 * StringUtil.substringBetween("", "tag")          = null
	 * StringUtil.substringBetween("tagabctag", null)  = null
	 * StringUtil.substringBetween("tagabctag", "")    = ""
	 * StringUtil.substringBetween("tagabctag", "tag") = "abc"
	 * </pre>
	 * 
	 * @param str
	 *            源字符串。
	 * @param tag
	 *            标识字符串。
	 * @return String 子字符串, 如果没有符合要求的，返回{@code null}。
	 */
	public static String substringBetween(String str, String tag) {
		return substringBetween(str, tag, tag);
	}
	
	/**
	 * <p>
	 * 得到两个字符串中间的子字符串，只返回第一个匹配项。
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.substringBetween("wx[b]yz", "[", "]") = "b"
	 * StringUtil.substringBetween(null, *, *)          = null
	 * StringUtil.substringBetween(*, null, *)          = null
	 * StringUtil.substringBetween(*, *, null)          = null
	 * StringUtil.substringBetween("", "", "")          = ""
	 * StringUtil.substringBetween("", "", "]")         = null
	 * StringUtil.substringBetween("", "[", "]")        = null
	 * StringUtil.substringBetween("yabcz", "", "")     = ""
	 * StringUtil.substringBetween("yabcz", "y", "z")   = "abc"
	 * StringUtil.substringBetween("yabczyabcz", "y", "z")   = "abc"
	 * </pre>
	 * 
	 * @param str
	 *            源字符串
	 * @param open
	 *            起字符串。
	 * @param close
	 *            末字符串。
	 * @return String 子字符串, 如果没有符合要求的，返回{@code null}。
	 */
	public static String substringBetween(String str, String open, String close) {
		if (str == null || open == null || close == null) {
			return null;
		}
		int start = str.indexOf(open);
		if (start != INDEX_NOT_FOUND) {
			int end = str.indexOf(close, start + open.length());
			if (end != INDEX_NOT_FOUND) {
				return str.substring(start + open.length(), end);
			}
		}
		return null;
	}
	
	/**
	 * <p>
	 * 得到两个字符串中间的子字符串，所有匹配项组合为数组并返回。
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.substringsBetween("[a][b][c]", "[", "]") = ["a","b","c"]
	 * StringUtil.substringsBetween(null, *, *)            = null
	 * StringUtil.substringsBetween(*, null, *)            = null
	 * StringUtil.substringsBetween(*, *, null)            = null
	 * StringUtil.substringsBetween("", "[", "]")          = []
	 * </pre>
	 *
	 * @param str
	 *            源字符串
	 * @param open
	 *            起字符串。
	 * @param close
	 *            末字符串。
	 * @return String 子字符串数组, 如果没有符合要求的，返回{@code null}。
	 */
	public static String[] substringsBetween(String str, String open,
			String close) {
		if (str == null || isEmpty(open) || isEmpty(close)) {
			return null;
		}
		int strLen = str.length();
		if (strLen == 0) {
			return new String[0];
		}
		int closeLen = close.length();
		int openLen = open.length();
		List<String> list = new ArrayList<String>();
		int pos = 0;
		while (pos < strLen - closeLen) {
			int start = str.indexOf(open, pos);
			if (start < 0) {
				break;
			}
			start += openLen;
			int end = str.indexOf(close, start);
			if (end < 0) {
				break;
			}
			list.add(str.substring(start, end));
			pos = end + closeLen;
		}
		if (list.isEmpty()) {
			return null;
		}
		return list.toArray(new String[list.size()]);
	}

	/**
	 * 功能：切换字符串中的所有字母大小写。<br/>
	 * 
	 * <pre>
	 * StringUtil.swapCase(null)                 = null
	 * StringUtil.swapCase("")                   = ""
	 * StringUtil.swapCase("The dog has a BONE") = "tHE DOG HAS A bone"
	 * </pre>
	 * 
	 *
	 * @param str
	 *            源字符串
	 * @return String
	 */
	public static String swapCase(String str) {
		if (StringUtil.isEmpty(str)) {
			return str;
		}
		char[] buffer = str.toCharArray();

		boolean whitespace = true;

		for (int i = 0; i < buffer.length; i++) {
			char ch = buffer[i];
			if (Character.isUpperCase(ch)) {
				buffer[i] = Character.toLowerCase(ch);
				whitespace = false;
			} else if (Character.isTitleCase(ch)) {
				buffer[i] = Character.toLowerCase(ch);
				whitespace = false;
			} else if (Character.isLowerCase(ch)) {
				if (whitespace) {
					buffer[i] = Character.toTitleCase(ch);
					whitespace = false;
				} else {
					buffer[i] = Character.toUpperCase(ch);
				}
			} else {
				whitespace = Character.isWhitespace(ch);
			}
		}
		return new String(buffer);
	}

	/**
	 * 功能：截取出最后一个标志位之后的字符串.<br/>
	 * 如果sourceStr为empty或者expr为null，直接返回源字符串。<br/>
	 * 如果expr长度为0，直接返回sourceStr。<br/>
	 * 如果expr在sourceStr中不存在，直接返回sourceStr。<br/>
	 * 
	 * @author 宋立君
	 * @date 2014年06月24日
	 * @param sourceStr
	 *            被截取的字符串
	 * @param expr
	 *            分隔符
	 * @return String
	 */
	public static String substringAfterLast(String sourceStr, String expr) {
		if (isEmpty(sourceStr) || expr == null) {
			return sourceStr;
		}
		if (expr.length() == 0) {
			return sourceStr;
		}

		int pos = sourceStr.lastIndexOf(expr);
		if (pos == -1) {
			return sourceStr;
		}
		return sourceStr.substring(pos + expr.length());
	}

	/**
	 * 功能：截取出最后一个标志位之前的字符串.<br/>
	 * 如果sourceStr为empty或者expr为null，直接返回源字符串。<br/>
	 * 如果expr长度为0，直接返回sourceStr。<br/>
	 * 如果expr在sourceStr中不存在，直接返回sourceStr。<br/>
	 * 
	 * @author 宋立君
	 * @date 2014年06月24日
	 * @param sourceStr
	 *            被截取的字符串
	 * @param expr
	 *            分隔符
	 * @return String
	 */
	public static String substringBeforeLast(String sourceStr, String expr) {
		if (isEmpty(sourceStr) || expr == null) {
			return sourceStr;
		}
		if (expr.length() == 0) {
			return sourceStr;
		}
		int pos = sourceStr.lastIndexOf(expr);
		if (pos == -1) {
			return sourceStr;
		}
		return sourceStr.substring(0, pos);
	}

	/**
	 * 功能：截取出第一个标志位之后的字符串.<br/>
	 * 如果sourceStr为empty或者expr为null，直接返回源字符串。<br/>
	 * 如果expr长度为0，直接返回sourceStr。<br/>
	 * 如果expr在sourceStr中不存在，直接返回sourceStr。<br/>
	 * 
	 * @author 宋立君
	 * @date 2014年06月24日
	 * @param sourceStr
	 *            被截取的字符串
	 * @param expr
	 *            分隔符
	 * @return String
	 */
	public static String substringAfter(String sourceStr, String expr) {
		if (isEmpty(sourceStr) || expr == null) {
			return sourceStr;
		}
		if (expr.length() == 0) {
			return sourceStr;
		}

		int pos = sourceStr.indexOf(expr);
		if (pos == -1) {
			return sourceStr;
		}
		return sourceStr.substring(pos + expr.length());
	}

	/**
	 * 功能：截取出第一个标志位之前的字符串.<br/>
	 * 如果sourceStr为empty或者expr为null，直接返回源字符串。<br/>
	 * 如果expr长度为0，直接返回sourceStr。<br/>
	 * 如果expr在sourceStr中不存在，直接返回sourceStr。<br/>
	 * 如果expr在sourceStr中存在不止一个，以第一个位置为准。
	 * 
	 * @author 宋立君
	 * @date 2014年06月24日
	 * @param sourceStr
	 *            被截取的字符串
	 * @param expr
	 *            分隔符
	 * @return String
	 */
	public static String substringBefore(String sourceStr, String expr) {
		if (isEmpty(sourceStr) || expr == null) {
			return sourceStr;
		}
		if (expr.length() == 0) {
			return sourceStr;
		}
		int pos = sourceStr.indexOf(expr);
		if (pos == -1) {
			return sourceStr;
		}
		return sourceStr.substring(0, pos);
	}

	

	/**
	 * 如果字符串没有超过最长显示长度返回原字符串，否则从开头截取指定长度并加...返回。
	 * 
	 * @param str
	 *            原字符串
	 * @param length
	 *            字符串最长显示的长度
	 * @return 转换后的字符串
	 */
	public static String trimString(String str, int length) {
		if (str == null) {
			return "";
		} else if (str.length() > length) {
			return str.substring(0, length - 3) + "...";
		} else {
			return str;
		}
	}
	
	/**
     * 一次性判断多个或单个对象为空。
     * @param objects
     * @author cai niao
     * @return 只要有一个元素为Blank，则返回true
     */
	public static boolean isBlank(Object...objects){
        Boolean result = false ;
        for (Object object : objects) {
            if(object == null || "".equals(object.toString().trim()) 
                    || "null".equals(object.toString().trim())
                    || "[null]".equals(object.toString().trim())
                    || "[]".equals(object.toString().trim())){
                result = true ; 
                break ; 
            }
        }
        return result ; 
    }
	
	 /**
	    * 计算两个日期之间相差的月数
	    * @param date1
	    * @param date2
	    * @return
	    */
	    public static int getMonths(Date date1, Date date2) {
	       int iMonth = 0;
	        int flag = 0;
	        try {
	            Calendar objCalendarDate1 = Calendar.getInstance();
	            objCalendarDate1.setTime(date1);
	            Calendar objCalendarDate2 = Calendar.getInstance();
	            objCalendarDate2.setTime(date2);
	            if (objCalendarDate2.equals(objCalendarDate1))
	                return 0;
	            if (objCalendarDate1.after(objCalendarDate2)) {
	                Calendar temp = objCalendarDate1;
	                objCalendarDate1 = objCalendarDate2;
	                objCalendarDate2 = temp;
	            }
	            if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1
	                    .get(Calendar.DAY_OF_MONTH))
	                flag = 1;

	            if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1
	                    .get(Calendar.YEAR))
	                iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1
	                        .get(Calendar.YEAR))
	                        * 12 + objCalendarDate2.get(Calendar.MONTH) - flag)
	                        - objCalendarDate1.get(Calendar.MONTH);
	            else
	                iMonth = objCalendarDate2.get(Calendar.MONTH) - objCalendarDate1.get(Calendar.MONTH) - flag;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return iMonth;
	    }

	   
	
    
	
	
	

}




	



		
	


