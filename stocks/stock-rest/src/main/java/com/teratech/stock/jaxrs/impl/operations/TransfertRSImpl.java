
package com.teratech.stock.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.stock.core.ifaces.operations.TransfertManagerRemote;
import com.teratech.stock.jaxrs.ifaces.operations.TransfertRS;
import com.teratech.stock.model.operations.Entree;
import com.teratech.stock.model.operations.LigneDocumentStock;
import com.teratech.stock.model.operations.Transfert;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Feb 20 15:00:50 GMT+01:00 2018
 * 
 */
@Path("/transfert")
public class TransfertRSImpl
    extends AbstractGenericService<Transfert, Long>
    implements TransfertRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechstock", name = "TransfertManagerImpl", interf = TransfertManagerRemote.class)
    protected TransfertManagerRemote manager;

    public TransfertRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Transfert, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechstock");
    }
    
      @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            return MetaDataUtil.getMetaData(new Transfert(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (Exception ex) {
            throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
        }
       
    }

    @Override
    protected void processBeforeUpdate(Transfert entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir le n° de pièce");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Veuillez saisir la date ");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement source"); 
        }else if(entity.getEmplcible()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement cible"); 
        } else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir la ligne du document"); 
        }
        //Traitement des ligne
        for(LigneDocumentStock ligne : entity.getLignes()){
            ligne.setTotalht(ligne.getPuht()*ligne.getQuantite());
        }//end for(LigneDocumentStock ligne : entity.getLignes()){
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(Transfert entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir le n° de pièce");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Veuillez saisir la date ");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement source"); 
        }else if(entity.getEmplcible()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement cible"); 
        } else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir la ligne du document"); 
        }
        //Traitement des ligne
        for(LigneDocumentStock ligne : entity.getLignes()){
            ligne.setTotalht(ligne.getPuht()*ligne.getQuantite());
        }//end for(LigneDocumentStock ligne : entity.getLignes()){
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
