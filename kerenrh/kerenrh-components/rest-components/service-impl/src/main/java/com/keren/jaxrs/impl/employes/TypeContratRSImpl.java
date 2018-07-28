
package com.keren.jaxrs.impl.employes;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.employes.TypeContratManagerRemote;
import com.keren.jaxrs.ifaces.employes.TypeContratRS;
import com.keren.model.employes.TypeContrat;
import com.keren.model.structures.Departement;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import javax.ws.rs.core.Context;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Feb 14 13:56:56 GMT+01:00 2018
 * 
 */
@Path("/typecontrat")
public class TypeContratRSImpl
    extends AbstractGenericService<TypeContrat, Long>
    implements TypeContratRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "TypeContratManagerImpl", interf = TypeContratManagerRemote.class)
    protected TypeContratManagerRemote manager;

    public TypeContratRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<TypeContrat, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {
            return MetaDataUtil.getMetaData(new TypeContrat(),new HashMap<String, MetaData>()
                                , new ArrayList<String>());
        } catch (Exception e) {

            // TODO Auto-generated catch block
            throw new WebApplicationException(e);
        }
    }
    
    @Override
    public TypeContrat delete(@Context HttpHeaders headers , Long id) {

        // TODO Auto-generated method stub
        TypeContrat entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(headers,id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }

}
