
package com.keren.jaxrs.impl.carrieres;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.carrieres.BonificationManagerRemote;
import com.keren.jaxrs.ifaces.carrieres.BonificationRS;
import com.keren.model.carrieres.Reclassement;
import com.keren.model.carrieres.Bonification;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 13:14:15 GMT+01:00 2018
 * 
 */
@Path("/bonification")
public class BonificationRSImpl
    extends AbstractGenericService<Bonification, Long>
    implements BonificationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "BonificationManagerImpl", interf = BonificationManagerRemote.class)
    protected BonificationManagerRemote manager;

    public BonificationRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Bonification, Long> getManager() {
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
   			meta = MetaDataUtil.getMetaData(new Bonification(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'bonification','method':'valide'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-success");
   	        meta.getHeader().add(workbtn);  
//   	        workbtn = new MetaColumn("button", "work1", "Annuler", false, "workflow", null);
//   	        workbtn.setValue("{'model':'kerenrh','entity':'bonification','method':'annule'}");
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
		Bonification entity = manager.find("id", (Long) id);
		if(!entity.getState().trim().equalsIgnoreCase("etabli")){
			throw new KerenExecption("Bonification déjà validé");
		}
		super.processBeforeDelete(id);
	}

	@Override
	protected void processBeforeSave(Bonification entity) {
		// TODO Auto-generated method stub
		if(entity.getSalarie()==null){
			throw new KerenExecption("L'employé est obligatoire");
		}else if(entity.getEchelonN()==null){
			throw new KerenExecption("Le nouveau Echelon est obligatoire");
		}else if(entity.getDenreg()==null){
			throw new KerenExecption("La date d'enregistrement est obligatoire");
		}
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(Bonification entity) {
		// TODO Auto-generated method stub
		if(entity.getSalarie()==null){
			throw new KerenExecption("L'employé est obligatoire");
		}else if(entity.getEchelonN()==null){
			throw new KerenExecption("Le nouveau Echelon est obligatoire");
		}else if(entity.getDenreg()==null){
			throw new KerenExecption("La date d'enregistrement est obligatoire");
		}
		super.processBeforeUpdate(entity);
	}

	@Override
	public Bonification valide(HttpHeaders headers, Bonification entity) {
		// TODO Auto-generated method stub
		if(entity.getSalarie()==null){
			throw new KerenExecption("L'employé est obligatoire");
		}else if(entity.getEchelonN()==null){
			throw new KerenExecption("Le nouveau Echelon est obligatoire");
		}else if(entity.getDenreg()==null){
			throw new KerenExecption("La date d'enregistrement est obligatoire");
		}else if(entity.getDeffet()==null){
			throw new KerenExecption("La date date de prise d'effet est obligatoire");
		}
		return manager.valide(entity);
	}

	@Override
	public Bonification annule(HttpHeaders headers, Bonification entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
