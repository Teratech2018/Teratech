/**
 * 
 */
package com.keren.kerenpaie.model.paie;

import java.io.Serializable;
import java.util.ArrayList;
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
//	
	
//	@Predicate(label="Heures Chomé",type=Double.class,group=true,groupName="group1",groupLabel="HEURES")
//	private Double hchomes = 0.0;
//	
//	@Predicate(label="Heures Période",type=Double.class,group=true,groupName="group1",groupLabel="HEURES")
//	private Double hperiode = 0.0;
//	
//	@Predicate(label="Heures Payés",type=Double.class,group=true,groupName="group1",groupLabel="HEURES")
//	private Double hpayes =0.0;
//
//	@Predicate(label="Heures Travaillés",type=Double.class,group=true,groupName="group1",groupLabel="HEURES")
//	private Double htravail = 0.0;
//	
//	@Predicate(label="Heures Absences",type=Double.class,group=true,groupName="group1",groupLabel="HEURES")
//	private Double nbreheuresabsences = 0.0;	
//	
//	@Predicate(label="SALBASE",type=Double.class,group=true,groupName="group2",groupLabel="SALAIRES")
//	private Double salbase = 0.0;	
//    
//	@Predicate(label="ANCIEN",type=Double.class)
//	private Double anciennite = 0.0;
//	
//	@Predicate(label="Salaire catégoriel",type=Double.class,editable=false,updatable=false,group=true,groupName="group2",groupLabel="SALAIRES")
//	private Double salcategorie = 0.0;
//	
//	@Predicate(label="Salaire de base Brut",type=Double.class,editable=false,updatable=false,group=true,groupName="group2",groupLabel="SALAIRES")
//	private Double salbasebrut = 0.0;
//	
//	@Predicate(label="Cumul Salaire brut Annuel",type=Double.class,editable=false,updatable=false,group=true,groupName="group2",groupLabel="SALAIRES")
//	private Double salbrutannuel = 0.0 ;
//
//	@Predicate(label="Salaire cotisable",type=Double.class,editable=false,updatable=false,group=true,groupName="group2",groupLabel="SALAIRES")
//	private Double salcotisable =0.0 ;
//
//	@Predicate(label="Salaire taxable",type=Double.class,editable=false,updatable=false,group=true,groupName="group2",groupLabel="SALAIRES")
//	private Double saltaxable = 0.0;	
//
//	@Predicate(label="NBRECONG",type=Double.class)
//	private Double nbreheuresconges = 0.0;
//	
//	@Predicate(label="NBREENF21",type=Double.class)
//	private Double nbreenfants21 = 0.0 ;
//
//	@Predicate(label="NBREENF",type=Double.class)
//	private Double nbreenfants= 0.0 ;	
//	
//	@Predicate(label="Salaire Brut",type=Double.class,editable=false,updatable=false,group=true,groupName="group2",groupLabel="SALAIRES")
//	private Double salbrut =0.0;	
//	
//	private Double jrstraveffectif = 0.0;
//	
//	
//	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
//	@JoinColumn(name="LIELVA_ID")
//	@Predicate(label="VARIABLES",type=LigneElementVariable.class,target="one-to-many",group=true,groupName="group1",groupLabel="VARIABLES")
//	private List<LigneElementVariable> lignes = new ArrayList<LigneElementVariable>();
	
	
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
		super(id, designation, moduleName);
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
		super(id, designation, moduleName);
		this.salarie0 = salarie;		
	}
	
	public ElementVariable(ElementVariable elem) {
		super(elem.id, elem.designation, elem.moduleName);
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
	
	

//	public Double getSalbase() {
//		return salbase;
//	}
//
//	public void setSalbase(Double salbase) {
//		this.salbase = salbase;
//	}
//
//	public Double getAnciennite() {
//		return anciennite;
//	}
//
//	public void setAnciennite(Double anciennite) {
//		this.anciennite = anciennite;
//	}
//
//	public Double getSalcategorie() {
//		return salcategorie;
//	}
//
//	public void setSalcategorie(Double salcategorie) {
//		this.salcategorie = salcategorie;
//	}
//
//	public Double getSalbasebrut() {
//		return salbasebrut;
//	}
//
//	public void setSalbasebrut(Double salbasebrut) {
//		this.salbasebrut = salbasebrut;
//	}
//
//	public Double getSalbrutannuel() {
//		return salbrutannuel;
//	}
//
//	public void setSalbrutannuel(Double salbrutannuel) {
//		this.salbrutannuel = salbrutannuel;
//	}
//
//	public Double getSalcotisable() {
//		return salcotisable;
//	}
//
//	public void setSalcotisable(Double salcotisable) {
//		this.salcotisable = salcotisable;
//	}
//
//	public Double getSaltaxable() {
//		return saltaxable;
//	}
//
//	public void setSaltaxable(Double saltaxable) {
//		this.saltaxable = saltaxable;
//	}
//
//	public Double getNbreheuresabsences() {
//		return nbreheuresabsences;
//	}
//
//	public void setNbreheuresabsences(Double nbreheuresabsences) {
//		this.nbreheuresabsences = nbreheuresabsences;
//	}
//
//	public Double getNbreheuresconges() {
//		return nbreheuresconges;
//	}
//
//	public void setNbreheuresconges(Double nbreheuresconges) {
//		this.nbreheuresconges = nbreheuresconges;
//	}
//
//	public Double getNbreenfants21() {
//		return nbreenfants21;
//	}
//
//	public void setNbreenfants21(Double nbreenfants21) {
//		this.nbreenfants21 = nbreenfants21;
//	}
//
//	public Double getSalbrut() {
//		return salbrut;
//	}
//
//	public void setSalbrut(Double salbrut) {
//		this.salbrut = salbrut;
//	}
//
//	public Double getNbreenfants() {
//		return nbreenfants;
//	}
//
//	public void setNbreenfants(Double nbreenfants) {
//		this.nbreenfants = nbreenfants;
//	}
//
//	public Double getJrstraveffectif() {
//		return jrstraveffectif;
//	}
//
//	public void setJrstraveffectif(Double jrstraveffectif) {
//		this.jrstraveffectif = jrstraveffectif;
//	}
//	
//	
//
//	public Double getHchomes() {
//		return hchomes;
//	}
//
//	public void setHchomes(Double hchomes) {
//		this.hchomes = hchomes;
//	}
//
//	public Double getHperiode() {
//		return hperiode;
//	}
//
//	public void setHperiode(Double hperiode) {
//		this.hperiode = hperiode;
//	}
//
//	public Double getHpayes() {
//		return hpayes;
//	}
//
//	public void setHpayes(Double hpayes) {
//		this.hpayes = hpayes;
//	}
//
//	public Double getHtravail() {
//		return htravail;
//	}
//
//	public void setHtravail(Double htravail) {
//		this.htravail = htravail;
//	}

//	public List<LigneElementVariable> getLignes() {
//		return lignes;
//	}
//
//	public void setLignes(List<LigneElementVariable> lignes) {
//		this.lignes = lignes;
//	}

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
		return super.getStates();
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
