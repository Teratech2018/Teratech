/**
 * 
 */
package com.keren.model.missions;

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

import org.codehaus.jackson.annotate.JsonIgnore;

import com.core.base.BaseElement;
import com.core.base.State;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.keren.model.employes.Employe;
import com.keren.model.structures.Pays;
import com.keren.model.structures.Ville;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_ORDMISSRH")
public class OrdreMission extends BaseElement implements Serializable, Comparable<OrdreMission> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6886836769210172784L;
	
	@Predicate(label="Numero",type=Short.class,editable=false,hide=true)
	private Short numero;
	
	@ManyToOne
	@JoinColumn(name="VILL_ID")
	@Predicate(label="Ville de destination",type=Ville.class,target="many-to-one",optional=false)
	private Ville ville ;
	
	@Predicate(label="Motif",optional=false,search=true)
	private String motif ;
	
	@ManyToOne
	@JoinColumn(name="PAYS_ID")
	@Predicate(label="Pays de destination",type=Pays.class,target="many-to-one",optional=false)
	private Pays pays ;
	
	@ManyToOne
	@JoinColumn(name="MISS_ID")
	@JsonIgnore
//	@Predicate(label="Mission",type=Mission.class,target="many-to-one",editable=false,updatable=false,search=true)
	private Mission mission ;
	
	@ManyToOne
	@JoinColumn(name="SALA_ID")
	@Predicate(label="Employé",type=Employe.class,target="many-to-one",optional=false,search=true)
	private Employe salarie ;
	
	@Predicate(label="Date de départ",type=Date.class,target="date",search=true)
	@Temporal(TemporalType.DATE)
	private Date ddepart ;
	
	@ManyToOne
	@JoinColumn(name="HIERA_ID")
	@Predicate(label="Autorité de délivrance",type=Employe.class,target="many-to-one")
	private Employe hierarchie ;
	
	@Predicate(label="Date de retour",type=Date.class,target="date")
	@Temporal(TemporalType.DATE)
	private Date dretour;
	
	@ManyToOne
	@JoinColumn(name="CATE_ID")
	@Predicate(label="Type de Mission",type=CategorieMission.class,target="many-to-one",optional=false,search=true)
	private CategorieMission categorie ;
	
	@Predicate(label="Description",target="textarea",group=true,groupName="group1",groupLabel="Motif et References")
	private String description ;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JoinColumn(name="FRMI_ID")
	@Predicate(label=".",type=FraisMission.class,target="one-to-many",edittable=true,group=true,groupName="group2",groupLabel="Frais de Mission")
	private List<FraisMission> frais = new ArrayList<FraisMission>();
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JoinColumn(name="ESCA_ID")
	@Predicate(label=".",type=Escale.class,target="one-to-many",edittable=true,group=true,groupName="group3",groupLabel="Escales")
	private List<Escale> escales = new ArrayList<Escale>();
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="T_ORDMIS_EMPL",joinColumns=@JoinColumn(name="ORMI_ID"),inverseJoinColumns=@JoinColumn(name="EMPL_ID"))
	private List<Employe> resources = new ArrayList<Employe>();

	@Predicate(label="Etat",hide=true,search=true)
	private String state = "etabli";
	/**
	 * 
	 */
	public OrdreMission() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public OrdreMission(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param numero
	 * @param ville
	 * @param motif
	 * @param pays
	 * @param mission
	 * @param salarie
	 * @param ddepart
	 * @param hierarchie
	 * @param dretour
	 * @param categorie
	 * @param description
	 * @param frais
	 * @param escales
	 * @param resources
	 */

	public OrdreMission(long id, String designation, String moduleName, Short numero, Ville ville, String motif,
			Pays pays, Mission mission, Employe salarie, Date ddepart, Employe hierarchie, Date dretour,
			CategorieMission categorie, String description, List<FraisMission> frais, List<Escale> escales,
			List<Employe> resources) {
		super(id, designation, moduleName);
		this.numero = numero;
		this.ville = ville;
		this.motif = motif;
		this.pays = pays;
		this.mission = mission;
		this.salarie = salarie;
		this.ddepart = ddepart;
		this.hierarchie = hierarchie;
		this.dretour = dretour;
		this.categorie = categorie;
		this.description = description;
		this.frais = frais;
		this.escales = escales;
		this.resources = resources;
	}

	public OrdreMission(OrdreMission ordre) {
		super(ordre.id, ordre.designation, ordre.moduleName);
		this.numero = ordre.numero;
		this.ville = ordre.ville;
		this.motif = ordre.motif;
		if(ordre.pays!=null){
			this.pays = new Pays(ordre.pays);
		}
		
		if(ordre.salarie!=null){
			this.salarie = new Employe(ordre.salarie);
		}
		this.ddepart = ordre.ddepart;
		if(ordre.hierarchie!=null){
			this.hierarchie = new Employe(ordre.hierarchie);
		}
		this.dretour = ordre.dretour;
		if(ordre.categorie!=null){
			this.categorie = new CategorieMission(ordre.categorie);
		}
		this.description = ordre.description;
		this.state = ordre.state;
//		this.frais = ordre.frais;
//		this.escales = escales;
//		this.resources = resources;
	}
	
	
	public Short getNumero() {
		return numero;
	}

	public void setNumero(Short numero) {
		this.numero = numero;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Employe getSalarie() {
		return salarie;
	}

	public void setSalarie(Employe salarie) {
		this.salarie = salarie;
	}

	public Date getDdepart() {
		return ddepart;
	}

	public void setDdepart(Date ddepart) {
		this.ddepart = ddepart;
	}

	public Employe getHierarchie() {
		return hierarchie;
	}

	public void setHierarchie(Employe hierarchie) {
		this.hierarchie = hierarchie;
	}

	public Date getDretour() {
		return dretour;
	}

	public void setDretour(Date dretour) {
		this.dretour = dretour;
	}

	public CategorieMission getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieMission categorie) {
		this.categorie = categorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<FraisMission> getFrais() {
		return frais;
	}

	public void setFrais(List<FraisMission> frais) {
		this.frais = frais;
	}

	public List<Escale> getEscales() {
		return escales;
	}

	public void setEscales(List<Escale> escales) {
		this.escales = escales;
	}

	public List<Employe> getResources() {
		return resources;
	}

	public void setResources(List<Employe> resources) {
		this.resources = resources;
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
		return "Ordre de Mission";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Ordres de Mission";
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
		states.add(new State("etabli", "Brouillon"));
		states.add(new State("valide", "Validé"));
		states.add(new State("termine", "Terminé"));
		states.add(new State("annule", "Annulé"));
		return states;
	}

	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

	@Override
	public boolean isDesablecreate() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(OrdreMission o) {
		// TODO Auto-generated method stub
		return numero.compareTo(o.numero);
	}

}
