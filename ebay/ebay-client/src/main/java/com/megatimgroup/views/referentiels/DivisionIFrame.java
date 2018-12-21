
package com.megatimgroup.views.referentiels;

import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.clients.AbstractListTemplateFrame;
import com.megatim.common.clients.AbstractTableBaseListModel;
import com.megatim.common.clients.PaginationStep;
import com.megatim.common.services.IocContext;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.common.utilities.ResourcesBundle;
import com.megatim.common.utilities.TypeOperation;
import com.megatimgroup.ebaytools.client.EbayUtilities;
import com.megatimgroup.model.referentiels.Division;


/**
 * Fenetre interne DivisionIFrame
 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class DivisionIFrame
    extends AbstractListTemplateFrame<Division, String>
{

    private MessagesBundle bundle;
    private ResourcesBundle resourcesbundle;
    public final static String FRAME_NAME = ("com.megatimgroup.views.referentiels.DivisionIFrame");

    /**
     * Constructeur par defaut
     * 
     */
    public DivisionIFrame() {
         super();
    }

    /**
     * Methode permettant de retourner la cle primaire
     * 
     * @param object
     * @return
     *     java.lang.String
     */
    @Override
    public String getPrimaryKey(Division object) {
        return object.getCode() ;
    }

    /**
     * Methode permettant de retourner nom de l'action
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public String getActionName() {
         return "divisionAction" ; 
    }

    /**
     * Methode permettant de retourner les parametres pour le reporting
     * 
     * @return
     *     java.util.Map
     */
    @Override
    public Map getReportParameters() {
        Map parametres = new HashMap();
        parametres.put("titreRapport", MessagesBundle.getMessage("division.title.report")) ;
        parametres.put("piedRapport", MessagesBundle.getMessage("division.footer.report")) ;
        parametres.put("nombreLignesRapport", getSelectedObjects().size()) ;
        return parametres ; 
    }

    /**
     * Methode permettant de retourner le nom du fichier Jasper
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public String getJasperFileName() {
        if ((getSelectedObjects().size()==0 || getSelectedObjects().isEmpty())) {
            return null;
        } else {
            if ((getSelectedObjects().size()==1)) {
                return (ResourcesBundle.getResource("division.detail.report"));
            } else {
                return (ResourcesBundle.getResource("division.list.report"));
            }
        }
    }

    /**
     * Methode permettant de retourner le titre de la fenetre
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public String getWindowTitle() {
        return (MessagesBundle.getMessage("division.list").toUpperCase());
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
        icon = new ImageIcon(getClass().getResource(ResourcesBundle.getResource("division.list.image")));
        return icon;
        } catch(Exception ex ){;}
        return null;
    }

    /**
     * Methode permettant de retourner le panel des champs
     * 
     * @return
     *     javax.swing.JPanel
     */
    @Override
    public JPanel getCriteriaPanel() {
        if ((criteriaPanel==null)) {
            criteriaPanel = new DivisionCriteriaPanel();
        }
        return (criteriaPanel);
    }

    /**
     * Methode permettant de retourner le manager
     * 
     * @return
     *     com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager
     */
    @Override
    public GenericManager<Division, String> getManager()
        throws Exception
    {
        IocContext context = new IocContext();
        return (GenericManager)context.lookup("com.megatimgroup.core.impl.referentiels.DivisionManagerImpl");
    }

    /**
     * Methode permettant de retourner le modele de tableau
     * 
     * @return
     *     com.megatim.common.clients.AbstractTableBaseListModel
     */
    @Override
    public AbstractTableBaseListModel getTableModel() {
        if ((model==null)) {
             model = new DivisionModel();
        }
        return (model);
    }

    /**
     * Methode permettant de retourner le nom complet de la classe
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public String getWindowClassName() {
        return "com.megatimgroup.views.referentiels.DivisionIFrame" ;
    }

    /**
     * Methode permettant de retourner nom complet de la classe
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public JDialog getEditDialog(Division object, GenericManager manager, TypeOperation typeOperation, JFrame window)
        throws Exception
    {
        if ((object==null)) {
             object = new Division();
        }
        DivisionDialog  dialog = new DivisionDialog(getApplicationFrame() ,true, typeOperation) ;
         dialog.setCurrentObject(object);
         dialog.setManager(manager);
        return (dialog);
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
     * Methode permettant de retourner une instance de la pagination
     * 
     * @return
     *     com.megatim.common.clients.PaginationStep
     */
    @Override
    public PaginationStep getPagination() {
        pagination =  new PaginationStep(20);
        return pagination ; 
    }
    
    @Override
    public ImageIcon getIconePage() {
        ImageIcon icon = EbayUtilities.getIcone();
        return icon;
    }

}
