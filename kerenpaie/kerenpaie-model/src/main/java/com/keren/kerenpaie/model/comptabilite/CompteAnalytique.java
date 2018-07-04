/**
 * 
 */
package com.keren.kerenpaie.model.comptabilite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.referentiels.Societe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name = "T_CANALYTIQUE")
public class CompteAnalytique extends BaseElement implements Serializable, Comparable<CompteAnalytique> {

    /**
     * 
     */
    private static final long serialVersionUID = -5131765886595965642L;

    @Predicate(label = "N° de compte",unique = true,optional = false,updatable = false,search = true)
    private String code ;
    
    @Predicate(label = "Intitulé",search = true)
    private String label ;
    
    @Predicate(label = "Type de compte",target ="combobox" ,values ="Détail;Total" ,search = false)
    private String type ="0";
    
    @Predicate(label = "Classement",search = true)
    private String classe;
    
    @Predicate(label = "Report-à-nouveau" , type = Boolean.class,search = false, optional = true)
    private Boolean reportANouveau = false;
    
    @Predicate(label = "Actif" , type = Boolean.class,search = false, optional = true)
    private Boolean active = true ;
    
    @Predicate(label = "Niveau d'analyse",type = NiveauAnalyse.class,target = "many-to-one",search = true)
    @ManyToOne
    @JoinColumn(name = "NA_ID")
    private NiveauAnalyse niveau ;
    
       
    @Predicate(label = "Bloc-notes",group = true,groupLabel = "Bloc-notes",groupName = "group2",target = "textarea",search = false)
    private String note ;
    
	/**
	 * 
	 */
	public CompteAnalytique() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public CompteAnalytique(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	public CompteAnalytique(CompteAnalytique compte) {
        super(compte.id, compte.designation, compte.moduleName,compte.compareid);
        this.code = compte.code;
        this.label = compte.label;
        type = compte.type;
        this.classe = compte.classe;
        reportANouveau = compte.reportANouveau;
        this.niveau = compte.niveau;
        this.active = compte.active;
        this.note = compte.note;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public Boolean getReportANouveau() {
		return reportANouveau;
	}

	public void setReportANouveau(Boolean reportANouveau) {
		this.reportANouveau = reportANouveau;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public NiveauAnalyse getNiveau() {
		return niveau;
	}

	public void setNiveau(NiveauAnalyse niveau) {
		this.niveau = niveau;
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
		return "COMPTE ANALYTIQUE";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "COMPTES ANALYTIQUES";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" - "+label;
	}

	@Override
	public int compareTo(CompteAnalytique o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
