package com.kerenedu.notes;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.MatiereDlt;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ImportNote extends BaseElement implements Serializable, Comparable<ImportNote> {
	@ManyToOne
	@JoinColumn(name = "PROF")
	@Predicate(label = "PROF", updatable = true, type = Professeur.class, target = "many-to-one", search = true, sequence = 1, editable = false, searchfields = "prof.nom")
	protected Professeur prof;
	@ManyToOne
	@JoinColumn(name = "MATIERE_ID")
	@Predicate(label = "MATIERE", optional = true, updatable = false, search = true, sequence = 2, type = CoefMatiereDetail.class, editable = false)
	protected CoefMatiereDetail matiere;
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label = "CLASSE", updatable = true, type = Classe.class, target = "many-to-one", search = true, sequence = 3, editable = false)
	protected Classe classe;
	@ManyToOne
	@JoinColumn(name = "EXAMEN_ID")
	@Predicate(label = "EXAMEN", updatable = true, type = Examen.class, target = "many-to-one", search = true, sequence = 4, editable = false, colsequence = 4)
	protected Examen examen;
	@Predicate(label = "Fichier lié", target = "file", search = true, sequence = 5)
	private String filename;
	@Predicate(label = "", type = Long.class, search = true, sequence = 6, hide = true)
	private long idmat;
	private String className;

	public ImportNote(Professeur prof, CoefMatiereDetail matiere, Classe classe, Examen examen, String filename) {
		this.prof = prof;
		this.matiere = matiere;
		this.classe = classe;
		this.examen = examen;
		this.filename = filename;
	}

	public ImportNote(ImportNote entity) {
		super(entity.id, entity.designation, entity.moduleName, 0L);
		this.prof = entity.prof;
		this.matiere = entity.matiere;
		this.classe = entity.classe;
		this.examen = entity.examen;
		this.filename = entity.filename;
	}

	public ImportNote() {
	}

	public int compareTo(ImportNote o) {
		return 0;
	}

	public Professeur getProf() {
		return prof;
	}

	public void setProf(Professeur prof) {
		this.prof = prof;
	}

	public CoefMatiereDetail getMatiere() {
		return matiere;
	}

	public void setMatiere(CoefMatiereDetail matiere) {
		this.matiere = matiere;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getEditTitle() {
		return "Imorter les notes  ";
	}

	public String getListTitle() {
		return "Importer les notes";
	}

	public String getDesignation() {
		return matiere.getMatiere().getLibelle();
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public long getIdmat() {
		return idmat;
	}

	public void setIdmat(long idmat) {
		this.idmat = idmat;
	}

	public String getModuleName() {
		return "kereneducation";
	}

	public String toString() {
		return "ImportNote [prof=" + prof + ", matiere=" + matiere + ", classe=" + classe + ", examen=" + examen
				+ ", filename=" + filename + ", idmat=" + idmat + "]";
	}
}
