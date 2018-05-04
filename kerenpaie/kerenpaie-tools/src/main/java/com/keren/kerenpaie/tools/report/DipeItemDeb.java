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
public class DipeItemDeb implements Serializable, Comparable<DipeItemDeb> {
	


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
	private String anneeDebExercice;
	
	@Predicate(length=2,nullable=false,optional=false)
	private String concoll;
	
	@Predicate(length=3,nullable=false,optional=false)
	private String typeActivite;
	
	@Predicate(length=1,nullable=false,optional=false)
	private String sexe;
	
	@Predicate(length=1,nullable=false,optional=false)
	private String nationalite;
	
	@Predicate(length=6,nullable=false,optional=false)
	private String dateNais;
	
	@Predicate(length=10,nullable=false,optional=false)
	private String numAss;
	
	@Predicate(length=1,nullable=false,optional=false)
	private String cleNumAss;
		
	@Predicate(length=20,nullable=false,optional=false)
	private String nomAss;
	
	@Predicate(length=15,nullable=false,optional=false)
	private String preAss;
	
	@Predicate(length=1,nullable=false,optional=false)
	private String sitFam;
	
	@Predicate(length=2,nullable=false,optional=false)
	private String nbreEnft;
	
	@Predicate(length=3,nullable=false,optional=false)
	private String nbrePart;
	
	@Predicate(length=4,nullable=false,optional=false)
	private String moisEmb;
	
	@Predicate(length=1,nullable=false,optional=false)
	private String typePersonnel;
	
	@Predicate(length=2,nullable=false,optional=false)
	private String numLigne;
	
	@Predicate(length=14,nullable=false,optional=false)
	private String matInterne;
	
	@Predicate(length=8,nullable=false,optional=false)
	private String filler;
	



	
	
	
	public DipeItemDeb() {
		// TODO Auto-generated constructor stub
	}


	
	public DipeItemDeb(String codeEnregistrement, String numeroDipe, String cleNumDipe, String numContribuable,
			String numfeuillet, String numEmployeur, String cleNumEmployeur, String regimeCnps, String anneeDipe,
			String numAss, String cleNumAss, String nbreJours, String salBrut, String salTaxable, String salExp,
			String salCotCnps, String salCotPlof, String retIrpp, String retTaxeCom, String numLigne, String matInterne,
			String filler, String redTaxeCom, String anneeDebExercice, String concoll, String typeActivite, String sexe,
			String nationalite, String dateNais, String nomAss, String preAss, String sitFam, String nbreEnft,
			String nbrePart, String moisEmb, String typePersonnel) {
		super();
		this.codeEnregistrement = codeEnregistrement;
		this.numeroDipe = numeroDipe;
		this.cleNumDipe = cleNumDipe;
		this.numContribuable = numContribuable;
		this.numfeuillet = numfeuillet;
		this.numEmployeur = numEmployeur;
		this.cleNumEmployeur = cleNumEmployeur;
		this.regimeCnps = regimeCnps;
		this.numAss = numAss;
		this.cleNumAss = cleNumAss;
		this.numLigne = numLigne;
		this.matInterne = matInterne;
		this.filler = filler;
		this.anneeDebExercice = anneeDebExercice;
		this.concoll = concoll;
		this.typeActivite = typeActivite;
		this.sexe = sexe;
		this.nationalite = nationalite;
		this.dateNais = dateNais;
		this.nomAss = nomAss;
		this.preAss = preAss;
		this.sitFam = sitFam;
		this.nbreEnft = nbreEnft;
		this.nbrePart = nbrePart;
		this.moisEmb = moisEmb;
		this.typePersonnel = typePersonnel;
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



	@Override
	public String toString() {
		return "DipeItemDeb [codeEnregistrement=" + codeEnregistrement + ", numeroDipe=" + numeroDipe + ", cleNumDipe="
				+ cleNumDipe + ", numContribuable=" + numContribuable + ", numfeuillet=" + numfeuillet
				+ ", numEmployeur=" + numEmployeur + ", cleNumEmployeur=" + cleNumEmployeur + ", regimeCnps="
				+ regimeCnps + ", anneeDebExercice=" + anneeDebExercice + ", concoll="
				+ concoll + ", typeActivite=" + typeActivite + ", sexe=" + sexe + ", nationalite=" + nationalite
				+ ", dateNais=" + dateNais + ", numAss=" + numAss + ", cleNumAss=" + cleNumAss + ", nomAss=" + nomAss
				+ ", preAss=" + preAss + ", sitFam=" + sitFam + ", nbreEnft=" + nbreEnft + ", nbrePart=" + nbrePart
				+ ", moisEmb=" + moisEmb + ", typePersonnel=" + typePersonnel + ", numLigne=" + numLigne
				+ ", matInterne=" + matInterne + ", filler=" + filler + "]";
	}



	public String getAnneeDebExercice() {
		return anneeDebExercice;
	}



	public void setAnneeDebExercice(String anneeDebExercice) {
		this.anneeDebExercice = anneeDebExercice;
	}



	public String getConcoll() {
		return concoll;
	}



	public void setConcoll(String concoll) {
		this.concoll = concoll;
	}



	public String getTypeActivite() {
		return typeActivite;
	}



	public void setTypeActivite(String typeActivite) {
		this.typeActivite = typeActivite;
	}



	public String getSexe() {
		return sexe;
	}



	public void setSexe(String sexe) {
		this.sexe = sexe;
	}



	public String getNationalite() {
		return nationalite;
	}



	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}



	public String getDateNais() {
		return dateNais;
	}



	public void setDateNais(String dateNais) {
		this.dateNais = dateNais;
	}



	public String getNomAss() {
		return nomAss;
	}



	public void setNomAss(String nomAss) {
		this.nomAss = nomAss;
	}



	public String getPreAss() {
		return preAss;
	}



	public void setPreAss(String preAss) {
		this.preAss = preAss;
	}



	public String getSitFam() {
		return sitFam;
	}



	public void setSitFam(String sitFam) {
		this.sitFam = sitFam;
	}



	public String getNbreEnft() {
		return nbreEnft;
	}



	public void setNbreEnft(String nbreEnft) {
		this.nbreEnft = nbreEnft;
	}



	public String getNbrePart() {
		return nbrePart;
	}



	public void setNbrePart(String nbrePart) {
		this.nbrePart = nbrePart;
	}



	public String getMoisEmb() {
		return moisEmb;
	}



	public void setMoisEmb(String moisEmb) {
		this.moisEmb = moisEmb;
	}



	public String getTypePersonnel() {
		return typePersonnel;
	}



	public void setTypePersonnel(String typePersonnel) {
		this.typePersonnel = typePersonnel;
	}

	/**
     * 
     * @return 
     */
    public String[] toStringDipeDebut(){
        
        List<String> values = new ArrayList<String>();
        
        values.add(codeEnregistrement);values.add(numeroDipe);values.add(cleNumDipe);values.add(numfeuillet);values.add(numContribuable);values.add(numEmployeur);
        values.add(cleNumEmployeur);values.add(regimeCnps);values.add(anneeDebExercice);values.add(concoll);values.add(typeActivite);
        values.add(sexe);values.add(nationalite);values.add(dateNais);values.add(numAss);values.add(cleNumAss);
        values.add(nomAss);values.add(preAss);values.add(sitFam);values.add(nbreEnft);values.add(nbrePart);
        values.add(moisEmb);values.add(typePersonnel);values.add(numLigne);values.add(matInterne);values.add(filler);
        
        String[] datas = new String[values.size()];
        
        for(int index = 0 ; index<values.size();index++){
            datas[index] = values.get(index);
        }
        return datas;
    }


	@Override
	public int compareTo(DipeItemDeb o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
