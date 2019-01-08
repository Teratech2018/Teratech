
package com.teratech.achat.jaxrs.impl.tools;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.achat.core.ifaces.operations.ExprBesionManagerRemote;
import com.teratech.achat.core.ifaces.tools.DARejetManagerRemote;
import com.teratech.achat.jaxrs.ifaces.tools.DARejetRS;
import com.teratech.achat.model.operations.ExprBesion;
import com.teratech.achat.model.tools.DARejet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Dec 21 15:08:09 WAT 2018
 * 
 */
@Path("/darejet")
public class DARejetRSImpl
    extends AbstractGenericService<DARejet, Long>
    implements DARejetRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "DARejetManagerImpl", interf = DARejetManagerRemote.class)
    protected DARejetManagerRemote manager;
    
    @Manager(application = "teratechachat", name = "ExprBesionManagerImpl", interf = ExprBesionManagerRemote.class)
    protected ExprBesionManagerRemote damanager;

    public DARejetRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<DARejet, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new DARejet(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(DARejetRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DARejetRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

    /***
     * 
     * @param headers
     * @param entity
     * @return 
     */
    @Override
    public DARejet save(HttpHeaders headers, DARejet entity) {
        ExprBesion besion = entity.getDemande();
        if(entity.getMotif()==null || entity.getMotif().trim().isEmpty()){
            throw new KerenExecption("Veuillez motiver le rejet");
        }
        if(!besion.getState().equalsIgnoreCase("etabli")){
            throw new KerenExecption("Verifier que la demande n'a pas encore fait l'objet d'un rejet");
        }//end if(!besion.getState().equalsIgnoreCase("etabli")){
        besion.setState("rejete");
        besion.setReponse(entity.getMotif());
        damanager.update(besion.getId(), besion);
        return entity; //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
