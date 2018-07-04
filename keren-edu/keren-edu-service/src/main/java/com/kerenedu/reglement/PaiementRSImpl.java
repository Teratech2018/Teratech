
package com.kerenedu.reglement;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.jaxrs.impl.report.ViewBulletinRSImpl;
import com.kerenedu.tools.KerenEduManagerException;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.kerenedu.tools.reports.ReportsParameter;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.base.JRBaseParameter;

/**
 * Classe d'implementation du Web Service JAX-RS
 * 
 * @since Tue Mar 06 16:43:59 CET 2018
 * 
 */
@Path("/paiement")
public class PaiementRSImpl extends AbstractGenericService<Paiement, Long> implements PaiementRS {

	/**
	 * On injecte un Gestionnaire d'entites
	 * 
	 */
	@Manager(application = "kereneducation", name = "PaiementManagerImpl", interf = PaiementManagerRemote.class)
	protected PaiementManagerRemote manager;

	public PaiementRSImpl() {
		super();
	}

	/**
	 * Methode permettant de retourner le gestionnaire d'entites
	 * 
	 */
	@Override
	public GenericManager<Paiement, Long> getManager() {
		return manager;
	}

	public String getModuleName() {
		return ("kereneducation");
	}

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			MetaData meta = MetaDataUtil.getMetaData(new Paiement(), new HashMap<String, MetaData>(),new ArrayList<String>());
			MetaColumn workbtn = new MetaColumn("button", "work1", "Annuler", false, "object", null);
			workbtn.setValue("{'model':'kereneducation','entity':'paiement','method':'annuler','template':{'this':'object'}}");
			workbtn.setStates(new String[] { "etabli" });
			workbtn.setPattern("btn btn-danger");	
			//meta.getHeader().add(workbtn);
			
			workbtn = new MetaColumn("button", "work2", "Editer la facture ", false, "report", null);
			workbtn.setValue("{'model':'kereneducation','entity':'paiement','method':'facture','template':{'this':'object'}}");
			workbtn.setStates(new String[] { "etabli" });
			// workbtn.setPattern("btn btn-primary");		
		//	meta.getHeader().add(workbtn);
			MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
			//meta.getHeader().add(stautsbar);
			return meta;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Paiement annuler(HttpHeaders headers, Paiement entity) {

		try {
			return new Paiement();
		} catch (KerenEduManagerException ex) {
			throw new KerenExecption(ex.getMessage());
		}
	}
	

	@Override
	public Response facture(HttpHeaders headers, Paiement entity) {
		// TODO Auto-generated method stub
		if (entity.getService()==null) {
			throw new KerenExecption("Ce bulletin est nulle <br/> ");
		} // end if(entity.getState().trim().equalsIgnoreCase("valide")){
		try {
			return this.buildPdfReport(entity);
		} catch (KerenEduManagerException ex) {
			throw new KerenExecption(ex.getMessage());
		}
	}
	
	/**
     * Methode permettant de retourner les parametres pour le reporting
     *
     * @return java.util.Map
     */
    public Map getReportParameters() {
        Map params = new HashMap();
        // On positionne la locale
        params.put(JRBaseParameter.REPORT_LOCALE, Locale.FRENCH);
        // Construction du Bundle
        ResourceBundle bundle = ReportHelper.getInstace();
        // Ajout du bundle dans les parametres
        params.put(JRBaseParameter.REPORT_RESOURCE_BUNDLE, bundle);
        params.put(ReportsParameter.REPORT_USER, "Administrateur");
        params.put(ReportsParameter.ETB, "UCA");

        return params;
    }


    @Override
	protected void processAfterSave(Paiement entity) {
		//imprimer la facture
    	this.buildPdfReport(entity);
		super.processAfterUpdate(entity);
	}

	@Override
    public Response buildPdfReport(Paiement entity) {
        try {
        	  List<Paiement> records =manager.getCriteres(entity);
              String URL = ReportHelper.templateURL+ReportsName.FACTURE.getName();
              Map parameters = new HashMap();
              return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
            Response.serverError().build();
        }catch (JRException ex) {
            Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        return Response.noContent().build();
    }

}
