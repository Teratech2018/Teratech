
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
import com.megatimgroup.model.operations.DeclarationPP;


/**
 * Boite de dialogue d'edition DeclarationPPDialog

 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class DeclarationPPDialog
    extends AbstractEditTemplateDialog<DeclarationPP, String>
{

    private MessagesBundle bundle;
    private ResourcesBundle resourcesbundle;

    /**
     * Constructeur par defaut
     * 
     */
    public DeclarationPPDialog() {
    }

    /**
     * Constructeur avec parametres
     * 
     * @param parent
     */
    public DeclarationPPDialog(Frame parent) {
         super(parent);
        interne = false ;
    }

    /**
     * Constructeur  avec parametres
     * 
     * @param title
     * @param parent
     */
    public DeclarationPPDialog(Frame parent, String title) {
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
    public DeclarationPPDialog(JFrame parent, Boolean modal, TypeOperation typeOperation) {
         super(parent , modal ,typeOperation );
         this.setSize(870, 630);
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
    public String getPrimaryKey(DeclarationPP object) {
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
        return (MessagesBundle.getMessage("declarationpp.edit").toUpperCase());
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
        icon = new ImageIcon(getClass().getResource(ResourcesBundle.getResource("declarationpp.edit.image")));
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
            middlePanel = new DeclarationPPEditPanel() ;
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
         return "com.megatimgroup.views.operations.DeclarationPPIFrame" ;
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
        if(currentObject.getNom() == null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            return false;
        } 
        if(currentObject.getNomJeuneFille() == null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            return false;
        } 
        if(currentObject.getNationalite() == null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            return false;
        } 
        if(currentObject.getProfession() == null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            return false;
        } 
        if(currentObject.getStatusResidence() == null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR,MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            return false;
        } 
        if(currentObject.getStatusResidence() == null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            return false;
        } 
            return super.beforeSave();
        }

}
