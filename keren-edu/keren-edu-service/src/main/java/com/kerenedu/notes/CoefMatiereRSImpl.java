
package com.kerenedu.notes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Cycle;
import com.kerenedu.configuration.CycleManagerRemote;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.configuration.TypeCacheMemory;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Feb 13 10:56:15 CET 2018
 * 
 */
@Path("/coefmatiere")
public class CoefMatiereRSImpl
    extends AbstractGenericService<CoefMatiere, Long>
    implements CoefMatiereRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "CoefMatiereManagerImpl", interf = CoefMatiereManagerRemote.class)
    protected CoefMatiereManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "CoefMatiereDetailManagerImpl", interf = CoefMatiereDetailManagerRemote.class)
    protected CoefMatiereDetailManagerRemote managercoefDlt;
    
    @Manager(application = "kereneducation", name = "CycleManagerImpl", interf = CycleManagerRemote.class)
    protected CycleManagerRemote managercycle;

    public CoefMatiereRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
	public GenericManager<CoefMatiere, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
  	public MetaData getMetaData(HttpHeaders headers) {
  		// TODO Auto-generated method stub
  		try {
  			return MetaDataUtil.getMetaData(new CoefMatiere(), new HashMap<String, MetaData>(),new ArrayList<String>());
  		} catch (InstantiationException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} catch (IllegalAccessException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		return null;
  	}
    

	private void todowork(CoefMatiere entity){
		
		if(entity.getClasse()==null){
			throw new KerenExecption("Bien vouloir choisir une classe <br/> !!!");
		}//end if (entity.getClasse()==null)
		
		 List<CoefMatiereDetail> result = new ArrayList<CoefMatiereDetail>();
		 List<CoefMatiereDetail> datas = new ArrayList<CoefMatiereDetail>();
		 RestrictionsContainer container = RestrictionsContainer.newInstance();
		 
		 container = RestrictionsContainer.newInstance();
		 container.addEq("classe.id",entity.getClasse().getId());
		 result = managercoefDlt.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
		 
		if(result==null||result.isEmpty()||result.size()==0){
			for(CoefMatiereDetail matDlt : entity.getMatdetailList()){
				CoefMatiereDetail newcoefdlt = new CoefMatiereDetail(matDlt);
				newcoefdlt.setClasse(entity.getClasse());
				newcoefdlt.setId(-1);
				managercoefDlt.save(newcoefdlt);
			}
		}else{
			for(CoefMatiereDetail matDlt : entity.getMatdetailList()){
				CoefMatiereDetail cfm = new CoefMatiereDetail(matDlt);
				cfm.setClasse(entity.getClasse());
				CoefMatiereDetail cfdlt = new CoefMatiereDetail();
				cfdlt=cfm;
				managercoefDlt.delete(cfm.getId());
				cfdlt.setId(-1);
				cfdlt.setClasse(entity.getClasse());
				managercoefDlt.save(cfdlt);
				
			}// fin if(result==null||result.isEmpty()||result.size()==0)
		}
	}
	@Override
	public List<CoefMatiereDetail> findmatierclasse(HttpHeaders headers) {
		Gson gson = new Gson();
		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		List<CoefMatiereDetail> datas =  manager.findMatiereFiliere(id);
		if(datas==null||datas.isEmpty()){
			throw new KerenExecption("Aucune Matiere pour cette classe");
		}else{
			return manager.findMatiereFiliere(id);
		}
		
		
	}
	
	
	
	  @Override
	    public CoefMatiere save(@Context HttpHeaders headers,CoefMatiere entity) {
		  this.todowork(entity);
		  
	        return entity; 
	    }

	@Override
	public List<CoefMatiereDetail> setid(HttpHeaders headers) {
		List<CoefMatiereDetail>  list = new ArrayList<CoefMatiereDetail>();
		Gson gson = new Gson();
		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		Cycle cycle = managercycle.find("id", id);
		long iduser = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
		CacheMemory.insert(iduser, TypeCacheMemory.CYCLE, cycle);
		//CacheMemory.setCurentcycle(id);
		return list;
	}

	
	@Override
	public CoefMatiere delete(@Context HttpHeaders headers, Long id) {

		// TODO Auto-generated method stub
		CoefMatiere entity = manager.find("id", id);

		try {

			// on supprimme l'objet
			super.delete(headers, id);

		} catch (Exception ex) {
			throw new KerenExecption(
					"Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
		}

		return entity;
	}

	@Override
	public List<CoefMatiere> filter(HttpHeaders arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		long id = gson.fromJson(arg0.getRequestHeader("userid").get(0), Long.class);
		RestrictionsContainer container = filterPredicatesBuilder(arg0,arg1,arg2);
		Filiere filiere = (Filiere) CacheMemory.getValue(id, TypeCacheMemory.FILLIERE);
		if(filiere!=null){
			container.addEq("classe.filiere.id", filiere.getId());	
		}//end if(filiere!=null){
		return getManager().filter(container.getPredicats(), null, new HashSet<String>(), arg1, arg2);
	}
	
	

}
