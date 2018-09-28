
package com.kerenedu.inscription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.model.report.ViewPaiementJournalier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Aug 08 06:03:36 WAT 2018
 * 
 */
@Path("/inscriptionclone")
public class InscriptioncloneRSImpl
    extends AbstractGenericService<Inscriptionclone, Long>
    implements InscriptioncloneRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "InscriptioncloneManagerImpl", interf = InscriptioncloneManagerRemote.class)
    protected InscriptioncloneManagerRemote manager;

    public InscriptioncloneRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Inscriptionclone, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new Inscriptionclone(), new HashMap<String, MetaData>(),new ArrayList<String>());
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
        String header = null;
		RestrictionsContainer container = null;
		if (headers.getRequestHeader("action_param") != null) {
			header = headers.getRequestHeader("action_param").get(0);
		}
        //Type predType = ;
        List contraints = new ArrayList();
        if(headers.getRequestHeader("predicats")!=null){
            contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
        }//end if(headers.getRequestHeader("predicats")!=null){        
      
         if(contraints!=null&&!contraints.isEmpty()){
            for(Object obj : contraints){
                FilterPredicat filter = (FilterPredicat) obj ;
                if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
                        &&filter.getValue()!=null&&!filter.getValue().isEmpty()){
                      container = addPredicate(container, filter);
                }//end if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
            }//end  for(Object obj : contraints)
        }//end if(contraints!=null&&!contraints.isEmpty())
       
         if(header!=null){
 			container.addLike("eleve.nom", "%" + header);
 			 }
        RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }
    
	@Override
	public List<Inscriptionclone> filter(HttpHeaders headers, int firstResult, int maxResult) {

		String header = null;
		RestrictionsContainer container = null;
		if (headers.getRequestHeader("action_param") != null) {
			header = headers.getRequestHeader("action_param").get(0);
		}
		 System.out.println(InscriptionRSImpl.class.toString()+" ==================================== "+header);
		List<Inscriptionclone> datas = new ArrayList<Inscriptionclone>();
		List<Inscriptionclone> results = new ArrayList<Inscriptionclone>();
		// To change body of generated methods, choose Tools | Templates.
			 container = RestrictionsContainer.newInstance();
			 if(header!=null){
			container.addLike("eleve.nom", "%" + header);
			 }
			datas = manager.filter(container.getPredicats(), null, null, firstResult, maxResult);
			for (Inscriptionclone data : datas) {
				results.add(new Inscriptionclone(data));
			} // end for(CourrierTous data:datas){
		
		return results;
	}

}
