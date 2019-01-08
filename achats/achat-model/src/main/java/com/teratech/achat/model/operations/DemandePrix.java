/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.operations;

import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;
import com.teratech.achat.model.base.ConditionPaiement;
import com.teratech.achat.model.base.Tier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_DP_ACH")
public class DemandePrix extends BaseElement implements Serializable{

    @Predicate(label = "Reference",optional = false,unique = true,search = true)
    private String code ;
    
    @Temporal(TemporalType.DATE)
    @Predicate(label = "Date",type = Date.class,target = "date",search = true)
    private Date date ;   
    
    
//    @ManyToOne
//    @JoinColumn(name = "CORE_ID")
//    @Predicate(label = "Conditions de règlement",type = ConditionPaiement.class,target = "many-to-one",group = true,groupName = "group3",groupLabel = "Livraison&Factures")
//    private ConditionPaiement condreglement ;
   
    @Predicate(label = "STATE",search = true,hide = true)
    private String state="etabli";
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "DP_ID")
    @Predicate(label = "ARTICLES " ,type = LigneDemandePrix.class,target = "one-to-many",group = true,groupName = "group1",groupLabel = " ",edittable = true)
    private List<LigneDemandePrix> articles = new ArrayList<LigneDemandePrix>();
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "T_TIER_DP_ACH",joinColumns = @JoinColumn(name = "DP_ID"),inverseJoinColumns = @JoinColumn(name = "TIER_ID"))
    @Predicate(label = "FOURNISSEURS",type = Tier.class,target = "many-to-many-list",group = true,groupName = "group1",groupLabel = " ")
    @Filter(value = "[{\"fieldName\":\"type\",\"value\":\"1\"}]")
    private List<Tier> fournisseurs = new ArrayList<Tier>();
    
    
    public DemandePrix() {
        
    }

    /**
     * 
     * @param code
     * @param date
     * @param condreglement
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public DemandePrix(String code, Date date, ConditionPaiement condreglement, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.date = date;
//        this.condreglement = condreglement;
    }

   public DemandePrix(DemandePrix entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.date = entity.date;    
        this.state = entity.getState();
    }

//    public ConditionPaiement getCondreglement() {
//        return condreglement;
//    }
//
//    public void setCondreglement(ConditionPaiement condreglement) {
//        this.condreglement = condreglement;
//    }
//    
    
    public String getState() {
        return state;
    }

    
    public void setState(String state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<LigneDemandePrix> getArticles() {
        return articles;
    }

    public void setArticles(List<LigneDemandePrix> articles) {
        this.articles = articles;
    }

    public List<Tier> getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(List<Tier> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    

    @Override
    public boolean isActivatefollower() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<State> getStates() {
        List<State> s = new ArrayList<>();
        State stat = new State("etabli", "Edité");
        stat.setIcone("fa fa-circle");
        stat.setCouleur("#d9534f");
        s.add(stat);
//        state = new State("envoye", "Envoyée au fornisseur");
//        states.add(state);
        stat = new State("transmi", "Transmi");
        stat.setIcone("fa fa-circle");
        stat.setCouleur("#008b8b");
        s.add(stat);
        stat = new State("cloture", "Terminé");
        stat.setIcone("fa fa-circle");
        stat.setCouleur("#d5575e");
        s.add(stat);
//        state = new State("termine", "Terminée");
//        states.add(state);
        return s; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOwnermodule() {
        return "teratechachat"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesableupdate() {
        return !"etabli".equals(state); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesabledelete() {
        return !"etabli".equals(state); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesablecreate() {
        return !"etabli".equals(state); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getCompareid() {
        return id; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public String getModuleName() {
        return "teratechachat"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSearchkeys() {
        return super.getSearchkeys(); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public boolean isActivefilelien() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSerial() {
        return "dp270220181057"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "DEMANDEPRIXL"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "DEMANDEPRIXD"; //To change body of generated methods, choose Tools | Templates.
    }
     
     
    
}
