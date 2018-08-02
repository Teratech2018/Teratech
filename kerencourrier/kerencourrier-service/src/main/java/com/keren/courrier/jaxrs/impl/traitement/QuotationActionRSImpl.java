
package com.keren.courrier.jaxrs.impl.traitement;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.traitement.QuotationActionManagerRemote;
import com.keren.courrier.jaxrs.ifaces.traitement.QuotationActionRS;
import com.keren.courrier.jaxrs.impl.courrier.CourrierRSImpl;
import com.keren.courrier.model.traitement.QuotationAction;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Jul 26 18:00:19 GMT+01:00 2018
 * 
 */
@Path("/quotationaction")
public class QuotationActionRSImpl
    extends AbstractGenericService<QuotationAction, Long>
    implements QuotationActionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "QuotationActionManagerImpl", interf = QuotationActionManagerRemote.class)
    protected QuotationActionManagerRemote manager;

    public QuotationActionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<QuotationAction, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }

     @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new QuotationAction(), new HashMap<String, MetaData>(), new ArrayList<String>());
//            MetaColumn workbtn = new MetaColumn("button", "work1", "Distribuer", false, "workflow", null);
//            workbtn.setValue("{'model':'kerencourrier','entity':'courrier','method':'distribuer'}");
//            workbtn.setStates(new String[]{"etabli","valide"});
////            workbtn.setPattern("btn btn-primary");
//            meta.getHeader().add(workbtn);  
            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
            meta.getHeader().add(stautsbar);	       
        } catch (InstantiationException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }
    
}
