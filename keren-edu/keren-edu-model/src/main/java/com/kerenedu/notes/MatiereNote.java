/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Matiere;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_note_mat")
public class MatiereNote extends BaseElement implements Serializable, Comparable<MatiereNote> {
	
	@ManyToOne
	@JoinColumn(name = "PROF")
	@Predicate(label="PROF",updatable=false,type=Professeur.class , target="many-to-one",search=true , sequence=1,colsequence=1	,editable=false)
	protected Professeur prof;
	
	@ManyToOne
    @JoinColumn(name = "MATIERE_ID")
	@Predicate(label="MATIERE",optional=false,updatable=false,search=true , sequence=2, colsequence=2,type=CoefMatiereDetail.class ,editable=false)
	protected CoefMatiereDetail matiere;
	
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="CLASSE",updatable=false,type=Classe.class , target="many-to-one",search=true , sequence=3	,colsequence=3,editable=false)
	protected Classe classe;
	
	@ManyToOne
	@JoinColumn(name = "EXAMEN_ID")
	@Predicate(label="EXAMEN",updatable=false,type=Examen.class , target="many-to-one",search=true , sequence=4	,editable=false,colsequence=4)
	protected Examen examen;

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "EL_NOTE_ID")
	@Predicate(group = true,groupName = "tab1",groupLabel = "Saisies des notes",target ="one-to-many",type = NoteDetail.class
	,search = false,edittable=true)
	private List<NoteDetail> notelisttr = new ArrayList<NoteDetail>();
	
	
	public MatiereNote() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MatiereNote(MatiereNote filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName);
		
		if(filiere.matiere!=null){
			this.matiere = new CoefMatiereDetail(filiere.matiere);
		}
		
		if(filiere.classe!=null){
			this.classe = new Classe(filiere.classe);
		}
		if(filiere.examen!=null){
			this.examen = new Examen(filiere.examen);
		}
		if(filiere.prof!=null){
			this.prof = new Professeur(filiere.prof);
		}
	
		this.notelisttr= new ArrayList<NoteDetail>();
	
		
	}
	
	public MatiereNote(Matiere filiere, List<Inscription> listEleve) {
		this.matiere = new CoefMatiereDetail(filiere);
		this.notelisttr= new ArrayList<NoteDetail>();
		for(Inscription el : listEleve){
			this.notelisttr.add(new NoteDetail(el));
		}
	
	}
	
	public MatiereNote(CoefMatiereDetail coefmat,Examen examen, List<Inscription> listEleve) {
		this.matiere = new CoefMatiereDetail(coefmat);
		this.classe= new Classe(coefmat.getClasse());
		this.prof=new Professeur(coefmat.getProffesseur());
		this.examen= new Examen(examen);
		this.notelisttr= new ArrayList<NoteDetail>();
		for(Inscription el : listEleve){
			this.notelisttr.add(new NoteDetail(el));
		}
	
	}
	

	
	
	public MatiereNote(List<NoteDetail> detailNote,Matiere matiere) {
		this.matiere = new CoefMatiereDetail(matiere);
		this.notelisttr= new ArrayList<NoteDetail>();
		for(NoteDetail note : detailNote){
			if(matiere.getCode().equals(note))
			this.notelisttr.add(new NoteDetail(note));
		}
	}
	
	
	/**
	 * @return the matiere
	 */
	public CoefMatiereDetail getMatiere() {
		return matiere;
	}


	/**
	 * @param matiere the matiere to set
	 */
	public void setMatiere(CoefMatiereDetail matiere) {
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



	public Professeur getProf() {
		return prof;
	}


	public void setProf(Professeur prof) {
		this.prof = prof;
	}


	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Notes";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Notes";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "PROF. "+matiere.getProffesseur().getNom()+" // MATIERE "+ matiere.getMatiere().getLibelle();
	}


	@Override
	public boolean isDesablecreate() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isDesabledelete() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

	

	public int compareTo(MatiereNote o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
