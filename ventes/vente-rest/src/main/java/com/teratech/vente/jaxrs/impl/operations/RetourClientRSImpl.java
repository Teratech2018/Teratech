
package com.teratech.vente.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.vente.core.ifaces.operations.BonLivraisonManagerRemote;
import com.teratech.vente.core.ifaces.operations.RetourClientManagerRemote;
import com.teratech.vente.jaxrs.ifaces.operations.RetourClientRS;
import com.teratech.vente.model.operations.BonLivraison;
import com.teratech.vente.model.operations.LIgneRetourClient;
import com.teratech.vente.model.operations.RetourClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Sat Jan 05 17:03:34 WAT 2019
 * 
 */
@Path("/retourclient")
public class RetourClientRSImpl
    extends AbstractGenericService<RetourClient, Long>
    implements RetourClientRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechvente", name = "RetourClientManagerImpl", interf = RetourClientManagerRemote.class)
    protected RetourClientManagerRemote manager;
    
    @Manager(application = "teratechvente", name = "BonLivraisonManagerImpl", interf = BonLivraisonManagerRemote.class)
    protected BonLivraisonManagerRemote blmanager;
    
    

    public RetourClientRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<RetourClient, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechvente");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new RetourClient(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(RetourClientRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RetourClientRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeUpdate(RetourClient entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ N° de Pièce est obligatoire");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Le cham Date document est obligatoire");
        }
        canSatisfied(entity);
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(RetourClient entity) {
         if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ N° de Pièce est obligatoire");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Le cham Date document est obligatoire");
        }
         canSatisfied(entity);
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void canSatisfied(RetourClient entity){
        if(entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez fournir les articles retournés");
        }//end if(entity.getLignes().isEmpty()){
        BonLivraison bl = blmanager.find("id", entity.getLivraison().getId());
        for(LIgneRetourClient ligne:entity.getLignes()){
            if(ligne.getId()<=0){
                ligne.setId(-1L);
            }//end if(ligne.getQuantite()<0.0){
            if(ligne.getQuantite()<=0){
                throw new KerenExecption("Veuillez fournir la quantité retournée pour l'article "+ligne.getArticle().getDesignation());
            }//endif(ligne.getQuantite()<=0){
            if(ligne.getSource().disponible().compareTo(ligne.getQuantite())<0){
                throw new KerenExecption("La quantité retournée est supérieur à la quantité disponible pour "+ligne.getArticle().getDesignation());
            }//end if(ligne.getSource().disponible().compareTo(ligne.getQuantite())<0){
        }
    }//end  private void canSatisfied(RetourClient entity){

    @Override
    public RetourClient save(HttpHeaders headers, RetourClient entity) {
        Gson gson = new Gson();
        Long _id =null;
        if(headers.getRequestHeader("livraison")!=null
                && !headers.getRequestHeader("livraison").isEmpty()){
            _id = gson.fromJson(headers.getRequestHeader("livraison").get(0), Long.class);
            BonLivraison bl = blmanager.find("id", _id);
            entity.setLivraison(bl);entity.setClient(bl.getClient());
            entity.setEntrepot(bl.getEntrepot());entity.setLieu(bl.getLieu());
            entity.setReference(bl.getReference());
        }//end if(headers.getRequestHeader("livraison")!=null
        return super.save(headers, entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RetourClient update(HttpHeaders headers, Long id, RetourClient entity) {
         Gson gson = new Gson();
        Long _id =null;
        if(headers.getRequestHeader("livraison")!=null
                && !headers.getRequestHeader("livraison").isEmpty()){
            _id = gson.fromJson(headers.getRequestHeader("livraison").get(0), Long.class);
            BonLivraison bl = blmanager.find("id", _id);
            entity.setClient(bl.getClient());
            entity.setEntrepot(bl.getEntrepot());entity.setLieu(bl.getLieu());
            entity.setReference(bl.getReference());
        }//end if(headers.getRequestHeader("livraison")!=null
        return super.update(headers, id, entity); //To change body of generated methods, choose Tools | Templates.
    }


}
