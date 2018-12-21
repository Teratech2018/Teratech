/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.ebaytools.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Commercial_2
 */
public class EbayItem implements Serializable{

    private String reference ;    
    
    private String idOperation ;
    
    private String qualite ;
    
    private String titre ;
    
    private String nom ;
    
    private String prenom;
    
    private String dateNaissance ;
    
    private String lieuNaissance ;
    
    private String nomJeuneFille ;
    
    private String nationalite ;
    
    private String profession ;
    
    private String natureClientele;
    
    private String statusResidence ;
    
    private String adresse_1 ;
    
    private String adresse_2 ;
     
    private String adresse_3 ;
      
    private String boitepostale; 
    
    private String ville ;
     
    private String raisonSocial ;
    
    private String sigle ;
    
    private String siegeSocial ;
    
    private String registreCommerce ;
    
    private String nomAbrege ;
    
    private String codeStatistique;
    
    private String natureJuridique;
    
    private String dateCreation ;
    
    private String objetSocial ;
   
    private String fax ;
    
    private String telephone1 ;
    
    private String telephone2 ;
    
    private String telephone3;
    
    private String email;
    
    private String section;
    
    private String division;
    
    private String groupe;
    
    private String classe; 

    private String precisionDatenaissance ;
    
    private String designation ;
    
    private String montant ;
    
    private String sens ;
    
    private String devise ;
    
    private String dateOperation ;
    
    private String type ;
    
    private String pays ;
    
    private String motif ;
    
    private String commentaire ;

    private String mtcn ;
    

    
    /**
     * 
     */
    public EbayItem() {
    }

    /**
     * 
     * @param reference
     * @param qualite
     * @param titre
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param lieuNaissance
     * @param nomJeuneFille
     * @param nationalite
     * @param profession
     * @param natureClientele
     * @param statusResidence
     * @param adresse_1
     * @param adresse_2
     * @param adresse_3
     * @param boitepostale
     * @param ville
     * @param raisonSocial
     * @param sigle
     * @param siegeSocial
     * @param registreCommerce
     * @param nomAbrege
     * @param codeStatistique
     * @param natureJuridique
     * @param dateCreation
     * @param objetSocial
     * @param fax
     * @param telephone1
     * @param telephone2
     * @param telephone3
     * @param email
     * @param section
     * @param division
     * @param groupe
     * @param classe
     * @param precisionDatenaissance
     * @param designation
     * @param montant
     * @param sens
     * @param devise
     * @param dateOperation
     * @param type
     * @param pays
     * @param motif
     * @param commentaire 
     */
    public EbayItem(String reference, String qualite, String titre, String nom, String prenom, String dateNaissance, String lieuNaissance, String nomJeuneFille, String nationalite, String profession, String natureClientele, String statusResidence, String adresse_1, String adresse_2, String adresse_3, String boitepostale, String ville, String raisonSocial, String sigle, String siegeSocial, String registreCommerce, String nomAbrege, String codeStatistique, String natureJuridique, String dateCreation, String objetSocial, String fax, String telephone1, String telephone2, String telephone3, String email, String section, String division, String groupe, String classe, String precisionDatenaissance, String designation, String montant, String sens, String devise, String dateOperation, String type, String pays, String motif, String commentaire) {
        this.reference = reference;
        this.qualite = qualite;
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.nomJeuneFille = nomJeuneFille;
        this.nationalite = nationalite;
        this.profession = profession;
        this.natureClientele = natureClientele;
        this.statusResidence = statusResidence;
        this.adresse_1 = adresse_1;
        this.adresse_2 = adresse_2;
        this.adresse_3 = adresse_3;
        this.boitepostale = boitepostale;
        this.ville = ville;
        this.raisonSocial = raisonSocial;
        this.sigle = sigle;
        this.siegeSocial = siegeSocial;
        this.registreCommerce = registreCommerce;
        this.nomAbrege = nomAbrege;
        this.codeStatistique = codeStatistique;
        this.natureJuridique = natureJuridique;
        this.dateCreation = dateCreation;
        this.objetSocial = objetSocial;
        this.fax = fax;
        this.telephone1 = telephone1;
        this.telephone2 = telephone2;
        this.telephone3 = telephone3;
        this.email = email;
        this.section = section;
        this.division = division;
        this.groupe = groupe;
        this.classe = classe;
        this.precisionDatenaissance = precisionDatenaissance;
        this.designation = designation;
        this.montant = montant;
        this.sens = sens;
        this.devise = devise;
        this.dateOperation = dateOperation;
        this.type = type;
        this.pays = pays;
        this.motif = motif;
        this.commentaire = commentaire;
    }

  
    
    
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getQualite() {
        return qualite;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
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

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
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

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getNatureClientele() {
        return natureClientele;
    }

    public void setNatureClientele(String natureClientele) {
        this.natureClientele = natureClientele;
    }

    public String getStatusResidence() {
        return statusResidence;
    }

    public void setStatusResidence(String statusResidence) {
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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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

    public String getNatureJuridique() {
        return natureJuridique;
    }

    public void setNatureJuridique(String natureJuridique) {
        this.natureJuridique = natureJuridique;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getObjetSocial() {
        return objetSocial;
    }

    public void setObjetSocial(String objetSocial) {
        this.objetSocial = objetSocial;
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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getPrecisionDatenaissance() {
        return precisionDatenaissance;
    }

    public void setPrecisionDatenaissance(String precisionDatenaissance) {
        this.precisionDatenaissance = precisionDatenaissance;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getSens() {
        return sens;
    }

    public void setSens(String sens) {
        this.sens = sens;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(String dateOperation) {
        this.dateOperation = dateOperation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getCommentaire() {
        return commentaire;
    }

    /**
	 * @return the idoperation
	 */
	public String getIdOperation() {
		return idOperation;
	}

	/**
	 * @param idoperation the idoperation to set
	 */
	public void setIdOperation(String idoperation) {
		this.idOperation = idoperation;
	}

	public void setCommentaire(String commentaire) {
            this.commentaire = commentaire;
        }

        public String getMtcn() {
            return mtcn;
        }

        public void setMtcn(String mtcn) {
            this.mtcn = mtcn;
        }

       
        
        

    @Override
    public String toString() {
        return "EbayItem{" + "reference=" + reference + ", qualite=" + qualite + ", titre=" + titre + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", lieuNaissance=" + lieuNaissance + ", nomJeuneFille=" + nomJeuneFille + ", nationalite=" + nationalite + ", profession=" + profession + ", natureClientele=" + natureClientele + ", statusResidence=" + statusResidence + ", adresse_1=" + adresse_1 + ", adresse_2=" + adresse_2 + ", adresse_3=" + adresse_3 + ", boitepostale=" + boitepostale + ", ville=" + ville + ", raisonSocial=" + raisonSocial + ", sigle=" + sigle + ", siegeSocial=" + siegeSocial + ", registreCommerce=" + registreCommerce + ", nomAbrege=" + nomAbrege + ", codeStatistique=" + codeStatistique + ", natureJuridique=" + natureJuridique + ", dateCreation=" + dateCreation + ", objetSocial=" + objetSocial + ", fax=" + fax + ", telephone1=" + telephone1 + ", telephone2=" + telephone2 + ", telephone3=" + telephone3 + ", email=" + email + ", section=" + section + ", division=" + division + ", groupe=" + groupe + ", classe=" + classe + ", precisionDatenaissance=" + precisionDatenaissance + ", designation=" + designation + ", montant=" + montant + ", sens=" + sens + ", devise=" + devise + ", dateOperation=" + dateOperation + ", type=" + type + ", pays=" + pays + ", motif=" + motif + ", commentaire=" + commentaire + '}';
    }
    
    /**
     * 
     * @return 
     */
    public String[] toStringPP(){
        
        List<String> values = new ArrayList<String>();
        
        values.add(reference);values.add(qualite);values.add(titre);values.add(nom);values.add(prenom);values.add(dateNaissance);
        values.add(lieuNaissance);values.add(nomJeuneFille);values.add(nationalite);values.add(profession);values.add(natureClientele);
        values.add(statusResidence);values.add(adresse_1);values.add(adresse_2);values.add(adresse_3);values.add(boitepostale);
        values.add(ville);values.add(precisionDatenaissance);
        
        String[] datas = new String[values.size()];
        
        for(int index = 0 ; index<values.size();index++){
            datas[index] = values.get(index);
        }
        return datas;
    }
    
    /**
     * 
     * @return 
     */
    public String[] toStringPM(){
        
         List<String> values = new ArrayList<String>();
         
         values.add(reference);values.add(raisonSocial);values.add((sigle==null||sigle.trim().isEmpty()) ? raisonSocial:sigle);values.add(siegeSocial);values.add(registreCommerce);values.add(nomAbrege);
         values.add(codeStatistique);values.add(natureJuridique);values.add(dateCreation);values.add(natureClientele);values.add(objetSocial);
         values.add(statusResidence);values.add(adresse_1);values.add(adresse_2);values.add(adresse_3);values.add(boitepostale);
         values.add(ville);values.add(fax);values.add(telephone1);values.add(telephone2);values.add(telephone3);values.add(email);
         values.add(section);values.add(division);values.add(groupe);values.add(classe);
        
         String[] datas = new String[values.size()];
        
        for(int index = 0 ; index<values.size();index++){
            datas[index] = values.get(index);
        }
        return datas;
       
    }
    
    public String[] toStringOF(){
        
         List<String> values = new ArrayList<String>();
        
         values.add(reference);values.add(designation);values.add(montant);values.add(sens);values.add(devise);values.add(dateOperation);
         values.add(type);values.add(pays);values.add(motif);
         if(commentaire.length()>150){
             values.add(commentaire.substring(0, 149));
         }else{
             values.add(commentaire);
         }
         
         String[] datas = new String[values.size()];
        
        for(int index = 0 ; index<values.size();index++){
            datas[index] = values.get(index);
        }
        return datas;        
        
    }
}

