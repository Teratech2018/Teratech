package com.kerenedu.notes;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.MatiereDlt;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ImportNoteClasseFile extends BaseElement implements Serializable, Comparable<ImportNoteClasseFile> {
	@Column(name = "CODE")
	@Predicate(label = "CODE", optional = false, updatable = true, search = true, sequence = 1, colsequence = 1)
	protected String code;
	@Column(name = "LIBELLE")
	@Predicate(label = "LIBELLE", optional = false, updatable = true, search = true, sequence = 2, colsequence = 2)
	protected String libelle;
	@ManyToOne
	@JoinColumn(name = "MATIERE_ID")
	protected CoefMatiereDetail matiere;
	@Predicate(label = "Fichier des Notes ", target = "file", search = true, sequence = 3, colsequence = 3)
	private String filename;
	private String className;

	public ImportNoteClasseFile(Professeur prof, CoefMatiereDetail matiere, Classe classe, Examen examen,
			String filename) {
		this.matiere = matiere;

		this.filename = filename;
	}

	public ImportNoteClasseFile(ImportNoteClasseFile entity) {
		super(entity.id, entity.designation, entity.moduleName, 0L);
		if(entity.getMatiere()!=null){
		this.matiere =  new CoefMatiereDetail(entity.getMatiere());
		}

		this.filename = entity.filename;
		this.code = entity.code;
		this.libelle = entity.libelle;
	}

	public ImportNoteClasseFile(CoefMatiereDetail entity) {
		this.matiere = new CoefMatiereDetail(entity);
		this.filename = "";
		this.code = entity.getMatiere().getCode();
		this.libelle = entity.getMatiere().getLibelle();
	}

	public ImportNoteClasseFile() {
	}

	public int compareTo(ImportNoteClasseFile o) {
		return 0;
	}

	public CoefMatiereDetail getMatiere() {
		return matiere;
	}

	public void setMatiere(CoefMatiereDetail matiere) {
		this.matiere = matiere;
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

	public String getModuleName() {
		return "kereneducation";
	}

	public String toString() {
		return "ImportNoteClasseFile [matiere=" + matiere + ", filename=" + filename + ", className=" + className + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}