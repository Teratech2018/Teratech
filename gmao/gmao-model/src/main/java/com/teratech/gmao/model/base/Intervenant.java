/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.base;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_TIER")
public class Intervenant extends BaseElement implements Serializable,Comparable<Intervenant>{

    
    @Predicate(label = "image",target = "image")
    private String image ;
    
    @Predicate(label = "Actif",type = Boolean.class,search = false)
    private Boolean active = true;
     
    @Predicate(label = "N° de compte",unique = true,optional = false,updatable = false,search = true)
    private String code ;
    
    @Predicate(label = "Type",unique = true,optional = false,updatable = false,target = "combobox",values = "Client;Fournisseur;Salarié;Autre",search = false)
    private String type ;
    
    @Predicate(label = "Intitulé",search = true)
    private String label ;
    
    @Predicate(label = "Socièté",type = Entreprise.class,target = "many-to-one",search = true)
    @ManyToOne
    @JoinColumn(name = "SOC_ID")
    private Entreprise societe;

    @ManyToOne
    @JoinColumn(name = "CLAS_ID")
    @Predicate(label = "Classe Horaire",type = Classe.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Compléments")
    private Classe classe ;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "T_INTEQUAGM",joinColumns = @JoinColumn(name = "INT_ID"),inverseJoinColumns = @JoinColumn(name = "QUA_ID"))
    @Predicate(label = "Qualifications",type = Qualification.class,target = "many-to-many",group = true,groupName = "group1",groupLabel = "Compléments")
    private List<Qualification> qualifications = new ArrayList<Qualification>();
    
    @ManyToOne
    @JoinColumn(name = "CF_ID")
    @Predicate(label = "Centre de frais",type = CentreFrais.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Compléments")
    private CentreFrais centre ;
    
    @ManyToOne
    @JoinColumn(name = "FAM_ID")
    @Predicate(label = "Famille",type = FamilleArticle.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Compléments")
    private FamilleArticle famille ;
    
    @ManyToOne
    @JoinColumn(name = "RES_ID")
    @Predicate(label = "Responsable",type = Intervenant.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Compléments")
    private Intervenant responsable ;
    
    @ManyToOne
    @JoinColumn(name = "FOU_ID")
    @Predicate(label = "Fournisseur",type = Intervenant.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Compléments")
    private Intervenant fournisseur ;
    
    @Predicate(label = "Adresse",group = true,groupName = "group2",groupLabel = "Adresse")
    private String adresse;
    
    @Predicate(label = "Poste Occupé",group = true,groupName = "group2",groupLabel = "Adresse")
    private String poste;
    
    @Predicate(label = "Téléphone",group = true,groupName = "group2",groupLabel = "Adresse",target = "tel")
    private String tel;
    
    @Predicate(label = "Mobile",group = true,groupName = "group2",groupLabel = "Adresse",target = "tel")
    private String mobile;
    
    @Predicate(label = "Fax",group = true,groupName = "group2",groupLabel = "Adresse")
    private String fax;
    
    @Predicate(label = "Courriel",group = true,groupName = "group2",groupLabel = "Adresse",target = "email")
    private String courriel;
    
   
    public Intervenant() {
    }

    public Intervenant(String image, String code, String type, String label, Entreprise societe, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.image = image;
        this.code = code;
        this.type = type;
        this.label = label;
        this.societe = societe;
    }
    
    public Intervenant(Intervenant inter) {
        super(inter.id, inter.designation, inter.moduleName, inter.compareid);
        this.image = inter.image;
        this.code = inter.code;
        this.type = inter.type;
        this.label = inter.label;
        if(inter.societe!=null){
            this.societe = new Entreprise(inter.societe);
        }
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Entreprise getSociete() {
        return societe;
    }

    public void setSociete(Entreprise societe) {
        this.societe = societe;
    }

    public CentreFrais getCentre() {
        return centre;
    }

    public void setCentre(CentreFrais centre) {
        this.centre = centre;
    }

    public FamilleArticle getFamille() {
        return famille;
    }

    public void setFamille(FamilleArticle famille) {
        this.famille = famille;
    }

    public Intervenant getResponsable() {
        return responsable;
    }

    public void setResponsable(Intervenant responsable) {
        this.responsable = responsable;
    }

    public Intervenant getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Intervenant fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }    

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
    

    @Override
    public String getDesignation() {
        return code+" - "+label; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechgmao"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Intervenants"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Intervenant"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public int compareTo(Intervenant o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }
    
}
