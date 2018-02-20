/**
 * 
 */
package com.kerenedu.school;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_visite")
public class VisiteMedicale  extends BaseElement implements Serializable, Comparable<VisiteMedicale> {

	@Column(name = "CODE" ,unique=true)	
	@Predicate(label="CODE",optional=false,updatable=false,search=true)
	protected String code;

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
	@Predicate(label="DATE CONSULTATION",optional=false,updatable=false,search=true, type=Date.class)
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date dateConsultation;
	
	@Column(name = "HEURE_ARRIVE")
	@Predicate(label="HEURE ARRIVE",optional=false,updatable=false,search=true, type=Long.class)
	protected Long heureArrive;
	
	@Column(name = "HEURE_DEPART")
	@Predicate(label="HEURE DEPART",optional=false,updatable=false,search=true, type=Long.class)
	protected Long heureDepart;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.code);
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

	public long getHeureArrive() {
		return heureArrive;
	}

	public void setHeureArrive(long heureArrive) {
		this.heureArrive = heureArrive;
	}

	public long getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(long heureDepart) {
		this.heureDepart = heureDepart;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final VisiteMedicale other = (VisiteMedicale) obj;
		if (!Objects.equals(this.code, other.code)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return code + " - " + objet;
	}

	public int compareTo(VisiteMedicale o) {
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
		return code;
	}

}
