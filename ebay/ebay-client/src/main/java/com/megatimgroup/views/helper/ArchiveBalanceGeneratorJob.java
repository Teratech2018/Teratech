/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.ebaytools.client.EbayItem;
import com.megatimgroup.model.archivage.ArchiveOperation;
import com.megatimgroup.model.operations.DeclarationFinanciere;
import com.megatimgroup.model.operations.DeclarationPM;
import com.megatimgroup.model.operations.DeclarationPP;
import com.megatimgroup.model.reporting.BordereauBP;

/**
 * Processus de chargement des operation financieres d'une periode
 * @author Commercial_2
 */
public class ArchiveBalanceGeneratorJob {

    private static Date dateDebut ;
    
    private static Date dateFin ;
    
    private static String mois ;
    
    
     private Periode periode ;
    
//    private String annee ;
    
    private static String fileName ;
    
    private static BordereauBP bordero ;    
    
    
    public static final String extension = ".txt";
    /**
     * 
     */


    
    /**
     * 
     * @param nextJob 
     */
    public ArchiveBalanceGeneratorJob() {
        
         bordero = new BordereauBP();
    }

    

    public static BordereauBP generateArchiveBalance(List<ArchiveOperation> v$list, BordereauBP v$bordereau) {
        try {
        	System.out.println("ArchiveBPDialog.beforeSave() debut generation archive...44444");
        	bordero=v$bordereau;  
        	dateDebut = bordero.getDateDebut();
        	dateFin=bordero.getDateFin();
        	mois = bordero.getlMoisGeneration().getVal();
        	fileName = bordero.getFileName();
        	bordero.setReportFiledeport(fileName);
             //Chargement des parametres
            bordero.setSociete(CurrentSessionInformations.getCurrentSociete());

             List<ArchiveOperation> archivelist = v$list;
             //Verification de l'existance des données
             if(archivelist==null||archivelist.isEmpty()){
                             
             }
             
             //Extraction des referentiels des personnes physiques et morales
             List<DeclarationPP> physiques = new ArrayList<DeclarationPP>();
             List<DeclarationPM> morales = new ArrayList<DeclarationPM>();
             List<DeclarationFinanciere> operations = new ArrayList<DeclarationFinanciere>();
             //Extraction du referentiel des personnes physiques et morales et df
             for(ArchiveOperation archive : archivelist){
                 //Recherche dans le referentiel des personnes physique
            	 	
            	 if(archive.getlRai()!=null){
                     //C'est une personnes morales
                     morales.add(archive.getMorale());
            	 }else{
                     //C'est une personnes morales
                     physiques.add(archive.getPhysisque());
            	 }
                     // operations financieres
                     operations.add(archive.getOperation());
             }
             List<EbayItem> pmitems = new ArrayList<EbayItem>();
             List<EbayItem> ppitems = new ArrayList<EbayItem>();
             //Conversion des données in Items
              List<EbayItem> ofitems = EbayHelper.convertFromFI(operations);
              bordero.setNombreOF(ofitems.size());
              System.out
					.println("ArchiveBalanceGeneratorJob.generateArchiveBalance() taile morale"+morales.size());
              if(!morales.isEmpty()||morales.size()!=0);{
              pmitems = EbayHelper.convertFromPM(morales);
              bordero.setNombrePM(pmitems.size());
              }
              if(!physiques.isEmpty()||physiques.size()!=0){
               ppitems = EbayHelper.convertFormPP(physiques);
              bordero.setNombrePP(ppitems.size());
              }
             
                //Generation des fichiers
              	transformPP(ppitems);
                transformPM(pmitems);
                transformOF(ofitems);
          
        } catch (IOException ex) {
         
            Logger.getLogger(ArchiveBalanceGeneratorJob.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ArchiveBalanceGeneratorJob.class.getName()).log(Level.SEVERE, null, ex);
        }
		return bordero;
    }
    
    

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public BordereauBP getBordero() {
        return bordero;
    }

    public void setBordero(BordereauBP bordero) {
        this.bordero = bordero;
    }
    
     /**
     * Geeration du fichier 
     * @param datas
     * @throws IOException 
     */
    private static void  transformOF(List<EbayItem> datas) throws IOException{
       
        StringBuilder builder = new StringBuilder(fileName);
        builder.append(File.separatorChar).append(fileNameOFBuilder());
        
        //System.out.println("========================================================================= "+builder.toString());
        File file  = new File(builder.toString());
        
        //Creation du fichier
        file.createNewFile();
        
        //Creation d'un 
        FileWriter writer = new FileWriter(file);
        //Creation d'un tempon de sortie
        BufferedWriter buffer = new BufferedWriter(writer);
        
        //Creation d'un line formatter
        LineFormatter formatter = new LineFormatter();
        //Ecriture en tete
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
        buffer.write(formatter.format(bordero.getSociete().getCode().trim(),formatter2.format(dateFin)));
        buffer.newLine();
        //Traitement des données
        for(EbayItem item : datas){
            
            buffer.write(formatter.format(item.toStringOF()));
            buffer.newLine();
        }
        
        //Mise a jour du nombre de 
        bordero.setNombreOF(datas.size());
        //Mise a jour du fichier
        buffer.write(formatter.format(Integer.toString(datas.size())));
        buffer.newLine();
        //Cloture du tempon
        buffer.close();
        //Cloture du flux
        writer.close();
    }
    
    
    
     /**
     * Geeration du fichier 
     * @param datas
     * @throws IOException 
     */
    private static void  transformPP(List<EbayItem> datas) throws IOException{
       
        StringBuilder builder = new StringBuilder(fileName);
        builder.append(File.separatorChar).append(fileNamePPBuilder());
        
        //System.out.println("========================================================================= "+builder.toString());
        File file  = new File(builder.toString());
        
        //Creation du fichier
        file.createNewFile();
        
        //Creation d'un 
        FileWriter writer = new FileWriter(file);
        //Creation d'un tempon de sortie
        BufferedWriter buffer = new BufferedWriter(writer);
        
        //Creation d'un line formatter
        LineFormatter formatter = new LineFormatter();
        //Ecriture en tete
        buffer.write(formatter.format(bordero.getSociete().getCode().trim()));
        buffer.newLine();
        //Traitement des données
        for(EbayItem item : datas){
            
            buffer.write(formatter.format(item.toStringPP()));
            buffer.newLine();
        }
        
        //Mise a jour du nombre de 
        bordero.setNombrePP(datas.size());
        bordero.setReportFiledeport(fileName);
        //Mise a jour du fichier
        buffer.write(formatter.format(Integer.toString(datas.size())));
        buffer.newLine();
        //Cloture du tempon
        buffer.close();
        //Cloture du flux
        writer.close();
    }
    
    
      /**
     * Geeration du fichier 
     * @param datas
     * @throws IOException 
     */
    private static void  transformPM(List<EbayItem> datas) throws IOException{
       
        StringBuilder builder = new StringBuilder(fileName);
        builder.append(File.separatorChar).append(fileNamePMBuilder());
        
        //System.out.println("========================================================================= "+builder.toString());
        File file  = new File(builder.toString());
        
        //Creation du fichier
        file.createNewFile();
        
        //Creation d'un 
        FileWriter writer = new FileWriter(file);
        //Creation d'un tempon de sortie
        BufferedWriter buffer = new BufferedWriter(writer);
        
        //Creation d'un line formatter
        LineFormatter formatter = new LineFormatter();
        //Ecriture en tete
        buffer.write(formatter.format(bordero.getSociete().getCode().trim()));
        buffer.newLine();
        //Traitement des données
        for(EbayItem item : datas){
            
            buffer.write(formatter.format(item.toStringPM()));
            buffer.newLine();
        }
        
        //Mise a jour du nombre de 
        bordero.setNombrePM(datas.size());
        //Mise a jour du fichier
        buffer.write(formatter.format(Integer.toString(datas.size())));
        buffer.newLine();
        //Cloture du tempon
        buffer.close();
        //Cloture du flux
        writer.close();
    }

    /**
     * 
     * @return 
     */
    private static String fileNamePMBuilder(){
        
        StringBuilder builder = new StringBuilder();
        
        builder.append(EbayHelper.annee(dateDebut)).append(EbayHelper.getPeriode(dateDebut).toString()).append("E").append(bordero.getSociete().getCode()).append(extension);
        
        return builder.toString();
    }
    

    public String getMois() {
		return mois;
	}



	public void setMois(String mois) {
		this.mois = mois;
	}



	/**
     * 
     * @return 
     */
    private static String fileNamePPBuilder(){
        
        StringBuilder builder = new StringBuilder();
        
        builder.append(EbayHelper.annee(dateDebut)).append(EbayHelper.getPeriode(dateDebut).toString()).append("I").append(bordero.getSociete().getCode()).append(extension);
        
        return builder.toString();
    }
    
    
     /**
     * 
     * @return 
     */
    private static String fileNameOFBuilder(){
        
        StringBuilder builder = new StringBuilder();
        
        builder.append(EbayHelper.annee(dateDebut)).append(EbayHelper.getPeriode(dateDebut).toString()).append("O").append(bordero.getSociete().getCode()).append(extension);
        
        return builder.toString();
    }
    
    
}
