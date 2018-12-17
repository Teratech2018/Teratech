package com.kerenedu.solde;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.referentiels.Societe;
import com.megatim.common.annotations.Predicate;

@Entity
@Table(name="e_forfcat")
public class ForfaitCategorie extends BaseElement implements Serializable, Comparable<ForfaitCategorie> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2290955710589999766L;
	
	@ManyToOne
	@JoinColumn(name="FONC_ID")
	@Predicate(label="Catégorie ",type=Categorie.class,target="many-to-one",optional=false,search=true)
	private Categorie categorie ;
	
//	@ManyToOne
//	@JoinColumn(name="SOC_ID")
//	@Predicate(label="Structure",type=Societe.class,target="many-to-one",search=true)
//	private Societe sructure ;
	
	
	
	@Predicate(label="Valeur",type=Double.class,optional=false,search=true)
	private Double valeur =0.0;

	@Predicate(label="Mesure",target="combobox",values="Montant Fixe;Par Heures" ,search=true)
	private String mesure="0";
	
	
	/**
	 * 
	 */
	public ForfaitCategorie() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ForfaitCategorie(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
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

	public ForfaitCategorie(long id, String designation, String moduleName, Categorie categorie, Societe societe,
 Double valeur, String mesure) {
		super(id, designation, moduleName,0L);
		this.categorie = categorie;
        this.valeur = valeur;
		this.mesure = mesure;
	}

	public ForfaitCategorie(ForfaitCategorie forfait) {
		super(forfait.id, forfait.designation, forfait.moduleName,forfait.compareid);
		this.categorie = new Categorie(forfait.categorie);
//		this.societe = forfait.societe;
		this.valeur = forfait.valeur;
		this.mesure = forfait.mesure;
	}
	
	public ForfaitCategorie(Categorie forfait) {
		this.id= -forfait.getId();
		this.categorie = new Categorie(forfait);
		this.valeur = new Double(0);
		this.mesure = "0";
	}
	
	



	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
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
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return categorie.getDesignation();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	//@Override
	public int compareTo(ForfaitCategorie arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
