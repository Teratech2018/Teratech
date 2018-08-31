/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_service")
public class Service extends BaseElement implements Serializable, Comparable<Service> {
	
	
	@Column(name = "CODE", unique=true)	
	@Predicate(label="CODE",optional=false,updatable=true,search=true, sequence=1)
	protected String libelle;
	
	
	@Column(name = "TYPE_SERVICE", unique=true)
	@Predicate(label="Type Service",optional=false,updatable=false,search=false, target="combobox", values="Inscription;1ere Tranche;2eme Tranche;3eme Tranche;autres" , sequence=2, observable=true)
	protected String type="0";
	
	@Column(name = "MNT" )	
	@Predicate(label="MONTANT",optional=true,updatable=true,search=true, type=Double.class, sequence=3, editable=false)
	protected Double zMnt;
	
	@Column(name = "DELAI")
	@Predicate(label="DELAI PAIEMENT",optional=false,updatable=true,search=true, type=Date.class,sequence=4, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date delai;
	
	@Predicate(label = "Optionnel ?", type = Boolean.class)
	private Boolean exige = Boolean.FALSE;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "SERVICE_ID")
	@Predicate(label = ".",target = "one-to-many",type = ServiceFilliere.class,search = true,group=true,groupLabel="Filière",
			groupName="tab1", edittable=true)
	@Observer(observable="type",source="method:findfiliere",parameters="type")
	private List<ServiceFilliere> filiere ;
	
	private int rang ;
	
	@Predicate(label = "Elligible Remise ?", type = Boolean.class)
	private Boolean elligible = Boolean.FALSE;

	

	public Service() {
		
	}


	public Service(Service service) {
		super(service.id, service.designation, service.moduleName,0L);
		this.zMnt=service.zMnt;
		this.delai=service.delai;
		filiere= new ArrayList<ServiceFilliere>();
		this.libelle=service.libelle;
		this.type=service.getType();
		this.exige= service.getExige();
		this.rang=service.rang;
		this.elligible=service.getElligible();
		
	}

			

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(Service o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Services Scolaire";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Services Scolaire";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}
	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return libelle;
	}
	

	public Double getzMnt() {

		return zMnt;
	}


	public void setzMnt(Double zMnt) {
		this.zMnt = zMnt;
	}




	public Date getDelai() {
		return delai;
	}


	public void setDelai(Date delai) {
		this.delai = delai;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public List<ServiceFilliere> getFiliere() {
		return filiere;
	}


	public Boolean getElligible() {
		return elligible;
	}


	public void setElligible(Boolean elligible) {
		this.elligible = elligible;
	}


	public Boolean getExige() {
		return exige;
	}


	public void setExige(Boolean exige) {
		this.exige = exige;
	}


	public void setFiliere(List<ServiceFilliere> filiere) {
		this.filiere = filiere;
	}


	public int getRang() {
		return rang;
	}


	public void setRang(int rang) {
		this.rang = rang;
	}


	@Override
	public boolean isDesabledelete() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isDesableupdate() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
