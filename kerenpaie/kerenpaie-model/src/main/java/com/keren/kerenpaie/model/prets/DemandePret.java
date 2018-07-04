/**
 * 
 */
package com.keren.kerenpaie.model.prets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.kerenpaie.model.employes.Employe;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_DEPRP")
public class DemandePret extends BaseElement implements Serializable, Comparable<DemandePret> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5896264921413540741L;
	
	@ManyToOne
	@JoinColumn(name="CAPR_ID")
	@Predicate(label="Type de prêt",target="many-to-one",type=CategoriePret.class,optional=false,updatable=false,search=true,observable=true)
	private CategoriePret typepret;
	
	@ManyToOne
	@JoinColumn(name="EMPL_ID")
	@Predicate(label="Salarié",type=Employe.class,target="many-to-one",optional=false,updatable=false,search=true)
	private Employe employe ;
	
	@Predicate(label="Date demande de prêt",type=Date.class,target="date",search=true)
	@Temporal(TemporalType.DATE)
	private Date dpret ;
	
	@Predicate(label="Date début de remboursement",type=Date.class,target="date",search=true)
	@Temporal(TemporalType.DATE)
	private Date drembour;
	
	@Predicate(label="Montant sollicité par l'employé",type=Double.class,search=true)
	private Double montantsol=0.0;
	
	@Predicate(label="Montant proposé par la hiérarchie",type=Double.class,search=true)
	private Double montantpro=0.0;
	
	@Predicate(label="Durée du remboursement",type=Short.class,search=true)
	@Observer(observable="typepret",source="field:duree")
	private Short duree = 0 ;
	
	@Predicate(label="Quotité cessible",type=Double.class,search=true)
	private Double quotite=0.0;
	
	@Predicate(label="c",target="textarea",group=true,groupName="group2",groupLabel="Commentaire")
        private String commentaire ;
    
	@OneToMany(fetch=FetchType.LAZY,mappedBy="demande")
	@Predicate(label="Rem",type=RemboursementPret.class,target="one-to-many",editable=false,updatable=false,group=true,groupName="group1",groupLabel="Remboursments")
        private List<RemboursementPret> remboursements = new ArrayList<RemboursementPret>();
    
	@Predicate(label="Status",hide=true ,search=true)
	private String state="etabli";
	/**
	 * 
	 */
	public DemandePret() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public DemandePret(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param typepret
	 * @param employe
	 * @param dpret
	 * @param drembour
	 * @param montantsol
	 * @param montantpro
	 * @param duree
	 * @param quotite
	 * @param commentaire
	 * @param remboursements
	 */

	public DemandePret(long id, String designation, String moduleName, CategoriePret typepret, Employe employe,
			Date dpret, Date drembour, Double montantsol, Double montantpro, Short duree, Double quotite,
			String commentaire, List<RemboursementPret> remboursements) {
		super(id, designation, moduleName,0L);
		this.typepret = typepret;
		this.employe = employe;
		this.dpret = dpret;
		this.drembour = drembour;
		this.montantsol = montantsol;
		this.montantpro = montantpro;
		this.duree = duree;
		this.quotite = quotite;
		this.commentaire = commentaire;
		this.remboursements = remboursements;
	}

	/**
	 * 
	 * @param pret
	 */
	public DemandePret(DemandePret pret) {
		super(pret.id, pret.designation, pret.moduleName,pret.compareid);
		if(pret.typepret!=null){
			this.typepret = new CategoriePret(pret.typepret);
		}
		if(pret.employe!=null){
			this.employe = new Employe(pret.employe);
		}
		this.dpret = pret.dpret;
		this.drembour = pret.drembour;
		this.montantsol = pret.montantsol;
		this.montantpro = pret.montantpro;
		this.duree = pret.duree;
		this.quotite = pret.quotite;
		this.commentaire = pret.commentaire;
		this.state = pret.state;
//		this.remboursements = remboursements;
	}
	
	
	
	public CategoriePret getTypepret() {
		return typepret;
	}

	public void setTypepret(CategoriePret typepret) {
		this.typepret = typepret;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Date getDpret() {
		return dpret;
	}

	public void setDpret(Date dpret) {
		this.dpret = dpret;
	}

	public Date getDrembour() {
		return drembour;
	}

	public void setDrembour(Date drembour) {
		this.drembour = drembour;
	}

	public Double getMontantsol() {
		return montantsol;
	}

	public void setMontantsol(Double montantsol) {
		this.montantsol = montantsol;
	}

	public Double getMontantpro() {
		return montantpro;
	}

	public void setMontantpro(Double montantpro) {
		this.montantpro = montantpro;
	}

	public Short getDuree() {
		return duree;
	}

	public void setDuree(Short duree) {
		this.duree = duree;
	}

	public Double getQuotite() {
		return quotite;
	}

	public void setQuotite(Double quotite) {
		this.quotite = quotite;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public List<RemboursementPret> getRemboursements() {
		return remboursements;
	}

	public void setRemboursements(List<RemboursementPret> remboursements) {
		this.remboursements = remboursements;
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
		return "Demande de Prêt";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Demandes de Prêts";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return employe.getDesignation();
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
		state = new State("confirme", "Validé");
		states.add(state);
		state = new State("encours", "En cours");
		states.add(state);
		state = new State("termine", "Terminé");
		states.add(state);
		state = new State("annule", "Annuler");
		states.add(state);
		return states;
	}

	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(DemandePret o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
