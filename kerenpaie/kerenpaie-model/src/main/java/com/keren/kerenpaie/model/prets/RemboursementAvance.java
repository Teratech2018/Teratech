/**
 * 
 */
package com.keren.kerenpaie.model.prets;

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
import com.keren.kerenpaie.model.paie.ElementVariable;
import com.keren.kerenpaie.model.structures.Societe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_REAVP") 
public class RemboursementAvance extends BaseElement implements Serializable, Comparable<RemboursementAvance> {

	/**
	 *  
	 */
	private static final long serialVersionUID = 7379660949986673989L;
	
	@ManyToOne
	@JoinColumn(name="AVSA_ID")
	@Predicate(label="Avance",type=AvanceSalaire.class,target="many-to-one",optional=false,search=true)
	private AvanceSalaire avance ;
	
	@ManyToOne
	@JoinColumn(name="SOC_ID")
//	@Predicate(label="Structure",type=Societe.class,target="many-to-one",search=true)
	private Societe societe ;
	
	@Predicate(label="Date",type=Date.class,target="date",optional=false,search=true)
	@Temporal(TemporalType.DATE)
	private Date date ;
	
	@Predicate(label="Montant",type=Double.class,optional=false,search=true)
	private Double montant =0.0;
	
	@Predicate(label="Actif",type=Boolean.class,group=true,groupName="group1",groupLabel="Références",search=true)
	private Boolean actif = Boolean.TRUE;
	
	@Predicate(label="Status",hide=true ,search=true)
	private String state="etabli";
	
	@ManyToOne
	@JoinColumn(name="ELVAP_ID")
	private ElementVariable eltVariable ;

	/**
	 * 
	 */
	public RemboursementAvance() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public RemboursementAvance(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param avance
	 * @param societe
	 * @param date
	 * @param montant
	 * @param actif
	 */

	public RemboursementAvance(long id, String designation, String moduleName, AvanceSalaire avance, Societe societe,
			Date date, Double montant, Boolean actif) {
		super(id, designation, moduleName,0L);
		this.avance = avance;
		this.societe = societe;
		this.date = date;
		this.montant = montant;
		this.actif = actif;
	}
	
	public RemboursementAvance(RemboursementAvance rem) {
		super(rem.id, rem.designation, rem.moduleName,rem.compareid);
		if(rem.avance!=null){
			this.avance = new AvanceSalaire(rem.avance);
		}
		if(rem.eltVariable!=null){
			this.eltVariable = new ElementVariable(rem.eltVariable);
		}
		if(rem.societe!=null){
			this.societe = new Societe(rem.societe);
		}
		this.date = rem.date;
		this.montant = rem.montant;
		this.actif = rem.actif;
		this.state = rem.state;
	}
	
	

	public AvanceSalaire getAvance() {
		return avance;
	}

	public void setAvance(AvanceSalaire avance) {
		this.avance = avance;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
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

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}
	
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}	
	

	public ElementVariable getEltVariable() {
		return eltVariable;
	}

	public void setEltVariable(ElementVariable eltVariable) {
		this.eltVariable = eltVariable;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Remboursement Prêt";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Remboursements Prêts";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return avance.getEmploye().getDesignation();
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
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> states = new ArrayList<State>();
		State state = new State("etabli", "Brouillon");
		states.add(state);
		state = new State("confirme", "Validé");
		states.add(state);
		state = new State("refuse", "Refusé");
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
	public int compareTo(RemboursementAvance o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
