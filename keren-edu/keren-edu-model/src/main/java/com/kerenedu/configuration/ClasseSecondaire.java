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
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Entity
@Table(name = "e_classe")
public class ClasseSecondaire extends BaseElement implements Serializable, Comparable<ClasseSecondaire> {
	
	
	@Column(name = "LIBELLE" ,unique=true)	
	@Predicate(label="CODE",optional=false,updatable=false,search=true , sequence=1, colsequence=1)
	protected String libelle;
	
	@ManyToOne
    @JoinColumn(name = "FILIERE_ID")
	@Predicate(label="Filière",updatable=true,type=Filiere.class , target="many-to-one",search=true, sequence=2, colsequence=2)
    protected Filiere filiere;
	
	@ManyToOne
    @JoinColumn(name = "NIVEAU_ID")
	//@Predicate(label="NIVEAU",updatable=true,type=Niveau.class , target="many-to-one",search=true, sequence=3, colsequence=3)
    protected Niveau niveau;
	
	@Column(name = "TYP_FORMATION")
	//@Predicate(label="TYPE FORMATION ",optional=false,updatable=true,search=false, target="combobox", values="cours du jours;cours du soir" , sequence=4, colsequence=4)
	protected String typeformation="0";
	
	@Column(name = "EFFECTIF")	
	@Predicate(label="Effectif",updatable=true,search=true , sequence=3, type=Long.class, editable=false, colsequence=3)
	protected Long effectif= new Long(0);
	
	@Column(name = "CAPACITE" )	
	//@Predicate(label="Capacité",optional=true,updatable=true,search=true , sequence=4, type=Long.class, colsequence=4)
	protected Long capacite;
	
	@ManyToOne
    @JoinColumn(name = "PROF_ID")
	@Predicate(label="Enseignant. Titulaire",updatable=true,type=Professeur.class , target="many-to-one",search=true, sequence=5, colsequence=4)
    protected Professeur professeur;
	
	@ManyToOne
	@JoinColumn(name="SECTION_ID")
	@Predicate(label="Section",type=SectionE.class,target="many-to-one",optional=false, hide=true)
	private SectionE section ;
	
    @Column(name = "CYCLE_ID")
    @Predicate(label = "cycle", search = true, hide = true, type=Long.class)
    protected long cycle;
    
    @Column(name = "TYPE_CYCLE_ID")
    @Predicate(label ="typecycle", search = true, hide = true)
    protected String typecycle;
	
//	
//	@ManyToMany(fetch = FetchType.LAZY )
//    @JoinColumn(name ="ELEVE_CLASSE_ID", unique=true)
//	@Predicate(label = "Affectation des Elèves",group = true,groupName = "tab1",groupLabel = "Affectation des Elèves",target = "many-to-many-list",type = Eleve.class,search = false)
//	private List<Eleve> elevelist = new ArrayList<Eleve>();
//	


	public ClasseSecondaire() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ClasseSecondaire(ClasseSecondaire filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName,0L);
		this.libelle = filiere.libelle;
		if(this.niveau!=null){
			this.niveau= new Niveau( filiere.niveau);
		}
	
		this.typeformation=filiere.typeformation;
		if(filiere.filiere!=null){
			this.filiere= new Filiere(filiere.filiere);
			this.cycle=filiere.getFiliere().getCycle().getId();
		}
		if(filiere.getSection()!=null){
			this.section=new SectionE(filiere.getSection());
		}
		this.effectif=filiere.effectif;
		if(filiere.professeur!=null){
		   this.professeur= new Professeur(filiere.professeur);
		}
		this.capacite=filiere.capacite;
		this.typecycle=filiere.typecycle;
	}
	
	public ClasseSecondaire(ClasseCycle filiere) {
		super(filiere.getId(), filiere.getDesignation(), filiere.getModuleName(),0L);
		this.libelle = filiere.libelle;
		if(this.niveau!=null){
			this.niveau= new Niveau( filiere.niveau);
		}
	
		this.typeformation=filiere.typeformation;
		if(filiere.filiere!=null){
			this.filiere= new Filiere(filiere.filiere);
			this.cycle=filiere.getFiliere().getCycle().getId();
		}
		if(filiere.getSection()!=null){
			this.section=filiere.getSection();
		}
		this.effectif=filiere.effectif;
		if(filiere.professeur!=null){
		   this.professeur= new Professeur(filiere.professeur);
		}
		this.capacite=filiere.capacite;
	}


	public String getLibelle() {
		return libelle;
	}


	public Long getEffectif() {
		return effectif;
	}


	public Professeur getProfesseur() {
		return professeur;
	}


	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public void setEffectif(Long effectif) {
		this.effectif = effectif;
	}


	public String getTypeformation() {
		return typeformation;
	}


	public void setTypeformation(String typeformation) {
		this.typeformation = typeformation;
	}


	
	
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Classes";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Classes";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return libelle;
	}


	public Filiere getFiliere() {
		return filiere;
	}

//
//	/**
//	 * @return the elevelist
//	 */
//	public List<Eleve> getElevelist() {
//		return elevelist;
//	}
//
//
//	/**
//	 * @param elevelist the elevelist to set
//	 */
//	public void setElevelist(List<Eleve> elevelist) {
//		this.elevelist = elevelist;
//	}


	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}


	public Niveau getNiveau() {
		return niveau;
	}


	public Long getCapacite() {
		return capacite;
	}


	public void setCapacite(Long capacite) {
		this.capacite = capacite;
	}


	public long getCycle() {
		return cycle;
	}




	public SectionE getSection() {
		return section;
	}


	public void setCycle(long cycle) {
		this.cycle = cycle;
	}


	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}


	public void setSection(SectionE section) {
		this.section = section;
	}


	public String getTypecycle() {
		return typecycle;
	}


	public void setTypecycle(String typecycle) {
		this.typecycle = typecycle;
	}


	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String getSearchkeys() {
		// TODO Auto-generated method stub
		return libelle;
	}
	

	public int compareTo(ClasseSecondaire o) {
		// TODO Auto-generated method stub
		return (int)o.getId();
	}

}
