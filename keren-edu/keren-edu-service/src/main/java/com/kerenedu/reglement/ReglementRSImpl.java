
package com.kerenedu.reglement;

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
 * @since Tue Mar 06 16:43:59 CET 2018
 * 
 */
@Path("/reglement")
public class ReglementRSImpl
    extends AbstractGenericService<Reglement, Long>
    implements ReglementRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ReglementManagerImpl", interf = ReglementManagerRemote.class)
    protected ReglementManagerRemote manager;

    public ReglementRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Reglement, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			MetaData meta = MetaDataUtil.getMetaData(new Reglement(), new HashMap<String, MetaData>(),new ArrayList<String>());
   			MetaColumn col = new MetaColumn("button", "paiement", "Paiement des frais", false, "action", null);
			col.setValue("{'name':'keren_education_paie_limit','template':{'eleve':'object.eleve'}}");
			
			MetaColumn col1 = new MetaColumn("button", "echeancier", "Echéancier de paiement", false, "action", null);
			col1.setValue("{'name':'keren_education_paie_ech','template':{'eleve':'object'}}");
			
			meta.getHeader().add(col);
			//meta.getHeader().add(col1);
			
//			MetaColumn workbtn = new MetaColumn("button", "work1", "Paiement des Frais", false, "object", null);
//			workbtn.setValue("{'model':'kereneducation','entity':'paiement','method':'paiement','template':{'this':'object'}}");
//			workbtn.setStates(new String[] { "etabli" });
//			meta.getHeader().add(workbtn);
			MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
			meta.getHeader().add(stautsbar);
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
