
package com.kerenedu.inscription;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.AnneScolaireManagerRemote;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.ServiceManagerRemote;
import com.kerenedu.configuration.TypeCacheMemory;
import com.kerenedu.configuration.UtilisateurConnect;
import com.kerenedu.configuration.UtilisateurConnectManagerRemote;
import com.kerenedu.jaxrs.impl.report.ReportHelperTrt;
import com.kerenedu.jaxrs.impl.report.ViewBulletinRSImpl;
import com.kerenedu.reglement.FichePaiement;
import com.kerenedu.reglement.Paiement;
import com.kerenedu.reglement.PaiementManagerRemote;
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
 * @since Tue Jan 09 20:37:12 WAT 2018
 * 
 */
@Path("/inscription")
public class InscriptionRSImpl extends AbstractGenericService<Inscription, Long> implements InscriptionRS {

	/**
	 * On injecte un Gestionnaire d'entites
	 * 
	 */
	@Manager(application = "kereneducation", name = "InscriptionManagerImpl", interf = InscriptionManagerRemote.class)
	protected InscriptionManagerRemote manager;

	@Manager(application = "kereneducation", name = "ServiceManagerImpl", interf = ServiceManagerRemote.class)
	protected ServiceManagerRemote managerService;

	@Manager(application = "kereneducation", name = "AnneScolaireManagerImpl", interf = AnneScolaireManagerRemote.class)
	protected AnneScolaireManagerRemote managerAnnee;

	@Manager(application = "kereneducation", name = "PaiementManagerImpl", interf = PaiementManagerRemote.class)
	protected PaiementManagerRemote managerPaiement;
	
	 @Manager(application = "kerencourrier", name = "UtilisateurConnectManagerImpl", interf = UtilisateurConnectManagerRemote.class)
	    protected UtilisateurConnectManagerRemote usermanager;

	public InscriptionRSImpl() {
		super();
	}

	/**
	 * Methode permettant de retourner le gestionnaire d'entites
	 * 
	 */
	@Override
	public GenericManager<Inscription, Long> getManager() {
		return manager;
	}

	public String getModuleName() {
		return ("kereneducation");
	}

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			MetaData meta = MetaDataUtil.getMetaData(new Inscription(), new HashMap<String, MetaData>(),
					new ArrayList<String>());
			// MetaColumn workbtn = new MetaColumn("button", "work1", "Change de
			// Classe", false, "workflow", null);
			// workbtn.setStates(new String[] { "crée" });
			// workbtn.setPattern("btn btn-primary");
			// workbtn.setValue("{'model':'kereneducation','entity':'inscription','method':'changer'}");
			// meta.getHeader().add(workbtn);

			MetaColumn col = new MetaColumn("button", "paiementfrais", "Paiement des frais", false, "action", null);
			col.setValue("{'name':'keren_education_paie_limit','template':{'eleve':'object'}}");
			col.setRoles(new String[]{"Administrateur"});

			MetaColumn workbtn = new MetaColumn("button", "work2", "Certificat de Scolarité", false, "report", null);
			workbtn.setValue("{'model':'kereneducation','entity':'inscription','method':'pdf'}");
			workbtn.setStates(new String[] { "crée" });
		    workbtn.setRoles(new String[]{"Administrateur"});
			meta.getHeader().add(workbtn);

			workbtn = new MetaColumn("button", "work2", "Fiche Inscription", false, "report", null);
			workbtn.setValue("{'model':'kereneducation','entity':'inscription','method':'fiche'}");
			workbtn.setStates(new String[] { "crée" });
			  workbtn.setRoles(new String[]{"Administrateur"});
			meta.getHeader().add(workbtn);
			
			workbtn = new MetaColumn("button", "work3", "Badge Scolaire", false, "report", null);
			workbtn.setValue("{'model':'kereneducation','entity':'inscription','method':'badge'}");
			workbtn.setStates(new String[] { "crée" });
			  workbtn.setRoles(new String[]{"Administrateur"});
			meta.getHeader().add(workbtn);

			// workbtn = new MetaColumn("button", "work1", "Frais de Scolarité",
			// false, "action", null);
			workbtn = new MetaColumn("button", "work1", "Frais de Scolarité", false, "link", null);
			workbtn.setValue(
					// "{'name':'keren_education_paie_limit','template':{'eleve':'object','zMntverser':'object.zMntPaye','zMnt':'object.zMnt','zsolde':'object.zSolde'}}");
					"{'name':'keren_education_paie_limit','template':{'eleve':'object','zMntverser':'object.zMntPaye','zMnt':'object.zMnt','zsolde':'object.zSolde'},'header':['eleve']}");
			workbtn.setStates(new String[] { "etabli" });
			workbtn.setRoles(new String[]{"Administrateur"});
			// workbtn.setPattern("btn btn-primary");
			meta.getHeader().add(workbtn);

			workbtn = new MetaColumn("button", "work1", "Frais Divers", false, "link", null);
			workbtn.setValue("{'name':'keren_education_frais_opt','template':{'eleve':'object'},'header':['eleve']}");
			workbtn.setStates(new String[] { "etabli" });
			  workbtn.setRoles(new String[]{"Administrateur"});
			// workbtn.setPattern("btn btn-primary");
			meta.getHeader().add(workbtn);

			col = new MetaColumn("button", "changer", "Changer de classe", false, "link", null);
			col.setValue(
					"{'name':'keren_education_ins_chgr','template':{'classe':'object.classe','eleve':'object.eleve','section':'object.classe.section','idIns':'object.id'},'header':['eleve']}");
			col.setRoles(new String[]{"Administrateur"});
			// meta.getHeader().add(col);
			return meta;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new WebApplicationException(
					Response.serverError().entity(new String("MetaData parse error")).build());
		}
	}

	@Override
	public List<Inscription> getEtudiantsInscrits(@Context HttpHeaders headers) {
		// TODO Auto-generated method stub
		return findAll(headers);
	}

	@Override
	protected void processBeforeUpdate(Inscription entity) {
		
		Inscription oldinscription = manager.find("id", entity.getId());
		if (entity.getService() == null && entity.getService().size() == 0) {
			throw new KerenExecption("Modification impossible, car l'élève n'a aucun service renseigné");
		}
		if (entity.getEleve() == null) {
			throw new KerenExecption("Modification impossible, car l'élève n'est pas renseigné");
		}
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("eleve.id", entity.getId());
		container.addNotEq("state", "annulé");
		List<Paiement> listPaiements = managerPaiement.filter(container.getPredicats(), null, null, 0, -1);
	//	System.out.println("InscriptionRSImpl.processBeforeUpdate() size list" + listPaiements.size());
	//	System.out.println("InscriptionRSImpl.processBeforeUpdate()valuer "+samefiliere(oldinscription, entity));
		if(samefiliere(oldinscription, entity)==true){
			entity.setService(oldinscription.getService());
		}
		if (listPaiements != null && listPaiements.size() != 0&&samefiliere(oldinscription, entity)==false) {
			throw new KerenExecption("Modification impossible, Bien vouloir Annuler les paiements de l'eleve !!!!");
		}

		super.processBeforeUpdate(entity); // To change body of generated
											// methods, choose Tools |
											// Templates.
	}
	
	public boolean samefiliere(Inscription old, Inscription nouveau){
		boolean value = false;
		if(old.getClasse().getFiliere().getId()==nouveau.getClasse().getFiliere().getId()){
			value=true;
		}else{
			value = false;
		}
		return value ;
	}

	@Override
	public Inscription changer(HttpHeaders headers, Inscription entity) {
		try {
			if (entity.getState().equalsIgnoreCase("crée")) {
				throw new KerenExecption("Modification impossible, car l'element a deja ete annulé");
			}
			// manager.update(entity.getId(), entity);

			return entity;
		} catch (KerenEduManagerException ex) {
			throw new KerenExecption(ex.getMessage());
		}
	}

	@Override
	protected void processBeforeSave(Inscription entity) {
		if (entity.getService() == null && entity.getService().size() == 0) {
			throw new KerenExecption("Enregistrement impossible, car l'eleve n'a aucun service renseigne");
		}

		if (entity.getEleve() == null) {
			throw new KerenExecption("Enregistrement impossible, car l'eleve n'est pas renseigne");
		}
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("connected", true);
		List<AnneScolaire> annee = managerAnnee.filter(container.getPredicats(), null, null, 0, -1);
		if (annee == null || annee.size() == 0) {
			throw new KerenExecption("Traitement impossible<br/> Aucune Année Scolaire disponible !!!");
		}
	//	entity.setAnneScolaire(CacheMemory.getCurrentannee());
		entity.setAnneScolaire(annee.get(0).getCode());
		// verifier si l'étudiant a déjà été inscit
		container = RestrictionsContainer.newInstance();
		container.addEq("eleve.matricule", entity.getEleve().getMatricule());
		container.addEq("anneScolaire", entity.getAnneScolaire());
		List<Inscription> inscit = manager.filter(container.getPredicats(), null, null, 0, -1);
		if ((inscit != null && inscit.size() != 0)) {
			throw new KerenExecption("Traitement impossible<br/> ELEVE DEJA INSCRIT !!!");
		}
		// for(FichePaiement ficheobligatoire:entity.getService()){
		// ficheobligatoire.setId(-1);
		// }//end for(FichePaiement ficheobligatoire:entity.getService()){
		//
		super.processBeforeSave(entity);
	}

	@Override
	public List<FichePaiement> findmatierclasse(HttpHeaders headers) {
		Gson gson = new Gson();
		long id = gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);

		return managerService.findmatierclasse(id);
	}

	/**
	 * Methode permettant de retourner les parametres pour le reporting
	 *
	 * @return java.util.Map
	 */
	public Map getReportParameters() {
		Map param = ReportHelperTrt.getReportParameters();

		return param;
	}

	@Override
	public Response ficheInscriptionReport(Inscription entity) {
		try {
			String URL = ReportHelper.templateURL + ReportsName.FICHE_INSCRIPTION.getName();
			List<Inscription> records = new ArrayList<Inscription>();
			records.add(entity);
			if (records.isEmpty() || records.size() == 0) {
				throw new KerenExecption("Traitement impossible<br/>Bien vouloir Selectionner un eleve !");
			}
			Map parameters = this.getReportParameters();
				if (entity.getEleve().getImage() != null) {
					entity.setPhoto(ReportHelper.getPhotoBytesEleve(entity.getEleve().getImage()));
				}
			
			// parameters = this.getReportParameters();
			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Response.noContent().build();
	}

	@Override
	public Response buildPdfReport(Inscription entity) {
		try {
			String URL = ReportHelper.templateURL + ReportsName.CERTIFICAT_SCOLAIRE.getName();
			List<Inscription> records = new ArrayList<Inscription>();
			records.add(entity);
			if (records.isEmpty() || records.size() == 0) {
				throw new KerenExecption("Traitement impossible<br/>Bien vouloir Selectionné un eleve !!!");
			}
			Map parameters = this.getReportParameters();
			try {
				if (entity.getClasse().getFiliere().getCycle().getTypecycle().equals("2")) {
					parameters.put(ReportsParameter.REPORT_IMAGE_REPOSITORY, ReportHelper.getBytesC());
				} else {
					parameters.put(ReportsParameter.REPORT_IMAGE_REPOSITORY, ReportHelper.getBytes());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	public Inscription delete(@Context HttpHeaders headers, Long id) {

		// TODO Auto-generated method stub
		Inscription entity = manager.find("id", id);

		try {

			// on supprimme l'objet
			super.delete(headers, id);

		} catch (Exception ex) {
			throw new KerenExecption(
					"Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
		}

		return entity;
	}

	@Override
	public Response listInscritRepoort(Inscription entity) {
		try {
			System.out.println("InscriptionRSImpl.listInscritRepoort() je suis ici");
			String URL = ReportHelper.templateURL + ReportsName.LISTE_INSCRIT.getName();
			entity.setAnneScolaire(CacheMemory.getCurrentannee());
			List<Inscription> records = manager.getCriteres(entity);

			if (records.isEmpty() || records.size() == 0) {
				throw new KerenExecption("Traitement impossible<br/>Bien vouloir Selectionné un eleve !!!");
			}
			Map parameters = this.getReportParameters();
			// parameters = this.getReportParameters();
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
	public Response badgeReport(Inscription entity) {
		try {
			String URL = ReportHelper.templateURL + ReportsName.BADGE.getName();
			//entity.setAnneScolaire(CacheMemory.getCurrentannee());
			List<Inscription> records = new ArrayList<Inscription>();

			if (entity.getEleve().getImage() != null) {
				entity.setPhoto(ReportHelper.getPhotoBytesEleve(entity.getEleve().getImage()));
			}
			records.add(entity);
			if (records.isEmpty() || records.size() == 0) {
				throw new KerenExecption("Traitement impossible<br/>Bien vouloir Selectionné un eleve !!!");
			}
			Map parameters = this.getReportParameters();

			// parameters = this.getReportParameters();
			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		

	}

		return Response.noContent().build();
	}

	@Override
	public Inscription find(HttpHeaders headers, String propertyName, Long id) {
		Inscription result = super.find(headers, propertyName, id);
		Gson gson = new Gson();
		long iduser = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
		CacheMemory.insert(iduser, TypeCacheMemory.INSCRIPTION, result.getId());
		return result;
	}

	@Override
	public Response buildPdfReportbi(Inscription entity) {
		// TODO Auto-generated method stub
		return this.buildPdfReport(entity);
	}

	@Override
	public Response ficheInscriptionReportbi(Inscription entity) {
		// TODO Auto-generated method stub
		return this.ficheInscriptionReport(entity);
	}

	@Override
	public Response listInscritRepoortbi(Inscription entity) {
		// TODO Auto-generated method stub
		return this.listInscritRepoort(entity);
	}

	@Override
	public Response badgeReportbi(Inscription entity) {
		// TODO Auto-generated method stub
		return this.badgeReport(entity);
	}
	
    @Override
    public RSNumber count(HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
         //To change body of generated methods, choose Tools | Templates.
        Gson gson = new Gson();
        Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
 //       UtilisateurConnect user = usermanager.getUserByAcompte(userid);
        //Type predType = ;
        List contraints = new ArrayList();
        if(headers.getRequestHeader("predicats")!=null&&!headers.getRequestHeader("predicats").isEmpty()){
            contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
        } //end if(headers.getRequestHeader("predicats")!=null){     
        String searchText = null;

        String liveSearch = null;
        if(headers.getRequestHeader("search_text")!=null && !headers.getRequestHeader("search_text").isEmpty()){
            searchText = gson.fromJson(headers.getRequestHeader("search_text").get(0),String.class);
        } //end if(headers.getRequestHeader("predicats")!=null){     
        if(headers.getRequestHeader("live_search")!=null && !headers.getRequestHeader("live_search").isEmpty()){
            liveSearch = gson.fromJson(headers.getRequestHeader("live_search").get(0),String.class);
        } //end if(headers.getRequestHeader("predicats")!=null){     

//        System.out.println(AbstractGenericService.class.toString()+" === "+headers.getRequestHeader("predicats")+" === "+firstResult+" === "+maxResult+" == "+contraints);   
        RestrictionsContainer container = RestrictionsContainer.newInstance();  
        if(contraints!=null&&!contraints.isEmpty()){
            for(Object obj : contraints){
                FilterPredicat filter = (FilterPredicat) obj ;
                if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
                        &&filter.getValue()!=null&&!filter.getValue().isEmpty()){
                        container = addPredicate(container,filter);
                }//end if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
            }//end  for(Object obj : contraints)
        }//end if(contraints!=null&&!contraints.isEmpty())

        if(liveSearch!=null&&!liveSearch.trim().isEmpty()){
            container.addLike("searchkeys", liveSearch);
        }else if(searchText!=null&&!searchText.trim().isEmpty()){
            container.addLike("searchkeys", "%"+searchText);
        }//end if(searchText!=null&&!searchText.trim().isEmpty()){        
      
        RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }
    
    
    
    @Override
    public List<Inscription> filter(HttpHeaders headers, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
         Gson gson = new Gson();
        Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
   //     UtilisateurConnect user = usermanager.getUserByAcompte(userid);
        //Type predType = ;
        //Type predType = ;
        List contraints = new ArrayList();
        if(headers.getRequestHeader("predicats")!=null){
            contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
        }//end if(headers.getRequestHeader("predicats")!=null){        
         String searchText = null;

        String liveSearch = null;
        if(headers.getRequestHeader("search_text")!=null && !headers.getRequestHeader("search_text").isEmpty()){
            searchText = gson.fromJson(headers.getRequestHeader("search_text").get(0),String.class);
        } //end if(headers.getRequestHeader("predicats")!=null){     
        if(headers.getRequestHeader("live_search")!=null && !headers.getRequestHeader("live_search").isEmpty()){
            liveSearch = gson.fromJson(headers.getRequestHeader("live_search").get(0),String.class);
        } //end if(headers.getRequestHeader("predicats")!=null){     
        RestrictionsContainer container = RestrictionsContainer.newInstance();  
         if(contraints!=null&&!contraints.isEmpty()){
            for(Object obj : contraints){
                FilterPredicat filter = (FilterPredicat) obj ;
                if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
                        &&filter.getValue()!=null&&!filter.getValue().isEmpty()){
                      container = addPredicate(container, filter);
                }//end if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
            }//end  for(Object obj : contraints)
        }//end if(contraints!=null&&!contraints.isEmpty())
         if(liveSearch!=null&&!liveSearch.trim().isEmpty()){
            container.addLike("searchkeys", liveSearch);
        }else if(searchText!=null&&!searchText.trim().isEmpty()){
            container.addLike("searchkeys", "%"+searchText);
        }//end if(searchText!=null&&!searchText.trim().isEmpty()){        
        return getManager().filter(container.getPredicats(), null , new HashSet<String>(), firstResult, maxResult);
    }

	//
	// @Override
	// public List<Inscription> filter(HttpHeaders headers, int firstResult, int
	// maxResult) {
	// System.out.println("InscriptionRSImpl.filter() je suis ici ::::");
	// String header = null;
	// RestrictionsContainer container = null;
	// if (headers.getRequestHeader("action_param") != null) {
	// header = headers.getRequestHeader("action_param").get(0);
	// }
	// System.out.println(InscriptionRSImpl.class.toString()+"
	// ==================================== "+header);
	// List<Inscription> datas = new ArrayList<Inscription>();
	// List<Inscription> results = new ArrayList<Inscription>();
	// // To change body of generated methods, choose Tools | Templates.
	// container = RestrictionsContainer.newInstance();
	// if(header!=null){
	// container.addLike("eleve.nom", "%" + header);
	// }
	// datas = manager.filter(container.getPredicats(), null, null, firstResult,
	// maxResult);
	// for (Inscription data : datas) {
	// results.add(new Inscription(data));
	// } // end for(CourrierTous data:datas){
	//
	// return results;
	// }
	
	

}
