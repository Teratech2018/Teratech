
package com.keren.jaxrs.impl.conges;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.conges.DemandeCongeCManagerRemote;
import com.keren.core.ifaces.conges.DemandeCongeManagerRemote;
import com.keren.core.ifaces.conges.DemandeCongeRManagerRemote;
import com.keren.core.ifaces.conges.DemandeCongeVManagerRemote;
import com.keren.jaxrs.ifaces.conges.DemandeCongeCRS;
import com.keren.model.conges.DemandeConge;
import com.keren.model.conges.DemandeCongeC;
import com.keren.model.conges.DemandeCongeR;
import com.keren.model.conges.DemandeCongeV;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Feb 15 09:30:08 GMT+01:00 2018
 * 
 */
@Path("/demandecongec")
public class DemandeCongeCRSImpl
    extends AbstractGenericService<DemandeCongeC, Long>
    implements DemandeCongeCRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "DemandeCongeCManagerImpl", interf = DemandeCongeCManagerRemote.class)
    protected DemandeCongeCManagerRemote manager;
    
    @Manager(application = "kerenrh", name = "DemandeCongeVManagerImpl", interf = DemandeCongeVManagerRemote.class)
    protected DemandeCongeVManagerRemote managerDCV;
    
    @Manager(application = "kerenrh", name = "DemandeCongeRManagerImpl", interf = DemandeCongeRManagerRemote.class)
    protected DemandeCongeRManagerRemote managerDCR;
    
    @Manager(application = "kerenrh", name = "DemandeCongeManagerImpl", interf = DemandeCongeManagerRemote.class)
    protected DemandeCongeManagerRemote managerDC;


    public DemandeCongeCRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<DemandeCongeC, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
				MetaData meta = MetaDataUtil.getMetaData(new DemandeCongeC(),new HashMap<String, MetaData>()
						, new ArrayList<String>());
				//Construction du workflow
				MetaColumn workbtn = new MetaColumn("button", "work1", "Approuver", false, "workflow", null);
				workbtn.setStates(new String[]{"confirmer"});workbtn.setPattern("btn btn-primary");
				workbtn.setValue("{'model':'kerenrh','entity':'demandecongec','method':'approuve'}");
				meta.getHeader().add(workbtn);
				//Cas du refus
				workbtn = new MetaColumn("button", "work2", "Refuser", false, "workflow", null);
				workbtn.setStates(new String[]{"confirmer"});
				workbtn.setValue("{'model':'kerenrh','entity':'demandecongec','method':'rejete'}");
				meta.getHeader().add(workbtn);
				//Resoumettre
				workbtn = new MetaColumn("button", "work3", "Remettre brouillon", false, "workflow", null);
				workbtn.setStates(new String[]{"confirmer"});
				workbtn.setValue("{'model':'kerenrh','entity':'demandecongec','method':'annuler'}");
				meta.getHeader().add(workbtn);
				MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
				meta.getHeader().add(stautsbar);
				return  meta;
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new WebApplicationException(e);
		}
	}

	@Override
	public DemandeCongeC approuver(HttpHeaders headers, DemandeCongeC dmde) {
		return manager.approuver(dmde);
	}

	@Override
	public DemandeCongeC rejeter(HttpHeaders headers, DemandeCongeC dmde) {
		return manager.rejeter(dmde);
	}

	@Override
	public DemandeCongeC annuler(HttpHeaders headers, DemandeCongeC dmde) {
		return manager.annuler(dmde);
	}

}
