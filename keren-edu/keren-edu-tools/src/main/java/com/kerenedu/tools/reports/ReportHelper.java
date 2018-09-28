/**
 *
 */
package com.kerenedu.tools.reports;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

import com.kerem.core.FileHelper;

/**
 * @author <a href="mailto:ntchuenna@yahoo.fr">nadège Tchuente</a>
 * 22 sept. 2016
 */
public class ReportHelper {

    /**
     * Chemin de base des report
     */
    //public static final String reportFileChemin = "src/main/resources/reports/";
    public static final String reportFileChemin = FileHelper.getReportsDirectory()+File.separator+"education"+File.separator;
    
    public static final String reportimages = FileHelper.getReportsDirectory()+File.separator+"education"+File.separator+"images"+File.separator+"logo.png";
    
    public static final String reportimagescg = FileHelper.getReportsDirectory()+File.separator+"education"+File.separator+"images"+File.separator+"logoc.png";
    
    public static final String templateURL = FileHelper.getReportsDirectory()+File.separator+"education"+File.separator;
    
    public static final String photourl = FileHelper.getStaticDirectory()+File.separator;
    public static final String reportimagesURL = FileHelper.getReportsDirectory()+File.separator+"education"+File.separator+"images"+File.separator ;
    
    public static final String reportphoto = FileHelper.getReportsDirectory()+File.separator+"education"+File.separator+"photomin"+File.separator ;
    /**
     * Chemin de base des report
     */
    /**
     * Gestionnaire de message
     */
    private static ResourceBundle bundle = null;

    private static String fileName = "reports/report_FR";//"com/megatim/tools/messages";   

    private ReportHelper() {
        //MessagesBundle.fileName = fielName;
        if (bundle == null) {
            bundle = ResourceBundle.getBundle(fileName);
        }
    }

    /**
     *
     * @param fileName
     */
    public static void setFileName(String fileName) {
        ReportHelper.fileName = fileName;
    }

    /**
     *
     * @param bundle
     */
    public static void setBundle(ResourceBundle bundle) {
        ReportHelper.bundle = bundle;
    }

    /**
     * Renvoi le message correspondant a une cle
     *
     * @param key
     * @return
     */
    public static String getResource(String key) {

        try {
            //   System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::  "+key+"  :::: "+bundle);
            if (bundle == null) {
                new ReportHelper();
            }
            //  System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::  "+key+"  :::: "+bundle.getString(key));
            return bundle.getString(key);

        } catch (Exception ex) {
            return key;
        }
    }

    public static synchronized ResourceBundle getInstace() {

        if (bundle == null) {
            new ReportHelper();
        }
        return bundle;
    }

    public static synchronized ResourceBundle getInstace(String fileName) {

        ReportHelper.fileName = fileName;

        if (bundle == null) {
            new ReportHelper();
        }
        return bundle;
    }
    
    public static byte[] getBytes() throws IOException
    {
    	InputStream stream = new FileInputStream(reportimages);
       try (ByteArrayOutputStream os = new ByteArrayOutputStream();) {
          byte[] buffer = new byte[1024];
          for (int len = 0; (len = stream.read(buffer)) != -1;) {
             os.write(buffer, 0, len);
          }
          os.flush();
          return os.toByteArray();
       }
    }
    public static byte[] getBytesC() throws IOException
    {
    	InputStream stream = new FileInputStream(reportimagescg);
       try (ByteArrayOutputStream os = new ByteArrayOutputStream();) {
          byte[] buffer = new byte[1024];
          for (int len = 0; (len = stream.read(buffer)) != -1;) {
             os.write(buffer, 0, len);
          }
          os.flush();
          return os.toByteArray();
       }
    }

    public static byte[] getBytes(String name) throws IOException
    {
    	InputStream stream = new FileInputStream(photourl);
       try (ByteArrayOutputStream os = new ByteArrayOutputStream();) {
          byte[] buffer = new byte[1024];
          for (int len = 0; (len = stream.read(buffer)) != -1;) {
             os.write(buffer, 0, len);
          }
          os.flush();
          return os.toByteArray();
       }
    }
    
    public static File getPhotoDirectory(){
        File binDirectory = FileHelper.getCurrentDirectory();        
        return new File(binDirectory.getParent()+File.separator+reportphoto);
   }
    
    public static String getReportPhoto(){
    	
    	return reportphoto ;
    }
    public static byte[] getPhotoBytes(String photoname) throws IOException
    {
    	InputStream stream = new FileInputStream(photourl+photoname);
       try (ByteArrayOutputStream os = new ByteArrayOutputStream();) {
          byte[] buffer = new byte[1024];
          for (int len = 0; (len = stream.read(buffer)) != -1;) {
             os.write(buffer, 0, len);
          }
          os.flush();
          return os.toByteArray();
       }
    }
    
    public static byte[] getPhotoBytesEleve(String photoname) throws IOException
    {
    	System.out.println("ReportHelper.getPhotoBytesEleve() construire la photo ");
    	InputStream stream ;
    	File tmpDir = new File(FileHelper.getStaticDirectory()+File.separator+photoname);
    	boolean exists = tmpDir.exists();
    	if(exists){
    		stream = new FileInputStream(FileHelper.getStaticDirectory()+File.separator+photoname);
    	}else{
    		stream = new FileInputStream(FileHelper.getStaticDirectory()+File.separator+"no.png");
    	}
       try (ByteArrayOutputStream os = new ByteArrayOutputStream();) {
          byte[] buffer = new byte[1024];
          for (int len = 0; (len = stream.read(buffer)) != -1;) {
             os.write(buffer, 0, len);
          }
          os.flush();
          return os.toByteArray();
       }
    }
    
    public static InputStream getPhotoBytesstream(String photoname) throws IOException
    {
    	System.out.println("ReportHelper.getPhotoBytesEleve() construire la photo ");
    	InputStream stream ;
    	File tmpDir = new File(reportphoto+photoname);
    	boolean exists = tmpDir.exists();
    	if(exists){
    		stream = new FileInputStream(reportphoto+photoname);
    	}else{
    		stream = new FileInputStream(reportphoto+"no.png");
    	}
       return stream ;
       }

}
