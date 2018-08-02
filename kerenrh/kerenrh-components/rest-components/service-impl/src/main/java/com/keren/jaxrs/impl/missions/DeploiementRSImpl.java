
package com.keren.jaxrs.impl.missions;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.keren.core.ifaces.missions.DeploiementManagerRemote;
import com.keren.jaxrs.ifaces.missions.DeploiementRS;
import com.keren.model.missions.Deploiement;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/deploiement")
public class DeploiementRSImpl
    extends AbstractGenericService<Deploiement, Long>
    implements DeploiementRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "DeploiementManagerImpl", interf = DeploiementManagerRemote.class)
    protected DeploiementManagerRemote manager;

    public DeploiementRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Deploiement, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
    public Deploiement delete(@Context HttpHeaders headers ,Long id) {
        
        //Initialisation
        Deploiement data = null;
        Deploiement result = null;
        
        try{
        
            data = super.delete(headers,id);
            result = new Deploiement(data);
            
        }catch(Exception e){
            
            throw new KerenExecption("Suppression impossible, car cet objet est dejà en cours d'utilisation par d'autres objets !");
        }
        
        return result; //To change body of generated methods, choose Tools | Templates.
    }
    
}
