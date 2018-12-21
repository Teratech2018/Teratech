/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.megatimgroup.ebaytools.client.AbstractJobExecutor;
import com.megatimgroup.views.jaxb.Action;
import com.megatimgroup.views.jaxb.Listener;
import com.megatimgroup.views.jaxb.Property;
import com.megatimgroup.views.jaxb.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Class responsable de la mise en place de la pile d'execution 
 * d'un service
 * @author Commercial_2
 */
public class ServiceExecutor extends Thread{

    private Map<String,Object> token = null ;
    
    //Reference sur les informations du service
    private Service service ;
    
     private Observer console ;
    
    /**
     * 
     */
    public ServiceExecutor(Service service) {
        
        token = new HashMap<String, Object>();
        
        this.service = service ;
                
    }

    @Override
    public void run() {
        try {
          
            super.run();
            
            while(true){

                //Reinitialisation du token
                 token = new HashMap<String, Object>();
                //Traitement de l'ecouteur
                Listener listener = service.getListener();

                if(listener==null) return ;
                //Extension de l'ecouteur
                AbstractJobExecutor listenerExecutor = (AbstractJobExecutor) Class.forName(listener.getComposerClass()).newInstance();
                //Initialisation des propertes
                listenerExecutor.setProperties(propertyToMap(listener.getProperty()));
                //Ajout du listener
                listenerExecutor.setListener(console);
                //Passage du token
                listenerExecutor.setToken(token);
                //Demarrage de l'ecouteur
                listenerExecutor.process();
                //Variable
                AbstractJobExecutor actionExecutor = null ;
                //Debut de l'execution des actions
                for(Action action : service.getActions().getAction()){

                    //Traitement de l'action courante
                    actionExecutor = (AbstractJobExecutor) Class.forName(action.getClazz()).newInstance();
                    //Initialisation des properties
                    actionExecutor.setProperties(propertyToMap(action.getProperty()));
                    //Ajout du listener
                    actionExecutor.setListener(console);
                    //Passage du token
                    actionExecutor.setToken(token);
                    //demarrage du traitement de l'action
                    actionExecutor.process();
                }
                //Mise en sommeil du service pendant cycle secondes
                Thread.sleep(service.getCycle()*1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ServiceExecutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServiceExecutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServiceExecutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServiceExecutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * 
     * @param properties
     * @return 
     */
    private List<Map<String , String>> propertyToMap(List<Property> properties){
        
        //Initialisatioh
        List<Map<String,String>> values = new ArrayList<Map<String,String>>();
         
        if(properties==null||properties.isEmpty()) return values;
        
        //Construction de la liste
        for(Property prop : properties){
            Map<String,String> map = new HashMap<String, String>();
            map.put(prop.getName(), prop.getValue());
            values.add(map);
        }
        
        return values;
    }

    /**
     * 
     * @param console 
     */
    public void setConsole(Observer console) {
        this.console = console;
    }
    
    
    
    
}
