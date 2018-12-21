/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.model.operations;

import com.megatim.common.annotations.Predicate;
import com.megatimgroup.model.referentiels.Classe;
import com.megatimgroup.model.referentiels.Division;
import com.megatimgroup.model.referentiels.Groupe;
import com.megatimgroup.model.referentiels.NatureClientele;
import com.megatimgroup.model.referentiels.NatureJuridique;
import com.megatimgroup.model.referentiels.Section;
import com.megatimgroup.model.referentiels.StatusResidence;
import com.megatimgroup.model.referentiels.Ville;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Commercial_2
 */
@Entity
@Table(name="D_MORALE")
public class DeclarationPM extends DeclarationBase implements Serializable{
    
    @Column(name="C_RSOCIAL")
    @Predicate(max=50,nullable=false,optional=false,label="Raison social")
    private String raisonSocial ;
    
    @Column(name="C_SIGLE")
    @Predicate(max=20,nullable=false,optional=false,label="Sigle")
    private String sigle ;
    
    @Column(name="C_SSOCIAL")
    @Predicate(max=5,nullable=false,optional=false,label="Siège social")
    private String siegeSocial ;
    
    @Column(name="C_RCOMM")
    @Predicate(max=10,label="Numéro registre du commerce et du credit Mobilier")
    private String registreCommerce ;
    
    @Column(name="C_NOMAB")
    @Predicate(max=34,label="Nom abrégé")
    private String nomAbrege ;
    
    @Column(name="C_STAT")
    @Predicate(max=10,label="Code statisque")
    private String codeStatistique;
    
    @ManyToOne
    @JoinColumn(name="C_NJURI")
    @Predicate(nullable=false,optional=false,entry=true,type=NatureJuridique.class,label="Nature juridique")
    private NatureJuridique natureJuridique;
    
    @Column(name="D_CREATION")
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label="Date de création",type=Date.class)
    private Date dateCreation ;
    
   @ManyToOne
   @JoinColumn(name="C_NCLIENT")
   @Predicate(entry=true,type=NatureClientele.class,label="Nature de clientèle")
   private NatureClientele natureClientele;
   
   @Column(name="C_OSOCIAL")
   @Predicate(max=100,optional=false,nullable=false,label="Objet social")
   private String objetSocial ;
   
   @ManyToOne
   @JoinColumn(name="C_SRESID")
   @Predicate(entry=true,type=StatusResidence.class,nullable=false,optional=false,label="Statut de résidence")
   private StatusResidence statusResidence ;
   
    @Column(name="C_ADRE1")
    @Predicate(max=30,label="Adresse (champ 1)")
    private String adresse_1 ;
    
    @Column(name="C_ADRE2")
    @Predicate(max=30,label="Adresse (champ 2)")
    private String adresse_2 ;
     
    @Column(name="C_ADRE3")
    @Predicate(max=30,label="Adresse (champ 3)")
    private String adresse_3 ;
      
    @Column(name="C_BP")
    @Predicate(max=5,label="Boite postale")
    private String boitepostale; 
    
    @ManyToOne
    @JoinColumn(name="C_VILLE")
    @Predicate(entry=true,type=Ville.class,nullable=false,optional=false,label="Ville")
    private Ville ville ;
    
    @Column(name="C_FAX")
    @Predicate(max=30,label="N° FAX")
    private String fax ;
    
    @Column(name="C_TEL1")
    @Predicate(max=20,label="N° Téléphone (ligne 1) ")
    private String telephone1 ;
    
    @Column(name="C_TEL2")
    @Predicate(max=20,label="N° Téléphone (ligne 2) ")
    private String telephone2 ;
    
    @Column(name="C_TEL3")
    @Predicate(max=20,label="N° Téléphone (ligne 3) ")
    private String telephone3;
    
    @Column(name="C_EMAIl")
    @Predicate(max=30,label="Adresse électronique ")
    private String email;
    
    @ManyToOne
    @JoinColumn(name="C_SECTION")
    @Predicate(entry=true,type=Section.class,nullable=false,optional=false,label="Section ")
    private Section section;
    
    @ManyToOne
    @JoinColumn(name="C_DIVISION")
    @Predicate(entry=true,type=Division.class,nullable=false,optional=false,label="Division ")
    private Division division;
    
    @ManyToOne
    @JoinColumn(name="C_GROUPE")
    @Predicate(entry=true,type=Groupe.class,nullable=false,optional=false,label="Groupe ")
    private Groupe groupe;
    
    @ManyToOne
    @JoinColumn(name="C_CLASSE")
    @Predicate(entry=true,type=Classe.class,nullable=false,optional=false,label="Classe ")
    private Classe classe;
    
    

    
    /**
     * 
     */
    public DeclarationPM() {
    }

    
    /**
     * 
     * @param reference 
     */
    public DeclarationPM(String reference) {
        super(reference);
    }

    /**
     * 
     * @param raisonSocial
     * @param sigle
     * @param siegeSocial
     * @param registreCommerce
     * @param nomAbrege
     * @param codeStatistique
     * @param natureJuridique
     * @param dateCreation
     * @param natureClientele
     * @param objetSocial
     * @param statusResidence
     * @param adresse_1
     * @param adresse_2
     * @param adresse_3
     * @param boitepostale
     * @param ville
     * @param fax
     * @param telephone1
     * @param telephone2
     * @param telephone3
     * @param email
     * @param section
     * @param division
     * @param groupe
     * @param classe
     * @param reference 
     */
    public DeclarationPM(String raisonSocial, String sigle, String siegeSocial, String registreCommerce, String nomAbrege, String codeStatistique, NatureJuridique natureJuridique, Date dateCreation, NatureClientele natureClientele, String objetSocial, StatusResidence statusResidence, String adresse_1, String adresse_2, String adresse_3, String boitepostale, Ville ville, String fax, String telephone1, String telephone2, String telephone3, String email, Section section, Division division, Groupe groupe, Classe classe, String reference) {
        super(reference);
        this.raisonSocial = raisonSocial;
        this.sigle = sigle;
        this.siegeSocial = siegeSocial;
        this.registreCommerce = registreCommerce;
        this.nomAbrege = nomAbrege;
        this.codeStatistique = codeStatistique;
        this.natureJuridique = natureJuridique;
        this.dateCreation = dateCreation;
        this.natureClientele = natureClientele;
        this.objetSocial = objetSocial;
        this.statusResidence = statusResidence;
        this.adresse_1 = adresse_1;
        this.adresse_2 = adresse_2;
        this.adresse_3 = adresse_3;
        this.boitepostale = boitepostale;
        this.ville = ville;
        this.fax = fax;
        this.telephone1 = telephone1;
        this.telephone2 = telephone2;
        this.telephone3 = telephone3;
        this.email = email;
        this.section = section;
        this.division = division;
        this.groupe = groupe;
        this.classe = classe;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getSiegeSocial() {
        return siegeSocial;
    }

    public void setSiegeSocial(String siegeSocial) {
        this.siegeSocial = siegeSocial;
    }

    public String getRegistreCommerce() {
        return registreCommerce;
    }

    public void setRegistreCommerce(String registreCommerce) {
        this.registreCommerce = registreCommerce;
    }

    public String getNomAbrege() {
        return nomAbrege;
    }

    public void setNomAbrege(String nomAbrege) {
        this.nomAbrege = nomAbrege;
    }

    public String getCodeStatistique() {
        return codeStatistique;
    }

    public void setCodeStatistique(String codeStatistique) {
        this.codeStatistique = codeStatistique;
    }

    public NatureJuridique getNatureJuridique() {
        return natureJuridique;
    }

    public void setNatureJuridique(NatureJuridique natureJuridique) {
        this.natureJuridique = natureJuridique;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public NatureClientele getNatureClientele() {
        return natureClientele;
    }

    public void setNatureClientele(NatureClientele natureClientele) {
        this.natureClientele = natureClientele;
    }

    public String getObjetSocial() {
        return objetSocial;
    }

    public void setObjetSocial(String objetSocial) {
        this.objetSocial = objetSocial;
    }

    public StatusResidence getStatusResidence() {
        return statusResidence;
    }

    public void setStatusResidence(StatusResidence statusResidence) {
        this.statusResidence = statusResidence;
    }

    public String getAdresse_1() {
        return adresse_1;
    }

    public void setAdresse_1(String adresse_1) {
        this.adresse_1 = adresse_1;
    }

    public String getAdresse_2() {
        return adresse_2;
    }

    public void setAdresse_2(String adresse_2) {
        this.adresse_2 = adresse_2;
    }

    public String getAdresse_3() {
        return adresse_3;
    }

    public void setAdresse_3(String adresse_3) {
        this.adresse_3 = adresse_3;
    }

    public String getBoitepostale() {
        return boitepostale;
    }

    public void setBoitepostale(String boitepostale) {
        this.boitepostale = boitepostale;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getTelephone3() {
        return telephone3;
    }

    public void setTelephone3(String telephone3) {
        this.telephone3 = telephone3;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
    
}
