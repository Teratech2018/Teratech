
package com.kerenedu.configuration;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jan 09 15:21:43 WAT 2018
 * 
 */
@Path("/annescolairemodal")
public class AnneScolaireModalRSImpl
    extends AbstractGenericService<AnneScolaireModal, Long>
    implements AnneScolaireModalRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "AnneScolaireManagerImpl", interf = AnneScolaireManagerRemote.class)
    protected AnneScolaireManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "UserEducationManagerImpl", interf =UserEducationManagerRemote.class)
    protected UserEducationManagerRemote managerUser;

    public AnneScolaireModalRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<AnneScolaireModal, Long> getManager() {
        return null;
    }
    
    @Override
    public AnneScolaireModal save(@Context HttpHeaders headers ,AnneScolaireModal entity) {
    	System.out.println("AnneScolaireModalRSImpl.save() set curent annéé scolaire");
    	if(entity.getAnneScolaire()==null){
    		 throw new KerenExecption("Bien vouloir selection l'année scolaire");
    	}else{
    	     UserEducation user = managerUser.find("id", CacheMemory.getCurrentuser());
    		  CacheMemory.setCurrentannee(entity.getAnneScolaire().getCode());
    		  CacheMemory.setCurentcycle(entity.getCycle().getId());
    		  CacheMemory.setCurrentSchool(user.getCurrentSchool());
    	}
    	CacheMemory.setClasse(null);
        return entity; 
    }


    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new AnneScolaireModal(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}

}
