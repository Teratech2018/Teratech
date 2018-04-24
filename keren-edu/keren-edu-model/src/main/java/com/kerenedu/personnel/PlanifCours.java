/**
 * 
 */
package com.kerenedu.personnel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Filiere;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

//@Table
//@Entity(name = "e_plcours")
public class PlanifCours extends BaseElement implements Serializable, Comparable<PlanifCours> {

	private static final long serialVersionUID = -9044947840624123074L;

	@ManyToOne
	@JoinColumn(name="CLASSE_ID")
	@Predicate(label="Sélectionner la Classe",type=Classe.class,target="many-to-one",optional=false , sequence=2 ,observable=true)
//	@Observer(observable="filiere",source="field:classe")
//	@Filter(value="[{\"fieldName\":\"filiere\",\"value\":\"object.filiere\",\"searchfield\":\"code\",\"optional\":false,\"message\":\"Veuillez sélectionner la filiere\"}]")
	private Classe classe ;
	
//	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
//    @JoinColumn(name = "JOURS_COURS_ID")
//	@Predicate(label="jours",group = true,groupName = "tab1",groupLabel = "Journée de cours",target = "one-to-many",type = JoursCours.class,search = true)
//	@Observer(observable="classe",source="method:findjourscours")
//	private List<JoursCours> jourscours = new ArrayList<JoursCours>();

	


	public PlanifCours() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PlanifCours(PlanifCours ins) {
		super(ins.id, ins.designation, ins.moduleName);
		this.classe =  new Classe(ins.classe);
		//this.jourscours = new ArrayList<JoursCours>();
	
	}

	

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(PlanifCours o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Plannifier les cours ";
	}

	@Override
	public String getListTitle() {
	 return "Plannifier les cours";
	}

	@Override
	public String getModuleName() {
		return "kereneducation";
	}



	@Override
	public String getDesignation() {
		return id+"-"+classe.getLibelle();
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
//
//	public void setFiliere(Filiere filiere) {
//		this.filiere = filiere;
//	}



//	public List<JoursCours> getJourscours() {
//		return jourscours;
//	}
//
//
//
//	public void setJourscours(List<JoursCours> jourscours) {
//		this.jourscours = jourscours;
//	}


	

}
