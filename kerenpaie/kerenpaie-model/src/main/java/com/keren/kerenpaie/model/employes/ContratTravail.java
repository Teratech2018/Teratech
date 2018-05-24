/**
 * 
 */
package com.keren.kerenpaie.model.employes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_COTRP")
public class ContratTravail extends BaseElement implements Serializable, Comparable<ContratTravail> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4727779632422483905L;
	
	@Predicate(label="Référence du contrat",optional=false,search=true)
	private String code ;
	
	@ManyToOne
	@JoinColumn(name="EMPL_ID")
	@Predicate(label="Salarié",type=Employe.class,target="many-to-one",optional=false,search=true)
	private Employe employe ;
	
	@ManyToOne
	@JoinColumn(name="CATE_ID")
	@Predicate(label="Catégorie",type=Categorie.class,target="many-to-one",optional=false,search=true)
	private Categorie categorie;

	@ManyToOne
	@JoinColumn(name="ECHE_ID")
	@Predicate(label="Echelon",type=Echelon.class,target="many-to-one",optional=false,search=true)
	private Echelon echelon ;
	
	@ManyToOne
	@JoinColumn(name="TYCO_ID")
	@Predicate(label="Type de Contrat",type=TypeContrat.class,target="many-to-one",optional=false,search=true)
	private TypeContrat type ;
	
	@Predicate(label="Indice Solde",type=Short.class,hidden="currentObject.type.categorie!='2'")
	private Short indice = 0 ;
	
	@ManyToOne
	@JoinColumn(name="FONC_ID")
	@Predicate(label="Emploi",type=Fonction.class,target="many-to-one",optional=false,search=true)
	private Fonction fonction ;
	
        @Predicate(label="Date fin période essai",type=Date.class,target="date",search=true)
	@Temporal(TemporalType.DATE)
	private Date fessai ;
        
	@Predicate(label="Date début période essai",type=Date.class,target="date",search=true)
	@Temporal(TemporalType.DATE)
	private Date dessai ;
	
	@Predicate(label="Lieu d'affectation")
	private String lieuaff ;
	
	@Predicate(label="Lieu de recrutement")
	private String lieurecr ;
	
        @Predicate(label="Date d'arrêt de service",type=Date.class,target="date",search=true)
	@Temporal(TemporalType.DATE)
	private Date darret;
        
	@Predicate(label="Date de recrutement",type=Date.class,target="date",search=true)
	@Temporal(TemporalType.DATE)
	private Date drecurtement ;
	
	@Predicate(label="Ancienité gélée",type=Short.class,group=true,groupName="group1",groupLabel="Conditions particulières")
	private Short gele = 0;
	
	@Predicate(label="Médialle",type=Short.class,group=true,groupName="group1",groupLabel="Conditions particulières")
	private Short medialles = 0;
	
	@Predicate(label="Notes",type=String.class,target="textarea",group=true,groupName="group2",groupLabel="Notes")
	private String commentaire ;
	
        @Predicate(label="Etat du Contrat",hide=true ,search=true, updatable = false)
	private String state ="etabli";
	/**
	 * 
	 */
	public ContratTravail() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ContratTravail(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param employe
	 * @param categorie
	 * @param type
	 * @param echelon
	 * @param fonction
	 * @param dessai
	 * @param fessai
	 * @param lieuaff
	 * @param lieurecr
	 * @param drecurtement
	 * @param darret
	 */

	public ContratTravail(long id, String designation, String moduleName, String code, Employe employe,
			Categorie categorie, TypeContrat type, Echelon echelon, Fonction fonction, Date dessai, Date fessai,
			String lieuaff, String lieurecr, Date drecurtement, Date darret) {
		super(id, designation, moduleName);
		this.code = code;
		this.employe = employe;
		this.categorie = categorie;
		this.type = type;
		this.echelon = echelon;
		this.fonction = fonction;
		this.dessai = dessai;
		this.fessai = fessai;
		this.lieuaff = lieuaff;
		this.lieurecr = lieurecr;
		this.drecurtement = drecurtement;
		this.darret = darret;
		
	}
	
	public ContratTravail(ContratTravail contrat) {
		super(contrat.id, contrat.designation, contrat.moduleName);
		this.code = contrat.code;
		if(contrat.employe!=null){
			this.employe = new Employe(contrat.employe);
		}
		if(contrat.categorie!=null){
			this.categorie = new Categorie(contrat.categorie);
		}
		this.type = contrat.type;
		this.echelon = contrat.echelon;
		if(contrat.fonction!=null){
			this.fonction = new Fonction(contrat.fonction);
		}
		this.dessai = contrat.dessai;
		this.fessai = contrat.fessai;
		this.lieuaff = contrat.lieuaff;
		this.lieurecr = contrat.lieurecr;
		this.drecurtement = contrat.drecurtement;
		this.darret = contrat.darret;
		this.gele = contrat.gele;
		this.medialles = contrat.medialles;
		this.commentaire = contrat.commentaire;
		this.state = contrat.state;
		this.indice = contrat.indice;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public TypeContrat getType() {
		return type;
	}

	public void setType(TypeContrat type) {
		this.type = type;
	}

	public Echelon getEchelon() {
		return echelon;
	}

	public void setEchelon(Echelon echelon) {
		this.echelon = echelon;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Date getDessai() {
		return dessai;
	}

	public void setDessai(Date dessai) {
		this.dessai = dessai;
	}

	public Date getFessai() {
		return fessai;
	}

	public void setFessai(Date fessai) {
		this.fessai = fessai;
	}

	public String getLieuaff() {
		return lieuaff;
	}

	public void setLieuaff(String lieuaff) {
		this.lieuaff = lieuaff;
	}

	public String getLieurecr() {
		return lieurecr;
	}

	public void setLieurecr(String lieurecr) {
		this.lieurecr = lieurecr;
	}

	public Date getDrecurtement() {
		return drecurtement;
	}

	public void setDrecurtement(Date drecurtement) {
		this.drecurtement = drecurtement;
	}

	public Date getDarret() {
		return darret;
	}

	public void setDarret(Date darret) {
		this.darret = darret;
	}
	
	

	public Short getGele() {
		return gele;
	}

	public void setGele(Short gele) {
		this.gele = gele;
	}

	public Short getMedialles() {
		return medialles;
	}

	public void setMedialles(Short medialles) {
		this.medialles = medialles;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	

	public Short getIndice() {
		return indice;
	}

	public void setIndice(Short indice) {
		this.indice = indice;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
        
        

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Contrat de Travail ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Contrats de Travail ";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}

	@Override
	public String getSerial() {
		// TODO Auto-generated method stub
		return Long.toString(serialVersionUID);
	}

	@Override
	public boolean isActivefilelien() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> states = new ArrayList<State>();
		State state = new State("etabli", "Brouillon");
		states.add(state);
		state = new State("confirme", "En Cours");
		states.add(state);
		state = new State("cloture", "Terminé");
		states.add(state);
		return states;
	}

	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ContratTravail arg0) {
		// TODO Auto-generated method stub
		return code.compareTo(arg0.code);
	}

}
