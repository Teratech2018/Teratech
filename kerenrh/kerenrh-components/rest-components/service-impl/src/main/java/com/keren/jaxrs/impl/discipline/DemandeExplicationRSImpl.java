
package com.keren.jaxrs.impl.discipline;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.discipline.DemandeExplicationManagerRemote;
import com.keren.jaxrs.ifaces.discipline.DemandeExplicationRS;
import com.keren.model.discipline.DemandeExplication;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Feb 15 16:33:29 GMT+01:00 2018
 * 
 */
@Path("/demandeexplication")
public class DemandeExplicationRSImpl
    extends AbstractGenericService<DemandeExplication, Long>
    implements DemandeExplicationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "DemandeExplicationManagerImpl", interf = DemandeExplicationManagerRemote.class)
    protected DemandeExplicationManagerRemote manager;

    public DemandeExplicationRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<DemandeExplication, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        
        // TODO Auto-generated method stub
        try {
            MetaData meta = MetaDataUtil.getMetaData(new DemandeExplication(), new HashMap<String, MetaData>()
                            , new ArrayList<String>());			
            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
            meta.getHeader().add(stautsbar);
            return meta;
        } catch (Exception e) {
            
            // TODO Auto-generated catch block
            throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
        }
    }



    @Override
    protected void processBeforeDelete(Object id) {
        
        // TODO Auto-generated method stub
        DemandeExplication entity = manager.find("id", (Long) id);
        if(!entity.getState().equalsIgnoreCase("etabli")){
            throw new KerenExecption("La demende est déjà en cours de traitement");
        }//end if(!entity.getState().equalsIgnoreCase("etabli")){
        
        super.processBeforeDelete(id);
    }

    @Override
    protected void processBeforeSave(DemandeExplication entity) {
            
        // TODO Auto-generated method stub
        if(entity.getAuteur()==null){
            throw new KerenExecption("L'auteur de la demande est obligatoire");
        }else if(entity.getReference()==null||entity.getReference().trim().isEmpty()){
            throw new KerenExecption("La Reference de la demande est obligatoire");
        }else if(entity.getDestinataire()==null){
            throw new KerenExecption("L'employé concerne par la demande est obligatoire");
        }else if(entity.getDaten() != null && entity.getDated() != null){
            
            if(entity.getDated().before(entity.getDaten())){
                throw new KerenExecption("La date de decharge est incorrecte");
            }           
        }
        
        entity.setState("etabli");
        super.processBeforeSave(entity);
    }

    @Override
    protected void processBeforeUpdate(DemandeExplication entity) {
            
        // TODO Auto-generated method stub
        if(entity.getAuteur()==null){
            throw new KerenExecption("L'auteur de la demande est obligatoire");
        }else if(entity.getReference()==null||entity.getReference().trim().isEmpty()){
            throw new KerenExecption("La Reference de la demande est obligatoire");
        }else if(entity.getDestinataire()==null){
            throw new KerenExecption("L'employé concerné par la demande est obligatoire");
        }if(!entity.getState().equalsIgnoreCase("etabli")){
            throw new KerenExecption("La demende est déjà en cours de traitement");
        }else if(entity.getDated().before(entity.getDaten())){
            throw new KerenExecption("La date de décharge est incorrecte");
        }
        
        super.processBeforeUpdate(entity);
    }
}
