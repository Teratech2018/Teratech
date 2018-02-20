
package com.kerenedu.configuration;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.discipline.Abscence;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Feb 08 11:01:57 CET 2018
 * 
 */
@Path("/notesms")
public class NoteSMSRSImpl
    extends AbstractGenericService<NoteSMS, Long>
    implements NoteSMSRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "NoteSMSManagerImpl", interf = NoteSMSManagerRemote.class)
    protected NoteSMSManagerRemote manager;

    public NoteSMSRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<NoteSMS, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
  	public MetaData getMetaData(HttpHeaders headers) {
  		// TODO Auto-generated method stub
  		try {
  			MetaColumn col = new MetaColumn("button", "paiementfrais", "Configurer", false, "action", null);
			col.setValue("{'name':'keren_education_paie'}");
			
			
			MetaData meta =  MetaDataUtil.getMetaData(new NoteSMS(), new HashMap<String, MetaData>(),new ArrayList<String>());
			meta.getHeader().add(col);
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
