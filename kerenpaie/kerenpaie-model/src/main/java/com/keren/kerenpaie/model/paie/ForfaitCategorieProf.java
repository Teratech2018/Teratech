/**
 * 
 */
package com.keren.kerenpaie.model.paie;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.kerenpaie.model.employes.Fonction;
import com.keren.kerenpaie.model.structures.Departement;
import com.keren.kerenpaie.model.structures.Societe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_FOCAPR")
public class ForfaitCategorieProf extends BaseElement implements Serializable, Comparable<ForfaitCategorieProf> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2290955710589999766L;
	
	@ManyToOne
	@JoinColumn(name="FONC_ID")
	@Predicate(label="Catégorie Professionelle",type=Fonction.class,target="many-to-one",optional=false,search=true)
	private Fonction categorie ;
	
//	@ManyToOne
//	@JoinColumn(name="SOC_ID")
//	@Predicate(label="Structure",type=Societe.class,target="many-to-one",search=true)
//	private Societe sructure ;
	
	
	@ManyToOne
	@JoinColumn(name="SERV_ID")
	@Predicate(label="Service",type=Departement.class,target="many-to-one",search=true)
	private Departement service ;	
	
	
	@Predicate(label="Valeur",type=Double.class,optional=false,search=true)
	private Double valeur =0.0;

	@Predicate(label="Mesure",target="combobox",values="Montant Fixe;Pourcentage salaire de base" ,search=true)
	private String mesure="0";
	
	
	/**
	 * 
	 */
	public ForfaitCategorieProf() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ForfaitCategorieProf(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param categorie
	 * @param societe
	 * @param service
	 * @param valeur
	 * @param mesure
	 */

	public ForfaitCategorieProf(long id, String designation, String moduleName, Fonction categorie, Societe societe,
			Departement service, Double valeur, String mesure) {
		super(id, designation, moduleName);
		this.categorie = categorie;
//		this.societe = societe;
		this.service = service;
		this.valeur = valeur;
		this.mesure = mesure;
	}

	public ForfaitCategorieProf(ForfaitCategorieProf forfait) {
		super(forfait.id, forfait.designation, forfait.moduleName);
		this.categorie = forfait.categorie;
//		this.societe = forfait.societe;
		if(forfait.service!=null){
			this.service = new Departement(forfait.service);
		}
		this.valeur = forfait.valeur;
		this.mesure = forfait.mesure;
	}
	
	

	public Fonction getCategorie() {
		return categorie;
	}

	public void setCategorie(Fonction categorie) {
		this.categorie = categorie;
	}

//	public Societe getSociete() {
//		return societe;
//	}
//
//	public void setSociete(Societe societe) {
//		this.societe = societe;
//	}

	public Departement getService() {
		return service;
	}

	public void setService(Departement service) {
		this.service = service;
	}

	public Double getValeur() {
		return valeur;
	}

	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}

	public String getMesure() {
		return mesure;
	}

	public void setMesure(String mesure) {
		this.mesure = mesure;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Forfait";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return super.getListTitle();
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return categorie.getDescription();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ForfaitCategorieProf arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
