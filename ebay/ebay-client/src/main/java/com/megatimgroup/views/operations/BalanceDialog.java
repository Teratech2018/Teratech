
package com.megatimgroup.views.operations;

import java.awt.Frame;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.megatim.common.clients.AbstractEditTemplateDialog;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.common.utilities.ResourcesBundle;
import com.megatim.common.utilities.TypeOperation;
import com.megatimgroup.ebaytools.client.EbayUtilities;
import com.megatimgroup.model.parametres.Mois;
import com.megatimgroup.model.reporting.BordereauBP;
import com.megatimgroup.views.helper.BalanceGeneratorJob;
import com.megatimgroup.views.helper.DateGeneration;
import com.megatimgroup.views.helper.DeclarationFinanciereExtractionJob;
import com.megatimgroup.views.helper.DeclarationPMExtractionJob;
import com.megatimgroup.views.helper.DeclarationPPExtractionJob;
import com.megatimgroup.views.helper.EndExtractionJob;


/**
 * Boite de dialogue d'edition ChampDialog
 * @since Sun Apr 30 13:05:42 WAT 2017
 * 
 */
public class BalanceDialog
    extends AbstractEditTemplateDialog<BordereauBP, String>
{

    private MessagesBundle bundle;
    private ResourcesBundle resourcesbundle;
    
//    private static List<ValidateError> errors = new ArrayList<ValidateError>();

    
    /**
     * Constructeur par defaut
     * 
     */
    public BalanceDialog() {
        super();
        setSize(550, 410);
        this.setResizable(false);
        this.btsave.setText("Genérer");
    }

    /**
     * Constructeur avec parametres
     * 
     * @param parent
     */
    public BalanceDialog(Frame parent) {
         super(parent);
        interne = false ;
    }

    /**
     * Constructeur  avec parametres
     * 
     * @param title
     * @param parent
     */
    public BalanceDialog(Frame parent, String title) {
         super(parent , title);
        interne = false ;
    }

    /**
     * Constructeur  avec parametres
     * 
     * @param typeOperation
     * @param parent
     * @param modal
     */
    public BalanceDialog(JFrame parent, Boolean modal, TypeOperation typeOperation) {
         super(parent , modal ,typeOperation );
        interne = false ;
        
    }

    /**
     * Methode permettant de retourner la cle primaire
     * 
     * @param object
     * @return
     *     java.lang.Long
     */
    @Override
    public String getPrimaryKey(BordereauBP object) {
        return object.getNatureSupport() ;
    }

    /**
     * Methode permettant de retourner nom de l'action
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public String getActionName() {
         return null ; 
    }

    /**
     * Methode permettant de retourner les parametres pour le reporting
     * 
     * @return
     *     java.util.Map
     */
    @Override
    public Map getReportParameters() {
         return null ; 
    }

    /**
     * Methode permettant de retourner le nom du fichier Jasper
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public String getJasperFileName() {
         return null ; 
    }

    /**
     * Methode permettant de retourner le titre de la fenetre
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public String getWindowTitle() {
        return (MessagesBundle.getMessage("balance.edit").toUpperCase());
    }

    /**
     * Methode permettant de retourner l'icone de la fenetre
     * 
     * @return
     *     javax.swing.ImageIcon
     */
    @Override
    public ImageIcon getImage() {
        try{
        ImageIcon icon = null;
        icon = new ImageIcon(getClass().getResource(ResourcesBundle.getResource("champ.edit.image")));
        return icon;
        }catch(Exception ex){;}
        return null;
    }

    /**
     * Methode permettant de retourner le panel des champs
     * 
     * @return
     *     javax.swing.JPanel
     */
    @Override
    public JPanel getFiledsPanel() {
        if ((middlePanel==null)) {
            middlePanel = new BalanceEditPanel() ;
            ((BalanceEditPanel)middlePanel).setContainer(this);
        }
        return (middlePanel);
    }

    /**
     * Methode permettant de retourner l'instance de la fenetre principale
     * 
     * @return
     *     javax.swing.JFrame
     */
    @Override
    public JFrame getApplicationFrame() {
        return com.megatimgroup.views.principal.PrincipalScreen.FRAME ;
    }

    /**
     * Methode permettant de retourner nom complet de la classe
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public String getWindowClassName() {
         return "com.megatimgroup.views.operations.ChampIFrame" ;
    }

    @Override
    protected boolean beforeSave() {
        try {
        	
        	// set date debut and date fin
        	this.setIntervalleDateGeneration();
//        	System.out.println("BalanceDialog.beforeSave() debut"+currentObject.getDateDebut());
//        	System.out.println("BalanceDialog.beforeSave() fin"+currentObject.getDateFin());
            //Reinitialisation
//            setErrors(new ArrayList<ValidateError>());
            //System.out.println(" ********************************************************** "+currentObject);
             //Construction de la chaine 
            //Creation du job de sauvegarde
            EndExtractionJob pullJob = new EndExtractionJob(null);
            //Creation du job de chargement
            BalanceGeneratorJob dataloaderJob = new BalanceGeneratorJob(pullJob);
            dataloaderJob.setFileName(currentObject.getFileName());
            dataloaderJob.setDateDebut(currentObject.getDateDebut());
            dataloaderJob.setDateFin(currentObject.getDateFin());
            //Initialisation des parametres d'entree
            //dataloaderJob.setImputData(currentObject);
            //inintialisation observer
            dataloaderJob.setListener((BalanceEditPanel)getFiledsPanel());
            pullJob.setListener((BalanceEditPanel)getFiledsPanel());
            //Traitement des données
            dataloaderJob.process();
            this.dispose();  
            return super.beforeSave();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BalanceDialog.class.getName()).log(Level.SEVERE, null, ex);
             return !super.beforeSave();
        }  
    }
    
    

    @Override
    public void save() {
        try {
            
            collecteCurrentObjectData();
            beforeSave();
            //Code de la fenetre
//          if(errors.isEmpty()){
////              afterSave();
//          }else{
//              
//              //Affichage de la fenetre des erreur
//               ValidateErrorTDialog errorDialog = new ValidateErrorTDialog(null, true, TypeOperation.VIEW, errors);
//                errorDialog.setModel(new ValidateErrorTModel());
//      //          System.out.println("Validator.validate() ::::::::::::::::: ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+resultat+" :::: "+validator.getErrors()); 
//                errorDialog.setLocationRelativeTo(this);
//                errorDialog.setVisible(true);
//          } 
            
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BalanceDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * @param errors 
     */
//    public static void setErrors(List<ValidateError> errors) {
//        BalanceDialog.errors = errors;
//    }
    
    @Override
    public ImageIcon getIconePage() {
        ImageIcon icon = EbayUtilities.getIcone();
        return icon;
    }
    
    private void setIntervalleDateGeneration(){
    	 BalanceEditPanel pan = (BalanceEditPanel) middlePanel;
    	 if(pan.getMoisGeneration().getSelectedItem()!=null){    		 
    		 Mois m = (Mois) pan.getMoisGeneration().getSelectedItem();

             Calendar cal = Calendar.getInstance();
             cal.setTime(new Date());
             currentObject.setDateDebut(DateGeneration.getDate(m.getValue(),cal.get(Calendar.YEAR)).get("DateDebut"));
             currentObject.setDateFin(DateGeneration.getDate(m.getValue(),cal.get(Calendar.YEAR)).get("DateFin"));
//             pan.getDebut().setDate(DateGeneration.getDate(m.getValue(),cal.get(Calendar.YEAR)).get("DateDebut"));
//             pan.getFin().setDate(DateGeneration.getDate(m.getValue(),cal.get(Calendar.YEAR)).get("DateFin"));
//    		 
    	 }
    }

}
