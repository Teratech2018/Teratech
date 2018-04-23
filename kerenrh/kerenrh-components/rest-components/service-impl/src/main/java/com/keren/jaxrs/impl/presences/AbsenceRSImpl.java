
package com.keren.jaxrs.impl.presences;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.presences.AbsenceManagerRemote;
import com.keren.jaxrs.ifaces.presences.AbsenceRS;
import com.keren.model.presences.Absence;
import com.keren.model.presences.LignePointage;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Sun Apr 22 11:44:27 GMT+01:00 2018
 * 
 */
@Path("/absence")
public class AbsenceRSImpl
    extends AbstractGenericService<Absence, Long>
    implements AbsenceRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "AbsenceManagerImpl", interf = AbsenceManagerRemote.class)
    protected AbsenceManagerRemote manager;

    public AbsenceRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Absence, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		 try {
				MetaData meta = MetaDataUtil.getMetaData(new Absence(),new HashMap<String, MetaData>()
						, new ArrayList<String>());
				MetaColumn workbtn = new MetaColumn("button", "work1", "Justifiée", false, "workflow", null);
				workbtn.setStates(new String[]{"etabli"});
				workbtn.setValue("{'model':'kerenrh','entity':'absence','method':'justifier'}");
				meta.getHeader().add(workbtn);
				workbtn = new MetaColumn("button", "work2", "Non justifiée", false, "workflow", null);
				workbtn.setStates(new String[]{"etabli"});
				workbtn.setValue("{'model':'kerenrh','entity':'absence','method':'nonjustifier'}");
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
	protected void processBeforeDelete(Object entity) {
		// TODO Auto-generated method stub
		super.processBeforeDelete(entity);
	}

	@Override
	protected void processBeforeSave(Absence entity) {
		// TODO Auto-generated method stub
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(Absence entity) {
		// TODO Auto-generated method stub
		super.processBeforeUpdate(entity);
	}

	@Override
	public Absence justifier(HttpHeaders headers, Absence entity) {
		// TODO Auto-generated method stub
		return manager.justifie(entity);
	}

	@Override
	public Absence nonjustifier(HttpHeaders headers, Absence entity) {
		// TODO Auto-generated method stub
		return manager.nonjustifie(entity);
	}
    
    

}
