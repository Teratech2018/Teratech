
package com.kerenedu.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.app.BuilderHttpHeaders;
import com.kerenedu.model.report.ViewBadgeModal;
import com.kerenedu.notes.CoefMatiere;
import com.kerenedu.notes.CoefMatiereDetail;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Sep 25 11:35:42 WAT 2018
 * 
 */
@Path("/classecycle")
public class ClasseCycleRSImpl
    extends AbstractGenericService<ClasseCycle, Long>
    implements ClasseCycleRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ClasseCycleManagerImpl", interf = ClasseCycleManagerRemote.class)
    protected ClasseCycleManagerRemote manager;

    public ClasseCycleRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ClasseCycle, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new ClasseCycle(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}


	@Override
	public List<ClasseCycle> filter(HttpHeaders arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		RestrictionsContainer container = filterPredicatesBuilder(arg0,arg1,arg2);
		Cycle filiere = (Cycle) CacheMemory.getValue(BuilderHttpHeaders.getidUsers(arg0), TypeCacheMemory.CYCLE);
		if(filiere!=null){
			container.addEq("cycle",  CacheMemory.getCurentcycle());
		}//end if(filiere!=null){
		return getManager().filter(container.getPredicats(), null, new HashSet<String>(), arg1, arg2);
	}

	

	
}
