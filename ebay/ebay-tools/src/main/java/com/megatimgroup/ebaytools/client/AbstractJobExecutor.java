/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.ebaytools.client;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.ResourceBundle;


/**
 *
 * @author Commercial_2
 */
public abstract class AbstractJobExecutor {
    
    //La prochaine tache a executer
    protected AbstractJobExecutor nextJob ;
    
    //Nombre de processus pour ce job
    protected int processors = 1 ;
    
    //Ecouteur du message
    protected Observer listener ;
    
    //Dispatcher de message
    protected EbayMessage messageDispacher ;
    
    //Message Bundle
    protected ResourceBundle bundle ;
    
    protected Map<String , Object> token ;

   protected Map<String,String> properties = new HashMap<String, String>();
    
    /**
     * 
     */
    public AbstractJobExecutor() {
    }
    

    
    
    /**
     * 
     * @param nextJob 
     */
    public AbstractJobExecutor(AbstractJobExecutor nextJob) {
        //Initialisation du token
//        this.token = new HashMap<String, Object>();
        //Initialisation du 
        this.nextJob = nextJob;
    }

    public AbstractJobExecutor getNextJob() {
        return nextJob;
    }

//    public void setNextJob(AbstractJobExecutor nextJob) {
//        this.nextJob = nextJob;
//    }

    /**
     * 
     * @return 
     */
    public int getProcessors() {
        return processors;
    }

    
    /**
     * 
     * @param processors 
     */
    public void setProcessors(int processors) {
        this.processors = processors;
    }

    /**
     * 
     * @param listener 
     */
    public void setListener(Observer listener) {
        this.listener = listener;
        
        //Enregister l'ecouteur
        if(messageDispacher!=null&&listener!=null){
            messageDispacher.addObserver(listener);
        }
    }

    /**
     * 
     * @param messageDispacher 
     */
    public void setMessageDispacher(EbayMessage messageDispacher) {
        this.messageDispacher = messageDispacher;
    }
    
    
    
    /**
     * Fonction implementant le metier 
     */
    public abstract void process() ;
    
    /**
     * Publi le message dans la file de message
     * @param message 
     */
    public void publish(EbayMessageItem message){
        
        //Verification de la validite du messages
        if(message==null)  return ;
        
        //Verifier qu'un routeur de message est disponible
        if(messageDispacher==null) return ;
        
        //Verifier que un destinataire est enregistre
        if(listener==null) return ;
        
        //Mise a jour du statut des messages
        messageDispacher.setStatut(message.getStatut());
        //Envoie du message
         messageDispacher.addMessage(message);
    }
    
    /**
     * Initialise le routeur de messages
     * @param message 
     */
    public void initialieMessageDispatcher(String message){
        
        //Creer un dispacher s'il n'existe pas encore
        if(messageDispacher==null){
            messageDispacher = new EbayMessage();      
        }
         //Initialisation du message
        messageDispacher.setMessage(message);
        messageDispacher.setDebut(new Date());
        messageDispacher.setStatut(MessageType.INITIAL);
    }
    
    /**
     * Initialise le routeur de messages
     * @param message 
     */
    public void initialieMessageDispatcher(){
        
        //Creer un dispacher s'il n'existe pas encore
        if(messageDispacher==null){
            messageDispacher = new EbayMessage();        
//            //Initialisation du message
//            messageDispacher.setMessage(message);
//            messageDispacher.setDebut(new Date());
//            messageDispacher.setStatut(MessageType.INITIAL);
        }
    }
    /**
     * Message de fin de traitement
     * @param message 
     */
    public void doneMessageDispatcher(EbayMessageItem message){
        
        //Verification de la validite du messages
        if(message==null)  return ;
        
        //Verification de la disponibilité du dispacher
        if(messageDispacher==null)  return ;
        
        //Verification disponibilite ecouteur
        if(listener==null)  return ;
        
        //Mise a jour du statut message
        messageDispacher.setStatut(MessageType.DONE);
        //Transfert message
        messageDispacher.addMessage(message);
        
        
    }
    
    /**
     * 
     * @param message
     * @return 
     */
    public EbayMessageItem buildMessage(String message,MessageType type){
        
        EbayMessageItem item = new EbayMessageItem();
        item.setMessage(message);
        item.setDateMessage(new Date());
        item.setStatut(type);        
        return item ;
        
    }

    /**
     * Partage du message
     * @param token 
     */
    public void setToken(Map<String, Object> token) {
        this.token = token;
    }

    /**
     * 
     * @param properties 
     */
    public void setProperties(List<Map<String, String>> values) {
      
        //Verification de la validite des entites
        if(values==null||values.isEmpty()) return ;
        //Construction des propertie
        for(Map<String,String> m : values){
            properties.putAll(m);
        }
    }
    
    
}
