/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.megatimgroup.ebaytools.client.ValidateError;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.export.EnumJavaType;
import com.megatim.common.jaxb.entities.Fileline;
import com.megatim.common.jaxb.entities.Linecolumn;
import com.megatim.common.jaxb.entities.Temporalfile;
import com.megatimgroup.ebaytools.client.NodeObject;
import com.megatimgroup.model.referentiels.Classe;
import com.megatimgroup.model.referentiels.Devise;
import com.megatimgroup.model.referentiels.Division;
import com.megatimgroup.model.referentiels.Groupe;
import com.megatimgroup.model.referentiels.Motif;
import com.megatimgroup.model.referentiels.Nationalite;
import com.megatimgroup.model.referentiels.NatureClientele;
import com.megatimgroup.model.referentiels.NatureJuridique;
import com.megatimgroup.model.referentiels.Pays;
import com.megatimgroup.model.referentiels.PrecisionDateNaissance;
import com.megatimgroup.model.referentiels.Qualite;
import com.megatimgroup.model.referentiels.Section;
import com.megatimgroup.model.referentiels.SensOperation;
import com.megatimgroup.model.referentiels.StatusResidence;
import com.megatimgroup.model.referentiels.Titre;
import com.megatimgroup.model.referentiels.TypeOperation;
import com.megatimgroup.model.referentiels.Ville;
import com.megatim.common.annotations.Connector;
import com.megatim.common.annotations.IncludeObject;
import com.megatimgroup.model.operations.DeclarationFinanciere;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 *
 * @author DEV_4
 */
public class ValidateRule implements RuleExecutor{
    
    private List<NodeObject> rule = new ArrayList<NodeObject>();
    
    private List<ValidateError> errors = new ArrayList<ValidateError>();
    
    private List<String> excludeFields = new ArrayList<String>();
    
    private Fileline data;
    
    private Temporalfile file = null ;
    
    private boolean strict = Boolean.TRUE;
    
    private  ResourceBundle bundle = null ;
    

    /**
     * 
     * @param file
     * @param rule
     * @param data 
     */
    public ValidateRule(Temporalfile file , List<NodeObject> rule, Fileline data,boolean strict) {
        this.rule = rule;
        this.data = data;
        this.file = file ;
        this.strict = strict;        
        bundle = ResourceBundle.getBundle("validationmessages");
    }
    

    /**
     * 
     * @param rule
     * @param data
     * @return 
     */
    private boolean executeRule(NodeObject rule, Linecolumn data , boolean strict){        
        //To change body of generated methods, choose Tools | Templates.
        if(rule==null||data==null){
            //ValidateError error = new ValidateError(rule, data, "Impossible de trouvez les données");
            //errors.add(error);
            return true;
        }        
        
        //Test de non nullité
        if(!rule.isNullable()&&(data.getValue()==null||data.getValue().trim().isEmpty())){
            if(strict){  
                ValidateError error = new ValidateError(rule, data, bundle.getString("V.0.0.0.1")+rule.getName());
                errors.add(error);
                return false ;
            }
        }
        
        //Sauvegarde de la valeur
        rule.setValue(data.getValue());
        
        if(rule.getPattern()!=null&&!rule.getPattern().trim().isEmpty()){
            if(!data.getValue().matches(rule.getPattern())){
                ValidateError error = new ValidateError(rule, data, bundle.getString("V.0.0.0.2"));
                errors.add(error);
                return false;
            }
        }
        
        if((data.getType()==EnumJavaType.STRING.ordinal())&&rule.getLength()>0){
            if(data.getValue().length()!=rule.getLength()){
                ValidateError error = new ValidateError(rule, data, bundle.getString("V.0.0.0.3"));
                errors.add(error);
                return false;
            }
        }
        
        //Traitement des composant verifie que le composant existe en BD
        if(rule.isEntry()){
            Object result = converter(rule.getClazz(),data.getValue());  
            if(result==null){
              if(strict&&!rule.isNullable()){ 
                ValidateError error = new ValidateError(rule, data, bundle.getString("V.0.0.0.4"));
                errors.add(error);
                return false ;
              }
            }
        }
        
        if(rule.isUnique()){
            GenericManager manager = (GenericManager) ManagerHelper.getManager2(rule.getParentClazz());
//            System.out.println("ImportDialog.beforeSave() :::::::::::::::::::::::::: "+rule.getParentClazz()+" :::::=====================================" );       
            List results = manager.findByUniqueProperty(rule.getName(), rule.getValue(), new HashSet<String>());              
            if(results!=null&&!results.isEmpty()){
                 ValidateError error = new ValidateError(rule, data, bundle.getString("V.0.0.0.5"));
                errors.add(error);
                return false ;
            }
            
            if(!isUniqueInFile(data)){
                ValidateError error = new ValidateError(rule, data, bundle.getString("V.0.0.0.6"));
                errors.add(error);
                return false ;
            }
        }
       
        if(rule.getInclude()!=null&&!include(rule.getInclude(), data)){            
            ValidateError error = new ValidateError(rule, data, bundle.getString("V.0.0.0.7"));
            errors.add(error);
            return false ;
        }
//        System.out.println(ValidateRule.class.getSimpleName()+".exclude() ====================================================== "+rule.getName()+" :::::: "+rule.getExclude()+" ==== ");
        
        if(rule.getExclude()!=null&&!exclude(rule.getExclude(), data)){            
            ValidateError error = new ValidateError(rule, data, bundle.getString("V.0.0.0.8"));
            errors.add(error);
            return false ;
        }
        
        return true;
    }
    
     private boolean isUniqueInFile(Linecolumn rule){
         if(file==null)
                  return true ;
         int compter = 0;
         for(Fileline line : file.getFileline()){
             if(line==null||line.getLinecolumn()==null||line.getLinecolumn().isEmpty())
                            continue;
             for(Linecolumn col : line.getLinecolumn()){
                 if(col==null||col.getName()==null||col.getValue()==null)
                     continue;
                 if(col.getName().equalsIgnoreCase(rule.getName())&&col.getValue().equalsIgnoreCase(rule.getValue())){
                     compter++;
                     break;
                 }//if
             }//end for
         }//end for
         
         return compter==0;
     }
    
     
     /**
      * Predicat verifiant que une valeur n'existe pas dans une ou plusieurs autres table
      * @param classes
      * @param champs
      * @param connector
      * @param type
      * @param value
      * @return 
      */
     private boolean exclude(IncludeObject include , Linecolumn value){
        
         //Test de validite des inputs
         if(include==null||value==null)
                      return true ;
         //Test de validite
         if(include.getClasses()==null||include.getClasses().length==0
                 ||include.getChamps()==null||include.getChamps().length==0
                 ||include.getType()==null||value.getValue()==null||value.getValue().trim().isEmpty())
             return true ;
          
         //Manager
         GenericManager manager = null ;
         //Resultat
         Boolean result = Boolean.TRUE;
         
         if(include.getConnector().equals(Connector.OR)){
             result = Boolean.FALSE;
         }
         int index = 0 ;
         //Parcours de la liste des classes
         for(Class  clazz : include.getClasses()){
             //Extension du manager
             manager = manager = (GenericManager) ManagerHelper.getManager2(clazz);
             //Valeur
             Object valeur =  converter(include.getType(),value.getValue());
             //Verification
             if(include.getChamps()==null||include.getChamps().length<index||valeur==null)
            	 return false;
             //Recuperation des resultats
             List results = manager.findByUniqueProperty(include.getChamps()[index]
                          ,valeur, new HashSet<String>());
             //Construction du resultat
             if(include.getConnector().equals(Connector.AND)){
                 result &=(results==null||results.isEmpty());
             }else{
                 result |=(result==null||results.isEmpty());
             }
             index = index +1;
         }
         return result ;
     }
     
          /**
      * Predicat verifiant que une valeur existe dans une ou plusieurs autres table
      * @param classes
      * @param champs
      * @param connector
      * @param type
      * @param value
      * @return 
      */
     private boolean include(IncludeObject include , Linecolumn value){
         
         //Test de validite des inputs
         if(include==null||value==null)
                      return true ;
         //Test de validite
         if(include.getClasses()==null||include.getClasses().length==0
                 ||include.getChamps()==null||include.getChamps().length==0
                 ||include.getType()==null||value.getValue()==null||value.getValue().trim().isEmpty())
             return true ;
//          System.out.println(ValidateRule.class.getSimpleName()+".execute() ====================================================== "+include.getClasses()+" :::::: "+include.getChamps()+" ==== "+include.getConnector()+" ::::: "+include.getType());
       
         //Manager
         GenericManager manager = null ;
         //Resultat
         Boolean result = Boolean.TRUE;
         
         if(include.getConnector().equals(Connector.OR)){
             result = Boolean.FALSE;
         }
         int index = 0 ;
         //Parcours de la liste des classes
         for(Class  clazz : include.getClasses()){
             //Extension du manager
             manager = manager = (GenericManager) ManagerHelper.getManager2(clazz);
             //Valeur
             Object valeur =  converter(include.getType(),value.getValue());
             //Verification
             if(include.getChamps()==null||include.getChamps().length<index||valeur==null)
            	 return false;
            	 
             //Recuperation des resultats
             List results = manager.findByUniqueProperty(include.getChamps()[index]
                          ,valeur, new HashSet<String>());
             //Construction du resultat
             if(include.getConnector().equals(Connector.AND)){
                 result &=(results!=null&&!results.isEmpty());
             }else{
                 result |=(result!=null&&!results.isEmpty());
             }
             index = index +1;
         }
         return result ;
     }
    /**
     * 
     * @param line
     * @return 
     */
    private boolean isLineEmpty(Fileline line){
        
        boolean result = true ;
        
        for(Linecolumn col : line.getLinecolumn()){
            result &= (col.getValue()==null||col.getValue().trim().isEmpty());
        }
        
        return result;
        
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public boolean execute() {
        
        if(rule==null||data==null||data.getLinecolumn()==null){
            ValidateError error = new ValidateError(null, null, "Impossible de trouvé l'entité correspondant");
            errors.add(error);
            return false;
        }
        //Cas de ligne vide
        if(isLineEmpty(data))
                     return true ;
       if(excludeFields.contains(rule.get(0).getName()))
                     return true ;
        /*
        if(rule.size()>data.getLinecolumn().size()){
             ValidateError error = new ValidateError(null, null, "Incompatibilité des tailles de données");
            errors.add(error);
             return false ;
         }**/
         
        //Construction de la base de corresponda,ce
        Map<String,NodeObject> database = new HashMap<String, NodeObject>();
        
        for(NodeObject node : rule){
            database.put(node.getName(), node);
        }
        int index = 0;
        
        boolean result = Boolean.TRUE;
        
        for(Linecolumn node: data.getLinecolumn()){
            //Recuperation du noeud
             NodeObject noeud = database.get(node.getName());
//           if(index<data.getLinecolumn().size()) 
              result &=executeRule(noeud, node,strict);     
            //System.out.println("Validator.validate() ::::::::::::::::: "+node+" :::::: "+data.getLinecolumn().get(index).getValue()+" ::::: "+result+" ::::::::::::: "+data.getLinecolumn().size());      
            index++;
             
        }
        
            
        return result ;
    }
    
    
     /**
     * Convertir la valeur en object
     * @param clazz
     * @param value
     * @return 
     */
    public Object converter(Class<?> clazz , String value){
        
        if(value==null||value.trim().isEmpty()||value.trim().equalsIgnoreCase("null")){
            return null;
        }
        
        if(clazz.equals(BigDecimal.class))
               return new BigDecimal(value);
        else if(clazz.equals(Ville.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(TypeOperation.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Titre.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(StatusResidence.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
            //return datas!=null&&!datas.isEmpty() ? datas.get(0) : null;
        }else if(clazz.equals(SensOperation.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Section.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Qualite.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(PrecisionDateNaissance.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Pays.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(NatureJuridique.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(NatureClientele.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Nationalite.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Motif.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Groupe.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Division.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Devise.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Classe.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }
        return value;
    }

    /**
     * 
     * @return 
     */
    public List<ValidateError> getErrors() {
        return errors;
    }

    /**
     * 
     * @param excludes 
     */
    
    public void setExcludeFields(String... excludes) {
        
        this.excludeFields = new ArrayList<String>();
        
        if(excludes!=null&&excludes.length>0) {
            for(String exclu : excludes){
                excludeFields.add(exclu);
            }
        }
    }
    
   
    
}
