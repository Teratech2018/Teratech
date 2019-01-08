
package com.teratech.vente.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.vente.core.ifaces.operations.BonLivraisonManagerRemote;
import com.teratech.vente.core.ifaces.operations.LIgneRetourClientManagerRemote;
import com.teratech.vente.jaxrs.ifaces.operations.LIgneRetourClientRS;
import com.teratech.vente.model.operations.BonLivraison;
import com.teratech.vente.model.operations.LIgneBonLivraison;
import com.teratech.vente.model.operations.LIgneRetourClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Sat Jan 05 17:28:33 WAT 2019
 * 
 */
@Path("/ligneretourclient")
public class LIgneRetourClientRSImpl
    extends AbstractGenericService<LIgneRetourClient, Long>
    implements LIgneRetourClientRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechvente", name = "LIgneRetourClientManagerImpl", interf = LIgneRetourClientManagerRemote.class)
    protected LIgneRetourClientManagerRemote manager;
    
    @Manager(application = "teratechvente", name = "BonLivraisonManagerImpl", interf = BonLivraisonManagerRemote.class)
    protected BonLivraisonManagerRemote blmanager;

    public LIgneRetourClientRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LIgneRetourClient, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechvente");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new LIgneRetourClient(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(LIgneRetourClientRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LIgneRetourClientRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LIgneRetourClient> filter(HttpHeaders headers, int firstResult, int maxResult) {
        Gson gson = new Gson();
        Long _id = null;
        if(headers.getRequestHeader("livraison")!=null 
                && !headers.getRequestHeader("livraison").isEmpty()){
            _id = gson.fromJson(headers.getRequestHeader("livraison").get(0), Long.class);
            List<LIgneRetourClient> lignes = new ArrayList<LIgneRetourClient>();
            BonLivraison bl = blmanager.find("id", _id);
            for(LIgneBonLivraison ligne:bl.getLignes()){
                lignes.add(new LIgneRetourClient(ligne));
            }//end for(LIgneBonLivraison ligne:bl.getLignes()){
            return lignes;
        }//end if(headers.getRequestHeader("livraison")!=null 
        return super.filter(headers, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
