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
import com.megatimgroup.model.operations.DeclarationPM;
import com.megatimgroup.model.operations.DeclarationPP;
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
public class DeclarationPMExtractionJob extends AbstractJobExecutor{

    
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
    public DeclarationPMExtractionJob(AbstractJobExecutor nextJob) {
        super(nextJob);
        
        MessagesBundle.setBundle(ResourceBundle.getBundle("consolemessages"));
        //bundle = MessagesBundle.getInstace("consolemessages");
        //Initialisation du Dispatcher
        initialieMessageDispatcher(MessagesBundle.getMessage("pm.header"));   
        
    }

    
    
    @Override
    public void process() {
        
         try {
            publish(buildMessage(MessagesBundle.getMessage("pm.start"), MessageType.INITIAL));
            //Chargement des parametres
//            GenericManager societeManager = ManagerHelper.getManager2(Societe.class);
//            bordero.setSociete((Societe)societeManager.findAll().get(0));
//            //Recuoeration d'un mamager
            GenericManager manager = ManagerHelper.getManager2(DeclarationPM.class);
            //Chargement de la liste des données
            publish(buildMessage(MessagesBundle.getMessage("pm.dataloading"), MessageType.IN_PROGRESS));
            List<DeclarationPM> datas = manager.findAll();
            //Conversion des donnees
            publish(buildMessage(MessagesBundle.getMessage("pm.conversion"), MessageType.IN_PROGRESS));
            List<EbayItem> items = EbayHelper.convertFromPM(datas);
            //Validatation des données
            publish(buildMessage(MessagesBundle.getMessage("pm.validation"), MessageType.IN_PROGRESS));
            //Construction du temporalfiel
            List<NodeObject> nodes = EbayHelper.getNodeObjects(DeclarationPM.class);
            Temporalfile teporalefile = EbayHelper.buildFormItem(items, nodes);
            //Validation
            Validator validator = new Validator(nodes, teporalefile, false);
            //Recuperation des resultats
            Boolean resultat = validator.validate();
            if(!resultat){
                 //Ajout des erreurs dans le message*
                  messageDispacher.setErrors(validator.getErrors());
                  //Publication du messages
                 publish(buildMessage(MessagesBundle.getMessage("pm.error"), MessageType.IN_ERROR));                 
                 //Arret du traitement
                 return ;
            }
            publish(buildMessage(MessagesBundle.getMessage("pm.generation"), MessageType.IN_PROGRESS));
            transform(items);
            publish(buildMessage(MessagesBundle.getMessage("pm.end"), MessageType.DONE));
            
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DeclarationPMExtractionJob.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DeclarationPMExtractionJob.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            publish(buildMessage(MessagesBundle.getMessage("pm.error"), MessageType.IN_ERROR));
            Logger.getLogger(DeclarationPPExtractionJob.class.getName()).log(Level.SEVERE, null, ex);
        }
         if(nextJob!=null){
            ((DeclarationFinanciereExtractionJob)nextJob).setBordero(bordero);
            ((DeclarationFinanciereExtractionJob)nextJob).setDateDebut(dateDebut);
            ((DeclarationFinanciereExtractionJob)nextJob).setDateFin(dateFin);
            ((DeclarationFinanciereExtractionJob)nextJob).setPeriode(periode);
            ((DeclarationFinanciereExtractionJob)nextJob).setFileName(fileName);
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
    private String fileNameBuilder(){
        
        StringBuilder builder = new StringBuilder();
        
        builder.append(EbayHelper.annee(dateDebut)).append(EbayHelper.getPeriode(dateDebut).toString()).append("E").append(bordero.getSociete().getCode()).append(extension);
        
        return builder.toString();
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

//    public BordereauBP getBordero() {
//        return bordero;
//    }

    public void setBordero(BordereauBP bordero) {
        this.bordero = bordero;
    }

//    public Date getDateDebut() {
//        return dateDebut;
//    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

//    public Date getDateFin() {
//        return dateFin;
//    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    
    
    
}
