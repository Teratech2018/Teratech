
package com.keren.jaxrs.impl.conges;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.conges.RepriseServiceManagerRemote;
import com.keren.jaxrs.ifaces.conges.RepriseServiceRS;
import com.keren.model.conges.DemandeConge;
import com.keren.model.conges.DemandeCongeV;
import com.keren.model.conges.InterruptionConge;
import com.keren.model.conges.RepriseService;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Feb 15 11:54:14 GMT+01:00 2018
 * 
 */
@Path("/repriseservice")
public class RepriseServiceRSImpl
    extends AbstractGenericService<RepriseService, Long>
    implements RepriseServiceRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "RepriseServiceManagerImpl", interf = RepriseServiceManagerRemote.class)
    protected RepriseServiceManagerRemote manager;

    public RepriseServiceRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<RepriseService, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
            
            // TODO Auto-generated method stub
            try {
                MetaData meta = MetaDataUtil.getMetaData(new RepriseService(),new HashMap<String, MetaData>()
                                , new ArrayList<String>());
                MetaColumn workbtn = new MetaColumn("button", "work1", "Confirmer", false, "workflow", null);
                workbtn.setStates(new String[]{"etabli"});
                workbtn.setValue("{'model':'kerenrh','entity':'repriseservice','method':'confirme'}");
                meta.getHeader().add(workbtn);
                MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
                meta.getHeader().add(stautsbar);
                return meta;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
            }
   	}

    
	@Override
	protected void processBeforeSave(RepriseService entity) {
		_controlreView(entity);
            entity.setEmploye(entity.getConge().getEmploye());
            entity.getConge().setFinEffetif(entity.getDate());

            entity.setState("etabli");
            super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(RepriseService entity) {
            _controlreView(entity);
            entity.setEmploye(entity.getConge().getEmploye());
            entity.getConge().setFinEffetif(entity.getDate());;
            super.processBeforeUpdate(entity);
	}

	@Override
	public RepriseService confirmer(HttpHeaders headers, RepriseService dmde) {
            return manager.confirmer(dmde);
	}
	
	private void _controlreView(RepriseService entity){
		
            if (!entity.getDate().after(entity.getConge().getFin())) {
                throw new KerenExecption("Impossible de saisir la reprise: conge encours.. !!! Le conge Prend Fin le : "+entity.getConge().getFin());
            }
	}

}
