
package com.keren.courrier.jaxrs.impl.referentiel;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.referentiel.GroupeUtilisateurManagerRemote;
import com.keren.courrier.jaxrs.ifaces.referentiel.GroupeUtilisateurRS;
import com.keren.courrier.jaxrs.impl.courrier.CourrierRSImpl;
import com.keren.courrier.model.courrier.Courrier;
import com.keren.courrier.model.referentiel.GroupeUtilisateur;
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

 * @since Wed Jul 18 10:58:44 GMT+01:00 2018
 * 
 */
@Path("/groupeutilisateur")
public class GroupeUtilisateurRSImpl
    extends AbstractGenericService<GroupeUtilisateur, Long>
    implements GroupeUtilisateurRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "GroupeUtilisateurManagerImpl", interf = GroupeUtilisateurManagerRemote.class)
    protected GroupeUtilisateurManagerRemote manager;

    public GroupeUtilisateurRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<GroupeUtilisateur, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }

    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new GroupeUtilisateur(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }
    
}
