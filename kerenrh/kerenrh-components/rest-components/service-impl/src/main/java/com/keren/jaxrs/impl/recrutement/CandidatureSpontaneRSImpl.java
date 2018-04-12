
package com.keren.jaxrs.impl.recrutement;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.recrutement.CandidatureSpontaneManagerRemote;
import com.keren.jaxrs.ifaces.recrutement.CandidatureSpontaneRS;
import com.keren.model.recrutement.CandidatureSpontane;
import com.keren.model.recrutement.Emploi;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Apr 11 11:31:28 GMT+01:00 2018
 * 
 */
@Path("/candidaturespontane")
public class CandidatureSpontaneRSImpl
    extends AbstractGenericService<CandidatureSpontane, Long>
    implements CandidatureSpontaneRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "CandidatureSpontaneManagerImpl", interf = CandidatureSpontaneManagerRemote.class)
    protected CandidatureSpontaneManagerRemote manager;

    public CandidatureSpontaneRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CandidatureSpontane, Long> getManager() {
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
   			meta = MetaDataUtil.getMetaData(new CandidatureSpontane(), new HashMap<String, MetaData>()
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

}
