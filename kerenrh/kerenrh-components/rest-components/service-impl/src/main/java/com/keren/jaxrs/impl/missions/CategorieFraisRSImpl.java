
package com.keren.jaxrs.impl.missions;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.missions.CategorieFraisManagerRemote;
import com.keren.jaxrs.ifaces.missions.CategorieFraisRS;
import com.keren.model.missions.CategorieFrais;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import javax.ws.rs.core.Context;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/categoriefrais")
public class CategorieFraisRSImpl
    extends AbstractGenericService<CategorieFrais, Long>
    implements CategorieFraisRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "CategorieFraisManagerImpl", interf = CategorieFraisManagerRemote.class)
    protected CategorieFraisManagerRemote manager;

    public CategorieFraisRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CategorieFrais, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
            // TODO Auto-generated method stub
            MetaData meta = null;
            try {
                    meta = MetaDataUtil.getMetaData(new CategorieFrais(), new HashMap<String, MetaData>()
                    , new ArrayList<String>());
            } catch (InstantiationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            return meta;
    }
        
	@Override
	protected void processBeforeUpdate(CategorieFrais entity) {
            if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("La Reference est obligatoire");
            }/*else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
                throw new KerenExecption("La Intitulé est obligatoire");
            }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
                throw new KerenExecption("La Type de depense est obligatoire");
            }else if(entity.getCompte()==null){
                throw new KerenExecption("La Compte de charge est obligatoire");
            }else if(entity.getGrille()==null||entity.getGrille().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins un GrilleFrais");
            }*/
            super.processBeforeUpdate(entity);
    }

	@Override
	protected void processBeforeSave(CategorieFrais entity) {
            if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("La Reference est obligatoire");
            }/*else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
                throw new KerenExecption("La Intitulé est obligatoire");
            }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
                throw new KerenExecption("La Type de depense est obligatoire");
            }else if(entity.getCompte()==null){
                throw new KerenExecption("La Compte de charge est obligatoire");
            }else if(entity.getGrille()==null||entity.getGrille().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins un GrilleFrais");
            }*/
            super.processBeforeSave(entity);
    }
    
    @Override
    public CategorieFrais delete(@Context HttpHeaders headers ,Long id) {
        
        //Initialisation
        CategorieFrais data = null;
        CategorieFrais result = null;
        
        try{
        
            data = super.delete(headers,id);
            result = new CategorieFrais(data);
            
        }catch(Exception e){
            
            throw new KerenExecption("Suppression impossible, car cet objet est dejà en cours d'utilisation par d'autres objets !");
        }
        
        return result; //To change body of generated methods, choose Tools | Templates.
    }        
        
}
