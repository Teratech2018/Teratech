
package com.kerenedu.jaxrs.dashboard;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.xml.bind.JAXBException;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.core.dashboard.DashboardContainer;
import com.core.securites.Groupe;
import com.core.securites.GroupeDetail;
import com.core.securites.Utilisateur;
import com.core.securites.UtilisateurManagerRemote;
import com.core.views.DashboardRecord;
import com.core.views.DashboardRecordManagerRemote;
import com.google.gson.Gson;
import com.kerem.core.DashboardUtil;
import com.kerem.core.KerenExecption;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.AnneScolaireManagerRemote;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.dashboard.EducationDashboard;
import com.kerenedu.dashboard.Raccourci;
import com.kerenedu.dashboard.ViewDashboard;
import com.kerenedu.dashboard.ViewDashboardManagerRemote;
import com.megatimgroup.generic.jax.rs.layer.annot.AnnotationsProcessor;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;

/**
 * Classe d'implementation du Web Service JAX-RS
 * 
 * @since Tue Jan 09 20:37:12 WAT 2018
 * 
 */
@Path("/educationdashboard")
public class EducationDashboardRSImpl implements EducationDashboardRSLocal, EducationDashboardRSRemote {

	@Manager(application = "kerencore", name = "DashboardRecordManagerImpl", interf = DashboardRecordManagerRemote.class)
	protected DashboardRecordManagerRemote dashboardmanager;

	@Manager(application = "kereneducation", name = "ViewDashboardManagerImpl", interf = ViewDashboardManagerRemote.class)
	protected ViewDashboardManagerRemote manager;

	@Manager(application = "kereneducation", name = "AnneScolaireManagerImpl", interf = AnneScolaireManagerRemote.class)
	protected AnneScolaireManagerRemote managerAnne;
	
	 @Manager(application = "kerencore", name = "UtilisateurManagerImpl", interf = UtilisateurManagerRemote.class)
	    protected UtilisateurManagerRemote usermanager;

	public EducationDashboardRSImpl() {
		AnnotationsProcessor processor = new AnnotationsProcessor();
		try {
			processor.process(this);
		} catch (NamingException ex) {
			Logger.getLogger(AbstractGenericService.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalArgumentException ex) {
			Logger.getLogger(AbstractGenericService.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(AbstractGenericService.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public DashboardContainer dashboard(@Context HttpHeaders headers,Long templateID) {
		try {
			// To change body of generated methods, choose Tools | Templates.
			DashboardRecord dashboard = dashboardmanager.find("id", templateID);
			if(dashboard==null){
                return null;
            }
			// select l'anné encours
			RestrictionsContainer container = RestrictionsContainer.newInstance();
			container.addEq("connected", true);
			List<AnneScolaire> annee = managerAnne.filter(container.getPredicats(), null, null, 0, -1);
			if (annee == null || annee.size() == 0) {
				throw new KerenExecption("Aucune Année Scolaire disponible !!!");
			}
			// initi cache memory
			CacheMemory.init();
			AnneScolaire codeAnne = annee.get(0);
			CacheMemory.setCurrentannee(codeAnne.getCode());
			ViewDashboard view = new ViewDashboard();
			List<ViewDashboard> list = manager.getdashboarddata();
			if (list != null && list.size() != 0) {
				view = list.get(0);
			}
			
			EducationDashboard entity = new EducationDashboard(view);
			return DashboardUtil.dashboardBuilder(entity, dashboard);
		} catch (JAXBException ex) {
			Logger.getLogger(EducationDashboardRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalArgumentException ex) {
			Logger.getLogger(EducationDashboardRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(EducationDashboardRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	
	   @Override
	    public EducationDashboard liens(HttpHeaders headers) {
	        //To change body of generated methods, choose Tools | Templates.
	        Gson gson = new Gson();
	       Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
	        Utilisateur user = usermanager.find("id", userid);
	        if(user.getAutorisations()!=null){
	            user.getAutorisations().size();
	        }//end  if(user.getAutorisations()!=null){
	        RestrictionsContainer container = RestrictionsContainer.newInstance();
			container.addEq("connected", true);
			List<AnneScolaire> annee = managerAnne.filter(container.getPredicats(), null, null, 0, -1);
			if (annee == null || annee.size() == 0) {
				throw new KerenExecption("Aucune Année Scolaire disponible !!!");
			}
			// initi cache memory
			CacheMemory.init();
			AnneScolaire codeAnne = annee.get(0);
			CacheMemory.setCurrentannee(codeAnne.getCode());
			ViewDashboard view = new ViewDashboard();
			List<ViewDashboard> list = manager.getdashboarddata();
			if (list != null && list.size() != 0) {
				view = list.get(0);
			}
	        EducationDashboard entity = new EducationDashboard(view);
	        entity.setRaccourcis(getUserRaccourcis(user));
	        return entity;
	    }
	   
	   private List<Raccourci> getUserRaccourcis(Utilisateur user){
	       // user = acomptemanager.find("id", user.getId());
	        List<Raccourci> results = new ArrayList<Raccourci>();
	       // if(user.getIntitule().trim().equalsIgnoreCase("administrateur")){
	            results.add(new Raccourci("keren_education_Report_041", "Journal des  paiements ", "glyphicon glyphicon-star"));
	            results.add(new Raccourci("keren_education_Report_02", " Liste des inscrits ", "glyphicon glyphicon-list-alt"));
	            results.add(new Raccourci("keren_education_Report_05", " Bilan Finacier ", "glyphicon glyphicon-list-alt"));
//	        }else{
//	            Groupe group =null;
//	            for(Groupe groupe : user.getAutorisations()){
//	                if(groupe.getModule().getName().trim().equalsIgnoreCase("scolarite")){
//	                    group = groupe;
//	                    break;
//	                }//end if(groupe.getModule().getName().trim().equalsIgnoreCase("keren_courrier")){
//	            }//end for(Groupe groupe : user.getAutorisations()){
//	            if(group==null) return results;
//	            //Chargement des details
//	            for(GroupeDetail detail:group.getDroits()){
//	                if(!detail.getHabilitation().trim().equalsIgnoreCase("3")){
//	                    results.add(new Raccourci(detail.getMenuAction().getName(), detail.getMenuAction().getLabel(), detail.getMenuAction().getIcon()));
//	                }//end if(!detail.getHabilitation().trim().equalsIgnoreCase("3")){
//	            }//end for(GroupeDetail detail:group.getDroits()){
//	        }//end if(user.getIntitule().trim().equalsIgnoreCase("administrateur")){
	        return results;
	    }

}
