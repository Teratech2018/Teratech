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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.keren.courrier.model.courrier.CourrierTrier;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.courrier.FichierLieTri;
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
public class LiasseDocumentTri extends BaseElement implements Serializable,Comparable<LiasseDocumentTri>{

    @Predicate(label ="Réference",optional = false,unique = true,search = true)
    private String code;
    
    @Predicate(label = "Intitulé",optional = false,search = true)
    private String intitule ;
    

	@Column(name = "D_TRI")
	@Predicate(label = "Date de Tri", optional = false, updatable = true, search = false, type = Date.class, target = "date")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dtri;
	
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
	@JoinColumn(name = "LIASTRI_ID")
//	@Predicate(label = "Courrier", type = CourrierTrier.class, target = "one-to-many", edittable = false, group = true, groupName = "group1", groupLabel = "Dossier à Archiver")
//    @Observer(observable="dossier",source="method:findcourrier")
	private List<CourrierTrier> courriers = new ArrayList<CourrierTrier>();
    
    
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY, orphanRemoval=true)
    @JoinColumn(name="LIASDOC_ID")
	@Predicate(label = "Pièces jointes", type = FichierLieTri.class, target = "one-to-many", edittable = true, group = true, groupName = "group1", groupLabel = "Général")
    @Observer(observable="dossier",source="method:findpiece")
    private List<FichierLieTri> piecesjointes = new ArrayList<FichierLieTri>();
    
	@ManyToOne
	@JoinColumn(name = "BORD_ID")
	private BorderoLiasse bordero;
	
	@Predicate(label = "Etat", search = true, hide = true)
	private String state = "etabli";
	
	@Predicate(label = "Trier(?)",target = "checkbox",search = true)
    private Boolean statut = Boolean.FALSE;
	
    
    
     
   
    
    public LiasseDocumentTri(String code, String intitule, Date dtri, UtilisateurCourrier source,
			StructureCompany sowner, StructureCompany service, DossierCourrier dossier,
			List<CourrierTrier> courriers, List<FichierLieTri> piecesjointes) {
		super();
		this.code = code;
		this.intitule = intitule;
		this.dtri = dtri;
		this.source = source;
		this.sowner = sowner;
		this.service = service;
		this.dossier = dossier;
		this.courriers = courriers;
		this.piecesjointes = piecesjointes;
	}



	public LiasseDocumentTri(LiasseDocumentTri entity) {
    	 super(entity.id, entity.designation, entity.moduleName, entity.compareid);
		this.code = entity.code;
		this.intitule =  entity.intitule;
		this.dossier = new DossierCourrier(entity.dossier) ;
		this.courriers = new ArrayList<CourrierTrier>();
		this.piecesjointes = new ArrayList<FichierLieTri>();
		
		this.dtri = entity.dtri;
		if(entity.source!=null){
			this.source = new UtilisateurCourrier(entity.source);
		}	
		if(entity.sowner!=null){
			this.sowner = new StructureCompany(entity.sowner);
		}
		if(entity.service!=null){
			this.service = new StructureCompany(entity.service);
		}
		
		if(entity.bordero!=null){
			this.bordero= new BorderoLiasse(entity.bordero);
		}
		
		this.state=entity.state;
		this.statut=entity.statut;
	}



	/**
     * 
     */
    public LiasseDocumentTri() {
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
        return "Trier la Liasse"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Trier la Liasse"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }
     
   


	public List<CourrierTrier> getCourriers() {
		return courriers;
	}



	public void setCourriers(List<CourrierTrier> courriers) {
		this.courriers = courriers;
	}



	public List<FichierLieTri> getPiecesjointes() {
		return piecesjointes;
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



	public Boolean getStatut() {
		return statut;
	}



	public void setStatut(Boolean statut) {
		this.statut = statut;
	}



	public Date getDtri() {
		return dtri;
	}



	public void setDtri(Date dtri) {
		this.dtri = dtri;
	}



	public DossierCourrier getDossier() {
		return dossier;
	}



	public void setDossier(DossierCourrier dossier) {
		this.dossier = dossier;
	}



	public void setService(StructureCompany service) {
		this.service = service;
	}

	public void setPiecesjointes(List<FichierLieTri> piecesjointes) {
		this.piecesjointes = piecesjointes;
	}



	@Override
    public int compareTo(LiasseDocumentTri o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
