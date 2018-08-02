
package com.keren.courrier.jaxrs.impl.dashbord;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.core.dashboard.DashboardContainer;
import com.core.securites.Groupe;
import com.core.securites.GroupeDetail;
import com.core.securites.UtilisateurManagerRemote;
import com.core.views.DashboardRecord;
import com.core.views.DashboardRecordManagerRemote;
import com.google.gson.Gson;
import com.kerem.core.DashboardUtil;
import com.kerem.core.KerenExecption;
import com.keren.courrier.core.ifaces.courrier.CourrierManagerRemote;
import com.keren.courrier.core.ifaces.courrier.CourrierRecuManagerRemote;
import com.keren.courrier.core.ifaces.dashbord.CorbeilleManagerRemote;
import com.keren.courrier.core.ifaces.dashbord.CourrierDashboardManagerRemote;
import com.keren.courrier.core.ifaces.referentiel.UserManagerRemote;
import com.keren.courrier.core.ifaces.referentiel.UtilisateurCourrierManagerRemote;
import com.keren.courrier.jaxrs.ifaces.dashbord.CourrierDashboardRS;
import com.keren.courrier.model.dashbord.Corbeille;
import com.keren.courrier.model.dashbord.CourrierDashboard;
import com.keren.courrier.model.dashbord.Raccourci;
import com.keren.courrier.model.dashbord.RegleCorbeille;
import com.keren.courrier.model.referentiel.User;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Jul 19 13:57:24 GMT+01:00 2018
 * 
 */
@Path("/courrierdashboard")
public class CourrierDashboardRSImpl
    extends AbstractGenericService<CourrierDashboard, Long>
    implements CourrierDashboardRS
{

    @Manager(application = "kerencore", name = "DashboardRecordManagerImpl", interf = DashboardRecordManagerRemote.class)
    protected DashboardRecordManagerRemote dashboardmanager;
    
    @Manager(application = "kerencourrier", name = "CorbeilleManagerImpl", interf = CorbeilleManagerRemote.class)
    protected CorbeilleManagerRemote corbeillemanager;
     
    @Manager(application = "kerencourrier", name = "UtilisateurCourrierManagerImpl", interf = UtilisateurCourrierManagerRemote.class)
    protected UtilisateurCourrierManagerRemote usermanager;
    
    @Manager(application = "kerencourrier", name = "CourrierRecuManagerImpl", interf = CourrierRecuManagerRemote.class)
    protected CourrierRecuManagerRemote courriermanager;
    
    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "CourrierDashboardManagerImpl", interf = CourrierDashboardManagerRemote.class)
    protected CourrierDashboardManagerRemote manager;
    

    public CourrierDashboardRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CourrierDashboard, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }

    @Override
    public DashboardContainer dashboard(@Context HttpHeaders headers ,Long templateID) {
         try {
            //To change body of generated methods, choose Tools | Templates.
            DashboardRecord dashboard = dashboardmanager.find("id", templateID);
            if(dashboard==null){
                return null;
            }
            CourrierDashboard entity = new CourrierDashboard();
//            entity.setCorbeilles(getUserCorbeilles(user));
            return DashboardUtil.dashboardBuilder(entity, dashboard);
        } catch (Exception ex) {
            Logger.getLogger(CourrierDashboardRSImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new KerenExecption(ex.getMessage());
        }
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    private List<Corbeille> getUserCorbeilles(User user){
        UtilisateurCourrier userc = usermanager.getUserByAcompte(user.getId());
        List<Corbeille> datas = new ArrayList<Corbeille>();
        List<Corbeille> results = new ArrayList<Corbeille>();
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("user", user);
        datas = corbeillemanager.filter(container.getPredicats(), null, null, 0, -1);
        for(Corbeille entry:datas){
            Corbeille cor = corbeillemanager.find("id", entry.getId());
            if(cor.getRules()!=null) cor.getRules().size();
            cor = initialiseCorbeille(cor,userc);
            results.add(cor);
        }//end for(Corbeille entry:datas){
//        System.out.println(CourrierDashboardRSImpl.class.toString()+" ============================================ "+results);
        return results;
    }
    
    /**
     * 
     * @param corbeille
     * @return 
     */
    private Corbeille initialiseCorbeille(Corbeille corbeille, UtilisateurCourrier user){
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        if(!corbeille.getRules().isEmpty()){
            for(RegleCorbeille rule:corbeille.getRules()){
                FilterPredicat filter = new FilterPredicat();
                filter.setFieldName(rule.getFieldName());
                filter.setFieldLabel(rule.getFieldLabel());
                filter.setTarget(rule.getTarget());
                filter.setType(rule.getType());
                filter.setValue(rule.getValue());
                container = addPredicate(container, filter);
            }//end for(RegleCorbeille rule:corbeille.getRules()){
        }//end if(!corbeille.getRules().isEmpty()){
        container.addEq("sowner", user.getService());
        container.addNotEq("state", "etabli");
        container.addNotEq("state", "transmis");
        container.addNotEq("state", "classer");
        long   qte =courriermanager.count(container.getPredicats());
        corbeille.setQuantite(Integer.valueOf(""+qte));
        return corbeille;
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    private List<Raccourci> getUserRaccourcis(User user){
        List<Raccourci> results = new ArrayList<Raccourci>();
        if(user.getIntitule().trim().equalsIgnoreCase("administrateur")){
            results.add(new Raccourci("courrier_001", "Courriers arrivés", "glyphicon glyphicon-envelope"));
            results.add(new Raccourci("courrier_002", "Courriers départs", "glyphicon glyphicon-envelope"));
            results.add(new Raccourci("courrier_003", "Courriers internes", "glyphicon glyphicon-envelope"));
            results.add(new Raccourci("courrier_ref_01", "Type Correspondant", "glyphicon glyphicon-envelope"));
            results.add(new Raccourci("courrier_ref_02", "Priorité", "glyphicon glyphicon-envelope"));
            results.add(new Raccourci("courrier_ref_03", "Types Dossiers", "glyphicon glyphicon-envelope"));
            results.add(new Raccourci("courrier_ref_04", "Dossiers", "glyphicon glyphicon-envelope"));
            results.add(new Raccourci("courrier_ref_06", "Type Courrier", "glyphicon glyphicon-envelope"));
            results.add(new Raccourci("courrier_ref_07", "Nature Courrier", "glyphicon glyphicon-envelope"));
            results.add(new Raccourci("courrier_ref_08", "Contacts", "glyphicon glyphicon-envelope"));
            results.add(new Raccourci("courrier_ref_09", "Statut", "glyphicon glyphicon-envelope"));
            results.add(new Raccourci("courrier_ref_10", "Services", "glyphicon glyphicon-envelope"));
            results.add(new Raccourci("courrier_ref_11", "Paramètrage des workflow", "glyphicon glyphicon-envelope"));
            results.add(new Raccourci("courrier_ref_12", "Actions courriers", "glyphicon glyphicon-envelope"));
            results.add(new Raccourci("courrier_ref_13", "Corbeilles", "glyphicon glyphicon-envelope"));
        }else{
            Groupe group =null;
            for(Groupe groupe : user.getAutorisations()){
                if(groupe.getModule().getName().trim().equalsIgnoreCase("courrier")){
                    group = groupe;
                    break;
                }//end if(groupe.getModule().getName().trim().equalsIgnoreCase("keren_courrier")){
            }//end for(Groupe groupe : user.getAutorisations()){
            //Chargement des details
            for(GroupeDetail detail:group.getDroits()){
                if(!detail.getHabilitation().trim().equalsIgnoreCase("3")){
                    results.add(new Raccourci(detail.getMenuAction().getName(), detail.getMenuAction().getLabel(), detail.getMenuAction().getIcon()));
                }//end if(!detail.getHabilitation().trim().equalsIgnoreCase("3")){
            }//end for(GroupeDetail detail:group.getDroits()){
        }//end if(user.getIntitule().trim().equalsIgnoreCase("administrateur")){
        return results;
    }

    @Override
    public CourrierDashboard corbeille(HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
        Gson gson = new Gson();
        Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
        UtilisateurCourrier user = usermanager.getUserByAcompte(userid);
        if(user.getCompte().getAutorisations()!=null){
            user.getCompte().getAutorisations().size();
        }//end  if(user.getAutorisations()!=null){
        CourrierDashboard entity = new CourrierDashboard();
        entity.setCorbeilles(getUserCorbeilles(user.getCompte()));
        entity.setRaccourcis(getUserRaccourcis(user.getCompte()));
        return entity;
    }

}
