/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;

import javax.persistence.Column;
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
//@Table
//@Entity(name = "e_coefmat")
public class CoefMatiereModal extends BaseElement implements Serializable, Comparable<CoefMatiereModal> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2319955732777210165L;
	
	//@Transient
	@ManyToOne
	@JoinColumn(name="SECTION_ID")
//	@Predicate(label="Section",type=SectionE.class,target="many-to-one",optional=false, sequence=1)
	private SectionE section ;
	

	@Transient
	@ManyToOne
	@JoinColumn(name="FILIERE_ID")
	@Predicate(label="Sélectionner la Filiere",type=Filiere.class,target="many-to-one",optional=false, sequence=2, observable=true)
	//@Filter(value="[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	private Filiere filiere ;
	
//	@ManyToOne
//	@JoinColumn(name="CLASSE_ID")
//	@Predicate(label="Classe",type=Classe.class,target="many-to-one",optional=false , sequence=3 , observable=true, search=true)
//	@Filter(value="[{\"fieldName\":\"filiere\",\"value\":\"object.filiere\",\"searchfield\":\"code\",\"optional\":false,\"message\":\"Veuillez sélectionner la filiere\"}]")
//	private Classe classe ;
//		
		

	public CoefMatiereModal() {
		super();
	}


	public CoefMatiereModal(CoefMatiereModal annee) {
		super(annee.id, annee.designation, annee.moduleName,0L);
//		this.classe = new Classe(annee.classe);
		if(annee.filiere!=null){
		this.filiere= new Filiere(annee.filiere);
		this.section=new SectionE(annee.filiere.getSection());
		}

	}





	public Filiere getFiliere() {
		return filiere;
	}


	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}


	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return " Gestion des Affectations des Matières ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Affectations des Matières  ";
	}




	public SectionE getSection() {
		return section;
	}


	public void setSection(SectionE section) {
		this.section = section;
	}


	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return id+"-"+filiere.getLibelle();
	}



	public int compareTo(CoefMatiereModal o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
