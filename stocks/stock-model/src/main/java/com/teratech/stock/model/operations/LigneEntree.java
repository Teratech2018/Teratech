/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.operations;

import com.core.base.State;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;
import com.teratech.stock.model.base.LienEmplacement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author BEKO
 */
@Entity
@DiscriminatorValue("IN")
public class LigneEntree extends LigneDocumentStock implements Serializable{
    
    @Predicate(label = "PU HT",type = Double.class,optional = false,search = true)
    @Observer(observable = "article" ,source = "field:uniteachat")
    private Double puht ;
    
    @ManyToOne
    @JoinColumn(name = "LIEMP_ID")
    @Predicate(label = "Emplacement cible",type = LienEmplacement.class,target = "many-to-one",search = true,optional = false)
    @Filter(value = "[{\"fieldName\":\"article\",\"value\":\"object.article\",\"searchfield\":\"code\",\"optional\":false,\"message\":\"Veuillez selectionner l'article\"},{\"fieldName\":\"entrpot\",\"value\":\"this.entrepot\",\"searchfield\":\"code\",\"optional\":false,\"message\":\"Veuillez selectionner le magasin\"}]")
    private LienEmplacement emplacement ;    
    
    
//    @Predicate(label = "PU Net",type = Double.class,optional = false,editable = false)
    private Double punet ;
    
    @Predicate(label = "N° lot/série",optional = true,unique = true,search = true)
    private String code ;
    
    @Predicate(label = "Péremption",type = Date.class,target = "date",search = true)
    @Temporal(TemporalType.DATE)
    private Date peremption ;
    
    @Predicate(label = "Fabrication",type = Date.class,target = "date",search = true)
    @Temporal(TemporalType.DATE)
    private Date fabrication ;
    
    @Predicate(label = "Total HT",type = Double.class,optional = false,search = true,hide = true,compute = true,values ="this.puht;*;this.quantite" )
    private Double totalht ;  
    
    @OneToOne
    @JoinColumn(name = "LOT_ID")
//    @Predicate(label = "Lot/Serie",type = Lot.class,target = "one-to-one",search = true)
    private Lot lot ;

    /**
     * 
     */
    public LigneEntree() {
    }

    public LigneEntree(LigneEntree entity) {
        super(entity);
        this.puht = entity.puht;
        if(entity.emplacement!=null){
            this.emplacement = new LienEmplacement(entity.emplacement);
        }
        this.punet = entity.punet;
        this.code = entity.code;
        this.peremption = entity.peremption;
        this.fabrication = entity.fabrication;
        this.totalht = entity.totalht;
    }

    public Double getPuht() {
        return puht;
    }

    public void setPuht(Double puht) {
        this.puht = puht;
    }

    public LienEmplacement getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(LienEmplacement emplacement) {
        this.emplacement = emplacement;
    }

    public Double getPunet() {
        return punet;
    }

    public void setPunet(Double punet) {
        this.punet = punet;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getPeremption() {
        return peremption;
    }

    public void setPeremption(Date peremption) {
        this.peremption = peremption;
    }

    public Date getFabrication() {
        return fabrication;
    }

    public void setFabrication(Date fabrication) {
        this.fabrication = fabrication;
    }

    public Double getTotalht() {
        return totalht;
    }

    public void setTotalht(Double totalht) {
        this.totalht = totalht;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
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
        return super.getListTitle(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return super.getEditTitle(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public String getSearchkeys() {
        return super.getSearchkeys(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
