
package com.keren.jaxrs.impl.employes;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.employes.DepartementSocManagerRemote;
import com.keren.jaxrs.ifaces.employes.DepartementSocRS;
import com.keren.model.employes.DepartementSoc;
import com.keren.model.employes.Fonction;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import javax.ws.rs.core.Context;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Feb 14 13:16:29 GMT+01:00 2018
 * 
 */
@Path("/departementsoc")
public class DepartementSocRSImpl
    extends AbstractGenericService<DepartementSoc, Long>
    implements DepartementSocRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "DepartementSocManagerImpl", interf = DepartementSocManagerRemote.class)
    protected DepartementSocManagerRemote manager;

    public DepartementSocRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<DepartementSoc, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {
            return MetaDataUtil.getMetaData(new DepartementSoc(),new HashMap<String, MetaData>()
                                , new ArrayList<String>());
        } catch (Exception e) {

            // TODO Auto-generated catch block
            throw new WebApplicationException(e);
        }
    }
        
        
    @Override
    public DepartementSoc delete(@Context HttpHeaders headers , Long id) {

        // TODO Auto-generated method stub
        DepartementSoc entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(headers,id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }

}
