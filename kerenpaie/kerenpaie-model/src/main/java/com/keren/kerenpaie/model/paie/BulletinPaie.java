/**
 * 
 */
package com.keren.kerenpaie.model.paie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.employes.Categorie;
import com.keren.kerenpaie.model.employes.Echelon;
import com.keren.kerenpaie.model.employes.Employe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_BUPA")
public class BulletinPaie extends BaseElement implements Serializable, Comparable<BulletinPaie> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8274847472533474787L;
    
	@Predicate(label="Intutilé",updatable=false,optional=false,search=true)
	private String code ;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	@Predicate(label="Employé",type=Employe.class,target="many-to-one",updatable=false,optional=false,search=true)
	private Employe employe ;
	
	@Predicate(label="Date de payement",type=Date.class,target="date",search=true)
	private Date dpayement ;
	
	@ManyToOne
	@JoinColumn(name="PEPA_ID")	
	@Predicate(label="Période",type=PeriodePaie.class,target="many-to-one",updatable=false,optional=false,search=true)
	private PeriodePaie periode ;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	@JoinColumn(name="LIBUPA_ID")
	@Predicate(label="Lignes",type=LigneBulletinPaie.class,target="one-to-many",group=true,groupName="group1",groupLabel="VALEURS DE RUBRIQUES")
	private List<LigneBulletinPaie> lignes = new ArrayList<LigneBulletinPaie>();
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="BUPA_ID")
	@Predicate(label="VARIABLES",type=LigneElementVariable.class,target="one-to-many",group=true,groupName="group2",groupLabel="VARIABLES",edittable=true)
	private List<LigneElementVariable> variables = new ArrayList<LigneElementVariable>();
	
	
	private String state = "etabli";
	
	/**
	 * 
	 */
	public BulletinPaie() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public BulletinPaie(long id, String designation, String moduleName) {
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
	 * @param dpayement
	 * @param periode
	 * @param nbrejrstra
	 * @param categorie
	 * @param salbrut
	 * @param echelon
	 * @param salcot
	 * @param ancienite
	 * @param saltax
	 * @param nbreenfts
	 * @param lignes
	 * @param state
	 */

	public BulletinPaie(long id, String designation, String moduleName, String code, Employe employe, Date dpayement,
			PeriodePaie periode, Short nbrejrstra, Categorie categorie, Double salbrut, Echelon echelon, Double salcot,
			Short ancienite, Double saltax, Short nbreenfts, List<LigneBulletinPaie> lignes, String state) {
		super(id, designation, moduleName);
		this.code = code;
		this.employe = employe;
		this.dpayement = dpayement;
		this.periode = periode;
//		this.nbrejrstra = nbrejrstra;
//		this.categorie = categorie;
//		this.salbrut = salbrut;
//		this.echelon = echelon;
//		this.salcot = salcot;
//		this.ancienite = ancienite;
//		this.saltax = saltax;
//		this.nbreenfts = nbreenfts;
		this.lignes = lignes;
		this.state = state;
	}
	
	/**
	 * 
	 * @param code
	 * @param employe
	 * @param dpayement
	 * @param periode
	 */
	public BulletinPaie(String code, Employe employe, Date dpayement,
			PeriodePaie periode) {
		super(-1, null, null);
		this.code = code;
		this.employe = employe;
		this.dpayement = dpayement;
		this.periode = periode;		
	}

	public BulletinPaie(BulletinPaie bulletin) {
		super(bulletin.id, bulletin.designation, bulletin.moduleName);
		this.code = bulletin.code;
		if(bulletin.employe!=null){
			this.employe = new Employe(bulletin.employe);
		}
		this.dpayement = bulletin.dpayement;
		if(bulletin.periode!=null){
			this.periode = new PeriodePaie(bulletin.periode);
		}

		this.state = bulletin.state;
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

	public Date getDpayement() {
		return dpayement;
	}

	public void setDpayement(Date dpayement) {
		this.dpayement = dpayement;
	}

	public PeriodePaie getPeriode() {
		return periode;
	}

	public void setPeriode(PeriodePaie periode) {
		this.periode = periode;
	}


	public List<LigneBulletinPaie> getLignes() {
		return lignes;
	}

	public void setLignes(List<LigneBulletinPaie> lignes) {
		this.lignes = lignes;
	}
	
	

	public List<LigneElementVariable> getVariables() {
		return variables;
	}

	public void setVariables(List<LigneElementVariable> variables) {
		this.variables = variables;
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
		return "Bulletin de paie";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Bulletins de paie";
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
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return super.isCreateonfield();
	}

	@Override
	public boolean isDesabledelete() {
		// TODO Auto-generated method stub
		return true;
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
		State state = new State("etabli", "A soumettre");
		states.add(state);
		state = new State("valide", "A valider");
		states.add(state);
//		state = new State("constate", "A constater");
//		states.add(state);
		state = new State("payement", "A payer");
		states.add(state);
		state = new State("ordonne", "Paiement ordonné");
		states.add(state);
		state = new State("paye", "Payé");
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
	public int compareTo(BulletinPaie arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
