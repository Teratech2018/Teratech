
package com.keren.kerenpaie.jaxrs.impl.paie;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.paie.CacheMemory;
import com.keren.kerenpaie.core.ifaces.paie.MoteurPaieManagerRemote;
import com.keren.kerenpaie.core.ifaces.paie.PrepaSalaireManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.paie.PrepaSalaireRS;
import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.paie.PrepaSalaire;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import javax.ws.rs.core.Context;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Mar 08 16:41:23 GMT+01:00 2018
 * 
 */
@Path("/prepasalaire")
public class PrepaSalaireRSImpl
    extends AbstractGenericService<PrepaSalaire, Long>
    implements PrepaSalaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "PrepaSalaireManagerImpl", interf = PrepaSalaireManagerRemote.class)
    protected PrepaSalaireManagerRemote manager;
    
    @Manager(application = "kerenpaie", name = "MoteurPaieManagerImpl", interf = MoteurPaieManagerRemote.class)
    protected MoteurPaieManagerRemote moteurmanager;

    public PrepaSalaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<PrepaSalaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			return MetaDataUtil.getMetaData(new PrepaSalaire(), new HashMap<String, MetaData>()
					, new ArrayList<String>());
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
	protected void processBeforeSave(PrepaSalaire entity) {
		// TODO Auto-generated method stub
		if(entity.getPeriode()==null){
			throw new KerenExecption("La Période de Paie est obligatoire");
		}else if(entity.getPorte()==null||entity.getPorte().trim().isEmpty()){
			throw new KerenExecption("La Portée de la Préparation est obligatoire");
		}else if(!entity.getPeriode().getState().equals("ouvert")){
			throw new KerenExecption("La Période n'est pas ouverte");
		}
		super.processBeforeSave(entity);
	}

	@Override
	public PrepaSalaire save(@Context HttpHeaders headers , PrepaSalaire entity) {
		// TODO Auto-generated method stub
		processBeforeSave(entity);
		entity = moteurmanager.preparerPaie(entity);
		CacheMemory.setPeriode(entity.getPeriode());
		processAfterSave(entity);
		return entity;
	}

	@Override
	public Response imprimer(HttpHeaders headers, PrepaSalaire dmde) {
		// TODO Auto-generated method stub
		return null;
	}
    
    
        

}
