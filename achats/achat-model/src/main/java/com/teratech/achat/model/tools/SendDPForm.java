/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.tools;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.achat.model.operations.DemandePrix;
import java.io.Serializable;
import javax.persistence.Lob;

/**
 *
 * @author BEKO
 */
public class SendDPForm extends BaseElement implements Serializable,Comparable<SendDPForm>{

    @Predicate(label = "DEMANDEPR",search = true,editable = false,type = DemandePrix.class,target = "many-to-one")
    private DemandePrix demande ;
    
    @Predicate(label = "Concerne",target = "richeditor",group = true,groupName = "group1",groupLabel = "MESSAGE")
    @Lob
    private String message ;
    
    
//    @ManyToMany
//    @Predicate(label = " ",type = Tier.class,target = "many-to-many-list",group = true,groupName = "group1",groupLabel = "FOURNISSEURS")
//    @Filter(value = "[{\"fieldName\":\"type\",\"value\":\"1\"}]")
//    private List<Tier> forunisseurs = new ArrayList<Tier>();

    public DemandePrix getDemande() {
        return demande;
    }

    public void setDemande(DemandePrix demande) {
        this.demande = demande;
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
    public int compareTo(SendDPForm o) {
        //To change body of generated methods, choose Tools | Templates.
        return 0;
    }
    
}
