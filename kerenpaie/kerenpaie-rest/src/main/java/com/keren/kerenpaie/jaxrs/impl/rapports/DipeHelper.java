/**
 * 
 */
package com.keren.kerenpaie.jaxrs.impl.rapports;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.rapports.ViewDipePaie;
import com.keren.kerenpaie.tools.report.DipeItem;
import com.keren.kerenpaie.tools.report.DipeItemDeb;
import com.keren.kerenpaie.tools.report.DipeItemFin;

import net.sf.jasperreports.engine.export.GenericElementHandlerBundle;

/**
 * @author Nadege
 *
 */
public class DipeHelper {

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String annee(Date date) {

		int year = date.getYear() + 1900;

		char[] years = Integer.toString(year).toCharArray();

		StringBuilder builder = new StringBuilder();

		builder.append(years);

		return builder.toString();
	}


	public static String nombreJours(Date debut, Date fin) {
		String nbre;
		final long MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24;
		long dureeconge = Math.abs(fin.getTime() - debut.getTime()) / MILLISECONDS_PER_DAY;
		nbre = new Long(dureeconge).toString();
		return nbre;
	}
	
	public static String moisAnnee(Date date) {
		return  new SimpleDateFormat("MMyyyy").format(date);
	}
	
	public static String jourMois(Date date) {
		return  new SimpleDateFormat("ddMM").format(date);
	}

	/**
	 * Conversion
	 * 
	 * @param datas
	 * @return
	 */
	public static List<DipeItem> convertFromDItem(List<ViewDipePaie> datas) {

		List<DipeItem> results = new ArrayList<DipeItem>();
		int numLigne=1;
		for (ViewDipePaie dipe : datas) {
			results.add(buildItem(dipe,numLigne));
			numLigne++;
		}
		return results;
	}

	public static List<DipeItemDeb> convertFromDItemDeb(List<ViewDipePaie> datas) {

		List<DipeItemDeb> results = new ArrayList<DipeItemDeb>();
		int numLigne=1;
		for (ViewDipePaie dipe : datas) {
			results.add(buildItemDeb(dipe,numLigne));
			numLigne++;
		}
		return results;
	}

	public static List<DipeItemFin> convertFromDItemFin(List<ViewDipePaie> datas) {

		List<DipeItemFin> results = new ArrayList<DipeItemFin>();
		int numLigne=1;
		for (ViewDipePaie dipe : datas) {
			results.add(buildItemFin(dipe,numLigne));
			numLigne++;
		}
		return results;
	}

	public static String TarnformBigDecimalToString(BigDecimal nombre) {
		String result = "";
		if (nombre != null) {
			result = String.valueOf(nombre);
		}
		return result;

	}

	public static DipeItem buildItem(ViewDipePaie data,int numLigne) {

		DipeItem item = new DipeItem();
		Employe employe = data.getBulletin().getEmploye();
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		item.setCodeEnregistrement("C04");
		item.setNumeroDipe(data.getBulletin().getEmploye().getDipe());
		item.setCleNumDipe(" ");
		item.setNumContribuable(employe.getContribuable());
		item.setNumfeuillet("12");
		if(employe.getStructure()!=null){
			item.setNumEmployeur(employe.getStructure().getRegistre());
		}
		item.setCleNumEmployeur("X");
		item.setRegimeCnps("X");
		if (data.getPeriode() != null) {
			item.setAnneeDipe(DipeHelper.annee(data.getPeriode().getDdebut()));
		}
		item.setNumAss(employe.getNumsec());
		item.setCleNumAss("X");
		item.setNbreJours(DipeHelper.nombreJours(data.getPeriode().getDdebut(), data.getPeriode().getDfin()));
		item.setSalBrut(DipeHelper.TarnformBigDecimalToString(data.getSalBrut()));
		item.setSalExp(DipeHelper.TarnformBigDecimalToString(data.getSalExceptionel()));
		item.setSalTaxable(DipeHelper.TarnformBigDecimalToString(data.getSalTaxable()));
		item.setSalCotCnps(DipeHelper.TarnformBigDecimalToString(data.getSalCotCnps()));
		item.setSalCotPlof(DipeHelper.TarnformBigDecimalToString(data.getSalCotPlaf()));
		item.setRetIrpp(DipeHelper.TarnformBigDecimalToString(data.getRetenueIrpp()));
		item.setRetTaxeCom(DipeHelper.TarnformBigDecimalToString(data.getRetenuetaxeCom()));
		item.setNumLigne(Integer.toString(numLigne));
		item.setMatInterne(data.getBulletin().getEmploye().getMatricule());
		item.setFiller("X");

		return item;
	}
	
	public static DipeItemDeb buildItemDeb(ViewDipePaie data,int numLigne) {

		DipeItemDeb item = new DipeItemDeb();
		Employe employe = data.getBulletin().getEmploye();
		item.setCodeEnregistrement("C05");
		item.setNumeroDipe(employe.getDipe());
		item.setCleNumDipe("X");
		item.setNumfeuillet("13");
		item.setNumContribuable(employe.getContribuable());
		if(employe.getStructure()!=null){
			item.setNumEmployeur(employe.getStructure().getRegistre());
			}
		item.setCleNumEmployeur("X");
		item.setRegimeCnps("X");
		if (data.getPeriode() != null) {
			item.setAnneeDebExercice(DipeHelper.annee(data.getPeriode().getDdebut()));
		}
		item.setConcoll("XO");
		item.setTypeActivite("XA");
		if(employe.getGenre()!=null){
			String sexe= employe.getGenre();
			if(sexe.equals("0")){
				item.setSexe("M");
			}else{
				item.setSexe("F");
			}
		}
		if(employe.getNationalite()!=null){
			item.setNationalite(employe.getNationalite().getCode());
		}
		String moisAnnee=DipeHelper.moisAnnee(employe.getNaissance());
		item.setDateNais(moisAnnee);
		item.setNumAss(employe.getNumsec());
		item.setCleNumAss("2");
		item.setNomAss(employe.getNom());
		item.setPreAss(employe.getNom());
		item.setSitFam(getSitFamiliale(employe.getEtatcivil()));
		item.setNbreEnft(Integer.toString(employe.getNbreenfants()));
		item.setNbrePart("0");
		item.setMoisEmb(DipeHelper.jourMois(new Date()));
		item.setTypePersonnel("X");
		item.setNumLigne(Integer.toString(numLigne));
		item.setMatInterne(employe.getMatricule());
		item.setFiller("D");

		return item;
	}
	
	private static String getSitFamiliale(String sitMat){
		String sit = "";
			if(sitMat.equals("0")){
				sit = "C";
			}else{
				if(sitMat.equals("1")){
					sit = "M";
				}else{
					if(sitMat.equals("2")){
						sit = "V";
					}else{
						if(sitMat.equals("3")){
							sit = "D";
						}
					}
				}
			}
		return sit;
	}
	
	public static DipeItemFin buildItemFin(ViewDipePaie data,int numLigne) {

		DipeItemFin item = new DipeItemFin();
		Employe employe = data.getBulletin().getEmploye();
		item.setCodeEnregistrement("C06");
		item.setNumeroDipe(employe.getDipe());
		item.setCleNumDipe("X");
		item.setNumfeuillet("13");
		item.setNumContribuable(employe.getContribuable());
		
		if(employe.getStructure()!=null){
		item.setNumEmployeur(employe.getStructure().getRegistre());
		}
		item.setCleNumEmployeur("X");
		item.setRegimeCnps("X");
		if (data.getPeriode() != null) {
			item.setAnneeDipe(DipeHelper.annee(data.getPeriode().getDdebut()));
		}
		item.setRedSalTax("X8");
		item.setRedSalCot("X9");
		item.setRedTaxePropor("X10");
		item.setRedSurtaxe("X11");
		item.setRedTaxeCom("X12");
		item.setAvantgeLog("X");
		item.setNbreMoisavantageLog("0");
		item.setAvantageNour("X");
		item.setNbreMoisavantageNour("0");
		item.setAvantageEcl("X");
		item.setNbreMoisavantageEcl("0");
		item.setAvantageDom("X");
		item.setNbreMoisavantageDom("0");
		item.setPeriodeDebEmb(DipeHelper.jourMois(new Date()));
		item.setPeriodeFinEmb(DipeHelper.jourMois(new Date()));
		item.setNumLigne(Integer.toString(numLigne));
		item.setNumAss(employe.getNumsec());
		item.setCleNumAss("X");
		item.setMatInterne(employe.getMatricule());
		item.setFiller("X");

		return item;
	}

}
