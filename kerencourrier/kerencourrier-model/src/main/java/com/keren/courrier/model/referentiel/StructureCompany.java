/**
 * 
 */
package com.keren.courrier.model.referentiel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.courrier.model.others.UtilisateurClone;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_DEPSOC")
public class StructureCompany extends BaseElement implements Serializable, Comparable<StructureCompany> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8474421046166007279L;
	
	@Predicate(label="Code",optional=false,unique=true,search=true)
	private String code ;
	
	@Predicate(label="Actif",type=Boolean.class,search=true)
	private Boolean actif = Boolean.TRUE;
	
	@Predicate(label="Nom du service",optional=false,search=true)
	private String nom ;
	
	@ManyToOne
	@JoinColumn(name="DEP_ID")
	@Predicate(label="Service parent",type=StructureCompany.class,target="many-to-one",search=true)
	private StructureCompany parent ;
	
	@ManyToOne
	@JoinColumn(name="CUSER_ID")
	@Predicate(label="Responsable",optional=false,type=UtilisateurClone.class,target="many-to-one",search=true)
	private UtilisateurClone responsable ;
	
	@Predicate(label="Type",search=true,target="combobox",values="Antenne;Direction;Sous-direction;Service;Bureau")
	private String type ="0";
        
//        @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
//        @JoinColumn(name = "LIDI_ID")
//        @Predicate(label = "Par utilitisateurs",type = LigneDiffusion.class,target = "one-to-many",edittable = true,group = true,groupName = "group1",groupLabel = "Diffusions")
//        private List<LigneDiffusion> intervenants = new ArrayList<LigneDiffusion>();
//        
//        @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
//        @JoinColumn(name = "LIDI_ID")
//        @Predicate(label = "Par services",type = ServiceDiffusion.class,target = "one-to-many",edittable = true,group = true,groupName = "group1",groupLabel = "Diffusions")
//        private List<ServiceDiffusion> services = new ArrayList<ServiceDiffusion>();

        
	/**
	 * 
	 */
	public StructureCompany() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public StructureCompany(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}

	
	
	
	public StructureCompany(StructureCompany dep) {
		super(dep.id, dep.designation, dep.moduleName,dep.compareid);
		this.code = dep.code;
		this.nom = dep.nom;
		this.actif = dep.actif;
		if(dep.responsable!=null){
			this.responsable = new UtilisateurClone(dep.responsable);
		}
		if(dep.parent!=null){
			this.parent = new StructureCompany(dep.parent);
		}
		this.type = dep.type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

    public UtilisateurClone getResponsable() {
        return responsable;
    }

    public void setResponsable(UtilisateurClone responsable) {
        this.responsable = responsable;
    }

	

	public StructureCompany getParent() {
		return parent;
	}

	public void setParent(StructureCompany parent) {
		this.parent = parent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

//    public List<LigneDiffusion> getIntervenants() {
//        return intervenants;
//    }
//
//    public void setIntervenants(List<LigneDiffusion> intervenants) {
//        this.intervenants = intervenants;
//    }
//
//    public List<ServiceDiffusion> getServices() {
//        return services;
//    }
//
//    public void setServices(List<ServiceDiffusion> services) {
//        this.services = services;
//    }
   

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "SERVICE";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "SERVICES";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerencourrier";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" - "+nom;
	}

	@Override
	public int compareTo(StructureCompany o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
