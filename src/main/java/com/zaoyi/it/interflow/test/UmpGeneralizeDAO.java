package com.zaoyi.it.interflow.test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.net.ssl.HttpsURLConnection;

public class UmpGeneralizeDAO {
	
	
	public void replaceImageColor(String file, Color srcColor, Color targetColor) throws IOException{
        URL http;
        if(file.trim().startsWith("https")){
            http = new URL(file);
            HttpsURLConnection conn = (HttpsURLConnection) http.openConnection();
            conn.setRequestMethod("GET"); 
        }else if(file.trim().startsWith("http")){
            http = new URL(file);
            HttpURLConnection conn = (HttpURLConnection) http.openConnection();
            conn.setRequestMethod("GET"); 
        }else{
            http = new File(file).toURI().toURL();
        }
        BufferedImage bi = ImageIO.read(http.openStream());
        
        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                  System.out.println(bi.getRGB(i, j));
                  if(srcColor.getRGB()==bi.getRGB(i, j)){
                      System.out.println(i+","+j+"  from:"+srcColor.getRGB()+"to"+targetColor.getRGB());
                      bi.setRGB(i, j, targetColor.getRGB());
                  }
            }
        }
        Iterator<ImageWriter> it = ImageIO.getImageWritersByFormatName("png");
        ImageWriter writer = it.next();
        File f = new File("c://test02.png");
        ImageOutputStream ios = ImageIO.createImageOutputStream(f);
        writer.setOutput(ios);
        writer.write(bi);
        bi.flush();
        ios.flush();
        ios.close();
    }
    
    public void createImage(int width, int height) throws IOException{
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D graphic = bi.createGraphics();
        graphic.setColor(new Color(0.2f,0.3f,0.4f,0.4f));
        graphic.fillRect(0, 0, width, height);
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                  //result[i][j] = bi.getRGB(i, j) & 0xFFFFFF;
                  System.out.println(bi.getRGB(i, j));
                 // bi.setRGB(i, j, 0xFFFFFF);
            }
       }
        
        Iterator<ImageWriter> it = ImageIO.getImageWritersByFormatName("png");
        ImageWriter writer = it.next();
        File f = new File("c://test02.png");
        ImageOutputStream ios = ImageIO.createImageOutputStream(f);
        writer.setOutput(ios);
        
        writer.write(bi);
    }
    
	public static void main(String[] args) {
		File file = new File("C:\\12.png");
		FileChannel fc = null;
		if (file.exists() && file.isFile()) {
			try {
				FileInputStream fs = new FileInputStream(file);
				fc = fs.getChannel();
				System.out.println(fc.size() + "-----fc.size()");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(file.length() + "-----file.length  B");
		System.out.println(file.length() * 1024 + "-----file.length  kb");
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int width = bi.getWidth();
		int height = bi.getHeight();

		System.out.println("宽：像素-----" + width + "高：像素" + height);

	}
}
