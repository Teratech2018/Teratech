
package com.keren.kerenpaie.jaxrs.impl.comptabilite;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.comptabilite.PeriodePaieCloseManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.comptabilite.PeriodePaieCloseRS;
import com.keren.kerenpaie.model.comptabilite.PeriodePaieClose;
import com.keren.kerenpaie.model.comptabilite.PeriodePaieOpen;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Mar 08 15:05:28 GMT+01:00 2018
 * 
 */
@Path("/periodepaieclose")
public class PeriodePaieCloseRSImpl
    extends AbstractGenericService<PeriodePaieClose, Long>
    implements PeriodePaieCloseRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "PeriodePaieCloseManagerImpl", interf = PeriodePaieCloseManagerRemote.class)
    protected PeriodePaieCloseManagerRemote manager;

    public PeriodePaieCloseRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<PeriodePaieClose, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			return MetaDataUtil.getMetaData(new PeriodePaieOpen(), new HashMap<String, MetaData>()
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

}
