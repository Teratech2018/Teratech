/**
 * 
 */
package com.kerenedu.school;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_resp")
public class Responsable extends BaseElement implements Serializable, Comparable<Responsable> {

	@Column(name = "RESPONSABLE")
	@Predicate(label="Responsable",optional=false,updatable=true,search=false, target="combobox", values="Parents;Personnels" )
	protected String responsable="0";
	
	@Column(name = "NOM", unique = true)
	@Predicate(label="Nom & Prenom",optional=true,updatable=false,search=true, hidden ="temporalData.responsable=='1'")
	protected String nom;
	
	@Column(name = "SEXE")
	@Predicate(label="Genre",optional=true,updatable=true,search=false, target="combobox", values="Masculin;Feminin", hidden ="temporalData.responsable=='1'" )
	protected String sexe="0";

	@Column(name = "TEL")
	@Predicate(label="WhatsApp/Teléphone",optional=true,updatable=false,search=true, hidden ="temporalData.responsable=='1'")
	protected String tel;
	
	@Column(name = "EMAIL")
	@Predicate(label="Email",optional=true,updatable=false,search=true, hidden ="temporalData.responsable=='1'")
	protected String email;
	
	@Column(name = "DATENAIS")
	@Temporal(javax.persistence.TemporalType.DATE)
	@Predicate(label="Né(e) le.",optional=true,updatable=true,search=true, type=Date.class, target="date", hidden ="temporalData.responsable=='1'")
	protected Date dateNais ;
	
	@ManyToOne
	@JoinColumn(name = "PERS_ID")
	@Predicate(label = "Personnel", type = Professeur.class, target = "many-to-one", optional = true, hidden ="temporalData.responsable=='0'")
	private Professeur personnel;
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



	public Responsable(Responsable entity) {
		super(entity.id, entity.designation, entity.moduleName,0L);
		this.responsable=entity.responsable;
		this.ne = entity.ne;
		if(entity.personnel!=null){
			this.personnel=new Professeur(entity.personnel);
			this.nom = entity.getPersonnel().getNom();
			this.tel = entity.getPersonnel().getContact();
			this.email = entity.getPersonnel().getEmail();
			this.dateNais = entity.getPersonnel().getDateNais();
			this.sexe= entity.getPersonnel().getSexe();
		}else{
			this.nom = entity.nom;
			this.tel = entity.tel;
			this.email = entity.email;
			this.dateNais = entity.dateNais;
			this.ne = entity.ne;
			this.sexe= entity.sexe;
		}
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



	public String getResponsable() {
		return responsable;
	}



	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}



	public Professeur getPersonnel() {
		return personnel;
	}



	public void setPersonnel(Professeur personnel) {
		this.personnel = personnel;
	}



	public void setSexe(String sexe) {
		this.sexe = sexe;
	}



	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return nom ;
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
