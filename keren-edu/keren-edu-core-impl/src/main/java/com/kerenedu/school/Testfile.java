/**
 * 
 */
package com.kerenedu.school;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import com.kerem.core.FileHelper;

/**
 * @author Nadege
 *
 */
public class Testfile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		 File file = new File("D:\\DEV_TOOLS\\serveur\\education\\jboss\\standalone\\data\\keren\\resources\\static\\M1.png");
//  	   System.out.println("EleveManagerImpl.processAfterSave() file "+file.getPath());
//         file.renameTo(new File("D:\\DEV_TOOLS\\serveur\\education\\jboss\\standalone\\data\\keren\\resources\\static"+File.separator+"M36po.png"));
////         File filerename = new File(newName);
////         try {
//////			FileHelper.copyFile(new File("D:\\DEV_TOOLS\\serveur\\education\\jboss\\standalone\\data\\keren\\resources\\static"+File.separator+"M36po.png"),
//////					new File("D:\\DEV_TOOLS\\serveur\\education\\jboss\\standalone\\data\\keren\\resources\\static\\scolarite"+File.separator+"M36po.png"));
//////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
		
		double val = 300000;
		double val1 = 7;
		
		
		  Double traite = (double) (val/val1);
		  BigDecimal bd = new BigDecimal(traite);
		bd = bd.setScale(0, BigDecimal.ROUND_UP);
		Double netarond = bd.doubleValue();
		  
		  System.out.println("Testfile.main() value "+traite);
		  System.out.println("Testfile.main() net round"+netarond);
		

	}

}
