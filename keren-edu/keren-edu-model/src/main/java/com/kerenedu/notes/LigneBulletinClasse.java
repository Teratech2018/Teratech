/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.configuration.GroupeCours;
import com.kerenedu.configuration.Matiere;
import com.kerenedu.configuration.MatiereDlt;
import com.kerenedu.model.report.ViewNoteHelper;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_bul_lgn")
public class LigneBulletinClasse extends BaseElement implements Serializable, Comparable<LigneBulletinClasse> {

	@ManyToOne
	@JoinColumn(name = "MAT_ID")
	@Predicate(label = "Matiere", updatable = false, search = true, type = MatiereDlt.class, target = "many-to-one", sequence = 2, editable = false)
	protected MatiereDlt matiere;

	@ManyToOne
	@JoinColumn(name = "PROF_ID")
	@Predicate(label = "PROF.", updatable = false, search = true, type = Professeur.class, target = "many-to-one", sequence = 2, editable = false)
	protected Professeur prof;

	@Column(name = "NOTE_1")
	@Predicate(label = "Note", type = Double.class, search = true, sequence = 2, colsequence = 2, updatable = true)
	private Double note = new Double(0);

	@Column(name = "COEF")
	@Predicate(label = "Coef", type = Long.class, search = true, sequence = 4, colsequence = 4, updatable = false)
	private Long coef = new Long(0);

	@Column(name = "TOTAL")
	@Predicate(label = "Totaux", type = Double.class, search = true, sequence = 5, colsequence = 5, updatable = false)
	private Double totaux = new Double(0);

	@ManyToOne
	@JoinColumn(name = "MODULE_ID")
	protected GroupeCours module;

	@Column(name = "RANG")
	@Predicate(label = "Rang", type = Long.class, search = true, sequence = 6, colsequence = 6, updatable = false)
	private Long rang = new Long(0);

	@Column(name = "APPRECIATION")
	@Predicate(label = "Appreciation", search = true, sequence = 7, colsequence = 7, editable = false)
	private String obs;

	@Column(name = "MOY_20")
	private Double moyenne = new Double(0);

	@Column(name = "POUR_REU")
	private Long pourcentage = new Long(0);

	@Column(name = "MOY_CLA")
	private Double moyeClasse = new Double(0);

	@Column(name = "EXTR_MIN")
	private Double extremeMin = new Double(0);

	@Column(name = "EXTR_MAX")
	private Double extremeMax = new Double(0);

	public LigneBulletinClasse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneBulletinClasse(MatiereDlt matiere, Professeur prof, Double note, Double moyenne, Long coef,
			Long pourcentage, Long rang, Double moyeClasse, Double extremeMin, Double extremeMax, String obs, Double totaux) {
		super();
		this.matiere = matiere;
		this.prof = prof;
		this.note = note;
		this.moyenne = moyenne;
		this.coef = coef;
		this.pourcentage = pourcentage;
		this.rang = rang;
		this.moyeClasse = moyeClasse;
		this.extremeMin = extremeMin;
		this.extremeMax = extremeMax;
		this.obs = obs;
		this.totaux = totaux;
	}

	public LigneBulletinClasse(LigneBulletinClasse filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName, 0L);
		this.obs = filiere.obs;
		this.note = filiere.note;
		this.matiere = new MatiereDlt(filiere.matiere);
		this.prof = new Professeur(filiere.prof);
		this.moyenne = filiere.moyenne;
		this.coef = filiere.coef;
		this.pourcentage = filiere.pourcentage;
		this.rang = filiere.rang;
		this.moyeClasse = filiere.moyeClasse;
		this.extremeMin = filiere.extremeMin;
		this.extremeMax = filiere.extremeMax;
		this.totaux = filiere.totaux;
		this.module = new GroupeCours(filiere.module);
		this.note = filiere.note;

	}


	public LigneBulletinClasse(ViewNoteHelper helper) {
		this.obs = helper.getObs();
		this.note = helper.getNote();
		this.matiere = new MatiereDlt(helper.getMatiere());
		this.prof = new Professeur(helper.getMatiereNote().getProf());
		this.coef = (long) helper.getMatiere().getCoeficient();
		this.totaux = helper.getNote() * this.coef;
		this.moyeClasse = helper.getMoyclasMat();
		this.extremeMin = helper.getExtrememax();
		this.extremeMax = helper.getExtrememax();
		this.module = helper.getMatiereNote().getMatiere().getGroupe();
		this.moyenne=helper.getMoyEtudiant();
		this.rang=helper.getRangMat();

	}

	public GroupeCours getModule() {
		return module;
	}

	public void setModule(GroupeCours module) {
		this.module = module;
	}

	public MatiereDlt getMatiere() {
		return matiere;
	}

	public void setMatiere(MatiereDlt matiere) {
		this.matiere = matiere;
	}

	public Professeur getProf() {
		return prof;
	}

	public void setProf(Professeur prof) {
		this.prof = prof;
	}

	public Double getNote() {
		return note;
	}

	public void setNote(Double note) {
		this.note = note;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(Double moyenne) {
		this.moyenne = moyenne;
	}

	public Long getCoef() {
		return coef;
	}

	public void setCoef(Long coef) {
		this.coef = coef;
	}

	public Long getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(Long pourcentage) {
		this.pourcentage = pourcentage;
	}

	public Long getRang() {
		return rang;
	}

	public void setRang(Long rang) {
		this.rang = rang;
	}

	public Double getMoyeClasse() {
		return moyeClasse;
	}

	public void setMoyeClasse(Double moyeClasse) {
		this.moyeClasse = moyeClasse;
	}

	public Double getExtremeMin() {
		return extremeMin;
	}

	public void setExtremeMin(Double extremeMin) {
		this.extremeMin = extremeMin;
	}

	public Double getTotaux() {
		return totaux;
	}

	public void setTotaux(Double totaux) {
		this.totaux = totaux;
	}

	public Double getExtremeMax() {
		return extremeMax;
	}

	public void setExtremeMax(Double extremeMax) {
		this.extremeMax = extremeMax;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Details  Bulletin";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Details Bulletin";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	public int compareTo(LigneBulletinClasse o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
