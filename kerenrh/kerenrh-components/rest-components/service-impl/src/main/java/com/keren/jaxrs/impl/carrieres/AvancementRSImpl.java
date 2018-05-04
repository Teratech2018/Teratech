
package com.keren.jaxrs.impl.carrieres;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.carrieres.AvancementManagerRemote;
import com.keren.jaxrs.ifaces.carrieres.AvancementRS;
import com.keren.model.carrieres.Avancement;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Apr 10 13:14:15 GMT+01:00 2018
 * 
 */
@Path("/avancement")
public class AvancementRSImpl
    extends AbstractGenericService<Avancement, Long>
    implements AvancementRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "AvancementManagerImpl", interf = AvancementManagerRemote.class)
    protected AvancementManagerRemote manager;

    public AvancementRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Avancement, Long> getManager() {
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
			meta = MetaDataUtil.getMetaData(new Avancement(), new HashMap<String, MetaData>()
			, new ArrayList<String>());
			MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
	        workbtn.setValue("{'model':'kerenrh','entity':'avancement','method':'valide'}");
	        workbtn.setStates(new String[]{"etabli"});
	        workbtn.setPattern("btn btn-success");
	        meta.getHeader().add(workbtn);  
//	        workbtn = new MetaColumn("button", "work1", "Annuler", false, "workflow", null);
//	        workbtn.setValue("{'model':'kerenrh','entity':'avancement','method':'annule'}");
//	        workbtn.setStates(new String[]{"etabli"});
//	        workbtn.setPattern("btn btn-danger");
//	        meta.getHeader().add(workbtn);   
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
	public Avancement delete(Long id) {
            // TODO Auto-generated method stub
            Avancement entity = manager.find("id", id);
            if(entity.getState().trim().equals("valide")){
                    throw new KerenExecption("Avancement déjà validé <br/>Suppresion impossible");
            }
            return super.delete(id);
	}

	@Override
	protected void processBeforeSave(Avancement entity) {
            // TODO Auto-generated method stub
            if(entity.getSalarie()==null){
                    throw new KerenExecption("L'employé concerné est obligatoire");
            }else if(entity.getCategorieN()==null){
                    throw new KerenExecption("La nouvelle catégorie est obligatoire");
            }else if(entity.getEchelonN()==null){
                    throw new KerenExecption("Le nouvelle échelon est obligatoire");
            }else if(entity.getDenreg()==null){
                    throw new KerenExecption("La date d'enregistrement est obligatoire");
            }
            

            entity.setState("etabli");
            super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(Avancement entity) {
            // TODO Auto-generated method stub
            if(entity.getSalarie()==null){
                    throw new KerenExecption("L'employé concerné est obligatoire");
            }else if(entity.getCategorieN()==null){
                    throw new KerenExecption("La nouvelle catégorie est obligatoire");
            }else if(entity.getEchelonN()==null){
                    throw new KerenExecption("Le nouvelle échelon est obligatoire");
            }else if(entity.getDenreg()==null){
                    throw new KerenExecption("La date d'enregistrement est obligatoire");
            }
            super.processBeforeUpdate(entity);
	}

	@Override
	public Avancement valide(HttpHeaders headers, Avancement entity) {
            // TODO Auto-generated method stub
            if(entity.getSalarie()==null){
                    throw new KerenExecption("L'employé concerné est obligatoire");
            }else if(entity.getCategorieN()==null){
                    throw new KerenExecption("La nouvelle catégorie est obligatoire");
            }else if(entity.getEchelonN()==null){
                    throw new KerenExecption("Le nouvelle échelon est obligatoire");
            }else if(entity.getDenreg()==null){
                    throw new KerenExecption("La date d'enregistrement est obligatoire");
            }else if(entity.getDeffet()==null){
                    throw new KerenExecption("La date de prise d'effet est obligatoire");
            }
            return manager.valide(entity);
	}

	@Override
	public Avancement annule(HttpHeaders headers, Avancement entity) {
            // TODO Auto-generated method stub
            return entity;
	}
    
    

}
