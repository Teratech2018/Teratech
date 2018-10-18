/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

//@Table
//@Entity(name = "e_plcours")
public class RetardPaiementModal extends BaseElement implements Serializable, Comparable<RetardPaiementModal> {

	private static final long serialVersionUID = -9044947840624123074L;

	@Column
	@Predicate(label="Matricule",optional=true , sequence=1)
	private String matricule;
	
	@Column
	@Predicate(label="Nom",optional=true , sequence=2)
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="FICHE_ID")
	@Predicate(label="Services",type=FichePaiement.class,target="many-to-one", sequence=3, editable=true )
	private FichePaiement service ;
	


	public RetardPaiementModal() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RetardPaiementModal(RetardPaiementModal ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		this.service =  new FichePaiement(ins.service);
		this.matricule= ins.matricule;
		this.nom=ins.nom;
		
	
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(RetardPaiementModal o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Critère de Recherche...";
	}

	@Override
	public String getListTitle() {
	 return "Critère de Recherche ...";
	}

	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public FichePaiement getService() {
		return service;
	}


	public void setService(FichePaiement service) {
		this.service = service;
	}


	@Override
	public String getModuleName() {
		return "kereneducation";
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




}
