
package com.teratech.achat.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.achat.core.ifaces.operations.BonReceptionManagerRemote;
import com.teratech.achat.core.ifaces.operations.LigneSortieManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.LigneSortieRS;
import com.teratech.achat.model.operations.BonReception;
import com.teratech.achat.model.operations.LigneEntree;
import com.teratech.achat.model.operations.LigneSortie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Jan 03 09:08:06 WAT 2019
 * 
 */
@Path("/lignesortie")
public class LigneSortieRSImpl
    extends AbstractGenericService<LigneSortie, Long>
    implements LigneSortieRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "LigneSortieManagerImpl", interf = LigneSortieManagerRemote.class)
    protected LigneSortieManagerRemote manager;
    
    @Manager(application = "teratechachat", name = "BonReceptionManagerImpl", interf = BonReceptionManagerRemote.class)
    protected BonReceptionManagerRemote brmanager;

    public LigneSortieRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LigneSortie, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new LigneSortie(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(LigneSortieRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LigneSortieRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  meta; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LigneSortie> filter(HttpHeaders headers, int firstResult, int maxResult) {
        List<LigneSortie> result = new ArrayList<LigneSortie>();
        Gson gson = new Gson();
        Long _id = null;
        if(headers.getRequestHeader("bonlivraison")!=null 
                && !headers.getRequestHeader("bonlivraison").isEmpty()){
            _id = gson.fromJson(headers.getRequestHeader("bonlivraison").get(0), Long.class);
            BonReception bon = brmanager.find("id", _id);
            for(LigneEntree ligne:bon.getLignes()){
                result.add(new LigneSortie(ligne));
            }//end  for(LigneEntree ligne:bon.getLignes()){
        }//end if(headers.getRequestHeader("bonlivraison")!=null 
        return result;//To change body of generated methods, choose Tools | Templates.
    }
    
    

}
