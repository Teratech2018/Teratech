
package com.keren.jaxrs.impl.discipline;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.discipline.DemandeExplicationManagerRemote;
import com.keren.jaxrs.ifaces.discipline.DemandeExplicationRS;
import com.keren.model.discipline.DemandeExplication;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Feb 15 16:33:29 GMT+01:00 2018
 * 
 */
@Path("/demandeexplication")
public class DemandeExplicationRSImpl
    extends AbstractGenericService<DemandeExplication, Long>
    implements DemandeExplicationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "DemandeExplicationManagerImpl", interf = DemandeExplicationManagerRemote.class)
    protected DemandeExplicationManagerRemote manager;

    public DemandeExplicationRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<DemandeExplication, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			MetaData meta = MetaDataUtil.getMetaData(new DemandeExplication(), new HashMap<String, MetaData>()
					, new ArrayList<String>());
			//Construction du workflow
//			MetaColumn workbtn = new MetaColumn("button", "work1", "Approuver", false, "workflow", null);
//			workbtn.setStates(new String[]{"confirmer"});workbtn.setPattern("btn btn-primary");
//			workbtn.setValue("{'model':'kerenrh','entity':'demandeconge','method':'approuve'}");
//			meta.getHeader().add(workbtn);
//			//Cas du refus
//			workbtn = new MetaColumn("button", "work2", "Refuser", false, "workflow", null);
//			workbtn.setStates(new String[]{"confirmer"});
//			workbtn.setValue("{'model':'kerenrh','entity':'demandeconge','method':'rejete'}");
//			meta.getHeader().add(workbtn);
//			//Resoumettre
//			workbtn = new MetaColumn("button", "work3", "Remettre brouillon", false, "workflow", null);
//			workbtn.setStates(new String[]{"confirmer"});
//			workbtn.setValue("{'model':'kerenrh','entity':'demandeconge','method':'annuler'}");
//			meta.getHeader().add(workbtn);
//			MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
//			meta.getHeader().add(stautsbar);
			return meta;
		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		}
	}

}
