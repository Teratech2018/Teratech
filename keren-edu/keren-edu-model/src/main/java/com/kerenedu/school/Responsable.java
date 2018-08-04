/**
 * 
 */
package com.kerenedu.school;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_resp")
public class Responsable extends BaseElement implements Serializable, Comparable<Responsable> {

	@Column(name = "NOM", unique = true)
	@Predicate(label="Nom & Prenom",optional=false,updatable=false,search=true)
	protected String nom;
	
	@Column(name = "SEXE")
	@Predicate(label="Genre",optional=false,updatable=true,search=false, target="combobox", values="Masculin;Feminin" )
	protected String sexe="0";

	@Column(name = "TEL")
	@Predicate(label="WhatsApp/Teléphone",optional=false,updatable=false,search=true)
	protected String tel;
	
	@Column(name = "EMAIL")
	@Predicate(label="Email",optional=false,updatable=false,search=true)
	protected String email;
	
	@Column(name = "DATENAIS")
	@Temporal(javax.persistence.TemporalType.DATE)
	@Predicate(label="Né(e) le.",optional=false,updatable=true,search=true, type=Date.class, target="date")
	protected Date dateNais ;
	
	@Column(name = "NE")
	//@Predicate(label="Nombre d'enfant",optional=false,updatable=false,search=true, type=Short.class)
	protected Short ne;
	
	public Responsable() {
		super();

	}

	

	public Responsable(String nom, String tel, String email, Date dateNais, Short ne, String sexe) {
		super();
		this.nom = nom;
		this.tel = tel;
		this.email = email;
		this.dateNais = dateNais;
		this.ne = ne;
		this.sexe=sexe;
	}



	public Responsable(Responsable nationalite) {
		super(nationalite.id, nationalite.designation, nationalite.moduleName,0L);
		this.nom = nationalite.nom;
		this.tel = nationalite.tel;
		this.email = nationalite.email;
		this.dateNais = nationalite.dateNais;
		this.ne = nationalite.ne;
		this.sexe= nationalite.sexe;
	}

	

	
	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getDateNais() {
		return dateNais;
	}



	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}



	public Short getNe() {
		return ne;
	}



	public void setNe(Short ne) {
		this.ne = ne;
	}



	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Responsable de l'élève";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Liste des Responsables";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	public String getSexe() {
		return sexe;
	}



	public void setSexe(String sexe) {
		this.sexe = sexe;
	}



	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return toString();
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.nom);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Responsable other = (Responsable) obj;
		if (!Objects.equals(this.nom, other.nom)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nom ;
	}

	public int compareTo(Responsable o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
