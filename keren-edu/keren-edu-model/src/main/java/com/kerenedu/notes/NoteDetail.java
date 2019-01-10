/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Appreciation;
import com.kerenedu.inscription.Inscription;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_notedlt")
public class NoteDetail extends BaseElement implements Serializable, Comparable<NoteDetail> {
	
	
	@Column(name = "MATRICULE")
	@Predicate(label = "MATRICULE", optional = true, updatable = false, search = true, type = String.class, hide = true, sequence=1)
	protected String matricule;
	
	
	@Column(name = "NOM")
	@Predicate(label = "NOM", optional = true, updatable = false, search = true, type = String.class, hide = true,  sequence=2)
	protected String nom;
	
	@ManyToOne
    @JoinColumn(name = "ETUDIANT_ID")
	@Predicate(label="Elève" ,target = "many-to-one",type = Inscription.class, sequence=1,editable=true, hide=true)
	private Inscription eleve ;
	
	@Column(name = "SUR")
	//@Predicate(label = "Note/",type = Long.class,search = true  , sequence=2)
	private Long sur = new Long(0) ;
		
	@Column(name = "NOTE_1")
	@Predicate(label = "Q1",type = Double.class,search = true  , sequence=3 )
	private Double note1 = new Double(0) ;
	
	@Column(name = "NOTE_2")
	@Predicate(label = "Q2",type = Double.class,search = true  , sequence=4 )
	private Double note2 = new Double(0) ;
	
	@Column(name = "NOTE_3")
	@Predicate(label = "SEQ",type = Double.class,search = true  , sequence=5)
	private Double note3 = new Double(0) ;

	@Column(name = "NOTE")
	@Predicate(label = "Note",type = Double.class,search = true  , sequence=6, editable=false )
	private Double note = new Double(0) ;
	
	@Column(name = "S_NOTE_1")
	//@Predicate(label = "Q1/Mois1",type = Double.class,search = true  , sequence=3 ,editable=false)
	private Double snote1 = new Double(0) ;
	
	@Column(name = "S_NOTE_2")
	//@Predicate(label = "Q2/Mois2",type = Double.class,search = true  , sequence=4 ,editable=false)
	private Double snote2 = new Double(0) ;
	
	@Column(name = "S_NOTE_3")
	//@Predicate(label = "SEQ/Mois3",type = Double.class,search = true  , sequence=5,editable=false )
	private Double snote3 = new Double(0) ;
	
	
	@Column(name = "APPRECIATION")
	@Predicate(label = "Appreciation", search = true  , sequence=7 ,editable=false)
	private String obs  ;
	
	

	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;
	


	public NoteDetail() {
		super();
	}


	public NoteDetail(NoteDetail notedetail) {
		super(notedetail.id, notedetail.designation, notedetail.moduleName,0L);
		if(notedetail.eleve!=null){
			this.eleve = new Inscription(notedetail.eleve);
		}
		this.obs= notedetail.obs;
		this.note= notedetail.note;
		this.note1= notedetail.note1;
		
		this.note2= notedetail.note2;
		this.note3= notedetail.note3;
		this.sur=notedetail.sur;
		this.anneScolaire=notedetail.anneScolaire;
		this.matricule=notedetail.matricule;
		this.nom=notedetail.nom;
		this.snote1 = notedetail.snote1;
		this.snote2 = notedetail.snote2;
		this.snote3 = notedetail.snote3;

	}
	
	public NoteDetail(Inscription eleve) {
		this.eleve = new Inscription(eleve);
		this.matricule=eleve.getEleve().getMatricule();
		this.nom=eleve.getEleve().getNom();
		this.obs= "";
		this.note= new Double(0);
		this.sur= new Long(20);
		this.anneScolaire=eleve.getAnneScolaire();
		this.snote1 = new Double(0);
		this.snote2 = new Double(0);
		this.snote3 = new Double(0);

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
		return "NOTE ";
	}





	public Inscription getEleve() {
		return eleve;
	}


	public void setEleve(Inscription eleve) {
		this.eleve = eleve;
	}


	public Double getNote() {
		return note;
	}


	public Long getSur() {
		return sur;
	}


	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setSur(Long sur) {
		this.sur = sur;
	}


	public void setNote(Double note) {
		this.note = note;
	}


	public String getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	public String getObs() {
		return obs;
	}


	public Double getNote1() {
		return note1;
	}


	public void setNote1(Double note1) {
		this.note1 = note1;
	}


	public Double getNote2() {
		return note2;
	}


	public void setNote2(Double note2) {
		this.note2 = note2;
	}


	public Double getNote3() {
		return note3;
	}


	public Double getSnote1() {
		return snote1;
	}


	public void setSnote1(Double snote1) {
		this.snote1 = snote1;
	}


	public Double getSnote2() {
		return snote2;
	}


	public void setSnote2(Double snote2) {
		this.snote2 = snote2;
	}


	public Double getSnote3() {
		return snote3;
	}


	public void setSnote3(Double snote3) {
		this.snote3 = snote3;
	}


	public void setNote3(Double note3) {
		this.note3 = note3;
	}


	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public String getSearchkeys() {
		// TODO Auto-generated method stub
		return matricule+","+nom;
	}
	

	public int compareTo(NoteDetail o) {
		// TODO Auto-generated method stub
		return (int)o.getId();
	}



	@Override
	public String toString() {
		return "NoteDetail [matricule=" + matricule + ", nom=" + nom + ", eleve=" + eleve + ", sur=" + sur + ", note1="
				+ note1 + ", note2=" + note2 + ", note3=" + note3 + ", note=" + note + ", obs=" + obs
				+ ", anneScolaire=" + anneScolaire + "]";
	}

}
