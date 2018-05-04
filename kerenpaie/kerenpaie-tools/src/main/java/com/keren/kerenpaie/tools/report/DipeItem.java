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
public class DipeItem implements Serializable, Comparable<DipeItem> {
	


	@Predicate(length=3,nullable=false,optional=false)
	private String codeEnregistrement;
	
	@Predicate(length=5,nullable=false,optional=false)
	private String numeroDipe;
	
	@Predicate(length=1,nullable=false,optional=false)
	private String cleNumDipe;
	
	@Predicate(length=14,nullable=false,optional=false)
	private String numContribuable;
	
	@Predicate(length=2,nullable=false,optional=false)
	private String numfeuillet;
	
	@Predicate(length=10,nullable=false,optional=false)
	private String numEmployeur;
	
	@Predicate(length=1,nullable=false,optional=false)
	private String cleNumEmployeur;
	
	@Predicate(length=1,nullable=false,optional=false)
	private String regimeCnps;
	
	@Predicate(length=4,nullable=false,optional=false)
	private String anneeDipe;
	
	@Predicate(length=10,nullable=false,optional=false)
	private String numAss;
	
	@Predicate(length=1,nullable=false,optional=false)
	private String cleNumAss;
	
	@Predicate(length=2,nullable=false,optional=false)
	private String nbreJours;
	
	@Predicate(length=10,nullable=false,optional=false)
	private String salBrut;
	
	@Predicate(length=10,nullable=false,optional=false)
	private String salTaxable;
	
	@Predicate(length=10,nullable=false,optional=false)
	private String salExp;
	
	@Predicate(length=10,nullable=false,optional=false)
	private String salCotCnps;
	
	@Predicate(length=10,nullable=false,optional=false)
	private String salCotPlof;
	
	@Predicate(length=8,nullable=false,optional=false)
	private String retIrpp;
	
	@Predicate(length=6,nullable=false,optional=false)
	private String retTaxeCom;
	
	@Predicate(length=2,nullable=false,optional=false)
	private String numLigne;
	
	@Predicate(length=14,nullable=false,optional=false)
	private String matInterne;
	
	@Predicate(length=1,nullable=false,optional=false)
	private String filler;
	

	
	
	
	public DipeItem(String codeEnregistrement, String numeroDipe, String cleNumDipe, String numContribuable,
			String numfeuillet, String numEmployeur, String cleNumEmployeur, String regimeCnps, String anneeDipe,
			String numAss, String cleNumAss, String nbreJours, String salBrut, String salTaxable, String salExp,
			String salCotCnps, String salCotPlof, String retIrpp, String retTaxeCom, String numLigne, String matInterne,
			String filler, String anneeDebExercice, String concoll, String typeActivite, String sexe,
			String nationalite, String dateNais, String nomAss, String preAss, String sitFam, String nbreEnft,
			String nbrePart, String moisEmb, String typePersonnel, String redSalTax, String redSalCot,
			String redTaxePropor, String redSurtaxe, String redTaxeCom, String avantgeLog, String nbreMoisavantageLog,
			String avantageNour, String nbreMoisavantageNour, String avantageEcl, String nbreMoisavantageEcl,
			String avantageDom, String nbreMoisavantageDom, String periodeDebEmb, String periodeFinEmb) {
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
		this.nbreJours = nbreJours;
		this.salBrut = salBrut;
		this.salTaxable = salTaxable;
		this.salExp = salExp;
		this.salCotCnps = salCotCnps;
		this.salCotPlof = salCotPlof;
		this.retIrpp = retIrpp;
		this.retTaxeCom = retTaxeCom;
		this.numLigne = numLigne;
		this.matInterne = matInterne;
		this.filler = filler;
	}
	
	
	
	public DipeItem() {
		// TODO Auto-generated constructor stub
	}


	/**
     * 
     * @return 
     */
    public String[] toStringDipeMensuel(){
        
        List<String> values = new ArrayList<String>();
        
        values.add(codeEnregistrement);values.add(numeroDipe);values.add(cleNumDipe);values.add(numContribuable);values.add(numfeuillet);values.add(numEmployeur);
        values.add(cleNumEmployeur);values.add(regimeCnps);values.add(anneeDipe);values.add(numAss);values.add(cleNumAss);
        values.add(nbreJours);values.add(salBrut);values.add(salExp);values.add(salTaxable);values.add(salCotPlof);
        values.add(retIrpp);values.add(retTaxeCom);values.add(numLigne);values.add(matInterne);values.add(filler);
        
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
	public String getNbreJours() {
		return nbreJours;
	}
	public void setNbreJours(String nbreJours) {
		this.nbreJours = nbreJours;
	}
	public String getSalBrut() {
		return salBrut;
	}
	public void setSalBrut(String salBrut) {
		this.salBrut = salBrut;
	}
	public String getSalTaxable() {
		return salTaxable;
	}
	public void setSalTaxable(String salTaxable) {
		this.salTaxable = salTaxable;
	}
	public String getSalExp() {
		return salExp;
	}
	public void setSalExp(String salExp) {
		this.salExp = salExp;
	}
	public String getSalCotCnps() {
		return salCotCnps;
	}
	public void setSalCotCnps(String salCotCnps) {
		this.salCotCnps = salCotCnps;
	}
	public String getSalCotPlof() {
		return salCotPlof;
	}
	public void setSalCotPlof(String salCotPlof) {
		this.salCotPlof = salCotPlof;
	}
	public String getRetIrpp() {
		return retIrpp;
	}
	public void setRetIrpp(String retIrpp) {
		this.retIrpp = retIrpp;
	}
	public String getRetTaxeCom() {
		return retTaxeCom;
	}
	public void setRetTaxeCom(String retTaxeCom) {
		this.retTaxeCom = retTaxeCom;
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
	




	@Override
	public int compareTo(DipeItem o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
