/**
 * 
 */
package com.kerenedu.personnel;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.kerenedu.school.Contacts;
import com.kerenedu.school.DossierMedical;
import com.kerenedu.school.Nationalite;
import com.kerenedu.school.NiveauScolaire;
import com.kerenedu.school.Profession;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_professeur")
public class Professeur extends BaseElement implements Serializable, Comparable<Professeur> {

	@Column(name = "PHOTO" )	
	@Predicate(label = "PHOTO",target = "image"  , sequence=1)
	private String image ;
	 
	
	@Column(name = "NOM")
	@Predicate(label="NOM",optional=false,updatable=true,search=true, sequence=4, colsequence=2)
	protected String nom;
	
	@Column(name = "PRENOM")
	@Predicate(label="PRENOM",optional=false,updatable=true,search=true , sequence=3, colsequence=3)
	protected String prenon;
	
	@Column(name = "DATENAIS")
	@Temporal(javax.persistence.TemporalType.DATE)
	@Predicate(label="DATE NAISS.",optional=false,updatable=true,search=true, type=Date.class, target="date", sequence=5, colsequence=4)
	protected Date dateNais ;

	@Column(name = "EMAIL")
	@Predicate(label="EMAIL",optional=true,updatable=true,search=false , target="email", sequence=6)
	protected String email;
		
	@Column(name = "SEXE")
	@Predicate(label="SEXE",optional=false,updatable=true,search=false, target="combobox", values="Masculin;Feminin" , sequence=7)
	protected String sexe="0";

	@Column(name = "SITFAMILIALE")
	@Predicate(label="SITUATION FAMILIALE",optional=false,updatable=true,search=false, target="combobox", values="Celibataire;Marié(é)" , sequence=8)
	protected String sitFamiliale="0";
	
	@Column(name = "DIPLOME")
	@Predicate(label="DERNIER DIPLOME",optional=false,updatable=true,search=false , sequence=9, colsequence=3)
	protected String diplome;
	
	@ManyToOne
    @JoinColumn(name = "NATIONALITE_ID")
	@Predicate(label="NATIONALITE",updatable=true,type=Nationalite.class , target="many-to-one",search=false, sequence=10, optional=false)
    protected Nationalite nationalite;
	
	@Column(name ="TELEPHONE")
	@Predicate(label = "TELEPHONE",type = String.class,search = false, sequence=11)
	private String contact ;
	
	
	// ajout tab inscription 
	// ajout tab absence
	
	public Professeur() {
		super();
		
	}
	
	
	public Professeur(String image, String matricule, Date dateNais, String lNais, String nom, String email, String prenon,
			String sexe, String sitFamiliale, String telPere, String emailPere, String telMere, String emailMere,
			Nationalite nationalite, String diplome,String contact) {
		super();
		this.image = image;
		this.dateNais = dateNais;
		this.nom = nom;
		this.email = email;
		this.prenon = prenon;
		this.sexe = sexe;
		this.sitFamiliale = sitFamiliale;
		this.nationalite = nationalite;
		this.contact=contact;
		this.diplome=diplome ;
	}


	public Professeur(Professeur eleve) {
		super(eleve.id, eleve.designation, eleve.moduleName);
		this.image = eleve.image;
		this.dateNais = eleve.dateNais;
		this.nom = eleve.nom;
		this.email = eleve.email;
		this.prenon =eleve. prenon;
		this.sexe = eleve.sexe;
		this.sitFamiliale = eleve.sitFamiliale;
		this.nationalite = new Nationalite(eleve.nationalite) ;
		this.contact=eleve.contact;
		this.diplome=eleve.diplome;
		
		/*for(DossierMedical dos:eleve.dossierMedical){
			dossierMedical.add(new DossierMedical(dos));
	    }
		
		for(Contacts con:eleve.contact){
			contact.add(new Contacts(con));
	    }*/
		//this.dossierMedical = dossierMedical;
		//Tthis.contact = contact;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Edition des Professeurs";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Professeurs";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return nom;
	}

	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenon() {
		return prenon;
	}



	public void setPrenon(String prenon) {
		this.prenon = prenon;
	}



	public String getSexe() {
		return sexe;
	}



	public void setSexe(String sexe) {
		this.sexe = sexe;
	}



	public Nationalite getNationalite() {
		return nationalite;
	}



	public void setNationalite(Nationalite nationalite) {
		this.nationalite = nationalite;
	}


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

//	public Date getDateNais() {
//		return dateNais;
//	}
//
//	public void setDateNais(Date dateNais) {
//		this.dateNais = dateNais;
//	}

	public String getSitFamiliale() {
		return sitFamiliale;
	}

	public void setSitFamiliale(String sitFamiliale) {
		this.sitFamiliale = sitFamiliale;
	}

	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}
	

	public Date getDateNais() {
		return dateNais;
	}

	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}

	public String getDiplome() {
		return diplome;
	}


	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}


	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
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
		final Professeur other = (Professeur) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isCreateonfield() {
		return false;
	}


	public int compareTo(Professeur o) {
		// TODO Auto-generated method stub
		return 0;
	}


}
