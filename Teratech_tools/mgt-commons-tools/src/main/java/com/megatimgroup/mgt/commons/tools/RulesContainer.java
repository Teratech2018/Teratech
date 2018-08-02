/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.mgt.commons.tools;

import com.megatimgroup.mgt.commons.rules.LengthRule;
import com.megatimgroup.mgt.commons.rules.MaxRule;
import com.megatimgroup.mgt.commons.rules.MinRule;
import com.megatimgroup.mgt.commons.rules.NotNullRule;
import com.megatimgroup.mgt.commons.rules.PatternRule;
import com.megatimgroup.mgt.commons.rules.UniqueRule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *Container of rules
 * @author BEKO
 */
public class RulesContainer {
    /**
     * Container des rules
     */
    private  Map<String,List<RuleValidator>> container;
    
     private static RulesContainer _instance =null;

    /**
     * Constructor
     */
    private RulesContainer() {
        this.container  = new HashMap<>();        
    }
    
    /**
     * Return new instance of container
     * @return 
     */
    public static RulesContainer newInstance(){
        _instance = new RulesContainer();
        return _instance;
    }
    
    /**
     * Add new Rules for Fields
     * @param fieldname
     * @param rule 
     */
    public  void addRule(String fieldname, RuleValidator rule){        
        if(!container.containsKey(fieldname)){
            container.put(fieldname, new ArrayList<RuleValidator>());
        }//end if(!container.containsKey(fieldname)){
        if(!container.get(fieldname).contains(rule)){
            container.get(fieldname).add(rule);
        }//end if(!container.get(fieldname).contains(rule)){
    }
    
    /**
     * 
     * @param fieldname
     * @param length
     * @param value 
     */
    public void addLengthRule(String fieldname , short length , String value){
        if(!container.containsKey(fieldname)){
            container.put(fieldname, new ArrayList<RuleValidator>());
        }//end if(!container.containsKey(fieldname)){
        LengthRule rule = new LengthRule(length, value);
        if(!container.get(fieldname).contains(rule)){
            container.get(fieldname).add(rule);
        }//end if(!container.get(fieldname).contains(rule)){
    }
    
    /**
     * 
     * @param fieldname
     * @param min
     * @param value 
     */
    public void addMinRule(String fieldname , double min , String value){
        if(!container.containsKey(fieldname)){
            container.put(fieldname, new ArrayList<RuleValidator>());
        }//end if(!container.containsKey(fieldname)){
        MinRule rule = new MinRule(min, value);
        if(!container.get(fieldname).contains(rule)){
            container.get(fieldname).add(rule);
        }//end if(!container.get(fieldname).contains(rule)){
    }
    
    /**
     * 
     * @param fieldname
     * @param max
     * @param value 
     */
    public void addMaxRule(String fieldname , double max , String value){
        if(!container.containsKey(fieldname)){
            container.put(fieldname, new ArrayList<RuleValidator>());
        }//end if(!container.containsKey(fieldname)){
        MaxRule rule = new MaxRule(max, value);
        if(!container.get(fieldname).contains(rule)){
            container.get(fieldname).add(rule);
        }//end if(!container.get(fieldname).contains(rule)){
    }
    
    /**
     * 
     * @param fieldname
     * @param pattern
     * @param value 
     */
    public void addPatternRule(String fieldname , String pattern,String value){        
        if(!container.containsKey(fieldname)){
            container.put(fieldname, new ArrayList<RuleValidator>());
        }//end if(!container.containsKey(fieldname)){
        PatternRule rule = new PatternRule(pattern, value);
        if(!container.get(fieldname).contains(rule)){
            container.get(fieldname).add(rule);
        }//end if(!container.get(fieldname).contains(rule)){
    }
    
    /**
     * 
     * @param classname
     * @param fieldname
     * @param value
     * @param manager 
     */
    public void addUniqueRule(String classname , String fieldname , String value, EntityManager manager){
         if(!container.containsKey(fieldname)){
            container.put(fieldname, new ArrayList<RuleValidator>());
        }//end if(!container.containsKey(fieldname)){
        UniqueRule rule = new UniqueRule(manager, value,classname);
        rule.setClassname(classname);
        rule.setFieldname(fieldname);
        if(!container.get(fieldname).contains(rule)){
            container.get(fieldname).add(rule);
        }//end if(!container.get(fieldname).contains(rule)){
    }
    
    /**
     * 
     * @param fieldname
     * @param value 
     */
    public void addNotNullRule(String fieldname ,String value){        
        if(!container.containsKey(fieldname)){
            container.put(fieldname, new ArrayList<RuleValidator>());
        }//end if(!container.containsKey(fieldname)){
        NotNullRule rule = new NotNullRule(value);
        if(!container.get(fieldname).contains(rule)){
            container.get(fieldname).add(rule);
        }//end if(!container.get(fieldname).contains(rule)){
    }
    
    /**
     * 
     * @param fieldname
     * @param value
     * @return 
     */
    public List<ValidatorError> execute(String fieldname , String value){
        List<ValidatorError> result = new ArrayList<>();
//        System.out.println(RulesContainer.class.toString()+".execute(String fieldname , String value) ======= fieldname : "+fieldname+" === container : "+container);
        if(!container.containsKey(fieldname)){
            return result;
        }//end if(!container.containsKey(fieldname)){
        for(RuleValidator rule : container.get(fieldname)){
            rule.setValue(value);
            ValidatorError error = rule.execute();
            if(error!=null){
                result.add(error);
            }//end if(error!=null){
        }//end for(RuleValidator rule : container.get(fieldname)){
        return result;
    }
    
    /**
     * 
     * @param datas
     * @return 
     */
   public Map<Long,Map<String,List<ValidatorError>>> execute(Map<Long ,List<String>> datas){
       Map<Long,Map<String,List<ValidatorError>>> result = new HashMap<>();
       //Teste s'il ya des données
       if(datas.isEmpty()){
           return result;
       }//end if(datas.isEmpty()){
       /**
        * Recuperation de la liste des champs
        */
       List<String> fieldnames = datas.get(0L);
       //Traitement des donnees
       for(long key : datas.keySet()){
           if(key!=0){
               //Recuperation des données
               List<String> data = datas.get(key);
               //Initialisation des index
               int index = 0;
               for(String value : data){
//                   System.out.println(RulesContainer.class.toString()+".execute(Map<Long ,List<String>> datas) ======= Fields : "+fieldnames+" === index : "+index+" === size"+fieldnames.size());
                   String fieldname = fieldnames.get(index);
                   List<ValidatorError> errors = execute(fieldname, value);
                   if(!errors.isEmpty()){
                       if(!result.containsKey(key)){
                           result.put(key, new HashMap<String, List<ValidatorError>>());
                       }//end if(!result.containsKey(key)){
                       result.get(key).put(fieldname, errors);
                   }//end if(!errors.isEmpty()){
                   index++;
               }//end for(String value : data){
           }//end if(key!=0){
       }//end for(long key : datas.keySet()){
       return result;
   } 
    
}
