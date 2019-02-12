
package com.kerenedu.jaxrs.impl.report;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.FileHelper;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.jaxrs.ifaces.report.ViewAnneeModalRS;
import com.kerenedu.model.report.ViewAnneeModal;
import com.kerenedu.model.report.ViewBulletinPaieHelper;
import com.kerenedu.personnel.EmargementDtlPeriode;
import com.kerenedu.personnel.EmargementDtlPeriodeManagerRemote;
import com.kerenedu.solde.BulletinPaie;
import com.kerenedu.solde.BulletinPaieManagerRemote;
import com.kerenedu.solde.RemboursementPret;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
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
@Path("/viewanneemodal")
public class ViewAnneeModalRSImpl extends AbstractGenericService<ViewAnneeModal, Long>
		implements ViewAnneeModalRS {

	/**
	 * On injecte un Gestionnaire d'entites
	 * 
	 */
	@Manager(application = "kereneducation", name = "BulletinPaieManagerImpl", interf = BulletinPaieManagerRemote.class)
	protected BulletinPaieManagerRemote manager;

	@Manager(application = "kereneducation", name = "EmargementDtlPeriodeManagerImpl", interf = EmargementDtlPeriodeManagerRemote.class)
	protected EmargementDtlPeriodeManagerRemote managerperiode;
	

	public ViewAnneeModalRSImpl() {
		super();
	}

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		try {
			MetaData meta = MetaDataUtil.getMetaData(new ViewAnneeModal(), new HashMap<String, MetaData>(),
					new ArrayList<String>());

			return meta;
		} catch (InstantiationException ex) {
			Logger.getLogger(ViewAnneeModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(ViewAnneeModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	/**
	 * Methode permettant de retourner le gestionnaire d'entites
	 * 
	 */
	@Override
	public GenericManager<ViewAnneeModal, Long> getManager() {
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
	public Response sithoraire(ViewAnneeModal entity, HttpHeaders headers) {
		try {
			String URL ="";
			Response results = null ;
			Map parameters = null;
			List<EmargementDtlPeriode> records = new ArrayList<EmargementDtlPeriode>();
				records = managerperiode.getCriteres(entity);
				if(records!=null&!records.isEmpty()){
					EmargementDtlPeriode aco = records.get(0);
					records.addAll(this.datasvideemarge(aco));
				}
				 parameters = this.getReportParameters();
				 URL = ReportHelper.templatepaieURL + ReportsName.SIT_HORAIRE.getName();
				 results =buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
		
			return results;
		} catch (FileNotFoundException ex) {
			Logger.getLogger(ViewBulletinPaieHelper.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(ViewBulletinPaieHelper.class.getName()).log(Level.SEVERE, null, ex);
		}

		return Response.noContent().build();
	}

	
	@Override
	public Response sithorairebi(ViewAnneeModal entity, HttpHeaders headers) {
		// TODO Auto-generated method stub
		return this.sithoraire(entity, headers);
	}


	public List<EmargementDtlPeriode> datasvideemarge(EmargementDtlPeriode entity){
		List<EmargementDtlPeriode> resullts = new ArrayList<EmargementDtlPeriode>();
		 Calendar xx=Calendar.getInstance();	
		 int jour = xx.get(Calendar.DAY_OF_MONTH);
			int mois = xx.get(Calendar.MONTH);
			int annee = xx.get(Calendar.YEAR);
		  for (int i=1; i<=12; i++){
			  EmargementDtlPeriode newacompte = new EmargementDtlPeriode();
			  try {
				xx.set(Calendar.DAY_OF_MONTH, jour);
				xx.set(Calendar.MONTH, i-1);
				xx.set(Calendar.YEAR, annee);
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String newdate1=formatter.format(xx.getTime());
				newacompte.setId(-i);
				//System.out.println("ViewRetenueModalRSImpl.datasvide() date "+formatter.parse(newdate1));
				newacompte.setDsaisie(formatter.parse(newdate1));
				newacompte.setProf(entity.getProf());
				newacompte.setPresence((double) 0);;
				newacompte.setRetard((double) 0);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  resullts.add(newacompte);
		  }
		
		return resullts;
	}
	}
