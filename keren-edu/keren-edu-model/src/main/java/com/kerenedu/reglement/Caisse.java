/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_caisse")
public class Caisse extends BaseElement implements Serializable, Comparable<Caisse> {

	@Column(name = "Code")
	@Predicate(label="Num Pièce",optional=false,updatable=true,search=false , sequence=1)
	protected String code ;	
	
	@Column(name = "DATE_ENC")
	@Predicate(label="Date",optional=false,updatable=true,search=true, type=Date.class,sequence=2, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datEnc;
	
	@Column(name = "TYP_PAI")
	@Predicate(label="Type Paiement",optional=false,updatable=false,search=true, target="combobox", values="especes;Espress Union" , sequence=5 )
	protected String typePaiment="0";

	@Column(name = "REVENU" )	
	@Predicate(label="Recette",optional=false,updatable=false,search=true, type=Long.class, hide=false ,sequence=5,hidden="currentObject.nature=='1'")
	protected Long zRevenu ;
	
	
	@Column(name = "DESCRIPTION")
	@Predicate(label="DESCRIPTION",optional=false,updatable=true,search=true , sequence=7)
	protected String description ;
	
	@Column(name = "PAI_ET_ID" )
	protected Long paiement ;
	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;
	


	public Caisse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Caisse(Caisse ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		this.zRevenu = ins.zRevenu;
		this.datEnc=ins.datEnc;
		this.anneScolaire=ins.anneScolaire;
		this.description=ins.description;
		this.paiement= ins.paiement;
		this.code=ins.code;
		this.typePaiment=ins.typePaiment;
	}
	
	public Caisse(Paiement reglement){
		this.zRevenu = reglement.getzMntverser();
		this.datEnc=new Date();
		this.anneScolaire= reglement.anneScolaire;
		this.description="Paiement Scolarité "+"//Elève "+reglement.getEleve().getEleve().getNom();
		this.paiement= reglement.getId();
		this.code=reglement.getCode();
		this.typePaiment=reglement.getTypePaiment();
		this.code=reglement.getEleve().getEleve().getMatricule();
	}
	
	public Caisse(Paiement reglement, String annuler){
		this.zRevenu =reglement.zMntverser;
		this.datEnc=new Date();
		this.anneScolaire= reglement.service.anneScolaire;
		this.description="Annulation du Paiement Scolarité "+"//Elève "+reglement.getEleve().getEleve().getNom();
		this.paiement= reglement.getId();
		this.code=reglement.getCode();
		this.typePaiment=reglement.getTypePaiment();
	}

	



	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(Caisse o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des  Recettes ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion  des Recettes  ";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	


	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return description+" "+id;
	}


	public String getAnneScolaire() {
		return anneScolaire;
	}


	/**
	 * @return the datEnc
	 */
	public Date getDatEnc() {
		return datEnc;
	}


	/**
	 * @param datEnc the datEnc to set
	 */
	public void setDatEnc(Date datEnc) {
		this.datEnc = datEnc;
	}


	/**
	 * @return the zRevenu
	 */
	public Long getzRevenu() {
		return zRevenu;
	}


	/**
	 * @param zRevenu the zRevenu to set
	 */
	public void setzRevenu(Long zRevenu) {
		this.zRevenu = zRevenu;
	}




	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	public Long getPaiement() {
		return paiement;
	}


	public void setPaiement(Long paiement) {
		this.paiement = paiement;
	}


	public String getTypePaiment() {
		return typePaiment;
	}


	public void setTypePaiment(String typePaiment) {
		this.typePaiment = typePaiment;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isDesablecreate() {
		// TODO Auto-generated method stub
		return true;
	}



	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	
	

}
