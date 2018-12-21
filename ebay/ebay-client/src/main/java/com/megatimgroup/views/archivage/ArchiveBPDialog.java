
package com.megatimgroup.views.archivage;

import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.clients.AbstractEditTemplateDialog;
import com.megatim.common.clients.Messages;
import com.megatim.common.clients.Notification;
import com.megatim.common.clients.NotificationType;
import com.megatim.common.clients.Succes;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.common.utilities.PrincipalFrame;
import com.megatim.common.utilities.ResourcesBundle;
import com.megatim.common.utilities.TypeOperation;
import com.megatimgroup.ebaytools.client.EbayUtilities;
import com.megatimgroup.model.archivage.ArchiveOperation;
import com.megatimgroup.model.operations.DeclarationFinanciere;
import com.megatimgroup.model.operations.DeclarationPM;
import com.megatimgroup.model.operations.DeclarationPP;
import com.megatimgroup.model.parametres.Mois;
import com.megatimgroup.model.reporting.BordereauBP;
import com.megatimgroup.views.helper.ArchiveBalanceGeneratorJob;
import com.megatimgroup.views.helper.DateGeneration;
import com.megatimgroup.views.helper.ManagerHelper;
import com.megatimgroup.views.helper.PreviewBordereauBP;


/**
 * Boite de dialogue d'edition ChampDialog
 * @since Sun Apr 30 13:05:42 WAT 2017
 * 
 */
public class ArchiveBPDialog
    extends AbstractEditTemplateDialog<ArchiveOperation, String>
{

    private MessagesBundle bundle;
    private ResourcesBundle resourcesbundle;
    private static Date dateDebut;
    private static Date dateFin;   
    private BordereauBP bordereau = new BordereauBP();
    private List<ArchiveOperation> currentlistArchive = new ArrayList<ArchiveOperation>();
//    private static List<ValidateError> errors = new ArrayList<ValidateError>();

    
    /**
     * Constructeur par defaut
     * 
     */
    public ArchiveBPDialog() {
        super();
        setSize(450, 200);
        this.setResizable(false);
        this.btsave.setText("Editer BP.");
    }
    
    public ArchiveBPDialog(List<ArchiveOperation> v$listarchive, BordereauBP bodereau) {
        super();
        setSize(470, 200);
        this.setResizable(false);
        this.btsave.setText("Editer BP");
        this.currentlistArchive=v$listarchive;
        this.bordereau=bodereau;
        System.out.println("ArchiveBPDialog.ArchiveBPDialog() je suis ici 1222");
    }


    /**
     * Constructeur avec parametres
     * 
     * @param parent
     */
    public ArchiveBPDialog(Frame parent) {
         super(parent);
        interne = false ;
    }

    /**
     * Constructeur  avec parametres
     * 
     * @param title
     * @param parent
     */
    public ArchiveBPDialog(Frame parent, String title) {
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
    public ArchiveBPDialog(JFrame parent, Boolean modal, TypeOperation typeOperation) {
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
    public String getPrimaryKey(ArchiveOperation object) {
        return object.getIdOperation().toString() ;
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
        return (MessagesBundle.getMessage("Archive.edit").toUpperCase());
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
            middlePanel = new ArchiveBPEditPanel() ;
          //  ((ArchiveEditPanel)middlePanel).setContainer(this);
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
        	System.out.println("ArchiveBPDialog.beforeSave() debut generation archive...333");
        	ArchiveBPEditPanel pan = (ArchiveBPEditPanel) middlePanel;
        	// set date debut and date fin  filename
        	bordereau.setFileName(pan.getFileName().getText());
        	this.setIntervalleDateGeneration(bordereau.getlMoisGeneration());
        	bordereau.setDateDebut(dateDebut);
        	bordereau.setDateFin(dateFin);        	
             // generations de la balance
             bordereau=  ArchiveBalanceGeneratorJob.generateArchiveBalance(currentlistArchive, bordereau);
             // Edition genération du borderau
             PreviewBordereauBP.imprimer(bordereau);
            return super.beforeSave();
        } catch (Exception ex) {
            Logger.getLogger(ArchiveBPDialog.class.getName()).log(Level.SEVERE, null, ex);
             return !super.beforeSave();
        }  
    }
    
    

    @Override
    public void save() {
        try {
            
            collecteCurrentObjectData();
            beforeSave();
            this.dispose();
           /* ManagerHelper.getManager2(ArchiveOperation.class).save(currentObject);
            afterSave();*/
            getApplicationFrame().dispose();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ArchiveBPDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
        	Notification.getNotificationDialog(getApplicationFrame(), true, NotificationType.ERROR, "Erreur pendant  le traitement\nVeuillez consulter les détails", ex.getMessage());
            throw new RuntimeException(ex);
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
    
    private void setIntervalleDateGeneration(Mois m){
             Calendar cal = Calendar.getInstance();
             cal.setTime(new Date());
             SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
             dateDebut =DateGeneration.getDate(m.getValue(),cal.get(Calendar.YEAR)).get("DateDebut");
             dateFin=DateGeneration.getDate(m.getValue(),cal.get(Calendar.YEAR)).get("DateFin");
//             pan.getDebut().setDate(DateGeneration.getDate(m.getValue(),cal.get(Calendar.YEAR)).get("DateDebut"));
//             pan.getFin().setDate(DateGeneration.getDate(m.getValue(),cal.get(Calendar.YEAR)).get("DateFin"));
    		 
    }

	public List<ArchiveOperation> getCurrentlistArchive() {
		return currentlistArchive;
	}

	public void setCurrentlistArchive(List<ArchiveOperation> currentlistArchive) {
		this.currentlistArchive = currentlistArchive;
	}
  

}
