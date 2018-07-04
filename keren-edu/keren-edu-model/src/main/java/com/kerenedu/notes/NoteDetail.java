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
import com.kerenedu.inscription.Inscription;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_notedlt")
public class NoteDetail extends BaseElement implements Serializable, Comparable<NoteDetail> {
	
	@ManyToOne
    @JoinColumn(name = "ETUDIANT_ID")
	@Predicate(label="Elève" ,target = "many-to-one",type = Inscription.class,search = true , sequence=1, colsequence=1,editable=true)
	private Inscription eleve = new Inscription();
	
	@Column(name = "SUR")
	@Predicate(label = "Note/",type = Long.class,search = true  , sequence=2, colsequence=2)
	private Long sur = new Long(0) ;
	
	@Column(name = "NOTE")
	@Predicate(label = "Note",type = Long.class,search = true  , sequence=3, colsequence=3)
	private Long note = new Long(0) ;
	
	@Column(name = "APPRECIATION")
	@Predicate(label = "Appreciation", search = true  , sequence=3, colsequence=3 ,editable=false)
	private String obs  ;
	
	


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
		this.sur=notedetail.sur;

	}
	
	public NoteDetail(Inscription eleve) {
		this.eleve = new Inscription(eleve);
		this.obs= "";
		this.note= new Long(0);
		this.sur= new Long(20);

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


	public Long getNote() {
		return note;
	}


	public Long getSur() {
		return sur;
	}


	public void setSur(Long sur) {
		this.sur = sur;
	}


	public void setNote(Long note) {
		this.note = note;
	}


	public String getObs() {
		return obs;
	}


	public void setObs(String obs) {
		this.obs = obs;
	}


	public int compareTo(NoteDetail o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
