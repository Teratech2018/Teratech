/**
 * 
 */
package com.keren.kerenpaie.model.comptabilite;

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

import com.core.base.BaseElement;
import com.core.referentiels.Societe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_Compte")
public class Compte extends BaseElement implements Serializable, Comparable<Compte> {

    /**
     * 
     */
    private static final long serialVersionUID = -9208634470819249675L;

    @Predicate(label = "N° de compte",unique = true,optional = false,updatable = false,search = true)
    private String code ;
    
    @Predicate(label = "Intitulé",search = true)
    private String libele ;
    
    @Predicate(label = "Type de Compte",target = "combobox",values = "Detail;Total",search = false)
    private String type ="0";
    
    @Predicate(label = "Nature de compte",target = "combobox",values = "Aucune;Client;Fournisseur;Salarié;Banque;Caisse;Amorts/Provision;Resultat de gestion;Immobilisation;Capitaux;Stock;Titre",search = false)
    private String nature ="0";    
    
    
    @Predicate(label = "Code Taxe" ,target = "many-to-one",type = Taxe.class,search = false)
    @ManyToOne
    @JoinColumn(name = "TAXE_ID")
    private Taxe taxe ;
    
    @Predicate(label = "Report-à-nouveau",target = "combobox",values = "Aucune;Solde;Detail",search = false)
    private String reportdesanouveau = "0";
   
    @Predicate(label = "Lettrage",target = "combobox",values = "Automatique;Manuel")
    private String lettrage = "0";
   
    @Predicate(label = "Analytique" ,group = true,groupLabel = "Analytique",groupName = "group1",type = SectionAnalytique.class,target = "one-to-many",optional = true)
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "CPTE_ID")
    private List<SectionAnalytique> analytiques = new ArrayList<SectionAnalytique>();
   
    @Predicate(label = "Bloc-notes",group = true,groupLabel = "Bloc-notes",groupName = "group2",target = "textarea",search = false)
    private String note ;

	/**
	 * 
	 */
	public Compte() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Compte(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	public Compte(Compte compte) {
        super(compte.id, compte.designation, compte.moduleName,compte.compareid);
        this.code = compte.code;
        this.libele = compte.libele;        
        this.note = compte.note;
        this.type = compte.type;
        if(compte.taxe!=null){
        	this.taxe = new Taxe(compte.taxe);
        }
        nature = compte.nature;
        reportdesanouveau = compte.getReportdesanouveau();
        lettrage = compte.getLettrage();
    }
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibele() {
		return libele;
	}

	public void setLibele(String libele) {
		this.libele = libele;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	

	public Taxe getTaxe() {
		return taxe;
	}

	public void setTaxe(Taxe taxe) {
		this.taxe = taxe;
	}

	public String getReportdesanouveau() {
		return reportdesanouveau;
	}

	public void setReportdesanouveau(String reportdesanouveau) {
		this.reportdesanouveau = reportdesanouveau;
	}

	public String getLettrage() {
		return lettrage;
	}

	public void setLettrage(String lettrage) {
		this.lettrage = lettrage;
	}

	public List<SectionAnalytique> getAnalytiques() {
		return analytiques;
	}

	public void setAnalytiques(List<SectionAnalytique> analytiques) {
		this.analytiques = analytiques;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "COMPTE";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "COMPTES";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" - "+libele;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Compte o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
