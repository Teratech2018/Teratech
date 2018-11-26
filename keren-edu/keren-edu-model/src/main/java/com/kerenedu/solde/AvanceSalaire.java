/**
 * 
 */
package com.kerenedu.solde;

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
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_AVSAP")
public class AvanceSalaire extends BaseElement implements Serializable, Comparable<AvanceSalaire> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2918162723049219538L;
	
	@ManyToOne
	@JoinColumn(name="RUBR_ID")
	@Predicate(label="Rubrique",type=RubriquePaie.class,target="many-to-one",optional=false,search=true)
	private RubriquePaie rubrique;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	@Predicate(label="Salarié",type=Professeur.class,target="many-to-one",optional=false,search=true)
	private Professeur employe;
	
	@Predicate(label="Date",type=Date.class,target="date",optional=false,search=true)
	@Temporal(TemporalType.DATE)
	private Date date ;
	
	@Predicate(label="Montant",type=Double.class,optional=false,search=true)
	private Double montant=0.0;
	
	@Predicate(label="Durée du remboursement (en Mois)",type=Short.class,optional=false,search=true)
	private Short duree = 0;
	
	@Predicate(label="C",target="textarea",group=true,groupName="group2",groupLabel="Commentaire")
	private String commentaire;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="avance")
	@Predicate(label="Rem",type=RemboursementAvance.class,target="one-to-many",group=true,groupName="group1",groupLabel="Remboursements",editable=false,updatable=false)
	private List<RemboursementAvance> remboursements = new ArrayList<RemboursementAvance>();

	@Predicate(label="Status",hide=true ,search=true)
	private String state="etabli";
	/**
	 * 
	 */
	public AvanceSalaire() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public AvanceSalaire(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param rubrique
	 * @param employe
	 * @param date
	 * @param montant
	 * @param duree
	 * @param commentaire
	 */

	public AvanceSalaire(long id, String designation, String moduleName, RubriquePaie rubrique, Professeur employe, Date date,
			Double montant, Short duree, String commentaire) {
		super(id, designation, moduleName,0L);
		this.rubrique = rubrique;
		this.employe = employe;
		this.date = date;
		this.montant = montant;
		this.duree = duree;
		this.commentaire = commentaire;
	}
	
	public AvanceSalaire(AvanceSalaire avance) {
		super(avance.id, avance.designation, avance.moduleName,avance.compareid);
		if(avance.rubrique!=null){
			this.rubrique = new RubriquePaie(avance.rubrique);
		}
		if(avance.employe!=null){
			this.employe = new Professeur(avance.employe);
		}
		this.date = avance.date;
		this.montant = avance.montant;
		this.duree = avance.duree;
		this.commentaire = avance.commentaire;
		this.state = avance.state;
	}
	
	

	public RubriquePaie getRubrique() {
		return rubrique;
	}

	public void setRubrique(RubriquePaie rubrique) {
		this.rubrique = rubrique;
	}

	public Professeur getEmploye() {
		return employe;
	}

	public void setEmploye(Professeur employe) {
		this.employe = employe;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Short getDuree() {
		return duree;
	}

	public void setDuree(Short duree) {
		this.duree = duree;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}	
	

	public List<RemboursementAvance> getRemboursements() {
		return remboursements;
	}

	public void setRemboursements(List<RemboursementAvance> remboursements) {
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
		return "Avance du salaire";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Avances du salaire";
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

	public int compareTo(AvanceSalaire o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	

}
