
package com.keren.jaxrs.impl.conges;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.conges.InterruptionCongeManagerRemote;
import com.keren.jaxrs.ifaces.conges.InterruptionCongeRS;
import com.keren.model.conges.InterruptionConge;
import com.keren.model.conges.RepriseService;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import javassist.tools.reflect.Loader;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Feb 15 11:54:14 GMT+01:00 2018
 * 
 */
@Path("/interruptionconge")
public class InterruptionCongeRSImpl
    extends AbstractGenericService<InterruptionConge, Long>
    implements InterruptionCongeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "InterruptionCongeManagerImpl", interf = InterruptionCongeManagerRemote.class)
    protected InterruptionCongeManagerRemote manager;

    public InterruptionCongeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<InterruptionConge, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			MetaData meta = MetaDataUtil.getMetaData(new InterruptionConge(),new HashMap<String, MetaData>()
   					, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Confirmer", false, "workflow", null);
			workbtn.setStates(new String[]{"etabli"});
			workbtn.setValue("{'model':'kerenrh','entity':'interruptionconge','method':'confirme'}");
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
	protected void processBeforeSave(InterruptionConge entity) {
		_controlreView(entity);
		
                //On applique l'etat
                entity.setState("etabli");
                
		entity.setEmploye(entity.getConge().getEmploye());
		entity.setDateDebutConge(entity.getConge().getDebut());
		long duree = entity.getDate().getTime()-entity.getConge().getFin().getTime();
		long nbrejourr = entity.getDate().getTime()-entity.getDateDebutConge().getTime();
		entity.setDureeconge(new Long(duree).shortValue());
		entity.setJoursr(new Long(nbrejourr).shortValue());
		
		entity.getConge().setFinEffetif(entity.getDate());
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(InterruptionConge entity) {
		final long MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24;
		this._controlreView(entity);
		entity.setEmploye(entity.getConge().getEmploye());
		entity.setDateDebutConge(entity.getConge().getDebut());
		long duree = Math.abs(entity.getConge().getFin().getTime()-entity.getDate().getTime())/MILLISECONDS_PER_DAY;
		long nbrejourr = Math.abs(entity.getDateDebutConge().getTime()-entity.getDate().getTime())/MILLISECONDS_PER_DAY;
		entity.setDureeconge(new Long(duree).shortValue());
		entity.setJoursr(new Long(nbrejourr).shortValue());
		
		entity.getConge().setFinEffetif(entity.getDate());
		super.processBeforeUpdate(entity);
	}

	@Override
	public InterruptionConge confirmer(HttpHeaders headers, InterruptionConge dmde) {
		return manager.confirmer(dmde);
	}
	
	
	private void _controlreView(InterruptionConge entity){
		 if(!entity.getDate().before(entity.getConge().getFin())){
	            throw new KerenExecption("Date d'interruption Invalide !!");
	        }
	}

}
