/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.inscription.Inscription;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

//@Table
//@Entity(name = "e_plcours")
public class SelectClasse extends BaseElement implements Serializable, Comparable<SelectClasse> {

	private static final long serialVersionUID = -9044947840624123074L;

	@Column
	@Predicate(label="Matricule",optional=true , sequence=1)
	private String matricule;
	
	@Column
	@Predicate(label="Nom",optional=true , sequence=2)
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="CLASSE_ID")
	@Predicate(label=" Classe",type=Classe.class,target="many-to-one", sequence=3 )
	private Classe classe ;
	
	@ManyToOne
	@JoinColumn(name="INS_ID")
	private Inscription eleve ;



	public SelectClasse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SelectClasse(SelectClasse ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		this.classe =  new Classe(ins.classe);
		this.matricule= ins.matricule;
		this.nom=ins.nom;
		this.eleve=new Inscription();
		this.eleve.getEleve().setMatricule(matricule);
		this.eleve.getEleve().setNom(nom);
		
	
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(SelectClasse o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Rechercher un Elève ...";
	}

	@Override
	public String getListTitle() {
	 return " Rechercher un Elève ...";
	}

	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	@Override
	public String getModuleName() {
		return "kereneducation";
	}



	public Inscription getEleve() {
		return eleve;
	}


	public void setEleve(Inscription eleve) {
		this.eleve = eleve;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	@Override
	public String getDesignation() {
		return "";
	}




	public Classe getClasse() {
		return classe;
	}



	public void setClasse(Classe classe) {
		this.classe = classe;
	}



}
