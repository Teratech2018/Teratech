
package com.kerenedu.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jan 09 15:21:44 WAT 2018
 * 
 */
@Path("/filiere")
public class FiliereRSImpl
    extends AbstractGenericService<Filiere, Long>
    implements FiliereRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "FiliereManagerImpl", interf = FiliereManagerRemote.class)
    protected FiliereManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "UtilisateurConnectManagerImpl", interf = UtilisateurConnectManagerRemote.class)
    protected UtilisateurConnectManagerRemote usermanager;
    
    @Manager(application = "kereneducation", name = "SectionEManagerImpl", interf = SectionEManagerRemote.class)
    protected SectionEManagerRemote sectionmanager;
    
    @Manager(application = "kereneducation", name = "CycleManagerImpl", interf = CycleManagerRemote.class)
    protected CycleManagerRemote cyclemanager;

    public FiliereRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Filiere, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new Filiere(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}
    
    @Override
    public RSNumber count(HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
         //To change body of generated methods, choose Tools | Templates.
        Gson gson = new Gson();
        Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
        UtilisateurConnect user =  usermanager.getUserByAcompte(userid);
        
        if(user==null){
        	return null;
        }
        UtilisateurConnect utilisateur = usermanager.find("id", user.getId()) ;
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
//        List<Predicat> value = this.getlisteCriteria(utilisateur);
//        container.getPredicats().addAll(value);
        RSNumber number;
        long numberall = 0;
        if(utilisateur.getAllResponsabilite()==false){
        	for(Responsabilite resp: utilisateur.getResponsable()){
            	container = RestrictionsContainer.newInstance();
            	container.addEq("cycle.id", resp.getCycle().getId());
            	container.addEq("section.id", resp.getSection().getId());
            	
            	numberall += getManager().count(container.getPredicats());
            	
            }
        }else{
        	container = RestrictionsContainer.newInstance();
        	numberall = getManager().count(container.getPredicats());
        }
        

      //   number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return new RSNumber(numberall);
    }
    
    
    
    @Override
    public List<Filiere> filter(HttpHeaders headers, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
         Gson gson = new Gson();
        Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
        UtilisateurConnect user = usermanager.getUserByAcompte(userid);
        if(user==null){
        	return null;
        }
        UtilisateurConnect utilisateur = usermanager.find("id", user.getId()) ;
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
         container = RestrictionsContainer.newInstance();
         List<Filiere>  datas = new ArrayList<Filiere>();
         List<Filiere> results = new ArrayList<Filiere>();
         if(utilisateur.getAllResponsabilite()==false){
        	 for(Responsabilite resp: utilisateur.getResponsable()){
            	 container = RestrictionsContainer.newInstance();
    	        	container.addEq("cycle.id", resp.getCycle().getId());
    	        	container.addEq("section.id", resp.getSection().getId());
    	        	
    	        	
    	        	datas =getManager().filter(container.getPredicats(), null , new HashSet<String>(), firstResult, maxResult);
    	        	results.addAll(datas);
    	        }
         }else{
        	 container = RestrictionsContainer.newInstance();
        	 datas =getManager().filter(container.getPredicats(), null , new HashSet<String>(), firstResult, maxResult);
	        	results.addAll(datas);
         }
         

        //List result = new ArrayList();
        return results;
    }

}
