/**
 * 
 */
package com.keren.courrier.model.referentiel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.core.base.BaseElement;
import com.core.referentiels.Devise;
import com.core.referentiels.Pays;
import com.megatim.common.annotations.Predicate;

/**
 * @author NTW
 *
 */
@Entity
@Table(name = "T_SOCIETE")
@XmlRootElement
public class Company extends BaseElement implements Serializable, Comparable<Company> {

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
    
	@ManyToOne
	@JoinColumn(name = "DES_ID")
	@Predicate(label = "Destinataire Par Défaut", type = UtilisateurCourrier.class, updatable = true, target = "many-to-one",
			 group = true, groupName = "tab1", groupLabel = "Configuration ", optional=false)
	private UtilisateurCourrier destDefaut;
	
	@ManyToOne
	@JoinColumn(name = "T_SERV")
	@Predicate(label = "Service Traitant Par Défaut", type = StructureCompany.class, target = "many-to-one", updatable = true, 
	optional = false,group = true, groupName = "tab1", groupLabel = "Configuration ")
	private StructureCompany serviceTraitantdefaut;
	
	@ManyToOne
	@JoinColumn(name = "T_PRIO")
	@Predicate(label = "Priorité Par Défaut", type = Priorite.class, target = "many-to-one", optional = false
			,group = true, groupName = "tab1", groupLabel = "Configuration ")
	private Priorite priorite;
	
	@Predicate(label = "Mention du courrier Par défaut", target = "combobox", values = "Ordinaire;Confidentiel"
			,group = true, groupName = "tab1", groupLabel = "Configuration ")
	private String porte = "0";
	
	@Predicate(label = "Registre Arrivé", group = true, groupName = "tab1", groupLabel = "Configuration")
	private String numregistrearrive;

	@Predicate(label = "Registre Départ", group = true, groupName = "tab1", groupLabel = "Configuration")
	private String numregistredepart;

    @Predicate(label = "Adresse",group = true,groupName = "tab2",groupLabel = "Informations Générales",search = true)
    private String adresse;
    
    @Predicate(label = "Téléphone",target = "tel",group = true,groupName = "tab2",groupLabel = "Informations Générales",search = true)
    private String telephone;    
    
    @Predicate(label = "Ville",group = true,groupName = "tab2",groupLabel = "Informations Générales")
    private String ville;
    
    @Predicate(label = "Fax" , target = "tel",group = true,groupName = "tab2",groupLabel = "Informations Générales")
    private String fax ;
    
    @Predicate(label = "Code Postal",group = true,groupName = "tab2",groupLabel = "Informations Générales",search = true)
    private String codePostal;
    
    @Predicate(label = "Courriel",group = true,groupName = "tab2",groupLabel = "Informations Générales",search = true)
    private String courriel ;
    
  
    @Predicate(label = "Numéro fiscal",group = true,groupName = "tab2",groupLabel = "Informations Générales")
    private String numFiscal ;
    
    @Predicate(label = "Site Web",target = "url",group = true,groupName = "tab2",groupLabel = "Informations Générales")
    private String siteWeb ;
    
    @Predicate(label = "Registre du commerce",group = true,groupName = "tab2",groupLabel = "Informations Générales")
    private String registre ;
    
 
    
    


   
   /**
    * 
    */
  public Company() {
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
  public Company(long id, String designation, String moduleName, String image, String code, String intitule,
		String adresse, String telephone, String ville, String fax, String codePostal, String courriel, Pays pays,
		String numFiscal, String siteWeb, String registre, Devise devise, Company societeMere) {
	super(id, designation, moduleName,0L);
	this.image = image;
	this.code = code;
	this.intitule = intitule;
	this.adresse = adresse;
	this.telephone = telephone;
	this.ville = ville;
	this.fax = fax;
	this.codePostal = codePostal;
	this.courriel = courriel;
	this.numFiscal = numFiscal;
	this.siteWeb = siteWeb;
	this.registre = registre;
}

  /**
   * 
   * @param societe
   */
  public Company(Company societe) {
		super(societe.id, societe.designation, societe.moduleName,societe.compareid);
		this.image = societe.image;
		this.code = societe.code;
		this.intitule = societe.intitule;
		this.adresse = societe.adresse;
		this.telephone = societe.telephone;
		this.ville = societe.ville;
		this.fax = societe.fax;
		this.codePostal = societe.codePostal;
		this.courriel = societe.courriel;
		this.numFiscal = societe.numFiscal;
		this.siteWeb = societe.siteWeb;
		this.registre = societe.registre;
		this.numregistrearrive=societe.numregistrearrive;
		this.numregistredepart=societe.numregistredepart;
		
		if(societe.destDefaut!=null){
			this.destDefaut= new UtilisateurCourrier(societe.destDefaut);
		}
		
		if(societe.serviceTraitantdefaut!=null){
			this.serviceTraitantdefaut= new StructureCompany(societe.serviceTraitantdefaut);
		}
		if(societe.priorite!=null){
			this.priorite= new Priorite(societe.priorite);
		}
		this.porte=societe.porte;
		
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

 

  public Priorite getPriorite() {
	return priorite;
}




public void setPriorite(Priorite priorite) {
	this.priorite = priorite;
}




public String getPorte() {
	return porte;
}




public void setPorte(String porte) {
	this.porte = porte;
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

  public UtilisateurCourrier getDestDefaut() {
	return destDefaut;
}




public void setDestDefaut(UtilisateurCourrier destDefaut) {
	this.destDefaut = destDefaut;
}




public StructureCompany getServiceTraitantdefaut() {
	return serviceTraitantdefaut;
}




public void setServiceTraitantdefaut(StructureCompany serviceTraitantdefaut) {
	this.serviceTraitantdefaut = serviceTraitantdefaut;
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

  

  public String getIntitule() {
      return intitule;
  }

  public void setIntitule(String intitule) {
      this.intitule = intitule;
  }

  

public String getNumregistrearrive() {
	return numregistrearrive;
}




public void setNumregistrearrive(String numregistrearrive) {
	this.numregistrearrive = numregistrearrive;
}




public String getNumregistredepart() {
	return numregistredepart;
}




public void setNumregistredepart(String numregistredepart) {
	this.numregistredepart = numregistredepart;
}




@Override
  public String getListTitle() {
      return "SOCIETES";
  }

  @Override
  public String getEditTitle() {
      return "SOCIETE"; 
  }
   
   @Override
  public String getModuleName() {
      return "kerencourrier";
  }

  @Override
  public boolean isCreateonfield() {
      return false; 
  }
  
  
   
  @Override
  public int compareTo(Company o) {
      return code.compareTo(o.code);
  }
}
