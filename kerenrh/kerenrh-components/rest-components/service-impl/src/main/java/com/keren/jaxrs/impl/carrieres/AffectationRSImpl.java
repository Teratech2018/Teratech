
package com.keren.jaxrs.impl.carrieres;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.carrieres.AffectationManagerRemote;
import com.keren.jaxrs.ifaces.carrieres.AffectationRS;
import com.keren.model.carrieres.Affectation;
import com.keren.model.carrieres.Reclassement;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 13:14:15 GMT+01:00 2018
 * 
 */
@Path("/affectation")
public class AffectationRSImpl
    extends AbstractGenericService<Affectation, Long>
    implements AffectationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "AffectationManagerImpl", interf = AffectationManagerRemote.class)
    protected AffectationManagerRemote manager;

    public AffectationRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Affectation, Long> getManager() {
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
   			meta = MetaDataUtil.getMetaData(new Affectation(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'reclassement','method':'valide'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-success");
   	        meta.getHeader().add(workbtn);  
   	        workbtn = new MetaColumn("button", "work1", "Annuler", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'reclassement','method':'annule'}");
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
	public Affectation valide(HttpHeaders headers, Affectation entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Affectation annule(HttpHeaders headers, Affectation entity) {
		// TODO Auto-generated method stub
		return null;
	}
    
    

}
