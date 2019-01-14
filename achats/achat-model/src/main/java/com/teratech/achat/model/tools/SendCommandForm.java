/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.tools;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.achat.model.operations.BonCommande;
import com.teratech.achat.model.operations.DemandePrix;
import java.io.Serializable;
import javax.persistence.Lob;

/**
 *
 * @author BEKO
 */
public class SendCommandForm extends BaseElement implements Serializable,Comparable<SendCommandForm>{

    @Predicate(label = "DEMANDEPR",search = true,editable = false,type = BonCommande.class,target = "many-to-one")
    private BonCommande commande ;
    
    @Predicate(label = "Concerne",target = "richeditor",group = true,groupName = "group1",groupLabel = "MESSAGE")
    @Lob
    private String message ;
    
    
//    @ManyToMany
//    @Predicate(label = " ",type = Tier.class,target = "many-to-many-list",group = true,groupName = "group1",groupLabel = "FOURNISSEURS")
//    @Filter(value = "[{\"fieldName\":\"type\",\"value\":\"1\"}]")
//    private List<Tier> forunisseurs = new ArrayList<Tier>();

    public BonCommande getCommande() {
        return commande;
    }

    public void setCommande(BonCommande commande) {
        this.commande = commande;
    }   
    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

   

    @Override
    public String getOwnermodule() {
        return "teratechachat"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechachat"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "SENDMAIL"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(SendCommandForm o) {
        //To change body of generated methods, choose Tools | Templates.
        return 0;
    }
    
}
