
package com.keren.jaxrs.impl.discipline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.discipline.ConvocationConseilManagerRemote;
import com.keren.core.ifaces.discipline.ResolutionConseilManagerRemote;
import com.keren.jaxrs.ifaces.discipline.ConvocationConseilRS;
import com.keren.model.discipline.ConvocationConseil;
import com.keren.model.discipline.MembreConseil;
import com.keren.model.discipline.ResolutionConseil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Feb 15 16:33:29 GMT+01:00 2018
 * 
 */
@Path("/convocationconseil")
public class ConvocationConseilRSImpl
    extends AbstractGenericService<ConvocationConseil, Long>
    implements ConvocationConseilRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "ConvocationConseilManagerImpl", interf = ConvocationConseilManagerRemote.class)
    protected ConvocationConseilManagerRemote manager;
    
    @Manager(application = "kerenrh", name = "ResolutionConseilManagerImpl", interf = ResolutionConseilManagerRemote.class)
    protected ResolutionConseilManagerRemote resolutionmanager;
    
    

    public ConvocationConseilRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ConvocationConseil, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			MetaData meta = MetaDataUtil.getMetaData(new ConvocationConseil(), new HashMap<String, MetaData>()
					, new ArrayList<String>());
			MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
			meta.getHeader().add(stautsbar);
			return meta;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void processBeforeDelete(Object id) {
		// TODO Auto-generated method stub
		ConvocationConseil entity = manager.find("id", (Long) id);
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("convocation.id", entity.getId());
		List<ResolutionConseil> datas = resolutionmanager.filter(container.getPredicats(),null,null,0, -1);
		if(datas!=null&&!datas.isEmpty()){
			throw new KerenExecption("Consiel ayant déjà siègé et résolution déjà liée");
		}//end if(datas!=null&&!datas.isEmpty()){
		super.processBeforeDelete(id);
	}

	@Override
	protected void processBeforeSave(ConvocationConseil entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La Reference du conseil d'administration est obligatoire");
		}else if(entity.getReference()==null||entity.getReference().trim().isEmpty()){
			throw new KerenExecption("Le Numéro de la décision est obligatoire");
		}else if(entity.getDate()==null){
			throw new KerenExecption("La date de convocationdu conseil d'administration est obligatoire");
		}else if(entity.getDemandes()==null||entity.getDemandes().isEmpty()){
			throw new KerenExecption("Les demandes d'explications concernées sont obligatoire");
		}else if(entity.getMembres()==null||entity.getMembres().isEmpty()){
			throw new KerenExecption("Les Membres du conseil d'administration sont obligatoire");
		}
		entity.setState("convoque");
		traitementMembres(entity);
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(ConvocationConseil entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La Reference du conseil d'administration est obligatoire");
		}else if(entity.getReference()==null||entity.getReference().trim().isEmpty()){
			throw new KerenExecption("Le Numéro de la décision est obligatoire");
		}else if(entity.getDate()==null){
			throw new KerenExecption("La date de convocationdu conseil d'administration est obligatoire");
		}else if(entity.getDemandes()==null||entity.getDemandes().isEmpty()){
			throw new KerenExecption("Les demandes d'explications concernées sont obligatoire");
		}else if(entity.getMembres()==null||entity.getMembres().isEmpty()){
			throw new KerenExecption("Les Membres du conseil d'administration sont obligatoire");
		}
		traitementMembres(entity);
		super.processBeforeUpdate(entity);
	}
    
    private void traitementMembres(ConvocationConseil entity){
    	for(MembreConseil mem:entity.getMembres()){
    		if(mem.getId()<=0){
    			mem.setId(-1);
    		}//end if(mem.getId()<=0){
    	}//end for(MembreConseil mem:entity.getMembres()){
    }

}
