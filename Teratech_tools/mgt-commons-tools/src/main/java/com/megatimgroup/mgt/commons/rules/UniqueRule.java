/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.mgt.commons.rules;

import com.megatimgroup.mgt.commons.tools.RuleValidator;
import com.megatimgroup.mgt.commons.tools.ValidatorError;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author BEKO
 */
public class UniqueRule implements RuleValidator,Serializable{

    private EntityManager manager ;
    
    private String fieldname ;
    
    private String classname ;
    
    private String value ;

    /**
     * 
     * @param manager
     * @param value 
     * @param classname 
     */
    public UniqueRule(EntityManager manager, String value,String classname) {
        this.manager = manager;
        this.value = value;
        this.classname = classname;
    }

    public String getFieldname() {
        return fieldname;
    }

    public String getValue() {
        return value;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
    
    
    
    @Override
    public ValidatorError execute() {
        //To change body of generated methods, choose Tools | Templates.
        if(manager==null || fieldname==null||value==null || classname==null){
            return null;
        }//end if(manager==null || fieldname==null||value==null){
        String requete = "SELECT c FROM "+classname+" c WHERE c."+fieldname+" = '"+value+"'";
//        System.out.println(UniqueRule.class.toString()+".execute() ======== manager : "+manager+" === fieldname : "+fieldname+" === valeur : "+value+" == classname : "+classname+" == \n requete : "+requete);
        Query query = manager.createQuery(requete);
        List datas = query.getResultList();
        if(datas==null||datas.isEmpty()){
            return null;
        }else{
            return new ValidatorError(value, "Unique contraints violation");
        }
    }

    @Override
    public void setValue(String value) {
        //To change body of generated methods, choose Tools | Templates.
        this.value = value;
    }
    
}
