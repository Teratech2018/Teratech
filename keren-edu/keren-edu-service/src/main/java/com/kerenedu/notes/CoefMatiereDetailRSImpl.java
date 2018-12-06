
package com.kerenedu.notes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.app.BuilderHttpHeaders;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.AnneScolaireManagerRemote;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.TypeCacheMemory;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Feb 14 09:44:41 CET 2018
 * 
 */
@Path("/coefmatieredetail")
public class CoefMatiereDetailRSImpl
    extends AbstractGenericService<CoefMatiereDetail, Long>
    implements CoefMatiereDetailRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "CoefMatiereDetailManagerImpl", interf = CoefMatiereDetailManagerRemote.class)
    protected CoefMatiereDetailManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "AnneScolaireManagerImpl", interf = AnneScolaireManagerRemote.class)
    protected AnneScolaireManagerRemote managerexo;

    public CoefMatiereDetailRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CoefMatiereDetail, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
  	public MetaData getMetaData(HttpHeaders headers) {
  		// TODO Auto-generated method stub
  		try {
  			return MetaDataUtil.getMetaData(new CoefMatiereDetail(), new HashMap<String, MetaData>(),new ArrayList<String>());
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
	protected void processBeforeSave(CoefMatiereDetail entity) {
	entity.setHeuretotal((long) 0);
	entity.setCoutheure((long) 0);
	
	RestrictionsContainer container = RestrictionsContainer.newInstance();
	container.addEq("connected", true);
	List<AnneScolaire> annee = managerexo.filter(container.getPredicats(), null, null, 0, -1);
	if (annee == null || annee.size() == 0) {
		throw new KerenExecption("Traitement impossible<br/> Aucune Année Scolaire disponible !!!");
	}
//	entity.setAnneScolaire(CacheMemory.getCurrentannee());
	entity.setAnneScolaire(annee.get(0).getCode());
	
		super.processBeforeSave(entity);
	}
	
	@Override
	protected void processBeforeUpdate(CoefMatiereDetail entity) {
	entity.setHeuretotal((long) 0);
	entity.setCoutheure((long) 0);
	
	entity.setClasse(CacheMemory.getClasse());
	RestrictionsContainer container = RestrictionsContainer.newInstance();
	container.addEq("connected", true);
	List<AnneScolaire> annee = managerexo.filter(container.getPredicats(), null, null, 0, -1);
	if (annee == null || annee.size() == 0) {
		throw new KerenExecption("Traitement impossible<br/> Aucune Année Scolaire disponible !!!");
	}
//	entity.setAnneScolaire(CacheMemory.getCurrentannee());
	entity.setAnneScolaire(annee.get(0).getCode());
	
		super.processBeforeSave(entity);
	}
	
	@Override
	public List<CoefMatiereDetail> filter(HttpHeaders arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		RestrictionsContainer container = filterPredicatesBuilder(arg0,arg1,arg2);
		Classe classe = (Classe) CacheMemory.getValue(BuilderHttpHeaders.getidUsers(arg0), TypeCacheMemory.CLASSE);
		if(classe!=null){
   		 container.addEq("classe.id", classe.getId());
		}
		return getManager().filter(container.getPredicats(), null, new HashSet<String>(), arg1, arg2);
	}

	@Override
	public CoefMatiereDetail find(HttpHeaders headers, String propertyName, Long id) {
		CoefMatiereDetail elev = super.find(headers, propertyName, id);
   		CoefMatiereDetail data = new CoefMatiereDetail(elev);
   		Gson gson = new Gson();
		long idusers = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
   		CacheMemory.insert(idusers, TypeCacheMemory.CLASSE, elev.getClasse());
		return data;
	}
	
	

}
