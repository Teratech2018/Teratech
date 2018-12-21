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
import com.teratech.achat.model.base.Tier;
import com.teratech.achat.model.base.Utilisateur;
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
import javax.persistence.TemporalType;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_EXBE")
public class ExprBesion extends BaseElement implements Serializable,Comparable<ExprBesion>{

   @Predicate(label = "Référence",optional = false,nullable = false,search = true)
   private String code ;
    
   @ManyToOne
   @JoinColumn(name = "UTIL_ID")
   @Predicate(label = "Employé",type = Tier.class,target = "many-to-one",optional = false,nullable = false,search = true)
   @Filter(value = "[{\"fieldName\":\"type\",\"value\":\"1\"}]")
   private Tier utilisateur ;
   
   @Temporal(TemporalType.DATE)
   @Predicate(label = "Date Expression",type = Date.class,target = "date",optional = false,search = true)
   private Date dateExpr;
   
   @Predicate(label = "Moti",target = "textarea" , group = true,groupName = "group2",groupLabel = "MOTIVATION")
   private String motivation ;
   
   @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
   @JoinColumn(name = "EXBE_ID")
   @Predicate(label = "Moti",target = "one-to-many" ,type = LigneExprBesion.class, group = true,groupName = "group1",groupLabel = "BESIONS",edittable = true)
   private List<LigneExprBesion> besions = new ArrayList<LigneExprBesion>();
   
   private String state = "etabli";

   /**
    * 
    * @param code
    * @param utilisateur
    * @param dateExpr
    * @param motivation 
    */
    public ExprBesion(String code, Tier utilisateur, Date dateExpr, String motivation) {
        this.code = code;
        this.utilisateur = utilisateur;
        this.dateExpr = dateExpr;
        this.motivation = motivation;
    }

    /**
     * 
     * @param code
     * @param utilisateur
     * @param dateExpr
     * @param motivation
     * @param id
     * @param designation
     * @param moduleName 
     */
    public ExprBesion(String code, Tier utilisateur, Date dateExpr, String motivation, long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
        this.code = code;
        this.utilisateur = utilisateur;
        this.dateExpr = dateExpr;
        this.motivation = motivation;
    }
    
    /**
     * 
     * @param expr 
     */
    public ExprBesion(ExprBesion expr) {
        super(expr.id, expr.designation, expr.moduleName,expr.compareid);
        this.code = expr.code;
        if(expr.utilisateur!=null){
            this.utilisateur = new Tier(expr.utilisateur);
        }
        this.dateExpr = expr.dateExpr;
        this.motivation = expr.motivation;
        this.state = expr.state;
    }

    public ExprBesion() {
    }

    


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Tier getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Tier utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Date getDateExpr() {
        return dateExpr;
    }

    public void setDateExpr(Date dateExpr) {
        this.dateExpr = dateExpr;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public List<LigneExprBesion> getBesions() {
        return besions;
    }

    public void setBesions(List<LigneExprBesion> besions) {
        this.besions = besions;
    }    
    

    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechachat"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "EXPRESSIONS DES BESIONS";  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "EXPRESSIONS DES BESIONS"; //To change body of generated methods, choose Tools | Templates.
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    

    @Override
    public boolean isActivatefollower() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<State> getStates() {
        states = new ArrayList<State>();
        if("etabli".equals(state)){
            State state = new State("etabli", "Broullion");
            states.add(state);
             state = new State("accorde", "A Accorder");
            states.add(state);
            state = new State("valide", "A Valider");
            states.add(state);
//            return states ;
        }else if("accorde".equals(state)){
            State state = new State("accorde", "A Accorder");
            states.add(state);
            state = new State("valide", "A Valider");
            states.add(state);
           state = new State("annule", "Annulé");
           states.add(state);
        }else if("valide".equals(state)){
            State state = new State("valide", "A Valider");
            states.add(state);
            state = new State("apprecie", "A Apprécier");
            states.add(state);
            state = new State("annule", "Annulé");
            states.add(state);
        }else if("apprecie".equals(state)){
            State state = new State("apprecie", "A Apprécier");
            states.add(state);
            state = new State("transmettre", "A Transmettre");
            states.add(state);
            state = new State("annule", "Annulé");
            states.add(state);
        }else if("transmettre".equals(state)){
            State state = new State("transmettre", "A Transmettre");
            states.add(state);
            state = new State("executer", "A Executer");
            states.add(state);
            state = new State("annule", "Annulé");
            states.add(state);
        }else if("executer".equals(state)){
            State state = new State("executer", "A Executer");
            states.add(state);
            state = new State("terminer", "Terminé");
            states.add(state);
            state = new State("annule", "Annulé");
            states.add(state);
        }else if("terminer".equals(state)){
            State state = new State("terminer", "Terminé");
            states.add(state);
        }else if("annule".equals(state)){
           State state = new State("annule", "Annulé");
           states.add(state);
        }//end if(state=="etabli"){
//        State state = new State("etabli", "Broullion");
//        states.add(state);
//        state = new State("annule", "Annulé");
//        states.add(state);
//        state = new State("accorde", "A Accorder");
//        states.add(state);
//        state = new State("valide", "A Valider");
//        states.add(state);
//        state = new State("apprecie", "A Apprécier");
//        states.add(state);
//        state = new State("transmettre", "A Transmettre");
//        states.add(state);
//        state = new State("executer", "A Executer");
//        states.add(state);
//        state = new State("terminer", "Terminé");
//        states.add(state);
        return states; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActivefilelien() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSerial() {
        return "exbe270220181852"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return super.isCreateonfield(); //To change body of generated methods, choose Tools | Templates.
    }
   
   
   
    @Override
    public int compareTo(ExprBesion o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
