
package com.teratech.gmao.jaxrs.impl.curative;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.gmao.core.ifaces.curative.AffectationBonTravailManagerRemote;
import com.teratech.gmao.jaxrs.ifaces.curative.AffectationBonTravailRS;
import com.teratech.gmao.jaxrs.impl.base.ArticleRSImpl;
import com.teratech.gmao.model.curative.AffectationBonTravail;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Jul 17 13:30:32 GMT+01:00 2018
 * 
 */
@Path("/affectationbontravail")
public class AffectationBonTravailRSImpl
    extends AbstractGenericService<AffectationBonTravail, Long>
    implements AffectationBonTravailRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechgmao", name = "AffectationBonTravailManagerImpl", interf = AffectationBonTravailManagerRemote.class)
    protected AffectationBonTravailManagerRemote manager;

    public AffectationBonTravailRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<AffectationBonTravail, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechgmao");
    }

    @Override
    public AffectationBonTravail update(HttpHeaders headers, Long id, AffectationBonTravail entity) {
         //To change body of generated methods, choose Tools | Templates.
        return new AffectationBonTravail();
    }

    @Override
    public AffectationBonTravail save(HttpHeaders headers, AffectationBonTravail entity) {
        return new AffectationBonTravail(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
             meta = MetaDataUtil.getMetaData(new AffectationBonTravail(), new HashMap<String, MetaData>(), new ArrayList<String>());
           //To change body of generated methods, choose Tools | Templates.
        } catch (InstantiationException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta;
    }

}
