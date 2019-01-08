
package com.teratech.achat.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.achat.core.ifaces.operations.CMDEFactureTMPManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.CMDEFactureTMPRS;
import com.teratech.achat.model.operations.Facture;
import com.teratech.achat.model.operations.LigneDocumentAchat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;



/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Mar 02 11:43:28 GMT+01:00 2018
 * 
 */
@Path("/cmdefacturetmp")
public class CMDEFactureTMPRSImpl
    extends AbstractGenericService<Facture, Long>
    implements CMDEFactureTMPRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "CMDEFactureTMPManagerImpl", interf = CMDEFactureTMPManagerRemote.class)
    protected CMDEFactureTMPManagerRemote manager;

    public CMDEFactureTMPRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Facture, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            MetaData meta =  MetaDataUtil.getMetaData(new Facture(), new HashMap<String, MetaData>(), new ArrayList<String>()); //To change body of generated methods, choose Tools | Templates.
            meta.setDesablecreate(true);
            return meta;
        } catch (InstantiationException ex) {
            Logger.getLogger(CMDEFactureTMPRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CMDEFactureTMPRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Facture delete(Long id) {
         //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    @Override
    protected void processBeforeSave(Facture entity) {
//        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
//            throw new KerenExecption("Veuillez saisir la reference");
//        }else if(entity.getDatecommande()==null){   
//           throw new KerenExecption("Veuillez saisir la date de la commande");
//        }else if(entity.getFornisseur()==null){
//            throw new KerenExecption("Veuillez saisir le fournisseur");
//        }else if(entity.getEmplacement()==null){
//            throw new KerenExecption("Veuillez saisir l'emplacement de livraison");
//        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
//            throw new KerenExecption("Veuillez saisir au moins un article");
//        }
         ligneFactureValidate(entity);
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeUpdate(Facture entity) {
//        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
//            throw new KerenExecption("Veuillez saisir la reference");
//        }else if(entity.getDatecommande()==null){   
//           throw new KerenExecption("Veuillez saisir la date de la commande");
//        }else if(entity.getFornisseur()==null){
//            throw new KerenExecption("Veuillez saisir le fournisseur");
//        }else if(entity.getEmplacement()==null){
//            throw new KerenExecption("Veuillez saisir l'emplacement de livraison");
//        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
//            throw new KerenExecption("Veuillez saisir au moins un article");
//        }
         ligneFactureValidate(entity);
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    /**
     * 
     * @param entity 
     */
    private void ligneFactureValidate(Facture entity){
//        for(LigneDocumentAchat lign:entity.getLignes()){
//            if(lign.getArticle()==null){
//                throw new KerenExecption("Veuillez fournir l'article pour toute les lignes");
//            }else if(lign.getPuht()==null||lign.getPuht()==0){
//                throw new KerenExecption("Veuillez fournir le puht");
//            }else if(lign.getQuantite()==null||lign.getQuantite()==0){
//                throw new KerenExecption("Veuillez fournir la quantité voulue");
//            }else if(lign.getTaxes()==null&&lign.getTaxes().isEmpty()){
//                throw new KerenExecption("Veuillez saisir la taxe appliquée");
//            }else if(lign.getStokdispo()<lign.getQuantite()){
//                throw new KerenExecption("Quantité insuffisante article:"+lign.getDesignation()+" quantité dispo :"+lign.getStokdispo());
//            }
//        }//end for(LigneDocumentAchat lign:entity.getLignes())
    }//end private void ligneFactureValidate(Facture entity)

}
