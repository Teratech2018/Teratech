/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.posweb.model;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_CMDEPOS")
public class Commande extends BaseElement implements Serializable,Comparable<Commande>{

    @Predicate(label = "Reference",optional = false,search = true)
    private String code ;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Date commande",type = Date.class,target = "date",search = true)
    private Date datecmde ;
    
    @ManyToOne
    @JoinColumn(name = "SESS_ID")
    @Predicate(label = "Session",type = PosSession.class,target = "many-to-one",search = true)
    private PosSession session ;
    
    @ManyToOne
    @JoinColumn(name = "CLIE_ID")
    @Predicate(label = "Client",type = Client.class,target = "many-to-one",search = true)    
    private Client client ;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval =true )
    @JoinColumn(name = "CMDE_ID")
    @Predicate(label = " ",type = LigneCommande.class,target = "one-to-many",group = true,groupName = "articles",groupLabel = "Articles")
    private List<LigneCommande>  lignes = new ArrayList<LigneCommande>();

    public Commande() {
    }

    public Commande(Commande entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.datecmde = entity.datecmde;
        if(entity.session!=null){
            this.session = new PosSession(entity.session);
        }
        if(entity.client!=null){
            this.client = client;
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDatecmde() {
        return datecmde;
    }

    public void setDatecmde(Date datecmde) {
        this.datecmde = datecmde;
    }

    public PosSession getSession() {
        return session;
    }

    public void setSession(PosSession session) {
        this.session = session;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<LigneCommande> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneCommande> lignes) {
        this.lignes = lignes;
    }

    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "posweb"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Commandes"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Commande"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(Commande o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }
    
}
