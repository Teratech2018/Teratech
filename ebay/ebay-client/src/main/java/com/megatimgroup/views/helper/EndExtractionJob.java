/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import java.util.ResourceBundle;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.ebaytools.client.AbstractJobExecutor;
import com.megatimgroup.ebaytools.client.MessageType;
import com.megatimgroup.model.parametres.Societe;
import com.megatimgroup.model.reporting.BordereauBP;
import java.util.Date;

/**
 *
 * @author Commercial_2
 */
public class EndExtractionJob extends AbstractJobExecutor{
	
	BordereauBP v$newBordereau ;
        
         
        private Periode periode ;

   //    private String annee ;

       private String fileName ;

       private Date dateDebut ;

       private Date dateFin ;

    /**
     * 
     * @param nextJob 
     */
    public EndExtractionJob(AbstractJobExecutor nextJob) {
        super(nextJob);
        MessagesBundle.setBundle(ResourceBundle.getBundle("consolemessages"));

        initialieMessageDispatcher(MessagesBundle.getMessage("endExtractionJob.header")); 
    }

    
    
    @Override
    public void process() {
        try{ 
            //Message de demarrage
            publish(buildMessage(MessagesBundle.getMessage("endExtractionJob.start"), MessageType.INITIAL));
//             GenericManager societeManager = ManagerHelper.getManager2(Societe.class);
//             v$newBordereau.setSociete((Societe)societeManager.findAll().get(0));
             //Verification de la validite des données
            if(v$newBordereau==null){
//                System.out.println("EndExtractionJob.process() :::::::::::::::::::::::::::::::::::::      "+v$newBordereau.getSociete());
                //Message de demarrage
                publish(buildMessage(MessagesBundle.getMessage("endExtractionJob.error"), MessageType.IN_ERROR));
                return ;
            }
                        
            // Edition genération du borderau
            PreviewBordereauBP.imprimer(v$newBordereau);
            //Initialisation du manager
            GenericManager manager = ManagerHelper.getManager2(v$newBordereau.getClass());
            //Sauvegarde du borderau
             manager.save(v$newBordereau);               
             //Message de demarrage
             publish(buildMessage(MessagesBundle.getMessage("endExtractionJob.end"), MessageType.DONE));
            
           }catch(Exception ex){
               //Message de demarrage
               publish(buildMessage(MessagesBundle.getMessage("endExtractionJob.error"), MessageType.IN_ERROR));
               ex.printStackTrace();
           }
            //Fin du traitement
    }

    public void setV$newBordereau(BordereauBP v$newBordereau) {
        this.v$newBordereau = v$newBordereau;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    
  
   
    
}
