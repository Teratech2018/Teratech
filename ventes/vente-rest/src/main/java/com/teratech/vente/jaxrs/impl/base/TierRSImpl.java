
package com.teratech.vente.jaxrs.impl.base;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.vente.core.ifaces.base.TierManagerRemote;
import com.teratech.vente.jaxrs.ifaces.base.TierRS;
import com.teratech.vente.model.base.Tier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Jan 04 08:13:40 WAT 2019
 * 
 */
@Path("/tier")
public class TierRSImpl
    extends AbstractGenericService<Tier, Long>
    implements TierRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechvente", name = "TierManagerImpl", interf = TierManagerRemote.class)
    protected TierManagerRemote manager;

    public TierRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Tier, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechvente");
    }
 @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            return MetaDataUtil.getMetaData(new Tier(), new HashMap<String, MetaData>(), new ArrayList<String>()); //To change body of generated methods, choose Tools | Templates.
        } catch (InstantiationException ex) {
            Logger.getLogger(CiviliteRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CiviliteRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    protected void processBeforeUpdate(Tier entity) {
        for(int i=0 ;i<entity.getComptesbancaire().size();i++){
           if(entity.getComptesbancaire().get(i).getId()<=0){
               entity.getComptesbancaire().get(i).setId(-1);
           }//end if(entity.getContacts().get(i).getId()<=0)
        }//end for(int i=0 ;i<entity.getContacts().size();i++){
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(Tier entity) {
        for(int i=0 ;i<entity.getComptesbancaire().size();i++){
           if(entity.getComptesbancaire().get(i).getId()<=0){
               entity.getComptesbancaire().get(i).setId(-1);
           }//end if(entity.getContacts().get(i).getId()<=0)
        }//end for(int i=0 ;i<entity.getContacts().size();i++){
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
}
