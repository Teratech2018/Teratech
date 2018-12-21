/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.model.operations;

import com.megatim.common.annotations.Predicate;
import com.megatimgroup.model.referentiels.Nationalite;
import com.megatimgroup.model.referentiels.NatureClientele;
import com.megatimgroup.model.referentiels.PrecisionDateNaissance;
import com.megatimgroup.model.referentiels.Qualite;
import com.megatimgroup.model.referentiels.StatusResidence;
import com.megatimgroup.model.referentiels.Titre;
import com.megatimgroup.model.referentiels.Ville;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Declaration des personnes Physique
 * @author Commercial_2
 */
@Entity
@Table(name="D_PHYSIQUE")
@Inheritance(strategy= InheritanceType.JOINED)
public class DeclarationPP extends DeclarationBase implements Serializable {

    @ManyToOne    
    @JoinColumn(name="C_QUALITE")
    @Predicate(nullable=true,optional=true,entry=true,type=Qualite.class,label="Qualité ")
    private Qualite qualite ;
    
    @ManyToOne    
    @JoinColumn(name="C_TITRE")
    @Predicate(nullable=true,optional=true,entry=true,type=Titre.class,label="Titre ")
    private Titre titre ;
    
    @Column(name="C_NOM")
    @Predicate(max=30,nullable=false,optional=false,label="Nom ")
    private String nom ;
    
    @Column(name="C_PRENOM")
    @Predicate(max=30,label="Prenoms ")
    private String prenom;
    
    @Column(name="D_NAISSANCE")
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label="Date de naissance ",type=Date.class)
    private Date dateNaissance ;
    
    @Column(name="C_LNAISS")
    @Predicate(max=50,label="Lieu de naissance")
    private String lieuNaissance ;
    
    @Column(name="C_NOMJF")
    @Predicate(max=30,label="Nom de jeune fille ")
    private String nomJeuneFille ;
    
    @ManyToOne    
    @JoinColumn(name="C_NATION")
    @Predicate(entry=true,type=Nationalite.class,nullable=false,optional=false,label="Nationalité ")
    private Nationalite nationalite ;
    
    @Column(name="C_PROF")
    @Predicate(nullable=false,optional=false,label="Profession",max=50)
    private String profession ;
    
    @ManyToOne
    @JoinColumn(name="C_NCLIENT")
    @Predicate(entry=true,type=NatureClientele.class,label="Nature de clientèle")
    private NatureClientele natureClientele;
    
    @ManyToOne
    @JoinColumn(name="C_SRESID")
    @Predicate(entry=true,type=StatusResidence.class,nullable=false,optional=false,label="Statut de résidence")
    private StatusResidence statusResidence ;
    
    @Column(name="C_ADRE1")
    @Predicate(max=30,label="Adresse (champ 1 ) ")
    private String adresse_1 ;
    
    @Column(name="C_ADRE2")
    @Predicate(max=30,label="Adresse (champ 2 ) ")
    private String adresse_2 ;
     
    @Column(name="C_ADRE3")
    @Predicate(max=30,label="Adresse (champ 3 ) ")  
    private String adresse_3 ;
      
    @Column(name="C_BP")
    @Predicate(max=5,label="Boite postale ")
    private String boitepostale; 
    
    @ManyToOne
    @JoinColumn(name="C_VILLE")
    @Predicate(entry=true,type=Ville.class,nullable=true,optional=true,label="Ville")
    private Ville ville ;

    @ManyToOne
    @JoinColumn(name="C_PDN")
    @Predicate(entry=true,type=PrecisionDateNaissance.class,label="Précision de la date de naissance")
    private PrecisionDateNaissance precisionDatenaissance ;
    
    /**
     * 
     */
    public DeclarationPP() {
    }

    
    /**
     * 
     * @param reference 
     */
    public DeclarationPP(String reference) {
        super(reference);
    }

    /**
     * 
     * @param qualite
     * @param titre
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param lieuNaissance
     * @param nomJeuneFille
     * @param nationalite
     * @param profession
     * @param statusResidence
     * @param adresse_1
     * @param adresse_2
     * @param adresse_3
     * @param boitepostale
     * @param ville
     * @param reference 
     */
    public DeclarationPP(Qualite qualite, Titre titre, String nom, String prenom, Date dateNaissance, String lieuNaissance, String nomJeuneFille, Nationalite nationalite, String profession, StatusResidence statusResidence, String adresse_1, String adresse_2, String adresse_3, String boitepostale, Ville ville, String reference) {
        super(reference);
        this.qualite = qualite;
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.nomJeuneFille = nomJeuneFille;
        this.nationalite = nationalite;
        this.profession = profession;
        this.statusResidence = statusResidence;
        this.adresse_1 = adresse_1;
        this.adresse_2 = adresse_2;
        this.adresse_3 = adresse_3;
        this.boitepostale = boitepostale;
        this.ville = ville;
    }

    public Qualite getQualite() {
        return qualite;
    }

    public void setQualite(Qualite qualite) {
        this.qualite = qualite;
    }

    public Titre getTitre() {
        return titre;
    }

    public void setTitre(Titre titre) {
        this.titre = titre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getNomJeuneFille() {
        return nomJeuneFille;
    }

    public void setNomJeuneFille(String nomJeuneFille) {
        this.nomJeuneFille = nomJeuneFille;
    }

    public Nationalite getNationalite() {
        return nationalite;
    }

    public void setNationalite(Nationalite nationalite) {
        this.nationalite = nationalite;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public NatureClientele getNatureClientele() {
        return natureClientele;
    }

    public void setNatureClientele(NatureClientele natureClientele) {
        this.natureClientele = natureClientele;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public PrecisionDateNaissance getPrecisionDatenaissance() {
        return precisionDatenaissance;
    }

    public void setPrecisionDatenaissance(PrecisionDateNaissance precisionDatenaissance) {
        this.precisionDatenaissance = precisionDatenaissance;
    }

    @Override
    public String toString() {
        return "DeclarationPP{" + "qualite=" + qualite + ", titre=" + titre + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", lieuNaissance=" + lieuNaissance + ", nomJeuneFille=" + nomJeuneFille + ", nationalite=" + nationalite + ", profession=" + profession + ", natureClientele=" + natureClientele + ", statusResidence=" + statusResidence + ", adresse_1=" + adresse_1 + ", adresse_2=" + adresse_2 + ", adresse_3=" + adresse_3 + ", boitepostale=" + boitepostale + ", ville=" + ville + ", precisionDatenaissance=" + precisionDatenaissance + '}';
    }
    
    
   
    
}
