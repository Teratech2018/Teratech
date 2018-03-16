/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.configuration.Service;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_caisse")
public class Caisse extends BaseElement implements Serializable, Comparable<Caisse> {

	
	@Column(name = "DATE_ENC")
	@Predicate(label="DATE",optional=false,updatable=true,search=true, type=Date.class,sequence=1, target="date" , colsequence=1 )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datEnc;

	@Column(name = "REVENU" )	
	@Predicate(label="REVENU",optional=true,updatable=false,search=true, type=Long.class, hide=false ,sequence=4, colsequence=3)
	protected Long zRevenu = new Long(0);
	
	@Column(name = "DEPENSE")	
	@Predicate(label="DEPENSE",optional=true,updatable=false,search=true, type=Long.class, hide=false ,sequence=4, colsequence=4)
	protected Long zDepense =new Long(0);
	
	@Column(name = "DESCRIPTION")
	@Predicate(label="DESCRIPTION",optional=false,updatable=true,search=true , sequence=2 , colsequence=2)
	protected String description ;

	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;
	


	public Caisse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Caisse(Caisse ins) {
		super(ins.id, ins.designation, ins.moduleName);
		this.zRevenu = ins.zRevenu;
		this.zDepense = ins.zDepense;
		this.datEnc=ins.datEnc;
		this.anneScolaire=ins.anneScolaire;
		this.description=ins.description;
		
	
	
	}
	
	public Caisse(Paiement reglement){
		this.zRevenu = reglement.zMnt;
		this.zDepense = new Long(0);
		this.datEnc=new Date();
		this.anneScolaire= reglement.service.anneScolaire;
		this.description="Paiement Etudiant "+reglement.service.eleve.getEleve().getMatricule();
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
		return "Gestion de la Caisse ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion de la Caisse ";
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


	/**
	 * @return the zDepense
	 */
	public Long getzDepense() {
		return zDepense;
	}


	/**
	 * @param zDepense the zDepense to set
	 */
	public void setzDepense(Long zDepense) {
		this.zDepense = zDepense;
	
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


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	

}
