
package com.keren.jaxrs.impl.structures;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.structures.DeviseManagerRemote;
import com.keren.jaxrs.ifaces.structures.DeviseRS;
import com.keren.model.structures.Departement;
import com.keren.model.structures.Devise;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Feb 16 13:42:05 GMT+01:00 2018
 * 
 */
@Path("/devise")
public class DeviseRSImpl
    extends AbstractGenericService<Devise, Long>
    implements DeviseRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "DeviseManagerImpl", interf = DeviseManagerRemote.class)
    protected DeviseManagerRemote manager;

    public DeviseRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Devise, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        
        // TODO Auto-generated method stub
        try {
            return MetaDataUtil.getMetaData(new Devise(),new HashMap<String, MetaData>()
                                , new ArrayList<String>());
        } catch (Exception e) {
            
            // TODO Auto-generated catch block
            throw new WebApplicationException(e);
        }
    }
    
    @Override
    public Devise delete(Long id) {

        // TODO Auto-generated method stub
        Devise entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }

}
