
package com.keren.jaxrs.impl.employes;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.employes.FonctionManagerRemote;
import com.keren.jaxrs.ifaces.employes.FonctionRS;
import com.keren.model.employes.Categorie;
import com.keren.model.employes.Fonction;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Feb 14 12:53:10 GMT+01:00 2018
 * 
 */
@Path("/fonction")
public class FonctionRSImpl
    extends AbstractGenericService<Fonction, Long>
    implements FonctionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "FonctionManagerImpl", interf = FonctionManagerRemote.class)
    protected FonctionManagerRemote manager;

    public FonctionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Fonction, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        
        // TODO Auto-generated method stub
        try {
            return MetaDataUtil.getMetaData(new Fonction(),new HashMap<String, MetaData>()
                                , new ArrayList<String>());
        } catch (Exception e) {
            
            // TODO Auto-generated catch block
            throw new WebApplicationException(e);
        }
    }
    
    @Override
    protected void processBeforeUpdate(Fonction entity) {

         if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le Code/Abbréviation est obligatoire");
        }/*else if(entity.getActif()==null){
            throw new KerenExecption("La Actif est obligatoire");
        }else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
            throw new KerenExecption("La Intitulé est obligatoire");
        }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
            throw new KerenExecption("La Type est obligatoire");
        }else if(entity.getDescription()==null||entity.getDescription().trim().isEmpty()){
            throw new KerenExecption("La Descrition  est obligatoire");
        }*/
        super.processBeforeUpdate(entity);
    }

    @Override
    protected void processBeforeSave(Fonction entity) {

        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le Code/Abbréviation est obligatoire");
        }/*else if(entity.getActif()==null){
            throw new KerenExecption("La Actif est obligatoire");
        }else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
            throw new KerenExecption("La Intitulé est obligatoire");
        }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
            throw new KerenExecption("La Type est obligatoire");
        }else if(entity.getDescription()==null||entity.getDescription().trim().isEmpty()){
            throw new KerenExecption("La Descrition  est obligatoire");
        }*/
        
        super.processBeforeSave(entity);
    }
    
    @Override
    public Fonction delete(Long id) {

        // TODO Auto-generated method stub
        Fonction entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }

}