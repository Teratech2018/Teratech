
package com.kerenedu.discipline;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.school.Eleve;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Sat Feb 03 12:30:23 CET 2018
 * 
 */
@Path("/abscence")
public class AbscenceRSImpl
    extends AbstractGenericService<Abscence, Long>
    implements AbscenceRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "AbscenceManagerImpl", interf = AbscenceManagerRemote.class)
    protected AbscenceManagerRemote manager;

    public AbscenceRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Abscence, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
  	public MetaData getMetaData(HttpHeaders headers) {
  		// TODO Auto-generated method stub
  		try {
  			MetaColumn col = new MetaColumn("button", "notesms", "Notifier par sms", false, "action", null);
			col.setValue("{'name':'keren_education_nsms','template':{'eleveList':'object.eleveList'}}");
			
			MetaColumn col2 = new MetaColumn("button", "notemail", "Notifier par Email", false, "action", null);
			col2.setValue("{'name':'keren_education_nmail','template':{'eleveList':'object.eleveList'}}");
			
			MetaData meta =  MetaDataUtil.getMetaData(new Abscence(), new HashMap<String, MetaData>(),new ArrayList<String>());
			meta.getHeader().add(col);
			meta.getHeader().add(col2);
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
