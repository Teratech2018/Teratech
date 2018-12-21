/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.megatim.common.jaxb.entities.Temporalfile;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.ebaytools.client.AbstractJobExecutor;
import com.megatimgroup.ebaytools.client.MessageType;
import com.megatimgroup.ebaytools.client.NodeObject;
import com.megatimgroup.views.operations.ImportEditPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Commercial_2
 */
public class ValidateJob extends AbstractJobExecutor{

    
    private ImportData imputData ;
    
    private Temporalfile temporal ;
    
    /**
     * 
     * @param nextJob 
     */
    public ValidateJob(AbstractJobExecutor nextJob) {
        super(nextJob);
        
        MessagesBundle.setBundle(ResourceBundle.getBundle("consolemessages"));
        //bundle = MessagesBundle.getInstace("consolemessages");
        //Initialisation du Dispatcher validate.header
        initialieMessageDispatcher(MessagesBundle.getMessage("validate.header"));   
        
    }

    
    
    @Override
    public void process() {
        
            List<NodeObject> rules = new ArrayList<NodeObject>(); //= imputData.getModele().buildNode();
            
           try {
               Class<?> clazz = Class.forName(imputData.getModele().getElements().get(0).getParentClassName());
               rules = imputData.getModele().buildNode(EbayHelper.getNodeObjects(clazz));
            //Message de demarrage
            publish(buildMessage(MessagesBundle.getMessage("validate.start"), MessageType.INITIAL));
            
            //Validation des données
            Validator validator = new Validator(rules, temporal,false);
            
            //Initialisaation du nombre de thread
            validator.setProcessors(30);
            //Demarrage de la validation
            Boolean result = validator.validate();
            
            //Traitement du resultat de la validation
            if(!result){
                 //Ajout des erreurs dans le message*
                  messageDispacher.setErrors(validator.getErrors());
                  //Publication du messages
                 publish(buildMessage(MessagesBundle.getMessage("validate.error"), MessageType.IN_ERROR));                 
                 //Arret du traitement
                 return ;
            }
           // boolean resultat =validator.validate();
             //Message de fin de traitement
            publish(buildMessage(MessagesBundle.getMessage("validate.end"), MessageType.DONE));
            
            
        } catch (ClassNotFoundException ex) {
             publish(buildMessage(MessagesBundle.getMessage("validate.error"), MessageType.IN_ERROR));
            Logger.getLogger(ValidateJob.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(nextJob!=null){
             nextJob.setListener(listener);  
            if(nextJob instanceof ConversionJob){
                ((ConversionJob)nextJob).setRules(rules);
                ((ConversionJob)nextJob).setTemporalFile(temporal);
                ((ConversionJob)nextJob).setClazz(rules.get(0).getParentClazz());
            }
            nextJob.process();
       }
    }

    /**
     * 
     * @param imputData 
     */
    public void setImputData(ImportData imputData) {
        this.imputData = imputData;
    }

    
    /**
     * 
     * @param temporal 
     */
    public void setTemporal(Temporalfile temporal) {
        this.temporal = temporal;
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
