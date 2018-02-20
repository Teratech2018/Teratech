/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.personnel.Professeur;
import com.kerenedu.school.Contacts;
import com.kerenedu.school.Eleve;
import com.kerenedu.school.Nationalite;
import com.kerenedu.school.NiveauScolaire;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_classe")
public class Classe extends BaseElement implements Serializable, Comparable<Classe> {
	
	
	@Column(name = "LIBELLE" ,unique=true)	
	@Predicate(label="LIBELLE",optional=false,updatable=false,search=true , sequence=1, colsequence=1)
	protected String libelle;
	
	@ManyToOne
    @JoinColumn(name = "FILIERE_ID")
	@Predicate(label="FILIERE",updatable=true,type=Filiere.class , target="many-to-one",search=true, sequence=2, colsequence=2)
    protected Filiere filiere;
	
	@ManyToOne
    @JoinColumn(name = "NIVEAU_ID")
	@Predicate(label="NIVEAU",updatable=true,type=Niveau.class , target="many-to-one",search=true, sequence=3, colsequence=3)
    protected Niveau niveau;
	
	@Column(name = "TYP_FORMATION")
	@Predicate(label="TYPE FORMATION ",optional=false,updatable=true,search=true, target="combobox", 
	values="cours du jours;cours du soir" , sequence=4, colsequence=4)
	protected String typeformation="0";
	
	@Column(name = "EFFECTIF" ,unique=true)	
	@Predicate(label="EFFECTIF",updatable=true,search=false , sequence=4, type=Long.class, editable=false)
	protected Long effectif;
	
	@ManyToOne
    @JoinColumn(name = "PROF_ID")
	@Predicate(label="PROF. TITULAIRE",updatable=true,type=Professeur.class , target="many-to-one",search=true, sequence=5, colsequence=4)
    protected Professeur professeur;
	
//	
//	@ManyToMany(fetch = FetchType.LAZY )
//    @JoinColumn(name ="ELEVE_CLASSE_ID", unique=true)
//	@Predicate(label = "Affectation des Elèves",group = true,groupName = "tab1",groupLabel = "Affectation des Elèves",target = "many-to-many-list",type = Eleve.class,search = false)
//	private List<Eleve> elevelist = new ArrayList<Eleve>();
//	


	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Classe(Classe filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName);
		this.libelle = filiere.libelle;
		this.niveau= new Niveau( filiere.niveau);
		this.typeformation=filiere.typeformation;
		this.filiere= new Filiere(filiere.filiere);
		this.effectif=filiere.effectif;
		this.professeur= new Professeur(filiere.professeur);
		//this.elevelist= new ArrayList<Eleve>();
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


	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}


	public int compareTo(Classe o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
