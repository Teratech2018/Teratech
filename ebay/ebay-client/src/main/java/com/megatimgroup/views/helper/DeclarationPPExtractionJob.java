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
import com.megatimgroup.model.operations.DeclarationPP;
import com.megatimgroup.model.parametres.Societe;
import com.megatimgroup.model.reporting.BordereauBP;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Commercial_2
 */
public class DeclarationPPExtractionJob extends AbstractJobExecutor{

    private Periode periode ;
    
//    private String annee ;
    
    private String fileName ;
    
    private BordereauBP bordero ;
    
    private Date dateDebut ;
    
    private Date dateFin ;
    
    
    public static final String extension = ".txt";
    
    /**
     * 
     * @param nextJob 
     */
    public DeclarationPPExtractionJob(AbstractJobExecutor nextJob) {
        
        super(nextJob);        
        
        MessagesBundle.setBundle(ResourceBundle.getBundle("consolemessages"));
        //bundle = MessagesBundle.getInstace("consolemessages");
        //Initialisation du Dispatcher
        initialieMessageDispatcher(MessagesBundle.getMessage("pp.header"));   
        
        bordero = new BordereauBP();
    }

    
    /**
     * 
     */
    @Override
    public void process() {
        try {
            publish(buildMessage(MessagesBundle.getMessage("pp.start"), MessageType.INITIAL));
            //Recuoeration d'un mamager
            GenericManager manager = ManagerHelper.getManager2(DeclarationPP.class);
            //Chargement de la liste des données
            publish(buildMessage(MessagesBundle.getMessage("pp.dataloading"), MessageType.IN_PROGRESS));
            List<DeclarationPP> datas = manager.findAll();
//            System.out.println("DeclarationPPExtractionJob.process() ::::::::::::::::::::::::::::::::::::::::::::::::::::::::  "+datas);
            //Conversion des donnees
            publish(buildMessage(MessagesBundle.getMessage("pp.conversion"), MessageType.IN_PROGRESS));
            List<EbayItem> items = EbayHelper.convertFormPP(datas);
            //Validatation des données
            publish(buildMessage(MessagesBundle.getMessage("pp.validation"), MessageType.IN_PROGRESS));
            //Construction du temporalfiel
            List<NodeObject> nodes = EbayHelper.getNodeObjects(DeclarationPP.class);
//            System.out.println(DeclarationPPExtractionJob.class.getSimpleName()+" ::::::::::::::::::::::::::::: "+nodes+" ;;;;;;;;; "+items);
            Temporalfile teporalefile = EbayHelper.buildFormItem(items, nodes);
            //Validation
            Validator validator = new Validator(nodes, teporalefile, false);
            //Recuperation des resultats
            Boolean resultat = validator.validate();
            if(!resultat){
                 //Ajout des erreurs dans le message*
                  messageDispacher.setErrors(validator.getErrors());
                  //Publication du messages
                 publish(buildMessage(MessagesBundle.getMessage("pp.error"), MessageType.IN_ERROR));                 
                 //Arret du traitement
                 return ;
            }
            //Chargement des parametres
            GenericManager societeManager = ManagerHelper.getManager2(Societe.class);
            bordero.setSociete((Societe)societeManager.findAll().get(0));
//            bordero.setSociete(null);
            //Generation des fichiers
            publish(buildMessage(MessagesBundle.getMessage("pp.generation"), MessageType.IN_PROGRESS));
            transform(items);
            publish(buildMessage(MessagesBundle.getMessage("pp.end"), MessageType.DONE));
            
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DeclarationPPExtractionJob.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DeclarationPPExtractionJob.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            publish(buildMessage(MessagesBundle.getMessage("pp.error"), MessageType.IN_ERROR));
            Logger.getLogger(DeclarationPPExtractionJob.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(nextJob!=null){
            ((DeclarationPMExtractionJob)nextJob).setBordero(bordero);
            ((DeclarationPMExtractionJob)nextJob).setPeriode(periode);
            ((DeclarationPMExtractionJob)nextJob).setDateDebut(dateDebut);
            ((DeclarationPMExtractionJob)nextJob).setFileName(fileName);
            ((DeclarationPMExtractionJob)nextJob).setDateFin(dateFin);
            nextJob.setListener(listener);
            nextJob.process();
        }
    }
    
    
    /**
     * Geeration du fichier 
     * @param datas
     * @throws IOException 
     */
    private void  transform(List<EbayItem> datas) throws IOException{
       
        StringBuilder builder = new StringBuilder(fileName);
        builder.append(File.separatorChar).append(fileNameBuilder());
        
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
     * 
     * @return 
     */
    private String fileNameBuilder(){
        
        StringBuilder builder = new StringBuilder();
        
        builder.append(EbayHelper.annee(dateDebut)).append(EbayHelper.getPeriode(dateDebut).toString()).append("I").append(bordero.getSociete().getCode()).append(extension);
        
        return builder.toString();
    }
    
   

    /**
     * 
     * @param fileName 
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
        
    }

    /**
     * 
     * @param dateDebut 
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
        bordero.setDateDebut(dateDebut);        
    }

    
    /**
     * 
     * @param dateFin 
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
        bordero.setDateFin(dateFin);
    }
    
    
    
}
