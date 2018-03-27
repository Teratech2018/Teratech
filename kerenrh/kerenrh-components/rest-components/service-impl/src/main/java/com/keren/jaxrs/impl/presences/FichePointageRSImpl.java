
package com.keren.jaxrs.impl.presences;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.presences.FichePointageManagerRemote;
import com.keren.jaxrs.ifaces.presences.FichePointageRS;
import com.keren.model.conges.InterruptionConge;
import com.keren.model.presences.FichePointage;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Feb 15 13:18:47 GMT+01:00 2018
 * 
 */
@Path("/fichepointage")
public class FichePointageRSImpl
    extends AbstractGenericService<FichePointage, Long>
    implements FichePointageRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "FichePointageManagerImpl", interf = FichePointageManagerRemote.class)
    protected FichePointageManagerRemote manager;

    public FichePointageRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<FichePointage, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			MetaData meta = MetaDataUtil.getMetaData(new FichePointage(),new HashMap<String, MetaData>()
					, new ArrayList<String>());			
			return meta;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new WebApplicationException(e);
		}

	}
    
    
}
