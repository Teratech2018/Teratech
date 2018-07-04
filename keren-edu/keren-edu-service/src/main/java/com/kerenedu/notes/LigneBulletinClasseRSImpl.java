
package com.kerenedu.notes;

import javax.ws.rs.Path;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 24 15:14:11 WAT 2018
 * 
 */
@Path("/lignebulletinclasse")
public class LigneBulletinClasseRSImpl
    extends AbstractGenericService<LigneBulletinClasse, Long>
    implements LigneBulletinClasseRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "LigneBulletinClasseManagerImpl", interf = LigneBulletinClasseManagerRemote.class)
    protected LigneBulletinClasseManagerRemote manager;

    public LigneBulletinClasseRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LigneBulletinClasse, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }

}
