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

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.GroupeCours;
import com.kerenedu.configuration.MatiereDlt;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_note_mat")
public class MatiereNote extends BaseElement implements Serializable, Comparable<MatiereNote> {
	
	
	
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="CLASSE",updatable=true,type=Classe.class , target="many-to-one",search=true , sequence=1	,colsequence=3,editable=false, optional=false)
	protected Classe classe;
	
	@ManyToOne
	@JoinColumn(name = "EXAMEN_ID")
	@Predicate(label="EXAMEN",updatable=true,type=Examen.class , target="many-to-one",search=true , sequence=2	,editable=false,colsequence=4, optional=false)
	protected Examen examen;
	
	@ManyToOne
    @JoinColumn(name = "MATIERE_ID")
	@Predicate(label="MATIERE",optional=true,updatable=true,search=true , sequence=3, colsequence=1,type=CoefMatiereDetail.class ,editable=false , observable=true
			)
	protected CoefMatiereDetail matiere;
	
//	@ManyToOne
//    @JoinColumn(name = "MODULE_ID")
//	@Predicate(label="MODULE",optional=true,updatable=true,search=true , sequence=3, colsequence=1,type=GroupeCours.class ,editable=false , observable=true
//	,hidden="currentObject.classe.filiere.cycle.typeccyle!=1")
//	protected GroupeCours module;
	
	@ManyToOne
	@JoinColumn(name = "PROF")
	@Predicate(label="PROF",updatable=true,type=Professeur.class , target="many-to-one",search=true , sequence=4,colsequence=2	,editable=false, searchfields="prof.nom")
	@Observer(observable = "matiere", source = "field:proffesseur")
	protected Professeur prof;


	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "EL_NOTE_ID")
	@Predicate(group = true,groupName = "tab1",groupLabel = "Saisies des notes",target ="one-to-many",type = NoteDetail.class
	,search = false,edittable=true)
	@Observer(observable="classe",source="method:findeleveclasse",parameters="classe")
	private List<NoteDetail> notelisttr = new ArrayList<NoteDetail>();
	
//	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
//    @JoinColumn(name = "EL_NOTE_ID")
//	@Predicate(group = true,groupName = "tab1",groupLabel = "Saisies des notes",target ="one-to-many",type = NoteDetailPr.class
//	,search = false,edittable=true , hidden = "currentObject.classe.filiere.cycle.typecycle!=1")
//	@Observer(observable="classe",source="method:findeleveclasse",parameters="classe")
//	private List<NoteDetailPr> notesprimaire = new ArrayList<NoteDetailPr>();
	

	@Column(name = "ANNEE")
	protected String anneScolaire ;
	
	
	public MatiereNote() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MatiereNote(MatiereNote filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName,0L);
		
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
//		if(filiere.module!=null){
//			this.module = new GroupeCours(filiere.module);
//		}
		this.anneScolaire=filiere.anneScolaire;
	
		this.notelisttr= new ArrayList<NoteDetail>();
	//	this.notesprimaire= new ArrayList<NoteDetailPr>();
	
		
	}
	
	@Override
	public String toString() {
		return "MatiereNote [classe=" + classe + ", examen=" + examen + ", matiere=" + matiere + ", prof=" + prof
				+ ", notelisttr=" + notelisttr + ", anneScolaire=" + anneScolaire + "]";
	}


	public MatiereNote(MatiereDlt filiere, List<Inscription> listEleve) {
		this.matiere = new CoefMatiereDetail(filiere);
		this.notelisttr= new ArrayList<NoteDetail>();
		for(Inscription el : listEleve){
			this.notelisttr.add(new NoteDetail(el));
		}
	
	}
	
	public MatiereNote(CoefMatiereDetail coefmat,Examen examen, List<Inscription> listEleve) {
		this.matiere = new CoefMatiereDetail(coefmat);
		this.classe= new Classe(coefmat.getClasse());
		if(coefmat.getProffesseur()!=null){
		this.prof=new Professeur(coefmat.getProffesseur());
		}
		this.examen= new Examen(examen);
		
		this.notelisttr= new ArrayList<NoteDetail>();
		for(Inscription el : listEleve){
			this.notelisttr.add(new NoteDetail(el));
		}
	
	}
	
	public MatiereNote(GroupeCours coefmat,Examen examen, List<Inscription> listEleve, Classe classe) {
		//this.module = new GroupeCours(coefmat);
		this.classe= new Classe(classe);
		//if(coefmat.getProffesseur()!=null){
		this.prof=new Professeur(new Professeur());
		//}
		this.examen= new Examen(examen);
		
//		this.notesprimaire= new ArrayList<NoteDetailPr>();
//		for(Inscription el : listEleve){
//			this.notesprimaire.add(new NoteDetailPr(el));
//		}
	
	}
	public MatiereNote(CoefMatiereDetail coefmat,Examen examen,Inscription eleve) {
		this.matiere = new CoefMatiereDetail(coefmat);
		this.classe= new Classe(coefmat.getClasse());
		this.prof=new Professeur(coefmat.getProffesseur());
		this.examen= new Examen(examen);
		this.notelisttr= new ArrayList<NoteDetail>();
		this.notelisttr.add(new NoteDetail(eleve));

	
	}
	

	
	
	public MatiereNote(List<NoteDetail> detailNote,MatiereDlt matiere) {
		this.matiere = new CoefMatiereDetail(matiere);
		this.notelisttr= new ArrayList<NoteDetail>();
		for(NoteDetail note : detailNote){
//			if(matiere.getCode().equals(note))
//			this.notelisttr.add(new NoteDetail(note));
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

//
//	public GroupeCours getModule() {
//		return module;
//	}
//
//
//	public void setModule(GroupeCours module) {
//		this.module = module;
//	}


	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Notes";
	}

//	public List<NoteDetailPr> getNotesprimaire() {
//		return notesprimaire;
//	}
//
//
//	public void setNotesprimaire(List<NoteDetailPr> notesprimaire) {
//		this.notesprimaire = notesprimaire;
//	}


	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Notes";
	}

	public String getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "Matière. "+matiere.getMatiere().getCode();
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
