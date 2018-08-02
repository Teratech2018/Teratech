
package com.teratech.gmao.jaxrs.impl.budget;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.gmao.core.ifaces.budget.LigneBudgetSaisieManagerRemote;
import com.teratech.gmao.jaxrs.ifaces.budget.LigneBudgetSaisieRS;
import com.teratech.gmao.model.budget.BudgetDivision;
import com.teratech.gmao.model.budget.LigneBudgetSaisie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Sat Jul 21 12:58:35 GMT+01:00 2018
 * 
 */
@Path("/lignebudgetsaisie")
public class LigneBudgetSaisieRSImpl
    extends AbstractGenericService<LigneBudgetSaisie, Long>
    implements LigneBudgetSaisieRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechgmao", name = "LigneBudgetSaisieManagerImpl", interf = LigneBudgetSaisieManagerRemote.class)
    protected LigneBudgetSaisieManagerRemote manager;

    public LigneBudgetSaisieRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LigneBudgetSaisie, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechgmao");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            //To change body of generated methods, choose Tools | Templates.
            meta = MetaDataUtil.getMetaData(new LigneBudgetSaisie(), new HashMap<String, MetaData>(), new ArrayList<String>());
           
        } catch (InstantiationException ex) {
            Logger.getLogger(BudgetDivisionRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BudgetDivisionRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta;
    }

}
