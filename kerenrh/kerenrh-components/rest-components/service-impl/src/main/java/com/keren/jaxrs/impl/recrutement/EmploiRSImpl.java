
package com.keren.jaxrs.impl.recrutement;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.recrutement.AffectationCandidatManagerRemote;
import com.keren.core.ifaces.recrutement.EmploiManagerRemote;
import com.keren.jaxrs.ifaces.recrutement.EmploiRS;
import com.keren.model.formations.SeanceFormation;
import com.keren.model.recrutement.Emploi;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import javax.ws.rs.core.Context;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Apr 11 11:31:28 GMT+01:00 2018
 * 
 */
@Path("/emploi")
public class EmploiRSImpl
    extends AbstractGenericService<Emploi, Long>
    implements EmploiRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "EmploiManagerImpl", interf = EmploiManagerRemote.class)
    protected EmploiManagerRemote manager;
    
    /**
     * On injecte un Gestionnaire d'entites 
     * 
     */
    @Manager(application = "kerenrh", name = "AffectationCandidatManagerImpl", interf = AffectationCandidatManagerRemote.class)
    protected AffectationCandidatManagerRemote AffectationCandidatManager;

    public EmploiRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Emploi, Long> getManager() {
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
                meta = MetaDataUtil.getMetaData(new Emploi(), new HashMap<String, MetaData>()
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
    public Emploi delete(@Context HttpHeaders headers , Long id) {
        
        //Initialsiation
        Emploi entity = null;
        
        try{
            
            //On supprime l'entite
            entity = super.delete(headers,id);
            
        }catch(Exception e){
            
            //On lève une exception
            throw new KerenExecption("Cet emploi a deja fait l'objet d'un traitement ");
        }
        
        return entity; 
    }
}
