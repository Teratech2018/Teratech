/**
 * 
 */
package com.keren.kerenpaie.jaxrs.impl.paie;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.ibm.icu.text.RuleBasedNumberFormat;
import com.kerem.commons.DateHelper;
import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.keren.kerenpaie.model.paie.LigneBulletinPaie;
import com.keren.kerenpaie.model.paie.LigneElementVariable;
import com.keren.kerenpaie.model.paie.Parametres;
import com.keren.kerenpaie.tools.report.ReportHelper;
import com.keren.kerenpaie.tools.report.ReportsParameter;
import net.sf.jasperreports.engine.base.JRBaseParameter;

/**
 * @author Nadege
 *
 */
public class ReportHelperTrt {

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
		// ResourceBundle bundle = ReportHelper.getInstace();
		// Ajout du bundle dans les parametres
		// params.put(JRBaseParameter.REPORT_RESOURCE_BUNDLE, bundle);
		params.put(ReportsParameter.SUBREPORT_DIR, ReportHelper.reportFileChemin);

		try {
			params.put(ReportsParameter.REPORT_IMAGE_REPOSITORY, ReportHelper.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		params.put(ReportsParameter.SUBREPORT_DIR, ReportHelper.reportFileChemin);

		return params;
	}
	
	public static List<BulletinPaie> getLivretoprint(List<BulletinPaie> records) {
		Double netapayer = 0.0;
		List<BulletinPaie> datas = new ArrayList<BulletinPaie>();
		Parametres p = new Parametres();
		for (BulletinPaie bulletin : records) {
			p = new Parametres();
			for (LigneElementVariable ligne : bulletin.getVariables()) {

				if (ligne.getVariable().getCode().equals("SALBASE")) {
					p.setSalbase(ligne.getValeur());
				}
				if (ligne.getVariable().getCode().equals("IRPP")) {
					p.setIrpp(ligne.getValeur());
				}
				if (ligne.getVariable().getCode().equals("CAC")) {
					p.setCac(ligne.getValeur());
				}
				if (ligne.getVariable().getCode().equals("TDL")) {
					p.setTdl(ligne.getValeur());
				}
				if (ligne.getVariable().getCode().equals("RAV")) {
					p.setRav(ligne.getValeur());
				}
				if (ligne.getVariable().getCode().equals("RAPPEL")) {
					p.setCac(ligne.getValeur());
				}
			}

			datas.add(bulletin);
		}
		return datas;
	}

}
