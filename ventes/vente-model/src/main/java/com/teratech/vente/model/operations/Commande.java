/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.vente.model.operations;

import com.core.base.State;
import com.megatim.common.annotations.Predicate;
import com.megatim.common.annotations.TableFooter;
import com.teratech.vente.model.base.Tier;
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
@DiscriminatorValue("CMDE")
public class Commande extends DocumentVente implements Serializable{

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "CMDE_ID")
    @Predicate(label = " ",type = LigneCommande.class,target = "one-to-many" ,group = true,groupName = "group1",groupLabel = "Articles",customfooter = true,edittable = true)
    @TableFooter(value = "<tr style='border:none;'><td></td><td></td><td></td><td></td><td'></td><td></td><td style='font-weight: bold;'>Total HT</td> <td class='text-center'>this.quantite;*;this.puht;*;(;100;-;this.remise;);/;100</td></tr> <tr style='border:none;'><td></td><td></td><td></td><td></td><td></td><td  style='font-weight: bold;'>Taxes</td><td  class='text-center'>(;this.quantite;*;this.puht;*;(;100;-;this.remise;);/;100;);*;{\"op\":\"sum\",\"source\":\"this\",\"data\":\"taxes\",\"field\":\"montant\"};/;100</td></tr> <tr style='border:none;'><td></td><td></td><td></td><td></td><td></td><td  style='font-weight: bold;'>Total TTC</td><td  class='text-center'  style='font-weight: bold;'>(;this.quantite;*;this.puht;*;(;100;-;this.remise;);/;100;);*;(;100;+;{\"op\":\"sum\",\"source\":\"this\",\"data\":\"taxes\",\"field\":\"montant\"};);/;100</td></tr>")
    private List<LigneCommande> lignes = new ArrayList<LigneCommande>();
    
    @ManyToOne
    @JoinColumn(name = "DEV_ID")
    @Predicate(label = "Document source",type = Devis.class,target = "many-to-one",group = true,groupName = "group2",groupLabel = "Complément" ,editable = false)
    private Devis devis ;
    
    private Double totaltaxes = 0.0;
    
    @Predicate(label = "Total HT",type = Double.class,search = true,hide = true)
    private Double totalht=0.0;
    
     @Predicate(label = "Total TTC",type = Double.class,search = true,hide = true)
    private Double totalttc = 0.0;
    
     @Predicate(label = " ",target = "state",hide = true,search = true)
     private String state ="etabli" ;
     
    public Commande(String code, Date date, Tier fornisseur, Date datecommande, String codefourni) {
        super(code, date, fornisseur, datecommande, codefourni);
    }

    public Commande(String code, Date date, Tier fornisseur, Date datecommande, String codefourni, long id, String designation, String moduleName) {
        super(code, date, fornisseur, datecommande, codefourni, id, designation, moduleName);
    }

    public Commande(DocumentVente da) {
        super(da);
        state ="etabli";
    }
    
    public Commande(Devis da) {
        super(da);
        this.devis = da;
    }
    
    public Commande(Commande da) {
        super(da);
        if(da.devis!=null){
            this.devis = new Devis(da.devis);
        }
        this.totalht = da.totalht;
        this.totalttc = da.totalttc;
        this.totaltaxes = da.totaltaxes;
        this.state = da.state;
    }

    public Commande() {
        state ="etabli";
    }

    public List<LigneCommande> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneCommande> lignes) {
        this.lignes = lignes;
    }

    public Devis getDevis() {
        return devis;
    }

    public void setDevis(Devis devis) {
        this.devis = devis;
    }

    public Double getTotaltaxes() {
        return totaltaxes;
    }

    public void setTotaltaxes(Double totaltaxes) {
        this.totaltaxes = totaltaxes;
    }

    

    public Double getTotalht() {
        return totalht;
    }

    public void setTotalht(double totalht) {
        this.totalht = totalht;
    }

    public Double getTotalttc() {
        return totalttc;
    }

    public void setTotalttc(double totalttc) {
        this.totalttc = totalttc;
    }
    
     public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean isDesableupdate() {
        return this.state.equalsIgnoreCase("confirme")
                ||this.state.equalsIgnoreCase("termine"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<State> getStates() {
        List<State> states = new ArrayList<State>();
        if(this.state.equalsIgnoreCase("etabli")){
            State stat = new State("etabli", "Brouillon");
            states.add(stat);
            stat= new State("confirme", "Confirmé");
            states.add(stat);
        }else if(this.state.equalsIgnoreCase("confirme")){
            State stat = new State("confirme", "Confirmé");
            states.add(stat);
            stat= new State("termine", "Terminé");
            states.add(stat);
        }else if(this.state.equalsIgnoreCase("termine")){
            State stat = new State("termine", "Terminé");
            states.add(stat);
        }
        return states; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesabledelete() {
         return this.state.equalsIgnoreCase("confirme")
                ||this.state.equalsIgnoreCase("termine");
    }

    @Override
    public boolean isDesablecreate() {
        return super.isDesablecreate(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "COMMANDES"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "COMMANDE"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSearchkeys() {
        return super.getSearchkeys(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
