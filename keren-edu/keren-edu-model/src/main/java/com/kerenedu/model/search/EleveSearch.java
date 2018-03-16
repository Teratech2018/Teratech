/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kerenedu.model.search;

import java.io.Serializable;

import com.core.base.BaseElement;
import com.kerenedu.school.Nationalite;
import com.megatim.common.annotations.Predicate;

/**
 *
 * @author Commercial_2
 */
public class EleveSearch extends BaseElement implements Serializable,Comparable<EleveSearch>{

	@Predicate(label = "Matricule:",type = String.class, search=true)
    private String matricule ;
	
   // @Predicate(label = "Nationnalité:",type = Nationalite.class,target = "many-to-one")
    private Nationalite nationalite ;
    

    


    /**
     * 
     * @param source
     * @param cible
     * @param debut
     * @param fin 
     */
    public EleveSearch(Nationalite nationalite,String matricule  ) {
        this.nationalite = nationalite;
        this.matricule = matricule;
    }

    /**
     * 
     * @param source
     * @param cible
     * @param debut
     * @param fin
     * @param id
     * @param designation
     * @param moduleName 
     */
    public EleveSearch(Nationalite nationalite,String matricule, long id, String designation, String moduleName) {
        super(id, designation, moduleName);
        this.nationalite = nationalite;
        this.matricule = matricule;
    }

    public EleveSearch() {
    }

  

    public Nationalite getNationalite() {
		return nationalite;
	}

	public void setNationalite(Nationalite nationalite) {
		this.nationalite = nationalite;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	@Override
    public String getEditTitle() {
        return "Critères de recherche"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Critères de recherche"; //To change body of generated methods, choose Tools | Templates.
    }

	public int compareTo(EleveSearch o) {
		// TODO Auto-generated method stub
		return 0;
	}

       
  
}
