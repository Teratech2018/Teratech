/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_s_filiere")
public class ServiceFilliere extends BaseElement implements Serializable, Comparable<ServiceFilliere> {

	@ManyToOne
	@JoinColumn(name = "FILIERE_ID")
	@Predicate(label = "Filiere", updatable = true, search = true,type = Filiere.class, target = "many-to-one", optional = false, sequence = 1)
	protected Filiere filiere;

	@Column(name = "MNT")
	@Predicate(label = "MONTANT", optional = false, updatable = true, search = true, type = Long.class, sequence = 2)
	protected Long zMnt;

	public ServiceFilliere() {

	}

	public ServiceFilliere(ServiceFilliere service) {
		super(service.id, service.designation, service.moduleName, 0L);
		if (service.zMnt == null) {
			this.zMnt = new Long(0);
		} else {
			this.zMnt = service.zMnt;
		}
		if (service.getFiliere() != null) {
			this.filiere = new Filiere(service.getFiliere());
		}

	}

	public ServiceFilliere(Filiere service) {

		this.zMnt = new Long(0);
		this.filiere = new Filiere(service);

	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(ServiceFilliere o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Services Scolaire";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Services Scolaire";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return filiere.getDesignation() + "-" + zMnt;
	}

	public Long getzMnt() {

		return zMnt;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public void setzMnt(Long zMnt) {
		this.zMnt = zMnt;
	}
	
	
	

}
