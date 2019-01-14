
package com.kerenedu.jaxrs.impl.report;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.core.ifaces.report.ViewDltPaiementManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewDltPaiementModalRS;
import com.kerenedu.model.report.ViewDltPaiement;
import com.kerenedu.model.report.ViewDltPaiementModal;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.kerenedu.tools.reports.ReportsParameter;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;

/**
 * Classe d'implementation du Web Service JAX-RS
 * 
 * @since Tue Jun 19 09:26:19 WAT 2018
 * 
 */
@Path("/viewdltpaiementmodal")
public class ViewDltPaiementModalRSImpl extends AbstractGenericService<ViewDltPaiementModal, Long>
		implements ViewDltPaiementModalRS {

	/**
	 * On injecte un Gestionnaire d'entites
	 * 
	 */
	@Manager(application = "kereneducation", name = "ViewDltPaiementManagerImpl", interf = ViewDltPaiementManagerRemote.class)
	protected ViewDltPaiementManagerRemote manager;

	public ViewDltPaiementModalRSImpl() {
		super();
	}

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			return MetaDataUtil.getMetaData(new ViewDltPaiementModal(), new HashMap<String, MetaData>(),
					new ArrayList<String>());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new WebApplicationException(
					Response.serverError().entity(new String("MetaData parse error")).build());
		}
	}

	/**
	 * Methode permettant de retourner le gestionnaire d'entites
	 * 
	 */
	@Override
	public GenericManager<ViewDltPaiementModal, Long> getManager() {
		return null;
	}

	public String getModuleName() {
		return ("kereneducation");
	}

	/**
	 * Methode permettant de retourner les parametres pour le reporting
	 *
	 * @return java.util.Map
	 */
	public Map getReportParameters() {

		return ReportHelperTrt.getReportParameters();
	}

	@Override
	public Response buildPdfReport(ViewDltPaiementModal entity) {
		try {
			List<ViewDltPaiement> records = manager.getCriteres(entity);
			System.out.println("ViewDltPaiementModalRSImpl.buildPdfReport() size record is " + records.size());
			if (records==null&&records.size() == 0) {
				throw new KerenExecption("Aucune Données Trouvés !!!");
			}
			String URL = ReportHelper.templateURL + ReportsName.LINSTINGPAIEMENT.getName();
			Map parameters = new HashMap();
			parameters = this.getReportParameters();
			System.out.println("ViewDltPaiementModalRSImpl.buildPdfReport() date " + entity.getDatepaideb());

			parameters.put(ReportsParameter.DEBUT, entity.getDatepaideb());
			parameters.put(ReportsParameter.FIN, entity.getDatepaifin());
			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}

		return Response.noContent().build();
	}

	@Override
	public Response buildPdfReportbi(ViewDltPaiementModal entity) {
		// TODO Auto-generated method stub
		return this.buildPdfReport(entity);
	}

}
