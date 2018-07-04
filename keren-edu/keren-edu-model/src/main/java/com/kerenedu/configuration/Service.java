/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_service")
public class Service extends BaseElement implements Serializable, Comparable<Service> {
	
	
	@Column(name = "TYPE_SERVICE")
	@Predicate(label="Type Service",optional=false,updatable=true,search=false, target="combobox", values="Inscription;Iere Tranche;IIeme Tranche;IIeme Tranche;Autres" , sequence=1)
	protected String type="0";
	
	@Column(name = "LIBELLE")	
	@Predicate(label="LIBELLE",optional=false,updatable=true,search=true, sequence=2)
	protected String libelle;
	
	@Column(name = "MNT" )	
	@Predicate(label="MONTANT",optional=false,updatable=true,search=true, type=Double.class, sequence=3)
	protected Double zMnt;
	
	@Column(name = "DELAI")
	@Predicate(label="DELAI PAIEMENT",optional=false,updatable=true,search=true, type=Date.class,sequence=4, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date delai;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "FILL_ID")
	@Predicate(label = ".",target = "many-to-many-list",type = Filiere.class,search = true,group=true,groupLabel="Filière concernés",
			groupName="tab1")
	private List<Filiere> filiere ;

	

	public Service() {
		
	}


	public Service(Service service) {
		super(service.id, service.designation, service.moduleName,0L);
		this.zMnt=service.zMnt;
		this.delai=service.delai;
		filiere= new ArrayList<Filiere>();
		this.libelle=service.libelle;
		this.type=service.getType();
		
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


	public List<Filiere> getFiliere() {
		return filiere;
	}


	public void setFiliere(List<Filiere> filiere) {
		this.filiere = filiere;
	}


	

}
