
package com.keren.jaxrs.impl.missions;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.missions.FraisMissionManagerRemote;
import com.keren.jaxrs.ifaces.missions.FraisMissionRS;
import com.keren.model.employes.Employe;
import com.keren.model.missions.FraisMission;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/fraismission")
public class FraisMissionRSImpl
    extends AbstractGenericService<FraisMission, Long>
    implements FraisMissionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "FraisMissionManagerImpl", interf = FraisMissionManagerRemote.class)
    protected FraisMissionManagerRemote manager;

    public FraisMissionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<FraisMission, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        // TODO Auto-generated method stub
        try {
                return MetaDataUtil.getMetaData(new Employe(),new HashMap<String, MetaData>()
                                , new ArrayList<String>());
        } catch (Exception e) {
                // TODO Auto-generated catch block
                throw new WebApplicationException(e);
        }
    }
    
    @Override
    protected void processBeforeUpdate(FraisMission entity) {
        
        if(entity.getCategorie()==null){
            throw new KerenExecption("La Catégorie de Frais est obligatoire");
        }/*else if(entity.getGroupe()==null||entity.getGroupe().trim().isEmpty()){
            throw new KerenExecption("La Groupe de Frais est obligatoire");
        }else if(entity.getMode()==null||entity.getMode().trim().isEmpty()){
            throw new KerenExecption("La Mode de Paiement est obligatoire");
        }else if(entity.getMontant()==null){
            throw new KerenExecption("La Montant est obligatoire");
        }*/
        super.processBeforeUpdate(entity);
    }

    @Override
    protected void processBeforeSave(FraisMission entity) {
        
        if(entity.getCategorie()==null){
            throw new KerenExecption("La Catégorie de Frais est obligatoire");
        }/*else if(entity.getGroupe()==null||entity.getGroupe().trim().isEmpty()){
            throw new KerenExecption("La Groupe de Frais est obligatoire");
        }else if(entity.getMode()==null||entity.getMode().trim().isEmpty()){
            throw new KerenExecption("La Mode de Paiement est obligatoire");
        }else if(entity.getMontant()==null){
            throw new KerenExecption("La Montant est obligatoire");
        }*/
        super.processBeforeSave(entity);
    }
    
    @Override
    public FraisMission delete(@Context HttpHeaders headers ,Long id) {
        
        //Initialisation
        FraisMission data = null;
        FraisMission result = null;
        
        try{
        
            data = super.delete(headers,id);
            result = new FraisMission(data);
            
        }catch(Exception e){
            
            throw new KerenExecption("Suppression impossible, car cet objet est dejà en cours d'utilisation par d'autres objets !");
        }
        
        return result; //To change body of generated methods, choose Tools | Templates.
    }
}