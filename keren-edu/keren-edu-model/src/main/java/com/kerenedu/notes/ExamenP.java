package com.kerenedu.notes;

import com.core.base.BaseElement;
import com.core.base.State;
import com.kerenedu.configuration.PeriodeScolaire;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ExamenP extends BaseElement implements Serializable, Comparable<ExamenP> {
	@Column(name = "DSC")
	protected String discr = "P";

	@Column(name = "CODE", unique = true)
	@Predicate(label = "CODE", optional = false, updatable = false, search = true, sequence = 1)
	protected String code;

	@Column(name = "LIBELLE")
	@Predicate(label = "Description", optional = false, updatable = true, search = true, sequence = 2)
	protected String typesequence;

	@Column(name = "SUR")
	@Predicate(label = "POURCENTAGE", optional = false, updatable = true, search = true, type = Double.class, sequence = 3)
	protected Double sur = Double.valueOf(0.0D);

	@ManyToOne
	@JoinColumn(name = "PERIODE_ID")
	protected PeriodeScolaire periode;

	@Column(name = "D_DEBUT")
	@Temporal(TemporalType.DATE)
	protected Date dDeb;

	@Column(name = "D_FIN")
	@Temporal(TemporalType.DATE)
	protected Date dFin;

	@Predicate(label = "Statut", search = true, hide = true)
	private String state = "etabli";

	public ExamenP() {
	}

	public ExamenP(ExamenP filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName, 0L);
		this.typesequence = filiere.typesequence;
		this.sur = filiere.sur;
		if (filiere.periode != null) {
			this.periode = new PeriodeScolaire(filiere.periode);
		}
		this.code = filiere.code;
		this.dDeb = filiere.dDeb;
		this.dFin = filiere.dFin;
		this.state = filiere.state;
		this.discr = filiere.discr;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getSur() {
		return sur.doubleValue();
	}

	public String getTypesequence() {
		return typesequence;
	}

	public void setTypesequence(String typesequence) {
		this.typesequence = typesequence;
	}

	public void setSur(double sur) {
		this.sur = Double.valueOf(sur);
	}

	public PeriodeScolaire getPeriode() {
		return periode;
	}

	public void setPeriode(PeriodeScolaire periode) {
		this.periode = periode;
	}

	public String getEditTitle() {
		return "Gestion des évaluations";
	}

	public String getListTitle() {
		return "Gestion des évaluations";
	}

	public String getModuleName() {
		return "kereneducation";
	}

	public String getDesignation() {
		return typesequence;
	}

	public Date getdDeb() {
		return dDeb;
	}

	public void setdDeb(Date dDeb) {
		this.dDeb = dDeb;
	}

	public Date getdFin() {
		return dFin;
	}

	public void setdFin(Date dFin) {
		this.dFin = dFin;
	}

	public int compareTo(ExamenP o) {
		return 0;
	}

	public String getState() {
		return state;
	}

	public String getDiscr() {
		return discr;
	}

	public void setDiscr(String discr) {
		this.discr = discr;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<State> getStates() {
		List<State> states = new ArrayList();
		State state = new State("etabli", "fermé");
		states.add(state);
		state = new State("ouvert", "Ouvert");
		states.add(state);
		state = new State("ferme", "Fermé");
		states.add(state);
		return states;
	}
}
