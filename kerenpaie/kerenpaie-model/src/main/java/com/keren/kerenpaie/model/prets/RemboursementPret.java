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
@Table(name="T_REPRP")
public class RemboursementPret extends BaseElement implements Serializable, Comparable<RemboursementPret> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3072046813663957452L;
	
	@ManyToOne
	@JoinColumn(name="DEPR_ID")
	@Predicate(label="Prêt",type=DemandePret.class,target="many-to-one",optional=false,search=true)
	private DemandePret demande ;

	@ManyToOne
	@JoinColumn(name="CATE_ID")
//	@Predicate(label="Prêt",type=CategoriePret.class,target="many-to-one",optional=false,search=true)
	private CategoriePret pret ;
	
	@ManyToOne
	@JoinColumn(name="SOC_ID")
	@Predicate(label="Structure",type=Societe.class,target="many-to-one",search=false)
	private Societe societe ;
	
	@Predicate(label="Date",type=Date.class,target="date",optional=false,search=true)
	@Temporal(TemporalType.DATE)
	private Date date ;
	
	@Predicate(label="Montant",type=Double.class,optional=false,search=true,updatable=false)
	private Double montant = 0.0;
	
	@Predicate(label="Actif",type=Boolean.class,group=true,groupName="group1",groupLabel="Référence",search=true)
	private Boolean actif = Boolean.TRUE;
	
	@Predicate(label="Status",hide=true ,search=true)
	private String state="etabli";
	
	@ManyToOne
	@JoinColumn(name="ELVAP_ID")
	private ElementVariable eltVariable ;
	
	
	/**
	 * 
	 */
	public RemboursementPret() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public RemboursementPret(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param pret
	 * @param societe
	 * @param date
	 * @param montant
	 * @param actif
	 * @param demande
	 */

	public RemboursementPret(long id, String designation, String moduleName, CategoriePret pret, Societe societe,
			Date date, Double montant, Boolean actif, DemandePret demande) {
		super(id, designation, moduleName,0L);
		this.pret = pret;
		this.societe = societe;
		this.date = date;
		this.montant = montant;
		this.actif = actif;
		this.demande = demande;
	}

	/**
	 * 
	 * @param pret
	 */
	public RemboursementPret(RemboursementPret pret) {
		super(pret.id, pret.designation, pret.moduleName,pret.compareid);
		if(pret.pret!=null){
			this.pret = new CategoriePret(pret.pret);
		}
		if(pret.societe!=null){
			this.societe = new Societe(pret.societe);
		}
		this.date = pret.date;
		this.montant = pret.montant;
		this.actif = pret.actif;
		if(pret.demande!=null){
			this.demande = new DemandePret(pret.demande);
		}
		if(pret.eltVariable!=null){
			this.eltVariable = new ElementVariable(pret.eltVariable);
		}
		this.state = pret.state;
	}
	
	
	
	public CategoriePret getPret() {
		return pret;
	}

	public void setPret(CategoriePret pret) {
		this.pret = pret;
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

	public DemandePret getDemande() {
		return demande;
	}

	public void setDemande(DemandePret demande) {
		this.demande = demande;
	}
	
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return "Remboursement du Prêt";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Remboursements de Prêts";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return pret.getDesignation();
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
		state = new State("refuse", "Refusé");
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
	
	

	@Override
	public boolean isDesablecreate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDesabledelete() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isDesableupdate() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(RemboursementPret o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
