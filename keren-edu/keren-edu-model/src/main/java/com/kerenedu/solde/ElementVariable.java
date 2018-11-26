/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.base.State;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="e_eltvar")
public class ElementVariable extends BaseElement implements Serializable, Comparable<ElementVariable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8747502413805211320L;
	
	@ManyToOne
	@JoinColumn(name="EMPL_ID")
	@Predicate(label="Salarié",type=Professeur.class,target="many-to-one",optional=false,updatable=false,editable=false,search=true)
	private Professeur salarie0 ;
	
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
	private List<RappelSalaire> rappels = new ArrayList<RappelSalaire>() ;
	
	@Column(name="CPP")
	private Short congePrisPeriode = 0 ;
	
	@Column(name="CCP")
	private Short cumulCongePris = 0 ;
	
	@Column(name="CAP")
	private Short congeAcquisPeriode = 0 ;
	
	@Column(name="CCA")
	private Short cumulCongeAcquis = 0 ;
	
	@Column(name="CSBB")
	private Double cumulSBB = 0.0;
	
	@Column(name="CSTA")
	private Double cumulSTA = 0.0 ;
	
	@Column(name="CSCO")
	private Double cumulSCO = 0.0;
	
	@Column(name="CSEX")
	private Double cumulSEX = 0.0;
	
	@Column(name="CCSA")
	private Double cumlChargeSal = 0.0 ;
	
	@Column(name="CCPA")
	private Double cumulChargePat = 0.0;
	
	@Column(name="CANA")
	private Double cumulAvantageNat = 0.0;
	
	@Column(name="CHT")
	private Double cumulHeureTrav = 0.0 ;
	
	@Column(name="CJT")
	private Double cumulJourTrav = 0.0 ;
	
	@Column(name="CHS")
	private Double cumulHeureSup = 0.0;
	
	
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

	public ElementVariable(long id, String designation, String moduleName, Professeur salarie, RemboursementAvance avance,
			RemboursementPret pret, Acompte acompte, RappelSalaire rappel) {
		super(id, designation, moduleName,0L);
		this.salarie0 = salarie;		
	}
	
	public ElementVariable(ElementVariable elem) {
		super(elem.id, elem.designation, elem.moduleName,elem.compareid);
		if(elem.salarie0!=null){
			this.salarie0 = new Professeur(elem.salarie0);
		}		
		if(elem.peiode!=null){
			this.peiode = new PeriodePaie(elem.peiode);
		}
	}	
	

	public Professeur getSalarie() {
		return salarie0;
	}

	public void setSalarie(Professeur salarie) {
		this.salarie0 = salarie;
	}	
	



	public PeriodePaie getPeiode() {
		return peiode;
	}

	public void setPeiode(PeriodePaie peiode) {
		this.peiode = peiode;
	}		
	

	public Professeur getSalarie0() {
		return salarie0;
	}
	


	public void setSalarie0(Professeur salarie0) {
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

	public List<RappelSalaire> getRappels() {
		return rappels;
	}

	public void setRappels(List<RappelSalaire> rappels) {
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
	

	public Double getCumulSBB() {
		return cumulSBB;
	}

	public void setCumulSBB(Double cumulSBB) {
		this.cumulSBB = cumulSBB;
	}

	public Double getCumulSTA() {
		return cumulSTA;
	}

	public void setCumulSTA(Double cumulSTA) {
		this.cumulSTA = cumulSTA;
	}

	public Double getCumulSCO() {
		return cumulSCO;
	}

	public void setCumulSCO(Double cumulSCO) {
		this.cumulSCO = cumulSCO;
	}

	public Double getCumulSEX() {
		return cumulSEX;
	}

	public void setCumulSEX(Double cumulSEX) {
		this.cumulSEX = cumulSEX;
	}

	public Double getCumlChargeSal() {
		return cumlChargeSal;
	}

	public void setCumlChargeSal(Double cumlChargeSal) {
		this.cumlChargeSal = cumlChargeSal;
	}

	public Double getCumulChargePat() {
		return cumulChargePat;
	}

	public void setCumulChargePat(Double cumulChargePat) {
		this.cumulChargePat = cumulChargePat;
	}

	public Double getCumulAvantageNat() {
		return cumulAvantageNat;
	}

	public void setCumulAvantageNat(Double cumulAvantageNat) {
		this.cumulAvantageNat = cumulAvantageNat;
	}

	public Double getCumulHeureTrav() {
		return cumulHeureTrav;
	}

	public void setCumulHeureTrav(Double cumulHeureTrav) {
		this.cumulHeureTrav = cumulHeureTrav;
	}

	public Double getCumulJourTrav() {
		return cumulJourTrav;
	}

	public void setCumulJourTrav(Double cumulJourTrav) {
		this.cumulJourTrav = cumulJourTrav;
	}

	public Double getCumulHeureSup() {
		return cumulHeureSup;
	}

	public void setCumulHeureSup(Double cumulHeureSup) {
		this.cumulHeureSup = cumulHeureSup;
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
//	@Override
	public int compareTo(ElementVariable arg0) {
		// TODO Auto-generated method stub
		return salarie0.compareTo(arg0.salarie0);
	}

}
