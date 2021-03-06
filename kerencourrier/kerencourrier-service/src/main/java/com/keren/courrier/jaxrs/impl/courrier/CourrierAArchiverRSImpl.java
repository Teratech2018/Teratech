
package com.keren.courrier.jaxrs.impl.courrier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.courrier.CourrierAArchiverManagerRemote;
import com.keren.courrier.core.ifaces.referentiel.UtilisateurCourrierManagerRemote;
import com.keren.courrier.jaxrs.ifaces.courrier.CourrierAArchiverRS;
import com.keren.courrier.model.courrier.CourrierAArchiver;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Aug 23 14:35:51 WAT 2018
 * 
 */
@Path("/courrieraarchiver")
public class CourrierAArchiverRSImpl
    extends AbstractGenericService<CourrierAArchiver, Long>
    implements CourrierAArchiverRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "CourrierAArchiverManagerImpl", interf = CourrierAArchiverManagerRemote.class)
    protected CourrierAArchiverManagerRemote manager;
    
    @Manager(application = "kerencourrier", name = "UtilisateurCourrierManagerImpl", interf = UtilisateurCourrierManagerRemote.class)
    protected UtilisateurCourrierManagerRemote usermanager;

    public CourrierAArchiverRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CourrierAArchiver, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }
    

    @Override
  public MetaData getMetaData(HttpHeaders headers) {
      MetaData meta = null;
      try {
          meta = MetaDataUtil.getMetaData(new CourrierAArchiver(), new HashMap<String, MetaData>(), new ArrayList<String>());
  
      } catch (InstantiationException ex) {
          Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
          Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
      }
      return meta; //To change body of generated methods, choose Tools | Templates.
  }
  
    
  @Override
  public RSNumber count(HttpHeaders headers) {
      //To change body of generated methods, choose Tools | Templates.
       //To change body of generated methods, choose Tools | Templates.
      Gson gson = new Gson();
      Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
      UtilisateurCourrier user = usermanager.getUserByAcompte(userid);
      //Type predType = ;
      List contraints = new ArrayList();
      if(headers.getRequestHeader("predicats")!=null){
          contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
      }//end if(headers.getRequestHeader("predicats")!=null){        
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
       container.addEq("state", "archivage partiel");
      RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//      System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
      return number;
  }
  
  
  
  @Override
  public List<CourrierAArchiver> filter(HttpHeaders headers, int firstResult, int maxResult) {
      //To change body of generated methods, choose Tools | Templates.
       Gson gson = new Gson();
      Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
      UtilisateurCourrier user = usermanager.getUserByAcompte(userid);
      //Type predType = ;
      List contraints = new ArrayList();
      if(headers.getRequestHeader("predicats")!=null){
          contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
      } //end if(headers.getRequestHeader("predicats")!=null){       
//      System.out.println(AbstractGenericService.class.toString()+" === "+headers.getRequestHeader("predicats")+" === "+firstResult+" === "+maxResult+" == "+contraints);   
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
      container.addEq("state", "archivage partiel");
      //List result = new ArrayList();
      return getManager().filter(container.getPredicats(), null , new HashSet<String>(), firstResult, maxResult);
  }

}
