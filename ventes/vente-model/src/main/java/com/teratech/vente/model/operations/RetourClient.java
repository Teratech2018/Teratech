/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.vente.model.operations;

import com.core.base.State;
import com.megatim.common.annotations.Predicate;
import com.teratech.vente.model.base.Entrepot;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author BEKO
 */
@Entity
@DiscriminatorValue("RC")
public class RetourClient extends DocumentStock implements Serializable{
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "RC_ID")
    @Predicate(label = " ",type = LIgneRetourClient.class,target = "many-to-many-list",group =true ,groupName = "group1",groupLabel = "Articles",edittable = true)
    private List<LIgneRetourClient> lignes = new ArrayList<LIgneRetourClient>();
    
    @ManyToOne
    @JoinColumn(name = "BL_ID")
    @Predicate(label = "Document source",type = BonLivraison.class,target = "many-to-one",group = true,groupName = "group2",groupLabel = "Complément")
    private BonLivraison livraison ;
    
    @Predicate(label = "Total HT",type = Double.class,search = true,hide = true,editable = false)
    private Double totalht = 0.0;

    public RetourClient() {
    }   
    

    /**
     * 
     * @param entity 
     */
    public RetourClient(RetourClient entity) {
        super(entity);
        if(entity.livraison!=null){
            this.livraison = new BonLivraison(entity.livraison);
        }
        this.totalht = entity.totalht;
    }

    public BonLivraison getLivraison() {
        return livraison;
    }

    public void setLivraison(BonLivraison livraison) {
        this.livraison = livraison;
    }

    public Double getTotalht() {
        return totalht;
    }

    public void setTotalht(Double totalht) {
        this.totalht = totalht;
    }

    public List<LIgneRetourClient> getLignes() {
        return lignes;
    }

    public void setLignes(List<LIgneRetourClient> lignes) {
        this.lignes = lignes;
    }

    @Override
    public List<State> getStates() {
        return super.getStates(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOwnermodule() {
        return "teratechvente"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesableupdate() {
        return super.isDesableupdate(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesabledelete() {
        return super.isDesabledelete(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesablecreate() {
        return super.isDesablecreate(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSearchkeys() {
        return super.getSearchkeys(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
