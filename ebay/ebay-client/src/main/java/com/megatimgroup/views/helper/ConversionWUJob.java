/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.annotationsprocessor.ValidateAndFillBeans;
import com.megatim.common.jaxb.entities.Fileline;
import com.megatim.common.jaxb.entities.Linecolumn;
import com.megatim.common.jaxb.entities.Temporalfile;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.ebaytools.client.AbstractJobExecutor;
import com.megatimgroup.ebaytools.client.EbayItem;
import com.megatimgroup.ebaytools.client.MessageType;
import com.megatimgroup.ebaytools.client.NodeObject;
import com.megatimgroup.ebaytools.client.ValidateError;
import com.megatimgroup.ebaytools.ebs.ESBMessageKEY;
import com.megatimgroup.model.operations.DeclarationFinanciere;
import com.megatimgroup.model.operations.DeclarationPM;
import com.megatimgroup.model.operations.DeclarationPP;
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
import com.megatimgroup.views.operations.ImportEditPanel;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Commercial_2
 */
public class ConversionWUJob extends AbstractJobExecutor{

    
    private List<ValidateError> errors = new ArrayList<ValidateError>();
    /**
     * 
     * @param nextJob 
     */
    public ConversionWUJob(AbstractJobExecutor nextJob) {
        super(nextJob);
        
//         MessagesBundle.setBundle(ResourceBundle.getBundle("consolemessages"));
//        //bundle = MessagesBundle.getInstace("consolemessages");
//        //Initialisation du Dispatcher validate.header
//        initialieMessageDispatcher(MessagesBundle.getMessage("convert.header"));   
    }

    public ConversionWUJob() {        
        super();     
        initialieMessageDispatcher();  
    }

    
    
    
    @Override
    public void process() {
        try {
                  
                 //Liste des EbayItem issues de 
                 List<EbayItem> items = new ArrayList<EbayItem>();
                 //Extraction du message de la liste dees Operations Western Union
                 String inbound = (String) token.get(ESBMessageKEY.INBOUND);
                if(inbound.trim().equalsIgnoreCase("TR")){
                     items = (List<EbayItem>) token.get(ESBMessageKEY.WESTERN_ITEMS);
                 }else if(inbound.trim().equalsIgnoreCase("PP")){
                     items = (List<EbayItem>) token.get(ESBMessageKEY.PP_ITEMS);
                 }else if(inbound.trim().equalsIgnoreCase("PM")){
                     items = (List<EbayItem>) token.get(ESBMessageKEY.PM_ITEMS);
                 }else if(inbound.trim().equalsIgnoreCase("OF")){
                     items = (List<EbayItem>) token.get(ESBMessageKEY.OF_ITEMS);
                 }else if(inbound.trim().equalsIgnoreCase("DB")){
                     items = (List<EbayItem>) token.get(ESBMessageKEY.OF_ITEMS);
                 }

                 //Si les données sont pas disponible
                 if(items==null||items.isEmpty()) return ;
                 MessagesBundle.setBundle(ResourceBundle.getBundle("consolemessages"));
                 initialieMessageDispatcher(MessagesBundle.getMessage("convert.header"));
                  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
                 publish(buildMessage(MessagesBundle.getMessage("convert.start")+" : "+formatter.format(new Date()), MessageType.INITIAL));
                 //Validation des données
                 if(inbound.trim().equalsIgnoreCase("TR")){
                       //Construction du temporalfiel
                       List<NodeObject> nodes = EbayHelper.getNodeObjects(DeclarationPP.class);
                       //INitialisation de la liste eventuelle des erreurs
                       Temporalfile temporalefile = EbayHelper.buildFormItem(items, nodes);                 
                       //Validation des personnes physiques et des Operations financieres
                       Validator validator = new Validator(nodes, temporalefile, true);
                       Boolean result = validator.validate();
                       if(!result){
                           errors.addAll(validator.getErrors());
                           token.put(ESBMessageKEY.PP, new ArrayList<DeclarationPP>());
                           //Message de demarrage
                            publish(buildMessage(MessagesBundle.getMessage("validation.error"), MessageType.IN_ERROR));
                       }else{
                           List listesPP = fillBean(DeclarationPP.class, nodes, temporalefile);
                           token.put(ESBMessageKEY.PP, listesPP);
                       }
                       //Validation des operations financieres
                       nodes = EbayHelper.getNodeObjects(DeclarationFinanciere.class);
                       temporalefile = EbayHelper.buildFormItem(items, nodes);                 
                       //Validation des personnes physiques et des Operations financieres
                       validator = new Validator(nodes, temporalefile, true);
                       result = validator.validate("reference");
//                       System.out.println(ConversionWUJob.class.getSimpleName()+" :::::::::::::::::::::::::::::::::::::::::::::::   "+result);
                        print(validator.getErrors());
                        if(!result){
                           errors.addAll(validator.getErrors());
                           token.put(ESBMessageKEY.OF, new ArrayList<DeclarationFinanciere>());
                           //Message de demarrage
                            publish(buildMessage(MessagesBundle.getMessage("validation.error"), MessageType.IN_ERROR));
                       }else{
                           List listeOF = fillBean(DeclarationFinanciere.class, nodes, temporalefile);
                           token.put(ESBMessageKEY.OF, listeOF);
                       }
                        //Sauvegarde des erreurs
                        if(!errors.isEmpty()){
                            //Ajout des erreurs dans le message*
                            messageDispacher.setErrors(validator.getErrors());
                            token.put(ESBMessageKEY.ERRORS_ITEMS, errors);
                        }
                 }else if(inbound.trim().equalsIgnoreCase("PP")){
                     //Construction du temporalfiel
                       List<NodeObject> nodes = EbayHelper.getNodeObjects(DeclarationPP.class);
                       Temporalfile temporalefile = EbayHelper.buildFormItem(items, nodes);                 
                       //Validation des personnes physiques et des Operations financieres
                       Validator validator = new Validator(nodes, temporalefile, false);
                       Boolean result = validator.validate();
                       if(!result){
                           errors.addAll(validator.getErrors());
                           token.put(ESBMessageKEY.PP, new ArrayList<DeclarationPP>());
                           //Sauvegarde des erreurs
                           token.put(ESBMessageKEY.ERRORS_ITEMS, errors);
                           //Ajout des erreurs dans le message*
                            messageDispacher.setErrors(validator.getErrors());
                           //Message de demarrage
                            publish(buildMessage(MessagesBundle.getMessage("validation.error"), MessageType.IN_ERROR));
                       }else{
                           List listesPP = fillBean(DeclarationPP.class, nodes, temporalefile);
                           token.put(ESBMessageKEY.PP, listesPP);
                       }
                 }else if(inbound.trim().equalsIgnoreCase("PM")){
                      //Construction du temporalfiel
                       List<NodeObject> nodes = EbayHelper.getNodeObjects(DeclarationPM.class);
                       Temporalfile temporalefile = EbayHelper.buildFormItem(items, nodes);                 
                       //Validation des personnes physiques et des Operations financieres
                       Validator validator = new Validator(nodes, temporalefile, false);
                       Boolean result = validator.validate();
                       if(!result){
                           errors.addAll(validator.getErrors());
                           token.put(ESBMessageKEY.PM, new ArrayList<DeclarationPM>());
                           //Sauvegarde des erreurs
                           token.put(ESBMessageKEY.ERRORS_ITEMS, errors);
                           //Ajout des erreurs dans le message*
                            messageDispacher.setErrors(validator.getErrors());
                           //Message de demarrage
                            publish(buildMessage(MessagesBundle.getMessage("validation.error"), MessageType.IN_ERROR));
                       }else{
                           List listePM = fillBean(DeclarationPM.class, nodes, temporalefile);
                           token.put(ESBMessageKEY.PM, listePM);
                       }
                 }else if(inbound.trim().equalsIgnoreCase("OF")){
                       //Construction du temporalfiel
                       List<NodeObject> nodes = EbayHelper.getNodeObjects(DeclarationFinanciere.class);
                       Temporalfile temporalefile = EbayHelper.buildFormItem(items, nodes);                 
                       //Validation des personnes physiques et des Operations financieres
                       Validator validator = new Validator(nodes, temporalefile, false);
                       Boolean result = validator.validate();
                       if(!result){
                           errors.addAll(validator.getErrors());
                           token.put(ESBMessageKEY.OF, new ArrayList<DeclarationFinanciere>());
                           //Sauvegarde des erreurs
                           token.put(ESBMessageKEY.ERRORS_ITEMS, errors);
                           //Ajout des erreurs dans le message*
                            messageDispacher.setErrors(validator.getErrors());
                           //Message de demarrage
                            publish(buildMessage(MessagesBundle.getMessage("validation.error"), MessageType.IN_ERROR));
                       }else{
                           //Validation s'est deroule avec succes
                           List listeOF = fillBean(DeclarationFinanciere.class, nodes, temporalefile);
                           token.put(ESBMessageKEY.OF, listeOF);
                       }
                 }else if(inbound.trim().equalsIgnoreCase("DB")){
                     //Recuperation de la liste personnes physiques
                     List<EbayItem> ppItems = (List<EbayItem>) token.get(ESBMessageKEY.PP_ITEMS);
                     //Traitement des PP
                     if(ppItems!=null&&!ppItems.isEmpty()){
                            //Construction du temporalfiel
                             List<NodeObject> nodes = EbayHelper.getNodeObjects(DeclarationPP.class);
                             Temporalfile temporalefile = EbayHelper.buildFormItem(ppItems, nodes);                 
                             System.out.println(ConversionWUJob.class.getSimpleName()+".process() PP ITEMS =====  "+ppItems);
                             //Validation des personnes physiques et des Operations financieres
                             Validator validator = new Validator(nodes, temporalefile, false);
                             Boolean result = validator.validate();
                             if(!result){
                                 errors.addAll(validator.getErrors());
                                 token.put(ESBMessageKEY.PP, new ArrayList<DeclarationFinanciere>());
                                 //Sauvegarde des erreurs
                                 token.put(ESBMessageKEY.ERRORS_ITEMS, errors);
                                 //Ajout des erreurs dans le message*
//                                 messageDispacher.setErrors(validator.getErrors());
//                                 //Message de demarrage
//                                  publish(buildMessage(MessagesBundle.getMessage("validation.error"), MessageType.IN_ERROR));
                             }else{
                                 //Validation s'est deroule avec succes
                                 List pps = fillBean(DeclarationPP.class, nodes, temporalefile);
                                 token.put(ESBMessageKEY.PP, pps);
                             }
                     }//Fin traitement
                     //Recuperation de la liste personnes morales
                     List<EbayItem> pmItems = (List<EbayItem>) token.get(ESBMessageKEY.PM_ITEMS);
                     if(pmItems!=null&&!pmItems.isEmpty()){
                         //Construction du temporalfiel
//                    	 System.out.println(ConversionWUJob.class.getSimpleName()+".process() PM ITEMS =====  "+pmItems);
                        List<NodeObject> nodes = EbayHelper.getNodeObjects(DeclarationPM.class);
                        Temporalfile temporalefile = EbayHelper.buildFormItem(pmItems, nodes);                 
                        //Validation des personnes physiques et des Operations financieres
                        Validator validator = new Validator(nodes, temporalefile, false);
                        Boolean result = validator.validate();
                        if(!result){
                            errors.addAll(validator.getErrors());
                            token.put(ESBMessageKEY.PM, new ArrayList<DeclarationPM>());
                            //Sauvegarde des erreurs
                            token.put(ESBMessageKEY.ERRORS_ITEMS, errors);
                            //Ajout des erreurs dans le message*
//                            messageDispacher.setErrors(validator.getErrors());
//                            //Message de demarrage
//                             publish(buildMessage(MessagesBundle.getMessage("validation.error"), MessageType.IN_ERROR));
                        }else{
                            List listePM = fillBean(DeclarationPM.class, nodes, temporalefile);
                            token.put(ESBMessageKEY.PM, listePM);
                        }
                     }
                     //Traitement des operations financieres
                     //Construction du temporalfiel
                       items = (List<EbayItem>) token.get(ESBMessageKEY.OF_ITEMS);
                       List<NodeObject> nodes = EbayHelper.getNodeObjects(DeclarationFinanciere.class);
                       Temporalfile temporalefile = EbayHelper.buildFormItem(items, nodes);                 
                       //Validation des personnes physiques et des Operations financieres
                       Validator validator = new Validator(nodes, temporalefile, false);
                       Boolean result =  validator.validate("reference");
                       if(!result){
                           errors.addAll(validator.getErrors());
//                           System.out.println(ConversionWUJob.class.getSimpleName()+".process() OF ITEMS =====  "+listeOF);
                           token.put(ESBMessageKEY.OF, new ArrayList<DeclarationFinanciere>());
                           //Sauvegarde des erreurs
//                           token.put(ESBMessageKEY.ERRORS_ITEMS, errors);
//                           //Message de demarrage
//                            publish(buildMessage(MessagesBundle.getMessage("validation.error"), MessageType.IN_ERROR));
                       }else{
                           //Validation s'est deroule avec succes
                           List listeOF = fillBean(DeclarationFinanciere.class, nodes, temporalefile);
//                           System.out.println(ConversionWUJob.class.getSimpleName()+".process() OF ITEMS =====  "+listeOF);
                           
                           token.put(ESBMessageKEY.OF, listeOF);
                       }
                       
                       if(!errors.isEmpty()){
                           //Ajout des erreurs dans le message*
                            messageDispacher.setErrors(validator.getErrors());
                            publish(buildMessage(MessagesBundle.getMessage("validation.error"), MessageType.IN_ERROR));
                       }
                 }
                 //Nettoyage des Items
                 token.remove(ESBMessageKEY.WESTERN_ITEMS);
                 token.remove(ESBMessageKEY.PP_ITEMS);
                 token.remove(ESBMessageKEY.PM_ITEMS);
                 token.remove(ESBMessageKEY.OF_ITEMS);
//                 //Construction du temporalfiel
//                 List<NodeObject> nodes = EbayHelper.getNodeObjects(DeclarationPP.class);
//                 Temporalfile temporalefile = EbayHelper.buildFormItem(items, nodes);
//                 //Construction de la liste de declarations des personnes physiques
//                 List listesPP = fillBean(DeclarationPP.class, nodes, temporalefile);
////                  System.out.println(DeclarationPPExtractionJob.class.getSimpleName()+" ::::::::::::::::::::::::::::: "+listesPP+" ;;;;;;;;; "+listesPP.size());
//               //Construction de la liste des operations financieres
//                 nodes =EbayHelper.getNodeObjects(DeclarationFinanciere.class);
//                 temporalefile = EbayHelper.buildFormItem(items, nodes);
//                 List listeOF = fillBean(DeclarationFinanciere.class, nodes, temporalefile);
                 //Suppression de la liste des operations western uunion
//                 token.remove(ESBMessageKEY.WESTERN_ITEMS);
//                 //Sauvegarde des objects EbayItem
//                 token.put(ESBMessageKEY.PP, listesPP);
//                 //Sauvegarde liste des operations financeres
//                 token.put(ESBMessageKEY.OF, listeOF);                
                 //Conversio des données en
//                 results = fillBean(clazz, rules, temporalFile);
                 //Message de demarrage
                 publish(buildMessage(MessagesBundle.getMessage("convert.end")+" : "+formatter.format(new Date()), MessageType.DONE));
                
            
        } catch (Exception ex) {
            publish(buildMessage(MessagesBundle.getMessage("convert.error"), MessageType.IN_ERROR));
            Logger.getLogger(ConversionWUJob.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
    }

    private void print(List<ValidateError> errors){
        
        if(errors==null||errors.isEmpty()) return ;
        
        for(ValidateError error : errors){
            
//            System.out.println(error.getColumn().getName()+" :::::: "+error.getColumn().getValue()+" :::: "+error.getErrorMessage());
        }
    }
    
    
    /**
     *
     * @param clazz
     * @param rules
     * @param line
     * @return
     */
    public List fillBean(Class<?> clazz, List<NodeObject> rules, Temporalfile file) throws InstantiationException, IllegalAccessException {

        List datas = new ArrayList();

        for (Fileline line : file.getFileline()) {
          if(!isLineEmpty(line)){  
            Object result = fillBean(clazz, rules, line);
            datas.add(result);
          }
        }
        return datas;
    }

    /**
     *
     * @param clazz
     * @param rules
     * @param line
     * @return
     */
    private Object fillBean(Class<?> clazz, List<NodeObject> rules, Fileline line) throws InstantiationException, IllegalAccessException {

        HashMap<String, NodeObject> map = new HashMap<String, NodeObject>();

        
        //Construction du Map
        Map<String , Linecolumn> database = new HashMap<String, Linecolumn>();
        
        for(Linecolumn column : line.getLinecolumn()){
            database.put(column.getName(), column);
        }
        int index = 0;

        for (NodeObject node : rules) {
//             if(index<line.getLinecolumn().size()){
              Linecolumn col = database.get(node.getName());
              if(col!=null){
                    node.setValue(converter(node.getClazz(), col.getValue()));
//                    System.out.println("ImportDialog.beforeSave() :::::::::::::::::::::::::: " + node.getName() + " :::::=====================================" + col.getName() + " ::::: " + node.getValue() + " ::::: "+col.getValue() );
                    map.put(node.getName(), node);
              }
//            }
            index++;
        }

        Object cible = clazz.newInstance();

        Field[] fields = ValidateAndFillBeans.getObjectDeclaredFields(clazz);

        for (Field field : fields) {

            NodeObject node = map.get(field.getName());

            if (node == null) {
                continue;
            }
            field.setAccessible(true);
//            System.out.println("ImportDialog.beforeSave() :::::::::::::::::::::::::: " + node + " :::::=====================================" + node.getClazz() + " ::::: " + node.getValue() + " ::::: " + field.getName());

            if (!node.isEntry()) {
                field.set(cible, node.getValue());
            } else {
                field.set(cible, node.getValue());
            }
        }
        return cible;
    }
    
      /**
     * Convertir la valeur en object
     * @param clazz
     * @param value
     * @return 
     */
    public Object converter(Class<?> clazz , String value){
        
               
        if(clazz.equals(BigDecimal.class)) {
//        	System.out.println(ConversionWUJob.class.getSimpleName()+".converter(Class<?> clazz , String value) :::::::::::::::::: "+value);
            return new BigDecimal(value);
        }else if(clazz.equals(Long.class)){
            return new Long(value);
        }
        else if(clazz.equals(Date.class)){
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {  //System.out.println(ConversionWUJob.class.getSimpleName()+".converter(Class<?> clazz , String value) :::::::::::::::::: "+value);
                  if(value!=null&&!value.trim().isEmpty()&&!value.trim().equalsIgnoreCase("null")){
                          return format.parse(value.trim());
                  }else {
                      return null;
                  }
            } catch (ParseException ex) {
                Logger.getLogger(ConversionWUJob.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(clazz.equals(Ville.class)){
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
     * @param container 
     */
    public void setContainer(ImportEditPanel container) {
        setListener(container);
//        messageDispacher.addObserver(container);
//        EbayMessageItem messageItem = new EbayMessageItem();
//        messageItem.setDateMessage(new Date());
//        messageItem.setMessage("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
//       
//        message.addMessage(messageItem);
        
    }
}
