/**
 * 
 */
package com.kerencourrier.jaxrs.impl.report;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.kerencourrier.tools.report.ReportHelper;
import com.kerencourrier.tools.report.ReportsParameter;

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
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         params.put(ReportsParameter.SUBREPORT_DIR, ReportHelper.reportFileChemin);
	       

	        return params;
	    }
}
