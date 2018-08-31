
package com.kerenedu.reglement;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
import com.google.gson.reflect.TypeToken;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.UserEducation;
import com.kerenedu.configuration.UserEducationManagerRemote;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionManagerRemote;
import com.kerenedu.jaxrs.impl.report.ReportHelperTrt;
import com.kerenedu.jaxrs.impl.report.ViewBulletinRSImpl;
import com.kerenedu.tools.KerenEduManagerException;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.kerenedu.tools.reports.ReportsParameter;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;

import net.sf.jasperreports.engine.JRException;

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

	@Manager(application = "kereneducation", name = "InscriptionManagerImpl", interf = InscriptionManagerRemote.class)
	protected InscriptionManagerRemote managerIns;

	@Manager(application = "kereneducation", name = "UserEducationManagerImpl", interf = UserEducationManagerRemote.class)
	protected UserEducationManagerRemote managerUser;

	@Manager(application = "kereneducation", name = "FichePaiementManagerImpl", interf = FichePaiementManagerRemote.class)
	protected FichePaiementManagerRemote managerFiche;

	@Manager(application = "kereneducation", name = "ReglementManagerImpl", interf = ReglementManagerRemote.class)
	protected ReglementManagerRemote managerregl;

	@Manager(application = "kereneducation", name = "RemiseManagerImpl", interf = RemiseManagerRemote.class)
	protected RemiseManagerRemote managerRemise;

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
			MetaData meta = MetaDataUtil.getMetaData(new Paiement(), new HashMap<String, MetaData>(),
					new ArrayList<String>());
			MetaColumn workbtn = new MetaColumn("button", "work1", "Annuler le Paiement", false, "workflow", null);
			workbtn.setStates(new String[] { "etabli" });
			workbtn.setPattern("btn btn-primary");
			workbtn.setValue("{'model':'kereneducation','entity':'paiement','method':'annuler'}");
			meta.getHeader().add(workbtn);

			workbtn = new MetaColumn("button", "work2", "Imprimer la Facture", false, "report", null);
			workbtn.setValue("{'model':'kereneducation','entity':'paiement','method':'facture'}");
			workbtn.setStates(new String[] { "etabli" });
			// workbtn.setPattern("btn btn-primary");
			meta.getHeader().add(workbtn);

			MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
			meta.getHeader().add(stautsbar);
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
	public List<Paiement> filter(HttpHeaders headers, int firstResult, int maxResult) {
		Gson gson = new Gson();
		Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);

		// UtilisateurCourrier user = usermanager.getUserByAcompte(userid);
		// Type predType = ;
		List contraints = new ArrayList();
		if (headers.getRequestHeader("predicats") != null) {
			contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),
					new TypeToken<List<FilterPredicat>>() {
					}.getType());
		} // end if(headers.getRequestHeader("predicats")!=null){
			// System.out.println(AbstractGenericService.class.toString()+" ===
			// "+headers.getRequestHeader("predicats")+" === "+firstResult+" ===
			// "+maxResult+" == "+contraints);
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (contraints != null && !contraints.isEmpty()) {
			for (Object obj : contraints) {
				FilterPredicat filter = (FilterPredicat) obj;
				if (filter.getFieldName() != null && !filter.getFieldName().trim().isEmpty()
						&& filter.getValue() != null && !filter.getValue().isEmpty()) {
					container = addPredicate(container, filter);
				} // end
					// if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
			} // end for(Object obj : contraints)
		} // end if(contraints!=null&&!contraints.isEmpty())
			// container.addEq("source", user);

		if (headers.getRequestHeader("eleve") != null) {
			long studenid = gson.fromJson(headers.getRequestHeader("eleve").get(0), Long.class);

			Inscription inscription = null;
			inscription = managerIns.find("id", studenid);
			container.addEq("eleve.id", inscription.getId());
		}
		container.addEq("state", "etabli");

		// if (inscription != null) {
		// container.addEq("eleve.eleve.matricule", inscription.getEleve().());
		// }
		// if (CacheMemory.getCurrentNameStudent() != null &&
		// !CacheMemory.getCurrentNameStudent().isEmpty()
		// && !CacheMemory.getCurrentNameStudent().equals("")) {
		// container.addEq("eleve.eleve.nom",
		// CacheMemory.getCurrentNameStudent());
		// }
		String anneScolaire = CacheMemory.getCurrentannee();
		if (anneScolaire != null) {
			container.addEq("anneScolaire", anneScolaire);
		}
		// List result = new ArrayList();
		return getManager().filter(container.getPredicats(), null, new HashSet<String>(), firstResult, maxResult);
	}

	@Override
	public RSNumber count(HttpHeaders headers) {
		// To change body of generated methods, choose Tools | Templates.
		// To change body of generated methods, choose Tools | Templates.
		Gson gson = new Gson();
		Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);

		// UtilisateurCourrier user = usermanager.getUserByAcompte(userid);
		// Type predType = ;
		List contraints = new ArrayList();
		if (headers.getRequestHeader("predicats") != null) {
			contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),
					new TypeToken<List<FilterPredicat>>() {
					}.getType());
		} // end if(headers.getRequestHeader("predicats")!=null){
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (contraints != null && !contraints.isEmpty()) {
			for (Object obj : contraints) {
				FilterPredicat filter = (FilterPredicat) obj;
				if (filter.getFieldName() != null && !filter.getFieldName().trim().isEmpty()
						&& filter.getValue() != null && !filter.getValue().isEmpty()) {
					container = addPredicate(container, filter);
				} // end
					// if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
			} // end for(Object obj : contraints)
		} // end if(contraints!=null&&!contraints.isEmpty())
		if (headers.getRequestHeader("eleve") != null) {
			long studenid = gson.fromJson(headers.getRequestHeader("eleve").get(0), Long.class);

			Inscription inscription = null;
			inscription = managerIns.find("id", studenid);
			container.addEq("eleve.id", inscription.getId());
		}
		container.addEq("state", "etabli");

		// if (inscription != null) {
		// container.addEq("eleve.eleve.matricule", inscription.getEleve().());
		// }
		// if (CacheMemory.getCurrentNameStudent() != null &&
		// !CacheMemory.getCurrentNameStudent().isEmpty()
		// && !CacheMemory.getCurrentNameStudent().equals("")) {
		// container.addEq("eleve.eleve.nom",
		// CacheMemory.getCurrentNameStudent());
		// }
		String anneScolaire = CacheMemory.getCurrentannee();
		if (anneScolaire != null) {
			container.addEq("anneScolaire", anneScolaire);
		}
		RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
		// System.out.println(AbstractGenericService.class.toString()+".count
		// === "+" == "+number.getValue());
		return number;
	}

	@Override
	protected void processBeforeSave(Paiement entity) {

		if (entity.getZristourne() == null) {
			entity.setZristourne((long) 0);
		}
		// calcul de la remise
		if (entity.getZremise() == null) {
			entity.setZremise((long) 0);
		}

		if (entity.getEleve() == null) {
			throw new KerenExecption("OPERATION IMPOSSIBLE <br/> Selectionner l'elève  !!!!");
		}
		if (entity.getEleve().getzSolde()!=null&&entity.getEleve().getzSolde() == 0 || entity.getEleve().getzMnt() == entity.getEleve().getzMntPaye()) {
			throw new KerenExecption("OPERATION IMPOSSIBLE <br/> Scolarite Totalement Payer pour  "
					+ entity.getEleve().getEleve().getNom());
		}
		if (entity.getzMntverser()!=null &&entity.getzMntverser() == 0 && entity.getModePaiement().equals("1")) {
			throw new KerenExecption("OPERATION IMPOSSIBLE <br/>Bien vouloir Saisir le Montant !!");
		}

		if (entity.getzMntverser()!=null&&entity.getzMntverser() > entity.getEleve().getzSolde() && entity.getModePaiement().equals("1")) {
			throw new KerenExecption("OPERATION IMPOSSIBLE <br/> Montant Saisie ERROR  !!!!");
		}

		if (entity.getZristourne()!=null&&entity.getZristourne() > 0 && entity.getEleve().getzRistourne() > 0) {
			throw new KerenExecption("OPERATION IMPOSSIBLE <br/> Cet eleve a deja beneficier d'une ristourne de : "
					+ entity.getEleve().getzRistourne());
		}
		long remise = 0;
		Inscription inscription = managerIns.find("id", entity.getEleve().getId());
		if (entity.getZremise() == null) {
		long montelligle = 0L;
		
		for (FichePaiement fiche : inscription.getService()) {
			if (fiche.getService().getElligible() == true) {
				montelligle = montelligle + fiche.getZtotal();
			}
		}
		List<Remise> remiselist = this.getremise(entity);// entity.getListremise();
		System.out.println("PaiementRSImpl.processBeforeSave() true remise is "+remiselist.size());
		if (remiselist != null) {

			for (Remise r : remiselist) {

				if (r.getTypeRemise().equals("0")) {
					remise = remise + (r.getzValeur());
				}
				if (r.getTypeRemise().equals("1")) {
					remise = remise + ((r.getzValeur() * montelligle) / 100);
				}
			}
		}
		}else{
			remise= entity.getZremise();
		}
		if (entity.getModePaiement().equals("0")) {			
				entity.setZremise(remise);
				long versement = entity.getZsolde() - remise - entity.getZristourne();
				entity.setzMntverser(versement);
		}else{
			System.out.println("PaiementRSImpl.processBeforeSave() REMISE is :" + remise);
			long totalpayer = inscription.getzMntPaye()+entity.getzMntverser();
			System.out.println("PaiementRSImpl.processBeforeSave() total PAYER is :" + totalpayer);
			
			if(totalpayer==inscription.getzMnt()){
				entity.setZremise(remise);
				long versement = entity.getzMntverser()- remise - entity.getZristourne() ;//- remise - entity.getZristourne()
				System.out.println("PaiementRSImpl.processBeforeSave() versement is :" + versement);
				entity.setzMntverser(versement);
			}
		}

		super.processBeforeSave(entity);
	}

	@Override
	public Paiement annuler(HttpHeaders headers, Paiement entity) {
		try {
			if (entity == null || entity.getId() == -1) {
				throw new KerenExecption(" Selectionner le paiement à annuler !!!");
			}
			if (entity.getState().equalsIgnoreCase("annulé")) {
				throw new KerenExecption("Modification impossible, car l'element a deja ete annulé");
			}
			entity = manager.update(entity.getId(), entity);

			return entity;
		} catch (KerenEduManagerException ex) {
			throw new KerenExecption(ex.getMessage());
		}
	}

	@Override
	public Response facture(HttpHeaders headers, Paiement entity) {
		// TODO Auto-generated method stub
		System.out.println("PaiementRSImpl.facture() paiement pris " + entity.getId());
		if (entity.getEleve() == null) {
			throw new KerenExecption("Ce paiement est nulle <br/> ");
		} // end if(entity.getState().trim().equalsIgnoreCase("valide")){
		try {
			// find user name connect
			// String userid = headers.getRequestHeader("userid").get(0);
			Gson gson = new Gson();
			long id = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
			UserEducation user = managerUser.find("id", id);
			System.out.println("PaiementRSImpl.facture() user found is ====" + user.getName());

			entity.setUsername(user.getName());
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

		return ReportHelperTrt.getReportParameters();
	}

	@Override
	public Response buildPdfReport(Paiement entity) {
		try {
			entity = manager.find("id", entity.getId());
			System.out.println("PaiementRSImpl.buildPdfReport() " + entity.getEleve());

			// Inscription ins = managerIns.find("id",
			// entity.getEleve().getId());
			// entity.setLignes(ins.getService());
			// System.out.println("PaiementRSImpl.buildPdfReport() lignes
			// "+entity.getLignes());
			List<Paiement> records = manager.getCriteres(entity);// new
																	// ArrayList<Paiement>();//
			// records.add(entity);//manager.getCriteres(entity);
			String URL = ReportHelper.templateURL + ReportsName.FACTURE.getName();
			Map parameters = this.getReportParameters();
			parameters.put(ReportsParameter.REPORT_USER, entity.getUsername());
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
	public List<FichePaiement> getideleve(HttpHeaders headers) {
		Gson gson = new Gson();
		long id = gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		if (id > 0) {
			Inscription eleve = managerIns.find("id", id);
			CacheMemory.setIncription(eleve);
		}

		return null;
	}

	@Override
	public List<FichePaiement> findfichefraiseleve(HttpHeaders headers) {
		Gson gson = new Gson();
		long id = gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		List<FichePaiement> ficheeleve = new ArrayList<FichePaiement>();
		if (id > 0) {
			Inscription elve = managerIns.find("id", id);
			for (FichePaiement service : elve.getService()) {
				if (service.getPayer() == false) {
					ficheeleve.add(service);
				}
			}
		}

		return ficheeleve;
	}

	public List<FichePaiement> getFicheeleve(Paiement entity) {
		List<FichePaiement> ficheeleve = new ArrayList<FichePaiement>();
		if (entity != null) {
			Inscription elve = managerIns.find("id", entity.getEleve().getId());
			for (FichePaiement service : elve.getService()) {
				if (service.getPayer() == false) {
					ficheeleve.add(service);
				}
			}
			System.out.println("PaiementRSImpl.getFicheeleve() nombre fiche " + ficheeleve.size());
		}

		return ficheeleve;
	}

	@Override
	public List<Remise> getremise(HttpHeaders headers) {
		Gson gson = new Gson();
		if (headers.getRequestHeader("eleve") == null) {
			throw new KerenExecption("OPERATION IMPOSSIBLE <br/> Selectionner l'elève  !!!!");
		}
		long id = gson.fromJson(headers.getRequestHeader("eleve").get(0), Long.class);
		Inscription eleve = managerIns.find("id", id);

		String mode = gson.fromJson(headers.getRequestHeader("modePaiement").get(0), String.class);
		// long ideleve =
		List<Remise> datas = new ArrayList<Remise>();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if(eleve.getzRemise() == 0){

		if(eleve.getEleve().getResp()!=null&&eleve.getEleve().getResp().getResponsable()!=null
				&&eleve.getEleve().getResp().getResponsable().equals("1")){
			container.addEq("natureRemise", "2");
			container.addLe("zenfant", eleve.getEleve().getResp().getNe());
			container.addGe("zenfantMax", eleve.getEleve().getResp().getNe());
			List<Remise> results = managerRemise.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
			for (Remise remise : results) {
				if (remise.getDatePriseEffet().after(new Date())) {
					datas.add(remise);
				}
			}
		}else{
			container = RestrictionsContainer.newInstance();
			container.addNotEq("natureRemise", "2");
			List<Remise> results = managerRemise.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
			for (Remise remise : results) {
				if (remise.getDatePriseEffet().after(new Date())) {
					datas.add(remise);
				}
			}
		}
		}

		return datas;
	}

	private List<Remise> getremise(Paiement entity) {
		Inscription eleve = managerIns.find("id", entity.getEleve().getId());
		List<Remise> datas = new ArrayList<Remise>();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if(eleve.getzRemise() == 0){

		if(eleve.getEleve().getResp()!=null&&eleve.getEleve().getResp().getResponsable()!=null
				&&eleve.getEleve().getResp().getResponsable().equals("1")){
			container.addEq("natureRemise", "2");
			container.addLe("zenfant", entity.getEleve().getEleve().getResp().getNe());
			container.addGe("zenfantMax", entity.getEleve().getEleve().getResp().getNe());
			List<Remise> results = managerRemise.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
			for (Remise remise : results) {
				if (remise.getDatePriseEffet().after(new Date())) {
					datas.add(remise);
				}
			}
		}else{
			container = RestrictionsContainer.newInstance();
			container.addNotEq("natureRemise", "2");
			List<Remise> results = managerRemise.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
			for (Remise remise : results) {
				if (remise.getDatePriseEffet().after(new Date())) {
					datas.add(remise);
				}
			}
		}
		}
		return datas;

	}

	@Override
	public Long getReduction(HttpHeaders headers) {
		System.out.println("PaiementRSImpl.getRemise() je suis icii remise ");
		Long remise = (long) 23000;
		Gson gson = new Gson();
		Long prioriteid = -1L;
		Long eleveid = -1L;
		eleveid = gson.fromJson(headers.getRequestHeader("eleve").get(0), Long.class);
		String data = headers.getRequestHeader("modePaiement").get(0);

		return remise;
	}

	@Override
	public Long getVersement(HttpHeaders headers) {
		System.out.println("PaiementRSImpl.getRemise() je suis icii vesemment  ");
		Gson gson = new Gson();
		Long prioriteid = -1L;
		Long eleveid = -1L;
		Long versement = (long) 340000;
		eleveid = gson.fromJson(headers.getRequestHeader("eleve").get(0), Long.class);
		String data = headers.getRequestHeader("modePaiement").get(0);

		return versement;
	}

}
