package com.kerenedu.discipline;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.notes.Examen;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity(name = "e_zview_abs")
public class ViewAbscence extends BaseElement implements Serializable, Comparable<ViewAbscence> {
	
	private static final long serialVersionUID = -7426874191351556828L;
	
	@ManyToOne
	@JoinColumn(name = "PERI_ID")
	private Examen periode;
	
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	protected Classe classe;
	
	@ManyToOne
	@JoinColumn(name = "LIGNE_ID")
	protected LigneAbscence ligne;
	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire;
	
	
	@Column(name = "ETAT")
	private String state = "etabli";

	public ViewAbscence() {
	}

	public ViewAbscence(Date datAbs, Classe classe, List<LigneAbscence> abscences, String observation,
			String anneScolaire) {
		this.classe = classe;

		this.anneScolaire = anneScolaire;
		state = "etabli";
	}

	public ViewAbscence(ViewAbscence ins) {
		super(ins.id, ins.designation, ins.moduleName, 0L);

		if (ins.getClasse() != null) {
			classe = new Classe(classe);
		}

		if (ins.getLigne() != null) {
			ligne = new LigneAbscence(ins.getLigne());
		}

		this.anneScolaire = anneScolaire;
		this.state = state;
		if (ins.getPeriode() != null) {
			periode = new Examen(ins.getPeriode());
		}
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(Long.valueOf(id));
		return hash;
	}

	public int compareTo(ViewAbscence o) {
		return 0;
	}

	public String getEditTitle() {
		return "Gérer les Abscences";
	}

	public String getListTitle() {
		return "Gérer les Abscences";
	}

	public String getModuleName() {
		return "kereneducation";
	}

	public String getDesignation() {
		return " ";
	}

	public String getAnneScolaire() {
		return anneScolaire;
	}

	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}

	public String getSerial() {
		return Long.toString(-7426874191351556828L);
	}

	public Examen getPeriode() {
		return periode;
	}

	public void setPeriode(Examen periode) {
		this.periode = periode;
	}

	public LigneAbscence getLigne() {
		return ligne;
	}

	public void setLigne(LigneAbscence ligne) {
		this.ligne = ligne;
	}
}
