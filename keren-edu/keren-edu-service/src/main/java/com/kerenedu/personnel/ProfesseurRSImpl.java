
package com.kerenedu.personnel;

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
import com.kerenedu.configuration.Etablissement;
import com.kerenedu.configuration.EtablissementManagerRemote;
import com.kerenedu.configuration.TypeCacheMemory;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.jaxrs.impl.report.ReportHelperTrt;
import com.kerenedu.jaxrs.impl.report.ViewBulletinRSImpl;
import com.kerenedu.solde.BulletinPaie;
import com.kerenedu.solde.DemandePret;
import com.kerenedu.solde.PeriodePaie;
import com.kerenedu.solde.RemboursementPret;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.kerenedu.tools.reports.ReportsParameter;
import com.megatim.common.annotations.Filter;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;

import net.sf.jasperreports.engine.JRException;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jan 30 12:13:16 CET 2018
 * 
 */
@Path("/professeur")
public class ProfesseurRSImpl
    extends AbstractGenericService<Professeur, Long>
    implements ProfesseurRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ProfesseurManagerImpl", interf = ProfesseurManagerRemote.class)
    protected ProfesseurManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "EtablissementManagerImpl", interf = EtablissementManagerRemote.class)
    protected EtablissementManagerRemote manageretbl;
    
    @Manager(application = "kereneducation", name = "AnneScolaireManagerImpl", interf = AnneScolaireManagerRemote.class)
    protected AnneScolaireManagerRemote manageranne;

    public ProfesseurRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Professeur, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
  	public MetaData getMetaData(HttpHeaders headers) {
  		// TODO Auto-generated method stub
  		try {
  			MetaData meta = MetaDataUtil.getMetaData(new Professeur(), new HashMap<String, MetaData>(),new ArrayList<String>());
		    MetaColumn workbtn = new MetaColumn("button", "work1", "Désactiver", false, "workflow", null);
            workbtn.setValue("{'model':'kereneducation','entity':'professeur','method':'desactiver','critical':true,'alert':'êtes vous sur de vouloir continuer ?'}");
            workbtn.setStates(new String[]{"etabli"});
            workbtn.setRoles(new String[]{"Administrateur"});
            workbtn.setPattern("btn btn-danger");
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work1", "Activer", false, "workflow", null);
            workbtn.setValue("{'model':'kereneducation','entity':'professeur','method':'activer','critical':true,'alert':'êtes vous sur de vouloir continuer ?'}");
            workbtn.setStates(new String[]{"desactiver"});
            workbtn.setRoles(new String[]{"Administrateur"});
            workbtn.setPattern("btn btn-success");
            meta.getHeader().add(workbtn);  
            workbtn = new MetaColumn("button", "work2", "Attestation de Travail", false, "report", null);
			workbtn.setValue("{'model':'kereneducation','entity':'professeur','method':'attestation'}");
			workbtn.setStates(new String[] { "crée" });
			workbtn.setRoles(new String[]{"Administrateur"});
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
	public Professeur delete(@Context HttpHeaders headers, Long id) {

		// TODO Auto-generated method stub
		Professeur entity = manager.find("id", id);

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
	public Professeur desactiver(HttpHeaders headers, Professeur entity) {
		// TODO Auto-generated method stub
		return manager.desactiver(entity);
	}

	@Override
	public Professeur activer(HttpHeaders headers, Professeur entity) {
		// TODO Auto-generated method stub
		return manager.activer(entity);
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
        container.addNotEq("state", "desactiver");	
      
        RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }
    
    
    
    @Override
    public List<Professeur> filter(HttpHeaders headers, int firstResult, int maxResult) {
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
         container.addNotEq("state", "desactiver");	

        return getManager().filter(container.getPredicats(), null , new HashSet<String>(), firstResult, maxResult);
    }
    
    @Override
    protected void processBeforeSave(Professeur entity) {

        // TODO Auto-generated method stub
        if(entity.getAllperiode()!=null&&entity.getAllperiode().equals("1")&&(entity.getPeriodepaie()==null||entity.getPeriodepaie().isEmpty())){
                throw new KerenExecption("OPERATIOn ERROR: Renseigner les periode de paiement de cet employe !!!!");
        }

    }
    
    @Override
    protected void processBeforeUpdate(Professeur entity) {

        // TODO Auto-generated method stub
        if(entity.getAllperiode()!=null&&entity.getAllperiode().equals("1")&&(entity.getPeriodepaie()==null||entity.getPeriodepaie().isEmpty())){
                throw new KerenExecption("OPERATIOn ERROR: Renseigner les periode de paiement de cet employe !!!!");
        }

    }
    /**
	 * Methode permettant de retourner les parametres pour le reporting
	 *
	 * @return java.util.Map
	 */
	public Map getReportParameters() {
		Map param = ReportHelperTrt.getReportParametersSolde();

		return param;
	}
	@Override
	public Response attestationReport(Professeur entity) {
		try {
			String URL = ReportHelper.templatepaieURL + ReportsName.ATESTATION_TRAVAIL.getName();
			List<Professeur> records = new ArrayList<Professeur>();
			records.add(entity);
			if (records.isEmpty() || records.size() == 0) {
				throw new KerenExecption("Traitement impossible<br/>Bien vouloir Selectionner un eleve !");
			}
			Map parameters = this.getReportParameters();
			Etablissement etbl = manageretbl.findAll().get(0);
			RestrictionsContainer container = RestrictionsContainer.newInstance();
			container.addEq("connected", true);
			AnneScolaire annee = manageranne.filter(container.getPredicats(), null, null, 0, -1).get(0);
			
			parameters.put(ReportsParameter.REPORT_ECOLE_CONTACT, etbl.getQuartier());
			parameters.put(ReportsParameter.REPORT_ECOLE, "GROUPE SCOALIRE BILINGUE LES SAUTERELLES /COLLEGE BILENGUE LA PIETE");
			parameters.put(ReportsParameter.ANNEE_SCOLAIRE,annee.getCode());
			parameters.put(ReportsParameter.REPORT_GERANT,etbl.getNomr());
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
	public Response attestationReportbi(Professeur entity) {
		// TODO Auto-generated method stub
		return attestationReport(entity);
	}
	
}
