/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_cycle")
public class Cycle extends BaseElement implements Serializable, Comparable<Cycle> {
	
	
	@Column(name = "LIBELLE")	
	@Predicate(label="Libellé",optional=false,updatable=false,search=true)
	protected String libelle;
	
	@Column(name = "CYCLE")
	@Predicate(label="Type Cycle",optional=false,updatable=true,search=true, target="combobox", values="Maternelle;Primare;Secondaire;Universitaire" , sequence=11)
	protected String typecycle="0";
	


	public Cycle() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cycle(Cycle filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName,0L);
		this.libelle = filiere.libelle;
		this.typecycle=filiere.typecycle;

		
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
		return  this.getlibelletype(typecycle)+"-"+ libelle;
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
	public int compareTo(Cycle o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
