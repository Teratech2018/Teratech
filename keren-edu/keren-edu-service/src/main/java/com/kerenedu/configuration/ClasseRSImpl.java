
package com.kerenedu.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Jan 11 10:03:44 WAT 2018
 * 
 */
@Path("/classe")
public class ClasseRSImpl
    extends AbstractGenericService<Classe, Long>
    implements ClasseRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ClasseManagerImpl", interf = ClasseManagerRemote.class)
    protected ClasseManagerRemote manager;

    public ClasseRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Classe, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
 
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new Classe(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}

	@Override
	protected void processBeforeSave(Classe entity) {
		entity.setEffectif(new Long("0"));
		super.processBeforeSave(entity);
	}
	
	 //
		@Override
		public List<Classe> filter(HttpHeaders headers, int firstResult, int maxResult) {

			RestrictionsContainer container = RestrictionsContainer.newInstance();  
	        System.out.println("ClasseRSImpl.filter() container "+container.getPredicats());
			List<Classe>	datas = manager.filter(container.getPredicats(), null, null, firstResult, maxResult);
			System.out.println("ClasseRSImpl.filter() nombre classe "+datas.size());
			return datas;
		}


}
