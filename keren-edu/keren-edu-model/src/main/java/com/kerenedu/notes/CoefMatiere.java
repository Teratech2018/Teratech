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
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.SectionE;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_coefmat")
public class CoefMatiere extends BaseElement implements Serializable, Comparable<CoefMatiere> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2319955732777210165L;

	//@Transient
	@ManyToOne
	@JoinColumn(name="SECTION_ID")
	@Predicate(label="Section",type=SectionE.class,target="many-to-one",optional=false, sequence=1)
	private SectionE section ;
	
		
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="Classe",type=Classe.class , target="many-to-one",search=true , sequence=2, observable=true)
	@Filter(value="[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	protected Classe classe ;
		
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "COEF_MAT_ID")
	@Predicate(group = true,groupName = "tab1",groupLabel = "Matière",target = "one-to-many",type = CoefMatiereDetail.class,search = false,edittable=true)
	@Observer(observable="classe",source="method:findmatierclasse")
	private List<CoefMatiereDetail> matdetailList = new ArrayList<CoefMatiereDetail>();
	
	


	public CoefMatiere() {
		super();
	}


	public CoefMatiere(CoefMatiere annee) {
		super(annee.id, annee.designation, annee.moduleName,0L);
		if(annee.getClasse()!=null){
			this.classe = new Classe(annee.classe);
			//this.section= new SectionE(annee.classe.getSection());
		}

		//this.filiere= new Filiere(annee.filiere);
		this.matdetailList= new ArrayList<CoefMatiereDetail>();
		
		if(annee.getSection()!=null){
			this.section=annee.section;
		}

	}



	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}


//	public Filiere getFiliere() {
//		return filiere;
//	}
//
//
//	public void setFiliere(Filiere filiere) {
//		this.filiere = filiere;
//	}


	public List<CoefMatiereDetail> getMatdetailList() {
		return matdetailList;
	}


	public void setMatdetailList(List<CoefMatiereDetail> matdetailList) {
		this.matdetailList = matdetailList;
	}


	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return " Gestion des Coeficients ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Coeficients ";
	}


	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return id+"-"+classe.getLibelle();
	}



	public SectionE getSection() {
		return section;
	}


	public void setSection(SectionE section) {
		this.section = section;
	}


	public int compareTo(CoefMatiere o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
