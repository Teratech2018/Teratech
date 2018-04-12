
package com.keren.jaxrs.impl.formations;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.formations.DemandeFormationManagerRemote;
import com.keren.jaxrs.ifaces.formations.DemandeFormationRS;
import com.keren.model.carrieres.Nomination;
import com.keren.model.formations.DemandeFormation;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 13:14:14 GMT+01:00 2018
 * 
 */
@Path("/demandeformation")
public class DemandeFormationRSImpl
    extends AbstractGenericService<DemandeFormation, Long>
    implements DemandeFormationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "DemandeFormationManagerImpl", interf = DemandeFormationManagerRemote.class)
    protected DemandeFormationManagerRemote manager;

    public DemandeFormationRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<DemandeFormation, Long> getManager() {
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
   			meta = MetaDataUtil.getMetaData(new DemandeFormation(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'demandeformation','method':'valide'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-success");
   	        meta.getHeader().add(workbtn);  
   	        workbtn = new MetaColumn("button", "work1", "Annuler", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'demandeformation','method':'rejete'}");
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

	@Override
	public DemandeFormation valide(HttpHeaders headers, DemandeFormation entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DemandeFormation rejete(HttpHeaders headers, DemandeFormation entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
