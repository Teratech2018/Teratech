/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kerenedu.model.report;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Cycle;
import com.kerenedu.configuration.SectionE;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 *
 * @author Commercial_2
 */
public class EleveInscritSearch extends BaseElement implements Serializable,Comparable<EleveInscritSearch>{

	@ManyToOne
	@JoinColumn(name = "CYCLE_ID")
	@Predicate(label = "Cycle :",type = Cycle.class,target = "many-to-one" , optional=true , sequence=1)
	protected Cycle cycle ;
	
	@ManyToOne
	@JoinColumn(name="SECTION_ID")
	@Predicate(label="Section",type=SectionE.class,target="many-to-one",optional=false, sequence=2)
	private SectionE section ;
	
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label = "Classe :",type = Classe.class,target = "many-to-one" , optional=true, sequence=3)
	@Filter(value="[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	protected Classe classe ;
    


   

    public EleveInscritSearch(Cycle cycle, Classe classe) {
		super();
		this.cycle = cycle;
		this.classe = classe;
	}


    public EleveInscritSearch(EleveInscritSearch entity) {
    	super(entity.id, entity.designation, entity.moduleName,0L);
    	if(entity.cycle!=null){
    		this.cycle =  new Cycle(entity.cycle);
    	}
    	
    	if(entity.classe!=null){
    	this.classe = new Classe(entity.classe) ;
    	}
    	if(entity.section!=null){
        	this.section = new SectionE(entity.section) ;
        	}
		
		
	}


	public EleveInscritSearch() {
    }

  

	public Cycle getCycle() {
		return cycle;
	}



	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
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



	@Override
    public String getEditTitle() {
        return "Critères de recherche"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Critères de recherche"; //To change body of generated methods, choose Tools | Templates.
    }

	public int compareTo(EleveInscritSearch o) {
		// TODO Auto-generated method stub
		return 0;
	}

       
  
}
