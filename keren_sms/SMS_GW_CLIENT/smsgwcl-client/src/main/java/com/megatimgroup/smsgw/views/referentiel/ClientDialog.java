
package com.megatimgroup.smsgw.views.referentiel;

import java.awt.Frame;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.megatim.common.clients.AbstractEditTemplateDialog;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.common.utilities.ResourcesBundle;
import com.megatim.common.utilities.TypeOperation;
import com.megatimgroup.smsgw.model.referentiel.Client;


/**
 * Boite de dialogue d'edition ClientDialog
 * @since Thu Sep 07 15:22:22 WAT 2017
 * 
 */
public class ClientDialog
    extends AbstractEditTemplateDialog<Client, Long>
{

    private MessagesBundle bundle;
    private ResourcesBundle resourcesbundle;

    /**
     * Constructeur par defaut
     * 
     */
    public ClientDialog() {
    }

    /**
     * Constructeur avec parametres
     * 
     * @param parent
     */
    public ClientDialog(Frame parent) {
         super(parent);
        interne = false ;
    }

    /**
     * Constructeur  avec parametres
     * 
     * @param title
     * @param parent
     */
    public ClientDialog(Frame parent, String title) {
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
    public ClientDialog(JFrame parent, Boolean modal, TypeOperation typeOperation) {
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
    public Long getPrimaryKey(Client object) {
        return object.getId() ;
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
        return (MessagesBundle.getMessage("client.edit"));
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
        icon = new ImageIcon(getClass().getResource(ResourcesBundle.getResource("client.edit.image")));
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
            middlePanel = new ClientEditPanel() ;
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
        return com.megatimgroup.smsgw.views.principal.PrincipalScreen.FRAME ;
    }

    /**
     * Methode permettant de retourner nom complet de la classe
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public String getWindowClassName() {
         return "com.megatimgroup.smsgw.views.referentiel.ClientIFrame" ;
    }

}
