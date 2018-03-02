
package com.teratech.stock.jaxrs.impl.invetaire;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.stock.core.ifaces.invetaire.RegulInventaireManagerRemote;
import com.teratech.stock.jaxrs.ifaces.invetaire.RegulInventaireRS;
import com.teratech.stock.model.invetaire.FicheInventaire;
import com.teratech.stock.model.invetaire.RegulInventaire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Feb 20 19:29:55 GMT+01:00 2018
 * 
 */
@Path("/regulinventaire")
public class RegulInventaireRSImpl
    extends AbstractGenericService<RegulInventaire, Long>
    implements RegulInventaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechstock", name = "RegulInventaireManagerImpl", interf = RegulInventaireManagerRemote.class)
    protected RegulInventaireManagerRemote manager;

    public RegulInventaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<RegulInventaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechstock");
    }
    
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            MetaData meta = MetaDataUtil.getMetaData(new RegulInventaire(), new HashMap<String, MetaData>(), new ArrayList<String>()); //To change body of generated methods, choose Tools | Templates.
            MetaColumn workbtn = new MetaColumn("button", "work1", "Cloturer l'inventaire", false, "workflow", null);
            workbtn.setValue("{'model':'teratechstock','entity':'regulinventaire','method':'confirme'}");
            workbtn.setStates(new String[]{"confirme"});
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work1", "Imprimer la fiche d'inventaire", false, "report", null);
            workbtn.setValue("{'model':'teratechstock','entity':'regulinventaire','method':'print'}");
            meta.getHeader().add(workbtn);
            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
            meta.getHeader().add(stautsbar);
            return meta;
        } catch (InstantiationException ex) {
            Logger.getLogger(FicheInventaireRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FicheInventaireRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public RegulInventaire confirmer(HttpHeaders headers, RegulInventaire dmde) {
        //To change body of generated methods, choose Tools | Templates.
        return dmde;
    }

    @Override
    public Response print(HttpHeaders headers, RegulInventaire dmde) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
