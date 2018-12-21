/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.core.ifaces.echange.ViewOFManager;
import com.megatimgroup.ebaytools.client.AbstractJobExecutor;
import com.megatimgroup.ebaytools.client.MessageType;
import com.megatimgroup.ebaytools.ebs.ESBMessageKEY;
import com.megatimgroup.model.echange.ViewOperationFinanciere;
import com.megatimgroup.model.operations.DeclarationFinanciere;
import com.megatimgroup.model.operations.DeclarationPM;
import com.megatimgroup.model.operations.DeclarationPP;
import com.megatimgroup.model.parametres.Societe;
import com.megatimgroup.views.operations.ImportEditPanel;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 *
 * @author Commercial_2
 */
public class CreateWUJob extends AbstractJobExecutor{

    
    private List inputs ;
    
   
    
     
    /**
     * 
     * @param nextJob 
     */
    public CreateWUJob(AbstractJobExecutor nextJob) {
        super(nextJob);        
        initialieMessageDispatcher();
        
    }

    /**
     * 
     */
    public CreateWUJob() {
        super();
        initialieMessageDispatcher();
       
    }

    
    
    @Override
    public void process() {
       
       try{ 
        
        //Verification de la validite des données
        
        //Recuperation de la liste des operations de personnes physiques
        List<DeclarationPP> listesPP = (List<DeclarationPP>) token.get(ESBMessageKEY.PP);
        //Extraction de la liste des operations financieres
        List<DeclarationFinanciere> listesOF = (List<DeclarationFinanciere>) token.get(ESBMessageKEY.OF);        
        //Extraction de la liste des personnes morales
        List<DeclarationPM> listesPM = (List<DeclarationPM>) token.get(ESBMessageKEY.PM);        
        
        if((listesPP==null||listesPP.isEmpty())&&(listesPM==null||listesPM.isEmpty())
                &&(listesOF==null||listesOF.isEmpty())) return ;
        //Messages traitement
         MessagesBundle.setBundle(ResourceBundle.getBundle("consolemessages"));
        //bundle = MessagesBundle.getInstace("consolemessages");
        //Initialisation du Dispatcher validate.header
        initialieMessageDispatcher(MessagesBundle.getMessage("pull.header")); 
        //Message de demarrage
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        publish(buildMessage(MessagesBundle.getMessage("pull.start")+" : "+formatter.format(new Date()), MessageType.INITIAL));
//        System.out.println(CreateWUJob.class.getSimpleName()+".process() Personnes physiques :::::::::: "+listesPP+" ::::::::::::::: "+listesOF.size());
        //Initialisation du manager
        GenericManager ppmanager = ManagerHelper.getManager2(DeclarationPP.class);
        GenericManager ofmanager = ManagerHelper.getManager2(DeclarationFinanciere.class);
        GenericManager pmmanager = ManagerHelper.getManager2(DeclarationPM.class);
//        publish(buildMessage(MessagesBundle.getMessage("pull.clean"), MessageType.IN_PROGRESS));
          Map<String , Object> referentiels = new HashMap<String, Object>();
//        publish(buildMessage(MessagesBundle.getMessage("pull.save"), MessageType.IN_PROGRESS));
        //Sauvegarde des données  des personnes physiques
        if(listesPP!=null&&!listesPP.isEmpty()){
            for(DeclarationPP pp: listesPP){
                
               DeclarationPP pers = (DeclarationPP) ppmanager.find("reference", pp.getReference());
               //Mise a jour du referentiel
               if(pers!=null){
                   ppmanager.update(pers.getReference(), pp);
               }else{
                   ppmanager.save(pp);
               }
               referentiels.put(pp.getReference(), pp);
            }
        }  
        
        //Sauvegarde des données  des personnes physiques
        if(listesPM!=null&&!listesPM.isEmpty()){
            for(DeclarationPM pm: listesPM){
                
                DeclarationPM pers = (DeclarationPM) pmmanager.find("reference", pm.getReference());
                
                if(pers==null){
                    pmmanager.save(pm);
                }else{
                    ppmanager.update(pers.getReference(), pm);
                }
                referentiels.put(pm.getReference(), pm);
            }
        }  
//        System.out.println(CreateWUJob.class.getSimpleName()+".process() Operations Financieres :::::::::: "+listesOF+" ::::::::::::::::::::: "+listesOF.size());        
         //Sauvegarde des personnes morales
        if(listesOF!=null&&!listesOF.isEmpty()){
           for(DeclarationFinanciere of:listesOF){
//        	   System.out.println(CreateWUJob.class.getSimpleName()+".process() Operations Financieres :::::::::: "+of+" ::::::::::::::::::::: "+ofmanager);
               Object pers = referentiels.get(of.getReference());
               
               if(pers instanceof DeclarationPP){
                   of.setPysique((DeclarationPP)pers);
               }else{
                   of.setMorale((DeclarationPM)pers);
               }
               ofmanager.save(of);
           }
        }
        
        //Extraction inbound
        String inbound = (String) token.get(ESBMessageKEY.INBOUND);
        if(inbound.trim().equalsIgnoreCase("DB")){
        	//Vider les tables View(temporaire
        	GenericManager viewManager = ManagerHelper.getManager2(ViewOperationFinanciere.class);
        	List<ViewOperationFinanciere> operations = (List<ViewOperationFinanciere>)token.get(ESBMessageKEY.DB_ITEMS);
        	if(operations!=null){
        		
        		for(ViewOperationFinanciere vo : operations){
//        			System.out.println(CreateWUJob.class.getSimpleName()+".process() ::::::::::::::::::::::::::: "+vo.getIdOperation());
        			viewManager.delete(vo.getIdOperation());
        		}
        	}
             //Message de demarrage
            publish(buildMessage(MessagesBundle.getMessage("pull.end")+" : "+formatter.format(new Date()), MessageType.DONE));
            
            return ;
        }
        //Recuperation du Fichier
        File file = (File) token.get(ESBMessageKEY.FILE_STREAM);
        //Lecture des données de la societe
        Societe societe = (Societe) token.get(ESBMessageKEY.SOCIETE);
        //Arret du traitement si societe null
        if(societe==null) return ;
        //Deplacement du fichier
        StringBuilder builder = new StringBuilder(societe.getOutRepository());
        if(inbound.trim().equalsIgnoreCase("TR")){
            builder.append(File.separatorChar).append(EbayHelper.TRANSFERT_REPO)
                .append(File.separatorChar).append(file.getName()).append("Done");        
        }else if(inbound.trim().equalsIgnoreCase("PP")){
            builder.append(File.separatorChar).append(EbayHelper.PP_REPO)
                .append(File.separatorChar).append(file.getName()).append("Done");        
        }else if(inbound.trim().equalsIgnoreCase("PM")){
            builder.append(File.separatorChar).append(EbayHelper.PM_REPO)
                .append(File.separatorChar).append(file.getName()).append("Done");        
        }else if(inbound.trim().equalsIgnoreCase("OF")){
            builder.append(File.separatorChar).append(EbayHelper.OF_REPO)
                .append(File.separatorChar).append(file.getName()).append("Done");        
        }
        //Verification qu'un ancien fichier de même nom n'existe pas
        File old = new File(builder.toString());
        if(old.exists()){
            old.delete();
        }
        //Deplacement du fichier
        file.renameTo(new File(builder.toString()));
         //Message de demarrage
         publish(buildMessage(MessagesBundle.getMessage("pull.end")+" : "+formatter.format(new Date()), MessageType.DONE));
            
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
