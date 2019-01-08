/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.vente.model.others;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.vente.model.operations.Devis;
import com.teratech.vente.model.operations.Facture;
import java.io.Serializable;
import javax.persistence.Lob;

/**
 *
 * @author BEKO
 */
public class SendDevisForm extends BaseElement implements Serializable,Comparable<SendDevisForm>{

    @Predicate(label = "Devis",search = true,editable = false,type = Devis.class,target = "many-to-one",hidden = "temporalData.devis==null")
    private Devis devis ;
    
    @Predicate(label = "Facture Client",search = true,editable = false,type = Facture.class,target = "many-to-one",hidden = "temporalData.facture==null")
    private Facture facture ;
    
    @Predicate(label = "Concerne",target = "richeditor",group = true,groupName = "group1",groupLabel = "MESSAGE")
    @Lob
    private String message ;
    
    
//    @ManyToMany
//    @Predicate(label = " ",type = Tier.class,target = "many-to-many-list",group = true,groupName = "group1",groupLabel = "FOURNISSEURS")
//    @Filter(value = "[{\"fieldName\":\"type\",\"value\":\"1\"}]")
//    private List<Tier> forunisseurs = new ArrayList<Tier>();

    public Devis getDevis() {
        return devis;
    }

    public void setDevis(Devis devis) {
        this.devis = devis;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
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
    public int compareTo(SendDevisForm o) {
        //To change body of generated methods, choose Tools | Templates.
        return 0;
    }
    
}
