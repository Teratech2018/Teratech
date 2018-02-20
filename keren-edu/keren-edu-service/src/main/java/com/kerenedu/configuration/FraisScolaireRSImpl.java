
package com.kerenedu.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatim.common.annotations.OrderType;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Jan 18 21:27:12 WAT 2018
 * 
 */
@Path("/fraisscolaire")
public class FraisScolaireRSImpl
    extends AbstractGenericService<FraisScolaire, Long>
    implements FraisScolaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "FraisScolaireManagerImpl", interf = FraisScolaireManagerRemote.class)
    protected FraisScolaireManagerRemote manager;

    public FraisScolaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<FraisScolaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new FraisScolaire(), new HashMap<String, MetaData>(),new ArrayList<String>());
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
	public void deleteAll(HttpHeaders headers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FilterPredicat> uniqueProperties(HttpHeaders headers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FraisScolaire> filter(HttpHeaders headers, int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		return null;
	}



	

}
