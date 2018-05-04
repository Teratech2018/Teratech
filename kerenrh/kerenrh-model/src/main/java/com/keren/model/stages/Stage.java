/**
 * 
 */
package com.keren.model.stages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.model.employes.Employe;
import com.keren.model.structures.Departement;
import com.keren.model.structures.Etablissement;
import com.keren.model.structures.NiveauEtude;
import com.keren.model.structures.Specialite;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_STAGERH")
public class Stage extends BaseElement implements Serializable, Comparable<Stage> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3189540460391825189L;
	
	@Predicate(label="Reference",optional=false,unique=true,search=true)
	@Column(unique=true)
	private String code ;
	
	@Predicate(label="Type de stage",target="combobox",values="Académique;Pré-Emploi;Professionnel")
	private String type="0";
     
	@Predicate(label="Nom & Prenom",optional=false,unique=true,search=true)
	private String nom ;
	
	@ManyToOne
	@JoinColumn(name="ETAB_ID")
	@Predicate(label="Etablissement",type=Etablissement.class,target="many-to-one",hidden="currentObject.type!='0'")
	private Etablissement ecole ;
	
	@ManyToOne
	@JoinColumn(name="DEPAR_ID")
	@Predicate(label="Structure d'affectation",type=Departement.class,target="many-to-one",search=true)
	private Departement departement ;	
	
	@ManyToOne
	@JoinColumn(name="NIVE_ID")
	@Predicate(label="Niveau d'étude",type=NiveauEtude.class,target="many-to-one")
	private NiveauEtude niveau ;
	
	
	@ManyToOne
	@JoinColumn(name="BEST_ID")
	@Predicate(label="Ref Besion en Stagiaire",type=BesionStage.class,target="many-to-one",observable=true,optional=false)
	@Filter(value="[{\"fieldName\":\"state\",\"value\":\"valide\"}]")
	private BesionStage besion ;
	
	@ManyToOne
	@JoinColumn(name="SPEC_ID")
	@Predicate(label="Spécialité",type=Specialite.class,target="many-to-one")
	//@Observer(observable="besion",source="field:profil")
	private Specialite specialite;
	
	@Predicate(label="Thème du stage",group=true,groupName="group1",groupLabel="Informations du stage",hidden="currentObject.type!='0'")
	private String theme ;	

	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de fin",type=Date.class,target="date",group=true,groupName="group1",groupLabel="Informations du stage")
	@Observer(observable="besion",source="field:dfin")
	private Date dfin ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de debut",type=Date.class,target="date",group=true,groupName="group1",groupLabel="Informations du stage")
	@Observer(observable="besion",source="field:ddebut")
	private Date ddebut ;	
	
	@ManyToOne
	@JoinColumn(name="EMPL_ID")
	@Predicate(label="Encadreur professionnel",type=Employe.class,target="many-to-one",group=true,groupName="group1",groupLabel="Informations du stage")
	private Employe encadreur ;  
	
	@Predicate(label="Frais de transport",type=Double.class,group=true,groupName="group1",groupLabel="Informations du stage")
	private Double transport =0.0;
	
	@Predicate(label="Email du Stagiaire",target="email",group=true,groupName="group2",groupLabel="Contacts du stagiaire")
	private String mail ;
	
	@Predicate(label="Téléphone du Stagiaire",target="tel",group=true,groupName="group2",groupLabel="Contacts du stagiaire")
	private String tel;
	
	@Predicate(label="Portable du Stagiaire",target="tel",group=true,groupName="group2",groupLabel="Contacts du stagiaire")
	private String portable ;
	
	@Lob
	@Predicate(label="Portable du Stagiaire",target="richeditor",group=true,groupName="group3",groupLabel="Notes")
	private String note ;
	
	@Predicate(label="Etat",hide=true,search=true)
	private String state = "etabli";
	
	/**
	 * 
	 */
	public Stage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Stage(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param nom
	 * @param type
	 * @param ecole
	 * @param departement
	 * @param specialite
	 * @param besion
	 * @param niveau
	 * @param theme
	 * @param ddebut
	 * @param dfin
	 * @param encadreur
	 * @param transport
	 * @param mail
	 * @param tel
	 * @param portable
	 */

	public Stage(long id, String designation, String moduleName, String code, String nom, String type,
			Etablissement ecole, Departement departement, Specialite specialite, BesionStage besion, NiveauEtude niveau,
			String theme, Date ddebut, Date dfin, Employe encadreur, Double transport, String mail, String tel,
			String portable) {
		super(id, designation, moduleName);
		this.code = code;
		this.nom = nom;
		this.type = type;
		this.ecole = ecole;
		this.departement = departement;
		this.specialite = specialite;
		this.besion = besion;
		this.niveau = niveau;
		this.theme = theme;
		this.ddebut = ddebut;
		this.dfin = dfin;
		this.encadreur = encadreur;
		this.transport = transport;
		this.mail = mail;
		this.tel = tel;
		this.portable = portable;
	}
	
	public Stage(Stage stage) {
		super(stage.id, stage.designation, stage.moduleName);
		this.code = stage.code;
		this.nom = stage.nom;
		this.type = stage.type;
		this.ecole = stage.ecole;
		if(stage.departement!=null){
			this.departement = new Departement(stage.departement);
		}
		this.specialite = stage.specialite;
		if(stage.besion!=null){
			this.besion = new BesionStage(stage.besion) ;//besion;
		}		
		this.niveau = stage.niveau;
		this.theme = stage.theme;
		this.ddebut = stage.ddebut;
		this.dfin = stage.dfin;
		if(stage.encadreur!=null){
			this.encadreur = new Employe(stage.encadreur);
		}
		this.transport = stage.transport;
		this.mail = stage.mail;
		this.tel = stage.tel;
		this.portable = stage.portable;
		this.note = stage.note;
		this.state = stage.state;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Etablissement getEcole() {
		return ecole;
	}

	public void setEcole(Etablissement ecole) {
		this.ecole = ecole;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public BesionStage getBesion() {
		return besion;
	}

	public void setBesion(BesionStage besion) {
		this.besion = besion;
	}

	public NiveauEtude getNiveau() {
		return niveau;
	}

	public void setNiveau(NiveauEtude niveau) {
		this.niveau = niveau;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Date getDdebut() {
		return ddebut;
	}

	public void setDdebut(Date ddebut) {
		this.ddebut = ddebut;
	}

	public Date getDfin() {
		return dfin;
	}

	public void setDfin(Date dfin) {
		this.dfin = dfin;
	}

	public Employe getEncadreur() {
		return encadreur;
	}

	public void setEncadreur(Employe encadreur) {
		this.encadreur = encadreur;
	}

	public Double getTransport() {
		return transport;
	}

	public void setTransport(Double transport) {
		this.transport = transport;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPortable() {
		return portable;
	}

	public void setPortable(String portable) {
		this.portable = portable;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
		return "Stage";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Stages";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" / "+nom;
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
		states.add(new State("etabli", "Brouillon"));
		states.add(new State("valide", "Validé"));
		states.add(new State("encours", "En Cours"));
		states.add(new State("termine", "Terminé"));
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
	public int compareTo(Stage arg0) {
		// TODO Auto-generated method stub
		return code.compareTo(arg0.code);
	}

}
