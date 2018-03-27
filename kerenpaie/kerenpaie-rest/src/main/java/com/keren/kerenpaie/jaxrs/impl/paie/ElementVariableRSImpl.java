
package com.keren.kerenpaie.jaxrs.impl.paie;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.paie.ElementVariableManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.paie.ElementVariableRS;
import com.keren.kerenpaie.model.paie.ElementVariable;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Sat Mar 17 12:54:26 GMT+01:00 2018
 * 
 */
@Path("/elementvariable")
public class ElementVariableRSImpl
    extends AbstractGenericService<ElementVariable, Long>
    implements ElementVariableRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "ElementVariableManagerImpl", interf = ElementVariableManagerRemote.class)
    protected ElementVariableManagerRemote manager;

    public ElementVariableRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ElementVariable, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		MetaData meta = null;
		
		try {
			meta = MetaDataUtil.getMetaData(new ElementVariable(), new HashMap<String, MetaData>(), new ArrayList<String>());
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
