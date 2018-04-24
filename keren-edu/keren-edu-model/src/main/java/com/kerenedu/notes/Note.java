/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
//@Table
//@Entity(name = "e_note")
public class Note extends BaseElement implements Serializable, Comparable<Note> {
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="CLASSE",updatable=true,type=Classe.class , target="many-to-one",search=true , sequence=1	)
	protected Classe classe;
	
	@ManyToOne
	@JoinColumn(name = "EXAMEN_ID")
	@Predicate(label="EXAMEN",updatable=true,type=Examen.class , target="many-to-one",search=true , sequence=2	)
	protected Examen examen;
	
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "MATIERE_NOTE_ID")
	@Predicate(group = true,groupName = "tab1",groupLabel = "Liste des Matieres" ,
		label="Liste des Matieres",updatable=true,type=MatiereNote.class ,target ="one-to-many",search=true , sequence=3	)
	protected List<MatiereNote>  matierelisttr;
	
	


	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Note(Note filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName);
		this.classe = new Classe(filiere.classe);
		this.examen = new Examen(filiere.examen);;		
		this.matierelisttr= new ArrayList<MatiereNote>();
	}

	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Saisir des notes";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Saisir des notes";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "Note";
	}


	

	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	public List<MatiereNote> getMatierelisttr() {
		return matierelisttr;
	}


	public void setMatierelisttr(List<MatiereNote> matierelisttr) {
		this.matierelisttr = matierelisttr;
	}




	public Examen getExamen() {
		return examen;
	}


	public void setExamen(Examen examen) {
		this.examen = examen;
	}



	public int compareTo(Note o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
