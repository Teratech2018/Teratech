/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.megatim.common.jaxb.entities.Fileline;
import com.megatim.common.jaxb.entities.Temporalfile;
import com.megatimgroup.ebaytools.client.NodeObject;
import com.megatimgroup.ebaytools.client.ValidateError;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DEV_4
 */
public class Validator {
    
    private List<RuleExecutor> rules = new ArrayList<RuleExecutor>();
    
    private List<ValidateError> errors = new ArrayList<ValidateError>();
    
    private boolean strict = Boolean.TRUE; 
    
    //Nombre de threads 
    private int processors = 1 ;

    /**
     * 
     * @param rules
     * @param file
     */
    public Validator(List<NodeObject> rules , Temporalfile file) {
       
       for(Fileline ligne : file.getFileline()){
           ValidateRule rule = new ValidateRule(file ,rules, ligne,strict);
           this.rules.add(rule);
      }
      
       //this.file = file ;
        
    }
    
     /**
     * 
     * @param rules
     * @param file
     */
    public Validator(List<NodeObject> rules , Temporalfile file,boolean strict) {
       
        this.strict = strict;
        
       for(Fileline ligne : file.getFileline()){
           ValidateRule rule = new ValidateRule(file ,rules, ligne,strict);
           this.rules.add(rule);
      }
      
       //this.file = file ;
        
    }
    
    
    /**
     * Validation des donnees du fichier
     * @return 
     */    
    public boolean validate(){
        
        boolean result = true ;
        
        errors = new ArrayList<ValidateError>();
        
        for(RuleExecutor cmde : rules){   
            //System.out.println("Validator.validate() - Entree:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+cmde);  
            
            result &=cmde.execute();
            errors.addAll(((ValidateRule)cmde).getErrors());
            
            //System.out.println("Validator.validate() - Fin:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+cmde);  
            
        }
         //System.out.println("Validator.validate() - Quitter:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        return result ;
    }
    
    /**
     * Validation des donnees du fichier
     * @return 
     */    
    public boolean validate(String ... excludefields){
        
        boolean result = true ;
        
        errors = new ArrayList<ValidateError>();
        
        for(RuleExecutor cmde : rules){   
            //System.out.println("Validator.validate() - Entree:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+cmde);  
            cmde.setExcludeFields(excludefields);
            result &=cmde.execute();
            errors.addAll(((ValidateRule)cmde).getErrors());
            
            //System.out.println("Validator.validate() - Fin:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+cmde);  
            
        }
         //System.out.println("Validator.validate() - Quitter:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        return result ;
    }

    public List<ValidateError> getErrors() {
        return errors;
    }

    public void setProcessors(int processors) {
        this.processors = processors;
    }

    public void setStrict(boolean strict) {
        this.strict = strict;
    }
    
    
    
}
