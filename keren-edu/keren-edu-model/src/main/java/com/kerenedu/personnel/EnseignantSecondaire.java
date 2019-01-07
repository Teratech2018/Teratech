package com.kerenedu.personnel;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Etablissement;
import com.kerenedu.solde.Banque;
import com.kerenedu.solde.Categorie;
import com.kerenedu.solde.Echellon;
import com.kerenedu.solde.Fonction;
import com.kerenedu.solde.ProfilPaie;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;







@Entity
@Table(name="e_professeur")
public class EnseignantSecondaire
  extends BaseElement
  implements Serializable, Comparable<EnseignantSecondaire>
{
  @Column(name="DISC")
  private String discriminant = "ES";
  
	@Column(name = "MAT", unique = true)
	@Predicate(label = "Matricule", optional = true, updatable = true, search = true, sequence = 3,editable=false)
	protected String matricule;

	
	@Column(name = "PHOTO")
	@Predicate(label = "PHOTO", target = "image", sequence = 1)
	private String image;

	@Column(name = "NOM", unique = true)
	@Predicate(label = "NOM", optional = false, updatable = true, search = true, sequence = 2)
	protected String nom;

	@Column(name = "STATUS_ID")
	@Predicate(label = "Type Contrat", optional = true, updatable = true, search = true, target = "combobox", values = "Vacataire;Permanent(e)", sequence = 4)
	protected String status;
	
	@Column(name = "SEXE")
	@Predicate(label = "SEXE", optional = false, updatable = true, search = false, target = "combobox", values = "Masculin;Feminin", sequence = 5)
	protected String sexe = "0";
	
	@Column(name = "D_EMB")
	@Temporal(javax.persistence.TemporalType.DATE)
	@Predicate(label = "Date Embauche.", optional = true, updatable = true, search = true, type = Date.class, target = "date", sequence = 6)
	protected Date dateembauche;
	
	
	@ManyToOne
	@JoinColumn(name = "FON_ID")
	@Predicate(label = "Fonction", updatable = true, type = Fonction.class, target = "many-to-one", search = true,  optional = true, sequence = 7
			,group = true, groupLabel = "Informations Personelles", groupName = "tab1")
	protected Fonction role;
	

	@ManyToOne
	@JoinColumn(name = "STRU_ID")
//	@Predicate(label = "Structure", type = Etablissement.class, target = "many-to-one", sequence=8, editable=false)
	private Etablissement structure;


	@Column(name = "PRENOM")
	// @Predicate(label="PRENOM",optional=true,updatable=true,search=true ,
	// sequence=3)
	protected String prenon;

	@Column(name = "DATENAIS")
	@Temporal(javax.persistence.TemporalType.DATE)
	@Predicate(label = "DATE NAISS.", optional = true, updatable = true, search = false, type = Date.class, target = "date",
			group = true, groupLabel = "Information Personelles", groupName = "tab1")
	protected Date dateNais;
	
	@Column(name = "LNAIS")
	@Predicate(label = "Lieu de Naissance", optional = true, updatable = true, search = false, target = "email",group = true, groupLabel = "Information Personelles", groupName = "tab1")
	protected String lnais ;
	
	@Column(name = "TELEPHONE")
	@Predicate(label = "TELEPHONE", type = String.class, search = false, sequence = 11, pattern = "[0-9]",group = true, groupLabel = "Information Personelles", groupName = "tab1")
	private String contact;

	@Column(name = "EMAIL")
	@Predicate(label = "EMAIL", optional = true, updatable = true, search = false, target = "email",group = true, groupLabel = "Information Personelles", groupName = "tab1")
	protected String email;
	
	@Column(name = "NE")
	@Predicate(label = "Nombre d'enfants", type = Long.class, search = false, sequence = 11, pattern = "[0-9]", group = true, groupLabel = "Information Personelles", groupName = "tab1")
	private Long nefts = new Long(0);

	@ManyToOne
	@JoinColumn(name = "DIP_ID")
	@Predicate(label = "DIPLOME", updatable = true, type = Diplome.class, target = "many-to-one", search = false, optional = true
			,group = true, groupLabel = "Informations Personelles", groupName = "tab1")
	protected Diplome diplome;

	@Column(name = "T_CIVI")
	@Predicate(label = "Etat Civil", search = false, target = "combobox", values = "Marie(é);Celibataire ; Divorcé;Veuf(ve)", optional = true
			,group = true, groupLabel = "Informations Personelles", groupName = "tab1")
	private String etatcivile = "0";
	
	@ManyToOne
	@JoinColumn(name = "CAT_ID")
	@Predicate(label = "Catégorie", updatable = true, type = Categorie.class, target = "many-to-one", search = true, optional = true
			,group = true, groupLabel = "Informations Professionnelles", groupName = "tab2")
	protected Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name = "ECH_ID")
	@Predicate(label = "Echélon", updatable = true, type = Echellon.class, target = "many-to-one", search = false, optional = true
			,group = true, groupLabel = "Informations Professionnelles", groupName = "tab2")
	protected Echellon echelon;
	
	@Column(name = "LIEU")
	@Predicate(label = "Lieu de Recrutement", optional = true, updatable = true, search = false,group = true, groupLabel = "Informations Professionnelles", groupName = "tab2")
	protected String lieu;

	@Predicate(label = "Curriculum Vitae", target = "file", group = true, groupName = "tab2", groupLabel = "Informations professionnelles")
	private String cv;
	
	@Column(name = "NAT_PAI")
	@Predicate(label = "Mode Paiement", optional = true, updatable = true, search = true, target = "combobox", values = "Espèces;Virements", sequence =8, observable = true,
			group = true, groupLabel = "Comptabilité", groupName = "tab3")
	protected String modePaiement = "0";
	
	@ManyToOne
	@JoinColumn(name = "BAN_ID")
	@Predicate(label = "Banque", updatable = true, type = Banque.class, target = "many-to-one", search = false, optional = true
			,group = true, groupLabel = "Comptabilité", groupName = "tab3", hidden="currentObject.modePaiement!==1")
	protected Banque banque;
	
	@Column(name = "NUM_BAN")
	@Predicate(label = "Numéro Bancaire", type = Long.class, search = false, sequence = 11, pattern = "[0-9]", group = true, groupLabel = "Comptabilité", groupName = "tab3"
			,hidden="currentObject.modePaiement!==1")
	private Long numBanque = new Long(0);
	
	@ManyToOne
	@JoinColumn(name = "PROF_ID")
	@Predicate(label = "Profil Paie", updatable = true, type = ProfilPaie.class, target = "many-to-one", search = false, optional = true
			,group = true, groupLabel = "Comptabilité", groupName = "tab2")
	protected ProfilPaie profil;

	@Column(name = "NB_JOURS")
	@Predicate(label = "Nombre de Jours", type = Long.class, search = false, sequence = 11, pattern = "[0-9]", group = true, groupLabel = "Comptabilité", groupName = "tab3")
	private Long njours = new Long(0);
	
	
	@Column(name = "SAL")
	@Predicate(label = "SALAIRE", type = Long.class, search = false, sequence = 11, pattern = "[0-9]", group = true, groupLabel = "Comptabilité ", groupName = "tab3")
	private Long salaire = new Long(0);

	@Column(name = "Tx_H")
	@Predicate(label = "TAUX HORAIRE", type = Long.class, search = false, sequence = 11, pattern = "[0-9]", group = true, groupLabel = "Comptabilité", groupName = "tab3")
	private Long thoraire = new Long(0);


	@Column(name = "APAYER")
	//@Predicate(label = "Salaire Global", updatable = false, search = true, type = Long.class, sequence = 4, editable = false)
	protected Long salmax;

	@Column(name = "PAYER")
	// @Predicate(label="Perçu",updatable=false,search=true, type=Long.class
	// ,sequence=5,editable=false)
	protected Long payer;

	@Column(name = "SOLD")
	// @Predicate(label="Solde",updatable=false,search=true, type=Long.class
	// ,sequence=5,editable=false)
	protected Long solde;

	@Column(name = "PRIME")
	// @Predicate(label="Total Prime",updatable=false,search=true,
	// type=Long.class ,sequence=6,editable=false)
	protected Long zprime;

	@Column(name = "RETENU")
	// @Predicate(label="Total Retenue",updatable=false,search=true,
	// type=Long.class ,sequence=7,editable=false)
	protected Long zretenu;

	@Column(name = "AVANCE")
	// @Predicate(label="Total Avance",updatable=false,search=true,
	// type=Long.class ,sequence=8,editable=false)
	protected Long zavance;

	// ajout tab inscription
	// ajout tab absence

	public EnseignantSecondaire() {

	}


	public EnseignantSecondaire(String image, String nom, String matricule, String status, String sexe, Date dateEmb, Fonction role,
			String prenon, Date dateNais, String lnais, String contact, String email, Long nefts, Diplome diplome,
			String etatcivile, Categorie categorie, Echellon echelon, String lieu, String cv, Banque banque,
			Long numBanque, ProfilPaie profil, Long njours, Long salaire, Long thoraire, Long salmax, Long payer,
			Long solde, Long zprime, Long zretenu, Long zavance) {
		super();
		this.image = image;
		this.nom = nom;
		this.matricule = matricule;
		this.status = status;
		this.sexe = sexe;
		
		this.role = role;
		this.prenon = prenon;
		this.dateNais = dateNais;
		this.lnais = lnais;
		this.contact = contact;
		this.email = email;
		this.nefts = nefts;
		this.diplome = diplome;
		this.etatcivile = etatcivile;
		this.categorie = categorie;
		this.echelon = echelon;
		this.lieu = lieu;
		this.cv = cv;
		this.banque = banque;
		this.numBanque = numBanque;
		this.profil = profil;
		this.njours = njours;
		this.salaire = salaire;
		this.thoraire = thoraire;
		this.salmax = salmax;
		this.payer = payer;
		this.solde = solde;
		this.zprime = zprime;
		this.zretenu = zretenu;
		this.zavance = zavance;
	}


	public EnseignantSecondaire(EnseignantSecondaire entity) {
		super(entity.id, entity.designation, entity.moduleName, 0L);
		this.image = entity.image;
		this.dateNais = entity.dateNais;
		this.nom = entity.nom;
		this.email = entity.email;
		this.prenon = entity.prenon;
		this.sexe = entity.sexe;

		if (entity.status != null) {
			this.status = entity.status;
		}
		
		if (entity.role != null) {
			this.role = new Fonction(entity.role);
		}
		this.contact = entity.contact;
		if (entity.diplome != null) {
			this.diplome = new Diplome(entity.diplome);
		}
		this.salaire = entity.salaire;
		this.thoraire = entity.thoraire;
		this.role = entity.role;
		this.matricule = entity.matricule;
		this.dateembauche = entity.dateembauche;
		this.lnais =entity.lnais;
		this.contact = entity.contact;
		this.nefts = entity.nefts;
		this.etatcivile = entity.etatcivile;
		if(entity.categorie!=null){
			this.categorie = new Categorie(entity.categorie);
		}		
		if(entity.echelon!=null){
			this.echelon = new Echellon(entity.echelon);
		}		
		this.lieu = entity.lieu;
		this.cv = entity.cv;
		if(entity.banque!=null){
			this.banque = new Banque(entity.banque);
		}
		
		this.numBanque = entity.numBanque;
		
		if(entity.profil!=null){
			this.profil = new ProfilPaie(entity.profil);
		}
		
		this.njours = entity.njours;
		this.salmax = entity.salmax;
		this.payer = entity.payer;
		this.solde = entity.solde;
		this.zprime = entity.zprime;
		this.zretenu = entity.zretenu;
		this.zavance = entity.zavance;
		
		if (entity.structure != null) {
			this.structure = new Etablissement(entity.structure);
		}
		this.modePaiement=entity.getModePaiement();

	}
	
	public EnseignantSecondaire(ProfesseurChoice entity) {
		super(entity.getId(), entity.getDesignation(), entity.getModuleName(), 0L);
		this.dateNais = entity.dateNais;
		this.nom = entity.nom;
		//this.email = entity.email;
		this.prenon = entity.prenon;
		this.sexe = entity.sexe;
		this.matricule=entity.matricule;
		if(entity.profil!=null){
		this.profil= new ProfilPaie(entity.getProfil());
		}
		this.dateembauche=entity.dateembauche;
		
		if(entity.categorie!=null){
			this.categorie= new Categorie(entity.getCategorie());
			}
		this.modePaiement=entity.getModePaiement();

	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Edition des Enseignants/Personnels";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Enseignants/Personnels";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return nom ;
	}

	public Etablissement getStructure() {
		return structure;
	}


	public void setStructure(Etablissement structure) {
		this.structure = structure;
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

	public String getModePaiement() {
		return modePaiement;
	}


	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public Echellon getEchelon() {
		return echelon;
	}


	public void setEchelon(Echellon echelon) {
		this.echelon = echelon;
	}


	public ProfilPaie getProfil() {
		return profil;
	}


	public void setProfil(ProfilPaie profil) {
		this.profil = profil;
	}


	public Date getDateNais() {
		return dateNais;
	}

	public Diplome getDiplome() {
		return diplome;
	}

	public void setDiplome(Diplome diplome) {
		this.diplome = diplome;
	}

	public Fonction getRole() {
		return role;
	}

	public void setRole(Fonction role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}

	public Long getSalaire() {
		return salaire;
	}

	public void setSalaire(Long salaire) {
		this.salaire = salaire;
	}

	public Long getThoraire() {
		return thoraire;
	}

	public void setThoraire(Long thoraire) {
		this.thoraire = thoraire;
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
		final EnseignantSecondaire other = (EnseignantSecondaire) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isCreateonfield() {
		return false;
	}

	public Long getSalmax() {
		return salmax;
	}

	public void setSalmax(Long salmax) {
		this.salmax = salmax;
	}

	public Long getPayer() {
		return payer;
	}

	public void setPayer(Long payer) {
		this.payer = payer;
	}

	public Date getDateembauche() {
		return dateembauche;
	}


	public void setDateembauche(Date dateembauche) {
		this.dateembauche = dateembauche;
	}


	public Long getSolde() {
		return solde;
	}

	public void setSolde(Long solde) {
		this.solde = solde;
	}

	public Long getZprime() {
		return zprime;
	}

	public void setZprime(Long zprime) {
		this.zprime = zprime;
	}

	public Long getZretenu() {
		return zretenu;
	}

	public void setZretenu(Long zretenu) {
		this.zretenu = zretenu;
	}

	public Long getZavance() {
		return zavance;
	}

	public void setZavance(Long zavance) {
		this.zavance = zavance;
	}

	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}



	public String getLnais() {
		return lnais;
	}


	public void setLnais(String lnais) {
		this.lnais = lnais;
	}


	public Long getNefts() {
		return nefts;
	}


	public void setNefts(Long nefts) {
		this.nefts = nefts;
	}


	public String getEtatcivile() {
		return etatcivile;
	}


	public void setEtatcivile(String etatcivile) {
		this.etatcivile = etatcivile;
	}

//
//	public Categorie getCategorie() {
//		return categorie;
//	}
//
//
//	public void setCategorie(Categorie categorie) {
//		this.categorie = categorie;
//	}
//
//
//	public Echellon getEchelon() {
//		return echelon;
//	}
//
//
//	public void setEchelon(Echellon echelon) {
//		this.echelon = echelon;
//	}


	public String getLieu() {
		return lieu;
	}


	public void setLieu(String lieu) {
		this.lieu = lieu;
	}


	public String getCv() {
		return cv;
	}


	public void setCv(String cv) {
		this.cv = cv;
	}


	public Banque getBanque() {
		return banque;
	}


	public void setBanque(Banque banque) {
		this.banque = banque;
	}


	public Long getNumBanque() {
		return numBanque;
	}


	public void setNumBanque(Long numBanque) {
		this.numBanque = numBanque;
	}


//	public ProfilPaie getProfil() {
//		return profil;
//	}
//
//
//	public void setProfil(ProfilPaie profil) {
//		this.profil = profil;
//	}


	public Long getNjours() {
		return njours;
	}


	public void setNjours(Long njours) {
		this.njours = njours;
	}


	public int compareTo(EnseignantSecondaire o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
