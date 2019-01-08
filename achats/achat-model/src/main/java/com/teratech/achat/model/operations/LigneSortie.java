/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.operations;

import com.megatim.common.annotations.Predicate;
import com.teratech.achat.model.base.Article;
import com.teratech.achat.model.base.UniteGestion;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author BEKO
 */
@Entity
@DiscriminatorValue("OUT")
public class LigneSortie extends LigneDocumentStock implements Serializable{

    @Predicate(label = "N° Série/Lot",search = true,editable = false)
    private String code ;
//    @Predicate(label = "N° lot/série",type = Lot.class,target = "many-to-one",optional = true,unique = true,search = true)
    @ManyToOne
    @JoinColumn(name = "LOT_ID")
//    @Filter(value = "[{\"fieldName\":\"lien\",\"value\":\"object.emplacement\",\"searchfield\":\"id\",\"optional\":false,\"message\":\"Veuillez sélectionner l'emplacement\"}]")
    private Lot lot ;
    
    @ManyToOne
    @JoinColumn(name = "SRC_ID")
    private LigneEntree source ;
    
    public LigneSortie(Article article, UniteGestion unite, Double puht, Double quantite, Double punet, String code, Date peremption, Date fabrication, Double totalht) {
        super(article, unite, puht, quantite, punet, code, peremption, fabrication, totalht);
    }

    public LigneSortie(Article article, UniteGestion unite, Double puht, Double quantite, Double punet, String code, Date peremption, Date fabrication, Double totalht, long id, String designation, String moduleName) {
        super(article, unite, puht, quantite, punet, code, peremption, fabrication, totalht, id, designation, moduleName);
    }

    public LigneSortie(LigneSortie ligne) {
        super(ligne);
        if(ligne.lot!=null){
            this.lot = new Lot(ligne.lot);
        }
        if(ligne.source!=null){
            this.source = new LigneEntree(ligne.source);
        }
        this.code = ligne.code;
    }
    
     public LigneSortie(LigneEntree ligne) {
        super(ligne);
        this.id = -1;
        if(ligne.getLot()!=null){
            this.lot = new Lot(ligne.getLot());
        }
        this.source = ligne;
        this.quantite = ligne.disponible();
        this.code = ligne.getCode();
    }

    public LigneSortie(LigneDocumentAchat ligne) {
        super(ligne);
    }

    public LigneSortie() {
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LigneEntree getSource() {
        return source;
    }

    public void setSource(LigneEntree source) {
        this.source = source;
    }
    
    

    @Override
    public String getListTitle() {
        return "Articles"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
