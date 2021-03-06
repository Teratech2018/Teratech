
package com.kerenedu.solde;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.app.BuilderHttpHeaders;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.TypeCacheMemory;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Oct 11 14:48:37 WAT 2018
 * 
 */
@Path("/traitsalaire")
public class TraitSalaireRSImpl
    extends AbstractGenericService<TraitSalaire, Long>
    implements TraitSalaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "TraitSalaireManagerImpl", interf = TraitSalaireManagerRemote.class)
    protected TraitSalaireManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "BulletinPaieManagerImpl", interf = BulletinPaieManagerRemote.class)
    protected BulletinPaieManagerRemote managerbul;

    public TraitSalaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<TraitSalaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
  	public MetaData getMetaData(HttpHeaders headers) {
  		// TODO Auto-generated method stub
  		try {
  			return MetaDataUtil.getMetaData(new TraitSalaire(), new HashMap<String, MetaData>()
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
	public TraitSalaire save(@Context HttpHeaders headers , TraitSalaire entity) {
		// TODO Auto-generated method stub
		  processBeforeSave(entity);
		  // controle si préparation 
		  RestrictionsContainer container = RestrictionsContainer.newInstance();
		  container.addEq("periode.id", entity.getPeriode().getId());
		  List<BulletinPaie> datas = managerbul.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
		  if(datas==null||datas.isEmpty()||datas.size()==0){
			  throw new KerenExecption("OPERATION IMPOSSIBLE ::Bien vouloir effectu&eacute; la pr&eacute;paration de la paie de cette p&eacute;riode !!");
		  }
		 managerbul.validerSalaire(entity);
		CacheMemory.insert(BuilderHttpHeaders.getidUsers(headers), TypeCacheMemory.PERIODE, entity.getPeriode());
		processAfterSave(entity);
		return entity;
	}
    
}
