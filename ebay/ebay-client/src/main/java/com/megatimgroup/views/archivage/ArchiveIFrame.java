
package com.megatimgroup.views.archivage;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.sf.jasperreports.engine.base.JRBaseParameter;

import org.apache.poi.ss.formula.functions.T;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.annotationsprocessor.ValidateAndFillBeans;
import com.megatim.common.clients.AbstractListTemplateFrame;
import com.megatim.common.clients.AbstractTableBaseListModel;
import com.megatim.common.clients.PaginationStep;
import com.megatim.common.services.IocContext;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.common.utilities.ResourcesBundle;
import com.megatim.common.utilities.TypeOperation;
import com.megatimgroup.ebaytools.client.EbayUtilities;
import com.megatimgroup.ebaytools.reporting.ReportHelper;
import com.megatimgroup.ebaytools.reporting.ReportsName;
import com.megatimgroup.ebaytools.reporting.ReportsParameter;
import com.megatimgroup.model.archivage.ArchiveOperation;
import com.megatimgroup.model.parametres.Mois;
import com.megatimgroup.model.reporting.BordereauBP;


/**
 * Fenetre interne BordereauBPIFrame
 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class ArchiveIFrame
    extends AbstractListTemplateFrame<ArchiveOperation, Long>
{

    private MessagesBundle bundle;
    private ResourcesBundle resourcesbundle;
    private BordereauBP bordereau = new BordereauBP();
    public final static String FRAME_NAME = ("com.megatimgroup.views.operations.BordereauBPIFrame");

    /**
     * Constructeur par defaut
     * 
     */
    public ArchiveIFrame() {
         super();
         this.btprint.setText("Editer BP.");
         this.btupdate.setVisible(false);
         this.btdelete.setVisible(false);
         this.btview.setVisible(false);
         this.btnew.setVisible(false);
    }

    /**
     * Methode permettant de retourner la cle primaire
     * 
     * @param object
     * @return
     *     java.lang.Long
     */
    @Override
    public Long getPrimaryKey(ArchiveOperation object) {
        return object.getIdOperation() ;
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
        return (MessagesBundle.getMessage("opérations Archivées").toUpperCase());
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
            criteriaPanel = new ArchiveCriteriaPanel();
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
    public GenericManager<ArchiveOperation, Long> getManager()
        throws Exception
    {
        IocContext context = new IocContext();
        return (GenericManager)context.lookup("com.megatimgroup.core.impl.archivage.ArchiveOperationManagerImpl");
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
             model = new ArchiveModel();
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

	public BordereauBP getBordereau() {
		return bordereau;
	}

	public void setBordereau(BordereauBP bordereau) {
		this.bordereau = bordereau;
	}

	@Override
	protected JDialog getEditDialog(ArchiveOperation arg0, GenericManager arg1,
			TypeOperation arg2, JFrame arg3) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
    *
    * @throws Exception
    * @throws Exception
    */
	@Override
   public void imprimer() throws Exception {
//		 if (model == null || model.getElements() == null
//	                || model.getElements().isEmpty()) {
//	            return;
//	        }
	
		 	List<ArchiveOperation> datas = new ArrayList<ArchiveOperation>();
	
	        RestrictionsContainer container = ValidateAndFillBeans.buildSearchCriteria(getCriteriaPanel());	
	        datas = getManager().filter(container.getPredicats(), ValidateAndFillBeans.getOrdersCriteria(), null, 0, -1);
		
			ArchiveCriteriaPanel pan = (ArchiveCriteriaPanel) criteriaPanel ;
			if(pan.getCbxMois().getSelectedItem()!=null){    		 
	    		 Mois m = (Mois) pan.getCbxMois().getSelectedItem();
	    		 bordereau.setlMoisGeneration(m);
			ArchiveBPDialog dialog = new ArchiveBPDialog(datas, bordereau);
			dialog.setLocationRelativeTo(getApplicationFrame());
			dialog.setVisible(true);
			}

}
}
