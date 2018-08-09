
package com.kerenedu.jaxrs.impl.report;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.core.ifaces.report.ViewPaiementJournalierManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewPaiementJournalierRS;
import com.kerenedu.model.report.ViewPaiementJournalier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Sat Aug 04 14:08:54 WAT 2018
 * 
 */
@Path("/viewpaiementjournalier")
public class ViewPaiementJournalierRSImpl
    extends AbstractGenericService<ViewPaiementJournalier, Long>
    implements ViewPaiementJournalierRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ViewPaiementJournalierManagerImpl", interf = ViewPaiementJournalierManagerRemote.class)
    protected ViewPaiementJournalierManagerRemote manager;

    public ViewPaiementJournalierRSImpl() {
        super();
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new ViewPaiementJournalier(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		} catch (InstantiationException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		} catch (IllegalAccessException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		return null;
   	}


    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ViewPaiementJournalier, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }

}
