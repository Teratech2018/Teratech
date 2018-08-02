
package com.kerenedu.school;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.core.MetaDataUtil;
import com.megatim.common.annotations.Filter;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Dec 28 15:02:40 WAT 2017
 * 
 */
@Path("/eleve")
public class EleveRSImpl
    extends AbstractGenericService<Eleve, Long>
    implements EleveRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "EleveManagerImpl", interf = EleveManagerRemote.class)
    protected EleveManagerRemote manager;

    public EleveRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Eleve, Long> getManager() {
        return manager;
    }
    
    

    @Override
	public List<Eleve> filter(HttpHeaders arg0, int arg1, int arg2) {
    	Gson gson = new Gson();
    	List<Filter> filters = gson.fromJson(arg0.getRequestHeader("predicats").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
		System.out.println("EleveRSImpl.filter()"+filters);
		return super.filter(arg0, arg1, arg2);
	}

	@Override
	public RSNumber count(HttpHeaders arg0) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
    	List<Filter> filters = gson.fromJson(arg0.getRequestHeader("predicats").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
		System.out.println("EleveRSImpl.count()"+filters);
		return super.count(arg0);
	}

	public String getModuleName() {
        return ("kereneducation");
    }

    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			MetaData meta =  MetaDataUtil.getMetaData(new Eleve(), new HashMap<String, MetaData>(),new ArrayList<String>());
			MetaColumn col = new MetaColumn("button", "incription", "Pré-Inscription", false, "action", null);
			col.setValue("{'name':'keren_education_ins','template':{'eleve':'object'}}");
			
			meta.getHeader().add(col);
			col = new MetaColumn("button", "paiementfrais", "Scolarité", false, "action", null);
			col.setValue("{'name':'keren_education_paie_limit','template':{'eleve':'object'}}");
			meta.getHeader().add(col);
	
			
			
//			meta.getHeader().add(col2);
//			meta.getHeader().add(col);
			return meta;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
