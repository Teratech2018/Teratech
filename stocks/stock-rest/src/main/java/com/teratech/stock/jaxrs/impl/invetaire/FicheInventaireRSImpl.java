
package com.teratech.stock.jaxrs.impl.invetaire;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.stock.core.ifaces.invetaire.FicheInventaireManagerRemote;
import com.teratech.stock.jaxrs.ifaces.invetaire.FicheInventaireRS;
import com.teratech.stock.model.invetaire.FicheInventaire;
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
@Path("/ficheinventaire")
public class FicheInventaireRSImpl
    extends AbstractGenericService<FicheInventaire, Long>
    implements FicheInventaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechstock", name = "FicheInventaireManagerImpl", interf = FicheInventaireManagerRemote.class)
    protected FicheInventaireManagerRemote manager;

    public FicheInventaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<FicheInventaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechstock");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            MetaData meta = MetaDataUtil.getMetaData(new FicheInventaire(), new HashMap<String, MetaData>(), new ArrayList<String>()); //To change body of generated methods, choose Tools | Templates.
            MetaColumn workbtn = new MetaColumn("button", "work1", "Démarrer l'inventaire", false, "workflow", null);
            workbtn.setValue("{'model':'teratechstock','entity':'ficheinventaire','method':'confirme'}");
            workbtn.setStates(new String[]{"etabli"});
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work1", "Imprimer la fiche d'inventaire", false, "report", null);
            workbtn.setValue("{'model':'teratechstock','entity':'ficheinventaire','method':'print'}");
            meta.getHeader().add(workbtn);
            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
            meta.getHeader().add(stautsbar);
            return meta ;
        } catch (InstantiationException ex) {
            Logger.getLogger(FicheInventaireRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FicheInventaireRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    protected void processBeforeUpdate(FicheInventaire entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez renseigner le champs reference");
        }else if(entity.getDateinventaire()==null){
            throw new KerenExecption("Veuillez renseigner la date d'inventaire");
        }else if(entity.getFentrepot()==null&&entity.getFemplacement()==null){
            throw new KerenExecption("Veuillez renseigner le dépôt et (ou) l'emplacement ");
        }
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(FicheInventaire entity) {
         if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez renseigner le champs reference");
        }else if(entity.getDateinventaire()==null){
            throw new KerenExecption("Veuillez renseigner la date d'inventaire");
        }else if(entity.getFentrepot()==null&&entity.getFemplacement()==null){
            throw new KerenExecption("Veuillez renseigner le dépôt et (ou) l'emplacement ");
        }
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FicheInventaire confirmer(HttpHeaders headers, FicheInventaire dmde) {
         //To change body of generated methods, choose Tools | Templates.
        return dmde;
    }

    @Override
    public Response print(HttpHeaders headers, FicheInventaire dmde) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
