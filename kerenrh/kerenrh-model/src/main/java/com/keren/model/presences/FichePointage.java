/**
 * 
 */
package com.keren.model.presences;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.model.employes.DepartementSoc;
import com.keren.model.structures.Departement;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_FIPORH")
public class FichePointage extends BaseElement implements Serializable, Comparable<FichePointage> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5845841836587944100L;
	
	@Predicate(label="Code de la Fiche",optional=false,unique=true,search=true)
	private String code ;
	
	private Boolean actif = Boolean.TRUE;
	
	@Predicate(label="Intitulé de la fiche",search=true)
	private String intitule ;	
        
	@ManyToOne
	@JoinColumn(name="DEP_ID")
	@Predicate(label="Département",type=Departement.class,target="many-to-one",search=true,updatable=true)
	private Departement departement;
        
	@Predicate(label="Générer pour" ,target="combobox",values="Tout les employes;Pour un département",search=true,observable=true,updatable=true)
	private String porte ="0";	
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JoinColumn(name="FIPO_ID")
	@Predicate(label="Fiche pointage",type=LigneFichePointage.class,target="one-to-many",group=true,groupName="group1",groupLabel="POINTAGES",edittable=true)
	@Observer(observable="porte",source="method:presence",parameters="departement")
	private List<LigneFichePointage> lignes = new ArrayList<LigneFichePointage>();

	/**
	 * 
	 */
	public FichePointage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public FichePointage(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	
/**
 * 
 * @param id
 * @param designation
 * @param moduleName
 * @param code
 * @param actif
 * @param intitule
 * @param porte
 * @param departement
 * @param lignes
 */
	public FichePointage(long id, String designation, String moduleName, String code, Boolean actif, String intitule,
			String porte, Departement departement, List<LigneFichePointage> lignes) {
		super(id, designation, moduleName);
		this.code = code;
		this.actif = actif;
		this.intitule = intitule;
		this.porte = porte;
		this.departement = departement;
		this.lignes = lignes;
	}
	
	/**
	 * 
	 * @param fiche
	 */
	public FichePointage(FichePointage fiche) {
		super(fiche.id, fiche.designation, fiche.moduleName);
		this.code = fiche.code;
		this.actif = fiche.actif;
		this.intitule = fiche.intitule;
		this.porte = fiche.porte;
		if(fiche.departement!=null){
			this.departement = new Departement(fiche.departement);
		}
		
	}	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public List<LigneFichePointage> getLignes() {
		return lignes;
	}

	public void setLignes(List<LigneFichePointage> lignes) {
		this.lignes = lignes;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "FICHE DE POINTAGE";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "FICHES DE POINTAGE";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" - "+intitule;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(FichePointage arg0) {
		// TODO Auto-generated method stub
		return code.compareTo(arg0.code);
	}

	@Override
	public String toString() {
		return "FichePointage [code=" + code + ", actif=" + actif + ", intitule=" + intitule + ", porte=" + porte
				+ ", departement=" + departement + ", lignes=" + lignes + "]";
	}
	
	

}
