/**
 * 
 */
package com.keren.kerenpaie.tools.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.megatim.common.annotations.Predicate;

/**
 * @author Nadege
 *
 */
public class DipeItemFin implements Serializable, Comparable<DipeItemFin> {
	


	@Predicate(length=3,nullable=false,optional=false)
	private String codeEnregistrement;
	
	@Predicate(length=5,nullable=false,optional=false)
	private String numeroDipe;
	
	@Predicate(length=1,nullable=false,optional=false)
	private String cleNumDipe;
	
	@Predicate(length=2,nullable=false,optional=false)
	private String numfeuillet;
	
	@Predicate(length=14,nullable=false,optional=false)
	private String numContribuable;
	
	@Predicate(length=10,nullable=false,optional=false)
	private String numEmployeur;
	
	@Predicate(length=1,nullable=false,optional=false)
	private String cleNumEmployeur;
	
	@Predicate(length=1,nullable=false,optional=false)
	private String regimeCnps;
	
	@Predicate(length=4,nullable=false,optional=false)
	private String anneeDipe;
	
	@Predicate(length=7,nullable=false,optional=false)
	private String redSalTax;
	
	@Predicate(length=7,nullable=false,optional=false)
	private String redSalCot;
	
	@Predicate(length=7,nullable=false,optional=false)
	private String redTaxePropor;
	
	@Predicate(length=7,nullable=false,optional=false)
	private String redSurtaxe;
	
	@Predicate(length=7,nullable=false,optional=false)
	private String redTaxeCom;
	
	@Predicate(length=1,nullable=false,optional=false)
	private String avantgeLog;
	
	@Predicate(length=2,nullable=false,optional=false)
	private String nbreMoisavantageLog;
	
	@Predicate(length=1,nullable=false,optional=false)
	private String avantageNour;
	
	@Predicate(length=2,nullable=false,optional=false)
	private String nbreMoisavantageNour;
	
	@Predicate(length=1,nullable=false,optional=false)
	private String avantageEcl;
	
	@Predicate(length=2,nullable=false,optional=false)
	private String nbreMoisavantageEcl;
	
	@Predicate(length=1,nullable=false,optional=false)
	private String avantageDom;
	
	@Predicate(length=2,nullable=false,optional=false)
	private String nbreMoisavantageDom;
	
	@Predicate(length=4,nullable=false,optional=false)
	private String periodeDebEmb;
	
	@Predicate(length=4,nullable=false,optional=false)
	private String periodeFinEmb;
	
	@Predicate(length=2,nullable=false,optional=false)
	private String numLigne;
	
	
	@Predicate(length=10,nullable=false,optional=false)
	private String numAss;
	
	@Predicate(length=1,nullable=false,optional=false)
	private String cleNumAss;

	@Predicate(length=14,nullable=false,optional=false)
	private String matInterne;
	
	@Predicate(length=12,nullable=false,optional=false)
	private String filler;

	
	
	

	
	
	
	
	
	
	
	public DipeItemFin() {
		// TODO Auto-generated constructor stub
	}





	public DipeItemFin(String codeEnregistrement, String numeroDipe, String cleNumDipe, String numContribuable,
			String numfeuillet, String numEmployeur, String cleNumEmployeur, String regimeCnps, String anneeDipe,
			String numAss, String cleNumAss, String numLigne, String matInterne, String filler, String anneeDebExercice,
			String redSalTax, String redSalCot, String redTaxePropor, String redSurtaxe, String redTaxeCom,
			String avantgeLog, String nbreMoisavantageLog, String avantageNour, String nbreMoisavantageNour,
			String avantageEcl, String nbreMoisavantageEcl, String avantageDom, String nbreMoisavantageDom,
			String periodeDebEmb, String periodeFinEmb) {
		super();
		this.codeEnregistrement = codeEnregistrement;
		this.numeroDipe = numeroDipe;
		this.cleNumDipe = cleNumDipe;
		this.numContribuable = numContribuable;
		this.numfeuillet = numfeuillet;
		this.numEmployeur = numEmployeur;
		this.cleNumEmployeur = cleNumEmployeur;
		this.regimeCnps = regimeCnps;
		this.anneeDipe = anneeDipe;
		this.numAss = numAss;
		this.cleNumAss = cleNumAss;
		this.numLigne = numLigne;
		this.matInterne = matInterne;
		this.filler = filler;
		this.redSalTax = redSalTax;
		this.redSalCot = redSalCot;
		this.redTaxePropor = redTaxePropor;
		this.redSurtaxe = redSurtaxe;
		this.redTaxeCom = redTaxeCom;
		this.avantgeLog = avantgeLog;
		this.nbreMoisavantageLog = nbreMoisavantageLog;
		this.avantageNour = avantageNour;
		this.nbreMoisavantageNour = nbreMoisavantageNour;
		this.avantageEcl = avantageEcl;
		this.nbreMoisavantageEcl = nbreMoisavantageEcl;
		this.avantageDom = avantageDom;
		this.nbreMoisavantageDom = nbreMoisavantageDom;
		this.periodeDebEmb = periodeDebEmb;
		this.periodeFinEmb = periodeFinEmb;
	}





	@Override
	public int compareTo(DipeItemFin o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

	/**
     * 
     * @return 
     */
    public String[] toStringDipeFin(){
        
        List<String> values = new ArrayList<String>();
        
        values.add(codeEnregistrement);values.add(numeroDipe);values.add(cleNumDipe);values.add(numfeuillet);values.add(numContribuable);values.add(numEmployeur);
        values.add(cleNumEmployeur);values.add(regimeCnps);values.add(anneeDipe);values.add(redSalTax);values.add(redSalCot);
        values.add(redTaxePropor);values.add(redSurtaxe);values.add(redTaxeCom);values.add(avantgeLog);values.add(nbreMoisavantageLog);
        values.add(avantageNour);values.add(nbreMoisavantageNour);values.add(avantageEcl);values.add(nbreMoisavantageEcl);values.add(avantageDom);
        values.add(nbreMoisavantageDom);values.add(periodeDebEmb);values.add(periodeFinEmb);values.add(numLigne);values.add(numAss);
        values.add(cleNumAss);values.add(matInterne);values.add(filler);
        
        String[] datas = new String[values.size()];
        
        for(int index = 0 ; index<values.size();index++){
            datas[index] = values.get(index);
        }
        return datas;
    }





	public String getCodeEnregistrement() {
		return codeEnregistrement;
	}





	public void setCodeEnregistrement(String codeEnregistrement) {
		this.codeEnregistrement = codeEnregistrement;
	}





	public String getNumeroDipe() {
		return numeroDipe;
	}





	public void setNumeroDipe(String numeroDipe) {
		this.numeroDipe = numeroDipe;
	}





	public String getCleNumDipe() {
		return cleNumDipe;
	}





	public void setCleNumDipe(String cleNumDipe) {
		this.cleNumDipe = cleNumDipe;
	}





	public String getNumContribuable() {
		return numContribuable;
	}





	public void setNumContribuable(String numContribuable) {
		this.numContribuable = numContribuable;
	}





	public String getNumfeuillet() {
		return numfeuillet;
	}





	public void setNumfeuillet(String numfeuillet) {
		this.numfeuillet = numfeuillet;
	}





	public String getNumEmployeur() {
		return numEmployeur;
	}





	public void setNumEmployeur(String numEmployeur) {
		this.numEmployeur = numEmployeur;
	}





	public String getCleNumEmployeur() {
		return cleNumEmployeur;
	}





	public void setCleNumEmployeur(String cleNumEmployeur) {
		this.cleNumEmployeur = cleNumEmployeur;
	}





	public String getRegimeCnps() {
		return regimeCnps;
	}





	public void setRegimeCnps(String regimeCnps) {
		this.regimeCnps = regimeCnps;
	}





	public String getAnneeDipe() {
		return anneeDipe;
	}





	public void setAnneeDipe(String anneeDipe) {
		this.anneeDipe = anneeDipe;
	}





	public String getNumAss() {
		return numAss;
	}





	public void setNumAss(String numAss) {
		this.numAss = numAss;
	}





	public String getCleNumAss() {
		return cleNumAss;
	}





	public void setCleNumAss(String cleNumAss) {
		this.cleNumAss = cleNumAss;
	}





	public String getNumLigne() {
		return numLigne;
	}





	public void setNumLigne(String numLigne) {
		this.numLigne = numLigne;
	}





	public String getMatInterne() {
		return matInterne;
	}





	public void setMatInterne(String matInterne) {
		this.matInterne = matInterne;
	}





	public String getFiller() {
		return filler;
	}





	public void setFiller(String filler) {
		this.filler = filler;
	}


	public String getRedSalTax() {
		return redSalTax;
	}





	public void setRedSalTax(String redSalTax) {
		this.redSalTax = redSalTax;
	}





	public String getRedSalCot() {
		return redSalCot;
	}





	public void setRedSalCot(String redSalCot) {
		this.redSalCot = redSalCot;
	}





	public String getRedTaxePropor() {
		return redTaxePropor;
	}





	public void setRedTaxePropor(String redTaxePropor) {
		this.redTaxePropor = redTaxePropor;
	}





	public String getRedSurtaxe() {
		return redSurtaxe;
	}





	public void setRedSurtaxe(String redSurtaxe) {
		this.redSurtaxe = redSurtaxe;
	}





	public String getRedTaxeCom() {
		return redTaxeCom;
	}





	public void setRedTaxeCom(String redTaxeCom) {
		this.redTaxeCom = redTaxeCom;
	}





	public String getAvantgeLog() {
		return avantgeLog;
	}





	public void setAvantgeLog(String avantgeLog) {
		this.avantgeLog = avantgeLog;
	}





	public String getNbreMoisavantageLog() {
		return nbreMoisavantageLog;
	}





	public void setNbreMoisavantageLog(String nbreMoisavantageLog) {
		this.nbreMoisavantageLog = nbreMoisavantageLog;
	}





	public String getAvantageNour() {
		return avantageNour;
	}





	public void setAvantageNour(String avantageNour) {
		this.avantageNour = avantageNour;
	}





	public String getNbreMoisavantageNour() {
		return nbreMoisavantageNour;
	}





	public void setNbreMoisavantageNour(String nbreMoisavantageNour) {
		this.nbreMoisavantageNour = nbreMoisavantageNour;
	}





	public String getAvantageEcl() {
		return avantageEcl;
	}





	public void setAvantageEcl(String avantageEcl) {
		this.avantageEcl = avantageEcl;
	}





	public String getNbreMoisavantageEcl() {
		return nbreMoisavantageEcl;
	}





	public void setNbreMoisavantageEcl(String nbreMoisavantageEcl) {
		this.nbreMoisavantageEcl = nbreMoisavantageEcl;
	}





	public String getAvantageDom() {
		return avantageDom;
	}





	public void setAvantageDom(String avantageDom) {
		this.avantageDom = avantageDom;
	}





	public String getNbreMoisavantageDom() {
		return nbreMoisavantageDom;
	}





	public void setNbreMoisavantageDom(String nbreMoisavantageDom) {
		this.nbreMoisavantageDom = nbreMoisavantageDom;
	}





	public String getPeriodeDebEmb() {
		return periodeDebEmb;
	}





	public void setPeriodeDebEmb(String periodeDebEmb) {
		this.periodeDebEmb = periodeDebEmb;
	}





	public String getPeriodeFinEmb() {
		return periodeFinEmb;
	}





	public void setPeriodeFinEmb(String periodeFinEmb) {
		this.periodeFinEmb = periodeFinEmb;
	}
}
