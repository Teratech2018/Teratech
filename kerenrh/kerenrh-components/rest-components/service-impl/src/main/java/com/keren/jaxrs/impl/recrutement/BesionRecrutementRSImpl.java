
package com.keren.jaxrs.impl.recrutement;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.recrutement.BesionRecrutementManagerRemote;
import com.keren.jaxrs.ifaces.recrutement.BesionRecrutementRS;
import com.keren.model.formations.SeanceFormation;
import com.keren.model.recrutement.BesionRecrutement;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Apr 11 11:31:28 GMT+01:00 2018
 * 
 */
@Path("/besionrecrutement")
public class BesionRecrutementRSImpl
    extends AbstractGenericService<BesionRecrutement, Long>
    implements BesionRecrutementRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "BesionRecrutementManagerImpl", interf = BesionRecrutementManagerRemote.class)
    protected BesionRecrutementManagerRemote manager;

    public BesionRecrutementRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BesionRecrutement, Long> getManager() {
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
   			meta = MetaDataUtil.getMetaData(new BesionRecrutement(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'besionrecrutement','method':'valide'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-success");
   	        meta.getHeader().add(workbtn);  
   	        workbtn = new MetaColumn("button", "work1", "Rejeter", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'besionrecrutement','method':'rejete'}");
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
	public BesionRecrutement valide(HttpHeaders headers, BesionRecrutement entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BesionRecrutement annule(HttpHeaders headers, BesionRecrutement entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
