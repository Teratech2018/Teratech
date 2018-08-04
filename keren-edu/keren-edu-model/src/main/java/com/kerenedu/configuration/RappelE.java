/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;

/**
 * @author Nadege
 *
 */
@Entity
@Table(name = "T_RAPPEL")
public class RappelE extends BaseElement implements Serializable,Comparable<RappelE>{

    private String titre ;
    
    /**
     * Unite de temps pour le rappel
     * 0 = aucun , 1 = heure , 2 = minutes , 3 = Jour(s)
     */
    private short unite ;
    
    private short quantite  ;

    /**
     * 
     */
    public RappelE() {
    }

    /**
     * 
     * @param titre
     * @param unite
     * @param quantite 
     */
    public RappelE(String titre, short unite, short quantite) {
        this.titre = titre;
        this.unite = unite;
        this.quantite = quantite;
    }
    
    public RappelE(RappelE r) {
        this.titre =r.titre;
        this.unite =r.unite;
        this.quantite =r.quantite;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public short getUnite() {
        return unite;
    }

    public void setUnite(short unite) {
        this.unite = unite;
    }

    public short getQuantite() {
        return quantite;
    }

    public void setQuantite(short quantite) {
        this.quantite = quantite;
    }

    @Override
    public String getDesignation() {
        return titre; //To change body of generated methods, choose Tools | Templates.
    }

	public int compareTo(RappelE o) {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
   
    
}