/**
 * 
 */
package com.keren.model.formations;

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
import com.keren.model.employes.Employe;
import com.keren.model.structures.Societe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_DEMFORRH")
public class DemandeFormation extends BaseElement implements Serializable, Comparable<DemandeFormation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7091681592633928968L;	
	
	@ManyToOne
	@JoinColumn(name="DEMA_ID")
	@Predicate(label="Demandeur",type=Employe.class,target="many-to-one",optional=false,search=true)
	private Employe demandeur ;
	
	@Predicate(label="Objet",search=true)
	private String objet ;
	
	@ManyToOne
	@JoinColumn(name="STRU_ID")
	@Predicate(label="Structure",type=Societe.class,target="many-to-one",optional=false,search=true)
	private Societe structure ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date",type=Date.class,target="date",optional=false,search=true)
	private Date date ;
	
	@Predicate(label=".",target="textarea",group=true,groupName="group1",groupLabel="Motif")
	private String motif ;
	
	@Predicate(label=".",target="textarea",group=true,groupName="group2",groupLabel="Décision de la Drirection")
	private String decision ;

	@ManyToOne
	@JoinColumn(name="BEFO_ID")
	private BesionFormation besion ;
	
	@Predicate(label="Etat",hide=true,search=true)
	private String state = "etabli";
	
	/**
	 * 
	 */
	public DemandeFormation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public DemandeFormation(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param demandeur
	 * @param objet
	 * @param structure
	 * @param date
	 * @param motif
	 * @param decision
	 */

	public DemandeFormation(long id, String designation, String moduleName, Employe demandeur, String objet, Societe structure,
			Date date, String motif, String decision) {
		super(id, designation, moduleName);
		this.demandeur = demandeur;
		this.objet = objet;
		this.structure = structure;
		this.date = date;
		this.motif = motif;
		this.decision = decision;
	}
	
	public DemandeFormation(DemandeFormation formation) {
		super(formation.id, formation.designation, formation.moduleName);
		if(formation.demandeur!=null){
			this.demandeur = new Employe(formation.demandeur);
		}
		this.objet = formation.objet;
		if(formation.structure!=null){
			this.structure = new Societe(formation.structure);
		}
		this.date = formation.date;
		this.motif = formation.motif;
		this.decision = formation.decision;
	}

	
	
	public Employe getDemandeur() {
		return demandeur;
	}

	public void setDemandeur(Employe demandeur) {
		this.demandeur = demandeur;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public Societe getStructure() {
		return structure;
	}

	public void setStructure(Societe structure) {
		this.structure = structure;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Demande de Formation";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Demandes de Formation";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return demandeur.getDesignation();
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
		states.add(new State("etabli", "Brouillon"));
		states.add(new State("valide", "Validée"));
		states.add(new State("rejete", "Rejétée"));
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
	public int compareTo(DemandeFormation o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
