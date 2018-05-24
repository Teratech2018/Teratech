/**
 * 
 */
package com.keren.kerenpaie.model.structures;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.print.attribute.standard.JobOriginatingUserName;
import javax.xml.bind.annotation.XmlRootElement;

import com.core.base.BaseElement;
import com.keren.kerenpaie.model.comptabilite.Compte;
import com.keren.kerenpaie.model.comptabilite.JournalComptable;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name = "T_SOCIETE")
@XmlRootElement
public class Societe extends BaseElement implements Serializable, Comparable<Societe> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2828949267142438471L;
	
	@Predicate(label = "Logo de la société",search = false,target = "image")
    private String image ;
   
    @Predicate(label = "Nom de la socièté" ,optional = false,unique = true,search = true)
    private String code ;
    
    @Predicate(label = "Slogan de la socièté",search = true)
    private String intitule;
    
    @Predicate(label = "Adresse",group = true,groupName = "infosgenerales",groupLabel = "Informations Générales",search = true)
    private String adresse;
    
    @Predicate(label = "Téléphone",target = "tel",group = true,groupName = "infosgenerales",groupLabel = "Informations Générales",search = true)
    private String telephone;    
    
    @Predicate(label = "Ville",group = true,groupName = "infosgenerales",groupLabel = "Informations Générales")
    private String ville;
    
    @Predicate(label = "Fax" , target = "tel",group = true,groupName = "infosgenerales",groupLabel = "Informations Générales")
    private String fax ;
    
    @Predicate(label = "Code Postal",group = true,groupName = "infosgenerales",groupLabel = "Informations Générales",search = true)
    private String codePostal;
    
    @Predicate(label = "Courriel",group = true,groupName = "infosgenerales",groupLabel = "Informations Générales",search = true)
    private String courriel ;
    
    @Predicate(label = "Pays" , type = Pays.class,group = true,groupName = "infosgenerales",groupLabel = "Informations Générales")
    @ManyToOne
    @JoinColumn(name = "PAYS_ID")
    private Pays pays ;
    
    @Predicate(label = "Numéro fiscal",group = true,groupName = "infosgenerales",groupLabel = "Informations Générales")
    private String numFiscal ;
    
    @Predicate(label = "Site Web",target = "url",group = true,groupName = "infosgenerales",groupLabel = "Informations Générales")
    private String siteWeb ;
    
    @Predicate(label = "Registre du commerce",group = true,groupName = "infosgenerales",groupLabel = "Informations Générales")
    private String registre ;
    
    @Predicate(label = "Devise" ,type = Devise.class,group = true,groupName = "infosgenerales",groupLabel = "Informations Générales")
    @ManyToOne
    @JoinColumn(name = "DEV_ID")
    private Devise devise ;
    
   /*@Predicate(label = "Socièté mère" , type = Societe.class,target="many-to-one")
   @ManyToOne
   @JoinColumn(name = "SOCP_ID")
    private Societe societeMere ;*/

   @Predicate(label = "Compte de Regroupement" , type = Compte.class,target="many-to-one",group=true,groupName="comptabilite",groupLabel="Comptabilité")
   @ManyToOne
   @JoinColumn(name="CREGR_ID")
   private Compte regroupement ;
   
   @Predicate(label = "Compte des Avance" , type = Compte.class,target="many-to-one",group=true,groupName="comptabilite",groupLabel="Comptabilité")
   @ManyToOne
   @JoinColumn(name="CAVA_ID")
   private Compte avance ;
   
   @Predicate(label = "Journal" , type = JournalComptable.class,target="many-to-one",group=true,groupName="comptabilite",groupLabel="Comptabilité")
   @ManyToOne
   @JoinColumn(name="JOCO_ID")
   private JournalComptable journal;
   
   @OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
   @JoinColumn(name="SOC_ID")
   @Predicate(label="Planification",type=Planification.class,target="one-to-many",group=true,groupLabel="Planification",groupName="aplan",edittable=true)
   private List<Planification> planifications = new ArrayList<Planification>();
   
   /**
    * 
    */
  public Societe() {
  }

  
  

 /**
  * 
  * @param id
  * @param designation
  * @param moduleName
  * @param image
  * @param code
  * @param intitule
  * @param adresse
  * @param telephone
  * @param ville
  * @param fax
  * @param codePostal
  * @param courriel
  * @param pays
  * @param numFiscal
  * @param siteWeb
  * @param registre
  * @param devise
  * @param societeMere
  * @param regroupement
  * @param avance
  * @param journal
  */
  public Societe(long id, String designation, String moduleName, String image, String code, String intitule,
		String adresse, String telephone, String ville, String fax, String codePostal, String courriel, Pays pays,
		String numFiscal, String siteWeb, String registre, Devise devise, Societe societeMere, Compte regroupement,
		Compte avance, JournalComptable journal) {
	super(id, designation, moduleName);
	this.image = image;
	this.code = code;
	this.intitule = intitule;
	this.adresse = adresse;
	this.telephone = telephone;
	this.ville = ville;
	this.fax = fax;
	this.codePostal = codePostal;
	this.courriel = courriel;
	this.pays = pays;
	this.numFiscal = numFiscal;
	this.siteWeb = siteWeb;
	this.registre = registre;
	this.devise = devise;
	//this.societeMere = societeMere;
	this.regroupement = regroupement;
	this.avance = avance;
	this.journal = journal;
}

  /**
   * 
   * @param societe
   */
  public Societe(Societe societe) {
		super(societe.id, societe.designation, societe.moduleName);
		this.image = societe.image;
		this.code = societe.code;
		this.intitule = societe.intitule;
		this.adresse = societe.adresse;
		this.telephone = societe.telephone;
		this.ville = societe.ville;
		this.fax = societe.fax;
		this.codePostal = societe.codePostal;
		this.courriel = societe.courriel;
		if(societe.pays!=null){
			this.pays = new Pays(societe.pays);
		}
		this.numFiscal = societe.numFiscal;
		this.siteWeb = societe.siteWeb;
		this.registre = societe.registre;
		this.devise = societe.devise;
//		if(societe.societeMere!=null){
//			this.societeMere = new Societe(societe.societeMere);
//		}
		if(societe.regroupement!=null){
			this.regroupement = new Compte(societe.regroupement);
		}
		if(societe.avance!=null){
			this.avance = new Compte(societe.avance);
		}
		if(societe.journal!=null){
			this.journal = new JournalComptable(societe.journal);
		}
	}



public String getImage() {
      return image;
  }

  public void setImage(String image) {
      this.image = image;
  }

  public String getCode() {
      return code;
  }

  public void setCode(String code) {
      this.code = code;
  }

  @Override
  public String getDesignation() {
      return intitule;
  }

  public String getAdresse() {
      return adresse;
  }

  public void setAdresse(String adresse) {
      this.adresse = adresse;
  }

  public String getTelephone() {
      return telephone;
  }

  public void setTelephone(String telephone) {
      this.telephone = telephone;
  }

  public String getVille() {
      return ville;
  }

  public void setVille(String ville) {
      this.ville = ville;
  }

  public String getFax() {
      return fax;
  }

  public void setFax(String fax) {
      this.fax = fax;
  }

  public String getCodePostal() {
      return codePostal;
  }

  public void setCodePostal(String codePostal) {
      this.codePostal = codePostal;
  }

  public String getCourriel() {
      return courriel;
  }

  public void setCourriel(String courriel) {
      this.courriel = courriel;
  }

  public Pays getPays() {
      return pays;
  }

  public void setPays(Pays pays) {
      this.pays = pays;
  }

  public String getNumFiscal() {
      return numFiscal;
  }

  public void setNumFiscal(String numFiscal) {
      this.numFiscal = numFiscal;
  }

  public String getSiteWeb() {
      return siteWeb;
  }

  public void setSiteWeb(String siteWeb) {
      this.siteWeb = siteWeb;
  }

  public String getRegistre() {
      return registre;
  }

  public void setRegistre(String registre) {
      this.registre = registre;
  }

  public Devise getDevise() {
      return devise;
  }

  public void setDevise(Devise devise) {
      this.devise = devise;
  }

  public String getIntitule() {
      return intitule;
  }

  public void setIntitule(String intitule) {
      this.intitule = intitule;
  }

  /*public Societe getSocieteMere() {
      return societeMere;
  }

  public void setSocieteMere(Societe societeMere) {
      this.societeMere = societeMere;
  }*/

 
  
  

//  public Societe getSocieteMere() {
//      return societeMere;
//  }
//
//  public void setSocieteMere(Societe societeMere) {
//      this.societeMere = societeMere;
//  }

  public List<Planification> getPlanifications() {
	return planifications;
}




public void setPlanifications(List<Planification> planifications) {
	this.planifications = planifications;
}




public Compte getRegroupement() {
	return regroupement;
}

public void setRegroupement(Compte regroupement) {
	this.regroupement = regroupement;
}

public Compte getAvance() {
	return avance;
}

public void setAvance(Compte avance) {
	this.avance = avance;
}

public JournalComptable getJournal() {
	return journal;
}

public void setJournal(JournalComptable journal) {
	this.journal = journal;
}

@Override
  public String getListTitle() {
      return "SOCIETES"; //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public String getEditTitle() {
      return "SOCIETE"; //To change body of generated methods, choose Tools | Templates.
  }
   
   @Override
  public String getModuleName() {
       //To change body of generated methods, choose Tools | Templates.
      return "kerenpaie";
  }

  @Override
  public boolean isCreateonfield() {
      return false; //To change body of generated methods, choose Tools | Templates.
  }
  
  
   
  @Override
  public int compareTo(Societe o) {
       //To change body of generated methods, choose Tools | Templates.
      return code.compareTo(o.code);
  }
}
