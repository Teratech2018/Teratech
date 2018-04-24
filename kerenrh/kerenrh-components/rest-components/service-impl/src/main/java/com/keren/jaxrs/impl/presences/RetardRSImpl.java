
package com.keren.jaxrs.impl.presences;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.presences.RetardManagerRemote;
import com.keren.jaxrs.ifaces.presences.RetardRS;
import com.keren.model.presences.LignePointage;
import com.keren.model.presences.Retard;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Mon Apr 23 09:28:01 GMT+01:00 2018
 * 
 */
@Path("/retard")
public class RetardRSImpl
    extends AbstractGenericService<Retard, Long>
    implements RetardRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "RetardManagerImpl", interf = RetardManagerRemote.class)
    protected RetardManagerRemote manager;

    public RetardRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Retard, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		 try {
				MetaData meta = MetaDataUtil.getMetaData(new Retard(),new HashMap<String, MetaData>()
						, new ArrayList<String>());
				MetaColumn workbtn = new MetaColumn("button", "work1", "Justifiée", false, "workflow", null);
				workbtn.setStates(new String[]{"etabli"});
				workbtn.setValue("{'model':'kerenrh','entity':'retard','method':'justifier'}");
				meta.getHeader().add(workbtn);
				workbtn = new MetaColumn("button", "work2", "Non justifiée", false, "workflow", null);
				workbtn.setStates(new String[]{"etabli"});
				workbtn.setValue("{'model':'kerenrh','entity':'retard','method':'nonjustifier'}");
				meta.getHeader().add(workbtn);
				MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
				meta.getHeader().add(stautsbar);
				return meta;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new WebApplicationException(e);
			}
	}

	@Override
	public Retard justifier(HttpHeaders headers, Retard entity) {
		// TODO Auto-generated method stub
		return manager.justifie(entity);
	}

	@Override
	public Retard nonjustifier(HttpHeaders headers, Retard entity) {
		// TODO Auto-generated method stub
		return manager.nonjustifie(entity);
	}
    
    
    

}
