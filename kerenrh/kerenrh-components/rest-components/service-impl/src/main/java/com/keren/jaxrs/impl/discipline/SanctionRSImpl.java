
package com.keren.jaxrs.impl.discipline;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.commons.DateHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.discipline.SanctionManagerRemote;
import com.keren.jaxrs.ifaces.discipline.SanctionRS;
import com.keren.model.discipline.ConvocationConseil;
import com.keren.model.discipline.Sanction;
import com.keren.model.presences.FichePointage;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import javax.ws.rs.core.Context;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Feb 16 11:11:48 GMT+01:00 2018
 * 
 */
@Path("/sanction")
public class SanctionRSImpl
    extends AbstractGenericService<Sanction, Long>
    implements SanctionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "SanctionManagerImpl", interf = SanctionManagerRemote.class)
    protected SanctionManagerRemote manager;

    public SanctionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Sanction, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			return MetaDataUtil.getMetaData(new Sanction(), new HashMap<String, MetaData>()
					, new ArrayList<String>());
		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		}
	}
    
    @Override
    public Sanction delete(@Context HttpHeaders headers , Long id) {
        
        //Initialisation
        Sanction data = null;
        Sanction result = null;
        
        try{
        
            data = super.delete(headers,id);
            result = new Sanction(data);
            
        }catch(Exception e){
            
            throw new KerenExecption("Suppression impossible, car cette Sanction est dejà en cours d'utilisation par d'autres objets !");
        }
        
        return result; //To change body of generated methods, choose Tools | Templates.
    }    
        
	@Override
	protected void processBeforeSave(Sanction entity) {
		// TODO Auto-generated method stub
		if(entity.getSanction()==null||entity.getSanction().trim().isEmpty()){
			throw new KerenExecption("La sanction retenue est obligatoire");
		}else if(entity.getDemande()==null){
			throw new KerenExecption("La Demande concernée est obligatoire");
		}else if(entity.getDateeffet()==null){
			throw new KerenExecption("La Date d'effet est obligatoire");
		}else if(entity.getDateeffet().before(entity.getDemande().getDaten())){
			throw new KerenExecption("La date d'effet ne peut être anterieur à la date de notificacation"
                                + " \n de la demande d'explication ( "+DateHelper.convertToString(entity.getDemande().getDaten(), "dd/MM/yyyy")+" )");
		}
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(Sanction entity) {
		// TODO Auto-generated method stub
		if(entity.getSanction()==null||entity.getSanction().trim().isEmpty()){
			throw new KerenExecption("La sanction retenue est obligatoire");
		}else if(entity.getDemande()==null){
			throw new KerenExecption("La Demande concernée est obligatoire");
		}else if(entity.getDateeffet()==null){
			throw new KerenExecption("La Date d'effet est obligatoire");
		}else if(entity.getDateeffet().before(entity.getDemande().getDaten())){
			throw new KerenExecption("La date d'effet ne peut être anterieur à la date de notificacation"
                                + " \n de la demande d'explication ( "+DateHelper.convertToString(entity.getDemande().getDaten(), "dd/MM/yyyy")+" )");
		}
		super.processBeforeUpdate(entity);
	}
    
    

}
