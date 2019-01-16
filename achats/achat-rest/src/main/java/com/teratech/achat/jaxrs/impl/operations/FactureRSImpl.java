
package com.teratech.achat.jaxrs.impl.operations;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaGroup;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;
import com.teratech.achat.core.ifaces.operations.BonCommandeManagerRemote;
import com.teratech.achat.core.ifaces.operations.BonReceptionManagerRemote;
import com.teratech.achat.core.ifaces.operations.FactureManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.FactureRS;
import com.teratech.achat.model.comptabilite.Acompte;
import com.teratech.achat.model.comptabilite.Taxe;
import com.teratech.achat.model.operations.BonCommande;
import com.teratech.achat.model.operations.BonReception;
import com.teratech.achat.model.operations.Facture;
import com.teratech.achat.model.operations.LigneFacture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


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

    public static String FOOTER="<tr style='border:none;'><td></td><td></td><td></td><td></td><td style='font-weight: bold;'>Total HT</td><td class='text-right'>this.quantite;*;this.puht;*;(;100;-;this.remise;);/;100</td><td></td></tr><tr style='border:none;'><td></td><td></td><td></td><td></td><td style='font-weight: bold;'>Escompte</td><td class='text-right'>this.quantite;*;this.puht;*;object.escompte;/;100</td><td></td></tr> <tr style='border:none;'><td></td><td></td><td></td><td></td><td  style='font-weight: bold;'>Taxes</td><td  class='text-right'>(;this.quantite;*;this.puht;*;(;100;-;this.remise;-;object.escompte;);/;100;);*;{\"op\":\"sum\",\"source\":\"this\",\"data\":\"taxes\",\"field\":\"montant\"};/;100</td><td></td></tr><tr style='border:none;'><td></td><td></td><td></td><td></td><td  style='font-weight: bold;'>Total TTC</td><td  class='text-right'  style='font-weight: bold;'>(;this.quantite;*;this.puht;*;(;100;-;this.remise;-;object.escompte;);/;100;);*;(;100;+;{\"op\":\"sum\",\"source\":\"this\",\"data\":\"taxes\",\"field\":\"montant\"};);/;100</td><td></td></tr><tr style='border:none;'><td></td><td></td><td></td><td></td><td style='font-weight: bold;'>Total Acomptes</td><td class='text-right'   style='font-weight: bold;'>{\"op\":\"sum\",\"source\":\"object\",\"data\":\"acomptes\",\"field\":\"montant\"}</td><td></td></tr><tr style='border:none;'><td></td><td></td><td></td><td></td><td style='font-weight: bold;'>Net à payer</td><td class='text-right'    style='font-weight: bold;'>(;this.quantite;*;this.puht;*;(;100;-;this.remise;-;object.escompte;);/;100;);*;(;100;+;{\"op\":\"sum\",\"source\":\"this\",\"data\":\"taxes\",\"field\":\"montant\"};);/;100;-;{\"op\":\"sum\",\"source\":\"object\",\"data\":\"acomptes\",\"field\":\"montant\"}</td><td></td></tr>";
    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "FactureManagerImpl", interf = FactureManagerRemote.class)
    protected FactureManagerRemote manager;
    
    @Manager(application = "teratechachat", name = "BonCommandeManagerImpl", interf = BonCommandeManagerRemote.class)
    protected BonCommandeManagerRemote bcmanager;
    
    @Manager(application = "teratechachat", name = "BonReceptionManagerImpl", interf = BonReceptionManagerRemote.class)
    protected BonReceptionManagerRemote brmanager;

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
            MetaColumn workbtn = new MetaColumn("button", "work1", "Imprimer la facture", false, "report", null);
            workbtn.setValue("{'name':'factureach_report01','model':'teratechachat','entity':'facture','method':'imprime'}");
            workbtn.setStates(new String[]{"etabli","confirme","transfere"});
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work3", "Confirmer la facture", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'facture','method':'confirme','critical':true,'alert':'Voulez vous confirmer cette facture ?'}");
            workbtn.setStates(new String[]{"etabli"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work4", "Transférer en comptabilité", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'facture','method':'transfere','critical':true,'alert':'Cette facture sera transferee en comptabilité\nVoulez vous continuer ?'}");
            workbtn.setStates(new String[]{"confirme"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);           
            workbtn = new MetaColumn("button", "work5", "Annuler", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'facture','method':'annule','critical':true,'alert':'Voulez vous revenir au status précédent ?'}");
            workbtn.setStates(new String[]{"confirme"});
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
    public List<Facture> filter(HttpHeaders headers, int firstResult, int maxResult) {
        Gson gson =new Gson();
        //Type predType = ;
        List contraints = new ArrayList();
        if(headers.getRequestHeader("predicats")!=null&&!headers.getRequestHeader("predicats").isEmpty()){
            contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
        } //end if(headers.getRequestHeader("predicats")!=null){     
        String searchText = null;

        String liveSearch = null;
        if(headers.getRequestHeader("search_text")!=null && !headers.getRequestHeader("search_text").isEmpty()){
            searchText = gson.fromJson(headers.getRequestHeader("search_text").get(0),String.class);
        } //end if(headers.getRequestHeader("predicats")!=null){     
        if(headers.getRequestHeader("live_search")!=null && !headers.getRequestHeader("live_search").isEmpty()){
            liveSearch = gson.fromJson(headers.getRequestHeader("live_search").get(0),String.class);
        } //end if(headers.getRequestHeader("predicats")!=null){     

//        System.out.println(AbstractGenericService.class.toString()+" === "+headers.getRequestHeader("predicats")+" === "+firstResult+" === "+maxResult+" == "+contraints);   
        RestrictionsContainer container = RestrictionsContainer.newInstance();  
        if(contraints!=null&&!contraints.isEmpty()){
            for(Object obj : contraints){
                FilterPredicat filter = (FilterPredicat) obj ;
                if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
                        &&filter.getValue()!=null&&!filter.getValue().isEmpty()){
                        container = addPredicate(container,filter);
                }//end if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
            }//end  for(Object obj : contraints)
        }//end if(contraints!=null&&!contraints.isEmpty())

        if(liveSearch!=null&&!liveSearch.trim().isEmpty()){
            container.addLike("searchkeys", liveSearch);
        }else if(searchText!=null&&!searchText.trim().isEmpty()){
            container.addLike("searchkeys", searchText);
        }//end if(searchText!=null&&!searchText.trim().isEmpty()){        
         Long _dpid = null;
        if(headers.getRequestHeader("docachat")!=null&&!headers.getRequestHeader("docachat").isEmpty()){
             _dpid = gson.fromJson(headers.getRequestHeader("docachat").get(0), Long.class);
              container.addEq("docachat.id", _dpid);        
         }//end if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
        Long _brid = null;
        if(headers.getRequestHeader("bonlivraison")!=null&&!headers.getRequestHeader("bonlivraison").isEmpty()){
             _brid = gson.fromJson(headers.getRequestHeader("bonlivraison").get(0), Long.class);
              container.addEq("bonlivraison.id", _brid);        
         }//end if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
        //List result = new ArrayList();
        return getManager().filter(container.getPredicats(), null , new HashSet<String>(), firstResult, maxResult);
    }

    @Override
    public RSNumber count(HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
         Gson gson =new Gson();
        //Type predType = ;
        List contraints = new ArrayList();
        if(headers.getRequestHeader("predicats")!=null){
            contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
        }//end if(headers.getRequestHeader("predicats")!=null){        
         String searchText = null;

        String liveSearch = null;
        if(headers.getRequestHeader("search_text")!=null && !headers.getRequestHeader("search_text").isEmpty()){
            searchText = gson.fromJson(headers.getRequestHeader("search_text").get(0),String.class);
        } //end if(headers.getRequestHeader("predicats")!=null){     
        if(headers.getRequestHeader("live_search")!=null && !headers.getRequestHeader("live_search").isEmpty()){
            liveSearch = gson.fromJson(headers.getRequestHeader("live_search").get(0),String.class);
        } //end if(headers.getRequestHeader("predicats")!=null){     
        RestrictionsContainer container = RestrictionsContainer.newInstance();  
         if(contraints!=null&&!contraints.isEmpty()){
            for(Object obj : contraints){
                FilterPredicat filter = (FilterPredicat) obj ;
                if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
                        &&filter.getValue()!=null&&!filter.getValue().isEmpty()){
                      container = addPredicate(container, filter);
                }//end if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
            }//end  for(Object obj : contraints)
        }//end if(contraints!=null&&!contraints.isEmpty())
         if(liveSearch!=null&&!liveSearch.trim().isEmpty()){
            container.addLike("searchkeys", liveSearch);
        }else if(searchText!=null&&!searchText.trim().isEmpty()){
            container.addLike("searchkeys", searchText);
        }//end if(searchText!=null&&!searchText.trim().isEmpty()){    
        Long _dpid = null;
         if(headers.getRequestHeader("docachat")!=null&&!headers.getRequestHeader("docachat").isEmpty()){
             _dpid = gson.fromJson(headers.getRequestHeader("docachat").get(0), Long.class);
              container.addEq("docachat.id", _dpid);        
         }//end if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
         Long _brid = null;
        if(headers.getRequestHeader("bonlivraison")!=null&&!headers.getRequestHeader("bonlivraison").isEmpty()){
             _brid = gson.fromJson(headers.getRequestHeader("bonlivraison").get(0), Long.class);
              container.addEq("bonlivraison.id", _brid);        
         }//end if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
         RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }


    @Override
    protected void processBeforeUpdate(Facture entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDatecommande()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFournisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un article");
        }
        double totalht = 0.0;
        double taxes = 0.0;
        double escompte = 0.0;
        double totalttc = 0.0;
        double acomptes = 0.0;
        double netapayer = 0.0;
        for(LigneFacture ligne:entity.getLignes()){      
            if(ligne.getId()<0){
                ligne.setId(-1L);
            }//end if(ligne.getId()<0){
            totalht +=ligne.getQuantite()*ligne.getPuht();
            for(Taxe taxe:ligne.getTaxes()){
                taxes +=ligne.getQuantite()*ligne.getPuht()*taxe.getMontant()/100;
            }//end for(Taxe taxe:ligne.getTaxes()){            
        }//end for(LigneFacture ligne:entity.getLignes()){
        escompte = totalht*(entity.getEscompte()==null ? 0.0 : entity.getEscompte())/100;
        totalttc = totalht + taxes - escompte;
        for(Acompte ligne:entity.getAcomptes()){
            acomptes+=ligne.getMontant();
        }//end for(Acompte ligne:entity.getAcomptes()){
        netapayer = totalttc - acomptes;
        entity.setTotalacompte(acomptes);
        entity.setTotalescompte(escompte);
        entity.setTotalht(totalht);
        entity.setTotalttc(totalttc);
        entity.setTotaltaxes(taxes);
        entity.setNetapayer(netapayer);        
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(Facture entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDatecommande()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFournisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un article");
        }
        double totalht = 0.0;
        double taxes = 0.0;
        double escompte = 0.0;
        double totalttc = 0.0;
        double acomptes = 0.0;
        double netapayer = 0.0;
        for(LigneFacture ligne:entity.getLignes()){      
            if(ligne.getId()<0){
                ligne.setId(-1L);
            }//end if(ligne.getId()<0){
            double remise = (ligne.getRemise()!=null ? ligne.getRemise():0.0)/100;
            totalht +=ligne.getQuantite()*ligne.getPuht()*(1-remise);
            for(Taxe taxe:ligne.getTaxes()){
                taxes +=ligne.getQuantite()*ligne.getPuht()*(1-remise)*taxe.getMontant()/100;
            }//end for(Taxe taxe:ligne.getTaxes()){            
        }//end for(LigneFacture ligne:entity.getLignes()){
        escompte = totalht*(entity.getEscompte()==null ? 0.0 : entity.getEscompte())/100;
        totalttc = totalht + taxes - escompte;
        for(Acompte ligne:entity.getAcomptes()){
            acomptes+=ligne.getMontant();
        }//end for(Acompte ligne:entity.getAcomptes()){
        netapayer = totalttc - acomptes;
        entity.setTotalacompte(acomptes);
        entity.setTotalescompte(escompte);
        entity.setTotalht(totalht);
        entity.setTotalttc(totalttc);
        entity.setTotaltaxes(taxes);
        entity.setNetapayer(netapayer);        
        entity.setState("etabli");
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public Facture confirmer(HttpHeaders headers, Facture entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDatecommande()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFournisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un article");
        }
        else if(entity.getState().equalsIgnoreCase("confirme")){
            throw new KerenExecption("Cette facture a déjà fait l'objet <br/>d'un transfert en comptabilit");
        }//end if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
        //To change body of generated methods, choose Tools | Templates.
        return manager.confirmer(entity);
    }

    @Override
    public Facture transfert(HttpHeaders headers, Facture entity) {
         //To change body of generated methods, choose Tools | Templates.
        return manager.transfert(entity);
    }

    @Override
    public Facture annule(HttpHeaders headers, Facture entity) {
       //To change body of generated methods, choose Tools | Templates.
        return manager.annule(entity);
    }

    @Override
    public List<Facture> imprimer(HttpHeaders headers, Facture entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDatecommande()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFournisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un article");
        }
         //To change body of generated methods, choose Tools | Templates.
        List<Facture> factures = new ArrayList<Facture>();
        factures.add(entity);
        return factures;
    }

    @Override
    public Facture save(HttpHeaders headers, Facture entity) {
        Gson gson = new Gson();
        if(headers.getRequestHeader("docachat")!=null && !headers.getRequestHeader("docachat").isEmpty()){
            Long _id = gson.fromJson(headers.getRequestHeader("docachat").get(0), Long.class);
            BonCommande bon = bcmanager.find("id", _id);
            entity.setDocachat(bon);
        }//end if(headers.getRequestHeader("docachat")!=null && !headers.getRequestHeader("docachat").isEmpty()){
        Long _brid = null;
        if(headers.getRequestHeader("bonlivraison")!=null&&!headers.getRequestHeader("bonlivraison").isEmpty()){
             _brid = gson.fromJson(headers.getRequestHeader("bonlivraison").get(0), Long.class);
             BonReception bon =  brmanager.find("id", _brid);
             entity.setBonlivraison(bon);
         }//end if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
        return super.save(headers, entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
