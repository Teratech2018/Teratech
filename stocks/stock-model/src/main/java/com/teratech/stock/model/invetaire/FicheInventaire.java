/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.invetaire;

import com.core.base.State;
import com.teratech.stock.model.base.Emplacement;
import com.teratech.stock.model.base.Entrepot;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author BEKO
 */
@Entity
@DiscriminatorValue("ETA")
public class FicheInventaire extends BaseInventaire implements Serializable{

    public FicheInventaire(String code, Date date, Entrepot fentrepot, Emplacement femplacement) {
        super(code, date, fentrepot, femplacement);
    }

    public FicheInventaire(String code, Date date, Entrepot fentrepot, Emplacement femplacement, long id, String designation, String moduleName) {
        super(code, date, fentrepot, femplacement, id, designation, moduleName);
    }

    public FicheInventaire() {
    }

    public FicheInventaire(FicheInventaire base) {
        super(base);
    }
    
    

    @Override
    public List<State> getStates() {
        List<State> states = new ArrayList<State>();
        State state = new State("etabli", "Brouillon");
        states.add(state);
        state = new State("confirme", "En cours");
        states.add(state);
        return states; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
