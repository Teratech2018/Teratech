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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ExamenS extends BaseElement implements Serializable, Comparable<ExamenS> {
	@Column(name = "DSC")
	protected String discr = "S";

	@Column(name = "CODE", unique = true)
	@Predicate(label = "CODE", optional = false, updatable = false, search = false, sequence = 1)
	protected String code;

	@Column(name = "LIBELLE")
	@Predicate(label = "Type Séquence", optional = false, updatable = true, search = true, target = "combobox", values = "1ere Séquence;2eme Séquence;3éme Séquence;4éme Séquence;5éme Séquence;6éme Séquence", sequence = 2, colsequence = 1)
	protected String typesequence = "0";

	@Column(name = "SUR")
	@Predicate(label = "POURCENTAGE", optional = false, updatable = true, search = true, type = Double.class, sequence = 3, colsequence = 3)
	protected Double sur = Double.valueOf(0.0D);

	@ManyToOne
	@JoinColumn(name = "PERIODE_ID")
	@Predicate(label = "PERIODE SCOLAIRE", updatable = true, type = PeriodeScolaire.class, target = "many-to-one", search = true, sequence = 4, colsequence = 2)
	protected PeriodeScolaire periode;

	@Column(name = "D_DEBUT")
	@Temporal(TemporalType.DATE)
	protected Date dDeb;

	@Column(name = "D_FIN")
	@Temporal(TemporalType.DATE)
	protected Date dFin;

	@OneToMany(fetch = FetchType.LAZY, cascade = { javax.persistence.CascadeType.ALL }, orphanRemoval = true)
	@JoinColumn(name = "EXAMEN_P_ID")
	@Predicate(label = "Liste Examens", updatable = true, type = ExamenP.class, target = "one-to-many", search = true, sequence = 2, group = true, groupLabel = "Liste Examen", groupName = "tab1", edittable = true)
	protected List<ExamenP> examens;

	@Predicate(label = "Statut", search = true, hide = true)
	private String state = "etabli";

	public ExamenS() {
	}

	public ExamenS(ExamenS filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName, 0L);
		this.typesequence = filiere.typesequence;
		this.sur = filiere.sur;
		if (filiere.periode != null) {
			this.periode = new PeriodeScolaire(filiere.periode);
		}
		this.code =filiere. code;
		this.dDeb = filiere.dDeb;
		this.dFin = filiere.dFin;
		this.state = filiere.state;
		this.discr = filiere.discr;
		this.examens = new ArrayList<ExamenP>();
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
		return "Gestion des Séquences";
	}

	public String getListTitle() {
		return "Gestion des Séquences";
	}

	public String getModuleName() {
		return "kereneducation";
	}

	public String getDesignation() {
		if (typesequence.equals("0"))
			return "1ere Séquence";
		if (typesequence.equals("1"))
			return "2eme Séquence";
		if (typesequence.equals("2"))
			return "3éme Séquence";
		if (typesequence.equals("3"))
			return "4éme Séquence";
		if (typesequence.equals("4")) {
			return "5éme Séquence";
		}
		return "6éme Séquence";
	}

	public String getDiscr() {
		return discr;
	}

	public void setDiscr(String discr) {
		this.discr = discr;
	}

	public List<ExamenP> getExamens() {
		return examens;
	}

	public void setExamens(List<ExamenP> examens) {
		this.examens = examens;
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

	public int compareTo(ExamenS o) {
		return 0;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<State> getStates() {
		List<State> states = new ArrayList<State>();
		State state = new State("etabli", "fermé");
		states.add(state);
		state = new State("ouvert", "Ouvert");
		states.add(state);
		state = new State("ferme", "Fermé");
		states.add(state);
		return states;
	}
}
