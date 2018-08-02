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
@Entity(name = "e_remise")
public class Remise extends BaseElement implements Serializable, Comparable<Remise> {

	
	@Column(name = "NATURE")
	@Predicate(label="Nature Remise",optional=false,updatable=true,search=true, target="combobox", values="Total Scolarité;Reste Scolarité" , sequence=1)
	protected String natureRemise="0";
	
	@Column(name = "TYPE")
	@Predicate(label="Type Valeur",optional=false,updatable=true, target="combobox", values="Montant;%" , sequence=2,search=true)
	protected String typeRemise="0";
	
	@Column(name = "VALEUR" )	
	@Predicate(label="Valeur",optional=true,updatable=false,search=true, type=Long.class, hide=false ,sequence=3)
	protected Long zValeur ;
	
	@Column(name = "DATE_EFFET")
	@Predicate(label="Delai Prise Effet",optional=false,updatable=false,search=true, type=Date.class,sequence=5, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datePriseEffet = new Date();
	
	@Column(name = "DESCRIPTION")
	@Predicate(label="DESCRIPTION",optional=false,updatable=true,search=true , sequence=7,target="textarea")
	protected String description ;

	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;
	
	protected boolean Valider =false;
	


	public Remise() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	



	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(Remise o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Remies ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion  des Remises  ";
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




	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	public String getNatureRemise() {
		return natureRemise;
	}








	public void setNatureRemise(String natureRemise) {
		this.natureRemise = natureRemise;
	}








	public String getTypeRemise() {
		return typeRemise;
	}








	public void setTypeRemise(String typeRemise) {
		this.typeRemise = typeRemise;
	}








	public Long getzValeur() {
		return zValeur;
	}








	public void setzValeur(Long zValeur) {
		this.zValeur = zValeur;
	}








	public Date getDatePriseEffet() {
		return datePriseEffet;
	}








	public void setDatePriseEffet(Date datePriseEffet) {
		this.datePriseEffet = datePriseEffet;
	}








	public boolean isValider() {
		return Valider;
	}








	public void setValider(boolean valider) {
		Valider = valider;
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
	


	@Override
	public boolean isDesabledelete() {
		// TODO Auto-generated method stub
		return true;
	}








	@Override
	public boolean isDesableupdate() {
		// TODO Auto-generated method stub
		return true;
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
