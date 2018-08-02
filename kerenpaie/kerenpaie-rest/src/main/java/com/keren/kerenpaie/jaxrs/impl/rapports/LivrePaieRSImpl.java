
package com.keren.kerenpaie.jaxrs.impl.rapports;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.paie.BulletinPaieManagerRemote;
import com.keren.kerenpaie.core.ifaces.paie.CacheMemory;
import com.keren.kerenpaie.core.ifaces.rapports.ViewBulletinPaieManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.rapports.LivrePaieRS;
import com.keren.kerenpaie.jaxrs.impl.paie.ReportHelperTrt;
import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.keren.kerenpaie.model.paie.LigneElementVariable;
import com.keren.kerenpaie.model.paie.Parametres;
import com.keren.kerenpaie.model.rapports.LivrePaie;
import com.keren.kerenpaie.tools.report.ReportHelper;
import com.keren.kerenpaie.tools.report.ReportsName;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import javax.ws.rs.core.Context;

import net.sf.jasperreports.engine.JRException;

/**
 * Classe d'implementation du Web Service JAX-RS
 * 
 * @since Fri Apr 06 09:41:44 WAT 2018
 * 
 */
@Path("/livrepaie")
public class LivrePaieRSImpl extends AbstractGenericService<LivrePaie, Long> implements LivrePaieRS {

	/**
	 * On injecte un Gestionnaire d'entites
	 * 
	 */
	@Manager(application = "kerenpaie", name = "ViewBulletinPaieManagerImpl", interf = ViewBulletinPaieManagerRemote.class)
	protected ViewBulletinPaieManagerRemote viewmanager;

	@Manager(application = "kerenpaie", name = "BulletinPaieManagerImpl", interf = BulletinPaieManagerRemote.class)
	protected BulletinPaieManagerRemote managerBulletin;

	public LivrePaieRSImpl() {
		super();
	}

	/**
	 * Methode permettant de retourner le gestionnaire d'entites
	 * 
	 */
	@Override
	public GenericManager<LivrePaie, Long> getManager() {
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
	
	

	/**
	 *
	 * @return
	 */

	public MetaData getMetaData() {
		try {
			MetaData meta = MetaDataUtil.getMetaData(new LivrePaie(), new HashMap<String, MetaData>(),new ArrayList<String>());
//			MetaColumn workbtn = new MetaColumn("button", "work2", "Livre de Paie", false, "report", null);
//			workbtn.setValue(
//					"{'model':'kerenpaie','entity':'livrepaie','method':'buildlivrepaie','template':{'this':'object'}}");
//			workbtn.setStates(new String[] { "etabli" });
//			workbtn.setPattern("btn btn-primary");
//			// meta.getHeader().add(workbtn);
//			//// workbtn = new MetaColumn("button", "work3", "Annuler", false,
//			// "workflow", null);
//			//// workbtn.setValue("{'model':'kerenpaie','entity':'acompte','method':'annule'}");
//			//// workbtn.setStates(new String[]{"etabli"});
//			//// workbtn.setPattern("btn btn-danger");
//			//meta.getHeader().add(workbtn);
//			MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
//			meta.getHeader().add(stautsbar);
//			System.out.println(LivrePaieRSImpl.class.toString() + ".getMetaData() ========= " + meta);
			return meta;
		} catch (InstantiationException ex) {
			Logger.getLogger(LivrePaieRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(LivrePaieRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
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
	public Response buildLivrePaie(LivrePaie livre) {
		livre.setPeriode(CacheMemory.getPeriode());
		if (livre.getPeriode() == null) {
			throw new KerenExecption("Bien vouloir renseigner les paramètres d'impression <br/> ");
		}
		try {
			
			System.out.println("LivrePaieRSImpl.buildLivrePaie() je suis ici livre pauiie");
			List<BulletinPaie> records = managerBulletin.getCriteres(new BulletinPaie(livre));
			// ;
			String URL = ReportHelper.templateURL + ReportsName.LIVRE_PAIE.getName();
			Map parameters = this.getReportParameters();
			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters,
					this.getLivretoprint(records));
		} catch (FileNotFoundException ex) {
			Logger.getLogger(LivrePaieRSImpl.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(LivrePaieRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}

		return Response.noContent().build();
	}

	public List<BulletinPaie> getLivretoprint(List<BulletinPaie> records) {
		System.out.println("LivrePaieRSImpl.getLivretoprint() je suis là "+records.size());
		Double netapayer = 0.0;
		List<BulletinPaie> datas = new ArrayList<BulletinPaie>();
		Parametres p = new Parametres();
		for (BulletinPaie bulletin : records) {
			p = new Parametres();
			for (LigneElementVariable ligne : bulletin.getVariables()) {
				System.out.println("LivrePaieRSImpl.getLivretoprint() code ====== "+ligne.getVariable().getCode());
				if (ligne.getVariable().getCode().equals("SALBASE")) {
					p.setSalbase(ligne.getValeur());
					System.out.println("LivrePaieRSImpl.getLivretoprint() salbase "+p.getSalbase());
				}
				if (ligne.getVariable().getCode().equals("FORMULANCIENNET")) {
				p.setPrimeanciennete(ligne.getValeur());
				}
				
				if (ligne.getVariable().getCode().equals("IRPP")) {
					p.setIrpp(ligne.getValeur());
					p.setCac(ligne.getValeur()*0.1);
					p.setPvid(ligne.getValeur()*0.1);
				}
				if (ligne.getVariable().getCode().equals("TDL")) {
					p.setTdl(ligne.getValeur());
				}
				if (ligne.getVariable().getCode().equals("CRTVV")) {
					p.setRav(ligne.getValeur());
				}
				if (ligne.getVariable().getCode().equals("RAPPEL")) {
					p.setRappel(ligne.getValeur());
				}
				if (ligne.getVariable().getCode().equals("PENSIONVEILLESSE")) {
					p.setPvid(ligne.getValeur());
				}
				if (ligne.getVariable().getCode().equals("BRUTSALTAX")) {
					p.setPvid(ligne.getValeur()*0.1);
				}
				
				
				
			}
			netapayer= bulletin.getSalaireBrut()-bulletin.getChargeSalariale();
			BigDecimal bd = new BigDecimal(netapayer);
			bd = bd.setScale(0, BigDecimal.ROUND_UP);
			Double netarond = bd.doubleValue();
			bulletin.setNetapayer(netarond);
			bulletin.setParametre(p);
			datas.add(bulletin);
		}
		return datas;
	}

	@Override
	public LivrePaie save(@Context HttpHeaders headers , LivrePaie entity) {
//		System.out.println("LivrePaieRSImpl.save() je suis ici ");
		this.buildLivrePaie(entity);
		return entity;
	}

}
