/**
 * 
 */
package com.keren.model.discipline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.model.employes.Employe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */ 
@Entity
@Table(name="T_COCORH") 
public class ConvocationConseil extends BaseElement implements Serializable, Comparable<ConvocationConseil> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6484335089058736508L; 
	
	@Predicate(label="Référence",optional=false,unique=true,search=true)
	private String code ;
	
	@Predicate(label="N. décision",optional=false,unique=true,search=true)
	private String reference ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de convocation",type=Date.class,target="date",optional=false,search=true)
	private Date date ;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	@Predicate(label="Emetteur",type=Employe.class,target="many-to-one",search=true)
	private Employe emetteur ;
	
	@ManyToMany
	@JoinTable(name="T_DE_CSRH",joinColumns=@JoinColumn(name="CC_ID"),inverseJoinColumns=@JoinColumn(name="DE_ID"))
	@Predicate(label="DE",type=DemandeExplication.class,target="many-to-many-list",optional=false,group=true,groupName="group1",groupLabel="Demandes concernées")
	private List<DemandeExplication> demandes = new ArrayList<DemandeExplication>();
	
	@OneToMany(fetch=FetchType.LAZY,orphanRemoval=true,cascade=CascadeType.ALL)
	@JoinColumn(name="MC_ID")
	@Predicate(label="DE",type=MembreConseil.class,target="one-to-many",group=true,groupName="group2",groupLabel="Membres du conseil",edittable=true)
	private List<MembreConseil> membres = new ArrayList<MembreConseil>();

	@Predicate(label="Etape",hide=true,search=true)
	private String state ="convoque";
	/**
	 * 
	 */
	public ConvocationConseil() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ConvocationConseil(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param reference
	 * @param date
	 * @param emetteur
	 * @param demandes
	 * @param membres
	 */

	public ConvocationConseil(long id, String designation, String moduleName, String code, String reference, Date date,
			Employe emetteur, List<DemandeExplication> demandes, List<MembreConseil> membres) {
		super(id, designation, moduleName);
		this.code = code;
		this.reference = reference;
		this.date = date;
		this.emetteur = emetteur;
		this.demandes = demandes;
		this.membres = membres;
	}
	
	public ConvocationConseil(ConvocationConseil cc) {
		super(cc.id, cc.designation, cc.moduleName);
		this.code = cc.code;
		this.reference = cc.reference;
		this.date = cc.date;
		if(cc.emetteur!=null){
			this.emetteur = new Employe(cc.emetteur);
		}
		this.state = cc.state;
//		for(DemandeExplication de:cc.demandes){
//			demandes.add(new DemandeExplication(de));
//		}
//		for(MembreConseil me:cc.membres){
//			membres.add(new MembreConseil(me));
//		}
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getReference() {  
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Employe getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(Employe emetteur) {
		this.emetteur = emetteur;
	}

	public List<DemandeExplication> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<DemandeExplication> demandes) {
		this.demandes = demandes;
	}

	public List<MembreConseil> getMembres() {
		return membres;
	}

	public void setMembres(List<MembreConseil> membres) {
		this.membres = membres;
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
		return "CONVOCATION DU CONSEIL";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "CONVOCATIONS DU CONSEIL";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}

	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
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
		State etat = new State("convoque", "Convoqué");
		states.add(etat);
		etat = new State("siege", "A Siègé");
		states.add(etat);
//		etat = new State("encours", "En cours");
//		states.add(etat);
//		etat = new State("traite", "Traité");
//		states.add(etat);
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
	public int compareTo(ConvocationConseil o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
