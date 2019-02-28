/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.core.base.State;
import com.kerenedu.configuration.Cycle;
import com.kerenedu.configuration.PeriodeScolaire;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Entity
@Table(name = "e_examen")
public class Examen extends BaseElement implements Serializable, Comparable<Examen> {

	
	@ManyToOne 
	@JoinColumn(name = "CYCLE_ID")
	@Predicate(label = "Cycle",target = "many-to-one",type = Cycle.class,search = true  , sequence=1, colsequence=1, optional=false)
	private Cycle cycle = new Cycle();
	
	@Column(name = "LIBELLE")
	@Predicate(label = "Type Séquence", optional = false, updatable = true, search = true, target = "combobox", values = "1ere Séquence;2eme Séquence;3éme Séquence;4éme Séquence;5éme Séquence;6éme Séquence;1er Trimestre;2éme Trimestre;3éme Trimestre", sequence = 2)
	protected String typesequence = "0";
	
	
	@Column(name = "CODE", unique = true)
	@Predicate(label = "CODE", optional = true, updatable = false, search = false, sequence = 3, hide=true)
	protected String code;

	@Column(name = "EVAL_1")
	@Predicate(label = "% Eval N1", optional = false, updatable = true, search = true, type = Double.class, sequence =4)
	protected Double e1 = new Double(100);
	
	@Column(name = "EVAL_2")
	@Predicate(label = "% Eval N2", optional = false, updatable = true, search = true, type = Double.class, sequence =5 )
	protected Double e2 = new Double(100);
	
	@Column(name = "EVAL_3")
	@Predicate(label = "% Eval N3", optional = false, updatable = true, search = true, type = Double.class, sequence =6 )
	protected Double e3 = new Double(100);

	@ManyToOne
	@JoinColumn(name = "PERIODE_ID")
	//@Predicate(label = "PERIODE SCOLAIRE", updatable = true, type = PeriodeScolaire.class, target = "many-to-one", search = true, sequence = 6, colsequence = 2)
	protected PeriodeScolaire periode;

	@Column(name = "D_DEBUT")
	@Temporal(javax.persistence.TemporalType.DATE)
	//@Predicate(label = "Début ", optional = false, updatable = true, type = Date.class, target = "date", sequence = 7)
	protected Date dDeb;

	@Column(name = "D_FIN")
	@Temporal(javax.persistence.TemporalType.DATE)
	//@Predicate(label = "Fin", optional = false, updatable = true, target = "date", type = Date.class, sequence = 6)
	protected Date dFin;

	@Predicate(label = "Statut", search = true, hide = true)
	private String state = "etabli";
	
	@Column(name = "TYPE_CYCLE_ID")
	@Predicate(label ="typecycle", search = true, hide = true)
    protected String typecycle;

	public Examen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Examen(Examen filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName, filiere.compareid);
		this.typesequence = filiere.typesequence;
		this.e1 = filiere.e1;
		this.e2 = filiere.e2;
		this.e3 = filiere.e3;
		if (filiere.periode != null) {
			this.periode = new PeriodeScolaire(filiere.periode);
		}
		if (filiere.cycle != null) {
			this.cycle = new Cycle(filiere.cycle);
		}
		this.code = filiere.code;
		this.dDeb = filiere.dDeb;
		this.dFin = filiere.dFin;
		this.state=filiere.state;
		this.typecycle= filiere.typecycle;

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}



	public String getTypesequence() {
		return typesequence;
	}

	public void setTypesequence(String typesequence) {
		this.typesequence = typesequence;
	}



	public PeriodeScolaire getPeriode() {
		return periode;
	}

	public void setPeriode(PeriodeScolaire periode) {
		this.periode = periode;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Séquences";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Séquences";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		if (typesequence.equals("0")) {
			return "1ere Séquence";
		} else if (typesequence.equals("1")) {
			return "2eme Séquence";
		} else if (typesequence.equals("2")) {
			return "3éme Séquence";
		} else if (typesequence.equals("3")) {
			return "4éme Séquence";
		} else if (typesequence.equals("4")) {
			return "5éme Séquence";
		}else if (typesequence.equals("5")) {
			return "6éme Séquence";
		}else if (typesequence.equals("7")) {
			return "2éme Trimestre";
		}else if (typesequence.equals("8")) {
			return "3éme Trimestre";
		} 
		else {
			return "6éme Séquence";
		}
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

	public int compareTo(Examen o) {
		// TODO Auto-generated method stub
		return (int) o.getId();
	}
	

	public String getState() {
		return state;
	}

	public Double getE1() {
		return e1;
	}

	public void setE1(Double e1) {
		this.e1 = e1;
	}

	public Double getE2() {
		return e2;
	}

	public void setE2(Double e2) {
		this.e2 = e2;
	}

	public Double getE3() {
		return e3;
	}

	public void setE3(Double e3) {
		this.e3 = e3;
	}

	public Cycle getCycle() {
		return cycle;
	}

	public String getTypecycle() {
		return typecycle;
	}

	public void setTypecycle(String typecycle) {
		this.typecycle = typecycle;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> states = new ArrayList<State>();
		State state = new State("etabli", "etabli");
		states.add(state);
		state = new State("ouvert", "Ouvert");
		states.add(state);
		state = new State("ferme", "Fermé");
		states.add(state);
		return states;
	}

}
