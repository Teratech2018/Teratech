
package com.keren.kerenpaie.jaxrs.impl.comptabilite;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.core.ifaces.comptabilite.JournalComptableManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.comptabilite.JournalComptableRS;
import com.keren.kerenpaie.model.comptabilite.JournalComptable;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Mar 21 14:00:16 GMT+01:00 2018
 * 
 */
@Path("/journalcomptable")
public class JournalComptableRSImpl
    extends AbstractGenericService<JournalComptable, Long>
    implements JournalComptableRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "JournalComptableManagerImpl", interf = JournalComptableManagerRemote.class)
    protected JournalComptableManagerRemote manager;

    public JournalComptableRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<JournalComptable, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }

}
