package com.kerenedu.notes;

import java.io.Serializable;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.core.base.BaseElement;
import com.kerenedu.configuration.ClasseSecondaire;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

public class ImportNoteClasse extends BaseElement implements Serializable, Comparable<ImportNoteClasse> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label = "CLASSE", type = ClasseSecondaire.class, target = "many-to-one", search = true, sequence = 1, optional = false, observable=true)
	protected ClasseSecondaire classe;
	
	
	@ManyToOne
	@JoinColumn(name = "EXAMEN_ID")
	@Predicate(label = "EXAMEN", type = Examen.class, target = "many-to-one", search = true, sequence = 2, optional = false)
	@Filter(value="[{\"fieldName\":\"state\",\"operator\":\"!=\",\"value\":\"ferme\"}]")
	protected Examen examen;
	

	@OneToMany(fetch = FetchType.LAZY, cascade = { javax.persistence.CascadeType.ALL }, orphanRemoval = true)
	@JoinColumn(name = "FILE_MATIERE")
	@Predicate(label = "Matière", updatable = true, type = ImportNoteClasseFile.class, target = "one-to-many", search = true, sequence = 3, group = true, groupLabel = "Matières", groupName = "tab1", edittable = true)
	@Observer(observable = "classe", source = "method:findmatiere")
	protected List<ImportNoteClasseFile> fileMatiere;
	

	public ImportNoteClasse(Professeur prof, CoefMatiereDetail matiere, ClasseSecondaire classe, Examen examen, String filename) {
		this.classe = classe;
		this.examen = examen;
	}

	public ImportNoteClasse(ImportNoteClasse entity) {
		super(entity.id, entity.designation, entity.moduleName, 0L);

		this.classe = new ClasseSecondaire(entity.classe);
		this.examen = new Examen(entity.examen);
	}

	public ImportNoteClasse() {
	}

	public int compareTo(ImportNoteClasse o) {
		return 0;
	}

	public ClasseSecondaire getClasse() {
		return classe;
	}

	public void setClasse(ClasseSecondaire classe) {
		this.classe = classe;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public String getEditTitle() {
		return "Imorter les notes  ";
	}

	public List<ImportNoteClasseFile> getFileMatiere() {
		return fileMatiere;
	}

	public void setFileMatiere(List<ImportNoteClasseFile> fileMatiere) {
		this.fileMatiere = fileMatiere;
	}

	public String getListTitle() {
		return "Importer les notes";
	}

	public String getDesignation() {
		return classe.getLibelle();
	}

	public String getModuleName() {
		return "kereneducation";
	}

	public String toString() {
		return "ImportNoteClasse [classe=" + classe + ", examen=" + examen + ", fileMatiere=" + fileMatiere + "]";
	}
}
