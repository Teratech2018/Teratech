/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.ebaytools.client.AbstractJobExecutor;
import com.megatimgroup.ebaytools.client.MessageType;
import com.megatimgroup.model.operations.DeclarationFinanciere;
import com.megatimgroup.model.operations.DeclarationPM;
import com.megatimgroup.model.operations.DeclarationPP;
import com.megatimgroup.views.operations.ImportEditPanel;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author Commercial_2
 */
public class PullJob extends AbstractJobExecutor{

    
    private List inputs ;
    
   
    
     
    /**
     * 
     * @param nextJob 
     */
    public PullJob(AbstractJobExecutor nextJob) {
        super(nextJob);
        
         MessagesBundle.setBundle(ResourceBundle.getBundle("consolemessages"));
        //bundle = MessagesBundle.getInstace("consolemessages");
        //Initialisation du Dispatcher validate.header
        initialieMessageDispatcher(MessagesBundle.getMessage("pull.header")); 
        
    }

    
    
    @Override
    public void process() {
       
       try{ 
        //Message de demarrage
        publish(buildMessage(MessagesBundle.getMessage("pull.start"), MessageType.INITIAL));
        //Verification de la validite des données
        if(inputs==null||inputs.isEmpty()){
            //Message de demarrage
            publish(buildMessage(MessagesBundle.getMessage("pull.error"), MessageType.IN_ERROR));
            return ;
        }
        
        //Initialisation du manager
        GenericManager manager = ManagerHelper.getManager2(inputs.get(0).getClass());
        publish(buildMessage(MessagesBundle.getMessage("pull.clean"), MessageType.IN_PROGRESS));
        List datas = manager.findAll();
        for(Object input : datas){
            if(input instanceof DeclarationFinanciere){
                manager.delete(((DeclarationFinanciere)input).getId());
            }else if(input instanceof DeclarationPM){
                manager.delete(((DeclarationPM)input).getReference());
            }else if(input instanceof DeclarationPP){
                manager.delete(((DeclarationPP)input).getReference());
            }
        }
        publish(buildMessage(MessagesBundle.getMessage("pull.save"), MessageType.IN_PROGRESS));
        //Sauvegarde des données
         manager.save(inputs);  
         
         //Message de demarrage
         publish(buildMessage(MessagesBundle.getMessage("pull.end"), MessageType.DONE));
            
       }catch(Exception ex){
           //Message de demarrage
           publish(buildMessage(MessagesBundle.getMessage("pull.error"), MessageType.IN_ERROR));
           ex.printStackTrace();
       }
        //Fin du traitement
        
    }

    /**
     * 
     * @param inputs 
     */
    public void setInputs(List inputs) {
        this.inputs = inputs;
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
