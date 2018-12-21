/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.megatimgroup.ebaytools.client.AbstractJobExecutor;
import com.megatimgroup.ebaytools.ebs.ESBMessageKEY;
import com.megatimgroup.model.parametres.Societe;
import java.io.File;
import java.io.FileFilter;

/**
 * Classe responsable du chargement des données en memoire
 * @author Commercial_2
 */
public class WesternComposer extends AbstractJobExecutor{
    
    //Fichier contenant les données 
    private File inputFile ;

    //Societe
    private Societe societe ; 

    //Extension des fichiers traites par service
    private String extension ="csv";
    
    private String inbound ="TR";
    /**
     * 
     * @param nextJob 
     */
    public WesternComposer(AbstractJobExecutor nextJob) {
        super(nextJob);
        initialieMessageDispatcher();
    }

    /**
     * 
     */
    public WesternComposer() {
        super();
        initialieMessageDispatcher();
    }
    
   
    
    
    @Override
    public void process() {
//       System.out.println(WesternComposer.class.getSimpleName()+".process() ::::::::::::::::::::::::::::::::::::::::::::::::::::  ");
       try{
           //Recuperation de la societe
           Societe societe = (Societe) ManagerHelper.getManager2(Societe.class).findAll().get(0);
           
           //Verification de la validite de la societe
           if(societe==null) throw new Exception("societe.null");
           
           //Verification de la disponibilite des repertoire d'echange
           if(societe.getInRepository()==null||societe.getInRepository().trim().isEmpty()||
                   societe.getOutRepository()==null||societe.getOutRepository().trim().isEmpty()||
                   societe.getErrRepository()==null||societe.getErrRepository().trim().isEmpty())
               throw  new Exception("societe.repository.null");
           //Recuperation de la source
           if(properties.get("inbound")==null||properties.get("inbound").trim().isEmpty()){
               return ;
           }else{
               inbound = properties.get("inbound");
           }
           //Mise a jour du connecteur d'entree dans le message
           token.put(ESBMessageKEY.INBOUND, inbound);
           StringBuilder builder = new StringBuilder();
           //Rechercher des fichiers
           if(inbound.trim().equalsIgnoreCase("TR")){
               builder.append(societe.getInRepository()).append(File.separatorChar).append(EbayHelper.TRANSFERT_REPO);
           }else if(inbound.trim().equalsIgnoreCase("PP")){
               builder.append(societe.getInRepository()).append(File.separatorChar).append(EbayHelper.PP_REPO);
           }else if(inbound.trim().equalsIgnoreCase("PM")){
               builder.append(societe.getInRepository()).append(File.separatorChar).append(EbayHelper.PM_REPO);
           }else if(inbound.trim().equalsIgnoreCase("OF")){
               builder.append(societe.getInRepository()).append(File.separatorChar).append(EbayHelper.OF_REPO);
           }
           //Lecture du fichier
           File fichier = new File(builder.toString());
           //Verification de la validite du fichier
           if(fichier==null)   return ;
           
           //Construction du filtre pour fichier .csv
           FileFilter filter = new FileFilter() {

               public boolean accept(File pathname) {
                   return (pathname.getName().toLowerCase().endsWith(".csv")||pathname.getName().toLowerCase().endsWith(".txt"));
               }
           };
           //Extraction des fichiers .csv
           File[] files = fichier.listFiles(filter);
            
           //Verification de la non vidité du repertoire
           if(files==null||files.length==0)  return ;           
           //Recuperation du premier fichier
           this.setInputFile(files[0]);
           
           //Ajout de fichier dans le body du jeton
           this.token.put(ESBMessageKEY.FILE_STREAM, inputFile);
           token.put(ESBMessageKEY.SOCIETE, societe);
           
//           System.out.println(WesternComposer.class.getSimpleName()+".process() :::: Chargement du  fichier  ========  "+inputFile+" ::::: "+inbound);
       }catch(Exception ex){
           ex.printStackTrace();
       }         
        
    }
    
    

    public File getInputFile() {
        return inputFile;
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getInbound() {
        return inbound;
    }

    public void setInbound(String inbound) {
        this.inbound = inbound;
    }
    
    

}
