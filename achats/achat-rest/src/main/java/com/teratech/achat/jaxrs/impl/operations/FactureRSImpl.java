
package com.teratech.achat.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaGroup;
import com.teratech.achat.core.ifaces.operations.FactureManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.FactureRS;
import com.teratech.achat.model.operations.Facture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Mar 02 08:22:57 GMT+01:00 2018
 * 
 */
@Path("/facture")
public class FactureRSImpl
    extends AbstractGenericService<Facture, Long>
    implements FactureRS
{

    public static String FOOTER="<tr style='border:none;'> <td></td><td></td><td></td><td></td><td></td><td style='font-weight: bold;'>Total HT</td><td></td> <td class='text-right'>this.quantite;*;this.puht;*;(;100;-;this.remise;);/;100</td> </tr><tr style='border:none;'> <td></td><td></td><td></td><td></td><td></td><td style='font-weight: bold;'>Escompte</td><td></td> <td class='text-right'>this.quantite;*;this.puht;*;object.escompte;/;100</td> </tr> <tr style='border:none;'> <td></td><td></td><td></td><td></td><td></td><td  style='font-weight: bold;'>Taxes</td><td></td> <td  class='text-right'>(;this.quantite;*;this.puht;*;(;100;-;this.remise;-;object.escompte;);/;100;);*;{\"op\":\"sum\",\"source\":\"this\",\"data\":\"taxes\",\"field\":\"montant\"};/;100</td> </tr> <tr style='border:none;'> <td></td><td></td><td></td><td></td><td></td><td  style='font-weight: bold;'>Total TTC</td><td></td><td  class='text-right'  style='font-weight: bold;'>(;this.quantite;*;this.puht;*;(;100;-;this.remise;-;object.escompte;);/;100;);*;(;100;+;{\"op\":\"sum\",\"source\":\"this\",\"data\":\"taxes\",\"field\":\"montant\"};);/;100</td></tr><tr style='border:none;'> <td></td><td></td><td></td><td></td><td></td><td style='font-weight: bold;'>Total Acomptes</td><td></td> <td class='text-right'   style='font-weight: bold;'>{\"op\":\"sum\",\"source\":\"object\",\"data\":\"acomptes\",\"field\":\"montant\"}</td> </tr><tr style='border:none;'> <td></td><td></td><td></td><td></td><td></td><td style='font-weight: bold;'>Net à payer</td><td></td> <td class='text-right'    style='font-weight: bold;'>(;this.quantite;*;this.puht;*;(;100;-;this.remise;-;object.escompte;);/;100;);*;(;100;+;{\"op\":\"sum\",\"source\":\"this\",\"data\":\"taxes\",\"field\":\"montant\"};);/;100;-;{\"op\":\"sum\",\"source\":\"object\",\"data\":\"acomptes\",\"field\":\"montant\"}</td> </tr>";
    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "FactureManagerImpl", interf = FactureManagerRemote.class)
    protected FactureManagerRemote manager;

    public FactureRSImpl() {
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
            //To change body of generated methods, choose Tools | Templates.
            MetaData meta= MetaDataUtil.getMetaData(new Facture(), new HashMap<String, MetaData>(), new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work1", "Imprimer la facture", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'facture','method':'envoyer'}");
            workbtn.setStates(new String[]{"etabli"});
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work3", "Confirmer la facture", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'facture','method':'confirme'}");
            workbtn.setStates(new String[]{"etabli"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work4", "Transférer en comptabilité", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'facture','method':'transfere'}");
            workbtn.setStates(new String[]{"etabli"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);           
            workbtn = new MetaColumn("button", "work5", "Annuler", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'facture','method':'annule'}");
            workbtn.setStates(new String[]{"etabli"});
            meta.getHeader().add(workbtn);
            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
            meta.getHeader().add(stautsbar);
            for(MetaColumn col:meta.getColumns()){
                if(col.getFieldName().equalsIgnoreCase("emplacement")){
                    col.setHide(true);
                }
            }//end for(MetaColumn col:meta.getColumns())
            for(MetaGroup group:meta.getGroups()){
                if(group.getGroupName().trim().equalsIgnoreCase("group1")){
//                    System.out.println(FactureRSImpl.class.toString()+"  =============================== "+group.getMetaArray()+" ====== "+group.getMetaArray().isCustomfooter()+" ==== "+group.getMetaArray().getFooterScript());
                     group.getMetaArray().get(0).setFooterScript(FOOTER);
                }//end if(group.getGroupName().trim().equalsIgnoreCase("group1"))
            }//end for(MetaGroup group:meta.getGroups())
            return meta;
        } catch (InstantiationException ex) {
            Logger.getLogger(FactureRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FactureRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    protected void processBeforeUpdate(Facture entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDatecommande()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFornisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement de livraison");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un article");
        }
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(Facture entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDatecommande()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFornisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement de livraison");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un article");
        }
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public Facture confirmer(HttpHeaders headers, Facture entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDatecommande()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFornisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement de livraison");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un article");
        }else if(entity.getState().equalsIgnoreCase("confirme")){
            throw new KerenExecption("Cette facture a déjà fait l'objet <br/>d'un transfert en comptabilité");
        }
        //To change body of generated methods, choose Tools | Templates.
        return manager.confirmer(entity);
    }

    @Override
    public Facture transfert(HttpHeaders headers, Facture entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDatecommande()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFornisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement de livraison");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un article");
        }else if(entity.getState().equalsIgnoreCase("etabli")){
            throw new KerenExecption("Veuillez d'abord confirmer la facture");
        }
         //To change body of generated methods, choose Tools | Templates.
        return manager.transfert(entity);
    }

    @Override
    public Facture annule(HttpHeaders headers, Facture entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDatecommande()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFornisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement de livraison");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un article");
        }else if(entity.getState().equalsIgnoreCase("transfere")){
            throw new KerenExecption("Impossible d'annuler une facture <br/> transferée en comptabilité");
        }
       //To change body of generated methods, choose Tools | Templates.
        return manager.annule(entity);
    }

    @Override
    public Response imprimer(HttpHeaders headers, Facture entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDatecommande()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFornisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement de livraison");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un article");
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
