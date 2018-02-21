
package com.teratech.stock.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.stock.core.ifaces.operations.EntreeManagerRemote;
import com.teratech.stock.jaxrs.ifaces.operations.EntreeRS;
import com.teratech.stock.model.operations.Entree;
import com.teratech.stock.model.operations.LigneDocumentStock;
import com.teratech.stock.model.operations.Lot;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Feb 20 13:26:04 GMT+01:00 2018
 * 
 */
@Path("/entree")
public class EntreeRSImpl
    extends AbstractGenericService<Entree, Long>
    implements EntreeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechstock", name = "EntreeManagerImpl", interf = EntreeManagerRemote.class)
    protected EntreeManagerRemote manager;

    public EntreeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Entree, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechstock");
    }
    
      @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            return MetaDataUtil.getMetaData(new Entree(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (Exception ex) {
            throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
        }
       
    }

    @Override
    protected void processBeforeDelete(Object entity) {
        super.processBeforeDelete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeUpdate(Entree entity) {
       if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir le n° de pièce");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Veuillez saisir la date ");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement"); 
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir la ligne du document"); 
        }
        //Traitement des ligne
        for(LigneDocumentStock ligne : entity.getLignes()){
            ligne.setTotalht(ligne.getPuht()*ligne.getQuantite());
        }//end for(LigneDocumentStock ligne : entity.getLignes()){
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(Entree entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir le n° de pièce");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Veuillez saisir la date ");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement"); 
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir la ligne du document"); 
        }
        //Traitement des ligne
        for(LigneDocumentStock ligne : entity.getLignes()){
            ligne.setTotalht(ligne.getPuht()*ligne.getQuantite());
        }//end for(LigneDocumentStock ligne : entity.getLignes()){
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
