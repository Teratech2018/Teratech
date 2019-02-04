/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.configuration.Service;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 */

//@Entity
//@Table(name = "e_zview_bf")
public class ViewCouponsInformation extends BaseElement implements Serializable, Comparable<ViewCouponsInformation> {

	
	@Column(name = "TYPE_SERVICE", unique=true)
	//@Predicate(label="Type Service",optional=false,updatable=false,search=false, target="combobox", values="Inscription;1ere Tranche;2eme Tranche;3eme Tranche;Autres" , sequence=2, observable=true)
	protected String type="0";
	@ManyToOne
	@JoinColumn(name = "SERVICE_ID")
	@Predicate(label="Type Service",type=Service.class , target="many-to-one",search=true , sequence=1, optional=false)
	protected Service service ;
	
	@Column(name = "STATUT", unique=true)
	//@Predicate(label="Statut",optional=false,updatable=false,search=false, target="combobox", values="Solvables;Non Solvables" , sequence=2, observable=true)
	protected String statut="0";
	
	@Transient
	@ManyToOne
	@JoinColumn(name = "FILIERE_ID")
	@Predicate(label="Filiere",type=Filiere.class , target="many-to-one",search=true , sequence=3, optional=true)
//	@Filter(value="[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"id\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	protected Filiere filiere ;
	
	@Transient
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	//@Predicate(label="Classe",type=Classe.class , target="many-to-one",search=true , sequence=3, optional=false)
//	@Filter(value="[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"id\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	protected Classe classe ;
	
	
	
	public ViewCouponsInformation() {
		// TODO Auto-generated constructor stub
	}





	public ViewCouponsInformation(String type, Classe classe) {
		super();
		this.type = type;
		this.classe = classe;
		
	}





	public ViewCouponsInformation(ViewCouponsInformation ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		
		if(ins.classe!=null){
			this.classe = new Classe(ins.classe);
		}
		if(ins.filiere!=null){
			this.filiere = new Filiere(ins.filiere);
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

	public int compareTo(ViewCouponsInformation o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Notification retard de paiement";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Notification retard de paiement";
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





	public Filiere getFiliere() {
		return filiere;
	}





	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}





	public Service getService() {
		return service;
	}





	public void setService(Service service) {
		this.service = service;
	}


	


}
