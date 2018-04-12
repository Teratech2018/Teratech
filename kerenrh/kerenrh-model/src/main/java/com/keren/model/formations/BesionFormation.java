/**
 * 
 */
package com.keren.model.formations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.model.structures.Societe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="BESFORMRH")
public class BesionFormation extends BaseElement implements Serializable, Comparable<BesionFormation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4109941020004388743L;
	
	@Predicate(label="Reference",optional=false,unique=true,search=true)
	@Column(unique=true)
	private String code ;
	
	@ManyToOne
	@JoinColumn(name="SOC_ID")
	@Predicate(label="Structure",type=Societe.class,target="many-to-one",search=true)
	private Societe societe;
	
	@Predicate(label="Intitulé",search=true)
	private String intitule ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date d'émission",type=Date.class,target="date",optional=false)
	private Date date ;
	
	@Predicate(label="Coût estimatif",type=Double.class,optional=false)
	private Double cout =0.0;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	@JoinColumn(name="BF_ID")
	@Predicate(label=".",type=LigneBesionFormation.class,target="one-to-many",edittable=true,group=true,groupName="group1",groupLabel="Détails du Besion")
	private List<LigneBesionFormation> lignes = new ArrayList<LigneBesionFormation>();
	
	@Predicate(label=".",target="textarea",group=true,groupName="group2",groupLabel="Notes")
	private String note ;
	
	@OneToMany(mappedBy="besion" , fetch=FetchType.LAZY)
	private List<DemandeFormation> demandes = new ArrayList<DemandeFormation>();

	@Predicate(label="Etat",hide=true,search=true)
	private String state = "etabli";
	
	/**
	 * 
	 */
	public BesionFormation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public BesionFormation(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param societe
	 * @param intitule
	 * @param date
	 * @param ecout
	 * @param lignes
	 * @param note
	 * @param demandes
	 */

	public BesionFormation(long id, String designation, String moduleName, String code, Societe societe,
			String intitule, Date date, Double ecout, List<LigneBesionFormation> lignes, String note,
			List<DemandeFormation> demandes) {
		super(id, designation, moduleName);
		this.code = code;
		this.societe = societe;
		this.intitule = intitule;
		this.date = date;
		this.cout = ecout;
		this.lignes = lignes;
		this.note = note;
		this.demandes = demandes;
	}
	
	public BesionFormation(BesionFormation bf) {
		super(bf.id, bf.designation, bf.moduleName);
		this.code = bf.code;
		if(bf.societe!=null){
			this.societe = new Societe(bf.societe);
		}
		this.intitule = bf.intitule;
		this.date = bf.date;
		this.cout = bf.cout;
//		this.lignes = lignes;
		this.note = bf.note;
		this.state = bf.state;
//		this.demandes = demandes;
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

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getCout() {
		return cout;
	}

	public void setCout(Double cout) {
		this.cout = cout;
	}

	public List<LigneBesionFormation> getLignes() {
		return lignes;
	}

	public void setLignes(List<LigneBesionFormation> lignes) {
		this.lignes = lignes;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<DemandeFormation> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<DemandeFormation> demandes) {
		this.demandes = demandes;
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
		return "Besion de Formation";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Besions de Formation";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" - "+intitule;
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
//		states.add(new State("rejete", "Brouillon"));
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
	public int compareTo(BesionFormation o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
