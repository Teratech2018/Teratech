package com.kerenedu.model.report;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.GroupeCours;
import com.kerenedu.configuration.Matiere;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.notes.Bulletin;
import com.kerenedu.notes.CoefMatiereDetail;
import com.kerenedu.notes.Examen;
import com.kerenedu.notes.NoteDetail;
import com.megatim.common.annotations.Predicate;

@Table
@Entity(name = "e_zview_bul")
public class ViewBulletin  extends BaseElement implements Serializable, Comparable<ViewBulletin> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Predicate(label = "Matricule", type = String.class, sequence=1)
	@Transient
	private String matricule;

	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="CLASSE",updatable=false,type=Classe.class , target="many-to-one", sequence=2 )
	protected Classe classe;

	@ManyToOne
	@JoinColumn(name = "EXAMEN_ID")
	protected Examen examen;
	
	@ManyToOne
	@JoinColumn(name = "BULLETIN_ID")
	@Predicate(label="TYPE BULLETIN",updatable=false,type=Bulletin.class , target="many-to-one", sequence=3)
	protected Bulletin bulletin;

	@ManyToOne
	@JoinColumn(name = "MATIERE_ID")
	protected Matiere matiere;

	@ManyToOne
	@JoinColumn(name = "INS_ID")
	protected Inscription inscription;

	@ManyToOne
	@JoinColumn(name = "COEF_ID")
	protected CoefMatiereDetail coefficient;
	
	@ManyToOne
	@JoinColumn(name = "MODULE_ID")
	protected GroupeCours module;

	@ManyToOne
	@JoinColumn(name = "NOTE_ID")
	protected NoteDetail note;
	
	@Column(name = "MOY_CLA_MAT")
	protected Double moyClsMat;
	

	public ViewBulletin(String code, Classe classe, Examen examen, Matiere matiere, Inscription inscription,
			CoefMatiereDetail coefficient) {
		super();
		this.classe = classe;
		this.examen = examen;
		this.matiere = matiere;
		this.inscription = inscription;
		this.coefficient = coefficient;
	}
	
	public ViewBulletin(ViewBulletin view) {
		this.id = view.id;
		this.classe = new Classe(view.classe);
		this.examen = new Examen(view.examen);
		this.matiere = new Matiere(view.matiere);
		this.inscription = new Inscription(view.inscription);
		this.coefficient = new CoefMatiereDetail(view.coefficient);
		this.module=new GroupeCours(view.module);
		this.note= new NoteDetail(view.note);
		this.bulletin= new Bulletin(view.bulletin);
		this.moyClsMat=view.moyClsMat;
	}
	
	public ViewBulletin(Bulletin view) {
		super();
		this.bulletin= new Bulletin(view);
	}

	public ViewBulletin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int compareTo(ViewBulletin o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule
	 *            the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	
	/**
	 * @return the classe
	 */
	public Classe getClasse() {
		return classe;
	}

	/**
	 * @param classe
	 *            the classe to set
	 */
	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	/**
	 * @return the examen
	 */
	public Examen getExamen() {
		return examen;
	}

	/**
	 * @param examen
	 *            the examen to set
	 */
	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	/**
	 * @return the matiere
	 */
	public Matiere getMatiere() {
		return matiere;
	}

	/**
	 * @param matiere
	 *            the matiere to set
	 */
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	/**
	 * @return the inscription
	 */
	public Inscription getInscription() {
		return inscription;
	}

	/**
	 * @param inscription
	 *            the inscription to set
	 */
	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}

	/**
	 * @return the coefficient
	 */
	public CoefMatiereDetail getCoefficient() {
		return coefficient;
	}

	/**
	 * @return the note
	 */
	public NoteDetail getNote() {
		return note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(NoteDetail note) {
		this.note = note;
	}

	/**
	 * @return the module
	 */
	public GroupeCours getModule() {
		return module;
	}

	public Bulletin getBulletin() {
		return bulletin;
	}

	public void setBulletin(Bulletin bulletin) {
		this.bulletin = bulletin;
	}

	/**
	 * @param module the module to set
	 */
	public void setModule(GroupeCours module) {
		this.module = module;
	}

	/**
	 * @param coefficient
	 *            the coefficient to set
	 */
	public void setCoefficient(CoefMatiereDetail coefficient) {
		this.coefficient = coefficient;
	}
	
	public Double getMoyClsMat() {
		return moyClsMat;
	}

	public void setMoyClsMat(Double moyClsMat) {
		this.moyClsMat = moyClsMat;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Inscriptions";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Liste des Inscrists";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "Critère de recherche";
	}

}
