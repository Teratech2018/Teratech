package com.kerenedu.solde;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.referentiels.Societe;
import com.kerenedu.configuration.Cycle;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

@Entity
@Table(name="e_forfpers")
public class ForfaitPersonnel extends BaseElement implements Serializable, Comparable<ForfaitPersonnel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2290955710589999766L;
	
	@Column(name = "MAT", unique = true)
	@Predicate(label = "Matricule", optional = true, updatable = true, search = true, sequence = 1,editable=false)
	@Observer(observable = "personnel", source = "field:matricule")
	protected String matricule;


	@Column(name = "NOM", unique = true)
	@Predicate(label = "NOM", optional = false, updatable = true, search = true, sequence = 2, hide=true)
	@Observer(observable = "personnel", source = "field:nom")
	protected String nom;
	
	@ManyToOne
	@JoinColumn(name="PERS_ID")
	@Predicate(label="Personnel ",type=Professeur.class,target="many-to-one",optional=false,search=true)
	private Professeur personnel ;
	
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
	public ForfaitPersonnel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ForfaitPersonnel(long id, String designation, String moduleName) {
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

	public ForfaitPersonnel(long id, String designation, String moduleName, Professeur personnel, Societe societe,
 Double valeur, String mesure) {
		super(id, designation, moduleName,0L);
		this.personnel = personnel;
        this.valeur = valeur;
		this.mesure = mesure;
	}

	public ForfaitPersonnel(ForfaitPersonnel forfait) {
		super(forfait.id, forfait.designation, forfait.moduleName,forfait.compareid);
		if(forfait.personnel!=null){
			this.nom=forfait.getPersonnel().getNom();
			this.matricule=forfait.getPersonnel().getMatricule();
			this.personnel = new Professeur(forfait.personnel) ;
		}
		
//		this.societe = forfait.societe;
		this.valeur = forfait.valeur;
		this.mesure = forfait.mesure;
		this.nom=forfait.nom;
		this.matricule=forfait.matricule;
	}
	
	public ForfaitPersonnel(Professeur forfait) {
		this.id=-forfait.getId();
		if(forfait!=null){
			this.nom=forfait.getNom();
			this.matricule=forfait.getMatricule();
			this.personnel = new Professeur(forfait) ;
		}
		this.valeur = new Double(0);
		this.mesure = "0";
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

	public Professeur getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Professeur personnel) {
		this.personnel = personnel;
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return nom;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	//@Override
	public int compareTo(ForfaitPersonnel arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
