/**
 * 
 */
package com.megatimgroup.views.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.JDialog;
import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseParameter;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

import com.megatimgroup.ebaytools.reporting.ReportHelper;
import com.megatimgroup.ebaytools.reporting.ReportsName;
import com.megatimgroup.ebaytools.reporting.ReportsParameter;
import com.megatimgroup.model.reporting.BordereauBP;

/**
 * @author mgt
 *
 */
public class PreviewBordereauBP {
	
	  /**
    *
    * @throws Exception
    * @throws Exception
    */

   public static void imprimer(BordereauBP bordereau) throws Exception {


       List<BordereauBP> datas = new ArrayList<BordereauBP>();
 
    	   List<BordereauBP> resultat = new ArrayList<BordereauBP>();
    	   resultat.add(bordereau);
           datas = resultat;
     //  }
       String reportFilePath = getJasperFileName();
       // Si le fichier ne se termine pas par .jasper
       if (!reportFilePath.endsWith(".jasper")) {
           reportFilePath = reportFilePath + ".jasper";
       }

       // Creation d'un File sur le fichier
       File reportFile = new File(reportFilePath);
       // System.out.println("le nom du fichier jasper a afficher :" +
       // reportFile);
       // Si l'objet n'existe pas
       if (!reportFile.exists()) {
           throw new RuntimeException(
                   "ebay.report.helper.buildreport.reportfile.notexist");
       }

       // Si l'objet n'est pas un fichier
       if (!reportFile.isFile()) {
           throw new RuntimeException(
                   "ebay.report.helper.buildreport.reportfile.notexist");
       }

       // Chargement du Rapport
       JasperReport report = null;

       // Etat rempli
       JasperPrint jasperPrint = null;

       // Chargement du report
       report = (JasperReport) JRLoader.loadObject(reportFile);
       jasperPrint = JasperFillManager.fillReport(report, getReportParameters(), new JRBeanCollectionDataSource(datas,
                       false));
       
       // - exporter le bordereaun dans un repport to pdf
       JasperExportManager.exportReportToPdfFile(jasperPrint, bordereau.getReportFiledeport()+"\\"+ReportsName.Bordereau_BP.getName()+".pdf");
       // export to .docx
       JRDocxExporter docxExp = new JRDocxExporter();
       OutputStream output = new FileOutputStream(bordereau.getReportFiledeport()+"\\"+ReportsName.Bordereau_BP.getName()+".docx");
		docxExp.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		docxExp.setParameter(JRExporterParameter.OUTPUT_STREAM, output);
		docxExp.exportReport();

       // Presentation de l'etat
       showReport(jasperPrint);

   }
   private static JFrame getApplicationFrame() {
       return com.megatimgroup.views.principal.PrincipalScreen.FRAME ;
   }
   /**
    * Methode de presentation d'un etat
    *
    * @param jasperPrint Etat à afficher
    */
   private static void showReport(JasperPrint jasperPrint) throws Exception {

       // Si le fichier jasper est null, arret
       if (jasperPrint == null) {
           return;
       }

       // Creation du viewer
       JRViewer jrViewer = new JRViewer(jasperPrint);

       // Creation de la boite de dilogue
       JDialog dialog = new JDialog(getApplicationFrame());

       // Injection du viewer dans la boite de dialogue
       dialog.getContentPane().add(jrViewer);

       // Gestion de la fermeture de la boite
       dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

       // Titre de la boite
       dialog.setTitle("Bordereau Balance de Paiement");

       // set modal a true
       dialog.setModal(true);
       // Dimension de la boite
       dialog.setSize(1300, 700);

       // dialog.pack();
       // Centrage de la boite sur l'IHM
       dialog.setLocationRelativeTo(getApplicationFrame());
       dialog.setVisible(true);

   }


  private static Map getReportParameters() {
      
      Map params = new HashMap();
      // ajout des paramètres
      params.put(ReportsParameter.DATE_DEBUT, new Date());
      params.put(ReportsParameter.DATE_FIN, new Date());
      params.put(ReportsParameter.SOCIETE_NAME, ReportHelper.societeName);
      params.put(ReportsParameter.REPORT_USER, ReportHelper.userName);
      // On positionne la locale
      params.put(JRBaseParameter.REPORT_LOCALE, Locale.FRENCH);
      // Construction du Bundle
      ResourceBundle bundle = ReportHelper.getInstace();
      // Ajout du bundle dans les parametres
      params.put(JRBaseParameter.REPORT_RESOURCE_BUNDLE, bundle);
     // params.put(ReportsParameter.REPORT_IMAGE_REPOSITORY, ReportHelper.reportFileimage);
      return params ; 
  }

  /**
   * Methode permettant de retourner le nom du fichier Jasper
   * 
   * @return
   *     java.lang.String
   */

 private static String getJasperFileName() {
  	
  	 String report = ReportHelper.reportFileChemin + ReportsName.Bordereau_BP.getName();  
      return report;
  }

}
