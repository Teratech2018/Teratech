
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
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;
import com.teratech.achat.core.ifaces.operations.BonCommandeManagerRemote;
import com.teratech.achat.core.ifaces.operations.BonReceptionManagerRemote;
import com.teratech.achat.core.ifaces.operations.LotManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.BonReceptionRS;
import com.teratech.achat.model.base.Article;
import com.teratech.achat.model.operations.BonCommande;
import com.teratech.achat.model.operations.BonReception;
import com.teratech.achat.model.operations.LigneDocumentStock;
import com.teratech.achat.model.operations.LigneEntree;
import com.teratech.achat.model.operations.Lot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Feb 28 21:40:29 GMT+01:00 2018
 * 
 */
@Path("/bonreception")
public class BonReceptionRSImpl
    extends AbstractGenericService<BonReception, Long>
    implements BonReceptionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "BonReceptionManagerImpl", interf = BonReceptionManagerRemote.class)
    protected BonReceptionManagerRemote manager;
    
     @Manager(application = "teratechachat", name = "BonCommandeManagerImpl", interf = BonCommandeManagerRemote.class)
    protected BonCommandeManagerRemote bcmanager;
     
    @Manager(application = "teratechstock", name = "LotManagerImpl", interf = LotManagerRemote.class)
    protected LotManagerRemote lotmanager;

    public BonReceptionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BonReception, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
         try {
            //To change body of generated methods, choose Tools | Templates.
            MetaData meta= MetaDataUtil.getMetaData(new BonReception(), new HashMap<String, MetaData>(), new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work2", "Imprimer le bon", false, "report", null);
            workbtn.setValue("{'name':'breceptionach_report01','model':'teratechachat','entity':'bonreception','method':'imprime'}");
            workbtn.setStates(new String[]{"etabli","qualite","disponible"});
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work3", "Contrôler la qualité", false, "link", null);
            workbtn.setValue("{'name':'teratech_achat_ope_6_1',template:{'bonlivraison':'object','fournisseur':'object.fournisseur'},'header':['bonlivraison']}");
            workbtn.setStates(new String[]{"etabli","qualite"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);
             workbtn = new MetaColumn("button", "work4", "Rejeter", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'bonreception','method':'rejete'}");
            workbtn.setStates(new String[]{"etabli"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work4", "Transferer en stock", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'bonreception','method':'transfere','critical':true,'alert':'Cette action va modifier le stock \nVoulez vous continuer ?'}");
            workbtn.setStates(new String[]{"transfere"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work4", "Générer la facture", false, "link", null);
            workbtn.setValue("{'name':'teratech_achat_ope_7',template:{'fournisseur':'object.fournisseur','bonlivraison':'object','docachat':'object.commande'},'header':['bonlivraison','commande']}");
            workbtn.setStates(new String[]{"disponible"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);
             workbtn = new MetaColumn("button", "work4", "Retour fournisseur", false, "link", null);
            workbtn.setValue("{'name':'teratech_achat_ope_6_2',template:{'fournisseur':'object.fournisseur','entrepot':'object.entrepot','bonlivraison':'object','reference':'object.reference'},'header':['bonlivraison','commande']}");
            workbtn.setStates(new String[]{"disponible"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);
//            workbtn = new MetaColumn("button", "work5", "Annuler", false, "workflow", null);
//            workbtn.setValue("{'model':'teratechachat','entity':'bonreception','method':'annule'}");
//            workbtn.setStates(new String[]{"disponible"});
//            meta.getHeader().add(workbtn);
            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
            meta.getHeader().add(stautsbar);
            return meta;
        } catch (InstantiationException ex) {
            Logger.getLogger(AppelOffreRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AppelOffreRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

     @Override
    public List<BonReception> filter(HttpHeaders headers, int firstResult, int maxResult) {
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
        if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
             _dpid = gson.fromJson(headers.getRequestHeader("commande").get(0), Long.class);
              container.addEq("commande.id", _dpid);        
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
         if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
             _dpid = gson.fromJson(headers.getRequestHeader("commande").get(0), Long.class);
              container.addEq("commande.id", _dpid);        
         }//end if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
         RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }

    
    @Override
    protected void processBeforeUpdate(BonReception entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDate()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFournisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getEntrepot()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement de livraison");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez renseigner les Articles");
        }
        double totalht = 0.0;
        for(LigneDocumentStock ligne : entity.getLignes()){
            if(ligne.getId()<0) ligne.setId(-1L);
            totalht+=ligne.getQuantite()*ligne.getPuht();
        }//end for(LigneDocumentStock ligne : entity.getLignes()){
        entity.setTotalht(totalht);
//        validateLigneBR(entity, Boolean.FALSE);
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(BonReception entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDate()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFournisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getEntrepot()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement de livraison");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez renseigner les Articles");
        }
        double totalht = 0.0;
        for(LigneDocumentStock ligne : entity.getLignes()){
            if(ligne.getId()<0) ligne.setId(-1L);
            totalht+=ligne.getQuantite()*ligne.getPuht();
        }//end for(LigneDocumentStock ligne : entity.getLignes()){
        entity.setTotalht(totalht);
//        validateLigneBR(entity, Boolean.FALSE);
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public BonReception confirmer(HttpHeaders headers, BonReception entity) {
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
//        else if(entity.getState().equalsIgnoreCase("confirme")){
//            throw new KerenExecption("Ce bon de reception est dÃ©jÃ  confirmÃ©");
//        }else if(entity.getState().equalsIgnoreCase("transfere")){
//            throw new KerenExecption("Impossible de confirmer un bon dÃ©ja transfÃ©rÃ©");
//        }else if(entity.getState().equalsIgnoreCase("annule")){
//            throw new KerenExecption("Impossible de confirmer un bon annulÃ©");
//        }
//        validateLigneBR(entity, Boolean.TRUE);
        //To change body of generated methods, choose Tools | Templates.
        return manager.confirmer(entity);
    }

    @Override
    public BonReception rejeter(HttpHeaders headers, BonReception entity) {
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
//        else if(entity.getState().equalsIgnoreCase("transfere")){
//            throw new KerenExecption("Impossible de rejeter un bon transfÃ©rÃ©");
//        }else if(entity.getState().equalsIgnoreCase("annule")){
//            throw new KerenExecption("Impossible de rejeter un bon annulÃ©");
//        }
       //To change body of generated methods, choose Tools | Templates.
        return manager.rejeter(entity);
    }

    @Override
    public BonReception transferer(HttpHeaders headers, BonReception entity) {
        //To change body of generated methods, choose Tools | Templates.
        validateInout(entity);
        return manager.transferer(entity);
    }

//    @Override
//    public Response imprimer(HttpHeaders headers, BonReception entity) {
//        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
//            throw new KerenExecption("Veuillez saisir la reference");
//        }else if(entity.getDate()==null){   
//           throw new KerenExecption("Veuillez saisir la date de la commande");
//        }else if(entity.getFournisseur()==null){
//            throw new KerenExecption("Veuillez saisir le fournisseur");
//        }else if(entity.getEmplacement()==null){
//            throw new KerenExecption("Veuillez saisir l'emplacement de livraison");
//        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public BonReception annuler(HttpHeaders headers, BonReception entity) {
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
//        else if(entity.getState().equalsIgnoreCase("transfere")){
//            throw new KerenExecption("Annulation impossible le bon Ã  dÃ©ja fait l'objet d'un transfert");
//        }
        return manager.annuler(entity);
    }
    
     /**
     * Valide les lignes de la demandes de prix
     * @param entity 
     */
//    private void validateLigneBR(BonReception entity,Boolean strict){
//        for(LigneDocumentStock lign:entity.getLignes()){
//            if(lign.getArticle()==null){
//                throw new KerenExecption("Veuillez fournir l'article pour toute les lignes");
//            }else if(lign.getPuht()==null||lign.getPuht()==0){
//                throw new KerenExecption("Veuillez fournir le puht");
//            }else if(lign.getQuantite()==null||lign.getQuantite()==0){
//                throw new KerenExecption("Veuillez fournir la quantitÃ© voulue");
//            }
//            if(strict==true){
//                if(lign.getArticle().getPolitiquestock().equalsIgnoreCase("1")||
//                        lign.getArticle().getPolitiquestock().equalsIgnoreCase("5")){
//                    if(lign.getCode()==null||lign.getCode().trim().isEmpty()){
//                        throw new KerenExecption("L'article "+lign.getArticle().getDesignation()+" est gÃ©rÃ© par lot ou par sÃ©rie");
//                    }//end if(lign.getCode()==null||lign.getCode().trim().isEmpty())
//                }//end if(lign.getArticle().getPolitiquestock().equalsIgnoreCase("1")
//            }//end vif(strict==true)
////        }//end for(LigneDocumentAchat lign:entity.getLignes())
//    }

    /**
     * 
     * @param headers
     * @param entity
     * @return 
     */
    @Override
    public BonReception facture(HttpHeaders headers, BonReception entity) {
        //To change body of generated methods, choose Tools | Templates.
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
//        else if(entity.getState().equalsIgnoreCase("annule")){
//            throw new KerenExecption("Impossible de facturer un bon annulÃ©");
//        }else if(entity.getState().equalsIgnoreCase("rejete")){
//            throw new KerenExecption("Impossible de transfÃ©rer un bon rejetÃ© <br/>Veuillez refaire le contrÃ´le de la qualitÃ©");
//        }
//        validateLigneBR(entity, Boolean.TRUE);
//        if(!isValideBC(entity)){
//            throw new KerenExecption("Ce bon de reception a dÃ©jÃ  fait l'objet d'une facturation");
//        }//end if(!isValideBC(entity))
        return manager.facturer(entity); 
    }

    /**
     * 
     * @param article
     * @return 
     */
    private boolean stockable(Article article){
        return article.getType()!=null && article.getType().equalsIgnoreCase("1");
    }
    
   /**
     * 
     * @param entity 
     */
    private void validateInout(BonReception entity){
        for(LigneEntree ligne:entity.getLignes()){
           if(!stockable(ligne.getArticle())){
               continue;
           }//end if(!stockable(ligne.getArticle())){
           if(ligne.getArticle().getPolitiquestock()!=null){
               if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("1")||
                       ligne.getArticle().getPolitiquestock().equalsIgnoreCase("5")){
                   if(ligne.getCode()==null||ligne.getCode().trim().isEmpty()){
                        throw new KerenExecption("Veuillez renseigner le numéro de lot/série article :"+ligne.getArticle().getDesignation()); 
                   }else {
                       RestrictionsContainer container = RestrictionsContainer.newInstance();
                       container.addEq("lien.id", ligne.getEmplacement().getId());
                       container.addEq("code", ligne.getCode());
                       List<Lot> lots = lotmanager.filter(container.getPredicats(), null, null, 0, -1);
                       if(!lots.isEmpty()){
                           throw new KerenExecption("Un lot/serie de nom : "+ligne.getCode()+" existe déjà pour cette emplacement \nVeuillez saisir un nouveau numéro de lot/série"); 
                       }//end if(!lots.isEmpty()){
                   }//end if(ligne.getCode()==null||ligne.getCode().trim().isEmpty()){
               }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("2")){
                   if(ligne.getPuht()==null){
                       throw new KerenExecption("Veuillez renseigner le PUHT pour l'article :"+ligne.getArticle().getDesignation()); 
                   }
               }//end  if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("1")||
           }//end  if(ligne.getArticle().getPolitiquestock()!=null){
        }//end for(LigneEntree ligne:entity.getLignes()){
    }

    @Override
    public BonReception save(HttpHeaders headers, BonReception entity) {
         Gson gson =new Gson();
        Long _dpid = null;
        if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
            _dpid = gson.fromJson(headers.getRequestHeader("commande").get(0), Long.class); 
            BonCommande commande = bcmanager.find("id", _dpid);
            entity.setCommande(commande);        
        }//end if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
       entity.setState("etabli");
        return super.save(headers, entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BonReception> imprimer(HttpHeaders headers, BonReception entity) {
        //To change body of generated methods, choose Tools | Templates.
        List<BonReception> datas = new ArrayList<BonReception>();
        datas.add(entity);
        return datas;
    }
     
     
}
