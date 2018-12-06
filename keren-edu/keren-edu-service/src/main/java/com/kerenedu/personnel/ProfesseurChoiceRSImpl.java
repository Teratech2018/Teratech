
package com.kerenedu.personnel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.configuration.TypeCacheMemory;
import com.kerenedu.notes.CoefMatiere;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Nov 27 16:21:12 WAT 2018
 * 
 */
@Path("/professeurchoice")
public class ProfesseurChoiceRSImpl
    extends AbstractGenericService<ProfesseurChoice, Long>
    implements ProfesseurChoiceRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ProfesseurChoiceManagerImpl", interf = ProfesseurChoiceManagerRemote.class)
    protected ProfesseurChoiceManagerRemote manager;

    public ProfesseurChoiceRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ProfesseurChoice, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new ProfesseurChoice(), new HashMap<String, MetaData>()
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
	public List<ProfesseurChoice> filter(HttpHeaders arg0, int arg1, int arg2) {
		RestrictionsContainer container = filterPredicatesBuilder(arg0,arg1,arg2);
		 container.addNotNull("profil", null);
         container.addNotNull("categorie", null);
		return getManager().filter(container.getPredicats(), null, new HashSet<String>(), arg1, arg2);
	}

}
