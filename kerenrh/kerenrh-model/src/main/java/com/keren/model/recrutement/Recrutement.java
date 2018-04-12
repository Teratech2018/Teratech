/**
 * 
 */
package com.keren.model.recrutement;

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
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_RECRURH")
public class Recrutement extends BaseElement implements Comparable<Recrutement>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2317515600917733231L;
	
	@ManyToOne
	@JoinColumn(name="CAND_ID")
	@Predicate(label="Candidat concerné",type=CandidatureSpontane.class,target="many-to-one")
	private CandidatureSpontane candidature ;
	
	@ManyToOne
	@JoinColumn(name="BESREC_ID")
	@Predicate(label="Besion Liée",type=BesionRecrutement.class,target="many-to-one")
	private BesionRecrutement besion ;
	
	@ManyToOne
	@JoinColumn(name="ETAREC_ID")
	@Predicate(label="Etape Recrutement",type=EtapeRecrutement.class,target="many-to-one")
	private EtapeRecrutement etape ;
	
	@Predicate(label="Appréciation",target="combobox",values="Faible;Moyen;Bon;Excellent;Parfait")
	private String niveau ;
	
	@Predicate(label=".",target="textarea",group=true,groupName="group1",groupLabel="Appréciations")
	private String note;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	@JoinColumn(name="DETREC_ID")
	private List<DetailRecrutement> details = new ArrayList<DetailRecrutement>();

	@Predicate(label="Etat",hide=true,search=true)
	private String state = "etabli";

	/**
	 * 
	 */
	public Recrutement() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Recrutement(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param candidature
	 * @param besion
	 * @param etape
	 * @param niveau
	 * @param note
	 * @param details
	 */

	public Recrutement(long id, String designation, String moduleName, CandidatureSpontane candidature,
			BesionRecrutement besion, EtapeRecrutement etape, String niveau, String note,
			List<DetailRecrutement> details) {
		super(id, designation, moduleName);
		this.candidature = candidature;
		this.besion = besion;
		this.etape = etape;
		this.niveau = niveau;
		this.note = note;
		this.details = details;
	}
	
	public Recrutement(Recrutement recru) {
		super(recru.id, recru.designation, recru.moduleName);
		if(recru.candidature!=null){
			this.candidature = new CandidatureSpontane(recru.candidature);
		}
		if(recru.besion!=null){
			this.besion = new BesionRecrutement(recru.besion);
		}
		this.etape = recru.etape;
		this.niveau = recru.niveau;
		this.note = recru.note;
//		this.details = details;
		this.state = recru.state;
	}
	
	

	public CandidatureSpontane getCandidature() {
		return candidature;
	}

	public void setCandidature(CandidatureSpontane candidature) {
		this.candidature = candidature;
	}

	public BesionRecrutement getBesion() {
		return besion;
	}

	public void setBesion(BesionRecrutement besion) {
		this.besion = besion;
	}

	public EtapeRecrutement getEtape() {
		return etape;
	}

	public void setEtape(EtapeRecrutement etape) {
		this.etape = etape;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<DetailRecrutement> getDetails() {
		return details;
	}

	public void setDetails(List<DetailRecrutement> details) {
		this.details = details;
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
		return "Suivi du Recrutement";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Suivi du Recrutement";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return candidature.getDesignation();
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
		states.add(new State("etabli", "En Cours"));
		states.add(new State("termine", "Terminé"));
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
	public int compareTo(Recrutement o) {
		// TODO Auto-generated method stub
		return candidature.compareTo(o.candidature);
	}

}
