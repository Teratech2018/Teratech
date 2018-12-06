/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.personnel.Professeur;
import com.kerenedu.personnel.Professeurclone;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_cycle")
public class Cycle extends BaseElement implements Serializable, Comparable<Cycle> {
	
	
	@Column(name = "LIBELLE")	
	@Predicate(label="Libellé",optional=false,updatable=true,search=true, sequence=1)
	protected String libelle;
	
	@Column(name = "CYCLE")
	@Predicate(label="Type Cycle",optional=false,updatable=true,search=true, target="combobox", values="Maternelle;Primaire;Secondaire;Universitaire" , sequence=2)
	protected String typecycle="0";
	
	@Column(name = "LIBELLE_EN")	
	@Predicate(label="Libellé Anglais",optional=false,updatable=true,search=true, sequence=3)
	protected String libelleEn;
	
	
	@ManyToOne
    @JoinColumn(name = "RESP_ID")
	@Predicate(label="Responsable/Directeur(trice)",updatable=true,type=Professeurclone.class , target="many-to-one",optional=false,sequence=4, search=true)
    protected Professeurclone responsable;
	
	


	public Cycle() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cycle(Cycle filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName,0L);
		this.libelle = filiere.libelle;
		this.typecycle=filiere.typecycle;
		this.libelleEn=filiere.libelleEn;
		if(filiere.responsable!=null){
			this.responsable= new Professeurclone(filiere.responsable);
		}

		
		//this.elevelist= new ArrayList<Eleve>();
	}

	public String getLibelle() {
		return libelle;
	}



	
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Cycles";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Cycles";
	}

	public String getTypecycle() {
		return typecycle;
	}


	public void setTypecycle(String typecycle) {
		this.typecycle = typecycle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return  this.getlibelletype(typecycle);
	}


	public String getLibelleEn() {
		return libelleEn;
	}


	public void setLibelleEn(String libelleEn) {
		this.libelleEn = libelleEn;
	}


	public String getlibelletype(String type)	{
		String valeur ;
		if(type.equals("0")){
			valeur="Maternelle";
		}else if(type.equals("1")){
			valeur="Primare";
		}else if(type.equals("2")){
			valeur="Secondaire";
		}
		else{
			valeur="Universitaire";
		}
		return valeur;
		
	}
	public Professeurclone getResponsable() {
		return responsable;
	}


	public void setResponsable(Professeurclone responsable) {
		this.responsable = responsable;
	}


	public int compareTo(Cycle o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}

}
