package com.bf.util;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.OutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.image.BufferedImage;


public final class MatrixToImageWriter {

  private static final int BLACK = 0xFF000000;
  private static final int WHITE = 0xFFFFFFFF;

  private MatrixToImageWriter() {}

  
  public static BufferedImage toBufferedImage(BitMatrix matrix) {
    int width = matrix.getWidth();
    int height = matrix.getHeight();
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
      }
    }
    return image;
  }

  
  public static void writeToFile(BitMatrix matrix, String format, File file)
      throws IOException {
    BufferedImage image = toBufferedImage(matrix);
    if (!ImageIO.write(image, format, file)) {
      throw new IOException("Could not write an image of format " + format + " to " + file);
    }
  }

  
  public static void writeToStream(BitMatrix matrix, String format, OutputStream stream)
      throws IOException {
    BufferedImage image = toBufferedImage(matrix);
    if (!ImageIO.write(image, format, stream)) {
      throw new IOException("Could not write an image of format " + format);
    }
  }

  
  //产生二维码并返回Url
  public static String getCodeUrl(String content,String path,String name){
	  try {
		     //String content = "http://www.baidu.com";
		    // String path = "C:/Users/Administrator/Desktop"; 
		     MultiFormatWriter multiFormatWriter = new MultiFormatWriter();  
		     Map hints = new HashMap();
		     hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		     BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400,hints);
		     File file1 = new File(path,name+".jpg");
		     MatrixToImageWriter.writeToFile(bitMatrix, "jpg", file1);  
		     return path+name+".jpg";
		 } catch (Exception e) {
		     e.printStackTrace();
		 }
		 return null;
  }
  
  
  public static void main(String[] args) {
	
		     String a = "呼呼会uigui";
		     String b = "C:/Users/Administrator/Desktop/"; 
		     String c="code";
		     System.out.println(getCodeUrl(a,b,c));
   }
}
