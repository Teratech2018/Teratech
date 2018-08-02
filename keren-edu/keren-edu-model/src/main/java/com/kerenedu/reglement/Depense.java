/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.kerenedu.configuration.TypeDepense;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_depense")
public class Depense extends BaseElement implements Serializable, Comparable<Depense> {

	@Column(name = "Code")
	@Predicate(label="Num Pièce",optional=false,updatable=true,search=false , sequence=1)
	protected String code ;	
	
	@Column(name = "DATE_ENC")
	@Predicate(label="Date Décaissement",optional=false,updatable=true,search=true, type=Date.class,sequence=2, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datEnc;
	
	@ManyToOne
    @JoinColumn(name = "TYPE_ID")
	@Predicate(label="Type Dépense",updatable=true,type=TypeDepense.class ,target="many-to-one",search=false, sequence=4)
    protected TypeDepense typeDepense;
	
	@Column(name = "DEPENSE" )	
	@Predicate(label="Montant",optional=false,updatable=false,search=true, type=Long.class, hide=false ,sequence=6)
	protected Long zdepense ;
	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;
	


	public Depense() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Depense(Depense ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		this.datEnc=ins.datEnc;
		this.anneScolaire=ins.anneScolaire;
		this.zdepense=ins.zdepense;
		this.code=ins.code;
		this.typeDepense=ins.typeDepense;
	}
	
	

	



	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(Depense o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Dépenses ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion  des Dépenses   ";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	


	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return code;
	}


	public String getAnneScolaire() {
		return anneScolaire;
	}


	/**
	 * @return the datEnc
	 */
	public Date getDatEnc() {
		return datEnc;
	}


	/**
	 * @param datEnc the datEnc to set
	 */
	public void setDatEnc(Date datEnc) {
		this.datEnc = datEnc;
	}





	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}

//
//	@Override
//	public boolean isCreateonfield() {
//		// TODO Auto-generated method stub
//		return false;
//	}


//	@Override
//	public boolean isDesablecreate() {
//		// TODO Auto-generated method stub
//		return true;
//	}


	
	public Long getZdepense() {
		return zdepense;
	}


	public void setZdepense(Long zdepense) {
		this.zdepense = zdepense;
	}


	public TypeDepense getTypeDepense() {
		return typeDepense;
	}


	public void setTypeDepense(TypeDepense typeDepense) {
		this.typeDepense = typeDepense;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	
	

}
