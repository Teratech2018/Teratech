
package com.keren.kerenpaie.jaxrs.impl.rapports;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.paie.BulletinPaieManagerRemote;
import com.keren.kerenpaie.core.ifaces.paie.CacheMemory;
import com.keren.kerenpaie.core.ifaces.rapports.ViewBulletinPaieManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.rapports.BPaieRS;
import com.keren.kerenpaie.jaxrs.impl.paie.ReportHelperTrt;
import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.keren.kerenpaie.model.rapports.BPaie;
import com.keren.kerenpaie.tools.report.ReportHelper;
import com.keren.kerenpaie.tools.report.ReportsName;
import com.keren.kerenpaie.tools.report.ReportsParameter;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.base.JRBaseParameter;

/**
 * Classe d'implementation du Web Service JAX-RS
 * 
 * @since Fri Apr 06 09:41:44 WAT 2018
 * 
 */
@Path("/bpaie")
public class BPaieRSImpl extends AbstractGenericService<BPaie, Long> implements BPaieRS {

	/**
	 * On injecte un Gestionnaire d'entites
	 * 
	 */
	@Manager(application = "kerenpaie", name = "ViewBulletinPaieManagerImpl", interf = ViewBulletinPaieManagerRemote.class)
	protected ViewBulletinPaieManagerRemote viewmanager;

	@Manager(application = "kerenpaie", name = "BulletinPaieManagerImpl", interf = BulletinPaieManagerRemote.class)
	protected BulletinPaieManagerRemote bulletinmanager;

	public BPaieRSImpl() {
		super();
	}

	/**
	 * Methode permettant de retourner le gestionnaire d'entites
	 * 
	 */
	@Override
	public GenericManager<BPaie, Long> getManager() {
		return null;
	}

	public String getModuleName() {
		return ("kerenpaie");
	}

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		return getMetaData(); // To change body of generated methods, choose
								// Tools | Templates.
	}

	public MetaData getMetaData() {
		try {
			MetaData meta = MetaDataUtil.getMetaData(new BPaie(), new HashMap<String, MetaData>(),
					new ArrayList<String>());
			MetaColumn workbtn = new MetaColumn("button", "work2", "Bulletin de Paie", false, "report", null);
			workbtn.setValue("{'model':'kerenpaie','entity':'bpaie','method':'buildbpaie'}");
			workbtn.setStates(new String[] { "etabli" });
			//// workbtn.setPattern("btn btn-primary");
			// meta.getHeader().add(workbtn);
			//// workbtn = new MetaColumn("button", "work3", "Annuler", false,
			//// "workflow", null);
			//// workbtn.setValue("{'model':'kerenpaie','entity':'acompte','method':'annule'}");
			//// workbtn.setStates(new String[]{"etabli"});
			//// workbtn.setPattern("btn btn-danger");
			meta.getHeader().add(workbtn);
			MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
			meta.getHeader().add(stautsbar);
			return meta;
		} catch (InstantiationException ex) {
			Logger.getLogger(BPaieRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(BPaieRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	  public Map getReportParameters() {
	        return ReportHelperTrt.getReportParameters();
	    }

	@Override
	public Response buildBPaie(BPaie entity) {
//		entity.setPeriode(CacheMemory.getPeriode());

		if (entity.getPeriode() == null) {
			throw new KerenExecption("Bien vouloir renseigner les paramètres d'impression <br/> ");
		}
		System.out.println(BPaieRSImpl.class.toString()+".buildLivrePaie() debut execution report" + entity.getPeriode().getCode());
		try {
			List<BulletinPaie> records = bulletinmanager.getCriteres(entity);
			String URL = ReportHelper.templateURL + ReportsName.BULLETIN_PAIE.getName();
			Map parameters = this.getReportParameters();
			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, ReportHelperTrt.getBulletintoprint(records));
		} catch (FileNotFoundException ex) {
			Logger.getLogger(BPaieRSImpl.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(BPaieRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}

		return Response.noContent().build();
	}

}
