
package com.teratech.gmao.jaxrs.impl.base;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.gmao.core.ifaces.base.IntervenantManagerRemote;
import com.teratech.gmao.jaxrs.ifaces.base.IntervenantRS;
import com.teratech.gmao.model.base.Intervenant;
import com.teratech.gmao.model.base.Qualification;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Jul 13 14:45:39 GMT+01:00 2018
 * 
 */
@Path("/intervenant")
public class IntervenantRSImpl
    extends AbstractGenericService<Intervenant, Long>
    implements IntervenantRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechgmao", name = "IntervenantManagerImpl", interf = IntervenantManagerRemote.class)
    protected IntervenantManagerRemote manager;

    public IntervenantRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Intervenant, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechgmao");
    }
    
     @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
             meta = MetaDataUtil.getMetaData(new Intervenant(), new HashMap<String, MetaData>(), new ArrayList<String>());
           //To change body of generated methods, choose Tools | Templates.
        } catch (InstantiationException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta;
    }

    @Override
    public List<Intervenant> filter(HttpHeaders headers, int firstResult, int maxResult) {
       return super.filter(headers, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public List<Intervenant> findAll(HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
        return super.findAll(headers); 
        
    }

    @Override
    public Intervenant find(HttpHeaders headers, String propertyName, Long id) {
        return super.find(headers, propertyName, id); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public Intervenant delete(HttpHeaders headers, Long id) {
        return super.delete(headers, id); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
