
package com.keren.jaxrs.impl.carrieres;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.carrieres.RetrogradationManagerRemote;
import com.keren.jaxrs.ifaces.carrieres.RetrogradationRS;
import com.keren.model.carrieres.Nomination;
import com.keren.model.carrieres.Retrogradation;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 13:14:15 GMT+01:00 2018
 * 
 */
@Path("/retrogradation")
public class RetrogradationRSImpl
    extends AbstractGenericService<Retrogradation, Long>
    implements RetrogradationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "RetrogradationManagerImpl", interf = RetrogradationManagerRemote.class)
    protected RetrogradationManagerRemote manager;

    public RetrogradationRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Retrogradation, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		MetaData meta = null;
   		try {
   			meta = MetaDataUtil.getMetaData(new Retrogradation(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'retrogradation','method':'valide'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-success");
   	        meta.getHeader().add(workbtn);  
//   	        workbtn = new MetaColumn("button", "work1", "Annuler", false, "workflow", null);
//   	        workbtn.setValue("{'model':'kerenrh','entity':'retrogradation','method':'annule'}");
//   	        workbtn.setStates(new String[]{"etabli"});
//   	        workbtn.setPattern("btn btn-danger");
//   	        meta.getHeader().add(workbtn);   
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
	protected void processBeforeDelete(Object id) {
		// TODO Auto-generated method stub
		Retrogradation entity = manager.find("id", (Long) id);
		if(entity.getState().trim().equalsIgnoreCase("valide")){
			throw new KerenExecption("Retrogradation déjà validé ");
		}
		super.processBeforeDelete(id);
	}

	@Override
	protected void processBeforeSave(Retrogradation entity) {
		// TODO Auto-generated method stub
		if(entity.getSalarie()==null){
			throw new KerenExecption("L'Employé est obligatoire");
		}else if(entity.getCategorieA()==null){
			throw new KerenExecption("L'Encien catégorie est obligatoire");
		}else if(entity.getCategorieN()==null){
			throw new KerenExecption("La nouvelle catégorie est obligatoire");
		}else if(entity.getEchelonA()==null){
			throw new KerenExecption("L'Encien Echelon est obligatoire");
		}else if(entity.getEchelonN()==null){
			throw new KerenExecption("Le nouveau Echelon est obligatoire");
		}else if(entity.getDenreg()==null){
			throw new KerenExecption("La date d'enregistrement est obligatoire");
		}
		entity.setState("etabli");
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(Retrogradation entity) {
		// TODO Auto-generated method stub
		if(entity.getSalarie()==null){
			throw new KerenExecption("L'Employé est obligatoire");
		}else if(entity.getCategorieA()==null){
			throw new KerenExecption("L'Encien catégorie est obligatoire");
		}else if(entity.getCategorieN()==null){
			throw new KerenExecption("La nouvelle catégorie est obligatoire");
		}else if(entity.getEchelonA()==null){
			throw new KerenExecption("L'Encien Echelon est obligatoire");
		}else if(entity.getEchelonN()==null){
			throw new KerenExecption("Le nouveau Echelon est obligatoire");
		}else if(entity.getDenreg()==null){
			throw new KerenExecption("La date d'enregistrement est obligatoire");
		}
		super.processBeforeUpdate(entity);
	}

	@Override
	public Retrogradation valide(HttpHeaders headers, Retrogradation entity) {
		// TODO Auto-generated method stub
		if(entity.getSalarie()==null){
			throw new KerenExecption("L'Employé est obligatoire");
		}else if(entity.getCategorieA()==null){
			throw new KerenExecption("L'Encien catégorie est obligatoire");
		}else if(entity.getCategorieN()==null){
			throw new KerenExecption("La nouvelle catégorie est obligatoire");
		}else if(entity.getEchelonA()==null){
			throw new KerenExecption("L'Encien Echelon est obligatoire");
		}else if(entity.getEchelonN()==null){
			throw new KerenExecption("Le nouveau Echelon est obligatoire");
		}else if(entity.getDenreg()==null){
			throw new KerenExecption("La date d'enregistrement est obligatoire");
		}else if(entity.getDeffet()==null){
			throw new KerenExecption("La date de prise d'effet est obligatoire");
		}
		return manager.valide(entity);
	}

	@Override
	public Retrogradation annule(HttpHeaders headers, Retrogradation entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
