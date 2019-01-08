
package com.teratech.achat.jaxrs.impl.base;

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
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;
import com.teratech.achat.core.ifaces.base.ArticleManagerRemote;
import com.teratech.achat.core.ifaces.base.LienEmplacementManagerRemote;
import com.teratech.achat.jaxrs.ifaces.base.LienEmplacementRS;
import com.teratech.achat.model.base.Article;
import com.teratech.achat.model.base.LienEmplacement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Dec 27 15:19:48 WAT 2018
 * 
 */
@Path("/lienemplacement")
public class LienEmplacementRSImpl
    extends AbstractGenericService<LienEmplacement, Long>
    implements LienEmplacementRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "LienEmplacementManagerImpl", interf = LienEmplacementManagerRemote.class)
    protected LienEmplacementManagerRemote manager;
    
     @Manager(application = "teratechachat", name = "ArticleManagerImpl", interf = ArticleManagerRemote.class)
    protected ArticleManagerRemote artmanager;

    public LienEmplacementRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LienEmplacement, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new LienEmplacement(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(LienEmplacementRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LienEmplacementRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }
    
    
     @Override
    public List<LienEmplacement> filter(HttpHeaders headers, int firstResult, int maxResult) {
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
        if(headers.getRequestHeader("article")!=null&&!headers.getRequestHeader("article").isEmpty()){
             _dpid = gson.fromJson(headers.getRequestHeader("article").get(0), Long.class);
              container.addEq("article.id", _dpid);        
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
         if(headers.getRequestHeader("article")!=null&&!headers.getRequestHeader("article").isEmpty()){
             _dpid = gson.fromJson(headers.getRequestHeader("article").get(0), Long.class);
              container.addEq("article.id", _dpid);        
         }//end if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
         RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }

    @Override
    public LienEmplacement save(HttpHeaders headers, LienEmplacement entity) {
        Gson gson =new Gson();
//        RestrictionsContainer container =  RestrictionsContainer.newInstance();
        Long _dpid = null;
        if(headers.getRequestHeader("article")!=null&&!headers.getRequestHeader("article").isEmpty()){
            _dpid = gson.fromJson(headers.getRequestHeader("article").get(0), Long.class);
            Article article = artmanager.find("id", _dpid);
            entity.setArticle(article);
        }//end if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
        return super.save(headers, entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    protected void processBeforeUpdate(LienEmplacement entity) {
        if(entity.getEntrpot()==null){
            throw new KerenExecption("Le champ Entrepôt est obligatoire");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Le champ Emplacement est obligatoire");
        }else if(entity.getStockalert()==null){
            throw new KerenExecption("Le champ Stock d'alerte est obligatoire");
        }
        entity.setStockmin(entity.getStockmin()==null ? 0.0 : entity.getStockmin());
        entity.setStockmax(entity.getStockmax()==null ? 0.0 : entity.getStockmax());
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(LienEmplacement entity) {
        if(entity.getEntrpot()==null){
            throw new KerenExecption("Le champ Entrepôt est obligatoire");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Le champ Emplacement est obligatoire");
        }else if(entity.getStockalert()==null){
            throw new KerenExecption("Le champ Stock d'alerte est obligatoire");
        }
        entity.setStockmin(entity.getStockmin()==null ? 0.0 : entity.getStockmin());
        entity.setStockmax(entity.getStockmax()==null ? 0.0 : entity.getStockmax());
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

   

}
