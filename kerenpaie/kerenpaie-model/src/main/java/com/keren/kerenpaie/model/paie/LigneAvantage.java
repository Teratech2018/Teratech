/**
 * 
 */
package com.keren.kerenpaie.model.paie;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_LIAVRH")
public class LigneAvantage extends BaseElement implements Serializable, Comparable<LigneAvantage> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Predicate(label = "Type Avantage",target = "combobox",values = "Eau;Logement;Electricité;Domestiques;Vehicules;Nourriture",editable = false,updatable = false,search = true)
	private String type ="0";
        
        @Predicate(label = "Statut",type = Boolean.class,search = true)
        private Boolean statut = Boolean.FALSE;

        @Predicate(label = "Mode Reglèment",target = "combobox",values = "Espèce;Nature",search = true)
        private String mode ="0";
        
        @Predicate(label = "Quantité",type = Short.class,search = true)
        private Short quantite = 0 ;
        
        
        /**
         * 
         * @param type
         * @param statut
         * @param mode
         * @param qte 
         */
        public LigneAvantage(String type, Boolean statut,String mode,Short qte) {
		// TODO Auto-generated constructor stub
            super(-1, null, null, 0L);
            this.type = type ;
            this.mode = mode ;
            this.statut = statut;
            this.quantite = qte ;
	}
	/**
	 * 
	 */
	public LigneAvantage() {
		// TODO Auto-generated constructor stub
	}
        
       /**
        * 
        * @param ligne 
        */
	public LigneAvantage(LigneAvantage ligne) {
		// TODO Auto-generated constructor stub
            super(ligne.id, ligne.designation, ligne.moduleName, ligne.compareid);
            this.type = ligne.type;
            this.statut = ligne.statut;
            this.mode = ligne.mode;
            this.quantite = ligne.quantite;
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param compareid
	 */
	public LigneAvantage(long id, String designation, String moduleName, long compareid) {
		super(id, designation, moduleName, compareid);
		// TODO Auto-generated constructor stub
	}

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Boolean getStatut() {
            return statut;
        }

        public void setStatut(Boolean statut) {
            this.statut = statut;
        }

        public String getMode() {
            return mode;
        }

        public void setMode(String mode) {
            this.mode = mode;
        }

        public Short getQuantite() {
            return quantite;
        }

        public void setQuantite(Short quantite) {
            this.quantite = quantite;
        }    

    @Override
    public boolean isDesabledelete() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesablecreate() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }
        
        
        

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(LigneAvantage arg0) {
		// TODO Auto-generated method stub
		return type.compareTo(arg0.type);
	}

}
