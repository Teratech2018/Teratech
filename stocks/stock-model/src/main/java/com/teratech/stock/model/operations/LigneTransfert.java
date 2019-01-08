/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.operations;

import com.core.base.State;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;
import com.teratech.stock.model.base.LienEmplacement;
import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author BEKO
 */
@Entity
@DiscriminatorValue("INOUT")
public class LigneTransfert extends LigneDocumentStock implements Serializable{

    @ManyToOne
    @JoinColumn(name = "LIEMP_ID")
    @Predicate(label = "Emplacement source",type = LienEmplacement.class,target = "many-to-one",search = true,optional = false)
    @Filter(value = "[{\"fieldName\":\"article\",\"value\":\"object.article\",\"searchfield\":\"code\",\"optional\":false,\"message\":\"Veuillez selectionner l'article\"},{\"fieldName\":\"entrpot\",\"value\":\"this.source\",\"searchfield\":\"code\",\"optional\":false,\"message\":\"Veuillez selectionner le magasin\"}]")
    private LienEmplacement empsource;
    
    @Predicate(label = "N° lot/série",type = Lot.class,target = "many-to-one",optional = true,unique = true,search = true)
    @ManyToOne
    @JoinColumn(name = "LOT_ID")
    @Filter(value = "[{\"fieldName\":\"lien\",\"value\":\"object.empsource\",\"searchfield\":\"id\",\"optional\":false,\"message\":\"Veuillez sélectionner l'emplacement\"}]")
    private Lot lot ;
    
    @ManyToOne
    @JoinColumn(name = "LOT2_ID")
    private Lot lotcible ;
    
    @ManyToOne
    @JoinColumn(name = "LIEMP2_ID")
    @Predicate(label = "Emplacement cible",type = LienEmplacement.class,target = "many-to-one",search = true,optional = false)
    @Filter(value = "[{\"fieldName\":\"article\",\"value\":\"object.article\",\"searchfield\":\"code\",\"optional\":false,\"message\":\"Veuillez selectionner l'article\"},{\"fieldName\":\"entrpot\",\"value\":\"this.cible\",\"searchfield\":\"code\",\"optional\":false,\"message\":\"Veuillez selectionner le magasin\"}]")
    private LienEmplacement empcible ;
    
    public LigneTransfert() {
    }

    public LigneTransfert(LigneTransfert entity) {
        super(entity);
        if(entity.empsource!=null){
            this.empsource = new LienEmplacement(entity.empsource);
        }
        if(entity.lot!=null){
            this.lot = new Lot(entity.lot);
        }
        if(entity.lotcible!=null){
            this.lotcible = new Lot(entity.lotcible);
        }
        if(entity.empcible!=null){
            this.empcible = new LienEmplacement(entity.empcible);
        }
    }

    public LienEmplacement getEmpsource() {
        return empsource;
    }

    public void setEmpsource(LienEmplacement empsource) {
        this.empsource = empsource;
    }

    public LienEmplacement getEmpcible() {
        return empcible;
    }

    public void setEmpcible(LienEmplacement empcible) {
        this.empcible = empcible;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Lot getLotcible() {
        return lotcible;
    }

    public void setLotcible(Lot lotcible) {
        this.lotcible = lotcible;
    }

     

   
    @Override
    public String getOwnermodule() {
        return "teratechstock"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesableupdate() {
        return super.isDesableupdate(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActivatefollower() {
        return super.isActivatefollower(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<State> getStates() {
        return super.getStates(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActivefilelien() {
        return super.isActivefilelien(); //To change body of generated methods, choose Tools | Templates.
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
    public boolean isCreateonfield() {
        return super.isCreateonfield(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "TRANSFERTL"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSearchkeys() {
        return super.getSearchkeys(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
