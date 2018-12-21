
package com.megatimgroup.views.operations;

import java.awt.Frame;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.megatim.common.clients.AbstractEditTemplateDialog;
import com.megatim.common.clients.Messages;
import com.megatim.common.clients.NotificationType;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.common.utilities.PrincipalFrame;
import com.megatim.common.utilities.ResourcesBundle;
import com.megatim.common.utilities.TypeOperation;
import com.megatimgroup.ebaytools.client.EbayUtilities;
import com.megatimgroup.model.operations.DeclarationPM;


/**
 * Boite de dialogue d'edition DeclarationPMDialog

 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class DeclarationPMDialog
    extends AbstractEditTemplateDialog<DeclarationPM, String>
{

    private MessagesBundle bundle;
    private ResourcesBundle resourcesbundle;

    /**
     * Constructeur par defaut
     * 
     */
    public DeclarationPMDialog() {
    }

    /**
     * Constructeur avec parametres
     * 
     * @param parent
     */
    public DeclarationPMDialog(Frame parent) {
         super(parent);
        interne = false ;
    }

    /**
     * Constructeur  avec parametres
     * 
     * @param title
     * @param parent
     */
    public DeclarationPMDialog(Frame parent, String title) {
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
    public DeclarationPMDialog(JFrame parent, Boolean modal, TypeOperation typeOperation) {
         super(parent , modal ,typeOperation );
         this.setSize(870, 730);
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
    public String getPrimaryKey(DeclarationPM object) {
        return object.getReference() ;
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
        return (MessagesBundle.getMessage("declarationpm.edit").toUpperCase());
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
        icon = new ImageIcon(getClass().getResource(ResourcesBundle.getResource("declarationpm.edit.image")));
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
            middlePanel = new DeclarationPMEditPanel() ;
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
         return "com.megatimgroup.views.operations.DeclarationPMIFrame" ;
    }

    @Override
    public ImageIcon getIconePage() {
        ImageIcon icon = EbayUtilities.getIcone();
        return icon;
    }
    @Override
    public boolean beforeSave() {
    	String eror = "ebay.valeur.obligatoire.null";
        if (currentObject.getReference()== null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            return false;
        }
        if(currentObject.getRaisonSocial() == null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            return false;
        } 
        if(currentObject.getSigle() == null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            return false;
        } 
        if(currentObject.getSiegeSocial() == null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            return false;
        } 
        if(currentObject.getNatureJuridique() == null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            return false;
        } 
        if(currentObject.getObjetSocial() == null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR,MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            return false;
        } 
        if(currentObject.getStatusResidence() == null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            return false;
        } 
        if(currentObject.getVille() == null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            return false;
        } 
        if(currentObject.getSection() == null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            return false;
        } 
        if(currentObject.getDivision() == null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            return false;
        } 
        if(currentObject.getClasse() == null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            return false;
        } 
        if(currentObject.getGroupe() == null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            return false;
        } 
            return super.beforeSave();
        }
}
