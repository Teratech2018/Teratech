
package com.keren.jaxrs.impl.presences;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.keren.core.ifaces.presences.LignePointageManagerRemote;
import com.kerem.core.MetaDataUtil;
import com.keren.jaxrs.ifaces.presences.LignePointageRS;
import com.keren.model.presences.LignePointage;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Feb 15 14:18:53 GMT+01:00 2018
 * 
 */
@Path("/lignepointage")
public class LignePointageRSImpl
    extends AbstractGenericService<LignePointage, Long>
    implements LignePointageRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "LignePointageManagerImpl", interf = LignePointageManagerRemote.class)
    protected LignePointageManagerRemote manager;

    public LignePointageRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LignePointage, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		 try {
   				MetaData meta = MetaDataUtil.getMetaData(new LignePointage(),new HashMap<String, MetaData>()
   						, new ArrayList<String>());
   				MetaColumn workbtn = new MetaColumn("button", "work1", "Justifiée", false, "workflow", null);
   				workbtn.setStates(new String[]{"etabli"});
   				workbtn.setValue("{'model':'kerenrh','entity':'lignefichepointage','method':'justifier'}");
   				meta.getHeader().add(workbtn);
   				workbtn = new MetaColumn("button", "work2", "Non justifiée", false, "workflow", null);
   				workbtn.setStates(new String[]{"etabli"});
   				workbtn.setValue("{'model':'kerenrh','entity':'lignefichepointage','method':'nonjustifier'}");
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
	protected void processBeforeDelete(Object id) {
            
            // TODO Auto-generated method stub
            LignePointage entity = manager.find("id", (Long) id);

            if(!entity.getState().equalsIgnoreCase("etabli")){
                throw new KerenExecption("Le Pointage est deja valide");
            }//end if(entity.getState().equalsIgnoreCase("valide")){
                
            super.processBeforeDelete(id);
	}
        
	@Override
	public LignePointage justifier(HttpHeaders headers, LignePointage dmde) {
            
            // TODO Auto-generated method stub
            return manager.justifie(dmde);
	}

	@Override
	public LignePointage nonjustifier(HttpHeaders headers, LignePointage dmde) {
            
            // TODO Auto-generated method stub
            return manager.nonjustifie(dmde);
	}
	
	

}
