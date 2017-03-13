package com.bf.util;
import java.nio.charset.Charset; 
/**  
 * DES加密和解密工具,可以对字符串进行加密和解密操作  。   
 */ 
public class MDEC {
	private static final String key0 = "FECOI()*&<MNCXZPKL";  
    private static final Charset charset = Charset.forName("UTF-8");  
    private static byte[] keyBytes = key0.getBytes(charset);  
      
    public static String encode(String enc){  
        byte[] b = enc.getBytes(charset);  
        for(int i=0,size=b.length;i<size;i++){  
            for(byte keyBytes0:keyBytes){  
                b[i] = (byte) (b[i]^keyBytes0);  
            }  
        }  
        return new String(b);  
    }  
      
    public static String decode(String dec){  
        byte[] e = dec.getBytes(charset);  
        byte[] dee = e;  
        for(int i=0,size=e.length;i<size;i++){  
            for(byte keyBytes0:keyBytes){  
                e[i] = (byte) (dee[i]^keyBytes0);  
            }  
        }  
        return new String(e);  
    }  
  
    public static void main(String[] args) {  
        String s="you are right 3233";  
        String enc = encode(s);  
        String dec = decode(enc);  
        System.out.println(enc);  
        System.out.println(dec);  
    } 
}
