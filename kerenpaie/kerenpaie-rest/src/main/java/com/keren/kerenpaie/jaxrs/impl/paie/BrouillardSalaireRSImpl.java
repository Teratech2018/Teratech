
package com.keren.kerenpaie.jaxrs.impl.paie;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.paie.MoteurPaieManagerRemote;
import com.keren.kerenpaie.core.ifaces.paie.PrepaSalaireManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.paie.PrepaSalaireRS;
import com.keren.kerenpaie.model.paie.PrepaSalaire;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Mar 08 16:41:23 GMT+01:00 2018
 * 
 */
@Path("/brouillardsalaire")
public class BrouillardSalaireRSImpl
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

    public BrouillardSalaireRSImpl() {
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
		MetaData meta =null;
		try {
			 meta = MetaDataUtil.getMetaData(new PrepaSalaire(), new HashMap<String, MetaData>()
					, new ArrayList<String>());
			 for(MetaColumn col:meta.getColumns()){
				 if(col.getFieldName().equalsIgnoreCase("periode")){
					 col.setHide(true);
				 }
			 }//end for(MetaColumn col:meta.getColumns()){
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
	public Response imprimer(HttpHeaders headers, PrepaSalaire dmde) {
		// TODO Auto-generated method stub
		throw new KerenExecption("En cours d'implementation");
	}
    
    

}
