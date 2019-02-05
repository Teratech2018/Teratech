/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Cycle;
import com.kerenedu.configuration.SectionE;
import com.kerenedu.configuration.Service;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 */

//@Entity
//@Table(name = "e_zview_bf")
public class ViewBilanServiceModal extends BaseElement implements Serializable, Comparable<ViewBilanServiceModal> {

	
	@Column(name = "TYPE_SERVICE", unique=true)
	//@Predicate(label="Type Service",optional=false,updatable=false,search=false, target="combobox", values="Inscription;1ere Tranche;2eme Tranche;3eme Tranche;Autres" , sequence=2, observable=true)
	protected String type="0";
	@ManyToOne
	@JoinColumn(name = "SERVICE_ID")
	@Predicate(label="Type Service",type=Service.class , target="many-to-one",search=true , sequence=1, optional=false)
	protected Service service ;
	
	@Column(name = "STATUT")
	@Predicate(label="Statut",optional=false,updatable=false,search=false, target="combobox", values="Solvables;Non Solvables;Tous" , sequence=2, observable=true)
	protected String statut="0";
	
	
	
	@Transient
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="Classe",type=Classe.class , target="many-to-one",search=true , sequence=3)
//	@Filter(value="[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"id\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	protected Classe classe ;
	
	
	
	public ViewBilanServiceModal() {
		// TODO Auto-generated constructor stub
	}





	public ViewBilanServiceModal(String type, Classe classe) {
		super();
		this.type = type;
		this.classe = classe;
		
	}





	public ViewBilanServiceModal(ViewBilanServiceModal ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		
		if(ins.classe!=null){
			this.classe = new Classe(ins.classe);
		}
		this.type=ins.type;
		this.statut=ins.statut;
		if(ins.service!=null){
			this.service = new Service(ins.service);
		}
		
		
	}
	

	


	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}



	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(ViewBilanServiceModal o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Bilan Financier par Service";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Bilan Financier : Selectionnez une Classe";
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



	public String getType() {
		return type;
	}



	public String getStatut() {
		return statut;
	}





	public void setStatut(String statut) {
		this.statut = statut;
	}





	public void setType(String type) {
		this.type = type;
	}





	public Service getService() {
		return service;
	}





	public void setService(Service service) {
		this.service = service;
	}


	


}
