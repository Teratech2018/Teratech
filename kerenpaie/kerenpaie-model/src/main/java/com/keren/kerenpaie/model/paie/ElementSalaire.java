/**
 * 
 */
package com.keren.kerenpaie.model.paie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.structures.Syndicat;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_ELSALP")
public class ElementSalaire extends BaseElement implements Serializable, Comparable<ElementSalaire> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8807082111156127699L;
	
	@Predicate(label="Type élément",updatable = false,target="combobox",values="Salaire de base fixe;Indemnité de logement négociée;Anciennité gélée;Retenue syndicale;Retraite complémentaire;Complement salaire;Rubrique spécifiques;Avantage en nature;Montant alloué arbre de noel",observable = true,search=true)
	private String type ="0";
	
	@ManyToOne
	@JoinColumn(name="SYND_ID")
	@Predicate(label="Syndicat",type=Syndicat.class,target="many-to-one",optional=true,hidden="currentObject.type!='3'")
	private Syndicat syndicat ;

	@Predicate(label="Valeur",type=Double.class,hidden="currentObject.type==6||currentObject.type==7",search=true)
	private Double valeur = 0.0;	
	
	@ManyToOne
	@JoinColumn(name="EMPL_ID")
	@Predicate(label="Salarié",type=Employe.class,target="many-to-one",optional=false,updatable = false,search=true)
	private Employe employe ;
	
	@ManyToMany
	@JoinTable(name="T_ELSALRUB",joinColumns=@JoinColumn(name="ELSA_ID"),inverseJoinColumns=@JoinColumn(name="RUBR_ID"))
	@Predicate(label="Details",type=Rubrique.class,target="many-to-many-list",group=true,groupName="group2",groupLabel="Rubriques",hidden="currentObject.type!=6")
	private List<Rubrique> rubriques = new ArrayList<Rubrique>();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "LIAV_ID")
    @Predicate(label=".",target="one-to-many",type=LigneAvantage.class,group=true,groupName="group1",groupLabel="Avantages",hidden="currentObject.type!=7",edittable = true)
    @Observer(observable = "type",source = "method:avantage",parameters = "type")
    private List<LigneAvantage> avantages = new ArrayList<LigneAvantage>();
//	@Predicate(label="Eau",type=Boolean.class,group=true,groupName="group1",groupLabel="Avantages",hidden="currentObject.type!=7")
//	private Boolean eau = Boolean.FALSE;
//	
//	@Predicate(label="Espèce ? ",type=Boolean.class,group=true,groupName="group1",groupLabel="Avantages",hidden="currentObject.type!=7")
//	private Boolean eauMode = Boolean.FALSE;
//	
//	@Predicate(label="Logement",type=Boolean.class,group=true,groupName="group1",groupLabel="Avantages",hidden="currentObject.type!=7")
//	private Boolean logement = Boolean.FALSE;
//
//	@Predicate(label="Espèce ? ",type=Boolean.class,group=true,groupName="group1",groupLabel="Avantages",hidden="currentObject.type!=7")
//	private Boolean logMode = Boolean.FALSE;
//	
//	@Predicate(label="Electricité",type=Boolean.class,group=true,groupName="group1",groupLabel="Avantages",hidden="currentObject.type!=7")
//	private Boolean electricite = Boolean.FALSE;	
//
//	@Predicate(label="Espèce ? ",type=Boolean.class,group=true,groupName="group1",groupLabel="Avantages",hidden="currentObject.type!=7")
//	private Boolean elecMode = Boolean.FALSE;
//	
//	@Predicate(label="Véhicule",type=Boolean.class,group=true,groupName="group1",groupLabel="Avantages",hidden="currentObject.type!=7")
//	private Boolean vehicule = Boolean.FALSE;
//
//	@Predicate(label="Espèce ? ",type=Boolean.class,group=true,groupName="group1",groupLabel="Avantages",hidden="currentObject.type!=7")
//	private Boolean vehMode = Boolean.FALSE;
//	
//	@Predicate(label="Nourriture",type=Boolean.class,group=true,groupName="group1",groupLabel="Avantages",hidden="currentObject.type!=7")
//	private Boolean alimentaire = Boolean.FALSE;
//
//	@Predicate(label="Espèce ? ",type=Boolean.class,group=true,groupName="group1",groupLabel="Avantages",hidden="currentObject.type!=7")
//	private Boolean aliMode = Boolean.FALSE;
//	
//	@Predicate(label="Menagère",type=Boolean.class,group=true,groupName="group1",groupLabel="Avantages",hidden="currentObject.type!=7")
//	private Boolean menagere = Boolean.FALSE;
//
//	@Predicate(label="Espèce ? ",type=Boolean.class,group=true,groupName="group1",groupLabel="Avantages",hidden="currentObject.type!=7")
//	private Boolean menMode = Boolean.FALSE;
	
	
	private String state = "etabli";
	
	
	/**
	 * 
	 */
	public ElementSalaire() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ElementSalaire(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param type
	 * @param employe
	 * @param valeur
	 * @param rubriques
	 * @param eau
	 * @param logement
	 * @param electricite
	 * @param vehicule
	 * @param alimentaire
	 */

	public ElementSalaire(long id, String designation, String moduleName, String type, Employe employe, Double valeur,
			List<Rubrique> rubriques, Boolean eau, Boolean logement, Boolean electricite, Boolean vehicule,
			Boolean alimentaire) {
		super(id, designation, moduleName,0L);
		this.type = type;
		this.employe = employe;
		this.valeur = valeur;
		this.rubriques = rubriques;
//		this.eau = eau;
//		this.logement = logement;
//		this.electricite = electricite;
//		this.vehicule = vehicule;
//		this.alimentaire = alimentaire;
	}
	
	public ElementSalaire(ElementSalaire elt) {
		super(elt.id, elt.designation, elt.moduleName,elt.compareid);
		this.type = elt.type;
		if(elt.employe!=null){
			this.employe = new Employe(elt.employe);
		}
		if(elt.getSyndicat()!=null){
			this.syndicat= new Syndicat(elt.syndicat);
		}
		this.valeur = elt.valeur;
//		this.rubriques = rubriques;
//		this.eau = elt.eau;
//		this.logement = elt.logement;
//		this.electricite = elt.electricite;
//		this.vehicule = elt.vehicule;
//		this.alimentaire = elt.alimentaire;
//		this.state = elt.state;
//		this.menagere=elt.menagere;
	}

        public List<LigneAvantage> getAvantages() {
            return avantages;
        }

        public void setAvantages(List<LigneAvantage> avantages) {
            this.avantages = avantages;
        }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Double getValeur() {
		return valeur;
	}

	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}

	public List<Rubrique> getRubriques() {
		return rubriques;
	}

	public void setRubriques(List<Rubrique> rubriques) {
		this.rubriques = rubriques;
	}

//	public Boolean getEau() {
//		return eau;
//	}
//
//	public void setEau(Boolean eau) {
//		this.eau = eau;
//	}
//
//	public Boolean getLogement() {
//		return logement;
//	}
//
//	public void setLogement(Boolean logement) {
//		this.logement = logement;
//	}
//
//	public Boolean getElectricite() {
//		return electricite;
//	}
//
//	public void setElectricite(Boolean electricite) {
//		this.electricite = electricite;
//	}
//
//	public Boolean getVehicule() {
//		return vehicule;
//	}
//
//	public void setVehicule(Boolean vehicule) {
//		this.vehicule = vehicule;
//	}
//
//	public Boolean getAlimentaire() {
//		return alimentaire;
//	}
//
//	public void setAlimentaire(Boolean alimentaire) {
//		this.alimentaire = alimentaire;
//	}	
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

//	public Boolean getEauMode() {
//		return eauMode;
//	}
//
//	public void setEauMode(Boolean eauMode) {
//		this.eauMode = eauMode;
//	}
//
//	public Boolean getLogMode() {
//		return logMode;
//	}
//
//	public void setLogMode(Boolean logMode) {
//		this.logMode = logMode;
//	}
//
//	public Boolean getElecMode() {
//		return elecMode;
//	}
//
//	public void setElecMode(Boolean elecMode) {
//		this.elecMode = elecMode;
//	}
//
//	public Boolean getVehMode() {
//		return vehMode;
//	}
//
//	public void setVehMode(Boolean vehMode) {
//		this.vehMode = vehMode;
//	}
//
//	public Boolean getAliMode() {
//		return aliMode;
//	}
//
//	public void setAliMode(Boolean aliMode) {
//		this.aliMode = aliMode;
//	}
//
//	public Boolean getMenMode() {
//		return menMode;
//	}
//
//	public void setMenMode(Boolean menMode) {
//		this.menMode = menMode;
//	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Elément Variable";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Eléments Variables";
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

	public Syndicat getSyndicat() {
		return syndicat;
	}

	public void setSyndicat(Syndicat syndicat) {
		this.syndicat = syndicat;
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
		State state = new State("etabli", "Brouillon");
		states.add(state);
		state = new State("active", "Actif");
		states.add(state);
		state = new State("inactive", "Inactif");
		states.add(state);
		return states;
	}

//	public Boolean getMenagere() {
//		return menagere;
//	}
//
//	public void setMenagere(Boolean menagere) {
//		this.menagere = menagere;
//	}

	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ElementSalaire o) {
		// TODO Auto-generated method stub
		return employe.compareTo(o.employe);
	}

}
