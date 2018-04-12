
package com.keren.jaxrs.impl.recrutement;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.recrutement.RecrutementManagerRemote;
import com.keren.jaxrs.ifaces.recrutement.RecrutementRS;
import com.keren.model.recrutement.AffectationCandidat;
import com.keren.model.recrutement.Recrutement;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Apr 11 11:31:28 GMT+01:00 2018
 * 
 */
@Path("/recrutement")
public class RecrutementRSImpl
    extends AbstractGenericService<Recrutement, Long>
    implements RecrutementRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "RecrutementManagerImpl", interf = RecrutementManagerRemote.class)
    protected RecrutementManagerRemote manager;

    public RecrutementRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Recrutement, Long> getManager() {
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
   			meta = MetaDataUtil.getMetaData(new Recrutement(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Terminé", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'recrutement','method':'termine'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-danger");
   	        meta.getHeader().add(workbtn);   
   	        MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
   	        meta.getHeader().add(stautsbar);	
   		} catch (InstantiationException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		} catch (IllegalAccessException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		return meta;
   	}

}
