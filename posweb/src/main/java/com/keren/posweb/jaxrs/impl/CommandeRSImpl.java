
package com.keren.posweb.jaxrs.impl;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.posweb.core.ifaces.CommandeManagerRemote;
import com.keren.posweb.jaxrs.ifaces.CommandeRS;
import com.keren.posweb.model.Commande;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Sep 06 10:32:17 GMT+01:00 2018
 * 
 */
@Path("/commande")
public class CommandeRSImpl
    extends AbstractGenericService<Commande, Long>
    implements CommandeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "posweb", name = "CommandeManagerImpl", interf = CommandeManagerRemote.class)
    protected CommandeManagerRemote manager;

    public CommandeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Commande, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("posweb");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new Commande(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(CommandeRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CommandeRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
