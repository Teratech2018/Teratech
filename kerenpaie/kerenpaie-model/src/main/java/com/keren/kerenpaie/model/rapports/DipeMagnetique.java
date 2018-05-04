package com.keren.kerenpaie.model.rapports;

import java.io.Serializable;

import com.megatim.common.annotations.Predicate;

public class DipeMagnetique  implements Serializable , Comparable<DipeMagnetique>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2230663011058937750L;
	
	
	@Predicate(max=3,nullable=false,optional=false)
	private String codeEnregistrement;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String numeroDipe;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String cleNumDipe;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String numContribuable;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String numfeuillet;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String numEmployeur;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String cleNumEmployeur;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String regimeCnps;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String anneeDipe;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String numAss;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String cleNumAss;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String nbreJours;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String salBrut;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String salTaxable;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String salExp;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String salCotCnps;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String salCotPlof;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String retIrpp;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String retTaxeCom;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String numLigne;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String matInterne;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String filler;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String anneeDebExercice;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String concoll;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String typeActivite;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String sexe;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String nationalite;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String dateNais;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String nomAss;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String preAss;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String sitFam;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String nbreEnft;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String nbrePart;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String moisEmb;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String typePersonnel;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String redSalTax;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String redSalCot;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String redTaxePropor;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String redSurtaxe;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String redTaxeCom;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String avantgeLog;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String nbreMoisavantageLog;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String avantageNour;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String nbreMoisavantageNour;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String avantageEcl;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String nbreMoisavantageEcl;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String avantageDom;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String nbreMoisavantageDom;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String periodeDebEmb;
	
	@Predicate(max=5,nullable=false,optional=false)
	private String periodeFinEmb;


	public DipeMagnetique(String codeEnregistrement, String numeroDipe, String cleNumDipe, String numContribuable,
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
	public String toString() {
		return "DipeMagnetique [codeEnregistrement=" + codeEnregistrement + ", numeroDipe=" + numeroDipe
				+ ", cleNumDipe=" + cleNumDipe + ", numContribuable=" + numContribuable + ", numfeuillet=" + numfeuillet
				+ ", numEmployeur=" + numEmployeur + ", cleNumEmployeur=" + cleNumEmployeur + ", regimeCnps="
				+ regimeCnps + ", anneeDipe=" + anneeDipe + ", numAss=" + numAss + ", cleNumAss=" + cleNumAss
				+ ", nbreJours=" + nbreJours + ", salBrut=" + salBrut + ", salTaxable=" + salTaxable + ", salExp="
				+ salExp + ", salCotCnps=" + salCotCnps + ", salCotPlof=" + salCotPlof + ", retIrpp=" + retIrpp
				+ ", retTaxeCom=" + retTaxeCom + ", numLigne=" + numLigne + ", matInterne=" + matInterne + ", filler="
				+ filler + ", anneeDebExercice=" + anneeDebExercice + ", concoll=" + concoll + ", typeActivite="
				+ typeActivite + ", sexe=" + sexe + ", nationalite=" + nationalite + ", dateNais=" + dateNais
				+ ", nomAss=" + nomAss + ", preAss=" + preAss + ", sitFam=" + sitFam + ", nbreEnft=" + nbreEnft
				+ ", nbrePart=" + nbrePart + ", moisEmb=" + moisEmb + ", typePersonnel=" + typePersonnel
				+ ", redSalTax=" + redSalTax + ", redSalCot=" + redSalCot + ", redTaxePropor=" + redTaxePropor
				+ ", redSurtaxe=" + redSurtaxe + ", redTaxeCom=" + redTaxeCom + ", avantgeLog=" + avantgeLog
				+ ", nbreMoisavantageLog=" + nbreMoisavantageLog + ", avantageNour=" + avantageNour
				+ ", nbreMoisavantageNour=" + nbreMoisavantageNour + ", avantageEcl=" + avantageEcl
				+ ", nbreMoisavantageEcl=" + nbreMoisavantageEcl + ", avantageDom=" + avantageDom
				+ ", nbreMoisavantageDom=" + nbreMoisavantageDom + ", periodeDebEmb=" + periodeDebEmb
				+ ", periodeFinEmb=" + periodeFinEmb + "]";
	}


	@Override
	public int compareTo(DipeMagnetique o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
