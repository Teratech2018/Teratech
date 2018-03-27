/**
 * 
 */
package com.keren.model.comptabilite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name = "T_SANALYTIQUE")
public class SectionAnalytique extends BaseElement implements Serializable, Comparable<SectionAnalytique> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6477707252810770511L;
	
	@Predicate(label = "Section Analytique",type = CompteAnalytique.class,target = "many-to-one",search = true,sequence = 1,colsequence = 1)
    @ManyToOne
    @JoinColumn(name = "CA_ID")
    private CompteAnalytique compte ;    
    
    @Predicate(label = "Valeur",type = Double.class,optional = false,search = true,sequence = 2,colsequence = 3)
    private Double quantite ;
    
    @Predicate(label = "Clé de repartition" ,target = "combobox",values = "Pourcentage;Equilibre;Montant",search = true,sequence = 3,colsequence = 2)
    private String type ="0";
	    

	/**
	 * 
	 */
	public SectionAnalytique() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public SectionAnalytique(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	public SectionAnalytique(SectionAnalytique section) {
        super(section.id, section.designation, section.moduleName);
        this.compte = new CompteAnalytique(section.compte);
        this.type = section.getType();
        this.quantite = section.quantite;
    }

	public CompteAnalytique getCompte() {
		return compte;
	}

	public void setCompte(CompteAnalytique compte) {
		this.compte = compte;
	}

	public Double getQuantite() {
		return quantite;
	}

	public void setQuantite(Double quantite) {
		this.quantite = quantite;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "SECTION ANALYTIQUE";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "SECTIONS ANALYTIQUES";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return compte.getDesignation();
	}

	@Override
	public int compareTo(SectionAnalytique o) {
		// TODO Auto-generated method stub
		return compte.compareTo(o.compte);
	}

}
