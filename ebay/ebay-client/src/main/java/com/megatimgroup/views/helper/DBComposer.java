/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.jaxb.entities.Temporalfile;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.ebaytools.client.AbstractJobExecutor;
import com.megatimgroup.ebaytools.client.EbayItem;
import com.megatimgroup.ebaytools.client.MessageType;
import com.megatimgroup.ebaytools.client.NodeObject;
import com.megatimgroup.ebaytools.ebs.ESBMessageKEY;
import com.megatimgroup.model.echange.ViewOperationFinanciere;
import com.megatimgroup.model.operations.WesternItem;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Initialise les parametres d'acces a la base de données
 * @author Commercial_2
 */
public class DBComposer extends AbstractJobExecutor{

    /**
     * 
     */
    public DBComposer() {
        
        initialieMessageDispatcher();
        
    }

    /**
     * 
     * @param nextJob 
     */
    public DBComposer(AbstractJobExecutor nextJob) {
        super(nextJob);
        initialieMessageDispatcher();
    }

    
    
    @Override
    public void process() {
        try {
            String inbound = properties.get(ESBMessageKEY.INBOUND);     
            //Recuperation de la source
            if(properties.get("inbound")==null||properties.get("inbound").trim().isEmpty()){
                return ;
            }else{
                inbound = properties.get("inbound");
            }
            token.put(ESBMessageKEY.INBOUND, inbound);
            //Liste des elements
            List<EbayItem> items = new ArrayList<EbayItem>();
            
            GenericManager  manager = ManagerHelper.getManager2(ViewOperationFinanciere.class);
            
             List<ViewOperationFinanciere> operations = manager.findAll();        

             //Verification de la validite
             if(operations==null||operations.isEmpty()) return ;
           
             MessagesBundle.setBundle(ResourceBundle.getBundle("consolemessages"));
             //Initialisation du Dispatcher
             SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
             initialieMessageDispatcher(MessagesBundle.getMessage("loading.header"));      
             publish(buildMessage(MessagesBundle.getMessage("loading.start")+" : "+formatter.format(new Date()), MessageType.INITIAL));
             //Liste des PP
             List<EbayItem> listePP = new ArrayList<EbayItem>();
             //Liste des PM
             List<EbayItem> listePM = new ArrayList<EbayItem>();
             //Liste des OF
             List<EbayItem> listeOF = new ArrayList<EbayItem>();
             //
             for(ViewOperationFinanciere oper : operations){
                 
                 if(oper.getPP()!=null){
                     listePP.add(oper.getPP());
                 }
                 
                 if(oper.getPM()!=null){
                     listePM.add(oper.getPM());
                 }
                 
                 listeOF.add(oper.getOF());
             }
             
             //Validation des données de la base de données
              //Construction du temporalfiel
             List<NodeObject> nodes = EbayHelper.getNodeObjects(ViewOperationFinanciere.class);
             //INitialisation de la liste eventuelle des erreurs
             Temporalfile temporalefile = EbayHelper.buildFormItem(listeOF, nodes);                 
             //Validation des personnes physiques et des Operations financieres
             Validator validator = new Validator(nodes, temporalefile, true);
             Boolean result = validator.validate();
             
             if(result){
                    token.put(ESBMessageKEY.PP_ITEMS, listePP);
                    token.put(ESBMessageKEY.PM_ITEMS, listePM);
                    token.put(ESBMessageKEY.OF_ITEMS, listeOF);
                    token.put(ESBMessageKEY.DB_ITEMS, operations);
                    publish(buildMessage(MessagesBundle.getMessage("loading.end")+" : "+formatter.format(new Date()), MessageType.DONE));            
             }else{
                    token.put(ESBMessageKEY.PP_ITEMS, new ArrayList<EbayItem>());
                    token.put(ESBMessageKEY.PM_ITEMS, new ArrayList<EbayItem>());
                    token.put(ESBMessageKEY.OF_ITEMS, new ArrayList<EbayItem>());
                    token.put(ESBMessageKEY.ERRORS_ITEMS, validator.getErrors());
                     //Ajout des errors
                    messageDispacher.setErrors(validator.getErrors());
                    publish(buildMessage(MessagesBundle.getMessage("loading.error"), MessageType.IN_ERROR));
//                    token.put(ESBMessageKEY.DB_ITEMS, operations);
                    
             }
            
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DBComposer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DBComposer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
