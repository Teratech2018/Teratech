
package com.keren.jaxrs.impl.employes;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.employes.PosteManagerRemote;
import com.keren.jaxrs.ifaces.employes.PosteRS;
import com.keren.model.employes.Categorie;
import com.keren.model.employes.Poste;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Feb 14 12:53:10 GMT+01:00 2018
 * 
 */
@Path("/poste")
public class PosteRSImpl
    extends AbstractGenericService<Poste, Long>
    implements PosteRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "PosteManagerImpl", interf = PosteManagerRemote.class)
    protected PosteManagerRemote manager;

    public PosteRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Poste, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {
            return MetaDataUtil.getMetaData(new Poste(),new HashMap<String, MetaData>()
                                , new ArrayList<String>());
        } catch (Exception e) {

            // TODO Auto-generated catch block
            throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
        }
    }
    
    @Override
    public Poste delete(Long id) {

        // TODO Auto-generated method stub
        Poste entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }

}
