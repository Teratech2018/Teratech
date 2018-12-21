/**
 *
 */
package com.megatimgroup.ebaytools.reporting;

import java.io.File;
import java.util.ResourceBundle;

/**
 * @author <a href="mailto:ntchuenna@yahoo.fr">nadège Tchuente</a>
 * 22 sept. 2016
 */
public class ReportHelper {

    /**
     * Chemin de base des report
     */
   // public static final String reportFileChemin = "src/main/resources/reports/";
    public static final String reportFileChemin = System.getProperty("user.dir") + File.separator + "/reports/";
    /**
     * Chemin de base des report
     */

 //   public static final byte[] reportFileimage = CurrentSessionInformations.getCurrentSociete().getLogo() ;
    public static final String societeName = "";//CurrentSessionInformations.getCurrentSociete().getCode();
    public static final String userName = "";//CurrentSessionInformations.getCurrentUser().getNom(); //"Administrateur";//
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

}
