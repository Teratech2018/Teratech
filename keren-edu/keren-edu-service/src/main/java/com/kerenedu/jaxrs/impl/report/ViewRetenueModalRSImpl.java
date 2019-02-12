
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
import com.core.tools.DateHelper;
import com.kerem.core.FileHelper;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.core.ifaces.report.ViewBulletinPaieHelperManagerRemote;
import com.kerenedu.core.ifaces.report.ViewEtatPretManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewRetenueModalRS;
import com.kerenedu.model.report.ViewBulletinPaieHelper;
import com.kerenedu.model.report.ViewRetenueModal;
import com.kerenedu.solde.Acompte;
import com.kerenedu.solde.AcompteManagerRemote;
import com.kerenedu.solde.BulletinPaie;
import com.kerenedu.solde.BulletinPaieManagerRemote;
import com.kerenedu.solde.RemboursementPret;
import com.kerenedu.solde.RemboursementPretManagerRemote;
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
@Path("/viewretenuemodal")
public class ViewRetenueModalRSImpl extends AbstractGenericService<ViewRetenueModal, Long>
		implements ViewRetenueModalRS {

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
	 
	 @Manager(application = "kereneducation", name = "AcompteManagerImpl", interf = AcompteManagerRemote.class)
	  protected AcompteManagerRemote manageracompte;

	public ViewRetenueModalRSImpl() {
		super();
	}

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		try {
			MetaData meta = MetaDataUtil.getMetaData(new ViewRetenueModal(), new HashMap<String, MetaData>(),
					new ArrayList<String>());

			return meta;
		} catch (InstantiationException ex) {
			Logger.getLogger(ViewRetenueModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(ViewRetenueModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	/**
	 * Methode permettant de retourner le gestionnaire d'entites
	 * 
	 */
	@Override
	public GenericManager<ViewRetenueModal, Long> getManager() {
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
	public Response retenuesSalaires(ViewRetenueModal entity, HttpHeaders headers) {
		try {
			String URL ="";
			Response results = null ;
			Map parameters = null;
			if(entity.getRubrique().getPret()!=null&&entity.getRubrique().getPret()==true){ // situation des pret 
				List<RemboursementPret> records = new ArrayList<RemboursementPret>();
				records = managerrem.getCriteres(entity);
				if(records!=null&!records.isEmpty()){
					RemboursementPret aco = records.get(0);
					records.addAll(this.datasviderem(aco));
				}
				 parameters = this.getReportParameters();
				 URL = ReportHelper.templatepaieURL + ReportsName.RETENUE_SAL_TD.getName();
				 results =buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
			}else if(entity.getRubrique().getAcompte()!=null&&entity.getRubrique().getAcompte()==true){// situation des Acompte
				List<Acompte> records = new ArrayList<Acompte>();
				// completr les ligne vide
				records = manageracompte.getCriteres(entity);
				if(records!=null&!records.isEmpty()){
					Acompte aco = records.get(0);
					records.addAll(this.datasvideacompte(aco));
				}
				 parameters = this.getReportParameters();
				 URL = ReportHelper.templatepaieURL + ReportsName.ACOMPTE_TD.getName();
				 results =buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
			}else if(entity.getRubrique().getNature()!=null&&entity.getRubrique().getNature().equals("3")){ // allocation familiale
				List<BulletinPaie> records = new ArrayList<BulletinPaie>();
				records = manager.getCriteres(entity,"cnps");
				if(records!=null&!records.isEmpty()){
					BulletinPaie bull = records.get(0);
					records.addAll(this.datasvidebulletin(bull));
				}
				 parameters = this.getReportParameters();
				 URL = ReportHelper.templatepaieURL + ReportsName.CNPS_TD.getName();
				 results =buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
				
			}else  if(entity.getRubrique().getNature()!=null&&entity.getRubrique().getNature().equals("4")){ // Amicale
				List<BulletinPaie> records = new ArrayList<BulletinPaie>();
				records = manager.getCriteres(entity,"amicale");
				if(records!=null&!records.isEmpty()){
					BulletinPaie bull = records.get(0);
					records.addAll(this.datasvidebulletin(bull));
				}
				 parameters = this.getReportParameters();
				 URL = ReportHelper.templatepaieURL + ReportsName.AMICALE_TD.getName();
				 results =buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
				
			}else  if(entity.getRubrique().getNature()!=null&&entity.getRubrique().getNature().equals("5")){ // Logement
				List<BulletinPaie> records = new ArrayList<BulletinPaie>();
				records = manager.getCriteres(entity ,"logement");
				if(records!=null&!records.isEmpty()){
					BulletinPaie bull = records.get(0);
					records.addAll(this.datasvidebulletin(bull));
				}
				 parameters = this.getReportParameters();
				 URL = ReportHelper.templatepaieURL + ReportsName.LOYER_TD.getName();
				 results =buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
			}
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
	public Response retenuesSalairesbi(ViewRetenueModal entity, HttpHeaders headers) {
		// TODO Auto-generated method stub
		return this.retenuesSalaires(entity, headers);
	}

	public List<Acompte> datasvideacompte(Acompte entity){
		List<Acompte> resullts = new ArrayList<Acompte>();
		 Calendar xx=Calendar.getInstance();	
		 int jour = xx.get(Calendar.DAY_OF_MONTH);
			int mois = xx.get(Calendar.MONTH);
			int annee = xx.get(Calendar.YEAR);
		  for (int i=1; i<=12; i++){
			  Acompte newacompte = new Acompte();
			  try {
				xx.set(Calendar.DAY_OF_MONTH, jour);
				xx.set(Calendar.MONTH, i-1);
				xx.set(Calendar.YEAR, annee);
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String newdate1=formatter.format(xx.getTime());
				newacompte.setId(-i);
				//System.out.println("ViewRetenueModalRSImpl.datasvide() date "+formatter.parse(newdate1));
				newacompte.setEffet(formatter.parse(newdate1));
				newacompte.setEmploye(entity.getEmploye());
				newacompte.setMontant((double) 0);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  resullts.add(newacompte);
		  }
		
		return resullts;
	}
	
	
	public List<RemboursementPret> datasviderem(RemboursementPret entity){
		List<RemboursementPret> resullts = new ArrayList<RemboursementPret>();
		 Calendar xx=Calendar.getInstance();	
		 int jour = xx.get(Calendar.DAY_OF_MONTH);
			int mois = xx.get(Calendar.MONTH);
			int annee = xx.get(Calendar.YEAR);
		  for (int i=1; i<=12; i++){
			  RemboursementPret newacompte = new RemboursementPret();
			  try {
				xx.set(Calendar.DAY_OF_MONTH, jour);
				xx.set(Calendar.MONTH, i-1);
				xx.set(Calendar.YEAR, annee);
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String newdate1=formatter.format(xx.getTime());
				newacompte.setId(-i);
				//System.out.println("ViewRetenueModalRSImpl.datasvide() date "+formatter.parse(newdate1));
				newacompte.setDate(formatter.parse(newdate1));
				newacompte.setDemande(entity.getDemande());
				newacompte.setMontant((double) 0);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  resullts.add(newacompte);
		  }
		
		return resullts;
	}
	
	public List<BulletinPaie> datasvidebulletin(BulletinPaie entity){
		List<BulletinPaie> resullts = new ArrayList<BulletinPaie>();
		 Calendar xx=Calendar.getInstance();	
		 int jour = xx.get(Calendar.DAY_OF_MONTH);
			int mois = xx.get(Calendar.MONTH);
			int annee = xx.get(Calendar.YEAR);
		  for (int i=1; i<=12; i++){
			  BulletinPaie newacompte = new BulletinPaie();
			  try {
				xx.set(Calendar.DAY_OF_MONTH, jour);
				xx.set(Calendar.MONTH, i-1);
				xx.set(Calendar.YEAR, annee);
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String newdate1=formatter.format(xx.getTime());
				newacompte.setId(-i);
				//System.out.println("ViewRetenueModalRSImpl.datasvide() date "+formatter.parse(newdate1));
				newacompte.setDpayement(formatter.parse(newdate1));
				newacompte.setEmploye(entity.getEmploye());
				newacompte.setAmical((double) 0);
				newacompte.setLoyer((double) 0);
				newacompte.setAllocation((double) 0);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  resullts.add(newacompte);
		  }
		
		return resullts;
	}
	}
