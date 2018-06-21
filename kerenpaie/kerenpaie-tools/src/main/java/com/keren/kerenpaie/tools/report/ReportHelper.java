/**
 *
 */
package com.keren.kerenpaie.tools.report;

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
	 public static final String reportFileChemin = FileHelper.getReportsDirectory()+File.separator+"rhpaie"+File.separator;
    
    public static final String templateURL = FileHelper.getReportsDirectory()+File.separator+"rhpaie"+File.separator;
    
    public static final String reportimages = FileHelper.getReportsDirectory()+File.separator+"rhpaie"+File.separator+"images"+File.separator+"logo.png";
    /**
     * Chemin de base des report
     */
    /**
     * Gestionnaire de message
     */
    private static ResourceBundle bundle = null;

    private static String fileName = "reports/report_FR";   

    private ReportHelper() {
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
            if (bundle == null) {
                new ReportHelper();
            }
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

}
