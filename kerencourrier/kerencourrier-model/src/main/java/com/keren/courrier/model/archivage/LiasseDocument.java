/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.archivage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.keren.courrier.model.courrier.CourrierAArchiver;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.referentiel.DossierCourrier;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.keren.courrier.model.referentiel.TypeDossier;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_LIADOC")
public class LiasseDocument extends BaseElement implements Serializable,Comparable<LiasseDocument>{

    @Predicate(label = "Réference",optional = false,unique = true,search = true, editable=true)
    private String code;
    
    @Predicate(label = "Intitulé",optional = false,search = true)
    private String intitule ;
    

	@Column(name = "D_LIASS")
	@Predicate(label = "Date de Création", optional = false, updatable = false, search = false, type = Date.class, target = "date")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dliasse;
	
	@ManyToOne
	@JoinColumn(name = "SOUR_ID")
	private UtilisateurCourrier source;

	@ManyToOne
	@JoinColumn(name = "OWSERV_ID")
	private StructureCompany sowner;
	
	@ManyToOne
	@JoinColumn(name = "T_SERV")
	@Predicate(label = "Service Archive", type = StructureCompany.class, target = "many-to-one", updatable = false, search = true, optional = true, observable = true)
	private StructureCompany service;
    
	@ManyToOne
	@JoinColumn(name = "T_DOS")
	@Predicate(label = "Dossier", type = DossierCourrier.class, target = "many-to-one", updatable = false, search = false, optional = true, observable = true)
	private DossierCourrier dossier;
	
    
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY, orphanRemoval=true)
    @JoinColumn(name="LIASDOC_ID")
	@Predicate(label = "Pièces jointes", type = FichierLie.class, target = "one-to-many", edittable = true, group = true, groupName = "group1", groupLabel = "Piéces à Archiver")
	@Observer(observable="dossier",source="method:findpiece")
    private List<FichierLie> piecesjointes = new ArrayList<FichierLie>();
    
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY, orphanRemoval=true)
	@JoinColumn(name = "LIASDOC_ID")
//	@Predicate(label = "Courrier", type = CourrierClone.class, target = "one-to-many", edittable = false, group = true, groupName = "group1", groupLabel = "Dossier à Archiver", hide=true)
//    @Observer(observable="dossier",source="method:findcourrier")
	private List<CourrierClone> courriers = new ArrayList<CourrierClone>();
    
	@ManyToOne
	@JoinColumn(name = "BORD_ID")
	private BorderoLiasse bordero;
	
	@Predicate(label = "Etat", search = true, hide = true)
	private String state = "etabli";
    
    
     
   
    
    public LiasseDocument(String code, String intitule, Date dliasse, UtilisateurCourrier source,
			StructureCompany sowner, StructureCompany service, TypeDossier typeDossier,
			List<CourrierClone> courriers, List<FichierLie> piecesjointes) {
		super();
		this.code = code;
		this.intitule = intitule;
		this.dliasse = dliasse;
		this.source = source;
		this.sowner = sowner;
		this.service = service;
		this.courriers = courriers;
		this.piecesjointes = piecesjointes;
	}



	public LiasseDocument(LiasseDocument entity) {
    	 super(entity.id, entity.designation, entity.moduleName, entity.compareid);
		this.code = entity.code;
		this.intitule =  entity.intitule;
		if(entity.dossier!=null){
			this.dossier =  new DossierCourrier(entity.dossier);
		}
		
		this.courriers = new ArrayList<CourrierClone>();
		this.piecesjointes = new ArrayList<FichierLie>();
		
		this.dliasse = entity.dliasse;
		if(entity.source!=null){
			this.source = new UtilisateurCourrier(entity.source);
		}
		if(entity.sowner!=null){
			this.sowner = new StructureCompany(entity.sowner);
		}
		if(entity.service!=null){
			this.service = new StructureCompany(entity.service);
		}
		this.state=entity.state;
	}



	/**
     * 
     */
    public LiasseDocument() {
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

   
    
    

    @Override
    public String getDesignation() {
        return code+" - "+intitule; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "kerencourrier"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Liasse de Documents"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return " Liasse de Documents"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }
     
   



	public DossierCourrier getDossier() {
		return dossier;
	}



	public void setDossier(DossierCourrier dossier) {
		this.dossier = dossier;
	}



	public List<CourrierClone> getCourriers() {
		return courriers;
	}



	public void setCourriers(List<CourrierClone> courriers) {
		this.courriers = courriers;
	}



	public List<FichierLie> getPiecesjointes() {
		return piecesjointes;
	}



	public Date getDliasse() {
		return dliasse;
	}

	public void setDliasse(Date dliasse) {
		this.dliasse = dliasse;
	}

	public UtilisateurCourrier getSource() {
		return source;
	}

	public void setSource(UtilisateurCourrier source) {
		this.source = source;
	}

	public StructureCompany getSowner() {
		return sowner;
	}

	public void setSowner(StructureCompany sowner) {
		this.sowner = sowner;
	}

	public StructureCompany getService() {
		return service;
	}

	public BorderoLiasse getBordero() {
		return bordero;
	}



	public void setBordero(BorderoLiasse bordero) {
		this.bordero = bordero;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public void setService(StructureCompany service) {
		this.service = service;
	}

	public void setPiecesjointes(List<FichierLie> piecesjointes) {
		this.piecesjointes = piecesjointes;
	}



	@Override
    public int compareTo(LiasseDocument o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
