
package com.keren.jaxrs.impl.conges;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.commons.DateHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.conges.DemandeCongeManagerRemote;
import com.keren.jaxrs.ifaces.conges.DemandeCongeRS;
import com.keren.model.conges.DemandeConge;
import com.keren.model.conges.DemandeCongeC;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Feb 15 09:30:08 GMT+01:00 2018
 * 
 */
@Path("/demandeconge")
public class DemandeCongeRSImpl
    extends AbstractGenericService<DemandeConge, Long>
    implements DemandeCongeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "DemandeCongeManagerImpl", interf = DemandeCongeManagerRemote.class)
    protected DemandeCongeManagerRemote manager;

    public DemandeCongeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<DemandeConge, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			MetaData meta = MetaDataUtil.getMetaData(new DemandeConge(),new HashMap<String, MetaData>()
					, new ArrayList<String>());
			//Construction du workflow
			MetaColumn workbtn = new MetaColumn("button", "work1", "Confirmer", false, "workflow", null);
			workbtn.setStates(new String[]{"etabli"});
			workbtn.setValue("{'model':'kerenrh','entity':'demandeconge','method':'confirme'}");
			meta.getHeader().add(workbtn);
			MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
			meta.getHeader().add(stautsbar);
			return  meta;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
		}
	}

	@Override
	public DemandeConge confirmer(HttpHeaders headers, DemandeConge dmde) {
		return manager.confirmer(dmde);
	}
        
         @Override
        protected void processBeforeDelete(Object id) {
            
            //Variables
            DemandeConge demandeConge = manager.find("id",(Long)id);
            
            if(!demandeConge.getState().equalsIgnoreCase("etabli")){
                throw new KerenExecption("Suppression impossible, car l'element a deja subit des traitements");
            }

            super.processBeforeDelete(id);
        }
        
	@Override
	protected void processBeforeSave(DemandeConge entity) {
		this._controlreView(entity);
		
                long dureeconge = DateHelper.numberOfDays(entity.getDebut(), entity.getFin());
		entity.setDuree(new Long(dureeconge).shortValue());
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(DemandeConge entity) {
		this._controlreView(entity);
		 
                long dureeconge = DateHelper.numberOfDays(entity.getDebut(), entity.getFin());
		entity.setDuree(new Long(dureeconge).shortValue());
		super.processBeforeUpdate(entity);
	}
	
	private void _controlreView(DemandeConge entity){
		    if(entity.getDebut().after(entity.getFin())){
	            throw new KerenExecption("Saisie Date erronée !!!");
	        }else if(entity.getDebut().equals(entity.getFin())){
	            throw new KerenExecption("Saisie Date erronée !!!");
	        }else if(entity.getFin().after(entity.getFin())){
	            throw new KerenExecption("Saisie Date erronée !!!");
	        }else if(!entity.getState().equalsIgnoreCase("etabli")){
                    throw new KerenExecption("Modification impossible, car l'element a deja subit des traitements");
                }
	}
	
	

}
