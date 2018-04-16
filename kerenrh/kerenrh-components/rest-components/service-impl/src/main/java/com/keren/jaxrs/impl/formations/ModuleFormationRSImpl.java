
package com.keren.jaxrs.impl.formations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.keren.core.ifaces.formations.ModuleFormationManagerRemote;
import com.keren.jaxrs.ifaces.formations.ModuleFormationRS;
import com.keren.model.formations.ModuleFormation;
import com.keren.model.formations.ThemeFormation;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 13:14:15 GMT+01:00 2018
 * 
 */
@Path("/moduleformation")
public class ModuleFormationRSImpl
    extends AbstractGenericService<ModuleFormation, Long>
    implements ModuleFormationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "ModuleFormationManagerImpl", interf = ModuleFormationManagerRemote.class)
    protected ModuleFormationManagerRemote manager;

    public ModuleFormationRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ModuleFormation, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    

	@Override
	protected void processBeforeSave(ModuleFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La reference du theme est obligatoire");
		}else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
			throw new KerenExecption("L'intitulé du theme est obligatoire");
		}
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(ModuleFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La reference du theme est obligatoire");
		}else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
			throw new KerenExecption("L'intitulé du theme est obligatoire");
		}
		super.processBeforeUpdate(entity);
	}   
    

}
