
package com.teratech.achat.jaxrs.impl.comptabilite;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.achat.core.ifaces.comptabilite.CompteManagerRemote;
import com.teratech.achat.jaxrs.ifaces.comptabilite.CompteRS;
import com.teratech.achat.jaxrs.impl.base.CiviliteRSImpl;
import com.teratech.achat.model.comptabilite.Compte;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Feb 27 14:29:40 GMT+01:00 2018
 * 
 */
@Path("/compte")
public class CompteRSImpl
    extends AbstractGenericService<Compte, Long>
    implements CompteRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "CompteManagerImpl", interf = CompteManagerRemote.class)
    protected CompteManagerRemote manager;

    public CompteRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Compte, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }
    
     @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            return MetaDataUtil.getMetaData(new Compte(), new HashMap<String, MetaData>(), new ArrayList<String>()); //To change body of generated methods, choose Tools | Templates.
        } catch (InstantiationException ex) {
            Logger.getLogger(CiviliteRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CiviliteRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    protected void processBeforeUpdate(Compte entity) {
        for(int i=0 ; i<entity.getAnalytiques().size();i++){
            if(entity.getAnalytiques().get(i).getId()<=0){
                entity.getAnalytiques().get(i).setId(-1);
            }//end  if(entity.getAnalytiques().get(i).getId()<=0){
        }//end for(int i=0 ; i<entity.getAnalytiques().size();i++)
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(Compte entity) {
         for(int i=0 ; i<entity.getAnalytiques().size();i++){
            if(entity.getAnalytiques().get(i).getId()<=0){
                entity.getAnalytiques().get(i).setId(-1);
            }//end  if(entity.getAnalytiques().get(i).getId()<=0){
        }//end for(int i=0 ; i<entity.getAnalytiques().size();i++)
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
