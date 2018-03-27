
package com.keren.jaxrs.impl.employes;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.employes.FamilleManagerRemote;
import com.keren.jaxrs.ifaces.employes.FamilleRS;
import com.keren.model.employes.Famille;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Feb 14 12:53:10 GMT+01:00 2018
 * 
 */
@Path("/famille")
public class FamilleRSImpl
    extends AbstractGenericService<Famille, Long>
    implements FamilleRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "FamilleManagerImpl", interf = FamilleManagerRemote.class)
    protected FamilleManagerRemote manager;

    public FamilleRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Famille, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			return MetaDataUtil.getMetaData(new Famille(), new HashMap<String, MetaData>(), new ArrayList<String>());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 throw new WebApplicationException(e);
		} 
	}
    
    

}
