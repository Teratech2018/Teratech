package com.megatimgroup.model.echange;

import com.megatim.common.annotations.Connector;
import com.megatim.common.annotations.Exclude;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.megatimgroup.ebaytools.client.EbayItem;
import com.megatimgroup.model.archivage.ArchiveOperation;
import com.megatimgroup.model.operations.DeclarationFinanciere;

@Entity
@Table(name="VIEW_OF")
public class ViewOperationFinanciere  implements Serializable , Comparable<ViewOperationFinanciere> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_OPERATION")
        @Predicate(label="Numéro Operation")
        @Exclude(classes={DeclarationFinanciere.class,ArchiveOperation.class},
            champs={"idOperation","idOperation"},connector= Connector.AND,value="")
	private Long idOperation;
	
	@Column(name="C_REF")
	private String cRef;
	
	@Column(name="L_DES")
	private String lDes;
	
	@Column(name="N_MNT")
	private BigDecimal nMnt;
	
	@Column(name="C_SENS")
	private String cSens;
	
	@Column(name="C_DEV")
	private String cDev;
	
	@Column(name="D_OPER")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dOper;
	
	@Column(name="C_TYPE")
	private String cType;
	
	@Column(name="C_PAYS")
	private String cPays;
	
	@Column(name="C_MOTIF")
	private String cMotif;
		
	@Column(name="L_RAI")
	private String lRai;
	
	@Column(name="L_SIG")
	private String lSig;
	
	@Column(name="L_SS")
	private String lSS;
	
	@Column(name="L_NUM_REG")
	private String lNumReg;

	@Column(name="L_NOM")
	private String lNom;
	
	@Column(name="L_NOM_ABREGE")
	private String lNomAbrege;
	
	@Column(name="C_JUR")
	private String cJur;
	
	@Column(name="D_CRE")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dCre;
	
	@Column(name="L_OBJ")
	private String lObj;
	
	@Column(name="C_RES")
	private String cRes;

	@Column(name="L_ADR_1")
	private String lAdr1;
	
	@Column(name="L_ADR_2")
	private String lAdr2;
	
	@Column(name="L_ADR_3")
	private String lAdr3;
	
	@Column(name="L_BP")
	private String lBp;

	@Column(name="C_VILLE")
	private String cVille;
	

	@Column(name="L_TEL_1")
	private String lTel1;
	
	@Column(name="L_TEL_2")
	private String lTel2;
	
	@Column(name="L_TEL_3")
	private String lTel3;
	
	@Column(name="L_EMAIL")
	private String lEmail;
	
	@Column(name="C_SEC")
	private String cSec;
	
	@Column(name="C_DIV")
	private String cDiv;
	
	@Column(name="C_GROU")
	private String cGrou;
	
	@Column(name="C_CLS")
	private String cCLs;

	@Column(name="C_QLTE")
	private String cQlte;
	
	@Column(name="C_TTRE")
	private String cTtre;
	
	@Column(name="L_PRE")
	private String lPre;
	
	@Column(name="D_NAIS")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dNais;
	
	@Column(name="L_NAIS")
	private String lNais;
	
	@Column(name="L_N_JEU")
	private String lNJeu;
	
	@Column(name="C_NAT")
	private String cNat;
	
	@Column(name="C_PROF")
	private String cProf;
	
	@Column(name="C_NAT_CLT")
	private String cNatClt;
	
	@Column(name="C_STAT_RES")
	private String cStatRes;
	
	@Column(name="C_STAT")
	private String cStat;
	
	@Column(name="C_PRE_NAIS")
	private String cPreNais;
	
	@Column(name="C_FAX")
	private String lFax ;

        
        /**
         * 
         */
    public ViewOperationFinanciere() {
    }

        
        
	/**
	 * @return the cRef
	 */
	public String getcRef() {
		return cRef;
	}

	/**
	 * @param cRef the cRef to set
	 */
	public void setcRef(String cRef) {
		this.cRef = cRef;
	}

	/**
	 * @return the lDes
	 */
	public String getlDes() {
		return lDes;
	}

	/**
	 * @param lDes the lDes to set
	 */
	public void setlDes(String lDes) {
		this.lDes = lDes;
	}

	/**
	 * @return the nMnt
	 */
	public BigDecimal getnMnt() {
		return nMnt;
	}

	/**
	 * @param nMnt the nMnt to set
	 */
	public void setnMnt(BigDecimal nMnt) {
		this.nMnt = nMnt;
	}

	/**
	 * @return the cSens
	 */
	public String getcSens() {
		return cSens;
	}

	/**
	 * @param cSens the cSens to set
	 */
	public void setcSens(String cSens) {
		this.cSens = cSens;
	}

	/**
	 * @return the cDev
	 */
	public String getcDev() {
		return cDev;
	}

	/**
	 * @param cDev the cDev to set
	 */
	public void setcDev(String cDev) {
		this.cDev = cDev;
	}

	/**
	 * @return the dOper
	 */
	public Date getdOper() {
		return dOper;
	}

	/**
	 * @param dOper the dOper to set
	 */
	public void setdOper(Date dOper) {
		this.dOper = dOper;
	}

	/**
	 * @return the cType
	 */
	public String getcType() {
		return cType;
	}

	/**
	 * @param cType the cType to set
	 */
	public void setcType(String cType) {
		this.cType = cType;
	}

	/**
	 * @return the lEmail
	 */
	public String getlEmail() {
		return lEmail;
	}

	/**
	 * @param lEmail the lEmail to set
	 */
	public void setlEmail(String lEmail) {
		this.lEmail = lEmail;
	}

	/**
	 * @return the lFax
	 */
	public String getlFax() {
		return lFax;
	}

	/**
	 * @param lFax the lFax to set
	 */
	public void setlFax(String lFax) {
		this.lFax = lFax;
	}

	/**
	 * @return the cPays
	 */
	public String getcPays() {
		return cPays;
	}

	/**
	 * @param cPays the cPays to set
	 */
	public void setcPays(String cPays) {
		this.cPays = cPays;
	}

	/**
	 * @return the cMotif
	 */
	public String getcMotif() {
		return cMotif;
	}

	/**
	 * @param cMotif the cMotif to set
	 */
	public void setcMotif(String cMotif) {
		this.cMotif = cMotif;
	}

	/**
	 * @return the idOperation
	 */
	public Long getIdOperation() {
		return idOperation;
	}

	/**
	 * @param idOperation the idOperation to set
	 */
	public void setIdOperation(Long idOperation) {
		this.idOperation = idOperation;
	}

	/**
	 * @return the lRai
	 */
	public String getlRai() {
		return lRai;
	}

	/**
	 * @param lRai the lRai to set
	 */
	public void setlRai(String lRai) {
		this.lRai = lRai;
	}

	/**
	 * @return the lSig
	 */
	public String getlSig() {
		return lSig;
	}

	/**
	 * @param lSig the lSig to set
	 */
	public void setlSig(String lSig) {
		this.lSig = lSig;
	}

	/**
	 * @return the lSS
	 */
	public String getlSS() {
		return lSS;
	}

	/**
	 * @param lSS the lSS to set
	 */
	public void setlSS(String lSS) {
		this.lSS = lSS;
	}

	/**
	 * @return the lNumReg
	 */
	public String getlNumReg() {
		return lNumReg;
	}

	/**
	 * @param lNumReg the lNumReg to set
	 */
	public void setlNumReg(String lNumReg) {
		this.lNumReg = lNumReg;
	}

	/**
	 * @return the cStat
	 */
	public String getcStat() {
		return cStat;
	}

	/**
	 * @param cStat the cStat to set
	 */
	public void setcStat(String cStat) {
		this.cStat = cStat;
	}

	/**
	 * @return the lNom
	 */
	public String getlNom() {
		return lNom;
	}

	/**
	 * @param lNom the lNom to set
	 */
	public void setlNom(String lNom) {
		this.lNom = lNom;
	}

	/**
	 * @return the cJur
	 */
	public String getcJur() {
		return cJur;
	}

	/**
	 * @param cJur the cJur to set
	 */
	public void setcJur(String cJur) {
		this.cJur = cJur;
	}

	/**
	 * @return the dCre
	 */
	public Date getdCre() {
		return dCre;
	}

	/**
	 * @param dCre the dCre to set
	 */
	public void setdCre(Date dCre) {
		this.dCre = dCre;
	}


	/**
	 * @return the lObj
	 */
	public String getlObj() {
		return lObj;
	}

	/**
	 * @param lObj the lObj to set
	 */
	public void setlObj(String lObj) {
		this.lObj = lObj;
	}

	/**
	 * @return the cRes
	 */
	public String getcRes() {
		return cRes;
	}

	/**
	 * @param cRes the cRes to set
	 */
	public void setcRes(String cRes) {
		this.cRes = cRes;
	}

	/**
	 * @return the lAdr1
	 */
	public String getlAdr1() {
		return lAdr1;
	}

	/**
	 * @param lAdr1 the lAdr1 to set
	 */
	public void setlAdr1(String lAdr1) {
		this.lAdr1 = lAdr1;
	}

	/**
	 * @return the lAdr2
	 */
	public String getlAdr2() {
		return lAdr2;
	}

	/**
	 * @param lAdr2 the lAdr2 to set
	 */
	public void setlAdr2(String lAdr2) {
		this.lAdr2 = lAdr2;
	}

	/**
	 * @return the lAdr3
	 */
	public String getlAdr3() {
		return lAdr3;
	}

	/**
	 * @param lAdr3 the lAdr3 to set
	 */
	public void setlAdr3(String lAdr3) {
		this.lAdr3 = lAdr3;
	}

	/**
	 * @return the lBp
	 */
	public String getlBp() {
		return lBp;
	}

	/**
	 * @param lBp the lBp to set
	 */
	public void setlBp(String lBp) {
		this.lBp = lBp;
	}

	/**
	 * @return the cVille
	 */
	public String getcVille() {
		return cVille;
	}

	/**
	 * @param cVille the cVille to set
	 */
	public void setcVille(String cVille) {
		this.cVille = cVille;
	}

	/**
	 * @return the lTel1
	 */
	public String getlTel1() {
		return lTel1;
	}

	/**
	 * @param lTel1 the lTel1 to set
	 */
	public void setlTel1(String lTel1) {
		this.lTel1 = lTel1;
	}

	/**
	 * @return the lTel2
	 */
	public String getlTel2() {
		return lTel2;
	}

	/**
	 * @param lTel2 the lTel2 to set
	 */
	public void setlTel2(String lTel2) {
		this.lTel2 = lTel2;
	}

	/**
	 * @return the lTel3
	 */
	public String getlTel3() {
		return lTel3;
	}

	/**
	 * @param lTel3 the lTel3 to set
	 */
	public void setlTel3(String lTel3) {
		this.lTel3 = lTel3;
	}

	/**
	 * @return the cSec
	 */
	public String getcSec() {
		return cSec;
	}

	/**
	 * @param cSec the cSec to set
	 */
	public void setcSec(String cSec) {
		this.cSec = cSec;
	}

	/**
	 * @return the cDiv
	 */
	public String getcDiv() {
		return cDiv;
	}

	/**
	 * @param cDiv the cDiv to set
	 */
	public void setcDiv(String cDiv) {
		this.cDiv = cDiv;
	}

	/**
	 * @return the cGrou
	 */
	public String getcGrou() {
		return cGrou;
	}

	/**
	 * @param cGrou the cGrou to set
	 */
	public void setcGrou(String cGrou) {
		this.cGrou = cGrou;
	}

	/**
	 * @return the cLs
	 */
	public String getcCLs() {
		return cCLs;
	}

	/**
	 * @param cLs the cLs to set
	 */
	public void setccLs(String ccLs) {
		this.cCLs = ccLs;
	}

	/**
	 * @return the cQlte
	 */
	public String getcQlte() {
		return cQlte;
	}

	/**
	 * @param cQlte the cQlte to set
	 */
	public void setcQlte(String cQlte) {
		this.cQlte = cQlte;
	}

	/**
	 * @return the cTtre
	 */
	public String getcTtre() {
		return cTtre;
	}

	/**
	 * @param cTtre the cTtre to set
	 */
	public void setcTtre(String cTtre) {
		this.cTtre = cTtre;
	}

	/**
	 * @return the lPre
	 */
	public String getlPre() {
		return lPre;
	}

	/**
	 * @param lPre the lPre to set
	 */
	public void setlPre(String lPre) {
		this.lPre = lPre;
	}

	/**
	 * @return the dNais
	 */
	public Date getdNais() {
		return dNais;
	}

	/**
	 * @param dNais the dNais to set
	 */
	public void setdNais(Date dNais) {
		this.dNais = dNais;
	}

	/**
	 * @return the lNais
	 */
	public String getlNais() {
		return lNais;
	}

	/**
	 * @param lNais the lNais to set
	 */
	public void setlNais(String lNais) {
		this.lNais = lNais;
	}

	/**
	 * @return the lNJeu
	 */
	public String getlNJeu() {
		return lNJeu;
	}

	/**
	 * @param lNJeu the lNJeu to set
	 */
	public void setlNJeu(String lNJeu) {
		this.lNJeu = lNJeu;
	}

	/**
	 * @return the cNat
	 */
	public String getcNat() {
		return cNat;
	}

	/**
	 * @param cNat the cNat to set
	 */
	public void setcNat(String cNat) {
		this.cNat = cNat;
	}

	/**
	 * @return the cProf
	 */
	public String getcProf() {
		return cProf;
	}

	/**
	 * @param cProf the cProf to set
	 */
	public void setcProf(String cProf) {
		this.cProf = cProf;
	}

	/**
	 * @return the cNatClt
	 */
	public String getcNatClt() {
		return cNatClt;
	}

	/**
	 * @param cNatClt the cNatClt to set
	 */
	public void setcNatClt(String cNatClt) {
		this.cNatClt = cNatClt;
	}

	/**
	 * @return the cStatRes
	 */
	public String getcStatRes() {
		return cStatRes;
	}

	/**
	 * @param cStatRes the cStatRes to set
	 */
	public void setcStatRes(String cStatRes) {
		this.cStatRes = cStatRes;
	}

	/**
	 * @return the cPreNais
	 */
	public String getcPreNais() {
		return cPreNais;
	}

	/**
	 * @param cPreNais the cPreNais to set
	 */
	public void setcPreNais(String cPreNais) {
		this.cPreNais = cPreNais;
	}
	
	/**
	 * @param cCLs the cCLs to set
	 */
	public void setcCLs(String cCLs) {
		this.cCLs = cCLs;
	}

	public String getlNomAbrege() {
		return lNomAbrege;
	}



	public void setlNomAbrege(String lNomAbrege) {
		this.lNomAbrege = lNomAbrege;
	}



	public EbayItem getPP(){
		if(lNom==null||lNom.trim().isEmpty()) return null ;
		EbayItem item = new EbayItem();
		item.setReference(cRef);
		item.setQualite(cQlte);
		item.setTitre(cTtre);
		item.setNom(lNom);
		item.setPrenom(lPre);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		if(dNais!=null){
			item.setDateNaissance(formatter.format(dNais));
		}
		item.setLieuNaissance(lNais);
		item.setNomJeuneFille(lNJeu);
		item.setNationalite(cNat);
		item.setProfession(cProf);
		item.setNatureClientele(cNatClt);
		item.setStatusResidence(cStatRes);
		item.setAdresse_1(lAdr1);
		item.setAdresse_2(lAdr2);
		item.setAdresse_3(lAdr3);
		item.setBoitepostale(lBp);
		item.setVille(cVille);
		item.setPrecisionDatenaissance(cPreNais);
		
		return item;
		
	}

	public EbayItem getPM(){
		if(lRai==null||lRai.trim().isEmpty()) return null ;
		EbayItem item = new EbayItem();
		item.setReference(cRef);
		item.setRaisonSocial(lRai);
		item.setSigle(lSig);
		item.setSiegeSocial(lSS);
		item.setRegistreCommerce(lNumReg);
		item.setNomAbrege(lNomAbrege);
		item.setCodeStatistique(cStat);
		item.setNatureJuridique(cJur);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		if(dCre!=null){
			item.setDateCreation(formatter.format(dCre));
		}
		
		item.setFax(lFax);
		item.setTelephone1(lTel1);
		item.setTelephone2(lTel2);
		item.setTelephone3(lTel3);
		item.setEmail(lEmail);
		item.setAdresse_1(lAdr1);
		item.setAdresse_2(lAdr2);
		item.setAdresse_3(lAdr3);
		item.setBoitepostale(lBp);
		item.setVille(cVille);
		item.setSection(cSec);
		item.setDivision(cDiv);
		item.setGroupe(cGrou);
		item.setClasse(cCLs);
		return item;
		
	}
	
	public EbayItem getOF(){
		EbayItem item = new EbayItem();
		item.setReference(cRef);
		item.setIdOperation(idOperation.toString());
		if(lNom!=null&&!lNom.trim().isEmpty()){
			
			StringBuilder builder = new StringBuilder();
			StringBuilder buildercom = new StringBuilder();
			
			builder.append(lNom);
			buildercom.append(lNom);
			
			if(lPre!=null&&!lPre.trim().isEmpty()){
				builder.append(" ").append(lPre);
				buildercom.append(" ").append(lPre);
			}
			
			if(cMotif!=null&&!cMotif.trim().isEmpty()){
				buildercom.append(" ").append(cMotif);
			}
			
			item.setDesignation(builder.toString());
			item.setCommentaire(buildercom.toString());
		}else {
			item.setDesignation(lRai);
			StringBuilder buildercom = new StringBuilder();
			buildercom.append(lRai);
			if(cMotif!=null&&!cMotif.trim().isEmpty()){
				buildercom.append(" ").append(cMotif);
			}
			item.setCommentaire(buildercom.toString());
		}
		
		
		if(nMnt!=null){
			item.setMontant(nMnt.toString());		
		}
		item.setSens(cSens);
		item.setDevise(cDev);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		if(dOper!=null){
			item.setDateOperation(formatter.format(dOper));
		}
		item.setType(cType);
		item.setPays(cPays);
		item.setMotif(cMotif);
                item.setIdOperation(Long.toString(idOperation));
                
		return item;
		
	}
	   public int compareTo(ViewOperationFinanciere o) {
	        return idOperation.compareTo(o.idOperation);
	    }



	@Override
	public String toString() {
		return "ViewOperationFinanciere [idOperation=" + idOperation
				+ ", cRef=" + cRef + ", lDes=" + lDes + ", nMnt=" + nMnt
				+ ", cSens=" + cSens + ", cDev=" + cDev + ", dOper=" + dOper
				+ ", cType=" + cType + ", cPays=" + cPays + ", cMotif="
				+ cMotif + ", lRai=" + lRai + ", lSig=" + lSig + ", lSS=" + lSS
				+ ", lNumReg=" + lNumReg + ", lNom=" + lNom + ", cJur=" + cJur
				+ ", dCre=" + dCre + ", lObj=" + lObj + ", cRes=" + cRes
				+ ", lAdr1=" + lAdr1 + ", lAdr2=" + lAdr2 + ", lAdr3=" + lAdr3
				+ ", lBp=" + lBp + ", cVille=" + cVille + ", lTel1=" + lTel1
				+ ", lTel2=" + lTel2 + ", lTel3=" + lTel3 + ", lEmail="
				+ lEmail + ", cSec=" + cSec + ", cDiv=" + cDiv + ", cGrou="
				+ cGrou + ", cCLs=" + cCLs + ", cQlte=" + cQlte + ", cTtre="
				+ cTtre + ", lPre=" + lPre + ", dNais=" + dNais + ", lNais="
				+ lNais + ", lNJeu=" + lNJeu + ", cNat=" + cNat + ", cProf="
				+ cProf + ", cNatClt=" + cNatClt + ", cStatRes=" + cStatRes
				+ ", cStat=" + cStat + ", cPreNais=" + cPreNais + ", lFax="
				+ lFax + "]";
	}
	    
     
}
