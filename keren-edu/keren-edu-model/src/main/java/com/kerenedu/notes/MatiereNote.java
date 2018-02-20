/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Matiere;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_note_mat")
public class MatiereNote extends BaseElement implements Serializable, Comparable<MatiereNote> {
	
	@ManyToOne
    @JoinColumn(name = "MATIERE_ID")
	@Predicate(label="MATIERE",optional=false,updatable=false,search=true , sequence=2, colsequence=1,type=Matiere.class )
	protected Matiere matiere;

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "EL_NOTE_ID")
	@Predicate(group = true,groupName = "tab1",groupLabel = "Saisies des notes",target ="one-to-many",type = NoteDetail.class,search = false)
	private List<NoteDetail> notelisttr = new ArrayList<NoteDetail>();
	
	
	public MatiereNote() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MatiereNote(MatiereNote filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName);
		this.matiere = new Matiere(filiere.matiere);
		this.notelisttr= new ArrayList<NoteDetail>();
	
		
	}
	
	public MatiereNote(Matiere filiere, List<Inscription> listEleve) {
		this.matiere = new Matiere(filiere);
		this.notelisttr= new ArrayList<NoteDetail>();
		for(Inscription el : listEleve){
			this.notelisttr.add(new NoteDetail(el));
		}
	
	}
	

	
	
	public MatiereNote(List<NoteDetail> detailNote,Matiere matiere) {
		this.matiere = new Matiere(matiere);
		this.notelisttr= new ArrayList<NoteDetail>();
		for(NoteDetail note : detailNote){
			if(matiere.getCode().equals(note))
			this.notelisttr.add(new NoteDetail(note));
		}
	}
	
	
	/**
	 * @return the matiere
	 */
	public Matiere getMatiere() {
		return matiere;
	}


	/**
	 * @param matiere the matiere to set
	 */
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}


	/**
	 * @return the notelisttr
	 */
	public List<NoteDetail> getNotelisttr() {
		return notelisttr;
	}


	/**
	 * @param notelisttr the notelisttr to set
	 */
	public void setNotelisttr(List<NoteDetail> notelisttr) {
		this.notelisttr = notelisttr;
	}


	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Matieres";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Matieres";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return matiere.getCode();
	}


	

	public int compareTo(MatiereNote o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
