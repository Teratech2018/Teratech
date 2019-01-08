/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.operations;

import com.megatim.common.annotations.Predicate;
import com.teratech.stock.model.base.Emplacement;
import com.teratech.stock.model.base.Entrepot;
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
@DiscriminatorValue("INOUT")
public class Transfert extends DocumentStock implements Serializable{

    @Predicate(label = "Référence",search = true)
    private String reference ;
    
    @Predicate(label = "Type document",target = "combobox",values = "Mouvement du stock(articles,equipements,...);Autres",hide = true)
    private String nature = "0";
    
    @ManyToOne
    @JoinColumn(name = "ENTR_ID")
    @Predicate(label = "Entrepôt source ",type = Entrepot.class,target = "many-to-one",optional = false,nullable = false,search = true)
    private Entrepot source ;
    
    @ManyToOne
    @JoinColumn(name = "ENTR2_ID")
    @Predicate(label = "Entrepôt cible ",type = Entrepot.class,target = "many-to-one",optional = false,nullable = false,search = true)
    private Entrepot cible ;
    
     @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "INOUT_ID")
    @Predicate(label = " ",type = LigneTransfert.class,target = "one-to-many",group =true ,groupName = "group1",groupLabel = "Articles",edittable = true)
    private List<LigneTransfert> lignes = new ArrayList<LigneTransfert>();
    /**
     * 
     * @param code
     * @param date
     * @param depot
     * @param reference
     * @param commentaire 
     */
    public Transfert(String code, Date date, Emplacement depot, String reference, String commentaire) {
        super(code, date, depot, reference, commentaire);
        this.state = "etabli";
    }

    /**
     * 
     * @param reference
     * @param source
     * @param cible
     * @param doc 
     */
    public Transfert(String reference, Entrepot source, Entrepot cible, DocumentStock doc) {
        super(doc);
        this.reference = reference;
        this.source = source;
        this.cible = cible;
    }

    

    public Transfert(Transfert doc) {
        super(doc);
        this.state = doc.getState();
        this.reference = doc.reference;
        if(doc.source!=null){
            this.source = new Entrepot(doc.source);
        }
        if(doc.cible!=null){
            this.cible = new Entrepot(doc.cible);
        }
    }
    
    

    /**
     * 
     */
    public Transfert() {
        this.state = "etabli";
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public Entrepot getSource() {
        return source;
    }

    public void setSource(Entrepot source) {
        this.source = source;
    }

    public Entrepot getCible() {
        return cible;
    }

    public void setCible(Entrepot cible) {
        this.cible = cible;
    }

    public List<LigneTransfert> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneTransfert> lignes) {
        this.lignes = lignes;
    }

   

    @Override
    public String getEditTitle() {
        return "TRANSFERTD"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "TRANSFERTL"; //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActivefilelien() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActivatefollower() {
        return true; //To change body of generated methods, choose Tools | Templates.
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
