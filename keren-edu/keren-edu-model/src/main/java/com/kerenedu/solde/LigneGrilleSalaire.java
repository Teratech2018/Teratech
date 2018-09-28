/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.Etablissement;
import com.megatim.common.annotations.Predicate;

/**
 * @author Nadege
 *
 */
@Entity
@Table(name = "e_lgrille")
public class LigneGrilleSalaire extends BaseElement implements Serializable, Comparable<LigneGrilleSalaire> {

	@Column(name = "T_CONTRAT")
	@Predicate(label="Type Contrat",optional=true,updatable=true,search=false, target="combobox", values="Vacataire;Permanent(e)" , sequence=1)
    protected String status;

	@ManyToOne
	@JoinColumn(name="CAT_ID")
	@Predicate(label="Catégorie",type=Categorie.class,target="many-to-one",optional=false,search=true, sequence=2)
	private Categorie categorie ;
	
	@ManyToOne
	@JoinColumn(name="ECH_ID")
	@Predicate(label="Echélon",type=Echellon.class,target="many-to-one",optional=false,search=true, sequence=3)
	private Echellon echelon ;
	
	@Predicate(label="Base",optional=false,type=Double.class,search=true, sequence=4)
	private Double salbase =0.0;
	


	
	
	
	public LigneGrilleSalaire(String status, Categorie categorie, Echellon echelon, Double salbase) {
		super();
		this.status = status;
		this.categorie = categorie;
		this.echelon = echelon;
		this.salbase = salbase;
	}
	
	public LigneGrilleSalaire(LigneGrilleSalaire entity) {
		super(entity.id, entity.designation, entity.moduleName,0L);
		this.status = entity.status;
		if(entity.categorie!=null){
			this.categorie = new Categorie(entity.categorie);	
		}
		if(entity.echelon!=null){
			this.echelon = new Echellon(entity.echelon);
		}
		
		this.salbase = entity.salbase;
	}




	public LigneGrilleSalaire() {
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Categorie getCategorie() {
		return categorie;
	}



	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}



	public Echellon getEchelon() {
		return echelon;
	}



	public void setEchelon(Echellon echelon) {
		this.echelon = echelon;
	}



	public Double getSalbase() {
		return salbase;
	}



	public void setSalbase(Double salbase) {
		this.salbase = salbase;
	}



	public int compareTo(LigneGrilleSalaire o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "ligne Grille des Salaire";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Ligne Grille des Salaire";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return id +"";
	}


}
