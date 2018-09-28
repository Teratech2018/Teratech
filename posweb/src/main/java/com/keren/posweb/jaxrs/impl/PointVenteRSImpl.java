
package com.keren.posweb.jaxrs.impl;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.posweb.core.ifaces.PointVenteManagerRemote;
import com.keren.posweb.jaxrs.ifaces.PointVenteRS;
import com.keren.posweb.model.PointVente;
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

 * @since Wed Sep 05 10:26:16 GMT+01:00 2018
 * 
 */
@Path("/pointvente")
public class PointVenteRSImpl
    extends AbstractGenericService<PointVente, Long>
    implements PointVenteRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "posweb", name = "PointVenteManagerImpl", interf = PointVenteManagerRemote.class)
    protected PointVenteManagerRemote manager;

    public PointVenteRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<PointVente, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("posweb");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null ;
        try {
            meta = MetaDataUtil.getMetaData(new PointVente(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(PointVenteRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PointVenteRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
