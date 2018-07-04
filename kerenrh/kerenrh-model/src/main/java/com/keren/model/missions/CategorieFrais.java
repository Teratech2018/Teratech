/**
 * 
 */
package com.keren.model.missions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.model.comptabilite.Compte;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_CATFRARH")
public class CategorieFrais extends BaseElement implements Serializable, Comparable<CategorieFrais> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5487725297266618239L;
	
	@Predicate(label="Reference",optional=false,unique=true,search=true)
	@Column(unique=true)
	private String code ;
	
	@Predicate(label="Intitulé",search=true)
	private String intitule ;
	
	@Predicate(label="Type de depense",target="combobox",values="Transport;Hébergement;Communication;Autres",optional=false,search=true)
	private String type ="0";
	
	@ManyToOne
	@JoinColumn(name="COMP_ID")
	@Predicate(label="Compte de charge",type=Compte.class,target="many-to-one",search=true)
	private Compte compte ;
	
	@OneToMany(fetch=FetchType.LAZY,orphanRemoval=true,cascade=CascadeType.ALL)
	@JoinColumn(name="CAFRA_ID")
	@Predicate(label=".",type=GrilleFrais.class,target="one-to-many",edittable=true,group=true,groupName="group2",groupLabel="Grille de Frais")
	private List<GrilleFrais> grille = new ArrayList<GrilleFrais>();

	/**
	 * 
	 */
	public CategorieFrais() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public CategorieFrais(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param intitule
	 * @param type
	 * @param compte
	 * @param grille
	 */

	public CategorieFrais(long id, String designation, String moduleName, String code, String intitule, String type,
			Compte compte, List<GrilleFrais> grille) {
		super(id, designation, moduleName,0L);
		this.code = code;
		this.intitule = intitule;
		this.type = type;
		this.compte = compte;
		this.grille = grille;
	}
	
	public CategorieFrais(CategorieFrais frais) {
		super(frais.id, frais.designation, frais.moduleName,frais.compareid);
		this.code = frais.code;
		this.intitule = frais.intitule;
		this.type = frais.type;
		if(frais.compte!=null){
			this.compte = new Compte(frais.compte);
		}
//		this.grille = grille;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public List<GrilleFrais> getGrille() {
		return grille;
	}

	public void setGrille(List<GrilleFrais> grille) {
		this.grille = grille;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Catégorie frais de mission";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Catégories frais de mission";
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
	public int compareTo(CategorieFrais o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
