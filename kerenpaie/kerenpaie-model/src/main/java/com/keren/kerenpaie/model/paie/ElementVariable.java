/**
 * 
 */
package com.keren.kerenpaie.model.paie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.prets.Acompte;
import com.keren.kerenpaie.model.prets.Rappel;
import com.keren.kerenpaie.model.prets.RemboursementAvance;
import com.keren.kerenpaie.model.prets.RemboursementPret;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_ELVAP")
public class ElementVariable extends BaseElement implements Serializable, Comparable<ElementVariable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8747502413805211320L;
	
	@ManyToOne
	@JoinColumn(name="EMPL_ID")
	@Predicate(label="Salarié",type=Employe.class,target="many-to-one",optional=false,updatable=false,editable=false,search=true)
	private Employe salarie0 ;
	
	@ManyToOne
	@JoinColumn(name="PEPA_ID")
	@Predicate(label="Periode de Paie",type=PeriodePaie.class,target="many-to-one",optional=false,updatable=false,editable=false,search=false)
	private PeriodePaie peiode;

	
	@OneToMany(mappedBy="eltVariable",fetch=FetchType.LAZY)
//	@Predicate(label="Remb Avance",type=RemboursementAvance.class,target="many-to-one",search=true)
	private List<RemboursementAvance> avances = new ArrayList<RemboursementAvance>() ;
	
	@OneToMany(mappedBy="eltVariable",fetch=FetchType.LAZY)
//	@Predicate(label="Remb Prêt",type=RemboursementPret.class,target="many-to-one",search=true)
	private List<RemboursementPret> prets = new ArrayList<RemboursementPret>() ;
	
	@OneToMany(mappedBy="eltVariable",fetch=FetchType.LAZY)
	private List<Acompte> acomptes = new ArrayList<Acompte>() ;
	
	@OneToMany(mappedBy="eltVariable",fetch=FetchType.LAZY)
	private List<Rappel> rappels = new ArrayList<Rappel>() ;
	
	@Column(name="CPP")
	private Short congePrisPeriode = 0 ;
	
	@Column(name="CCP")
	private Short cumulCongePris = 0 ;
	
	@Column(name="CAP")
	private Short congeAcquisPeriode = 0 ;
	
	@Column(name="CCA")
	private Short cumulCongeAcquis = 0 ;
	
	
	
	/**
	 * 
	 */
	public ElementVariable() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ElementVariable(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param salarie
	 * @param avance
	 * @param pret
	 * @param acompte
	 * @param rappel
	 */

	public ElementVariable(long id, String designation, String moduleName, Employe salarie, RemboursementAvance avance,
			RemboursementPret pret, Acompte acompte, Rappel rappel) {
		super(id, designation, moduleName,0L);
		this.salarie0 = salarie;		
	}
	
	public ElementVariable(ElementVariable elem) {
		super(elem.id, elem.designation, elem.moduleName,elem.compareid);
		if(elem.salarie0!=null){
			this.salarie0 = new Employe(elem.salarie0);
		}		
		if(elem.peiode!=null){
			this.peiode = new PeriodePaie(elem.peiode);
		}
	}	
	

	public Employe getSalarie() {
		return salarie0;
	}

	public void setSalarie(Employe salarie) {
		this.salarie0 = salarie;
	}	
	



	public PeriodePaie getPeiode() {
		return peiode;
	}

	public void setPeiode(PeriodePaie peiode) {
		this.peiode = peiode;
	}		
	

	public Employe getSalarie0() {
		return salarie0;
	}
	


	public void setSalarie0(Employe salarie0) {
		this.salarie0 = salarie0;
	}

	public List<RemboursementAvance> getAvances() {
		return avances;
	}

	public void setAvances(List<RemboursementAvance> avances) {
		this.avances = avances;
	}

	public List<RemboursementPret> getPrets() {
		return prets;
	}

	public void setPrets(List<RemboursementPret> prets) {
		this.prets = prets;
	}

	public List<Acompte> getAcomptes() {
		return acomptes;
	}

	public void setAcomptes(List<Acompte> acomptes) {
		this.acomptes = acomptes;
	}

	public List<Rappel> getRappels() {
		return rappels;
	}

	public void setRappels(List<Rappel> rappels) {
		this.rappels = rappels;
	}
	
	

	public Short getCongePrisPeriode() {
		return congePrisPeriode;
	}

	public void setCongePrisPeriode(Short congePrisPeriode) {
		this.congePrisPeriode = congePrisPeriode;
	}

	public Short getCumulCongePris() {
		return cumulCongePris;
	}

	public void setCumulCongePris(Short cumulCongePris) {
		this.cumulCongePris = cumulCongePris;
	}

	public Short getCongeAcquisPeriode() {
		return congeAcquisPeriode;
	}

	public void setCongeAcquisPeriode(Short congeAcquisPeriode) {
		this.congeAcquisPeriode = congeAcquisPeriode;
	}

	public Short getCumulCongeAcquis() {
		return cumulCongeAcquis;
	}

	public void setCumulCongeAcquis(Short cumulCongeAcquis) {
		this.cumulCongeAcquis = cumulCongeAcquis;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Element Variable";
	}
	
	

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Elements Variables";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return salarie0.getDesignation();
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
		state = new State("active", "Actif");
		states.add(state);
		state = new State("inactive", "Inactif");
		states.add(state);
		return states;
	}

	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ElementVariable arg0) {
		// TODO Auto-generated method stub
		return salarie0.compareTo(arg0.salarie0);
	}

}
