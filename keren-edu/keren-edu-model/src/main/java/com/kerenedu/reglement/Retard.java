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

//@Table
//@Entity(name = "e_paie")
public class Retard extends BaseElement implements Serializable, Comparable<Retard> {

	@Column(name = "Nbr_JOUR")
	@Predicate(label="Afficher les écheances qui ont un retard de :",optional=false,updatable=true,search=true, 
	type=Long.class,sequence=1 )
	protected Long nbreJour = new Long(0);
	
	

	public Retard() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Retard(Retard ins) {
		super(ins.id, ins.designation, ins.moduleName);
		this.nbreJour = ins.nbreJour;
	
	}


	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(Retard o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Retards ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Retards";
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


	public Long getNbreJour() {
		return nbreJour;
	}


	public void setNbreJour(Long nbreJour) {
		this.nbreJour = nbreJour;
	}


			
	

}
