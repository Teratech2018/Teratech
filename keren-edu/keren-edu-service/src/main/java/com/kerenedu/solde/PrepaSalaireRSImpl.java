
package com.kerenedu.solde;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.app.BuilderHttpHeaders;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.TypeCacheMemory;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Oct 11 14:48:37 WAT 2018
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
    @Manager(application = "kereneducation", name = "PrepaSalaireManagerImpl", interf = PrepaSalaireManagerRemote.class)
    protected PrepaSalaireManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "MoteurPaieManagerImpl", interf = MoteurPaieManagerRemote.class)
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
        return ("kereneducation");
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
			throw new KerenExecption("OPERATION IMPOSSIBLE ::: La P&eacute;riode de Paie est obligatoire");
		}else if(entity.getPorte()==null||entity.getPorte().trim().isEmpty()){
			throw new KerenExecption("OPERATION IMPOSSIBLE ::: La Port&eacute;e de la Pr&eacute;paration est obligatoire");
		}else if(entity.getPeriode().getState().equals("etabli")){
			throw new KerenExecption("OPERATION IMPOSSIBLE ::: La P&eacute;riode n'est pas ouverte");
		}else if(entity.getPeriode().getState().equals("ferme")){
			throw new KerenExecption("OPERATION IMPOSSIBLE ::: La P&eacute;riode est d&eacute;jà Ferm&eacute; !!");
		}
		super.processBeforeSave(entity);
	}

	@Override
	public PrepaSalaire save(@Context HttpHeaders headers , PrepaSalaire entity) {
		// TODO Auto-generated method stub
		processBeforeSave(entity);
		entity = moteurmanager.preparerPaie(entity);
		CacheMemory.insert(BuilderHttpHeaders.getidUsers(headers), TypeCacheMemory.PERIODE, entity.getPeriode());
		processAfterSave(entity);
		return entity;
	}

	@Override
	public Response imprimer(HttpHeaders headers, PrepaSalaire dmde) {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}
