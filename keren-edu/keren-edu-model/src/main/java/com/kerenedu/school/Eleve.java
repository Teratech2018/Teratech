/**
 * 
 */
package com.kerenedu.school;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_eleve")
public class Eleve extends BaseElement implements Serializable, Comparable<Eleve> {

	@Column(name = "PHOTO" )	
	@Predicate(label = "PHOTO",target = "image"  , sequence=1)
	private String image ;
	  
	@Column(name = "MATRICULE")	
	@Predicate(label="Matricule",optional=true,updatable=false,search=true, sequence=4, colsequence=1, editable=false)
	protected String matricule;
	
	@Column(name = "DATENAIS")
	@Temporal(javax.persistence.TemporalType.DATE)
	@Predicate(label="Né(e) le.",optional=true,updatable=true,search=true, type=Date.class, target="date", sequence=7, colsequence=4)
	protected Date dateNais ;
	
	@Column(name = "L_NAIS")
	@Predicate(label="à",optional=true,updatable=true,search=true, sequence=8, colsequence=5)
	protected String lNais;
	
	@Column(name = "NOM")
	@Predicate(label="Nom",optional=false,updatable=true,search=true, sequence=3, colsequence=2)
	protected String nom;

	@Column(name = "EMAIL")
	//@Predicate(label="Email",optional=true,updatable=true,search=false , target="email", sequence=6)
	protected String email;
	
	@Column(name = "TEL")
//	@Predicate(label="TEL.",optional=true,updatable=true,search=false , sequence=9)
	protected String telephone;
	
	
	@Column(name = "PRENOM")
	@Predicate(label="Prenom",optional=false,updatable=true,search=true , sequence=5, colsequence=3)
	protected String prenon;
	
	@Column(name = "SEXE")
	@Predicate(label="Genre",optional=true,updatable=true,search=false, target="combobox", values="Masculin;Feminin" , sequence=11)
	protected String sexe="0";

	@Column(name = "SITFAMILIALE")
	//@Predicate(label="SITUATION FAMILIALE",optional=false,updatable=true,search=false, target="combobox", values="Celibataire;Marié(é)" , sequence=10)
	protected String sitFamiliale="0";
	
	@ManyToOne
    @JoinColumn(name = "NATIONALITE_ID")
	@Predicate(label="Nationalité",updatable=true,type=Nationalite.class , target="many-to-one",search=false, sequence=12)
    protected Nationalite nationalite;
	
	
	@Column(name = "TEL_PERE")
	@Predicate(label="WhatsApp/Tel Père",optional=true,updatable=true,search=false ,target="tel", group=true, groupLabel="Parents/Tuteur", groupName="tab1")
	protected String telPere;
	
	@Column(name = "EMAIL_PERE")
	@Predicate(label="Email Père",optional=true,updatable=true,search=false , target="email" , group=true, groupLabel="Parents/Tuteur", groupName="tab1")
	protected String emailPere;
	
	@Column(name = "TEL_MERE")
	@Predicate(label="WhatsApp/Tel Mère",optional=true,updatable=true,search=false ,target="tel", group=true, groupLabel="Parents/Tuteur", groupName="tab1")
	protected String telMere;
	
	
	@Column(name = "EMAIL_MERE")
	@Predicate(label="Email Mère",optional=true,updatable=true,search=false, group=true, groupLabel="Parents/Tuteur", groupName="tab1" )
	protected String emailMere;
	
	@Column(name = "TEL_TUTEUR")
	@Predicate(label="WhatsApp/Tel Tuteur",optional=true,updatable=true,search=false ,target="tel", group=true, groupLabel="Parents/Tuteur", groupName="tab1")
	protected String telTuteur;
	
	
	@Column(name = "EMAIL_TUTEUR")
	@Predicate(label="Email Tuteur",optional=true,updatable=true,search=false, group=true, groupLabel="Parents/Tuteur", groupName="tab1" )
	protected String emailTuteur;
	

	@ManyToOne
    @JoinColumn(name = "RESP_ID")
	@Predicate(label="Responsable de L'élève",updatable=true,type=Responsable.class , 
	target="many-to-one",group = true,groupName = "tab1",groupLabel = "Parents/Tuteur",optional=true)
    protected Responsable resp;
	
	@ManyToOne
    @JoinColumn(name = "NIVEAU_ID")
//	@Predicate(label="NIVEAU SCOLAIRE",updatable=true,type=NiveauScolaire.class , target="many-to-one",search=false,  group=true, groupLabel="Informations Genérales", groupName="tab2")
    protected NiveauScolaire niveauScolaire;
	
	@ManyToOne // eleve ,etudiant..
    @JoinColumn(name = "PREFESSION_ID")
	//@Predicate(label="PROFESSION",updatable=true,type=Profession.class , target="many-to-one",search=false,  group=true, groupLabel="Informations Genérales", groupName="tab2")
    protected Profession profession;
	
//	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
//    @JoinColumn(name = "DOSSIER_MEDICALE_ID")
//	@Predicate(label = "Dossier Médical",group = true,groupName = "tab3",groupLabel = "Dossier Médical",target = "one-to-many",type = DossierMedical.class,search = false)
//	private List<DossierMedical> dossierMedical = new ArrayList<DossierMedical>();
//	
	@Column(name = "ALLERTE_MEDICALE")
	@Predicate(label="Allergie ",optional=true,updatable=true,group = true,groupName = "tab3",groupLabel = "Dossier Médical")
	protected String allerte;

	@Column(name = "REFERENCE_HOPITAL")
	@Predicate(label="Hopital de Reférence",optional=true,updatable=true,group = true,groupName = "tab3",groupLabel = "Dossier Médical")
	protected String referenceHopital;
	
	@Column(name = "ADR_HOP")
	@Predicate(label=" Adresse Hopital",optional=true,updatable=true,group = true,groupName = "tab3",groupLabel = "Dossier Médical")
	protected String adressehop;
	
//	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
//    @JoinColumn(name ="CONTACTS_ID")
//	//@Predicate(label = "Contacts",group = true,groupName = "tab4",groupLabel = "Localisation",target = "one-to-many",type = Contacts.class,search = false)
//	private List<Contacts> contact = new ArrayList<Contacts>();
//	
	@Column(name = "QUARTIER")
	@Predicate(label="Quartier",optional=true,updatable=true,search=false,group = true,groupName = "tab4",groupLabel = "Localisation" )
	protected String quartier;
	
	@Column(name = "BLOC")
	@Predicate(label="Bolc/Rue",optional=true,updatable=true,search=false,group = true,groupName = "tab4",groupLabel = "Localisation" )
	protected String bloc;
		
	private boolean inscrit=false;
	
	
	
	  private String state ="initial";
	
	// ajout tab inscription 
	// ajout tab absence
	
	public Eleve() {
		
	}
	
	
	


	public Eleve(String image, String matricule, Date dateNais, String lNais, String nom, String email,
			String telephone, String prenon, String sexe, String sitFamiliale, Nationalite nationalite, String telPere,
			String emailPere, String telMere, String emailMere, String telTuteur, String emailTuteur,
			NiveauScolaire niveauScolaire, Profession profession, List<DossierMedical> dossierMedical,
			List<Contacts> contact, String quartier, String bloc, Responsable resp, String state) {
		super();
		this.image = image;
		this.matricule = matricule;
		this.dateNais = dateNais;
		this.lNais = lNais;
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.prenon = prenon;
		this.sexe = sexe;
		this.sitFamiliale = sitFamiliale;
		this.nationalite = nationalite;
		this.telPere = telPere;
		this.emailPere = emailPere;
		this.telMere = telMere;
		this.emailMere = emailMere;
		this.telTuteur = telTuteur;
		this.emailTuteur = emailTuteur;
		this.niveauScolaire = niveauScolaire;
		this.profession = profession;
		this.quartier = quartier;
		this.bloc = bloc;
		this.resp = resp;
		this.state = state;
	}





	public Eleve(Eleve eleve) {
		super(eleve.id, eleve.designation, eleve.moduleName,0L);
		this.image = eleve.image;
		this.matricule =eleve. matricule;
		this.dateNais = eleve.dateNais;
		this.lNais = eleve.lNais;
		this.nom = eleve.nom;
		this.email = eleve.email;
		this.prenon =eleve. prenon;
		this.sexe = eleve.sexe;
		this.sitFamiliale = eleve.sitFamiliale;
		this.telPere = eleve.telPere;
		this.emailPere = eleve.emailPere;
		this.telMere = eleve.telMere;
		this.emailMere = eleve.emailMere;
		if(eleve.nationalite!=null){
			this.nationalite = eleve.nationalite;
		}

		if(eleve.niveauScolaire!=null){
			this.niveauScolaire = eleve.niveauScolaire;
		}
		
		if(eleve.profession!=null){
			this.profession = eleve.profession;
		}
		
//		this.contact=new ArrayList<Contacts>();
		this.telephone= eleve.telephone;
		this.allerte=eleve.allerte;
		this.adressehop=eleve.adressehop;
		this.referenceHopital=eleve.referenceHopital;
		
		this.emailTuteur = eleve.emailTuteur;
		this.telTuteur=eleve.telTuteur;
		if(eleve.resp!=null){
		this.resp= eleve.resp;
		}
		this.quartier = eleve.quartier;
		this.bloc = eleve.bloc;
		if(eleve.resp!=null){
			this.resp = eleve.resp;
		}
		
		this.inscrit=eleve.inscrit;
		
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
		return "Gestion des Elèves";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Liste des Elèves";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return matricule+"-"+nom;
	}


	
	public String getMatricule() {
		return matricule;
	}



	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getlNais() {
		return lNais;
	}



	public void setlNais(String lNais) {
		this.lNais = lNais;
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



	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public void setNationalite(Nationalite nationalite) {
		this.nationalite = nationalite;
	}



	public NiveauScolaire getNiveauScolaire() {
		return niveauScolaire;
	}



	public void setNiveauScolaire(NiveauScolaire niveauScolaire) {
		this.niveauScolaire = niveauScolaire;
	}



	public Profession getProfession() {
		return profession;
	}



	public void setProfession(Profession profession) {
		this.profession = profession;
	}



	public String getEmailPere() {
		return emailPere;
	}



	public void setEmailPere(String emailPere) {
		this.emailPere = emailPere;
	}



	public String getTelPere() {
		return telPere;
	}



	public boolean isInscrit() {
		return inscrit;
	}





	public void setInscrit(boolean inscrit) {
		this.inscrit = inscrit;
	}





	public void setTelPere(String telPere) {
		this.telPere = telPere;
	}



	public String getEmailMere() {
		return emailMere;
	}



	public void setEmailMere(String emailMere) {
		this.emailMere = emailMere;
	}



	public String getTelMere() {
		return telMere;
	}



	public String getTelTuteur() {
		return telTuteur;
	}


	public void setTelTuteur(String telTuteur) {
		this.telTuteur = telTuteur;
	}


	public String getEmailTuteur() {
		return emailTuteur;
	}


	public void setEmailTuteur(String emailTuteur) {
		this.emailTuteur = emailTuteur;
	}


	public void setTelMere(String telMere) {
		this.telMere = telMere;
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

//	
//	public List<DossierMedical> getDossierMedical() {
//		return dossierMedical;
//	}
//
//	public void setDossierMedical(List<DossierMedical> dossierMedical) {
//		this.dossierMedical = dossierMedical;
//	}

//	public List<Contacts> getContact() {
//		return contact;
//	}


	public String getQuartier() {
		return quartier;
	}


	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}


	public String getBloc() {
		return bloc;
	}


	public void setBloc(String bloc) {
		this.bloc = bloc;
	}


	public Responsable getResp() {
		return resp;
	}


	public void setResp(Responsable resp) {
		this.resp = resp;
	}


//	public void setContact(List<Contacts> contact) {
//		this.contact = contact;
//	}
	

	public Date getDateNais() {
		return dateNais;
	}

	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.matricule);
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
		final Eleve other = (Eleve) obj;
		if (!Objects.equals(this.matricule, other.matricule)) {
			return false;
		}
		return true;
	}


	public int compareTo(Eleve o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}


	public String getAllerte() {
		return allerte;
	}





	public void setAllerte(String allerte) {
		this.allerte = allerte;
	}





	public String getReferenceHopital() {
		return referenceHopital;
	}





	public void setReferenceHopital(String referenceHopital) {
		this.referenceHopital = referenceHopital;
	}





	public String getAdressehop() {
		return adressehop;
	}





	public void setAdressehop(String adressehop) {
		this.adressehop = adressehop;
	}





	@Override
	public List<State> getStates() {
		  //To change body of generated methods, choose Tools | Templates.
        List<State> etats = new ArrayList<State>();
        State etat = new State("etabli", "Inscrit(e)");
        etats.add(etat);
        etat = new State("confirme", "Scolarité ok");
        etats.add(etat);
        return etats; 
	
	}
	

}
