
package com.keren.kerenpaie.jaxrs.impl.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.structures.SyndicatManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.structures.SyndicatRS;
import com.keren.kerenpaie.model.structures.Syndicat;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Apr 05 13:54:58 GMT+01:00 2018
 * 
 */
@Path("/syndicat")
public class SyndicatRSImpl
    extends AbstractGenericService<Syndicat, Long>
    implements SyndicatRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "SyndicatManagerImpl", interf = SyndicatManagerRemote.class)
    protected SyndicatManagerRemote manager;

    public SyndicatRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Syndicat, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {
            return MetaDataUtil.getMetaData(new Syndicat(),new HashMap<String, MetaData>()
                            , new ArrayList<String>());
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
    protected void processBeforeSave(Syndicat entity) {
        
        // TODO Auto-generated method stub
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("Le nom de l'organisation est obligatoire");
        }else if(entity.getComptetier()==null){
                throw new KerenExecption("Le Compte Tier lié est obligatoire");
        }else if(entity.getTypecaisse()==null){
                throw new KerenExecption("Le Type de Caisse est obligatoire");
        }
        super.processBeforeSave(entity);
    }

    @Override
    protected void processBeforeUpdate(Syndicat entity) {
        
        // TODO Auto-generated method stub
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("Le nom de l'organisation est obligatoire");
        }else if(entity.getComptetier()==null){
                throw new KerenExecption("Le Compte Tier lié est obligatoire");
        }else if(entity.getTypecaisse()==null){
                throw new KerenExecption("Le Type de Caisse est obligatoire");
        }
        super.processBeforeUpdate(entity);
    }
    
    @Override
    public Syndicat delete(Long id) {

        // TODO Auto-generated method stub
        Syndicat entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }

}
