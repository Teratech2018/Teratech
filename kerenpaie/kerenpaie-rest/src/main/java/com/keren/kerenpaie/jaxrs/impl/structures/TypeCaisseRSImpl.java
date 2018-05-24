
package com.keren.kerenpaie.jaxrs.impl.structures;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.structures.TypeCaisseManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.structures.TypeCaisseRS;
import com.keren.kerenpaie.model.structures.TypeCaisse;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Apr 05 13:54:58 GMT+01:00 2018
 * 
 */
@Path("/typecaisse")
public class TypeCaisseRSImpl
    extends AbstractGenericService<TypeCaisse, Long>
    implements TypeCaisseRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "TypeCaisseManagerImpl", interf = TypeCaisseManagerRemote.class)
    protected TypeCaisseManagerRemote manager;

    public TypeCaisseRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<TypeCaisse, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {
            return MetaDataUtil.getMetaData(new TypeCaisse(), new HashMap<String, MetaData>()
                            , new ArrayList<String>());
        } catch (InstantiationException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }
    
    @Override
    public TypeCaisse delete(Long id) {

        // TODO Auto-generated method stub
        TypeCaisse entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }
}
