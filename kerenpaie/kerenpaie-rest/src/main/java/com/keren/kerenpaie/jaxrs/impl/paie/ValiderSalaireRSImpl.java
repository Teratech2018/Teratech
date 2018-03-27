
package com.keren.kerenpaie.jaxrs.impl.paie;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.paie.ValiderSalaireManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.paie.ValiderSalaireRS;
import com.keren.kerenpaie.model.paie.SoumettreSalaire;
import com.keren.kerenpaie.model.paie.ValiderSalaire;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Mar 13 16:31:05 GMT+01:00 2018
 * 
 */
@Path("/validersalaire")
public class ValiderSalaireRSImpl
    extends AbstractGenericService<ValiderSalaire, Long>
    implements ValiderSalaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "ValiderSalaireManagerImpl", interf = ValiderSalaireManagerRemote.class)
    protected ValiderSalaireManagerRemote manager;

    public ValiderSalaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ValiderSalaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		MetaData meta =null;
		try {
			meta = MetaDataUtil.getMetaData(new ValiderSalaire(), new HashMap<String, MetaData>(),new ArrayList<String>());
			MetaColumn workbtn = new MetaColumn("button", "work1", "Imprimer le brouillard des salaires", false, "workflow", null);
	        workbtn.setValue("{'model':'kerenpaie','entity':'validersalaire','method':'imprimerbrouillard'}");
	        workbtn.setStates(new String[]{"etabli"});
	        workbtn.setPattern("btn btn-success");
	        meta.getHeader().add(workbtn);   
//	        workbtn = new MetaColumn("button", "work1", "Refuser", false, "workflow", null);
//	        workbtn.setValue("{'model':'kerenpaie','entity':'remboursementpret','method':'refuse'}");
//	        workbtn.setStates(new String[]{"etabli"});
//	        workbtn.setPattern("btn btn-danger");
//	        meta.getHeader().add(workbtn);   
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
