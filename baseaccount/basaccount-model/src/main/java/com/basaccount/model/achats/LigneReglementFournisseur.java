/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basaccount.model.achats;

import com.core.base.BaseElement;
import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author BEKO
 */
@Entity
public class LigneReglementFournisseur extends BaseElement implements Serializable,Comparable<LigneReglementFournisseur>{

    @Override
    public int compareTo(LigneReglementFournisseur o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
