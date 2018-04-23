/**
 * 
 */
package com.keren.model.structures;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.model.employes.Employe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_DEPSOC")
public class Departement extends BaseElement implements Serializable, Comparable<Departement> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8474421046166007279L;
	
	@Predicate(label="Code",optional=false,unique=true,search=true)
	private String code ;
	
	@Predicate(label="Actif",type=Boolean.class,search=true)
	private Boolean actif = Boolean.TRUE;
	
	@Predicate(label="Nom du département",optional=false,search=true)
	private String nom ;
	
	@ManyToOne
	@JoinColumn(name="DEP_ID")
	@Predicate(label="Departement parent",type=Departement.class,target="many-to-one",search=true)
	private Departement parent ;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	@Predicate(label="Responsable",type=Employe.class,target="many-to-one",search=true)
	private Employe responsable ;
	
	@Predicate(label="Type",search=true,target="combobox",values="Antenne;Direction;Sous-direction;Services;Bureau")
	private String type ="0";

	/**
	 * 
	 */
	public Departement() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Departement(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}

	
	
	
	public Departement(Departement dep) {
		super(dep.id, dep.designation, dep.moduleName);
		this.code = dep.code;
		this.nom = dep.nom;
		this.actif = dep.actif;
		if(dep.responsable!=null){
			this.responsable = new Employe(dep.responsable);
		}
		if(dep.parent!=null){
			this.parent = new Departement(dep.parent);
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

	public Employe getResponsable() {
		return responsable;
	}

	public void setResponsable(Employe responsable) {
		this.responsable = responsable;
	}

	public Departement getParent() {
		return parent;
	}

	public void setParent(Departement parent) {
		this.parent = parent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "DEPARTEMENT";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "DEPARTEMENTS";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" - "+nom;
	}

	@Override
	public int compareTo(Departement o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

    @Override
    public String toString() {
        return "Departement{" + "code=" + code + ", actif=" + actif + ", nom=" + nom + ", parent=" + parent + ", responsable=" + responsable + ", type=" + type + '}';
    }
        
        

}
