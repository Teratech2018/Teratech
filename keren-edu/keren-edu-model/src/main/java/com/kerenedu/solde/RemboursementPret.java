/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.core.base.State;
import com.kerenedu.configuration.Etablissement;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="e_remprt")
public class RemboursementPret extends BaseElement implements Serializable, Comparable<RemboursementPret> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3072046813663957452L;
	
	@ManyToOne
	@JoinColumn(name="DEPR_ID")
	@Predicate(label="Salarié",type=DemandePret.class,target="many-to-one",optional=false,search=true, updatable=false)
	private DemandePret demande ;
	
	
	@Column(name="EMPL_ID")
	//@Predicate(label="Salarié",type=Professeur.class,target="many-to-one",optional=false,updatable=false,search=true)
	private long emplid ;

	@ManyToOne
	@JoinColumn(name="CATE_ID")
//	@Predicate(label="Prêt",type=CategoriePret.class,target="many-to-one",optional=false,search=true)
	private CategoriePret pret ;
	
	@ManyToOne
	@JoinColumn(name="SOC_ID")
	//@Predicate(label="Structure",type=Etablissement.class,target="many-to-one",search=false)
	private Etablissement societe ;
	
	@Predicate(label="Date Effet",type=Date.class,target="date",optional=false,search=true)
	@Temporal(javax.persistence.TemporalType.DATE)
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
	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire;
	
	
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

	public RemboursementPret(long id, String designation, String moduleName, CategoriePret pret, Etablissement societe,
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
			this.societe = new Etablissement(pret.societe);
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
		this.anneScolaire=pret.anneScolaire;
		this.emplid=pret.emplid;
	}
	
	
	
	public CategoriePret getPret() {
		return pret;
	}

	public void setPret(CategoriePret pret) {
		this.pret = pret;
	}

	public Etablissement getSociete() {
		return societe;
	}

	public void setSociete(Etablissement societe) {
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

	public long getEmplid() {
		return emplid;
	}

	public void setEmplid(long emplid) {
		this.emplid = emplid;
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
		state = new State("paye", "Payé");
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
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	//@Override
	public int compareTo(RemboursementPret o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getAnneScolaire() {
		return anneScolaire;
	}

	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}

}
