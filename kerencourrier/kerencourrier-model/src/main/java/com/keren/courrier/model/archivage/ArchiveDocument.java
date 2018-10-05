/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.archivage;

import com.core.base.BaseElement;
import com.keren.courrier.model.courrier.FichierLie;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_ARCDOCGC")
public class ArchiveDocument extends BaseElement implements Serializable,Comparable<ArchiveDocument>{

    @Predicate(label = "Reference",optional = false,search = true)
    private String code ;
    
    @Predicate(label = "Intitulé",optional = false,search = true)
    private String intitule;
    
    @ManyToOne
    @JoinColumn(name = "CAD_ID")
    @Predicate(label = "Numéro de série",type = CadreClassement.class,target = "many-to-one",search = true)
    private CadreClassement cadre ;
    
     @ManyToOne
    @JoinColumn(name = "BOI_ID")
    @Predicate(label = "Boîte d'archivage",type = BoiteArchivage.class,target = "many-to-one",search = true)
    private BoiteArchivage boite ;
    
    @Predicate(label = "Mots clés",optional = false, search = true)
    private String motscles;
    
    @Predicate(label = "Auteur",optional = false,search = false)
    private String auteur ;
    
    @Predicate(label = "Resumé",optional = true,search = false)
    private String description;
    
    @Predicate(label = "Nombre de page",type = Short.class,search = false)
    private Short nbrepages = 0 ;
    
    @Predicate(label = "Editeur",optional = true,search = false)
    private String editeur ;
    
    @Predicate(label = "Publié par",optional = true,search = true)
    private String publisher ;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Date publication",type = Date.class,target = "date",optional = true,search = true)
    private Date dpublisher;
    
    @Predicate(label = "Observation",optional = true,search = false)
    private String observation;
    
    //@Predicate(label = "Mention du courrier", target = "combobox", values = "Documents;Dossiers;Liasses", search = true)
	private String nature = " ";
    
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY, orphanRemoval=true)
    @JoinColumn(name="ARCDOC_ID")
	@Predicate(label = "Pièces jointes", type = FichierLie.class, target = "one-to-many", edittable = true, group = true, groupName = "group1", groupLabel = "Documents Archivé")
    private List<FichierLie> piecesjointes = new ArrayList<FichierLie>();
     
     
    @Override
    public int compareTo(ArchiveDocument o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }


	public ArchiveDocument(String code, String intitule, CadreClassement cadre, BoiteArchivage boite, String motscles,
			String auteur, String description, Short nbrepages, String editeur, String publisher, Date dpublisher,
			String observation, List<FichierLie> piecesjointes) {
		super();
		this.code = code;
		this.intitule = intitule;
		this.cadre = cadre;
		this.boite = boite;
		this.motscles = motscles;
		this.auteur = auteur;
		this.description = description;
		this.nbrepages = nbrepages;
		this.editeur = editeur;
		this.publisher = publisher;
		this.dpublisher = dpublisher;
		this.observation = observation;
		this.piecesjointes = piecesjointes;
	}
	

	public ArchiveDocument(ArchiveDocument entity) {
		super(entity.id, entity.designation, entity.moduleName, entity.compareid);
		this.code = entity.code;
		this.intitule = entity.intitule;
		this.cadre = entity.cadre;
		this.boite = entity.boite;
		this.motscles = entity.motscles;
		this.auteur = entity.auteur;
		this.description = entity.description;
		this.nbrepages = entity.nbrepages;
		this.editeur = entity.editeur;
		this.publisher = entity.publisher;
		this.dpublisher = entity.dpublisher;
		this.observation = entity.observation;
		this.piecesjointes = new ArrayList<FichierLie>();
	}



	public ArchiveDocument() {
		// TODO Auto-generated constructor stub
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getIntitule() {
		return intitule;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public CadreClassement getCadre() {
		return cadre;
	}


	public void setCadre(CadreClassement cadre) {
		this.cadre = cadre;
	}


	public BoiteArchivage getBoite() {
		return boite;
	}


	public void setBoite(BoiteArchivage boite) {
		this.boite = boite;
	}


	public String getMotscles() {
		return motscles;
	}


	public void setMotscles(String motscles) {
		this.motscles = motscles;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Short getNbrepages() {
		return nbrepages;
	}


	public void setNbrepages(Short nbrepages) {
		this.nbrepages = nbrepages;
	}


	public String getEditeur() {
		return editeur;
	}


	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public Date getDpublisher() {
		return dpublisher;
	}


	public void setDpublisher(Date dpublisher) {
		this.dpublisher = dpublisher;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public String getNature() {
		return nature;
	}


	public void setNature(String nature) {
		this.nature = nature;
	}


	public List<FichierLie> getPiecesjointes() {
		return piecesjointes;
	}


	public void setPiecesjointes(List<FichierLie> piecesjointes) {
		this.piecesjointes = piecesjointes;
	}
	 @Override
	    public String getListTitle() {
	        return "Archives des Documents "; 
	    }

	    @Override
	    public String getEditTitle() {
	        return "Archiver un Document"; 
	    }
    
}
