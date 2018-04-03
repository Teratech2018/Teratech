
package com.keren.kerenpaie.jaxrs.impl.comptabilite;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.comptabilite.CompteAnalytiqueManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.comptabilite.CompteAnalytiqueRS;
import com.keren.kerenpaie.model.comptabilite.CompteAnalytique;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Mar 01 10:22:26 GMT+01:00 2018
 * 
 */
@Path("/compteanalytique")
public class CompteAnalytiqueRSImpl
    extends AbstractGenericService<CompteAnalytique, Long>
    implements CompteAnalytiqueRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "CompteAnalytiqueManagerImpl", interf = CompteAnalytiqueManagerRemote.class)
    protected CompteAnalytiqueManagerRemote manager;

    public CompteAnalytiqueRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CompteAnalytique, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			return MetaDataUtil.getMetaData(new CompteAnalytique(),new HashMap<String, MetaData>()
					, new ArrayList<String>());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new WebApplicationException(e);
		}
	}
    

}