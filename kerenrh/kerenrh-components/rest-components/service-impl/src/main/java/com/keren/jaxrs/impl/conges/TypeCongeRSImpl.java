
package com.keren.jaxrs.impl.conges;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.conges.TypeCongeManagerRemote;
import com.keren.jaxrs.ifaces.conges.TypeCongeRS;
import com.keren.model.comptabilite.Banque;
import com.keren.model.conges.TypeConge;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Feb 15 09:30:08 GMT+01:00 2018
 * 
 */
@Path("/typeconge")
public class TypeCongeRSImpl
    extends AbstractGenericService<TypeConge, Long>
    implements TypeCongeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "TypeCongeManagerImpl", interf = TypeCongeManagerRemote.class)
    protected TypeCongeManagerRemote manager;

    public TypeCongeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<TypeConge, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			return MetaDataUtil.getMetaData(new TypeConge(),new HashMap<String, MetaData>()
					, new ArrayList<String>());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new WebApplicationException(e);
		}
	}

}
