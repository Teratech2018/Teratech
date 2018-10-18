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
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_filiere")
public class Filiere extends BaseElement implements Serializable, Comparable<Filiere> {
	
	
	@ManyToOne
	@JoinColumn(name="SECTION_ID")
	@Predicate(label="Section",type=SectionE.class,target="many-to-one",optional=false, sequence=1)
	private SectionE section ;
	
	@Column(name = "CODE" ,unique=true)	
	@Predicate(label="CODE",optional=false,updatable=true,search=true , sequence=2)
	protected String code;
	
	@Column(name = "LIBELLE" )	
	@Predicate(label="LIBELLE",optional=false,updatable=true,search=true , sequence=3)
	protected String libelle;
	
	@ManyToOne
    @JoinColumn(name = "CYCLE_ID")
	@Predicate(label="Cycle Scolaire",updatable=true,type=Cycle.class , target="many-to-one",optional=false,sequence=4)
    protected Cycle cycle;
	
	@Column(name = "CAPACITE" )	
	@Predicate(label="CAPACITE",optional=true,updatable=true,search=true , sequence=4, type=Long.class)
	protected Long capacite;
	
	@Column(name = "DUREE" )	
	@Predicate(label="DUREE",optional=true,updatable=true,search=true , sequence=5, type=Long.class, editable=false)
	protected Long duree;
	
	


	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Filiere(Filiere filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName,0L);
		this.libelle = filiere.libelle;
		this.code=filiere.code;
		this.capacite=filiere.capacite;
		this.duree=filiere.duree;
		this.cycle=filiere.cycle;
		if(filiere.getSection()!=null){
			this.section=filiere.section;
		}
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}


	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}




	public SectionE getSection() {
		return section;
	}


	public void setSection(SectionE section) {
		this.section = section;
	}


	public Cycle getCycle() {
		return cycle;
	}


	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}


	public Long getCapacite() {
		return capacite;
	}


	public void setCapacite(Long capacite) {
		this.capacite = capacite;
	}


	public Long getDuree() {
		return duree;
	}




	public void setDuree(Long duree) {
		this.duree = duree;
	}


	
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Edition des Filières";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Filières";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code +" "+libelle;
	}

//
//	@Override
//	public boolean isCreateonfield() {
//		// TODO Auto-generated method stub
//		return false;
//	}


	public int compareTo(Filiere o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
