
package com.teratech.achat.jaxrs.impl.operations;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;
import com.teratech.achat.core.ifaces.operations.DemandePrixManagerRemote;
import com.teratech.achat.core.ifaces.operations.ReponseFournisseurManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.ReponseFournisseurRS;
import com.teratech.achat.model.operations.DemandePrix;
import com.teratech.achat.model.operations.LigneReponseDP;
import com.teratech.achat.model.operations.ReponseFournisseur;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Sat Dec 22 14:01:07 WAT 2018
 * 
 */
@Path("/reponsefournisseur")
public class ReponseFournisseurRSImpl
    extends AbstractGenericService<ReponseFournisseur, Long>
    implements ReponseFournisseurRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "ReponseFournisseurManagerImpl", interf = ReponseFournisseurManagerRemote.class)
    protected ReponseFournisseurManagerRemote manager;
    
    @Manager(application = "teratechachat", name = "DemandePrixManagerImpl", interf = DemandePrixManagerRemote.class)
    protected DemandePrixManagerRemote dpmanager;

    public ReponseFournisseurRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ReponseFournisseur, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new ReponseFournisseur(), new HashMap<String, MetaData>(), new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work1", "Emettre un commande", false, "report", null);
            workbtn.setValue("{'name':'reponse_report01','model':'teratechachat','entity':'reponsefournisseur','method':'imprime',template:{'reponse':'object','fournisseur':'object.fournisseur'}}");
            workbtn.setStates(new String[]{"etabli"});
            meta.getHeader().add(workbtn);
        } catch (InstantiationException ex) {
            Logger.getLogger(ReponseFournisseurRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ReponseFournisseurRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ReponseFournisseur> filter(HttpHeaders headers, int firstResult, int maxResult) {
        Gson gson =new Gson();
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
            container.addLike("searchkeys", searchText);
        }//end if(searchText!=null&&!searchText.trim().isEmpty()){        
        Long _dpid = gson.fromJson(headers.getRequestHeader("demande").get(0), Long.class);
        container.addEq("demande.id", _dpid);
        //List result = new ArrayList();
        return getManager().filter(container.getPredicats(), null , new HashSet<String>(), firstResult, maxResult);
    }

    @Override
    public RSNumber count(HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
         Gson gson =new Gson();
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
            container.addLike("searchkeys", searchText);
        }//end if(searchText!=null&&!searchText.trim().isEmpty()){    
        Long _dpid = gson.fromJson(headers.getRequestHeader("demande").get(0), Long.class);
        container.addEq("demande.id", _dpid);
        RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }

    @Override
    protected void processAfterUpdate(ReponseFournisseur entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ Reference est obligatoire");
        }else if(entity.getDreponse()==null){
            throw new KerenExecption("Le champ Date est obligatoire");
        }else if(entity.getFournisseur()==null){
            throw new KerenExecption("Le champ Fournisseur est obligatoire");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Aucune Reponses n'est saisie");
        }
        super.processAfterUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(ReponseFournisseur entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ Reference est obligatoire");
        }else if(entity.getDreponse()==null){
            throw new KerenExecption("Le champ Date est obligatoire");
        }else if(entity.getFournisseur()==null){
            throw new KerenExecption("Le champ Fournisseur est obligatoire");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Aucune Reponses n'est saisie");
        }
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    public ReponseFournisseur save(HttpHeaders headers, ReponseFournisseur entity) {
        Gson gson =new Gson();
        Long _dpid = gson.fromJson(headers.getRequestHeader("demande").get(0), Long.class);
        DemandePrix demande = dpmanager.find("id", _dpid);
        if(demande.getState().equalsIgnoreCase("cloture")){
            throw new KerenExecption("Impossible de créer une reponse pour une demande \nclôturée");
        }//end if(demande.getState().equalsIgnoreCase("cloture")){
        entity.setDemande(demande);
        return super.save(headers, entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReponseFournisseur imprimer(HttpHeaders headers, ReponseFournisseur dmde) {
        //To change body of generated methods, choose Tools | Templates.
        for(LigneReponseDP ligne : dmde.getLignes()){
            double remise = (ligne.getRemise()!=null ? ligne.getRemise():0);
            ligne.setTotalht(ligne.getQuantite()*ligne.getPuht()*(1-remise/100));
        }
        return dmde;
    }
    
    

}
