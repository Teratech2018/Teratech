/**
 * 
 */
package com.kerenedu.stages;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name = "e_bstage")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EBS", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("BS")
public class BaseBesionStage extends BaseElement implements Serializable, Comparable<BaseBesionStage> {

	protected static final long serialVersionUID = 7741105795796486143L;

	@Column(name = "REF")
	@Predicate(label = "Reférence", optional = false, updatable = true, search = true, sequence = 1, colsequence = 1)
	protected String reference;

	@Column(name = "NBRE_PL")
	@Predicate(label = "Nombre de Places ", type = Short.class, optional = true, search = true, editable = true,  sequence = 2)
	protected Short nbreplace = 0;

	@Temporal(TemporalType.DATE)
	@Predicate(label = "Date d'emission du besion", type = Date.class, target = "date", optional = false, search = true, sequence = 3)
	protected Date demission;

	@Temporal(TemporalType.DATE)
	@Predicate(label = "Date Début", type = Date.class, target = "date", optional = false, search = false, editable = true, sequence = 4)
	protected Date debut;

	@Temporal(TemporalType.DATE)
	@Predicate(label = "Date Fin", type = Date.class, target = "date", optional = false, search = false, editable = true, sequence = 5)
	protected Date fin;

	@ManyToOne
	@JoinColumn(name = "LIEU_ID")
	@Predicate(label = "Lieu de Stage", target = "many-to-one", type = LieuStage.class, search = true, sequence = 6)
	private LieuStage lstage;

	@Predicate( target = "textarea", group = true, groupName = "tab1", groupLabel = "Justification")
	@Column(name = "MOTIF")
	protected String motif;

	@Predicate(target = "textarea", group = true, groupName = "tab2", groupLabel = "Activités")
	@Column(name = "ACT")
	protected String activite;
	
	protected String state ;

	/**
	 * 
	 */
	public BaseBesionStage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public BaseBesionStage(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}

	public BaseBesionStage(String reference, Short nbreplace, Date demission, Date debut, Date fin, LieuStage lstage,
			String motif, String activite, String state) {
		super();
		this.reference = reference;
		this.nbreplace = nbreplace;
		this.demission = demission;
		this.debut = debut;
		this.fin = fin;
		this.lstage = lstage;
		this.motif = motif;
		this.activite = activite;
		this.state=state;
	}

	/**
	 * 
	 * @param dc
	 */
	public BaseBesionStage(BaseBesionStage bs) {
		super(bs.id, bs.designation, bs.moduleName);
		this.reference = bs.reference;
		this.nbreplace = bs.nbreplace;
		this.demission = bs.demission;
		this.debut = bs.debut;
		this.fin = bs.fin;
		this.lstage = new LieuStage(bs.lstage);
		this.motif = bs.motif;
		this.activite = bs.activite;
		this.state=bs.state;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Besion en Stage";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return reference+" "+lstage.getLibelle();
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Besion en Stage";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
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
	public String getSerial() {
		// TODO Auto-generated method stub
		serial = Long.toString(serialVersionUID);
		return serial;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Short getNbreplace() {
		return nbreplace;
	}

	public void setNbreplace(Short nbreplace) {
		this.nbreplace = nbreplace;
	}

	public Date getDemission() {
		return demission;
	}

	public void setDemission(Date demission) {
		this.demission = demission;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public LieuStage getLstage() {
		return lstage;
	}

	public void setLstage(LieuStage lstage) {
		this.lstage = lstage;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getActivite() {
		return activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int compareTo(BaseBesionStage o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
