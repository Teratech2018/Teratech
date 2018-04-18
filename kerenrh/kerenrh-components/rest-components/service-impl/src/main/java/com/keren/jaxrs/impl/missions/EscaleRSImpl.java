
package com.keren.jaxrs.impl.missions;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.missions.EscaleManagerRemote;
import com.keren.jaxrs.ifaces.missions.EscaleRS;
import com.keren.model.employes.Employe;
import com.keren.model.missions.Escale;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/escale")
public class EscaleRSImpl
    extends AbstractGenericService<Escale, Long>
    implements EscaleRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "EscaleManagerImpl", interf = EscaleManagerRemote.class)
    protected EscaleManagerRemote manager;

    public EscaleRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Escale, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        
        try {
            return MetaDataUtil.getMetaData(new Escale(),new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (Exception e) {          
            throw new WebApplicationException(e);
        }
    }
    
    @Override
    protected void processBeforeUpdate(Escale entity) {
        if(entity.getSource()==null){
            throw new KerenExecption("La ville de départ est obligatoire");
        }if(entity.getCible()==null){
            throw new KerenExecption("La Ville d'arrivée est obligatoire");
        }else if(entity.getMontant()==null){
            throw new KerenExecption("Les Frais de l'escale sont obligatoires");
        }
        super.processBeforeUpdate(entity);
    }

    @Override
    protected void processBeforeSave(Escale entity) {
        if(entity.getSource()==null){
            throw new KerenExecption("La ville de départ est obligatoire");
        }if(entity.getCible()==null){
            throw new KerenExecption("La Ville d'arrivée est obligatoire");
        }else if(entity.getMontant()==null){
            throw new KerenExecption("Les Frais de l'escale sont obligatoires");
        }
        super.processBeforeUpdate(entity);
    }
}
