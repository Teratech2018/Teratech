
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

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.FileHelper;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.TypeCacheMemory;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.FichePresenceModalModalRS;
import com.kerenedu.model.report.FichePresenceModal;
import com.kerenedu.model.report.ViewBulletinPaieHelper;
import com.kerenedu.solde.Acompte;
import com.kerenedu.solde.AcompteManagerRemote;
import com.kerenedu.solde.BulletinPaie;
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
@Path("/fichepresencemodal")
public class FichePresenceModalRSImpl extends AbstractGenericService<FichePresenceModal, Long>
		implements FichePresenceModalModalRS {

	
	 
	 @Manager(application = "kereneducation", name = "AcompteManagerImpl", interf = AcompteManagerRemote.class)
	  protected AcompteManagerRemote manageracompte;
	 
	 @Manager(application = "kereneducation", name = "InscriptionManagerImpl", interf = InscriptionManagerRemote.class)
		protected InscriptionManagerRemote manager;

	public FichePresenceModalRSImpl() {
		super();
	}

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		try {
			MetaData meta = MetaDataUtil.getMetaData(new FichePresenceModal(), new HashMap<String, MetaData>(),
					new ArrayList<String>());

			return meta;
		} catch (InstantiationException ex) {
			Logger.getLogger(FichePresenceModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(FichePresenceModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	/**
	 * Methode permettant de retourner le gestionnaire d'entites
	 * 
	 */
	@Override
	public GenericManager<FichePresenceModal, Long> getManager() {
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
	public Response reportficheprsence(FichePresenceModal entity, HttpHeaders headers) {
		try {
			String URL ="";
			Response results = null ;
			Map parameters = null;
			List<Inscription> records = new ArrayList<Inscription>();
			RestrictionsContainer container = RestrictionsContainer.newInstance();
			  Gson gson = new Gson();
		        long id = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
			 AnneScolaire annee = (AnneScolaire) CacheMemory.getValue(id, TypeCacheMemory.ANNEESCOLAIRE);
	         if(annee!=null){
	         	 container.addEq("anneScolaire", annee.getCode());
	         }
	         
			if(entity.getClasse()!=null){
				container.addEq("classe.id", entity.getClasse().getId());
			}
			if(entity.getCycle()!=null){
				container.addEq("classe.filiere.cycle.id", entity.getCycle().getId());	
			}
			records=manager.filter(container.getPredicats(), null, null, 0, -1);
			parameters = this.getReportParameters();
			URL = ReportHelper.templateURL + ReportsName.FICHE_PRESENCE.getName();
			results =buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
			
			return results;
		} catch (FileNotFoundException ex) {
			Logger.getLogger(ViewBulletinPaieHelper.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError( ).build();
		} catch (JRException ex) {
			Logger.getLogger(ViewBulletinPaieHelper.class.getName()).log(Level.SEVERE, null, ex);
		}

		return Response.noContent().build();
	}

	
	@Override
	public Response reportficheprsencebi(FichePresenceModal entity, HttpHeaders headers) {
		// TODO Auto-generated method stub
		return this.reportficheprsence(entity, headers);
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
