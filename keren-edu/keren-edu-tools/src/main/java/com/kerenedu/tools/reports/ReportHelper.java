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
    public static final String reportFileChemin = FileHelper.getReportsDirectory()+File.separator+"scolarite"+File.separator;
    public static final String reportFileCheminPaie = FileHelper.getReportsDirectory()+File.separator+"solde"+File.separator;
    
    public static final String reportimages = FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+"logo.png";
    
    public static final String reportimagescg = FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+"logoc.png";
    
    //public static final String templateURL = FileHelper.getReportsDirectory()+File.separator+"education"+File.separator;
    public static final String templateURL = FileHelper.getReportsDirectory()+File.separator+"scolarite"+File.separator;;
//    public static final String templatepaieURL = FileHelper.getReportsDirectory()+File.separator+"solde"+File.separator;
    public static final String templatepaieURL =FileHelper.getReportsDirectory()+File.separator+"solde"+File.separator;
    
    public static final String photourl = FileHelper.getStaticDirectory()+File.separator;
    public static final String reportimagesURL = FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator ;
    
    public static final String reportphoto = FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator ;
    
    public static final String titre1 = FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+"c.png";
    public static final String titre2 = FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+"b.png";
    
    public static final String reportimagesbgc = FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+"bgccc.png";
    public static final String reportimagesbgs = FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+"bgss.png";
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
    public static byte[] getBytescol() throws IOException
    {
    	InputStream stream = new FileInputStream(FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+"logoc.png");
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
    	InputStream stream = new FileInputStream(FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+"logoc.png");
       try (ByteArrayOutputStream os = new ByteArrayOutputStream();) {
          byte[] buffer = new byte[1024];
          for (int len = 0; (len = stream.read(buffer)) != -1;) {
             os.write(buffer, 0, len);
          }
          os.flush();
          System.out.println("ReportHelper.getBytesC() image "+os.toByteArray());
          return os.toByteArray();
       }
    }
    
    public static byte[] getBytesbgc() throws IOException
    {
    	InputStream stream = new FileInputStream(FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+"bgccc.png");
       try (ByteArrayOutputStream os = new ByteArrayOutputStream();) {
          byte[] buffer = new byte[1024];
          for (int len = 0; (len = stream.read(buffer)) != -1;) {
             os.write(buffer, 0, len);
          }
          os.flush();
          return os.toByteArray();
       }
    }
    
    public static byte[] getBytestitrcee(String image) throws IOException
    {
    	InputStream stream = new FileInputStream(FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+"c.png");
       try (ByteArrayOutputStream os = new ByteArrayOutputStream();) {
          byte[] buffer = new byte[1024];
          for (int len = 0; (len = stream.read(buffer)) != -1;) {
             os.write(buffer, 0, len);
          }
          os.flush();
          return os.toByteArray();
       }
    }
    
    public static byte[] getBytesbgs() throws IOException
    {
    	InputStream stream = new FileInputStream(FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+"bgss.png");
       try (ByteArrayOutputStream os = new ByteArrayOutputStream();) {
          byte[] buffer = new byte[1024];
          for (int len = 0; (len = stream.read(buffer)) != -1;) {
             os.write(buffer, 0, len);
          }
          os.flush();
          return os.toByteArray();
       }
    }
    
    public static byte[] getBytestitre(String value) throws IOException
    {
    	InputStream stream = new FileInputStream(value);
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
    	InputStream stream = new FileInputStream(FileHelper.getStaticDirectory()+File.separator+File.separator+"scolarite"+File.separator);
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
    	InputStream stream = new FileInputStream(FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+photoname);
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
    	//FileHelper.setCurrentModule("scolarite");
    	File tmpDir = new File(FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+photoname);
    	File tmpDirold = new File(FileHelper.getStaticDirectory()+File.separator+photoname);
    	boolean exists = tmpDir.exists();
    	boolean existsold = tmpDirold.exists();
    	if(exists){
    		stream = new FileInputStream(FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+photoname);
    	}else if(existsold){
    		stream = new FileInputStream(FileHelper.getStaticDirectory()+File.separator+photoname);
    	}
    	else{
    		stream = new FileInputStream(FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+"no.png");
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
    	File tmpDir = new File(FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+photoname);
    	File tmpDirold = new File(FileHelper.getStaticDirectory()+File.separator+photoname);
    	boolean exists = tmpDir.exists();
    	boolean existsold = tmpDirold.exists();
    	if(exists){
    		stream = new FileInputStream(FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+photoname);
    	}else if(existsold){
    		stream = new FileInputStream(FileHelper.getStaticDirectory()+File.separator+photoname);
    	}else{
    		stream = new FileInputStream(FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+"no.png");
    	}
       return stream ;
       }

}
