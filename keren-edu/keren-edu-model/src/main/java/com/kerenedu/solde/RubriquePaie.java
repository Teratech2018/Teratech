/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.personnel.EnseignantSecondaire;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author Nadege
 *
 */
@Entity
@Table(name = "e_rub")
public class RubriquePaie extends BaseElement implements Serializable, Comparable<RubriquePaie> {

	@Column(name = "CODE", unique=true)
	@Predicate(label="Code",optional=false,updatable=false,search=true, sequence=1)
	protected String code;
	
	@Column(name = "DES")
	@Predicate(label="Description",optional=false,updatable=false,search=true, sequence=2)
	protected String desc;
	
	@Predicate(label="Type de rubrique",target="combobox",values="Gain;Retenue",search=true, sequence=3,optional=false)
	private String type ="0";
	
	@Predicate(label="Nature de rubrique",target="combobox",values="Salaire;Prime;Indemnité;Allocations Familiales;Amicale;Loyer;Autres Retenues",search=true,observable=true,
			 sequence=4)
	private String nature ="0";	
	
	@Predicate(label="Impression sur le bulletin",target="combobox",values="Jamais;Toujours;si non nul", sequence=5)
	private String porte="0";
	
	@Predicate(label="Acompte?",type=Boolean.class, sequence=6)
	private Boolean acompte = Boolean.FALSE;
	
	@Predicate(label="Prêt?",type=Boolean.class, sequence=7)
	private Boolean pret = Boolean.FALSE;
	
	@Predicate(label="Mode d'evaluation",target="combobox",values="Forfait par Catégorie;Forfaitaire par Cycle;Forfaitaire Par Personnels;Fixe;Formule;Elements Variables", 
			optional=false ,group=true,groupName="group1",groupLabel="Elements de calcul", observable=true)
	private String mode;	
	
	@Predicate(label="Valeur Fixe",type=Double.class,group=true,groupName="group1",groupLabel="Elements de calcul",optional=true,hidden = "currentObject.mode!=3")
	private Double valFixe =0.0;
	
	@Predicate(label="Taux salarial(%)",type=Double.class,group=true,groupName="group1",groupLabel="Elements de calcul", sequence=7,optional=true)
	private Double tauxsal =0.0;
	
	@Predicate(label="Formile",type=String.class,group=true,groupName="group1",groupLabel="Elements de calcul",optional=true,hidden = "currentObject.mode!=4")
	private String formule ;
	
	@Predicate(label="Taux patronal(%)",type=Double.class,group=true,groupName="group1",groupLabel="Elements de calcul", sequence=9,optional=true)
	private Double tauxpat=0.0;
	
	@Predicate(label="Participe au salaire brut?",type=Boolean.class,group=true,groupName="group1",groupLabel="Elements de calcul", sequence=8)
	private Boolean brutsal = Boolean.FALSE;
	
	@Predicate(label="Participe à la base cotisable?",type=Boolean.class,group=true,groupName="group1",groupLabel="Elements de calcul", sequence=10,search=true)
	private Boolean cotisablesal = Boolean.FALSE;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	@JoinColumn(name="RUBR_ID")
	@Predicate(label="RU",type=ForfaitCategorie.class,target="one-to-many",group=true,groupName="group3",groupLabel="Définition des forfaits",
	hidden="currentObject.mode!='0'", sequence=14,edittable=true)
	@Observer(observable="mode",source="method:generatecategorie",parameters="mode")
	private List<ForfaitCategorie> forfaitscat = new ArrayList<ForfaitCategorie>();
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	@JoinColumn(name="RUBR_ID")
	@Predicate(label="RU",type=ForfaitCycle.class,target="one-to-many",group=true,groupName="group3",groupLabel="Définition des forfaits",
	hidden="currentObject.mode!='1'", sequence=14,edittable=true)
	@Observer(observable="mode",source="method:generatecycle",parameters="mode")
	private List<ForfaitCycle> forfaitscycle = new ArrayList<ForfaitCycle>();
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	@JoinColumn(name="RUBR_ID")
	@Predicate(label="RU",type=ForfaitPersonnel.class,target="one-to-many",group=true,groupName="group3",groupLabel="Définition des forfaits",
	hidden="currentObject.mode!='2'", sequence=14,edittable=true)
	@Observer(observable="mode",source="method:generatepersonnel",parameters="mode")
	private List<ForfaitPersonnel> forfaitsperso = new ArrayList<ForfaitPersonnel>();
	

	public RubriquePaie(String code, String desc, String type, String porte, String formule, Double tauxsal,
			Double tauxpat) {
		super();
		this.code = code;
		this.desc = desc;
		this.type = type;
		this.porte = porte;
		this.mode = formule;
		this.tauxsal = tauxsal;
		this.tauxpat = tauxpat;
	}
	
	public RubriquePaie(RubriquePaie entity) {
		super(entity.id, entity.designation, entity.moduleName,0L);
		this.code = entity.code;
		this.desc = entity.desc;
		this.type = entity.type;
		this.porte = entity.porte;
		this.mode = entity.mode;
		this.tauxsal = entity.tauxsal;
		this.tauxpat = entity.tauxpat;
		this.forfaitscat= new ArrayList<ForfaitCategorie>();
		this.forfaitscycle= new ArrayList<ForfaitCycle>();
		this.forfaitsperso= new ArrayList<ForfaitPersonnel>();
		this.valFixe=entity.valFixe;
		this.nature=entity.nature;
		this.brutsal = entity.brutsal;
		this.cotisablesal = entity.cotisablesal;
		this.formule=entity.getFormule();
		this.acompte=entity.acompte;
		this.pret=entity.pret;
	}

	public RubriquePaie() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getSearchkeys() {
		// TODO Auto-generated method stub
		return code;
	}
	

	public int compareTo(RubriquePaie o) {
		// TODO Auto-generated method stub
		return (int)o.getId();
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}


	public Double getTauxsal() {
		return tauxsal;
	}

	public void setTauxsal(Double tauxsal) {
		this.tauxsal = tauxsal;
	}

	public Double getTauxpat() {
		return tauxpat;
	}

	public void setTauxpat(Double tauxpat) {
		this.tauxpat = tauxpat;
	}
	
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Rubrique de Paie";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Rubrique de  Paie";
	}

	public String getFormule() {
		return formule;
	}

	public void setFormule(String formule) {
		this.formule = formule;
	}

	public String getMode() {
		return mode;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Double getValFixe() {
		return valFixe;
	}

	public Boolean getAcompte() {
		return acompte;
	}

	public void setAcompte(Boolean acompte) {
		this.acompte = acompte;
	}

	public Boolean getPret() {
		return pret;
	}

	public void setPret(Boolean pret) {
		this.pret = pret;
	}

	public void setValFixe(Double valFixe) {
		this.valFixe = valFixe;
	}

	public List<ForfaitCycle> getForfaitscycle() {
		return forfaitscycle;
	}

	public void setForfaitscycle(List<ForfaitCycle> forfaitscycle) {
		this.forfaitscycle = forfaitscycle;
	}

	public List<ForfaitPersonnel> getForfaitsperso() {
		return forfaitsperso;
	}

	public void setForfaitsperso(List<ForfaitPersonnel> forfaitsperso) {
		this.forfaitsperso = forfaitsperso;
	}

	public List<ForfaitCategorie> getForfaitscat() {
		return forfaitscat;
	}

	public void setForfaitscat(List<ForfaitCategorie> forfaitscat) {
		this.forfaitscat = forfaitscat;
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code +"-"+desc;
	}

	public Boolean getBrutsal() {
		return brutsal;
	}

	public void setBrutsal(Boolean brutsal) {
		this.brutsal = brutsal;
	}

	public Boolean getCotisablesal() {
		return cotisablesal;
	}

	public void setCotisablesal(Boolean cotisablesal) {
		this.cotisablesal = cotisablesal;
	}

}
