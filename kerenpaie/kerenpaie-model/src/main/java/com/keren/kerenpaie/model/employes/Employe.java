/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.kerenpaie.model.employes;

import com.core.base.BaseElement;
import com.keren.kerenpaie.model.comptabilite.Compte;
import com.keren.kerenpaie.model.comptabilite.CompteBancaire;
import com.keren.kerenpaie.model.paie.ProfilPaie;
import com.keren.kerenpaie.model.paie.Rubrique;
import com.keren.kerenpaie.model.structures.Departement;
import com.keren.kerenpaie.model.structures.Pays;
import com.keren.kerenpaie.model.structures.Region;
import com.keren.kerenpaie.model.structures.Societe;
import com.keren.kerenpaie.model.structures.Specialite;
import com.megatim.common.annotations.Predicate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_EMPLOY")
public class Employe extends BaseElement implements Serializable,Comparable<Employe>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 341452139435806032L;

	@Predicate(label="Photo",target="image")
	private String image;
	
	@Predicate(label="Handicapé(e)?",type=Boolean.class)
	private Boolean handicape = Boolean.FALSE;	
	
	
	@Predicate(label="Nom" ,search=true,optional=false,nullable=false)
	private String nom ;
	
	@Predicate(label="Matricule",search=true,optional=false,nullable=false,unique=true)
    private String matricule ;    
    
	@Predicate(label="Genre",target="combobox",values="Masculin;Feminin")
    private String genre ="0";
	
	@Predicate(label="Statut",type=String.class,target="combobox",values="Agent local;Agent public")
	private String statut ="0";
	
	@Predicate(label="N. Dipe")
	private String dipe;
	
	@ManyToOne
	@JoinColumn(name="CAT_ID")
	@Predicate(label="Catégories" ,type=Categorie.class,target="many-to-one")
	private Categorie categorie ;
	
	@ManyToOne
	@JoinColumn(name="ECH_ID")
	@Predicate(label="Echelon" ,type=Echelon.class,target="many-to-one")
	private Echelon echelon ;
	
	@Predicate(label="N. d'assurance social",group=true,groupName="group1",groupLabel="Informations Personelles")
	private String numsec ;
	
	@ManyToOne
	@JoinColumn(name="PAYS_ID")
	@Predicate(label="Nationalité",type=Pays.class,group=true,groupName="group1",groupLabel="Informations Personelles")
	private Pays nationalite ;
	
	@Predicate(label="N. contribuable",group=true,groupName="group1",groupLabel="Informations Personelles")
	private String contribuable ;
	
	@Predicate(label="N. CNI",group=true,groupName="group1",groupLabel="Informations Personelles")
	private String cni ;
	
	@Predicate(label="Date de délivrance",type=Date.class,target="date",group=true,groupName="group1",groupLabel="Informations Personelles")
	@Temporal(TemporalType.DATE)
	private Date datedelivrance ;
	
	@Predicate(label="Lieu de délivrance",group=true,groupName="group1",groupLabel="Informations Personelles")
	private String lieudelivrance ;
	
	@Predicate(label="Etat Civil",type=String.class,target="combobox",values="Célébataire;Marié;Veuf(ve);Divorcé(e)",group=true,groupName="group1",groupLabel="Informations Personelles")
	private String etatcivil="0" ;
	
	@Predicate(label="N. de passeport",group=true,groupName="group1",groupLabel="Informations Personelles")
	private String passeport ;
	
	@Predicate(label="Nombre d'enfants",type=Short.class,group=true,groupName="group1",groupLabel="Informations Personelles")
	private Short nbreenfants = 0 ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de naissance",type=Date.class,target="date",group=true,groupName="group1",groupLabel="Informations Personelles")
	private Date naissance ;
	
	@Predicate(label="Lieu de naissance",group=true,groupName="group1",groupLabel="Informations Personelles")
	private String lieudenaiss ;
	
	@Predicate(label="Adresse 1",group=true,groupName="group1",groupLabel="Informations Personelles")
	private String adresse1 ;
	
	@Predicate(label="Adresse 2",group=true,groupName="group1",groupLabel="Informations Personelles")
	private String adresse2 ;
	
	@Predicate(label="Téléphone",target="tel",group=true,groupName="group1",groupLabel="Informations Personelles")
	private String tel ;
	
	@Predicate(label="Portable",target="tel",group=true,groupName="group1",groupLabel="Informations Personelles")
	private String modile ;
	
	@Predicate(label="Adresse électronique",target="email",group=true,groupName="group1",groupLabel="Informations Personelles")
	private String mail ;
	
	@ManyToOne
	@JoinColumn(name="REG_ID")
	@Predicate(label="Région d'origine",type=Region.class,target="many-to-one",group=true,groupName="group1",groupLabel="Informations Personelles")
	private Region region ;
	
	@ManyToOne
	@JoinColumn(name="DEPSOC_ID")
	@Predicate(label="Département d'origine",type=DepartementSoc.class,target="many-to-one",group=true,groupName="group1",groupLabel="Informations Personelles")
	private DepartementSoc departementsoc ;
	
	@ManyToOne
	@JoinColumn(name="STRU_ID")	
	@Predicate(label="Structure",type=Societe.class,target="many-to-one",group=true,groupName="group2",groupLabel="Informations professionnelles")
	private Societe structure ;
	
	@ManyToOne
	@JoinColumn(name="POS_ID")
	@Predicate(label="Poste",type=Poste.class,target="many-to-one",group=true,groupName="group2",groupLabel="Informations professionnelles")
	private Poste poste  ;
	
	@ManyToOne
	@JoinColumn(name="DEP_ID")
	@Predicate(label="Département",type=Departement.class,target="many-to-one",group=true,groupName="group2",groupLabel="Informations professionnelles")
	private Departement departement ;
	
	@ManyToOne
	@JoinColumn(name="SPEC_ID")
	@Predicate(label="Spécialité",type=Specialite.class,target="many-to-one",group=true,groupName="group2",groupLabel="Informations professionnelles")
	private Specialite specialite ;
	
	@Predicate(label="Lieu d'affectation",group=true,groupName="group2",groupLabel="Informations professionnelles")
	private String lieuaffectation;
	
	@Predicate(label="Lieu de recrutement",group=true,groupName="group2",groupLabel="Informations professionnelles")
	private String lieurecrut;
	
	@ManyToOne
	@JoinColumn(name="FON_ID")
	@Predicate(label="Fonction",type=Fonction.class,target="many-to-one",group=true,groupName="group2",groupLabel="Informations professionnelles")
	private Fonction fonction;
	
	@Predicate(label="Numéro de compte bancaire",group=true,groupName="group3",groupLabel="Comptabilité")
	private String comptebancaire ;
	
	@ManyToOne
	@JoinColumn(name="PRPA_ID")
	@Predicate(label="Profi de paie",type=ProfilPaie.class,target="many-to-one",group=true,groupName="group3",groupLabel="Comptabilité")
	private ProfilPaie profilpaie ;
	
	@ManyToOne
	@JoinColumn(name="COM_ID")
	@Predicate(label="Compte salaire",type=Compte.class,target="many-to-one",group=true,groupName="group3",groupLabel="Comptabilité")
	private Compte compte ;
	
	@Predicate(label="Nombre de jours",type=Double.class,group=true,groupName="group3",groupLabel="Comptabilité")
	private Double nbrejours = 0.0;
	
//	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
//	@JoinColumn(name="EMP_ID")
//	@Predicate(label="Compte bancaires",group=true,groupName="group4",groupLabel="Banques",type=CompteBancaire.class,target="one-to-many")
//	private List<CompteBancaire> comptesbancaire = new ArrayList<CompteBancaire>();
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="EMP_ID")
	@Predicate(label="Familles",group=true,groupName="group5",groupLabel="Familles",type=Famille.class,target="one-to-many")
	private List<Famille> familles = new ArrayList<Famille>();
	
	@OneToMany(mappedBy="employe",fetch=FetchType.LAZY)
	@Predicate(label="Contrat de tarvail",type=ContratTravail.class,target="one-to-many",editable=false,updatable=false,group=true,groupName="group41",groupLabel="Contrats de Travail")
    private List<ContratTravail> contrats = new ArrayList<ContratTravail>();
    

	@Predicate(label="Employe syndiqué?",editable=false,updatable=false,type=Boolean.class,group=true,groupName="group40",groupLabel="Elements de salaire")
    private Boolean  syndique = Boolean.FALSE; 
	
	@Predicate(label="Employe affecté?",editable=false,updatable=false,type=Boolean.class,group=true,groupName="group40",groupLabel="Elements de salaire")
    private Boolean  affecte = Boolean.FALSE;
    
	
	@Predicate(label="Anciennité?",editable=false,updatable=false,type=Boolean.class,group=true,groupName="group40",groupLabel="Elements de salaire")
    private Double anciennite =0.0;
    
    @Column(name="TAUXSYN")
    @Predicate(label="Taux Syndical(%)",editable=false,updatable=false,type=Double.class,group=true,groupName="group40",groupLabel="Elements de salaire")
    private Double tauxsyndical =0.0;
    
    @Column(name="IDEMLOG")
    @Predicate(label="Indemnité de logement?",editable=false,updatable=false,type=Boolean.class,group=true,groupName="group40",groupLabel="Elements de salaire")
    private Double idemlogement = 0.0;
    
    @Column(name="RETCOM")
    @Predicate(label="Retraite complémentaire?",editable=false,updatable=false,type=Boolean.class,group=true,groupName="group40",groupLabel="Elements de salaire")
    private Double retraitcomplementaire = 0.0;
    
    @Column(name="ANGELE")
    @Predicate(label="Anciennité gélée?",editable=false,updatable=false,type=Double.class,group=true,groupName="group40",groupLabel="Elements de salaire")
    private Double anciennitegele = 0.0;
    
    @Predicate(label="Salaire de base négocié?",editable=false,updatable=false,type=Double.class,group=true,groupName="group40",groupLabel="Elements de salaire")
    private Double salbase = 0.0;
    
    @Predicate(label="Complément salaire?",editable=false,updatable=false,type=Double.class,group=true,groupName="group40",groupLabel="Elements de salaire")
    private Double cmplsalaire =0.0;
    
    @Predicate(label="Arbre de noel?",editable=false,updatable=false,type=Double.class,group=true,groupName="group40",groupLabel="Elements de salaire")
    private Double noel =0.0;
    
    @Predicate(label="Avantage Eau?",editable=false,updatable=false,type=Boolean.class,group=true,groupName="group40",groupLabel="Elements de salaire")
    private Boolean eau = Boolean.FALSE;
    
    @Predicate(label="Avantage Logement?",editable=false,updatable=false,type=Boolean.class,group=true,groupName="group40",groupLabel="Elements de salaire")
    private Boolean logement = Boolean.FALSE;
    
    @Predicate(label="Avantage Electricité?",editable=false,updatable=false,type=Boolean.class,group=true,groupName="group40",groupLabel="Elements de salaire")
    private Boolean electricite = Boolean.FALSE;
    
    @Predicate(label="Avantage Ménagères?",editable=false,updatable=false,type=Boolean.class,group=true,groupName="group40",groupLabel="Elements de salaire")
    private Boolean menagere = Boolean.FALSE;
    
    @Predicate(label="Avantage Vehicule?",editable=false,updatable=false,type=Boolean.class,group=true,groupName="group40",groupLabel="Elements de salaire")
    private Boolean vehicule = Boolean.FALSE; 
    
    @Predicate(label="Avantage Alimentaire?",editable=false,updatable=false,type=Boolean.class,group=true,groupName="group40",groupLabel="Elements de salaire")
    private Boolean alimentaire = Boolean.FALSE;
   
    @ManyToMany
    @JoinTable(name="T_EMRUP",joinColumns=@JoinColumn(name="EMPL_ID"),inverseJoinColumns=@JoinColumn(name="RUBR_ID"))
    @Predicate(label="Rubriques?",type=Rubrique.class,editable=false,updatable=false,target="many-to-many-list",group=true,groupName="group401",groupLabel="Rubriques Complémentaires")
    private List<Rubrique> rubriques = new ArrayList<Rubrique>();
    
    
    public Employe(String matricule, String nom, String prenom) {
        this.matricule = matricule;
        this.nom = nom;
       
    }

    public Employe(String matricule, String nom, String prenom, long id, String designation, String moduleName) {
        super(id, designation, moduleName);
        this.matricule = matricule;
        this.nom = nom;
        
    }

    public Employe() {
    }
    
    

    /**
     * 
     * @param employ
     */
    public Employe(Employe employ) {
		super(employ.id, employ.designation, employ.moduleName);
		this.image = employ.image;
		this.nom = employ.nom;
		this.matricule = employ.matricule;
		this.genre = employ.genre;
		this.statut = employ.statut;
		this.dipe = employ.dipe;
		this.handicape = employ.handicape;
		if(employ.categorie!=null){
			this.categorie = new Categorie(employ.categorie);
		}
		if(employ.echelon!=null){
			this.echelon = new Echelon(employ.echelon);
		}
		this.numsec = employ.numsec;
		if(employ.nationalite!=null){
			this.nationalite = employ.nationalite;
		}
		this.specialite = employ.specialite;
		this.affecte = employ.affecte;
		this.syndique = employ.syndique;
		this.anciennite = employ.anciennite;
		this.tauxsyndical = employ.tauxsyndical;
		this.idemlogement = employ.idemlogement;
		this.retraitcomplementaire = employ.retraitcomplementaire;
		this.anciennitegele = employ.anciennitegele;
		this.contribuable = employ.contribuable;
		this.cni = employ.cni;
		this.datedelivrance = employ.datedelivrance;
		this.lieudelivrance = employ.lieudelivrance;
		this.etatcivil = employ.etatcivil;
		this.passeport = employ.passeport;
		this.nbreenfants = employ.nbreenfants;
		this.naissance = employ.naissance;
		this.lieudenaiss = employ.lieudenaiss;
		this.adresse1 = employ.adresse1;
		this.adresse2 = employ.adresse2;
		this.tel = employ.tel;
		this.modile = employ.modile;
		this.mail = employ.mail;
		this.region = employ.region;
		this.eau = employ.eau;
		this.logement = employ.logement;
		this.electricite = employ.electricite;
		this.menagere = employ.menagere;
		this.vehicule = employ.vehicule;
		this.alimentaire = employ.alimentaire;
		this.noel = employ.noel;
		if(employ.departement!=null){
			this.departement = new Departement(employ.departement);
		}
		if(employ.departementsoc!=null){
			this.departementsoc = new DepartementSoc(employ.departementsoc);
		}
		this.lieuaffectation = employ.lieuaffectation;
		this.lieurecrut = employ.lieurecrut;
		if(employ.fonction!=null){
			this.fonction = new Fonction(employ.fonction);
		}
		if(employ.poste!=null){
			this.poste = new Poste(employ.poste);
		}
		if(employ.compte!=null){
			this.compte = new Compte(employ.compte);
		}
		if(employ.structure!=null){
			this.structure = new Societe(employ.structure);
		}
		this.nbrejours = employ.nbrejours;
        this.comptebancaire = employ.comptebancaire;
        if(employ.profilpaie!=null){
        	this.profilpaie = new ProfilPaie(employ.profilpaie);
        }
	}

	public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }    
    
    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getDipe() {
		return dipe;
	}

	public void setDipe(String dipe) {
		this.dipe = dipe;
	}

	public Boolean getHandicape() {
		return handicape;
	}

	public void setHandicape(Boolean handicape) {
		this.handicape = handicape;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Echelon getEchelon() {
		return echelon;
	}

	public void setEchelon(Echelon echelon) {
		this.echelon = echelon;
	}

	public String getNumsec() {
		return numsec;
	}

	public void setNumsec(String numsec) {
		this.numsec = numsec;
	}

	public Pays getNationalite() {
		return nationalite;
	}

	public void setNationalite(Pays nationalite) {
		this.nationalite = nationalite;
	}

	public String getContribuable() {
		return contribuable;
	}

	public void setContribuable(String contribuable) {
		this.contribuable = contribuable;
	}

	public String getCni() {
		return cni;
	}

	public void setCni(String cni) {
		this.cni = cni;
	}

	public Date getDatedelivrance() {
		return datedelivrance;
	}

	public void setDatedelivrance(Date datedelivrance) {
		this.datedelivrance = datedelivrance;
	}

	public String getLieudelivrance() {
		return lieudelivrance;
	}

	public void setLieudelivrance(String lieudelivrance) {
		this.lieudelivrance = lieudelivrance;
	}

	public String getEtatcivil() {
		return etatcivil;
	}

	public void setEtatcivil(String etatcivil) {
		this.etatcivil = etatcivil;
	}

	public String getPasseport() {
		return passeport;
	}

	public void setPasseport(String passeport) {
		this.passeport = passeport;
	}

	public Short getNbreenfants() {
		return nbreenfants;
	}

	public void setNbreenfants(Short nbreenfants) {
		this.nbreenfants = nbreenfants;
	}

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	public String getLieudenaiss() {
		return lieudenaiss;
	}

	public void setLieudenaiss(String lieudenaiss) {
		this.lieudenaiss = lieudenaiss;
	}

	public String getAdresse1() {
		return adresse1;
	}

	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}

	public String getAdresse2() {
		return adresse2;
	}

	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getModile() {
		return modile;
	}

	public void setModile(String modile) {
		this.modile = modile;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public DepartementSoc getDepartementsoc() {
		return departementsoc;
	}

	public void setDepartementsoc(DepartementSoc departementsoc) {
		this.departementsoc = departementsoc;
	}

	public String getLieuaffectation() {
		return lieuaffectation;
	}

	public void setLieuaffectation(String lieuaffectation) {
		this.lieuaffectation = lieuaffectation;
	}

	public String getLieurecrut() {
		return lieurecrut;
	}

	public void setLieurecrut(String lieurecrut) {
		this.lieurecrut = lieurecrut;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Double getNbrejours() {
		return nbrejours;
	}

	public void setNbrejours(Double nbrejours) {
		this.nbrejours = nbrejours;
	}
	
	

//	public List<CompteBancaire> getComptesbancaire() {
//		return comptesbancaire;
//	}
//
//	public void setComptesbancaire(List<CompteBancaire> comptesbancaire) {
//		this.comptesbancaire = comptesbancaire;
//	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public Double getNoel() {
		return noel;
	}

	public void setNoel(Double noel) {
		this.noel = noel;
	}

	public Boolean getAffecte() {
		return affecte;
	}

	public void setAffecte(Boolean affecte) {
		this.affecte = affecte;
	}

	public Boolean getSyndique() {
		return syndique;
	}

	public void setSyndique(Boolean syndique) {
		this.syndique = syndique;
	}

	public Double getAnciennite() {
		return anciennite;
	}

	public void setAnciennite(Double anciennite) {
		this.anciennite = anciennite;
	}

	public Double getTauxsyndical() {
		return tauxsyndical;
	}

	public void setTauxsyndical(Double tauxsyndical) {
		this.tauxsyndical = tauxsyndical;
	}

	public Double getIdemlogement() {
		return idemlogement;
	}

	public void setIdemlogement(Double idemlogement) {
		this.idemlogement = idemlogement;
	}

	public Double getRetraitcomplementaire() {
		return retraitcomplementaire;
	}

	public void setRetraitcomplementaire(Double retraitcomplementaire) {
		this.retraitcomplementaire = retraitcomplementaire;
	}

	public Double getAnciennitegele() {
		return anciennitegele;
	}

	public void setAnciennitegele(Double anciennitegele) {
		this.anciennitegele = anciennitegele;
	}

	public List<ContratTravail> getContrats() {
		return contrats;
	}

	public void setContrats(List<ContratTravail> contrats) {
		this.contrats = contrats;
	}

	public List<Famille> getFamilles() {
		return familles;
	}

	public void setFamilles(List<Famille> familles) {
		this.familles = familles;
	}
	
	

	public Societe getStructure() {
		return structure;
	}

	public void setStructure(Societe structure) {
		this.structure = structure;
	}
	
	

	public Double getSalbase() {
		return salbase;
	}

	public void setSalbase(Double salbase) {
		this.salbase = salbase;
	}

	public Double getCmplsalaire() {
		return cmplsalaire;
	}

	public void setCmplsalaire(Double cmplsalaire) {
		this.cmplsalaire = cmplsalaire;
	}

	public Boolean getEau() {
		return eau;
	}

	public void setEau(Boolean eau) {
		this.eau = eau;
	}

	public Boolean getLogement() {
		return logement;
	}

	public void setLogement(Boolean logement) {
		this.logement = logement;
	}

	public Boolean getElectricite() {
		return electricite;
	}

	public void setElectricite(Boolean electricite) {
		this.electricite = electricite;
	}

	public Boolean getMenagere() {
		return menagere;
	}

	public void setMenagere(Boolean menagere) {
		this.menagere = menagere;
	}

	public Boolean getVehicule() {
		return vehicule;
	}

	public void setVehicule(Boolean vehicule) {
		this.vehicule = vehicule;
	}

	public Boolean getAlimentaire() {
		return alimentaire;
	}

	public void setAlimentaire(Boolean alimentaire) {
		this.alimentaire = alimentaire;
	}

	public List<Rubrique> getRubriques() {
		return rubriques;
	}

	public void setRubriques(List<Rubrique> rubriques) {
		this.rubriques = rubriques;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "EMPLOYE";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "EMPLOYES";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}
	
	

	@Override
	public String getSerial() {
		// TODO Auto-generated method stub
		return Long.toString(serialVersionUID);
	}

	@Override
	public boolean isActivefilelien() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return matricule+" - "+nom;
	}
	
	

	public String getComptebancaire() {
		return comptebancaire;
	}

	public void setComptebancaire(String comptebancaire) {
		this.comptebancaire = comptebancaire;
	}

	public ProfilPaie getProfilpaie() {
		return profilpaie;
	}

	public void setProfilpaie(ProfilPaie profilpaie) {
		this.profilpaie = profilpaie;
	}

	@Override
    public int compareTo(Employe o) {
        //To change body of generated methods, choose Tools | Templates.
        return matricule.compareTo(o.matricule);
    }
    
}
