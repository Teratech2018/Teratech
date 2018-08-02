
package com.keren.courrier.jaxrs.impl.referentiel;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.referentiel.ClasseurCourrierManagerRemote;
import com.keren.courrier.jaxrs.ifaces.referentiel.ClasseurCourrierRS;
import com.keren.courrier.model.referentiel.ClasseurCourrier;
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

 * @since Fri Jul 27 09:35:27 GMT+01:00 2018
 * 
 */
@Path("/classeurcourrier")
public class ClasseurCourrierRSImpl
    extends AbstractGenericService<ClasseurCourrier, Long>
    implements ClasseurCourrierRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "ClasseurCourrierManagerImpl", interf = ClasseurCourrierManagerRemote.class)
    protected ClasseurCourrierManagerRemote manager;

    public ClasseurCourrierRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ClasseurCourrier, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta =  MetaDataUtil.getMetaData(new ClasseurCourrier(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(ClasseurCourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ClasseurCourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta;
    }
    
    

}
