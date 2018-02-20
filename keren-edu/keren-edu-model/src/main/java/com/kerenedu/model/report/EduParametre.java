/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kerenedu.model.report;

import java.io.Serializable;

import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.Etablissement;

/**
 *
 * @author Commercial_2
 */
public class EduParametre  implements Serializable,Comparable<EduParametre>{
	
	
	private AnneScolaire anneeScolaire;
	
	private Etablissement etablissement;
	
	
	public EduParametre (){
		
	}


	public EduParametre(AnneScolaire anneeScolaire, Etablissement etablissement) {
		super();
		this.anneeScolaire = anneeScolaire;
		this.etablissement = etablissement;
	}


	public AnneScolaire getAnneeScolaire() {
		return anneeScolaire;
	}



	public void setAnneeScolaire(AnneScolaire anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}



	public Etablissement getEtablissement() {
		return etablissement;
	}



	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}



	public int compareTo(EduParametre o) {
		// TODO Auto-generated method stub
		return 0;
	}

    
    
}
