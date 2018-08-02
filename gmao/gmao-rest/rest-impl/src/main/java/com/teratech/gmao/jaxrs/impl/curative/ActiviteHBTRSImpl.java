
package com.teratech.gmao.jaxrs.impl.curative;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.gmao.core.ifaces.curative.ActiviteHBTManagerRemote;
import com.teratech.gmao.jaxrs.ifaces.curative.ActiviteHBTRS;
import com.teratech.gmao.jaxrs.impl.base.ArticleRSImpl;
import com.teratech.gmao.model.curative.ActiviteHBT;
import com.teratech.gmao.model.curative.Remede;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Mon Jul 16 17:19:58 GMT+01:00 2018
 * 
 */
@Path("/activitehbt")
public class ActiviteHBTRSImpl
    extends AbstractGenericService<ActiviteHBT, Long>
    implements ActiviteHBTRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechgmao", name = "ActiviteHBTManagerImpl", interf = ActiviteHBTManagerRemote.class)
    protected ActiviteHBTManagerRemote manager;

    public ActiviteHBTRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ActiviteHBT, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechgmao");
    }
    
     @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
             meta = MetaDataUtil.getMetaData(new ActiviteHBT(), new HashMap<String, MetaData>(), new ArrayList<String>());
           //To change body of generated methods, choose Tools | Templates.
        } catch (InstantiationException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta;
    }

    @Override
    protected void processBeforeUpdate(ActiviteHBT entity) {
         if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ Activité est obligatoire");
        }else if(entity.getType().trim().equalsIgnoreCase("0")&&entity.getDemande()==null){
            throw new KerenExecption("Le champ Demande intervention est obligatoire");
        }else if(entity.getIntervenant()==null){
            throw new KerenExecption("Le champ Intervenant est obligatoire  ");
        }else if(entity.getDdebut()==null){
            throw new KerenExecption("Le champ Date début est obligatoire");
        }else if(entity.getDfin()==null){
            throw new KerenExecption("Le champ Date de fin est obligatoire");
        }
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(ActiviteHBT entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ Activité est obligatoire");
        }else if(entity.getType().trim().equalsIgnoreCase("0")&&entity.getDemande()==null){
            throw new KerenExecption("Le champ Demande intervention est obligatoire");
        }else if(entity.getIntervenant()==null){
            throw new KerenExecption("Le champ Intervenant est obligatoire  ");
        }else if(entity.getDdebut()==null){
            throw new KerenExecption("Le champ Date début est obligatoire");
        }else if(entity.getDfin()==null){
            throw new KerenExecption("Le champ Date de fin est obligatoire");
        }
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
