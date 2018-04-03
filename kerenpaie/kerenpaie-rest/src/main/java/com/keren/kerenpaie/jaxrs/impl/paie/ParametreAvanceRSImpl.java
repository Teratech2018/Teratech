
package com.keren.kerenpaie.jaxrs.impl.paie;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.paie.ParametreAvanceManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.paie.ParametreAvanceRS;
import com.keren.kerenpaie.model.paie.ParametreAvance;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Mar 23 14:48:54 GMT+01:00 2018
 * 
 */
@Path("/parametreavance")
public class ParametreAvanceRSImpl
    extends AbstractGenericService<ParametreAvance, Long>
    implements ParametreAvanceRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "ParametreAvanceManagerImpl", interf = ParametreAvanceManagerRemote.class)
    protected ParametreAvanceManagerRemote manager;

    public ParametreAvanceRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ParametreAvance, Long> getManager() {
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
			meta = MetaDataUtil.getMetaData(new ParametreAvance(), new HashMap<String, MetaData>(), new ArrayList<String>());
			MetaColumn workbtn = new MetaColumn("button", "work1", "Générer La Pondération", false, "workflow", null);
	        workbtn.setValue("{'model':'kerenpaie','entity':'parametreavance','method':'genere'}");
	        workbtn.setStates(new String[]{"etabli"});
	        workbtn.setPattern("btn btn-primary");
	        meta.getHeader().add(workbtn);  
			workbtn = new MetaColumn("button", "work1", "Activer", false, "workflow", null);
	        workbtn.setValue("{'model':'kerenpaie','entity':'parametreavance','method':'actif'}");
	        workbtn.setStates(new String[]{"etabli"});
	        workbtn.setPattern("btn btn-success");
	        meta.getHeader().add(workbtn);   
	        workbtn = new MetaColumn("button", "work2", "Désactiver", false, "workflow", null);
	        workbtn.setValue("{'model':'kerenpaie','entity':'parametreavance','method':'inactif'}");
	        workbtn.setStates(new String[]{"etabli"});
	        workbtn.setPattern("btn btn-danger");
	        meta.getHeader().add(workbtn);   
	        MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
	        meta.getHeader().add(stautsbar);	       
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
	protected void processBeforeDelete(Object entity) {
		// TODO Auto-generated method stub		
		super.processBeforeDelete(entity);
	}

	@Override
	protected void processBeforeSave(ParametreAvance entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null){
			throw new KerenExecption("La Reference est obligatoire");
		}else if(entity.getType()==null){
			throw new KerenExecption("Le type de Parametrage est obligatoire");
		}else if(entity.getType().equalsIgnoreCase("0")){
			if(entity.getFonctions()==null||entity.getFonctions().isEmpty()){
				throw new KerenExecption("Aucne Pondération n'est définie");
			}
		}else if(entity.getType().equalsIgnoreCase("1")){
			if(entity.getTypescontrats()==null||entity.getTypescontrats().isEmpty()){
				throw new KerenExecption("Aucne Pondération n'est définie");
			}
		}
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(ParametreAvance entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null){
			throw new KerenExecption("La Reference est obligatoire");
		}else if(entity.getType()==null){
			throw new KerenExecption("Le type de Parametrage est obligatoire");
		}else if(entity.getType().equalsIgnoreCase("0")){
			if(entity.getFonctions()==null||entity.getFonctions().isEmpty()){
				throw new KerenExecption("Aucne Pondération n'est définie");
			}
		}else if(entity.getType().equalsIgnoreCase("1")){
			if(entity.getTypescontrats()==null||entity.getTypescontrats().isEmpty()){
				throw new KerenExecption("Aucne Pondération n'est définie");
			}
		}
		super.processBeforeUpdate(entity);
	}

	@Override
	public ParametreAvance actif(HttpHeaders headers, ParametreAvance entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null){
			throw new KerenExecption("La Reference est obligatoire");
		}else if(entity.getType()==null){
			throw new KerenExecption("Le type de Parametrage est obligatoire");
		}else if(entity.getType().equalsIgnoreCase("0")){
			if(entity.getFonctions()==null||entity.getFonctions().isEmpty()){
				throw new KerenExecption("Aucne Pondération n'est définie");
			}
		}else if(entity.getType().equalsIgnoreCase("1")){
			if(entity.getTypescontrats()==null||entity.getTypescontrats().isEmpty()){
				throw new KerenExecption("Aucne Pondération n'est définie");
			}
		}
		if(entity.getId()<=0){
			throw new KerenExecption("Le paramétrage avancé "+entity.getDesignation()+" est introuvable <br/> Veuillez sauvegarder et Réessayer");
		}//end if(entity.getId()<=0)
		return manager.actif(entity);
	}

	@Override
	public ParametreAvance inactif(HttpHeaders headers, ParametreAvance entity) {
		// TODO Auto-generated method stub		
		if(entity.getCode()==null){
			throw new KerenExecption("La Reference est obligatoire");
		}else if(entity.getType()==null){
			throw new KerenExecption("Le type de Parametrage est obligatoire");
		}else if(entity.getType().equalsIgnoreCase("0")){
			if(entity.getFonctions()==null||entity.getFonctions().isEmpty()){
				throw new KerenExecption("Aucne Pondération n'est définie");
			}
		}else if(entity.getType().equalsIgnoreCase("1")){
			if(entity.getTypescontrats()==null||entity.getTypescontrats().isEmpty()){
				throw new KerenExecption("Aucne Pondération n'est définie");
			}
		}
		if(entity.getId()<=0){
			throw new KerenExecption("Le paramétrage avancé "+entity.getDesignation()+" est introuvable <br/> Veuillez sauvegarder et Réessayer");
		}//end if(entity.getId()<=0)
		return manager.inactif(entity);
	}

	@Override
	public ParametreAvance genere(HttpHeaders headers, ParametreAvance entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null){
			throw new KerenExecption("La Reference est obligatoire");
		}else if(entity.getType()==null){
			throw new KerenExecption("Le type de Parametrage est obligatoire");
		}
		
		return manager.genere(entity);
	}
    
    

}
