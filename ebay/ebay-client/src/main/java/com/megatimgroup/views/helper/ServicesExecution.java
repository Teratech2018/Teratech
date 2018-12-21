/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.megatimgroup.model.parametres.Societe;
import com.megatimgroup.views.jaxb.Service;
import com.megatimgroup.views.jaxb.Services;
import java.io.File;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Commercial_2
 */
public class ServicesExecution {
    
    private static Observer console ;

    /**
     * 
     */
    public ServicesExecution() {
    }
    
    
    public static void start() {
        try {
            Services services = JaxbHelper.getServices(ServicesExecution.class.getResourceAsStream("/META-INF/ebay-esb.xml"));
            
            //Verification validite 
            if(services==null)  return ;
            
            //Creation de l'environnement
            //Recuperation de la societe
           Societe societe = (Societe) ManagerHelper.getManager2(Societe.class).findAll().get(0);
           
           //Verification de la validite de la societe
           if(societe==null) throw new Exception("societe.null");
           
           //Verification de la disponibilite des repertoire d'echange
           if(societe.getInRepository()==null||societe.getInRepository().trim().isEmpty()||
                   societe.getOutRepository()==null||societe.getOutRepository().trim().isEmpty()||
                   societe.getErrRepository()==null||societe.getErrRepository().trim().isEmpty())
               throw  new Exception("societe.repository.null");
           
           File fichier = new File(societe.getInRepository());
           
           if(!fichier.exists()){
               //Creation des sous repertoires
               fichier.mkdir();
               //Repertoire de transfert               
               File transf = new File(fichier.getAbsolutePath()+File.separatorChar+EbayHelper.TRANSFERT_REPO);
               transf.mkdir();
               //Repertoire des Persones physiques
               File pp = new File(fichier.getAbsolutePath()+File.separatorChar+EbayHelper.PP_REPO);
               pp.mkdir();
               //Repertoire des Persones physiques
               File pm = new File(fichier.getAbsolutePath()+File.separatorChar+EbayHelper.PM_REPO);
               pm.mkdir();
               //Repertoire des Persones physiques
               File of = new File(fichier.getAbsolutePath()+File.separatorChar+EbayHelper.OF_REPO);
               of.mkdir();
           }
           //Creation des sous repertoires  de sortie
           fichier = new File(societe.getOutRepository());
           
           if(!fichier.exists()){
               //Creation des sous repertoires
               fichier.mkdir();
               //Repertoire de transfert               
               File transf = new File(fichier.getAbsolutePath()+File.separatorChar+EbayHelper.TRANSFERT_REPO);
               transf.mkdir();
               //Repertoire des Persones physiques
               File pp = new File(fichier.getAbsolutePath()+File.separatorChar+EbayHelper.PP_REPO);
               pp.mkdir();
               //Repertoire des Persones physiques
               File pm = new File(fichier.getAbsolutePath()+File.separatorChar+EbayHelper.PM_REPO);
               pm.mkdir();
               //Repertoire des Persones physiques
               File of = new File(fichier.getAbsolutePath()+File.separatorChar+EbayHelper.OF_REPO);
               of.mkdir();
           }
           
           //Creation des sous repertoires  des erreurs
           fichier = new File(societe.getErrRepository());
           
           if(!fichier.exists()){
               //Creation des sous repertoires
               fichier.mkdir();
               //Repertoire de transfert               
               File transf = new File(fichier.getAbsolutePath()+File.separatorChar+EbayHelper.TRANSFERT_REPO);
               transf.mkdir();
               //Repertoire des Persones physiques
               File pp = new File(fichier.getAbsolutePath()+File.separatorChar+EbayHelper.PP_REPO);
               pp.mkdir();
               //Repertoire des Persones physiques
               File pm = new File(fichier.getAbsolutePath()+File.separatorChar+EbayHelper.PM_REPO);
               pm.mkdir();
               //Repertoire des Persones physiques
               File of = new File(fichier.getAbsolutePath()+File.separatorChar+EbayHelper.OF_REPO);
               of.mkdir();
           }
            //Reference sur le serviceexecutor courant
            ServiceExecutor executor =null ;
            //Traitement
            for(Service service : services.getService()){
                //Creation d'une instance de serviceexecutor
                executor = new ServiceExecutor(service);
                //Mise a jour observateur
                executor.setConsole(console);
                //Demarrage du service
                executor.start();
            }
        }  catch (JAXBException ex) {
            Logger.getLogger(ServicesExecution.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex) {
            Logger.getLogger(ServicesExecution.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * @param console 
     */
    public static void setConsole(Observer console) {
        ServicesExecution.console = console;
    }

   
    
    
}
