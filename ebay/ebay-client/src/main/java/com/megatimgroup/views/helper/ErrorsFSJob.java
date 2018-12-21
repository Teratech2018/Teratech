/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.megatimgroup.ebaytools.client.AbstractJobExecutor;
import com.megatimgroup.ebaytools.client.ValidateError;
import com.megatimgroup.ebaytools.ebs.ESBMessageKEY;
import com.megatimgroup.model.parametres.Societe;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Commercial_2
 */
public class ErrorsFSJob extends AbstractJobExecutor{

    
    /**
     * 
     */
    public ErrorsFSJob() {
        super();
        initialieMessageDispatcher();
    }

    /**
     * 
     * @param nextJob 
     */
    public ErrorsFSJob(AbstractJobExecutor nextJob) {
        super(nextJob);
        initialieMessageDispatcher();
    }

    
    
    /**
     * Responsable du traitement des erreurs survenues pendant la validation
     * 
     */
    @Override
    public void process() {
        try {
        	 String inbound = (String) token.get(ESBMessageKEY.INBOUND);
        	 if(inbound.trim().equalsIgnoreCase("DB")) return ;
            //Recuperation de la liste des erreurs
            List<ValidateError> errors = (List<ValidateError>) token.get(ESBMessageKEY.ERRORS_ITEMS);
            //Verification du status du traitement
            if(errors==null||errors.isEmpty())  return; //Arrêt si pas d'erreurs
            //Extration du nom du fichier
            File file = (File) token.get(ESBMessageKEY.FILE_STREAM);
            //Extraction du nom du fichier
            String fileName = file.getName();
            
            //Lecture de la socite
            Societe societe = (Societe) token.get(ESBMessageKEY.SOCIETE);
            //Construction du nom de fichier de sortie
            StringBuilder builder = new StringBuilder(societe.getErrRepository());
//            StringBuilder builder2 = new StringBuilder(societe.getErrRepository());
//            System.out.println(ErrorsFSJob.class.getSimpleName()+".process() =============================== "+errors+" ======= "+inbound+" ============= "+fileName+" ::: "+builder.toString());
           
            
            if(inbound.trim().equalsIgnoreCase("TR")){
                builder.append(File.separatorChar).append(EbayHelper.TRANSFERT_REPO)
                        .append(File.separatorChar).append(fileName);
            }else if(inbound.trim().equalsIgnoreCase("PP")){
                builder.append(File.separatorChar).append(EbayHelper.PP_REPO)
                        .append(File.separatorChar).append(fileName);
            }else if(inbound.trim().equalsIgnoreCase("PM")){
                builder.append(File.separatorChar).append(EbayHelper.PM_REPO)
                        .append(File.separatorChar).append(fileName);
            }else if(inbound.trim().equalsIgnoreCase("OF")){
                builder.append(File.separatorChar).append(EbayHelper.OF_REPO)
                        .append(File.separatorChar).append(fileName);
            }else if(inbound.trim().equalsIgnoreCase("DB")){
                return ;
            }
            
            //Creation du fichier
            File errorsfile = new File(builder.toString()+"ERROR");
            errorsfile.createNewFile();
            //Extension d'un Formater
            LineFormatter formatter = new LineFormatter();
            FileWriter writer = new FileWriter(errorsfile);
            BufferedWriter buffer = new BufferedWriter(writer);
            
            for(ValidateError error : errors){
                buffer.write(formatter.format(error.getNode().getName(),Integer.toString(error.getColumn().getRow())
                                ,Integer.toString(error.getColumn().getColumn()),error.getColumn().getValue()
                                 ,error.getErrorMessage()));
                buffer.newLine();
            }
            //Cloture des flux 
            buffer.close();
            writer.close();
            //Fichier des 
            File errorFile = new File(builder.toString());
            
            if(errorFile.exists()){
                errorFile.delete();
            }
            file.renameTo(errorFile);
        } catch (IOException ex) {
            Logger.getLogger(ErrorsFSJob.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
