
package com.kerenedu.personnel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.configuration.TypeCacheMemory;
import com.kerenedu.notes.CoefMatiere;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Nov 27 16:21:12 WAT 2018
 * 
 */
@Path("/professeurchoice")
public class ProfesseurChoiceRSImpl
    extends AbstractGenericService<ProfesseurChoice, Long>
    implements ProfesseurChoiceRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ProfesseurChoiceManagerImpl", interf = ProfesseurChoiceManagerRemote.class)
    protected ProfesseurChoiceManagerRemote manager;

    public ProfesseurChoiceRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ProfesseurChoice, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new ProfesseurChoice(), new HashMap<String, MetaData>()
   					, new ArrayList<String>());
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
    public List<ProfesseurChoice> filter(HttpHeaders headers, int firstResult, int maxResult) {
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
	
}
