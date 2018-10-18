package com.core.base;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class CompressorImage {

	 public static void main(String args[]) throws Exception { 
		 //    String reperttoire = "C:\\Users\\ABEGA ABEGA SERGE\\Desktop\\pdf";
		  String reperttoire ="C:\\Users\\Nadege\\Desktop\\newphoto";//"D:\\DEV_TOOLS\\serveur\\education\\jboss\\standalone\\data\\keren\\resources\\templates\\education\\photo";
		  File listeFiles  = new File(reperttoire);
	    	        
	        for(int i = 0; i<listeFiles.listFiles().length; i++){
	            System.out.println(" ==================== "+listeFiles.listFiles()[i].getAbsolutePath());
	            
	            //Compresser
	            ecrire(listeFiles.listFiles()[i].getAbsolutePath());
	            
	            //Redimensionner
	            resizeImage(listeFiles.listFiles()[i].getAbsolutePath(), listeFiles.listFiles()[i].getName(), 0.5);
	        }
	    }
	 
	  public static void ecrire(String filePath) throws FileNotFoundException, IOException{
	        
	        File input = new File(filePath);
	        BufferedImage image = ImageIO.read(input);

	        File compressedImageFile = new File(filePath);  
	        OutputStream os = new FileOutputStream(compressedImageFile);

	        Iterator<ImageWriter>writers = ImageIO.getImageWritersByFormatName("png");
	        ImageWriter writer = (ImageWriter) writers.next();

	        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
	        writer.setOutput(ios);
	        
	        ImageWriteParam param = writer.getDefaultWriteParam();
	        
	        // Check if canWriteCompressed is true
	        if(param.canWriteCompressed()) {
	           param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
	           param.setCompressionQuality(0.3f);
	        }

	        // End of check
	        writer.write(null, new IIOImage(image, null, null), param);
	    }
	  
	  
	    public static void resizeImage(String filePath, String nameFile, double factor) {
	        
	        try {
	            BufferedImage bImage = ImageIO.read(new File(filePath));
	            int destWidth=(int) (bImage.getWidth() * factor);
	            int destHeight=(int) (bImage.getHeight() * factor);
	//créer l'image de destination
	            GraphicsConfiguration configuration = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
	            BufferedImage bImageNew = configuration.createCompatibleImage(destWidth, destHeight);
	            Graphics2D graphics = bImageNew.createGraphics();
	            graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	            graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
	            //dessiner l'image de destination
	            graphics.drawImage(bImage, 0, 0, destWidth, destHeight, 0, 0, bImage.getWidth(), bImage.getHeight(), null);
	            graphics.dispose();
	            
	            //BufferedImage imgnew=scale(img, 10);
	            ImageIO.write(bImageNew, getExtension(nameFile), new File(filePath));
	            
	            //return bImageNew;
	        } catch (IOException ex) {
	            Logger.getLogger(CompressorImage.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    private static String getExtension(String nameFile){
	        
	        try {
	            return nameFile.substring(nameFile.lastIndexOf(".") + 1);
	        } catch (Exception e) {
	            return "";
	        }
	    }
}
