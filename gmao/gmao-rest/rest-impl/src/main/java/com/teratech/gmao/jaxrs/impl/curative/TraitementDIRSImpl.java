
package com.teratech.gmao.jaxrs.impl.curative;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.gmao.core.ifaces.curative.TraitementDIManagerRemote;
import com.teratech.gmao.jaxrs.ifaces.curative.TraitementDIRS;
import com.teratech.gmao.model.curative.TraitementDI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Jul 17 13:56:42 GMT+01:00 2018
 * 
 */
@Path("/traitementdi")
public class TraitementDIRSImpl
    extends AbstractGenericService<TraitementDI, Long>
    implements TraitementDIRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechgmao", name = "TraitementDIManagerImpl", interf = TraitementDIManagerRemote.class)
    protected TraitementDIManagerRemote manager;

    public TraitementDIRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<TraitementDI, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechgmao");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            //To change body of generated methods, choose Tools | Templates.
            meta = MetaDataUtil.getMetaData(new TraitementDI(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(TraitementDIRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TraitementDIRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta ;
    }

    @Override
    protected void processBeforeUpdate(TraitementDI entity) {
       if(entity.getReponse()==null||entity.getReponse().trim().isEmpty()){
           throw new KerenExecption("Veuillez saisir la reponse à la demande");
       }
       entity.setState("prisencharge");
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

}
