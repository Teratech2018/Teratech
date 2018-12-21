/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.megatim.common.export.ParserHelper;
import com.megatim.common.jaxb.entities.Temporalfile;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.ebaytools.client.AbstractJobExecutor;
import com.megatimgroup.ebaytools.client.EbayItem;
import com.megatimgroup.ebaytools.client.MessageType;
import com.megatimgroup.views.operations.ImportEditPanel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author Commercial_2
 */
public class LoadingJob extends AbstractJobExecutor{

    
    private List<EbayItem> results ;
    
    private ImportData imputData ;    
       
//    private ImportEditPanel container ;
//    
//    private EbayMessage message ;
    
    
    /**
     * 
     * @param nextJob 
     */
    public LoadingJob(AbstractJobExecutor nextJob) {
        
        super(nextJob);
        
        //Initialisation de la liste
        results = new ArrayList<EbayItem>();  
       
        MessagesBundle.setBundle(ResourceBundle.getBundle("consolemessages"));
        //bundle = MessagesBundle.getInstace("consolemessages");
        //Initialisation du Dispatcher
        initialieMessageDispatcher(MessagesBundle.getMessage("loading.header"));          
       
    }

    
    
    /**
     * 
     */
    @Override
    public void process() {
        Temporalfile template =null;
        try {
            
            //Publication mesage demarrage 
            publish(buildMessage(MessagesBundle.getMessage("loading.start"), MessageType.INITIAL));
//            System.out.println("LoadingJob.process()::::::::::::::::::::::::::::::::::::::::::::::::::::  "+imputData.getModele().getFields());
            template = ParserHelper.cvsToJAXBParser(imputData.getFile(), imputData.getModele().getFields(), EbayItem.class);
            publish(buildMessage(MessagesBundle.getMessage("loading.end"), MessageType.DONE));            
            
        } catch (Exception ex) {
            publish(buildMessage(MessagesBundle.getMessage("loading.error"), MessageType.IN_ERROR));
        }
        
       
        if(nextJob!=null){
            nextJob.setListener(listener);
            if(nextJob instanceof ValidateJob){
                ((ValidateJob)nextJob).setImputData(imputData);
                ((ValidateJob)nextJob).setTemporal(template);
            }
            nextJob.process();
        }
    }

//    private void print(Temporalfile file){
//        
//        for(Fileline line : file.getFileline()){
//            
//            for(Linecolumn column : line.getLinecolumn()){
//                 
//                System.out.println(column.getName()+" = "+column.get);
//            }
//        }
//    }
    /**
     * Renvoie la liste des tuples 
     * @return 
     */
    public List<EbayItem> getResults() {
        return Collections.unmodifiableList(results);
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
