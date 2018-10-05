
package com.keren.courrier.jaxrs.impl.dashbord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.core.dashboard.DashboardContainer;
import com.core.securites.Groupe;
import com.core.securites.GroupeDetail;
import com.core.views.DashboardRecord;
import com.core.views.DashboardRecordManagerRemote;
import com.google.gson.Gson;
import com.kerem.core.DashboardUtil;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.archivage.LiasseDocumentTriManagerRemote;
import com.keren.courrier.core.ifaces.dashbord.ArchiveDashboardManagerRemote;
import com.keren.courrier.core.ifaces.dashbord.CorbeilleManagerRemote;
import com.keren.courrier.core.ifaces.referentiel.UserManagerRemote;
import com.keren.courrier.core.ifaces.referentiel.UtilisateurCourrierManagerRemote;
import com.keren.courrier.jaxrs.ifaces.dashbord.ArchiveDashboardRS;
import com.keren.courrier.jaxrs.impl.archivage.ArchiveLiasseRSImpl;
import com.keren.courrier.model.dashbord.ArchiveDashboard;
import com.keren.courrier.model.dashbord.Corbeille;
import com.keren.courrier.model.dashbord.Raccourci;
import com.keren.courrier.model.dashbord.RegleCorbeille;
import com.keren.courrier.model.referentiel.User;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Mon Sep 03 12:16:16 WAT 2018
 * 
 */
@Path("/archivedashboard")
public class ArchiveDashboardRSImpl
    extends AbstractGenericService<ArchiveDashboard, Long>
    implements ArchiveDashboardRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "ArchiveDashboardManagerImpl", interf = ArchiveDashboardManagerRemote.class)
    protected ArchiveDashboardManagerRemote manager;
    
    @Manager(application = "kerencore", name = "DashboardRecordManagerImpl", interf = DashboardRecordManagerRemote.class)
    protected DashboardRecordManagerRemote dashboardmanager;
    
    @Manager(application = "kerencourrier", name = "CorbeilleManagerImpl", interf = CorbeilleManagerRemote.class)
    protected CorbeilleManagerRemote corbeillemanager;
     
    @Manager(application = "kerencourrier", name = "UtilisateurCourrierManagerImpl", interf = UtilisateurCourrierManagerRemote.class)
    protected UtilisateurCourrierManagerRemote usermanager;
    
    @Manager(application = "kerencourrier", name = "UserManagerImpl", interf = UserManagerRemote.class)
    protected UserManagerRemote acomptemanager;
    
    @Manager(application = "kerencourrier", name = "LiasseDocumentTriManagerImpl", interf = LiasseDocumentTriManagerRemote.class)
    protected LiasseDocumentTriManagerRemote liassemanager;

    public ArchiveDashboardRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ArchiveDashboard, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new ArchiveDashboard(), new HashMap<String, MetaData>(), new ArrayList<String>());
    
        } catch (InstantiationException ex) {
            Logger.getLogger(ArchiveLiasseRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ArchiveLiasseRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public DashboardContainer dashboard(@Context HttpHeaders headers ,Long templateID) {
         try {
            //To change body of generated methods, choose Tools | Templates.
            DashboardRecord dashboard = dashboardmanager.find("id", templateID);
            if(dashboard==null){
                return null;
            }
            ArchiveDashboard entity = new ArchiveDashboard();
//            entity.setCorbeilles(getUserCorbeilles(user));
            return DashboardUtil.dashboardBuilder(entity, dashboard);
        } catch (Exception ex) {
            Logger.getLogger(CourrierDashboardRSImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new KerenExecption(ex.getMessage());
        }
    }

    @Override
    public ArchiveDashboard corbeille(HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
        Gson gson = new Gson();
        Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
        UtilisateurCourrier user = usermanager.getUserByAcompte(userid);
        if(user.getCompte().getAutorisations()!=null){
            user.getCompte().getAutorisations().size();
        }//end  if(user.getAutorisations()!=null){
        ArchiveDashboard entity = new ArchiveDashboard();
        entity.setCorbeilles(getUserCorbeilles(user.getCompte()));
        entity.setRaccourcis(getUserRaccourcis(user.getCompte()));
        return entity;
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
        container.addEq("state", "transmis");
        long   qte =liassemanager.count(container.getPredicats());
        corbeille.setQuantite(Integer.valueOf(""+qte));
        return corbeille;
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    private List<Raccourci> getUserRaccourcis(User user){
        user = acomptemanager.find("id", user.getId());
        List<Raccourci> results = new ArrayList<Raccourci>();
        if(user.getIntitule().trim().equalsIgnoreCase("administrateur")){
            results.add(new Raccourci("archive_trans_011", "Liasse à décharger", "glyphicon glyphicon-envelope"));
            results.add(new Raccourci("archive_trans_02", "Archivages des Documents", "glyphicon glyphicon-envelope"));
            results.add(new Raccourci("archive_trans_03", "Archivages des Dossiers", "glyphicon glyphicon-envelope"));
            results.add(new Raccourci("archive_trans_04", "Archivage des Liasses ", "glyphicon glyphicon-envelope"));
        }else{
            Groupe group =null;
            for(Groupe groupe : user.getAutorisations()){
                if(groupe.getModule().getName().trim().equalsIgnoreCase("archivage")){
                    group = groupe;
                    break;
                }//end if(groupe.getModule().getName().trim().equalsIgnoreCase("keren_courrier")){
            }//end for(Groupe groupe : user.getAutorisations()){
            if(group==null) return results;
            //Chargement des details
            for(GroupeDetail detail:group.getDroits()){
                if(!detail.getHabilitation().trim().equalsIgnoreCase("3")){
                    results.add(new Raccourci(detail.getMenuAction().getName(), detail.getMenuAction().getLabel(), detail.getMenuAction().getIcon()));
                }//end if(!detail.getHabilitation().trim().equalsIgnoreCase("3")){
            }//end for(GroupeDetail detail:group.getDroits()){
        }//end if(user.getIntitule().trim().equalsIgnoreCase("administrateur")){
        return results;
    }


}
