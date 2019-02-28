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
import com.kerenedu.inscription.Inscription;
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
	@Predicate(label="CAPACITE",optional=true,updatable=true,search=true , sequence=5, type=Long.class,editable=false, hide=true)
	protected Long capacite;
	
	@Column(name = "EFF_FILLE")	
	@Predicate(label="Nbre fille",updatable=true,search=true , sequence=6, type=Long.class, editable=false, hide=true)
	protected Long efffille= new Long(0);
	
	@Column(name = "EFF_GAR")	
	@Predicate(label="Nbre Gar.",updatable=true,search=true , sequence=7, type=Long.class, editable=false, hide=true)
	protected Long effGarcon= new Long(0);
	
	@Column(name = "DUREE" )	
	@Predicate(label="DUREE",optional=true,updatable=true,search=false , sequence=8, type=Long.class, editable=false)
	protected Long duree;
	
//	  @ManyToOne
//	    @JoinColumn(name = "FIL_ID_SUP")
//		@Predicate(label="Filière Sup.",updatable=true,type=Classe.class , target="many-to-one",search=false, sequence=7)
//	    protected Filiere clssup;
		


	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Filiere(Filiere filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName,filiere.compareid);
		this.libelle = filiere.libelle;
		this.code=filiere.code;
		this.capacite=filiere.capacite;
		this.efffille=filiere.efffille;
		this.effGarcon=filiere.effGarcon;
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

	public Long getEfffille() {
		return efffille;
	}


	public void setEfffille(Long efffille) {
		this.efffille = efffille;
	}


	public Long getEffGarcon() {
		return effGarcon;
	}


	public void setEffGarcon(Long effGarcon) {
		this.effGarcon = effGarcon;
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

	@Override
	public String getSearchkeys() {
		// TODO Auto-generated method stub
		return code;
	}
	

	public int compareTo(Filiere o) {
		// TODO Auto-generated method stub
		return (int)o.getId();
	}


	
}
