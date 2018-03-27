
package com.keren.kerenpaie.jaxrs.impl.prets;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.prets.CategoriePretManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.prets.CategoriePretRS;
import com.keren.kerenpaie.model.prets.CategoriePret;
import com.keren.kerenpaie.model.prets.RemboursementPret;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Mar 13 13:15:47 GMT+01:00 2018
 * 
 */
@Path("/categoriepret")
public class CategoriePretRSImpl
    extends AbstractGenericService<CategoriePret, Long>
    implements CategoriePretRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "CategoriePretManagerImpl", interf = CategoriePretManagerRemote.class)
    protected CategoriePretManagerRemote manager;

    public CategoriePretRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CategoriePret, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			return MetaDataUtil.getMetaData(new CategoriePret(), new HashMap<String, MetaData>(),new ArrayList<String>());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
