/**
 * 
 */
package com.keren.model.stages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.model.structures.Societe;
import com.keren.model.structures.Specialite;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_BESSTARH")
public class BesionStage extends BaseElement implements Serializable, Comparable<BesionStage> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6898194607190798837L;
	
	@Predicate(label="Référence",optional=false,search=true)
	private String code ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date d'émission",type=Date.class,target="date",optional=false,search=true)
	private Date demission ;
	
	@ManyToOne
	@JoinColumn(name="STRUC_ID")
	@Predicate(label="Structure",type=Societe.class,target="many-to-one",optional=false,search=true)
	private Societe structure ;
	

	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de fin",type=Date.class,target="date",optional=false,search=true)
	private Date dfin ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de début",type=Date.class,target="date",optional=false,search=true)
	private Date ddebut ;
	
	@ManyToOne
	@JoinColumn(name="SPEC_ID")
	@Predicate(label="Profil demandé",type=Specialite.class,target="many-to-one",search=true)
	private Specialite profil ;
	
	@Predicate(label="Nombre de Places",type=Short.class,optional=false,min=1,search=true)
	private Short place =0;
	
	@Predicate(label=".",target="textarea",group=true,groupName="group1",groupLabel="Justification")	
	@Lob
	private String justif ;
	
	@Predicate(label=".",target="richeditor",group=true,groupName="group2",groupLabel="Description des tâches")	
	@Lob
	private String description ;
	
	@Predicate(label="Etat",hide=true,search=true)
	private String state = "etabli";

	/**
	 * 
	 */
	public BesionStage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public BesionStage(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param demission
	 * @param structure
	 * @param profil
	 * @param ddebut
	 * @param dfin
	 * @param place
	 * @param justif
	 * @param description
	 */

	public BesionStage(long id, String designation, String moduleName, String code, Date demission, Societe structure,
			Specialite profil, Date ddebut, Date dfin, Short place, String justif, String description) {
		super(id, designation, moduleName,0L);
		this.code = code;
		this.demission = demission;
		this.structure = structure;
		this.profil = profil;
		this.ddebut = ddebut;
		this.dfin = dfin;
		this.place = place;
		this.justif = justif;
		this.description = description;
	}
	
	public BesionStage(BesionStage besion) {
		super(besion.id, besion.designation, besion.moduleName,besion.compareid);
		this.code = besion.code;
		this.demission = besion.demission;
		if(besion.structure!=null){
			this.structure = new Societe(besion.structure);
		}
		this.profil = besion.profil;
		this.ddebut = besion.ddebut;
		this.dfin = besion.dfin;
		this.place = besion.place;
		this.justif = besion.justif;
		this.description = besion.description;
		this.state = besion.state;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDemission() {
		return demission;
	}

	public void setDemission(Date demission) {
		this.demission = demission;
	}

	public Societe getStructure() {
		return structure;
	}

	public void setStructure(Societe structure) {
		this.structure = structure;
	}

	public Specialite getProfil() {
		return profil;
	}

	public void setProfil(Specialite profil) {
		this.profil = profil;
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

	public Short getPlace() {
		return place;
	}

	public void setPlace(Short place) {
		this.place = place;
	}

	public String getJustif() {
		return justif;
	}

	public void setJustif(String justif) {
		this.justif = justif;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "Besion en Stagiaires";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Besions en Stagiaires";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
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
		states.add(new State("traite", "Traité"));
		states.add(new State("annule", "Annulé"));
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
	public int compareTo(BesionStage o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
