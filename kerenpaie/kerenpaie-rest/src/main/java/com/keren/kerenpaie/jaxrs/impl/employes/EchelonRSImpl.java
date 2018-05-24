
package com.keren.kerenpaie.jaxrs.impl.employes;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.employes.EchelonManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.employes.EchelonRS;
import com.keren.kerenpaie.model.employes.Echelon;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Mar 01 10:22:26 GMT+01:00 2018
 * 
 */
@Path("/echelon")
public class EchelonRSImpl
    extends AbstractGenericService<Echelon, Long>
    implements EchelonRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "EchelonManagerImpl", interf = EchelonManagerRemote.class)
    protected EchelonManagerRemote manager;

    public EchelonRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Echelon, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }


    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {
            return MetaDataUtil.getMetaData(new Echelon(),new HashMap<String, MetaData>()
                            , new ArrayList<String>());
        } catch (Exception e) {

            // TODO Auto-generated catch block
            throw new WebApplicationException(e);
        }
    }
    
    @Override
    public Echelon delete(Long id) {

        // TODO Auto-generated method stub
        Echelon entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }
}
