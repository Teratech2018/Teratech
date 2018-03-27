
package com.keren.jaxrs.impl.presences;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.presences.LigneFichePointageManagerRemote;
import com.keren.jaxrs.ifaces.presences.LigneFichePointageRS;
import com.keren.model.presences.LigneFichePointage;
import com.keren.model.presences.PointageJouranlier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Feb 15 13:18:47 GMT+01:00 2018
 * 
 */
@Path("/lignefichepointage")
public class LigneFichePointageRSImpl
    extends AbstractGenericService<LigneFichePointage, Long>
    implements LigneFichePointageRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "LigneFichePointageManagerImpl", interf = LigneFichePointageManagerRemote.class)
    protected LigneFichePointageManagerRemote manager;

    public LigneFichePointageRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LigneFichePointage, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
   

}
