
package com.keren.jaxrs.impl.formations;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.formations.GenererBesionFormationManagerRemote;
import com.keren.jaxrs.ifaces.formations.GenererBesionFormationRS;
import com.keren.model.formations.BesionFormation;
import com.keren.model.formations.GenererBesionFormation;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import javax.ws.rs.core.Context;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Apr 11 15:59:28 GMT+01:00 2018
 * 
 */
@Path("/genererbesionformation")
public class GenererBesionFormationRSImpl
    extends AbstractGenericService<GenererBesionFormation, Long>
    implements GenererBesionFormationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "GenererBesionFormationManagerImpl", interf = GenererBesionFormationManagerRemote.class)
    protected GenererBesionFormationManagerRemote manager;

    public GenererBesionFormationRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<GenererBesionFormation, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		MetaData meta = null;
   		try {
   			meta = MetaDataUtil.getMetaData(new GenererBesionFormation(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());   			
   		} catch (InstantiationException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		} catch (IllegalAccessException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		return meta;
   	}

	@Override
	public GenererBesionFormation save(@Context HttpHeaders headers , GenererBesionFormation entity) {
		// TODO Auto-generated method stub
		return entity;
	}
    
    

}
