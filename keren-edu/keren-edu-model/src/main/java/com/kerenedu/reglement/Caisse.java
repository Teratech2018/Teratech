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
	
	@Column(name = "NATURE")
	@Predicate(label="Nature",optional=false,updatable=true,search=true, target="combobox", values="Recette;Depense" , sequence=3)
	protected String nature="0";
	
//	@ManyToOne
//    @JoinColumn(name = "TYPE_ID")
//	//@Predicate(label="Type Dépense",updatable=true,type=TypeDepense.class , target="many-to-one",search=false, sequence=4)
//    protected TypeDepense typeDepense;
//	

	@Column(name = "REVENU" )	
	@Predicate(label="Recette",optional=true,updatable=false,search=true, type=Long.class, hide=false ,sequence=5,hidden="currentObject.nature=='1'")
	protected Long zRevenu ;
	
	@Column(name = "DEPENSE" )	
	@Predicate(label="Dépense",optional=true,updatable=false,search=true, type=Long.class, hide=false ,sequence=6,hidden="currentObject.nature == null || currentObject.nature=='0'")
	protected Long zdepense ;
	
	
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
		this.zdepense=ins.zdepense;
		this.nature=ins.nature;
		this.code=ins.code;
	}
	
	public Caisse(Paiement reglement){
		this.zRevenu = reglement.zMntverser;
		this.datEnc=new Date();
		this.anneScolaire= reglement.service.anneScolaire;
		this.description="Paiement "+reglement.service.getService().getLibelle()+"//Elève "+reglement.getEleve().getEleve().getNom();
		this.paiement= reglement.getId();
		this.nature="0";
		this.code=reglement.getCode();
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
		return "Gestion des Dépenses et Recettes ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion  des Dépenses et Recettes  ";
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


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

//
//	@Override
//	public boolean isCreateonfield() {
//		// TODO Auto-generated method stub
//		return false;
//	}


//	@Override
//	public boolean isDesablecreate() {
//		// TODO Auto-generated method stub
//		return true;
//	}


	public String getNature() {
		return nature;
	}


	public void setNature(String nature) {
		this.nature = nature;
	}


	public Long getZdepense() {
		return zdepense;
	}


	public void setZdepense(Long zdepense) {
		this.zdepense = zdepense;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	
	

}
