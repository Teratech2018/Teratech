
package com.keren.jaxrs.impl.presences;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.presences.PointageJouranlierManagerRemote;
import com.keren.jaxrs.ifaces.presences.PointageJouranlierRS;
import com.keren.model.conges.InterruptionConge;
import com.keren.model.presences.PointageJouranlier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Feb 15 13:18:47 GMT+01:00 2018
 * 
 */
@Path("/pointagejouranlier")
public class PointageJouranlierRSImpl
    extends AbstractGenericService<PointageJouranlier, Long>
    implements PointageJouranlierRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "PointageJouranlierManagerImpl", interf = PointageJouranlierManagerRemote.class)
    protected PointageJouranlierManagerRemote manager;

    public PointageJouranlierRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<PointageJouranlier, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
   
    
	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		 try {
				MetaData meta = MetaDataUtil.getMetaData(new PointageJouranlier(),new HashMap<String, MetaData>()
						, new ArrayList<String>());
				MetaColumn workbtn = new MetaColumn("button", "work1", "Confirmer", false, "workflow", null);
				workbtn.setStates(new String[]{"etabli"});
				workbtn.setValue("{'model':'kerenrh','entity':'pointagejournalier','method':'confirme'}");
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
	public PointageJouranlier confirmer(HttpHeaders headers, PointageJouranlier dmde) {
		// TODO Auto-generated method stub
		return dmde;
	}

}
