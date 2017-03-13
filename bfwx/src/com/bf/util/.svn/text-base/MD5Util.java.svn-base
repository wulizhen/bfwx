package com.bf.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	
    // 閸忋劌鐪弫鎵矋
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public MD5Util() {
    }

     private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 鏉╂柨娲栬ぐ銏犵础閸欘亙璐熼弫鏉跨摟
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    // 鏉烆剚宕茬�妤勫Ν閺佹壆绮嶉敓锟�鏉╂稑鍩楃�妞捐
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    public static String GetMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 鐠囥儱鍤遍弫鎷岀箲閸ョ儑鎷�娑撳搫鐡ㄩ弨鎯ф惐鐢矉鎷�缂佹挻鐏夐惃鍒te閺佹壆绮�
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }
    
	 private static String byteArrayToHexString(byte b[]) {
	        StringBuffer resultSb = new StringBuffer();
	        for (int i = 0; i < b.length; i++)
	            resultSb.append(byteToHexString(b[i]));

	        return resultSb.toString();
	    }

	    private static String byteToHexString(byte b) {
	        int n = b;
	        if (n < 0)
	            n += 256;
	        int d1 = n / 16;
	        int d2 = n % 16;
	        return hexDigits[d1] + hexDigits[d2];
	    }

	    public static String MD5Encode(String origin, String charsetname) {
	        String resultString = null;
	        try {
	            resultString = new String(origin);
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            if (charsetname == null || "".equals(charsetname))
	                resultString = byteArrayToHexString(md.digest(resultString
	                        .getBytes()));
	            else
	                resultString = byteArrayToHexString(md.digest(resultString
	                        .getBytes(charsetname)));
	        } catch (Exception exception) {
	        }
	        return resultString;
	    }
	    
	    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
	        "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	    
	    public static void main(String[] args){
	    	String s=MD5Util.GetMD5Code("admin");
	    	System.out.println(s);
	    	//String w=MD5Util.GetMD5Code(s);
	    	//System.out.println(w);
	    }
	
}
