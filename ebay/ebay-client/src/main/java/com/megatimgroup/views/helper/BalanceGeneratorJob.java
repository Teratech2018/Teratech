/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.megatim.common.jaxb.entities.Temporalfile;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.ebaytools.client.AbstractJobExecutor;
import com.megatimgroup.ebaytools.client.EbayItem;
import com.megatimgroup.ebaytools.client.MessageType;
import com.megatimgroup.ebaytools.client.NodeObject;
import com.megatimgroup.ebaytools.client.ValidateError;
import com.megatimgroup.model.operations.DeclarationFinanciere;
import com.megatimgroup.model.operations.DeclarationPM;
import com.megatimgroup.model.operations.DeclarationPP;
import com.megatimgroup.model.parametres.Societe;
import com.megatimgroup.model.reporting.BordereauBP;
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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Processus de chargement des operation financieres d'une periode
 * @author Commercial_2
 */
public class BalanceGeneratorJob extends AbstractJobExecutor{

    private Date dateDebut ;
    
    private Date dateFin ;
    
    
     private Periode periode ;
    
//    private String annee ;
    
    private String fileName ;
    
    private BordereauBP bordero ;    
    
    private List<ValidateError> errors = new ArrayList<ValidateError>();
    
    public static final String extension = ".txt";
    /**
     * 
     */
    public BalanceGeneratorJob() {
    }

    
    /**
     * 
     * @param nextJob 
     */
    public BalanceGeneratorJob(AbstractJobExecutor nextJob) {
        super(nextJob);
         MessagesBundle.setBundle(ResourceBundle.getBundle("consolemessages"));
        //bundle = MessagesBundle.getInstace("consolemessages");
        //Initialisation du Dispatcher
        initialieMessageDispatcher(MessagesBundle.getMessage("gen.header"));   
        
         bordero = new BordereauBP();
    }

    
    
    @Override
    public void process() {
        try {
            bordero.setDateDebut(dateDebut);
            
            bordero.setDateFin(dateFin);
            
            bordero.setFileName(fileName);
            
             //Chargement des parametres
            GenericManager societeManager = ManagerHelper.getManager2(Societe.class);
            bordero.setSociete((Societe)societeManager.findAll().get(0));
            
            publish(buildMessage(MessagesBundle.getMessage("gen.start"), MessageType.INITIAL));
             //Chargement des parametres
 //            GenericManager societeManager = ManagerHelper.getManager2(Societe.class);
 //            bordero.setSociete((Societe)societeManager.findAll().get(0));
 //            //Recuoeration d'un mamager
             GenericManager manager = ManagerHelper.getManager2(DeclarationFinanciere.class);
             //Chargement de la liste des données             
             //Container
             RestrictionsContainer container = RestrictionsContainer.newInstance(); 
             container.addGe("dateOperation", dateDebut);
             container.addLe("dateOperation", dateFin);
             List<DeclarationFinanciere> operations = manager.filter(container.getPredicats(), new HashMap()
                     , new HashSet<String>(), 0, -1);
             //Verification de l'existance des données
             if(operations==null||operations.isEmpty()){
                 publish(buildMessage(MessagesBundle.getMessage("gen.loader.err"), MessageType.IN_ERROR));
             
                 return ;
             }
             
             publish(buildMessage(MessagesBundle.getMessage("gen.loader"), MessageType.IN_PROGRESS));             
             //Extraction des referentiels des personnes physiques et morales
             List<DeclarationPP> physiques = new ArrayList<DeclarationPP>();
             List<DeclarationPM> morales = new ArrayList<DeclarationPM>();
             //Extraction du referentiel des personnes physiques et morales de la periode
             for(DeclarationFinanciere df : operations){
                 //Recherche dans le referentiel des personnes physique
                 if(df.getPysique()!=null&&!physiques.contains(df.getPysique())){
                     physiques.add(df.getPysique());
                 }else if(df.getMorale()!=null&&!morales.contains(df.getMorale())) {
                     //C'est une personnes morales
                     morales.add(df.getMorale());
                 }
             }
             //Conversion des données in Items
              List<EbayItem> ofitems = EbayHelper.convertFromFI(operations);
              bordero.setNombreOF(ofitems.size());
              List<EbayItem> pmitems = EbayHelper.convertFromPM(morales);
              bordero.setNombrePM(pmitems.size());
              List<EbayItem> ppitems = EbayHelper.convertFormPP(physiques);
              bordero.setNombrePP(ppitems.size());
              //Message de fin de conversion
              publish(buildMessage(MessagesBundle.getMessage("gen.convert"), MessageType.IN_PROGRESS));
              //Validation des données
              List<NodeObject> nodes = EbayHelper.getNodeObjects(DeclarationPP.class);
              Temporalfile teporalefile = EbayHelper.buildFormItem(ppitems, nodes);
              //Validation
                Validator validator = new Validator(nodes, teporalefile, true);
                //Recuperation des resultats
                Boolean resultat = validator.validate();
                //Verification des resultats
                if(!resultat){
                    errors.addAll(validator.getErrors());
                }
                //Personnes Morales
                nodes = EbayHelper.getNodeObjects(DeclarationPM.class);
                teporalefile = EbayHelper.buildFormItem(pmitems , nodes);
                validator = new Validator(nodes, teporalefile, true);
                //Recuperation des resultats
                resultat = validator.validate();
                //Verification des resultats
                if(!resultat){
                    errors.addAll(validator.getErrors());
                }
                nodes = EbayHelper.getNodeObjects(DeclarationFinanciere.class);
                teporalefile = EbayHelper.buildFormItem(ofitems, nodes);
                //Validation
               validator = new Validator(nodes, teporalefile, true);
                //Recuperation des resultats
                resultat = validator.validate();
                if(!resultat){
                    errors.addAll(validator.getErrors());
                }
                //Arrêt si Erreur
                if(!errors.isEmpty()){
                    messageDispacher.setErrors(errors);
                    publish(buildMessage(MessagesBundle.getMessage("gen.validation.err"), MessageType.IN_ERROR));
                    return ;
                }
                publish(buildMessage(MessagesBundle.getMessage("gen.validation"), MessageType.IN_PROGRESS));
                //Generation des fichiers
                transformPP(ppitems);
                transformPM(pmitems);
                transformOF(ofitems);
                publish(buildMessage(MessagesBundle.getMessage("gen.generation"), MessageType.IN_PROGRESS));
                publish(buildMessage(MessagesBundle.getMessage("gen.end"), MessageType.DONE));
        } catch (IOException ex) {
            publish(buildMessage(MessagesBundle.getMessage("gen.generation.err"), MessageType.IN_ERROR));
            Logger.getLogger(BalanceGeneratorJob.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            publish(buildMessage(MessagesBundle.getMessage("gen.validation.err"), MessageType.IN_ERROR));
            Logger.getLogger(BalanceGeneratorJob.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            publish(buildMessage(MessagesBundle.getMessage("gen.validation.err"), MessageType.IN_ERROR));
            Logger.getLogger(BalanceGeneratorJob.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(nextJob!=null){
            ((EndExtractionJob)nextJob).setV$newBordereau(bordero);
            ((EndExtractionJob)nextJob).setDateDebut(dateDebut);
            ((EndExtractionJob)nextJob).setDateFin(dateFin);
            ((EndExtractionJob)nextJob).setPeriode(periode);
            ((EndExtractionJob)nextJob).setFileName(fileName);
            nextJob.setListener(listener);
            nextJob.process();
         }
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
    private void  transformOF(List<EbayItem> datas) throws IOException{
       
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
    private void  transformPP(List<EbayItem> datas) throws IOException{
       
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
    private void  transformPM(List<EbayItem> datas) throws IOException{
       
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
    private String fileNamePMBuilder(){
        
        StringBuilder builder = new StringBuilder();
        
        builder.append(EbayHelper.annee(dateDebut)).append(EbayHelper.getPeriode(dateDebut).toString()).append("E").append(bordero.getSociete().getCode()).append(extension);
        
        return builder.toString();
    }
    

    /**
     * 
     * @return 
     */
    private String fileNamePPBuilder(){
        
        StringBuilder builder = new StringBuilder();
        
        builder.append(EbayHelper.annee(dateDebut)).append(EbayHelper.getPeriode(dateDebut).toString()).append("I").append(bordero.getSociete().getCode()).append(extension);
        
        return builder.toString();
    }
    
    
     /**
     * 
     * @return 
     */
    private String fileNameOFBuilder(){
        
        StringBuilder builder = new StringBuilder();
        
        builder.append(EbayHelper.annee(dateDebut)).append(EbayHelper.getPeriode(dateDebut).toString()).append("O").append(bordero.getSociete().getCode()).append(extension);
        
        return builder.toString();
    }
    
    
}
