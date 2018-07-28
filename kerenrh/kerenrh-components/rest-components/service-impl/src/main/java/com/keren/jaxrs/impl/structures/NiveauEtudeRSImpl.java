
package com.keren.jaxrs.impl.structures;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.structures.NiveauEtudeManagerRemote;
import com.keren.jaxrs.ifaces.structures.NiveauEtudeRS;
import com.keren.model.structures.Departement;
import com.keren.model.structures.NiveauEtude;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import javax.ws.rs.core.Context;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Feb 14 14:12:28 GMT+01:00 2018
 * 
 */
@Path("/niveauetude")
public class NiveauEtudeRSImpl
    extends AbstractGenericService<NiveauEtude, Long>
    implements NiveauEtudeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "NiveauEtudeManagerImpl", interf = NiveauEtudeManagerRemote.class)
    protected NiveauEtudeManagerRemote manager;

    public NiveauEtudeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<NiveauEtude, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {
            return MetaDataUtil.getMetaData(new NiveauEtude(),new HashMap<String, MetaData>()
                                , new ArrayList<String>());
        } catch (Exception e) {

            // TODO Auto-generated catch block
            throw new WebApplicationException(e);
        }
    }

    @Override
    public NiveauEtude delete(@Context HttpHeaders headers , Long id) {

        // TODO Auto-generated method stub
        NiveauEtude entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(headers,id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }
}
