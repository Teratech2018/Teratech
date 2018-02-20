
package com.kerenedu.school;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Dec 28 15:02:40 WAT 2017
 * 
 */
@Path("/eleve")
public class EleveRSImpl
    extends AbstractGenericService<Eleve, Long>
    implements EleveRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "EleveManagerImpl", interf = EleveManagerRemote.class)
    protected EleveManagerRemote manager;

    public EleveRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Eleve, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }

    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			MetaColumn col = new MetaColumn("button", "paiementfrais", "Paiement des frais", false, "action", null);
			col.setValue("{'name':'keren_education_paie','template':{'eleve':'object'}}");

			MetaColumn col2 = new MetaColumn("button", "abscence", "Abscence", false, "action", null);
			col2.setValue("{'name':'keren_education_abs','template':{'eleveList':'object'}}");
			
			MetaData meta =  MetaDataUtil.getMetaData(new Eleve(), new HashMap<String, MetaData>(),new ArrayList<String>());
			meta.getHeader().add(col);
			meta.getHeader().add(col2);
			return meta;
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
