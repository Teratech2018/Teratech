/**
 * 
 */
package com.kerenedu.school;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_dossier")
public class DossierMedical  extends BaseElement implements Serializable, Comparable<DossierMedical> {

	@Column(name = "OBJET")
	@Predicate(label="OBJET",optional=false,updatable=false,search=false)
	protected String objet;

	@Column(name = "ALLERTE_MEDICALE")
	@Predicate(label="ALLERTE MEDICALE",optional=false,updatable=false,search=false)
	protected String allerte;

	@Column(name = "REFERENCE_HOPITAL")
	@Predicate(label="REFERENCE HOPITAL",optional=false,updatable=false,search=true)
	protected String referenceHopital;

	@Column(name = "DATE_CONSULTATION")
	@Predicate(label="DATE CONSULTATION",optional=false,updatable=false,search=true, type=Date.class, target="date")
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date dateConsultation;
	
	@Column(name = "HEURE_ARRIVE")
	@Temporal(javax.persistence.TemporalType.TIME)
	@Predicate(label="HEURE ARRIVE",optional=false,updatable=false,search=true, type=Long.class, target="time")
	protected Date heureArrive;
	
	@Column(name = "HEURE_DEPART")
	@Temporal(javax.persistence.TemporalType.TIME)
	@Predicate(label="HEURE DEPART",optional=false,updatable=false,search=true, type=Long.class, target="time")
	protected Date heureDepart;
	
	@Column(name = "OBS")
	@Predicate(group = true, groupName = "tab1", groupLabel = "Observation", target = "textarea", search = false)
	protected String observation;



	public DossierMedical() {
		
	}

	public DossierMedical(DossierMedical dossierMedical) {
		super(dossierMedical.id, dossierMedical.designation, dossierMedical.moduleName);
		
		this.objet = dossierMedical.objet;
		this.allerte = dossierMedical.allerte;
		this.referenceHopital = dossierMedical.referenceHopital;
		this.dateConsultation =dossierMedical. dateConsultation;
		this.heureArrive =dossierMedical. heureArrive;
		this.heureDepart = dossierMedical.heureDepart;
		this.observation = dossierMedical.observation;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public String getAllerte() {
		return allerte;
	}

	public void setAllerte(String allerte) {
		this.allerte = allerte;
	}

	public String getReferenceHopital() {
		return referenceHopital;
	}

	public void setReferenceHopital(String referenceHopital) {
		this.referenceHopital = referenceHopital;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public Date getDateConsultation() {
		return dateConsultation;
	}

	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}




	public int compareTo(DossierMedical o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Dossier Medical";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Dossier Medical";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return objet;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public void setHeureArrive(Date heureArrive) {
		this.heureArrive = heureArrive;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

}
