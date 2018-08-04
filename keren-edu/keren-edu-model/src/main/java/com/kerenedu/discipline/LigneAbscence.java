/**
 * 
 */
package com.kerenedu.discipline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.base.State;
import com.kerenedu.inscription.Inscription;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_abs_lgn")
public class LigneAbscence extends BaseElement implements Serializable, Comparable<LigneAbscence> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4678610081093002369L;

	@ManyToOne
	@JoinColumn(name = "ELEVE_ID")
	@Predicate(label = "Elève", updatable = false, type = Inscription.class, target = "many-to-one", search = true, sequence = 1)
	protected Inscription eleve;

	@Column(name = "HD")
	@Predicate(label = "HEURE DEBUT(Ex:7:30)", optional = false, updatable = false, search = true, sequence = 2, target = "time")
	protected String hdebut;

	@Column(name = "HF")
	@Predicate(label = "HEURE FIN (Ex:6:30)", optional = false, updatable = false, search = true, sequence = 3, target = "time")
	protected String hfin;

	@Column(name = "HTOTAL")
	@Predicate(label = "Total Heure", updatable = false, search = true, sequence = 4, type = Double.class, editable = false)
	protected Double heuretotal;

	@Predicate(label = "Retard", type = Boolean.class, search = true)
	private Boolean retard = Boolean.FALSE;

	@Predicate(label = "Absent", type = Boolean.class, search = true)
	private Boolean absent = Boolean.FALSE;

	@Predicate(label = "Absent Justifié", type = Boolean.class, search = true)
	private Boolean absencepaye = Boolean.FALSE;

	public LigneAbscence() {
		
	}

	public LigneAbscence(Inscription eleve, String hdebut, String hfin, Boolean retard, Boolean absent,
			Boolean absencepaye, String state) {
		super();
		this.eleve = eleve;
		this.hdebut = hdebut;
		this.hfin = hfin;
		this.retard = retard;
		this.absent = absent;
		this.absencepaye = absencepaye;
	
		
	}

	public LigneAbscence(LigneAbscence ins) {
		super(ins.id, ins.designation, ins.moduleName, 0L);
		if (ins.eleve != null) {
			this.eleve = new Inscription(ins.getEleve());
		}

		this.hdebut = ins.hdebut;
		this.hfin = ins.hfin;
		this.retard = ins.retard;
		this.absent = ins.absent;
		this.absencepaye = ins.absencepaye;
		this.heuretotal=ins.getHeuretotal();
	

	}
	
	public LigneAbscence(Inscription ins) {
		this.eleve = new Inscription(ins);
		this.hdebut = "00:00";
		this.hfin = "00:00";

	}


	public String getHdebut() {
		return hdebut;
	}

	public void setHdebut(String hdebut) {
		this.hdebut = hdebut;
	}

	public String getHfin() {
		return hfin;
	}

	public void setHfin(String hfin) {
		this.hfin = hfin;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(LigneAbscence o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gérer des Abscences";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gérer des Abscences";
	}

	public Inscription getEleve() {
		return eleve;
	}

	public void setEleve(Inscription eleve) {
		this.eleve = eleve;
	}

	public Double getHeuretotal() {
		return heuretotal;
	}

	public void setHeuretotal(Double heuretotal) {
		this.heuretotal = heuretotal;
	}

	public Boolean getRetard() {
		return retard;
	}

	public void setRetard(Boolean retard) {
		this.retard = retard;
	}

	public Boolean getAbsent() {
		return absent;
	}

	public void setAbsent(Boolean absent) {
		this.absent = absent;
	}

	public Boolean getAbsencepaye() {
		return absencepaye;
	}

	public void setAbsencepaye(Boolean absencepaye) {
		this.absencepaye = absencepaye;
	}



	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return this.id + "";
	}



}
