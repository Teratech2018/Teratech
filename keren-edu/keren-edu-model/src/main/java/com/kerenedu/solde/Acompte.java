/**
 * 
 */
package com.kerenedu.solde;

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
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="e_acompte")
public class Acompte extends BaseElement implements Serializable, Comparable<Acompte> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8106416349038340585L;
	
	@ManyToOne
	@JoinColumn(name="EMPL_ID")
	@Predicate(label="Salarié",type=Professeur.class,target="many-to-one",optional=false,search=true)
	private Professeur employe ;
	
	@ManyToOne
	@JoinColumn(name="RUBR_ID")
	@Predicate(label="Rubrique",type=RubriquePaie.class,target="many-to-one",optional=false,search=true)
	private RubriquePaie rubrique;
	
	@Predicate(label="Date",type=Date.class,target="date",optional=false,search=true)
	@Temporal(TemporalType.DATE)
	private Date effet ;
	
	@Predicate(label="Montant",type=Double.class,optional=false,search=true)
	private Double montant = 0.0;
	
	@Predicate(label=" ",target="textarea",group=true,groupName="grou1",groupLabel="Commentaire")
	private String description ;
	
   @Predicate(label = "Statut",search = true,hide = true)
	private String state="etabli";
	
	@ManyToOne
	@JoinColumn(name="ELVAP_ID")
	private ElementVariable eltVariable ;

	/**
	 * 
	 */
	public Acompte() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Acompte(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param employe
	 * @param effet
	 * @param montant
	 * @param description
	 */

	public Acompte(long id, String designation, String moduleName, Professeur employe, Date effet, Double montant,
			String description) {
		super(id, designation, moduleName,0L);
		this.employe = employe;
		this.effet = effet;
		this.montant = montant;
		this.description = description;
	}
	
	/**
	 * 
	 * @param acompte
	 */
	public Acompte(Acompte acompte) {
		super(acompte.id, acompte.designation, acompte.moduleName,acompte.compareid);
		if(acompte.employe!=null){
			this.employe = new Professeur(acompte.employe);
		}
		if(acompte.eltVariable!=null){
			this.eltVariable = new ElementVariable(acompte.eltVariable);
		}
		
		if(acompte.rubrique!=null){
			this.rubrique = new RubriquePaie(acompte.rubrique);
		}
//		if(acompte.rubrique!=null){
//			this.rubrique = new Rubrique(acompte.rubrique);
//		}
		this.effet = acompte.effet;
		this.montant = acompte.montant;
		this.description = acompte.description;
		this.state = acompte.state;
	}
	
	

	public Professeur getEmploye() {
		return employe;
	}

	public void setEmploye(Professeur employe) {
		this.employe = employe;
	}

	public Date getEffet() {
		return effet;
	}

	public void setEffet(Date effet) {
		this.effet = effet;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public ElementVariable getEltVariable() {
		return eltVariable;
	}

	public void setEltVariable(ElementVariable eltVariable) {
		this.eltVariable = eltVariable;
	}	

//	public Rubrique getRubrique() {
//		return rubrique;
//	}
//
//	public void setRubrique(Rubrique rubrique) {
//		this.rubrique = rubrique;
//	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Acompte de ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Acomptes";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
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
	
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
                if(state==null){
                    return states;
                }//end if(state==null){
                if(state.equalsIgnoreCase("etabli")){
                    State state = new State("etabli", "Brouillon");
                    states.add(state);		
                }else if(state.equalsIgnoreCase("confirme")){
                    State state = new State("confirme", "Validée");
                    states.add(state);
		    state = new State("annule", "Annulée");
		    states.add(state);
                }else if(state.equalsIgnoreCase("paye")){
                    State state = new State("paye", "Payée");
                    states.add(state);		
                }else if(state.equalsIgnoreCase("annule")){
                    State state = new State("annule", "Annulée");
		    states.add(state);		
                }//end if(state.equalsIgnoreCase("etabli")){
		return states;
	}

	public RubriquePaie getRubrique() {
		return rubrique;
	}

	public void setRubrique(RubriquePaie rubrique) {
		this.rubrique = rubrique;
	}

	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

	public int compareTo(Acompte o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */


}
