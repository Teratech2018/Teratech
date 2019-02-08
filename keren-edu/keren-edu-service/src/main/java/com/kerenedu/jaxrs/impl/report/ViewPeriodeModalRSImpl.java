
package com.kerenedu.jaxrs.impl.report;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.FileHelper;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.core.ifaces.report.ViewBulletinPaieHelperManagerRemote;
import com.kerenedu.core.ifaces.report.ViewEtatPretManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewPeriodeModalRS;
import com.kerenedu.model.report.ViewBulletinPaieHelper;
import com.kerenedu.model.report.ViewEtatPret;
import com.kerenedu.model.report.ViewPeriodeModal;
import com.kerenedu.solde.BulletinPaie;
import com.kerenedu.solde.BulletinPaieManagerRemote;
import com.kerenedu.solde.RemboursementPret;
import com.kerenedu.solde.RemboursementPretManagerRemote;
import com.kerenedu.tools.reports.KerenSchoolTools;
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
@Path("/viewperiodemodal")
public class ViewPeriodeModalRSImpl extends AbstractGenericService<ViewPeriodeModal, Long>
		implements ViewPeriodeModalRS {

	/**
	 * On injecte un Gestionnaire d'entites
	 * 
	 */
	@Manager(application = "kereneducation", name = "BulletinPaieManagerImpl", interf = BulletinPaieManagerRemote.class)
	protected BulletinPaieManagerRemote manager;

	@Manager(application = "kereneducation", name = "ViewBulletinPaieHelperManagerImpl", interf = ViewBulletinPaieHelperManagerRemote.class)
	protected ViewBulletinPaieHelperManagerRemote managerview;
	
	 @Manager(application = "kereneducation", name = "ViewEtatPretManagerImpl", interf = ViewEtatPretManagerRemote.class)
	    protected ViewEtatPretManagerRemote managerpret;
	 
	 @Manager(application = "kereneducation", name = "RemboursementPretManagerImpl", interf = RemboursementPretManagerRemote.class)
	    protected RemboursementPretManagerRemote managerrem;

	public ViewPeriodeModalRSImpl() {
		super();
	}

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		try {
			MetaData meta = MetaDataUtil.getMetaData(new ViewPeriodeModal(), new HashMap<String, MetaData>(),
					new ArrayList<String>());

			return meta;
		} catch (InstantiationException ex) {
			Logger.getLogger(ViewPeriodeModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(ViewPeriodeModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	/**
	 * Methode permettant de retourner le gestionnaire d'entites
	 * 
	 */
	@Override
	public GenericManager<ViewPeriodeModal, Long> getManager() {
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

		return ReportHelperTrt.getReportParametersSolde();
	}

	@Override
	public Response buildPdfReport(ViewPeriodeModal entity, @Context HttpHeaders headers) {
		try {

			List<BulletinPaie> records = new ArrayList<BulletinPaie>();
			records = manager.getCriteres(entity);
			String URL = ReportHelper.templatepaieURL + ReportsName.BULLETIN_PAIE.getName();
			Map parameters = this.getReportParameters();
			
			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(BulletinPaie.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(BulletinPaie.class.getName()).log(Level.SEVERE, null, ex);
		}

		return Response.noContent().build();
	}

	@Override
	public Response virementsalaire(ViewPeriodeModal entity, HttpHeaders headers) {
		try {

			List<BulletinPaie> records = new ArrayList<BulletinPaie>();
			entity.setTypereport("1");
			records = manager.getCriteres(entity);
			Double totalnet = 0.0;
			if(records!=null&&!records.isEmpty()){
				for(BulletinPaie bull : records){
					totalnet+=bull.getNetapayer();
				}
			}
			String URL = ReportHelper.templatepaieURL + ReportsName.DOC_BANCAIRE.getName();
			Map parameters = this.getReportParameters();
			parameters.put(ReportsParameter.TOTAL_NET, KerenSchoolTools.getFormatLetter(totalnet));
			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(BulletinPaie.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(BulletinPaie.class.getName()).log(Level.SEVERE, null, ex);
		}

		return Response.noContent().build();
	}

	@Override
	public Response caissesalaire(ViewPeriodeModal entity, HttpHeaders headers) {
		try {

			List<BulletinPaie> records = new ArrayList<BulletinPaie>();
			entity.setTypereport("0");
			records = manager.getCriteres(entity);
			String URL = ReportHelper.templatepaieURL + ReportsName.PEICE_CAISSE.getName();
			Double totalnet = 0.0;
			if(records!=null&&!records.isEmpty()){
				for(BulletinPaie bull : records){
					totalnet+=bull.getNetapayer();
				}
			}
			Map parameters = this.getReportParameters();
			parameters.put(ReportsParameter.TOTAL_NET, KerenSchoolTools.getFormatLetter(totalnet));
			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(BulletinPaie.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(BulletinPaie.class.getName()).log(Level.SEVERE, null, ex);
		}

		return Response.noContent().build();
	}

	@Override
	public Response retenuesSalaires(ViewPeriodeModal entity, HttpHeaders headers) {
		try {

//			List<ViewEtatPret> records = new ArrayList<ViewEtatPret>();
//			entity.setType("1");
//			records = managerpret.getCriteres(entity);
			List<RemboursementPret> records = new ArrayList<RemboursementPret>();
			//records = managerrem.getCriteres(entity);
			String URL = ReportHelper.templatepaieURL + ReportsName.RETENUE_SAL_TD.getName();
			Map parameters = this.getReportParameters();
			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(ViewBulletinPaieHelper.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(ViewBulletinPaieHelper.class.getName()).log(Level.SEVERE, null, ex);
		}

		return Response.noContent().build();
	}

	@Override
	public Response pieceBancaire(ViewPeriodeModal entity, HttpHeaders headers) {
		try {

			List<BulletinPaie> records = new ArrayList<BulletinPaie>();
			entity.setTypereport("1");
			records = manager.getCriteres(entity);
			Double totalnet = 0.0;
			if(records!=null&&!records.isEmpty()){
				for(BulletinPaie bull : records){
					totalnet+=bull.getNetapayer();
				}
			}
			String URL = ReportHelper.templatepaieURL + ReportsName.DOC_BANCAIRE.getName();
			Map parameters = this.getReportParameters();
			parameters.put(ReportsParameter.TOTAL_NET, KerenSchoolTools.getFormatLetter(totalnet));
			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(BulletinPaie.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(BulletinPaie.class.getName()).log(Level.SEVERE, null, ex);
		}

		return Response.noContent().build();
	}

	@Override
	public Response buildPdfReportbi(ViewPeriodeModal entity, HttpHeaders headers) {
		// TODO Auto-generated method stub
		return this.buildPdfReport(entity, headers);
	}

	@Override
	public Response virementsalairebi(ViewPeriodeModal entity, HttpHeaders headers) {
		// TODO Auto-generated method stub
		return this.virementsalaire(entity, headers);
	}

	@Override
	public Response caissesalairebi(ViewPeriodeModal entity, HttpHeaders headers) {
		// TODO Auto-generated method stub
		return this.caissesalaire(entity, headers);
	}

	@Override
	public Response retenuesSalairesbi(ViewPeriodeModal entity, HttpHeaders headers) {
		// TODO Auto-generated method stub
		return this.retenuesSalaires(entity, headers);
	}

	@Override
	public Response pieceBancairebi(ViewPeriodeModal entity, HttpHeaders headers) {
		// TODO Auto-generated method stub
		return this.pieceBancaire(entity, headers);
	}

}
