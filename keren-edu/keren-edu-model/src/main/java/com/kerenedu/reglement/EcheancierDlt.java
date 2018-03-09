/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.configuration.Service;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_ech_dlt")
public class EcheancierDlt extends BaseElement implements Serializable, Comparable<EcheancierDlt> {

	@Column(name = "DATE_ECH")
	@Predicate(label="Date Echéance",optional=false,updatable=true,search=true, type=Date.class,sequence=1, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date dateEch = new Date();
	
	@Column(name = "MNT" )	
	@Predicate(label="Montant ",optional=false,updatable=false,search=true, type=Long.class ,sequence=3)
	protected Long Zmnt;

	
	

	public EcheancierDlt() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EcheancierDlt(EcheancierDlt ins) {
		super(ins.id, ins.designation, ins.moduleName);
		this.dateEch = ins.dateEch;
		this.Zmnt = ins.Zmnt;
	
	}


	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(EcheancierDlt o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Echeancier détails ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Echeancier détails";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return id+"";
	}


	public Date getDateEch() {
		return dateEch;
	}


	public void setDateEch(Date dateEch) {
		this.dateEch = dateEch;
	}


	public Long getZmnt() {
		return Zmnt;
	}


	public void setZmnt(Long zmnt) {
		Zmnt = zmnt;
	}

		
	

}
