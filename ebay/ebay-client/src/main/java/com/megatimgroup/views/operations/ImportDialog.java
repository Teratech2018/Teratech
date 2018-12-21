
package com.megatimgroup.views.operations;

import com.megatim.common.clients.AbstractEditTemplateDialog;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.common.utilities.ResourcesBundle;
import com.megatim.common.utilities.TypeOperation;
import com.megatimgroup.ebaytools.client.EbayUtilities;
import com.megatimgroup.ebaytools.client.ValidateError;
import com.megatimgroup.views.helper.ConversionJob;
import com.megatimgroup.views.helper.ImportData;
import com.megatimgroup.views.helper.LoadingJob;
import com.megatimgroup.views.helper.PullJob;
import com.megatimgroup.views.helper.ValidateErrorTDialog;
import com.megatimgroup.views.helper.ValidateErrorTModel;
import com.megatimgroup.views.helper.ValidateJob;
import java.awt.Frame;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Boite de dialogue d'edition ChampDialog
 * @since Sun Apr 30 13:05:42 WAT 2017
 * 
 */
public class ImportDialog
    extends AbstractEditTemplateDialog<ImportData, String>
{

    private MessagesBundle bundle;
    private ResourcesBundle resourcesbundle;
    
//    private static ImportDialog _instance ;
//    
//    private static List<ValidateError> errors = new ArrayList<ValidateError>();

    
    /**
     * Constructeur par defaut
     * 
     */
    public ImportDialog() {
        super();
        setSize(550, 410);
        this.setResizable(false);
        
    }

    /**
     * Constructeur avec parametres
     * 
     * @param parent
     */
    public ImportDialog(Frame parent) {
         super(parent);
        interne = false ;
    }

    /**
     * Constructeur  avec parametres
     * 
     * @param title
     * @param parent
     */
    public ImportDialog(Frame parent, String title) {
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
    public ImportDialog(JFrame parent, Boolean modal, TypeOperation typeOperation) {
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
    public String getPrimaryKey(ImportData object) {
        return object.getFileName() ;
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
        return (MessagesBundle.getMessage("import.edit").toUpperCase());
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
            middlePanel = new ImportEditPanel() ;
            ((ImportEditPanel)middlePanel).setContainer(this);
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
            //Reinitialisation
//            setErrors(new ArrayList<ValidateError>());
//            System.out.println("ImportDialog.()  ********************************************************** "+currentObject.getModele().getElements());
            currentObject.setFile(new File(currentObject.getFileName()));
//            Temporalfile temporal = ParserHelper.cvsToJAXBParser(currentObject.getFile(), currentObject.getModele().getFields(), EbayItem.class);
            //Construction de la chaine 
            //Creation du job de sauvegarde
            PullJob pullJob = new PullJob(null);
            //Creation du job de conversion
            ConversionJob convertJob = new ConversionJob(pullJob);
            //Creation du job de validation
            ValidateJob validatorJob = new ValidateJob(convertJob);
            //Creation du job de chargement
            LoadingJob dataloaderJob = new LoadingJob(validatorJob);
            //Initialisation des parametres d'entree
            dataloaderJob.setImputData(currentObject);
            //inintialisation observer
            dataloaderJob.setContainer((ImportEditPanel)getFiledsPanel());
            validatorJob.setContainer((ImportEditPanel)getFiledsPanel());
            convertJob.setContainer((ImportEditPanel)getFiledsPanel());
            pullJob.setContainer((ImportEditPanel)getFiledsPanel());
            //Traitement des données
            dataloaderJob.process();
            
            return super.beforeSave();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ImportDialog.class.getName()).log(Level.SEVERE, null, ex);
             return !super.beforeSave();
        }
    }
    
    

    @Override
    public void save() {
        try {
            
            collecteCurrentObjectData();
            beforeSave();
//             System.out.println("Validator.validate() ::::::::::::::::: ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+errors+" :::: "); 
            //Code de la fenetre
//          if(errors.isEmpty()){
////              afterSave();
//          }else{
//              
//              
//          } 
            
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ImportDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * @param errors 
     */
//    public static void setErrors(List<ValidateError> errors) {
//        ImportDialog.errors = errors;
//    }
    
    @Override
    public ImageIcon getIconePage() {
        ImageIcon icon = EbayUtilities.getIcone();
        return icon;
    }

    
    
    
}
