
package com.teratech.gmao.jaxrs.impl.base;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.gmao.core.ifaces.base.CentreAnalytiqueManagerRemote;
import com.teratech.gmao.jaxrs.ifaces.base.CentreAnalytiqueRS;
import com.teratech.gmao.model.base.Article;
import com.teratech.gmao.model.base.CentreAnalytique;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Jul 13 14:45:39 GMT+01:00 2018
 * 
 */
@Path("/centreanalytique")
public class CentreAnalytiqueRSImpl
    extends AbstractGenericService<CentreAnalytique, Long>
    implements CentreAnalytiqueRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechgmao", name = "CentreAnalytiqueManagerImpl", interf = CentreAnalytiqueManagerRemote.class)
    protected CentreAnalytiqueManagerRemote manager;

    public CentreAnalytiqueRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CentreAnalytique, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechgmao");
    }

     @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
             meta = MetaDataUtil.getMetaData(new CentreAnalytique(), new HashMap<String, MetaData>(), new ArrayList<String>());
           //To change body of generated methods, choose Tools | Templates.
        } catch (InstantiationException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta;
    }

    @Override
    protected void processBeforeUpdate(CentreAnalytique entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ centre de frais est obligatoire");
        }else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
            throw new KerenExecption("Le champ désignation est obligatoire");
        }
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(CentreAnalytique entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ centre de frais est obligatoire");
        }else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
            throw new KerenExecption("Le champ désignation est obligatoire");
        }
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
