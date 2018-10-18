
package com.kerenedu.solde;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Oct 11 16:18:28 WAT 2018
 * 
 */
@Path("/categoriepret")
public class CategoriePretRSImpl
    extends AbstractGenericService<CategoriePret, Long>
    implements CategoriePretRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "CategoriePretManagerImpl", interf = CategoriePretManagerRemote.class)
    protected CategoriePretManagerRemote manager;

    public CategoriePretRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CategoriePret, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {
                return MetaDataUtil.getMetaData(new CategoriePret(), new HashMap<String, MetaData>(),new ArrayList<String>());
        } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return null;
    }
    
    @Override
    protected void processBeforeSave(CategoriePret entity) {

        // TODO Auto-generated method stub
        if(entity.getGelee() == null){
            entity.setGelee(false);
        }

        super.processBeforeSave(entity);
    }

    @Override
    protected void processBeforeUpdate(CategoriePret entity) {
        
        // TODO Auto-generated method stub
        if(entity.getGelee() == null){
            entity.setGelee(false);
        }
    }
}
