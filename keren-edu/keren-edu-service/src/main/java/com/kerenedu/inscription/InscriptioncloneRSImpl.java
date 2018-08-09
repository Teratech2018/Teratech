
package com.kerenedu.inscription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.model.report.ViewPaiementJournalier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Aug 08 06:03:36 WAT 2018
 * 
 */
@Path("/inscriptionclone")
public class InscriptioncloneRSImpl
    extends AbstractGenericService<Inscriptionclone, Long>
    implements InscriptioncloneRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "InscriptioncloneManagerImpl", interf = InscriptioncloneManagerRemote.class)
    protected InscriptioncloneManagerRemote manager;

    public InscriptioncloneRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Inscriptionclone, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new Inscriptionclone(), new HashMap<String, MetaData>(),new ArrayList<String>());
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
	public List<Inscriptionclone> filter(HttpHeaders headers, int firstResult, int maxResult) {

		String header = null;
		RestrictionsContainer container = null;
		if (headers.getRequestHeader("action_param") != null) {
			header = headers.getRequestHeader("action_param").get(0);
		}
		 System.out.println(InscriptionRSImpl.class.toString()+" ==================================== "+header);
		List<Inscriptionclone> datas = new ArrayList<Inscriptionclone>();
		List<Inscriptionclone> results = new ArrayList<Inscriptionclone>();
		// To change body of generated methods, choose Tools | Templates.
			 container = RestrictionsContainer.newInstance();
			 if(header!=null){
			container.addLike("eleve.nom", "%" + header);
			 }
			datas = manager.filter(container.getPredicats(), null, null, firstResult, maxResult);
			for (Inscriptionclone data : datas) {
				results.add(new Inscriptionclone(data));
			} // end for(CourrierTous data:datas){
		
		return results;
	}

}
