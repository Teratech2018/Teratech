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
import com.keren.kerenpaie.model.comptabilite.Compte;
import com.keren.kerenpaie.model.structures.Societe;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * 
 * @author BEKO
 *
 */
@Entity
@Table(name="T_RUBR")
public class Rubrique extends BaseElement implements Comparable<Rubrique>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6956286092155176573L;
	
	@Predicate(label="Code",optional=false,search=true,unique=true)
	private String code ;
	
	@ManyToOne
	@JoinColumn(name="SOC_ID")
	@Predicate(label="Dossier de Paie",type=Societe.class,target="many-to-one",search=false)
	private Societe societe ;
	
	@Predicate(label="Description",optional=true,search=true,unique=true)
	private String label;

	@Predicate(label="Type de rubrique",target="combobox",values="Gain;Retenue",search=true)
	private String type ="0";
	
	@Predicate(label="Nature de rubrique",target="combobox",values="Salaire;Prime;Indemnité;Charge sociale;Charge fiscale;Charge parafiscale;Autre retenue",search=true,observable=true)
	private String nature ="0";	

	@Predicate(label="Impression sur le bulletin",target="combobox",values="Jamais;Toujours;si non nul")
	private String porte="0";

	@Predicate(label="Mode d'évaluation",target="combobox",values="Forfait par catégorie professionnelle;Forfait par salaire catégoriel;Forfait par spécialité/Aptitude proffessionnelle;Formule")
	private String mode="0";	
	
//	@ManyToOne
//	@JoinColumn(name="COMP_ID")
//	@Predicate(label="Compte",type=Compte.class,target="many-to-one",search=true)
//	private Compte compte ;
	
	@Predicate(label="Base",group=true,groupName="group1",groupLabel="Elements de calcul",search=true, sequence=1)
	private String formule;	
	@Predicate(label="Taux salarial(%)",type=Double.class,group=true,groupName="group1",groupLabel="Elements de calcul", sequence=9)
	private Double tauxsal =0.0;
	
	@Predicate(label="Taux patronal(%)",type=Double.class,group=true,groupName="group1",groupLabel="Elements de calcul", sequence=3)
	private Double tauxpat=0.0;

	@Predicate(label="Taux plafond avantage (%)",type=Double.class,group=true,groupName="group1",groupLabel="Elements de calcul", sequence=7,hidden="currentObject.avantagenat==false||currentObject.avantagenat==null")
	private Double tauxplaf=0.0;
	
	//@Predicate(label="Participe au acompte de salaire?",type=Boolean.class,group=true,groupName="group1",groupLabel="Elements de calcul", sequence=4)
	private Boolean acomptesal = Boolean.FALSE;
	
	@Predicate(label="Participe au salaire brut?",type=Boolean.class,group=true,groupName="group1",groupLabel="Elements de calcul", sequence=5)
	private Boolean brutsal = Boolean.FALSE;
	
	//@Predicate(label="Participe au salaire des congés?",type=Boolean.class,group=true,groupName="group1",groupLabel="Elements de calcul", sequence=6)
	private Boolean congesal = Boolean.FALSE;
	
	@Predicate(label="Participe à la base cotisable?",type=Boolean.class,group=true,groupName="group1",groupLabel="Elements de calcul", sequence=13)
	private Boolean cotisablesal = Boolean.FALSE;
	
	//@Predicate(label="Rubrique Proraté?",type=Boolean.class,group=true,groupName="group1",groupLabel="Elements de calcul", sequence=8)
	private Boolean proratesal = Boolean.FALSE;
	
	@Predicate(label="Avantage en Nature?",type=Boolean.class,group=true,groupName="group1",groupLabel="Elements de calcul", sequence=8)
        private Boolean avantagenat = Boolean.FALSE;
	
	@Predicate(label="Nature Avantage",type=String.class,target = "combobox",values = "Eau;Logement;Electricité;Domestiques;Vehicules;Nourriture",group=true,groupName="group1",groupLabel="Elements de calcul",search=true ,hidden="currentObject.avantagenat==false || currentObject.avantagenat==null", sequence=2)
	private String natureAv = "0";
	
	@Predicate(label="Participe à la base Taxable?",type=Boolean.class,group=true,groupName="group1",groupLabel="Elements de calcul", sequence=11)
	private Boolean basetaxablesal = Boolean.FALSE;
	
	@Predicate(label="Participe à la base exceptionnelle?",type=Boolean.class,group=true,groupName="group1",groupLabel="Elements de calcul", sequence=10)
	private Boolean baseexcepsal = Boolean.FALSE;
	
	@Predicate(label="Taux taxable(%)",type=Double.class,group=true,groupName="group1",groupLabel="Elements de calcul",search=true ,hidden="currentObject.basetaxablesal==false || currentObject.basetaxablesal==null", sequence=2)
	private Double tauxtax = 0.0;
	
	//@Predicate(label="Participe au rappel de salaire?",type=Boolean.class,group=true,groupName="group1",groupLabel="Elements de calcul", sequence=12)
	private Boolean rappelsal = Boolean.FALSE;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	@JoinColumn(name="RUBR_ID")
	@Predicate(label="RU",type=ForfaitCategorieProf.class,target="one-to-many",group=true,groupName="group3",groupLabel="Définition des forfaits",
	hidden="currentObject.mode!='0'", sequence=13,edittable=true)
	@Observer(observable="mode",source="method:generatecategorieprof",parameters="mode")
	private List<ForfaitCategorieProf> forfaitscatprof = new ArrayList<ForfaitCategorieProf>();
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	@JoinColumn(name="RUBR_ID")
	@Predicate(label="RU",type=ForfaitCategorie.class,target="one-to-many",group=true,groupName="group3",groupLabel="Définition des forfaits",
	hidden="currentObject.mode!='1'", sequence=14,edittable=true)
	@Observer(observable="mode",source="method:generatecategorie",parameters="mode")
	private List<ForfaitCategorie> forfaitscat = new ArrayList<ForfaitCategorie>();
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	@JoinColumn(name="RUBR_ID")
	@Predicate(label="RU",type=ForfaitSpecialite.class,target="one-to-many",group=true,groupName="group3",groupLabel="Définition des forfaits",hidden="currentObject.mode!='2'", sequence=15)
	private List<ForfaitSpecialite> forfaitsspe = new ArrayList<ForfaitSpecialite>();
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	@JoinColumn(name="RUBR_ID")
	@Predicate(label="RU",type=CompteRubrique.class,target="one-to-many",group=true,groupName="group4",groupLabel="Informations Comptable",edittable=true, sequence=16)
	private List<CompteRubrique> comptes = new ArrayList<CompteRubrique>();
	
	
	public Rubrique() {
		// TODO Auto-generated constructor stub
	}

	public Rubrique(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param societe
	 * @param porte
	 * @param label
	 * @param type
	 * @param compte
	 * @param formule
	 * @param tauxtax
	 * @param tauxsal
	 * @param tauxpat
	 * @param acomptesal
	 * @param brutsal
	 * @param congesal
	 * @param cotisablesal
	 * @param proratesal
	 * @param baseexcepsal
	 * @param rappelsal
	 */

	public Rubrique(long id, String designation, String moduleName, String code, Societe societe, String porte,
			String label, String type, Compte compte, String formule, Double tauxtax, Double tauxsal, Double tauxpat,
			Boolean acomptesal, Boolean brutsal, Boolean congesal, Boolean cotisablesal, Boolean proratesal,
			Boolean baseexcepsal, Boolean rappelsal) {
		super(id, designation, moduleName,0L);
		this.code = code;
		this.societe = societe;
		this.porte = porte;
		this.label = label;
		this.type = type;
//		this.compte = compte;
		this.formule = formule;
		this.tauxtax = tauxtax;
		this.tauxsal = tauxsal;
		this.tauxpat = tauxpat;
		this.acomptesal = acomptesal;
		this.brutsal = brutsal;
		this.congesal = congesal;
		this.cotisablesal = cotisablesal;
		this.proratesal = proratesal;
		this.baseexcepsal = baseexcepsal;
		this.rappelsal = rappelsal;
		
	}

	public Rubrique(Rubrique rubrique) {
		super(rubrique.id, rubrique.designation, rubrique.moduleName,rubrique.compareid);
		this.code = rubrique.code;
		if(rubrique.societe!=null){
			this.societe = new Societe(rubrique.societe);
		}
		this.porte = rubrique.porte;
		this.label = rubrique.label;
		this.type = rubrique.type;
//		if(rubrique.compte!=null){
//			this.compte = new Compte(rubrique.compte);
//		}
		this.formule = rubrique.formule;
		this.tauxtax = rubrique.tauxtax;
		this.tauxsal = rubrique.tauxsal;
		this.tauxplaf=rubrique.tauxplaf;
		this.tauxpat = rubrique.tauxpat;
		this.acomptesal = rubrique.acomptesal;
		this.brutsal = rubrique.brutsal;
		this.congesal = rubrique.congesal;
		this.cotisablesal = rubrique.cotisablesal;
		this.proratesal = rubrique.proratesal;
		this.baseexcepsal = rubrique.baseexcepsal;
		this.basetaxablesal = rubrique.basetaxablesal;
		this.rappelsal = rubrique.rappelsal;
		this.avantagenat = rubrique.avantagenat;
		this.mode = rubrique.mode;
		this.nature = rubrique.nature;
                this.natureAv = rubrique.natureAv;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	public Compte getCompte() {
//		return compte;
//	}
//
//	public void setCompte(Compte compte) {
//		this.compte = compte;
//	}

	public String getFormule() {
		return formule;
	}

	public void setFormule(String formule) {
		this.formule = formule;
	}

	public Double getTauxtax() {
		return tauxtax;
	}

	public void setTauxtax(Double tauxtax) {
		this.tauxtax = tauxtax;
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

	public Boolean getAcomptesal() {
		return acomptesal;
	}

	public void setAcomptesal(Boolean acomptesal) {
		this.acomptesal = acomptesal;
	}

	public Boolean getBrutsal() {
		return brutsal;
	}

	public void setBrutsal(Boolean brutsal) {
		this.brutsal = brutsal;
	}

	public Boolean getCongesal() {
		return congesal;
	}

	public void setCongesal(Boolean congesal) {
		this.congesal = congesal;
	}

	public Boolean getCotisablesal() {
		return cotisablesal;
	}

	public void setCotisablesal(Boolean cotisablesal) {
		this.cotisablesal = cotisablesal;
	}

	public Boolean getProratesal() {
		return proratesal;
	}

	public void setProratesal(Boolean proratesal) {
		this.proratesal = proratesal;
	}

	public Boolean getBaseexcepsal() {
		return baseexcepsal;
	}

	public void setBaseexcepsal(Boolean baseexcepsal) {
		this.baseexcepsal = baseexcepsal;
	}

	public Boolean getRappelsal() {
		return rappelsal;
	}

	public void setRappelsal(Boolean rappelsal) {
		this.rappelsal = rappelsal;
	}

        public String getNatureAv() {
            return natureAv;
        }

        public void setNatureAv(String natureAv) {
            this.natureAv = natureAv;
        }       

	public List<ForfaitCategorie> getForfaitscat() {
		return forfaitscat;
	}

	public void setForfaitscat(List<ForfaitCategorie> forfaitscat) {
		this.forfaitscat = forfaitscat;
	}

	public List<ForfaitCategorieProf> getForfaitscatprof() {
		return forfaitscatprof;
	}

	public void setForfaitscatprof(List<ForfaitCategorieProf> forfaitscatprof) {
		this.forfaitscatprof = forfaitscatprof;
	}	

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public List<ForfaitSpecialite> getForfaitsspe() {
		return forfaitsspe;
	}

	public void setForfaitsspe(List<ForfaitSpecialite> forfaitsspe) {
		this.forfaitsspe = forfaitsspe;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	

//	public Double getTauxava() {
//		return tauxava;
//	}
//
//	public void setTauxava(Double tauxava) {
//		this.tauxava = tauxava;
//	}

	public Boolean getBasetaxablesal() {
		return basetaxablesal;
	}

	public Double getTauxplaf() {
		return tauxplaf;
	}

	public void setTauxplaf(Double tauxplaf) {
		this.tauxplaf = tauxplaf;
	}

	public void setBasetaxablesal(Boolean basetaxablesal) {
		this.basetaxablesal = basetaxablesal;
	}
	
	

	public Boolean getAvantagenat() {
		return avantagenat;
	}

	public void setAvantagenat(Boolean avantagenat) {
		this.avantagenat = avantagenat;
	}

	public List<CompteRubrique> getComptes() {
		return comptes;
	}

	public void setComptes(List<CompteRubrique> comptes) {
		this.comptes = comptes;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Rubrique de paie";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Rubriques de paie";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" - "+label;
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
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int compareTo(Rubrique arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
