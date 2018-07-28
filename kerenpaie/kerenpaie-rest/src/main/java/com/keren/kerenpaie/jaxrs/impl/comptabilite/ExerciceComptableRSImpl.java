
package com.keren.kerenpaie.jaxrs.impl.comptabilite;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.comptabilite.ExerciceComptableManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.comptabilite.ExerciceComptableRS;
import com.keren.kerenpaie.model.comptabilite.ExerciceComptable;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import javax.ws.rs.core.Context;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Mar 06 12:50:48 GMT+01:00 2018
 * 
 */
@Path("/exercicecomptable")
public class ExerciceComptableRSImpl
    extends AbstractGenericService<ExerciceComptable, Long>
    implements ExerciceComptableRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "ExerciceComptableManagerImpl", interf = ExerciceComptableManagerRemote.class)
    protected ExerciceComptableManagerRemote manager;

    public ExerciceComptableRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ExerciceComptable, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {
                return MetaDataUtil.getMetaData(new ExerciceComptable(),new HashMap<String, MetaData>()
                                , new ArrayList<String>());
        } catch (Exception e) {
            
            // TODO Auto-generated catch block
            throw new WebApplicationException(e);
        }
    }
    
    @Override
    protected void processBeforeSave(ExerciceComptable entity) {
        
        // TODO Auto-generated method stub
        if(entity.getDebut().after(entity.getFin())){
           throw new KerenExecption("La date debut est incorrecte");
        }
        
        super.processBeforeSave(entity);
    }

    @Override
    protected void processBeforeUpdate(ExerciceComptable entity) {
        
        // TODO Auto-generated method stub
        if(entity.getDebut().after(entity.getFin())){
           throw new KerenExecption("La date debut est incorrecte");
        }

        super.processBeforeUpdate(entity);
    }

    @Override
    public ExerciceComptable delete(@Context HttpHeaders headers , Long id) {

        // TODO Auto-generated method stub
        ExerciceComptable entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(headers,id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }
}
