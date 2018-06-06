/**
 * 
 */
package com.keren.model.carrieres;

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
import com.keren.model.employes.Categorie;
import com.keren.model.employes.Echelon;
import com.keren.model.employes.Employe;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_BONIFRH")
public class Reclassement extends BaseElement implements Serializable, Comparable<Reclassement> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6727153887777942664L;
	
	@ManyToOne
	@JoinColumn(name="EMPL_ID")
	@Predicate(label="Employé",type=Employe.class,target="many-to-one",optional=false,search=true,observable=true)
	private Employe salarie ;
	
	@Predicate(label="Référence",search=true,unique=true)
	@Column(unique=true)
	private String code ;
	
	@ManyToOne
	@JoinColumn(name="CATA_ID")
	@Predicate(label="Ancienne catégorie",type=Categorie.class,target="many-to-one",optional=false,search=true,editable=false)
	@Observer(observable="salarie",source="field:categorie")
	private Categorie categorieA ;
	
	@ManyToOne
	@JoinColumn(name="CATN_ID")
	@Predicate(label="Nouvelle catégorie",type=Categorie.class,target="many-to-one",optional=false,search=true)
	private Categorie categorieN ; 
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date d'enregistrement",type=Date.class,target="date")
	private Date denreg ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date prise d'effet",type=Date.class,target="date")
	private Date deffet ;
	
	private String state="etabli";

	/**
	 * 
	 */
	public Reclassement() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Reclassement(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param salarie
	 * @param code
	 * @param categorieA
	 * @param categorieN
	 * @param denreg
	 * @param deffet
	 */

	public Reclassement(long id, String designation, String moduleName, Employe salarie, String code,
			Categorie categorieA, Categorie categorieN, Date denreg, Date deffet) {
		super(id, designation, moduleName,0L);
		this.salarie = salarie;
		this.code = code;
		this.categorieA = categorieA;
		this.categorieN = categorieN;
		this.denreg = denreg;
		this.deffet = deffet;
	}
	
	/**
	 * 
	 * @param reclassement
	 */
	public Reclassement(Reclassement reclassement) {
		super(reclassement.id, reclassement.designation, reclassement.moduleName,reclassement.compareid);
		if(reclassement.salarie!=null){
			this.salarie = new Employe(reclassement.salarie);
		}
		this.code = reclassement.code;
		if(reclassement.categorieA!=null){
			this.categorieA = new Categorie(reclassement.categorieA);
		}
		if(reclassement.categorieN!=null){
			this.categorieN = new Categorie(reclassement.categorieN);
		}
		this.denreg = reclassement.denreg;
		this.deffet = reclassement.deffet;
		this.state = reclassement.state;
	}
	
	

	public Employe getSalarie() {
		return salarie;
	}

	public void setSalarie(Employe salarie) {
		this.salarie = salarie;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Categorie getCategorieA() {
		return categorieA;
	}

	public void setCategorieA(Categorie categorieA) {
		this.categorieA = categorieA;
	}

	public Categorie getCategorieN() {
		return categorieN;
	}

	public void setCategorieN(Categorie categorieN) {
		this.categorieN = categorieN;
	}

	public Date getDenreg() {
		return denreg;
	}

	public void setDenreg(Date denreg) {
		this.denreg = denreg;
	}

	public Date getDeffet() {
		return deffet;
	}

	public void setDeffet(Date deffet) {
		this.deffet = deffet;
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
		return "Reclassement du personel";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Reclassements du personel";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return salarie.getDesignation();
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
		states.add(new State("etabli", "Brouillion"));
		states.add(new State("valide", "Validé"));
//		states.add(new State("annule", "Annulé"));
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
	public int compareTo(Reclassement arg0) {
		// TODO Auto-generated method stub
		return code.compareTo(arg0.code);
	}

	
}
