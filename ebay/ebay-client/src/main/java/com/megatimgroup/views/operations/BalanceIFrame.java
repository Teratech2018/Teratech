
package com.megatimgroup.views.operations;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.sf.jasperreports.engine.base.JRBaseParameter;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.clients.AbstractListTemplateFrame;
import com.megatim.common.clients.AbstractTableBaseListModel;
import com.megatim.common.clients.Messages;
import com.megatim.common.clients.NotificationType;
import com.megatim.common.clients.PaginationStep;
import com.megatim.common.services.IocContext;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.common.utilities.ResourcesBundle;
import com.megatim.common.utilities.TypeOperation;
import com.megatimgroup.ebaytools.client.EbayUtilities;
import com.megatimgroup.ebaytools.reporting.ReportHelper;
import com.megatimgroup.ebaytools.reporting.ReportsName;
import com.megatimgroup.ebaytools.reporting.ReportsParameter;
import com.megatimgroup.model.reporting.BordereauBP;


/**
 * Fenetre interne BordereauBPIFrame
 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class BalanceIFrame
    extends AbstractListTemplateFrame<BordereauBP, Long>
{

    private MessagesBundle bundle;
    private ResourcesBundle resourcesbundle;
    public final static String FRAME_NAME = ("com.megatimgroup.views.operations.BordereauBPIFrame");

    /**
     * Constructeur par defaut
     * 
     */
    public BalanceIFrame() {
         super();
         this.btnew.setVisible(false);
         this.btupdate.setVisible(false);
         this.btdelete.setVisible(false);
         this.btview.setVisible(false);
    }

    /**
     * Methode permettant de retourner la cle primaire
     * 
     * @param object
     * @return
     *     java.lang.Long
     */
    @Override
    public Long getPrimaryKey(BordereauBP object) {
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
         return "declarationfinanciereAction" ; 
    }

    /**
     * Methode permettant de retourner les parametres pour le reporting
     * 
     * @return
     *     java.util.Map
     */
    @Override
    public Map getReportParameters() {
    	  
        Map params = new HashMap();
        // ajout des paramètres
        params.put(ReportsParameter.DATE_DEBUT, new Date());
        params.put(ReportsParameter.DATE_FIN, new Date());
        params.put(ReportsParameter.SOCIETE_NAME, ReportHelper.societeName);
        params.put(ReportsParameter.REPORT_USER, ReportHelper.userName);
        // On positionne la locale
        params.put(JRBaseParameter.REPORT_LOCALE, Locale.FRENCH);
        // Construction du Bundle
        ResourceBundle bundle = ReportHelper.getInstace();
        // Ajout du bundle dans les parametres
        params.put(JRBaseParameter.REPORT_RESOURCE_BUNDLE, bundle);
       // params.put(ReportsParameter.REPORT_IMAGE_REPOSITORY, ReportHelper.reportFileimage);
        return params ; 
    }

    /**
     * Methode permettant de retourner le nom du fichier Jasper
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public String getJasperFileName() {
    	String report = ReportHelper.reportFileChemin + ReportsName.Bordereau_BP.getName();  
        if ((getSelectedObjects().size()==0 || getSelectedObjects().isEmpty())) {
            return null;
        } else {
            if ((getSelectedObjects().size()==1)) {
                return report;
            } else {
                return report;
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
        return (MessagesBundle.getMessage("balance.list").toUpperCase());
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
        icon = new ImageIcon(getClass().getResource(ResourcesBundle.getResource("declarationfinanciere.list.image")));
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
            criteriaPanel = new BalanceCriteriaPanel();
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
    public GenericManager<BordereauBP, Long> getManager()
        throws Exception
    {
        IocContext context = new IocContext();
        return (GenericManager)context.lookup("com.megatimgroup.core.impl.operations.BordereauBPManagerImpl");
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
             model = new BalanceModel();
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
        return "com.megatimgroup.views.operations.BordereauBPIFrame" ;
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

	@Override
	protected JDialog getEditDialog(BordereauBP arg0, GenericManager arg1,
			TypeOperation arg2, JFrame arg3) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
