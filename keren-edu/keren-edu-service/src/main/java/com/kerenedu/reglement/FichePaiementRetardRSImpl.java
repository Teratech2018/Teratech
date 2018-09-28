
package com.kerenedu.reglement;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.core.tools.DateHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.inscription.Inscription;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Sep 04 10:23:04 WAT 2018
 * 
 */
@Path("/fichepaiementretard")
public class FichePaiementRetardRSImpl
    extends AbstractGenericService<FichePaiementRetard, Long>
    implements FichePaiementRetardRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "FichePaiementRetardManagerImpl", interf = FichePaiementRetardManagerRemote.class)
    protected FichePaiementRetardManagerRemote manager;

    public FichePaiementRetardRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<FichePaiementRetard, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			MetaData meta = MetaDataUtil.getMetaData(new FichePaiementRetard(), new HashMap<String, MetaData>(),
					new ArrayList<String>());
	
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Moratoire", false, "link", null);
			workbtn.setValue("{'name':'keren_education_fiche_01',template:{'eleve':'object.eleve','service':'object.fiche','delai':'object.delai'},'header':['eleve']}");
//					"{'name':'keren_education_paie_limit','template':{'eleve':'object','zMntverser':'object.zMntPaye','zMnt':'object.zMnt','zsolde':'object.zSolde'},'header':['eleve']}");
			workbtn.setStates(new String[] { "etabli" });
			// workbtn.setPattern("btn btn-primary");
			meta.getHeader().add(workbtn);
			return meta ;
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
       
         container.addLe("delai", DateHelper.formatDate(new Date()));
         container.addLe("payer",false);
        RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }
    
    
    
    @Override
    public List<FichePaiementRetard> filter(HttpHeaders headers, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
         Gson gson = new Gson();
      
        //Type predType = ;
        List contraints = new ArrayList();
        if(headers.getRequestHeader("predicats")!=null){
            contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
        } //end if(headers.getRequestHeader("predicats")!=null){       
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
        
        container.addLe("delai", DateHelper.formatDate(new Date()));
        container.addLe("payer",false);
        //List result = new ArrayList();
        return getManager().filter(container.getPredicats(), null , new HashSet<String>(), firstResult, maxResult);
    }


}
