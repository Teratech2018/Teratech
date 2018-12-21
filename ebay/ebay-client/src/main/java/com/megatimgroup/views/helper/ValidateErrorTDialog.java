package com.megatimgroup.views.helper;

import com.megatim.common.clients.AbstractTransfertTemplateDialog;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.common.utilities.ResourcesBundle;
import com.megatim.common.utilities.TypeOperation;
import com.megatimgroup.ebaytools.client.ValidateError;
import com.megatimgroup.views.principal.PrincipalScreen;
import java.awt.Frame;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Boite de dialogue d'edition EngagementTDialog
 *
 * @since Tue Sep 20 11:41:16 WAT 2016
 *
 */
public class ValidateErrorTDialog
        extends AbstractTransfertTemplateDialog<ValidateError, String> {

    private MessagesBundle bundle;
    private ResourcesBundle resourcesbundle;
//    private BorderoSequenceGeneratorDAO generator = null;

    /**
     * Constructeur par defaut
     *
     */
    public ValidateErrorTDialog(List<ValidateError> datas) {
        super(datas);
    }

    /**
     * Constructeur avec parametres
     *
     * @param parent
     */
    public ValidateErrorTDialog(Frame parent, List<ValidateError> datas) {
        super(parent, datas);
        interne = false;
    }

    /**
     * Constructeur avec parametres
     *
     * @param title
     * @param parent
     */
    public ValidateErrorTDialog(Frame parent, String title, List<ValidateError> datas) {
        super(parent, title, datas);
        interne = false;
    }

    /**
     * Constructeur avec parametres
     *
     * @param typeOperation
     * @param parent
     * @param modal
     */
    public ValidateErrorTDialog(JFrame parent, Boolean modal, TypeOperation typeOperation, List<ValidateError> datas) {
        super(parent, modal, typeOperation, datas);
        interne = false;
    }

    /**
     * Methode permettant de retourner la cle primaire
     *
     * @param object
     * @return java.lang.String
     */
    @Override
    public String getPrimaryKey(ValidateError object) {
        return object.getErrorMessage();
    }

    /**
     * Methode permettant de retourner nom de l'action
     *
     * @return java.lang.String
     */
    @Override
    public String getActionName() {
        return null;
    }

    /**
     * Methode permettant de retourner les parametres pour le reporting
     *
     * @return java.util.Map
     */
    @Override
    public Map getReportParameters() {
        Map params = new HashMap();
        

        return params;
    }

    /**
     * Methode permettant de retourner le nom du fichier Jasper
     *
     * @return java.lang.String
     */
    @Override
    public String getJasperFileName() {
        String report = null ;//ReportHelper.reportFileChemin + ReportsName.BDR_TRANSFERT.getName();

        return report;
    }

    /**
     * Methode permettant de retourner le titre de la fenetre
     *
     * @return java.lang.String
     */
    @Override
    public String getWindowTitle() {
        return "Details de la validation";
    }

    /**
     * Methode permettant de retourner l'icone de la fenetre
     *
     * @return javax.swing.ImageIcon
     */
    @Override
    public ImageIcon getImage() {
        try {
            ImageIcon icon = null;
            icon = new ImageIcon(getClass().getResource(ResourcesBundle.getResource("engagement.edit.image")));
            return icon;
        } catch (Exception ex) {;
        }
        return null;
    }

    /**
     * Methode permettant de retourner l'instance de la fenetre principale
     *
     * @return javax.swing.JFrame
     */
    @Override
    public JFrame getApplicationFrame() {
        return PrincipalScreen.FRAME;
    }

    @Override
    public String getWindowClassName() {
        return "com.gepa.views.depenses.EngagementIFrame";
    }

    /**
     * Methode permettant de retourner nom complet de la classe
     *
     * @return java.lang.String
     */
    @Override
    public boolean isSelected(ValidateError objet) {
        return false;
    }

   
    @Override
    public void save() {
        ; //To change body of generated methods, choose Tools | Templates.
    }

    

}
