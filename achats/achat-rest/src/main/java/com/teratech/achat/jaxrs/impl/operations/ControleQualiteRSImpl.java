
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
import com.teratech.achat.core.ifaces.operations.BonReceptionManagerRemote;
import com.teratech.achat.core.ifaces.operations.ControleQualiteManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.ControleQualiteRS;
import com.teratech.achat.model.operations.BonReception;
import com.teratech.achat.model.operations.ControleQualite;
import com.teratech.achat.model.operations.LigneControleQualite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Sat Feb 24 14:57:22 WAT 2018
 * 
 */
@Path("/controlequalite")
public class ControleQualiteRSImpl
    extends AbstractGenericService<ControleQualite, Long>
    implements ControleQualiteRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "ControleQualiteManagerImpl", interf = ControleQualiteManagerRemote.class)
    protected ControleQualiteManagerRemote manager;
    
    @Manager(application = "teratechachat", name = "BonReceptionManagerImpl", interf = BonReceptionManagerRemote.class)
    protected BonReceptionManagerRemote bonmanager;
    
    

    public ControleQualiteRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ControleQualite, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new ControleQualite(), new HashMap<String, MetaData>(), new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work1", "Marquer comme traiter", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'controlequalite','method':'traiter',template:{'commande':'object'},'critical':true,alert:'Êtes vous sur de vouloir continuer ?'}");
            workbtn.setStates(new String[]{"etabli"});
            meta.getHeader().add(workbtn);
//            workbtn = new MetaColumn("button", "work1", "Envoyé le bon par e-mail", false, "workflow", null);
//            workbtn.setValue("{'model':'teratechachat','entity':'controlequalite','method':'valider',template:{'commande':'object'}}");
//            workbtn.setStates(new String[]{"etabli"});
//            meta.getHeader().add(workbtn);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControleQualiteRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControleQualiteRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ControleQualite> filter(HttpHeaders headers, int firstResult, int maxResult) {
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
         Long _dpid = null;
        if(headers.getRequestHeader("bonlivraison")!=null&&!headers.getRequestHeader("bonlivraison").isEmpty()){
             _dpid = gson.fromJson(headers.getRequestHeader("bonlivraison").get(0), Long.class);
              container.addEq("bonlivraison.id", _dpid);        
         }//end if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
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
        Long _dpid = null;
         if(headers.getRequestHeader("bonlivraison")!=null&&!headers.getRequestHeader("bonlivraison").isEmpty()){
             _dpid = gson.fromJson(headers.getRequestHeader("bonlivraison").get(0), Long.class);
              container.addEq("bonlivraison.id", _dpid);        
         }//end if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
         RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }

    @Override
    public ControleQualite find(HttpHeaders headers, String propertyName, Long id) {
        ControleQualite entity =  super.find(headers, propertyName, id); //To change body of generated methods, choose Tools | Templates.
        ControleQualite result = new ControleQualite(entity);
        for(LigneControleQualite ligne:entity.getLignes()){
            result.getLignes().add(new LigneControleQualite(ligne));
        }
        return result;
    }

    @Override
    public ControleQualite traiter(HttpHeaders headers, ControleQualite entity) {
        //To change body of generated methods, choose Tools | Templates.
        for(LigneControleQualite ligne:entity.getLignes()){
            if(ligne.getValeur()==null || ligne.getValeur().trim().isEmpty()){
                throw new KerenExecption("Veuillez saisir le resultat de l'analyse "+ligne.getIntitule());
            }//end if(ligne.getValeur()==null || ligne.getValeur().trim().isEmpty()){
        }//end for(LigneControleQualite ligne:entity.getLignes()){
        entity.setState("traite");
        entity = manager.update(entity.getId(), entity);
        //Verifier si tout le contrôles 
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("bonlivraison.id", entity.getBonlivraison().getId());
        List<ControleQualite> controles = manager.filter(container.getPredicats(), null, null, 0, -1);
        boolean traiter = true;
        for(ControleQualite controle:controles){
            traiter &=controle.getState().equalsIgnoreCase("traite");
        }//end for(ControleQualite controle:controles){
        if(traiter){//Tout les controles sont effectués
            BonReception reception = bonmanager.find("id", entity.getBonlivraison().getId());            
            reception.setState("transfere");
            bonmanager.update(reception.getId(), reception);
        }//end if(traiter){
        return entity;
    }

    
    
    
    
}
