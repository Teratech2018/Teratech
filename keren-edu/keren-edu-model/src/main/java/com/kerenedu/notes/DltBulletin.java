/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.configuration.SectionE;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

public class DltBulletin extends BaseElement implements Serializable, Comparable<DltBulletin> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4609375799032659501L;
	
		
		
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="Classe",type=Classe.class , target="many-to-one",search=true , sequence=1, observable=true)
	//@Filter(value="[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	protected Classe classe ;


	@ManyToOne
    @JoinColumn(name = "SEQ_ID")
	@Predicate(label="Sequence",updatable=true,type=Examen.class , target="many-to-one", sequence=2)
	@Filter(value="[{\"fieldName\":\"cycle\",\"value\":\"object.classe\",\"searchfield\":\"typecycle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Classe\"}]")
    protected Examen seq;

//	@Column(name = "LIBELLE")
//	@Predicate(label="Type Bulletin",optional=false,updatable=true,search=true, target="combobox", values="1ere Trimestre;2eme Trimestre;3éme Trimestre" , sequence=2,colsequence=1)
//	protected String typebulletin="0";
//	
	
	@ManyToOne
    @JoinColumn(name = "FILIERE_ID")
//	@Predicate(label="Selectionner La Filiere",updatable=true,type=Filiere.class , target="many-to-one", sequence=2)
    protected Filiere filiere;
	
	@Transient
	@ManyToOne
	@JoinColumn(name="SECTION_ID")
//	@Predicate(label="Section",type=SectionE.class,target="many-to-one",optional=false, sequence=2)
	private SectionE section ;
	


	public DltBulletin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DltBulletin(DltBulletin bull) {
		super(bull.id, bull.designation, bull.moduleName,0L);
		this.filiere = new Filiere(bull.filiere);
		this.classe = new Classe(bull.classe);
		this.section= new SectionE(bull.getSection());
		this.seq=bull.seq;
		

	}



	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Editer les Bulletins à Editer ";
	}


	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Editer les Bulletins à Editer";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return seq.getDesignation();
	}




	public Examen getSeq() {
		return seq;
	}


	public void setSeq(Examen seq) {
		this.seq = seq;
	}


	public Filiere getFiliere() {
		return filiere;
	}




	public Classe getClasse() {
		return classe;
	}



	public SectionE getSection() {
		return section;
	}


	public void setSection(SectionE section) {
		this.section = section;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}


	public int compareTo(DltBulletin o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
