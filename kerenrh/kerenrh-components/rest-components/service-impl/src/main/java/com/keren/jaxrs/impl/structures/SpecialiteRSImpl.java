
package com.keren.jaxrs.impl.structures;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.structures.SpecialiteManagerRemote;
import com.keren.jaxrs.ifaces.structures.SpecialiteRS;
import com.keren.model.structures.Departement;
import com.keren.model.structures.Specialite;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Feb 14 14:12:28 GMT+01:00 2018
 * 
 */
@Path("/specialite")
public class SpecialiteRSImpl
    extends AbstractGenericService<Specialite, Long>
    implements SpecialiteRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "SpecialiteManagerImpl", interf = SpecialiteManagerRemote.class)
    protected SpecialiteManagerRemote manager;

    public SpecialiteRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Specialite, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
            
        // TODO Auto-generated method stub
        try {
            return MetaDataUtil.getMetaData(new Specialite(),new HashMap<String, MetaData>()
                                , new ArrayList<String>());
        } catch (Exception e) {
            
            // TODO Auto-generated catch block
            throw new WebApplicationException(e);
        }
    }

    @Override
    public Specialite delete(Long id) {

        // TODO Auto-generated method stub
        Specialite entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }
}
