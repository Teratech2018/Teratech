
package com.teratech.vente.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.vente.core.ifaces.operations.DevisManagerRemote;
import com.teratech.vente.core.ifaces.operations.LigneCommandeManagerRemote;
import com.teratech.vente.jaxrs.ifaces.operations.LigneCommandeRS;
import com.teratech.vente.model.operations.Devis;
import com.teratech.vente.model.operations.LigneCommande;
import com.teratech.vente.model.operations.LigneDevis;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Jan 04 13:43:20 WAT 2019
 * 
 */
@Path("/lignecommande")
public class LigneCommandeRSImpl
    extends AbstractGenericService<LigneCommande, Long>
    implements LigneCommandeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechvente", name = "LigneCommandeManagerImpl", interf = LigneCommandeManagerRemote.class)
    protected LigneCommandeManagerRemote manager;
    
    @Manager(application = "teratechvente", name = "DevisManagerImpl", interf = DevisManagerRemote.class)
    protected DevisManagerRemote devismanager;

    public LigneCommandeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LigneCommande, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechvente");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta=null;
        try {
            meta = MetaDataUtil.getMetaData(new LigneCommande(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(LigneCommandeRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LigneCommandeRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LigneCommande> filter(HttpHeaders headers, int firstResult, int maxResult) {
        Gson gson = new Gson();
        Long _id = null;
        if(headers.getRequestHeader("devis")!=null && !headers.getRequestHeader("devis").isEmpty()){
            _id = gson.fromJson(headers.getRequestHeader("devis").get(0), Long.class);
            Devis _devis = devismanager.find("id", _id);
            List<LigneCommande> datas = new ArrayList<LigneCommande>();
            for(LigneDevis ligne:_devis.getLignes()){
                datas.add(new LigneCommande(ligne));
            }//end for(LigneDevis ligne:_devis.getLignes()){
            return datas;
        }//end if(headers.getRequestHeader("devis")!=null && !headers.getRequestHeader("devis").isEmpty()){
        return super.filter(headers, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
