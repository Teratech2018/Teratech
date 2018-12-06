/**
 * 
 */
package com.kerenedu.jaxrs.impl.report;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.ibm.icu.text.RuleBasedNumberFormat;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.school.Eleve;
import com.kerenedu.solde.BulletinPaie;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsParameter;

import net.sf.jasperreports.engine.base.JRBaseParameter;

/**
 * @author Nadege
 *
 */
public class ReportHelperTrt {

	/**
     * Methode permettant de retourner les parametres pour le reporting
     *
     * @return java.util.Map
     */
	 public static Map getReportParameters() {
	        Map params = new HashMap();
	        params.put(ReportsParameter.ANNEE_SCOLAIRE, CacheMemory.getCurrentannee());
	        params.put(ReportsParameter.CYCLE_SCOLAIRE, CacheMemory.getCurrentannee());
	        params.put(ReportsParameter.REPORT_USER,CacheMemory.getCurrentuser());

	        // On positionne la locale
	        params.put(JRBaseParameter.REPORT_LOCALE, Locale.FRENCH);
	        // Construction du Bundle
//	        ResourceBundle bundle = ReportHelper.getInstace();
//	        // Ajout du bundle dans les parametres
//	        params.put(JRBaseParameter.REPORT_RESOURCE_BUNDLE, bundle);
//	        
	        // chemin des sous rapport
	        String report = ReportHelper.reportFileChemin;
	        
	        try {
	        	 params.put(ReportsParameter.REPORT_IMAGE_CO, ReportHelper.getBytescol());
				 params.put(ReportsParameter.REPORT_IMAGE, ReportHelper.getBytescol());
				 params.put(ReportsParameter.REPORT_IMAGE_REPOSITORY, ReportHelper.getBytes());
				 params.put(ReportsParameter.REPORT_IMAGE_REPOSITORY_CO, ReportHelper.getBytescol());
				 params.put(ReportsParameter.REPORT_IMAGE_REPOSITORY_CO_BG, ReportHelper.getBytesbgc());
				 params.put(ReportsParameter.BG_IMAGE_REPOSITORY,ReportHelper.getBytes("default.png"));
				// params.put(ReportsParameter.REPORT_IMAGE_REPOSITORY_BG, ReportHelper.getBytes("default.png"));
				
				 //params.put(ReportsParameter.REPORT_TITRE_BULL, ReportHelper.getBytestitre(ReportHelper.titre1));
				// params.put(ReportsParameter.REPORT_TITRE_BULL_2, ReportHelper.getBytestitre(ReportHelper.titre2));
				 
				 //params.put(ReportsParameter.REPORT_IMAGE_REPOSITORY_TITRE, ReportHelper.getBytestitrcee("titre.png"));
				// params.put(ReportsParameter.REPORT_IMAGE_REPOSITORY_TITRE_EN, ReportHelper.getBytestitrcee("titre.png"));
				
				 
				 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        params.put(ReportsParameter.SUBREPORT_DIR, ReportHelper.reportFileChemin);
	       

	        return params;
	    }
	 
	 public static Map getReportParametersSolde() {
	        Map params = new HashMap();
	        params.put(ReportsParameter.ANNEE_SCOLAIRE, CacheMemory.getCurrentannee());
	        params.put(ReportsParameter.CYCLE_SCOLAIRE, CacheMemory.getCurrentannee());
	        params.put(ReportsParameter.REPORT_USER,CacheMemory.getCurrentuser());

	        // On positionne la locale
	        params.put(JRBaseParameter.REPORT_LOCALE, Locale.FRENCH);
	        // Construction du Bundle
//	        ResourceBundle bundle = ReportHelper.getInstace();
//	        // Ajout du bundle dans les parametres
//	        params.put(JRBaseParameter.REPORT_RESOURCE_BUNDLE, bundle);
//	        
	        // chemin des sous rapport
	        String report = ReportHelper.reportFileCheminPaie;
	        
	        try {
				 params.put(ReportsParameter.REPORT_IMAGE_REPOSITORY, ReportHelper.getBytes());
				 params.put(ReportsParameter.REPORT_IMAGE_REPOSITORY_BG, ReportHelper.getBytesbgs());
				 params.put(ReportsParameter.REPORT_IMAGE_REPOSITORY_CO, ReportHelper.getBytes());
				 params.put(ReportsParameter.REPORT_IMAGE_REPOSITORY_CO_BG, ReportHelper.getBytesbgc());
				 params.put(ReportsParameter.BG_IMAGE_REPOSITORY,ReportHelper.getBytes("default.png"));
				 params.put(ReportsParameter.REPORT_TITRE_BULL, ReportHelper.getBytestitre(ReportHelper.titre1));
				 params.put(ReportsParameter.REPORT_TITRE_BULL_2, ReportHelper.getBytestitre(ReportHelper.titre2));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        params.put(ReportsParameter.SUBREPORT_DIR, ReportHelper.reportFileCheminPaie);
	       

	        return params;
	    }
	 
	 public static String getMatricule(Eleve eleve , AnneScolaire annee){
		 String matricule = "M"+eleve.getId()+"/"+annee.getCode();
		 
		 return matricule;
	 }
	 

		public static List<BulletinPaie> getBulletintoprint(List<BulletinPaie> records) {
			Double netapayer = 0.0;
			List<BulletinPaie> datas = new ArrayList<BulletinPaie>();
			for (BulletinPaie bulletin : records) {
				RuleBasedNumberFormat rbnf = new RuleBasedNumberFormat(Locale.FRANCE, RuleBasedNumberFormat.SPELLOUT);
				netapayer= bulletin.getSalaireBrut()-bulletin.getChargeSalariale();
				BigDecimal bd = new BigDecimal(netapayer);
				bd = bd.setScale(0, BigDecimal.ROUND_UP);
				Double netarond = bd.doubleValue();
				String mntEnlettre = rbnf.format(netarond);
				bulletin.setNetapayer(netarond);
				bulletin.setNetLettre(mntEnlettre);
				datas.add(bulletin);
			}
			return datas;
		}
	 
	 
}
