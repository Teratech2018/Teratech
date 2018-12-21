package com.megatimgroup.model.archivage;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.ibm.icu.math.BigDecimal;
import com.megatim.common.annotations.Predicate;
import com.megatimgroup.model.operations.DeclarationFinanciere;
import com.megatimgroup.model.operations.DeclarationPM;
import com.megatimgroup.model.operations.DeclarationPP;
import com.megatimgroup.model.referentiels.Classe;
import com.megatimgroup.model.referentiels.Division;
import com.megatimgroup.model.referentiels.Groupe;
import com.megatimgroup.model.referentiels.Motif;
import com.megatimgroup.model.referentiels.Nationalite;
import com.megatimgroup.model.referentiels.NatureClientele;
import com.megatimgroup.model.referentiels.NatureJuridique;
import com.megatimgroup.model.referentiels.PrecisionDateNaissance;
import com.megatimgroup.model.referentiels.Qualite;
import com.megatimgroup.model.referentiels.Section;
import com.megatimgroup.model.referentiels.StatusResidence;
import com.megatimgroup.model.referentiels.Titre;
import com.megatimgroup.model.referentiels.Ville;

@Entity
@Table(name="ARCHIVE_OPERATION")
public class ArchiveOperation  implements Serializable , Comparable<ArchiveOperation> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_OPERATION")
	private Long idOperation;
	
	@Column(name="C_REF")
	private String cRef;
	
	@Column(name="N_MTCN")
  	private String mtcn ;
	
	@Column(name="L_DES")
	private String lDes;
	
	@Column(name="N_MNT")
	private String nMnt;
	
	@Column(name="C_SENS")
	private String cSens;
	
	@Column(name="C_DEV")
	private String cDev;
	
	@Column(name="D_OPER")
	private String dOper;
	
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
	private String dCre;
	
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
	
	@Column(name="CODE_ETBL")
	private String codeEtbl;
	
	@Column(name="L_MOIS")
	private String lMois ;
	
	@Column(name="L_COMMENTAIRE")
	private String lCommentaire ;
	
    @Column(name="D_DEBUT")
	private String dateDebut;
    
    @Column(name="D_FIN")
	private String dateFin;
	

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
	public String getnMnt() {
		return nMnt;
	}

	/**
	 * @param nMnt the nMnt to set
	 */
	public void setnMnt(String nMnt) {
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
	public String getdOper() {
		return dOper;
	}

	/**
	 * @param dOper the dOper to set
	 */
	public void setdOper(String dOper) {
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

	public String getlNomAbrege() {
		return lNomAbrege;
	}

	public void setlNomAbrege(String lNomAbrege) {
		this.lNomAbrege = lNomAbrege;
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
	 * @return the lCommentaire
	 */
	public String getlCommentaire() {
		return lCommentaire;
	}

	/**
	 * @param lCommentaire the lCommentaire to set
	 */
	public void setlCommentaire(String lCommentaire) {
		this.lCommentaire = lCommentaire;
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
	public String getdCre() {
		return dCre;
	}

	/**
	 * @param dCre the dCre to set
	 */
	public void setdCre(String dCre) {
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
	
	public ArchiveOperation(){
		
	}
	public void setPP(DeclarationPP pp){
		this.setcRef(pp.getReference());
		if(pp.getQualite()!=null)
		this.setcQlte(pp.getQualite().getCode());
		if(pp.getTitre()!=null)
		this.setcTtre(pp.getTitre().getCode());
		this.setlNom(pp.getNom());
		this.setlPre(pp.getPrenom());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		if(pp.getDateNaissance()!=null){
			this.setdCre(formatter.format(pp.getDateNaissance()));
		}
		this.setdNais(pp.getDateNaissance());
		this.setlNais(pp.getLieuNaissance());
		this.setlNJeu(pp.getNomJeuneFille());
		if(pp.getNationalite()!=null)
		this.setcNat(pp.getNationalite().getCode());
		this.setcProf(pp.getProfession());
		if(pp.getNatureClientele()!=null)
		this.setcNatClt(pp.getNatureClientele().getCode());
		if(pp.getStatusResidence()!=null)
		this.setcStatRes(pp.getStatusResidence().getCode());
		this.setlAdr1(pp.getAdresse_1());
		this.setlAdr2(pp.getAdresse_2());
		this.setlAdr3(pp.getAdresse_3());
		this.setlBp(pp.getBoitepostale());
		if(pp.getVille()!=null)
		this.setcVille(pp.getVille().getCode());
		if(pp.getPrecisionDatenaissance()!=null)
		this.setcPreNais(pp.getPrecisionDatenaissance().getCode());
		
	}

	public void setPM( DeclarationPM pm){
		this.setcRef(pm.getReference());
		this.setlRai(pm.getRaisonSocial());
		this.setlSig(pm.getSigle());
		this.setlSS(pm.getSiegeSocial());
		this.setlNumReg(pm.getRegistreCommerce());
		this.setlNomAbrege(pm.getNomAbrege());
		this.setcStat(pm.getCodeStatistique());
		if(pm.getNatureJuridique()!=null)
		this.setcJur(pm.getNatureJuridique().getCode());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		if(pm.getDateCreation()!=null){
			this.setdCre(formatter.format(pm.getDateCreation()));
		}
		this.setlFax(pm.getFax());
		this.setlTel1(pm.getTelephone1());
		this.setlTel2(pm.getTelephone2());
		this.setlTel3(pm.getTelephone3());
		this.setlEmail(pm.getEmail());
		this.setlAdr1(pm.getAdresse_1());
		this.setlAdr2(pm.getAdresse_2());
		this.setlAdr3(pm.getAdresse_3());
		this.setlBp(pm.getBoitepostale());
		
		if(pm.getVille()!=null)
		this.setcVille(pm.getVille().getCode());
		if(pm.getSection()!=null)
		this.setcSec(pm.getSection().getCode());
		if(pm.getDivision()!=null)
		this.setcDiv(pm.getDivision().getCode());
		if(pm.getGroupe()!=null)
		this.setcGrou(pm.getGroupe().getCode());
		if(pm.getClasse()!=null)
		this.setcCLs(pm.getClasse().getCode());
		
	}
	
	public void setOF(DeclarationFinanciere df){
		
		this.setIdOperation(df.getId());
		this.setlDes(df.getDesignation());
		this.setnMnt(df.getMontant()+"");
		this.setcSens(df.getSens().getCode());
		this.setcDev(df.getDevise().getCode());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		if(df.getDateOperation()!=null){
			this.setdOper(formatter.format(df.getDateOperation()));
		}
		if(df.getType()!=null)
		this.setcType(df.getType().getCode());
		if(df.getPays()!=null)
		this.setcPays(df.getPays().getCode());
		if(df.getMotif()!=null)
		this.setcMotif(df.getMotif().getCode());
		this.setMtcn(df.getMtnc());
	
	}
	
	public DeclarationFinanciere getOperation(){
		DeclarationFinanciere of = new DeclarationFinanciere();

		of.setReference(cRef);
		of.setIdOperation(idOperation.toString());
		of.setMontant(new java.math.BigDecimal(nMnt));
		if(lNom!=null&&!lNom.trim().isEmpty()){
			
			StringBuilder builder = new StringBuilder();
			StringBuilder buildercom = new StringBuilder();
			
			builder.append(lNom);
			buildercom.append(lNom);
			
			if(lPre!=null&&!lPre.trim().isEmpty()){
				builder.append(" ").append(lPre);
				buildercom.append(" ").append(lPre);
			}
			Motif motif= new Motif();
			motif.setCode(cMotif);
			of.setMotif(motif);
			buildercom.append(" ").append(of.getMotif().getCode());
			of.setDesignation(builder.toString());
			of.setCommentaire(buildercom.toString());
		}else {
			of.setDesignation(lRai);
			StringBuilder buildercom = new StringBuilder();
			buildercom.append(lRai);
			if(cMotif!=null&&!cMotif.trim().isEmpty()){
				buildercom.append(" ").append(of.getMotif().getCode());
			}
			of.setCommentaire(buildercom.toString());
		}
		return of;
		
	}
	
	public DeclarationPM getMorale(){
		DeclarationPM pm = new DeclarationPM();
		if(lRai==null||lRai.trim().isEmpty()) return null ;
		pm.setReference(cRef);
		pm.setRaisonSocial(lRai);
		pm.setSigle(lSig);
		pm.setSiegeSocial(lSS);
		pm.setRegistreCommerce(lNumReg);
		pm.setNomAbrege(lNomAbrege);
		pm.setCodeStatistique(cStat);
		NatureJuridique natJuridique = new NatureJuridique();
		natJuridique.setCode(cJur);
		pm.setNatureJuridique(natJuridique);
		pm.setDateCreation(new Date(dCre));		
		pm.setFax(lFax);
		pm.setTelephone1(lTel1);
		pm.setTelephone2(lTel2);
		pm.setTelephone3(lTel3);
		pm.setEmail(lEmail);
		pm.setAdresse_1(lAdr1);
		pm.setAdresse_2(lAdr2);
		pm.setAdresse_3(lAdr3);
		pm.setBoitepostale(lBp);
		Ville ville = new Ville();
		ville.setCode(cVille);
		pm.setVille(ville);
		Section section = new Section();
		section.setCode(cSec);
		pm.setSection(section);
		Division div = new Division();
		div.setCode(cDiv);
		pm.setDivision(div);
		Groupe groupe = new Groupe();
		groupe.setCode(cGrou);
		pm.setGroupe(groupe);
		Classe classe = new Classe();
		classe.setCode(cCLs);
		pm.setClasse(classe);
		return pm;
	}
	
	public DeclarationPP getPhysisque(){
		DeclarationPP pp = new DeclarationPP();
		if(lNom==null||lNom.trim().isEmpty()) return null ;
		pp.setReference(cRef);
		Qualite qlte = new Qualite();
		qlte.setCode(cQlte);
		pp.setQualite(qlte);
		Titre titre = new Titre();
		titre.setCode(cTtre);
		pp.setTitre(titre);
		pp.setNom(lNom);
		pp.setPrenom(lPre);
		pp.setDateNaissance(dNais);
		pp.setLieuNaissance(lNais);
		pp.setNomJeuneFille(lNJeu);
		Nationalite nat = new Nationalite();
		nat.setCode(cNat);
		pp.setNationalite(nat);
		pp.setProfession(cProf);
		NatureClientele nclt = new NatureClientele();
		nclt.setCode(cNatClt);
		pp.setNatureClientele(nclt);
		StatusResidence sr = new StatusResidence();
		sr.setCode(cStatRes);
		pp.setStatusResidence(sr);
		pp.setAdresse_1(lAdr1);
		pp.setAdresse_2(lAdr2);
		pp.setAdresse_3(lAdr3);
		pp.setBoitepostale(lBp);
		Ville ville = new Ville();
		ville.setCode(cVille);
		pp.setVille(ville);
		PrecisionDateNaissance pdate = new PrecisionDateNaissance();
		pdate.setCode(cPreNais);
		pp.setPrecisionDatenaissance(pdate);
		return pp ;
	}
	   /**
	 * @return the codeEtbl
	 */
	public String getCodeEtbl() {
		return codeEtbl;
	}

	/**
	 * @param codeEtbl the codeEtbl to set
	 */
	public void setCodeEtbl(String codeEtbl) {
		this.codeEtbl = codeEtbl;
	}

	/**
	 * @return the lMois
	 */
	public String getlMois() {
		return lMois;
	}

	/**
	 * @param lMois the lMois to set
	 */
	public void setlMois(String lMois) {
		this.lMois = lMois;
	}

	/**
	 * @param cCLs the cCLs to set
	 */
	public void setcCLs(String cCLs) {
		this.cCLs = cCLs;
	}

	public String getMtcn() {
		return mtcn;
	}

	public void setMtcn(String mtcn) {
		this.mtcn = mtcn;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public int compareTo(ArchiveOperation o) {
	        return idOperation.compareTo(o.idOperation);
	    }
	    

}
