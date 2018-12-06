/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.reglement.FichePaiement;

/**
 * @author ntchuente
 */

@Table
@Entity(name = "e_zview_eleve")
public class ViewBilanServiceEleve extends BaseElement implements Serializable, Comparable<ViewBilanServiceEleve> {

	@ManyToOne
	@JoinColumn(name = "FICHE_ID")
	protected  FichePaiement fiche ;
	
	@ManyToOne
	@JoinColumn(name = "INS_ID")
	protected Inscription eleve ;
	
	@Transient
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "FICHE_PAIE_ID")
	protected List<FichePaiement> serviceimpayes;
	
	
	
	
	
	public ViewBilanServiceEleve() {
		// TODO Auto-generated constructor stub
	}


	public ViewBilanServiceEleve(ViewBilanServiceEleve ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		if(ins.eleve!=null){
			this.eleve = new Inscription(ins.eleve);
		}
		if(ins.fiche!=null){
			this.fiche = new FichePaiement(ins.fiche);
		}
		this.serviceimpayes= new ArrayList<FichePaiement>();
	
		
			
	}
	



	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(ViewBilanServiceEleve o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Bilan Financiers";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Bilan Financiers";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "";
	}


	//
	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isDesablecreate() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isDesableupdate() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isDesabledelete() {
		// TODO Auto-generated method stub
		return true;
	}


	public FichePaiement getFiche() {
		return fiche;
	}


	public void setFiche(FichePaiement fiche) {
		this.fiche = fiche;
	}


	public Inscription getEleve() {
		return eleve;
	}


	public List<FichePaiement> getServiceimpayes() {
		return serviceimpayes;
	}


	public void setServiceimpayes(List<FichePaiement> serviceimpayes) {
		this.serviceimpayes = serviceimpayes;
	}


	public void setEleve(Inscription eleve) {
		this.eleve = eleve;
	}


}
