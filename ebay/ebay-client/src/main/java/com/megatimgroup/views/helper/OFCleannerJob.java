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
import com.megatimgroup.model.operations.DeclarationPP;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author Commercial_2
 */
public class OFCleannerJob extends AbstractJobExecutor{

    /**
     * 
     * @param nextJob 
     */
    public OFCleannerJob(AbstractJobExecutor nextJob) {
        super(nextJob);
        
         
         MessagesBundle.setBundle(ResourceBundle.getBundle("consolemessages"));
        //bundle = MessagesBundle.getInstace("consolemessages");
        //Initialisation du Dispatcher validate.header
        initialieMessageDispatcher(MessagesBundle.getMessage("of.clean.header"));  
    }

    
    
    @Override
    public void process() {
        try{
            //Message de demarrage
            publish(buildMessage(MessagesBundle.getMessage("of.clean.start"), MessageType.INITIAL));
            //Injection du manager
            GenericManager manager = ManagerHelper.getManager2(DeclarationFinanciere.class);         
            //Recuperation de la liste des Declarations
            List<DeclarationFinanciere> datas = manager.findAll();
            if(datas!=null&&!datas.isEmpty()){    
                //Message de demarrage
                publish(buildMessage(MessagesBundle.getMessage("of.clean.load"), MessageType.IN_PROGRESS));
                //Nettoyage de la base de données
                for(DeclarationFinanciere data : datas){
                    manager.delete(data.getId());
                }
                publish(buildMessage(MessagesBundle.getMessage("of.clean.clean"), MessageType.IN_PROGRESS));
            }
            publish(buildMessage(MessagesBundle.getMessage("of.clean.end"), MessageType.DONE));
        }catch(Exception ex){
             publish(buildMessage(MessagesBundle.getMessage("of.clean.error"), MessageType.IN_ERROR));
       }
         if(nextJob!=null){
             nextJob.setListener(listener);            
            //Execution
            nextJob.process();
        }
    }
    
}
