/**
 * 
 */
package com.kerenedu.jaxrs.impl.report;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.school.Eleve;
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
				 params.put(ReportsParameter.REPORT_IMAGE_REPOSITORY, ReportHelper.getBytes());
				 params.put(ReportsParameter.BG_IMAGE_REPOSITORY,ReportHelper.getBytes("default.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        params.put(ReportsParameter.SUBREPORT_DIR, ReportHelper.reportFileChemin);
	       

	        return params;
	    }
	 
	 public static String getMatricule(Eleve eleve , AnneScolaire annee){
		 String matricule = "M"+eleve.getId()+"/"+annee.getCode();
		 
		 return matricule;
	 }
}
