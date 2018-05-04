
package com.keren.kerenpaie.jaxrs.impl.paie;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.paie.MoteurPaieManagerRemote;
import com.keren.kerenpaie.core.ifaces.paie.VariableManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.paie.VariableRS;
import com.keren.kerenpaie.model.paie.Convension;
import com.keren.kerenpaie.model.paie.Variable;
import com.keren.kerenpaie.tools.KerenPaieManagerException;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Mar 06 12:50:48 GMT+01:00 2018
 * 
 */
@Path("/variable")
public class VariableRSImpl
    extends AbstractGenericService<Variable, Long>
    implements VariableRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "VariableManagerImpl", interf = VariableManagerRemote.class)
    protected VariableManagerRemote manager;
    
    @Manager(application = "kerenpaie", name = "MoteurPaieManagerImpl", interf = MoteurPaieManagerRemote.class)
    protected MoteurPaieManagerRemote moteurmanager;

    public VariableRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Variable, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
    	MetaData meta = null;
		try {
			meta = MetaDataUtil.getMetaData(new Variable(), new HashMap<String, MetaData>()
					, new ArrayList<String>());
			MetaColumn workbtn = new MetaColumn("button", "work1", "Evaluer la Variable", false, "object", null);
	        workbtn.setValue("{'model':'kerenpaie','entity':'variable','method':'evaluer',template:{'this':'object'}}");
	        workbtn.setPattern("btn btn-primary");
	        meta.getHeader().add(workbtn);  
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meta;
	}

	@Override
	protected void processBeforeDelete(Object key) {
		Variable entity = manager.find("id", (Long) key);
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("Le Nom de la Variable est obligatoire");
		}else if(entity.getDescription()==null||entity.getDescription().trim().isEmpty()){
			throw new KerenExecption("La Description de la Variable est obligatoire");
		}else if(entity.getDescription()==null||entity.getDescription().trim().isEmpty()){
			throw new KerenExecption("La Description de la Variable est obligatoire");
		}else if(entity.getTypevar()==null||entity.getTypevar().trim().isEmpty()){
			throw new KerenExecption("Le Type de la Variable est obligatoire");
		}else if(entity.getMethodcal()==null||entity.getMethodcal().trim().isEmpty()){
			throw new KerenExecption("La Methode de la Variable est obligatoire");
		}
		// TODO Auto-generated method stub
		super.processBeforeDelete(entity);
	}

	@Override
	protected void processBeforeSave(Variable entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("Le Nom de la Variable est obligatoire");
		}else if(entity.getDescription()==null||entity.getDescription().trim().isEmpty()){
			throw new KerenExecption("La Description de la Variable est obligatoire");
		}else if(entity.getDescription()==null||entity.getDescription().trim().isEmpty()){
			throw new KerenExecption("La Description de la Variable est obligatoire");
		}else if(entity.getTypevar()==null||entity.getTypevar().trim().isEmpty()){
			throw new KerenExecption("Le Type de la Variable est obligatoire");
		}else if(entity.getMethodcal()==null||entity.getMethodcal().trim().isEmpty()){
			throw new KerenExecption("La Methode de la Variable est obligatoire");
		}
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(Variable entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("Le Nom de la Variable est obligatoire");
		}else if(entity.getDescription()==null||entity.getDescription().trim().isEmpty()){
			throw new KerenExecption("La Description de la Variable est obligatoire");
		}else if(entity.getDescription()==null||entity.getDescription().trim().isEmpty()){
			throw new KerenExecption("La Description de la Variable est obligatoire");
		}else if(entity.getTypevar()==null||entity.getTypevar().trim().isEmpty()){
			throw new KerenExecption("Le Type de la Variable est obligatoire");
		}else if(entity.getMethodcal()==null||entity.getMethodcal().trim().isEmpty()){
			throw new KerenExecption("La Methode de la Variable est obligatoire");
		}
		super.processBeforeUpdate(entity);
	}

	
	@Override
	public Variable evaluer(HttpHeaders headers, Variable entity) {
		// TODO Auto-generated method stub
	  try{
		Double valeur = moteurmanager.eval(entity, null, null, null,entity.getSociete());
		if(valeur<0){
			throw new KerenExecption("Echec de validation de la variable Vérifiez que : <br/> Les variables existent <br/> L'expression arithmétique est bien formées");
		}
		return entity;
	  }catch(KerenPaieManagerException ex){
		  throw new KerenExecption(ex.getMessage());
	  }
	}
    
    

}
