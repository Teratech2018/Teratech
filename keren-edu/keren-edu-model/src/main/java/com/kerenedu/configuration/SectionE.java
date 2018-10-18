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
@Entity(name = "e_section")
public class SectionE extends BaseElement implements Serializable, Comparable<SectionE> {
	
	@Column(name = "T_SEC")
	@Predicate(label="Type Section",optional=false,updatable=true,search=true, target="combobox", values="Anglophone;Francophone" , sequence=1)
	protected String typesection="0";
	
	
	@Column(name = "LIBELLE")	
	@Predicate(label="Libellé",optional=false,updatable=false,search=true)
	protected String libelle;
	
	@ManyToOne
    @JoinColumn(name = "RESP_ID")
	@Predicate(label="Responsable/Directeur(trice)",updatable=true,type=Professeurclone.class , target="many-to-one",optional=false,sequence=4, search=true)
    protected Professeurclone responsable;
	
	


	public SectionE() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SectionE(SectionE filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName,0L);
		this.libelle=filiere.libelle;
		this.typesection=filiere.typesection;
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
		return "Gestion des Scetions";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Sections";
	}



	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public String getTypesection() {
		return typesection;
	}


	public Professeurclone getResponsable() {
		return responsable;
	}


	public void setResponsable(Professeurclone responsable) {
		this.responsable = responsable;
	}


	public void setTypesection(String typesection) {
		this.typesection = typesection;
	}


	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		return libelle;
	}


	
	public int compareTo(SectionE o) {
		return 0;
	}


	@Override
	public String getSearchkeys() {
		// TODO Auto-generated method stub
		return libelle;
	}
	

}
