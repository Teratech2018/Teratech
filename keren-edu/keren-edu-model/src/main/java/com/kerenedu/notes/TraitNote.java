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
import com.megatim.common.annotations.Filter;
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
	@JoinColumn(name="CLASSE_ID")
	@Predicate(label="Classe",type=Classe.class,target="many-to-one",optional=false , sequence=1, observable=true)
	@Filter(value="[{\"fieldName\":\"typecycle\",\"value\":\"2\"}]")
	private Classe classe ;
	
	@ManyToOne
	@JoinColumn(name="PERI_ID")
	@Predicate(label="Séquence",type=Examen.class,target="many-to-one",optional=false, sequence=2)
	@Filter(value="[{\"fieldName\":\"state\",\"operator\":\"!=\",\"value\":\"ferme\"}]")
	//@Filter(value="[{\"fieldName\":\"cycle\",\"value\":\"object.classe\",\"searchfield\":\"typecycle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Classe\"}]")
	//@Filter(value="[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	private Examen periode ;
	
//	@ManyToOne
//	@JoinColumn(name="PERI_ID")
//	@Predicate(label="Evaluation",type=ExamenP.class,target="many-to-one",optional=false, sequence=2)
//	//@Filter(value="[{\"fieldName\":\"state\",\"value\":\"etabli\"}]")
//	//@Filter(value="[{\"fieldName\":\"periode\",\"value\":\"object\",\"searchfield\":\"id\",\"optional\":false,\"message\":\"Veuillez sélectionner un examen \"}]")
//	private ExamenP evaluation ;
//		

	
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
		
//		if(prepa.evaluation!=null){
//			this.evaluation = new ExamenP(prepa.evaluation);
//		}
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

//	public ExamenP getEvaluation() {
//		return evaluation;
//	}
//
//	public void setEvaluation(ExamenP evaluation) {
//		this.evaluation = evaluation;
//	}

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
