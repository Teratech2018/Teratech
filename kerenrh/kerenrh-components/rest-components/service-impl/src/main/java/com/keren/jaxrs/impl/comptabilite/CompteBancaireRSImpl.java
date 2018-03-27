
package com.keren.jaxrs.impl.comptabilite;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.comptabilite.CompteBancaireManagerRemote;
import com.keren.jaxrs.ifaces.comptabilite.CompteBancaireRS;
import com.keren.model.comptabilite.CompteBancaire;
import com.keren.model.employes.Categorie;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Feb 14 12:53:10 GMT+01:00 2018
 * 
 */
@Path("/comptebancaire")
public class CompteBancaireRSImpl
    extends AbstractGenericService<CompteBancaire, Long>
    implements CompteBancaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "CompteBancaireManagerImpl", interf = CompteBancaireManagerRemote.class)
    protected CompteBancaireManagerRemote manager;

    public CompteBancaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CompteBancaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			return MetaDataUtil.getMetaData(new CompteBancaire(),new HashMap<String, MetaData>()
					, new ArrayList<String>());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new WebApplicationException(e);
		}
	}
    

}
