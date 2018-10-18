/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.configuration.PeriodeScolaire;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author wapo
 *
 */
public class TraitNote extends BaseElement implements Serializable, Comparable<TraitNote> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4083876520606273661L;

	@ManyToOne
	@JoinColumn(name="PERI_ID")
	@Predicate(label="Séquence",type=Examen.class,target="many-to-one",optional=false, sequence=1)
	//@Filter(value="[{\"fieldName\":\"state\",\"value\":\"etabli\"}]")
	private Examen periode ;
		
	@ManyToOne
	@JoinColumn(name="CLASSE_ID")
	@Predicate(label="Classe",type=Classe.class,target="many-to-one",optional=false , sequence=2)
	private Classe classe ;
	
	/**
	 * 
	 */
	public TraitNote() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public TraitNote(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param periode
	 * @param porte
	 * @param concernes
	 */
	public TraitNote(long id, String designation, String moduleName, Examen periode
			,Filiere filiere, Classe classe,CoefMatiereDetail prof) {
		super(id, designation, moduleName,0L);
		this.periode = periode;
		this.classe = classe;
		
	}
	
	public TraitNote(TraitNote prepa) {
		super(prepa.id, prepa.designation, prepa.moduleName,0L);
		if(prepa.periode!=null){
			this.periode = new Examen(prepa.periode);
		}
	
		if(prepa.classe!=null){
			this.classe = new Classe(prepa.classe);
		}
		
		
	}
	
	

	public Examen getPeriode() {
		return periode;
	}

	public void setPeriode(Examen periode) {
		this.periode = periode;
	}
	

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Traitement des notes";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Traitement des notes";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return super.getDesignation();
	}

	public int compareTo(TraitNote o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */


}
