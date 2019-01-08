
package com.teratech.vente.jaxrs.impl.operations;

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
import com.teratech.vente.core.ifaces.operations.BonLivraisonManagerRemote;
import com.teratech.vente.jaxrs.ifaces.operations.BonLivraisonRS;
import com.teratech.vente.model.operations.BonLivraison;
import com.teratech.vente.model.operations.Commande;
import com.teratech.vente.model.operations.LIgneBonLivraison;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Jan 04 21:36:00 WAT 2019
 * 
 */
@Path("/bonlivraison")
public class BonLivraisonRSImpl
    extends AbstractGenericService<BonLivraison, Long>
    implements BonLivraisonRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechvente", name = "BonLivraisonManagerImpl", interf = BonLivraisonManagerRemote.class)
    protected BonLivraisonManagerRemote manager;

    public BonLivraisonRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BonLivraison, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechvente");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new BonLivraison(), new HashMap<String, MetaData>(), new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work1", "Imprimer le bon de livraison", false, "report", null);
            workbtn.setValue("{'name':'livraisonvte_report01','model':'teratechvente','entity':'bonlivraison','method':'imprime'}");
            workbtn.setStates(new String[]{"etabli","confirme"});
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work1", "Confirmer la livraison", false, "workflow", null);
            workbtn.setValue("{'model':'teratechvente','entity':'bonlivraison','method':'confirme','critical':true,'alert':'La confirmation empechera tout action de modification\nÊtes vous sûr de vouloir continuer?'}");
            workbtn.setStates(new String[]{"etabli"});workbtn.setPattern("btn btn-danger");
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work1", "Saisir les factures", false, "link", null);
            workbtn.setValue("{'name':'teratech_vente_ope_4',template:{},'header':[]}");
            workbtn.setStates(new String[]{"confirme"});
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work1", "Saisir les retours client", false, "link", null);
            workbtn.setValue("{'name':'teratech_vente_ope_3_1',template:{'client':'object.client','data':'object.date','entrepot':'object.entrepot','lieu':'object.lieu','reference':'object.reference','livraison':'object'},'header':['livraison']}");
            workbtn.setStates(new String[]{"confirme"});
            meta.getHeader().add(workbtn);
            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
            meta.getHeader().add(stautsbar);
        } catch (InstantiationException ex) {
            Logger.getLogger(BonLivraisonRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BonLivraisonRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }
    
     
    @Override
    public List<BonLivraison> filter(HttpHeaders headers, int firstResult, int maxResult) {
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
         if(headers.getRequestHeader("devis")!=null&&!headers.getRequestHeader("devis").isEmpty()){
             _dpid = gson.fromJson(headers.getRequestHeader("devis").get(0), Long.class);
              container.addEq("devis.id", _dpid);        
         }//end if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
//        Long _brid = null;
        if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
             _dpid = gson.fromJson(headers.getRequestHeader("commande").get(0), Long.class);
              container.addEq("commande.id", _dpid);        
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
        if(headers.getRequestHeader("devis")!=null&&!headers.getRequestHeader("devis").isEmpty()){
             _dpid = gson.fromJson(headers.getRequestHeader("devis").get(0), Long.class);
              container.addEq("devis.id", _dpid);        
        }//end if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
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
    protected void processBeforeUpdate(BonLivraison entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ N° de Pièce est obligatoire");
        }else if(entity.getClient()==null){
            throw new KerenExecption("Veuillez selectionner le client concerné");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Le cham Date document est obligatoire");
        }else if(entity.getLieu()==null||entity.getLieu().trim().isEmpty()){
            throw new KerenExecption("Le champ Adresse de livraison est obligatoire");
        }else if(entity.getEntrepot()==null){
            throw  new KerenExecption("Veuillez selectionnez l'entrepôt source");
        }
        check(entity);
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(BonLivraison entity) {
         if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ N° de Pièce est obligatoire");
        }else if(entity.getClient()==null){
            throw new KerenExecption("Veuillez selectionner le client concerné");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Le cham Date document est obligatoire");
        }else if(entity.getLieu()==null||entity.getLieu().trim().isEmpty()){
            throw new KerenExecption("Le champ Adresse de livraison est obligatoire");
        }else if(entity.getEntrepot()==null){
            throw  new KerenExecption("Veuillez selectionnez l'entrepôt source");
        }
         check(entity);
         entity.setState("etabli");
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * 
     * @param entity 
     */
    private void check(BonLivraison entity){
        if(entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un article à livré");
        }
        Double totalht = 0.0;
        for(LIgneBonLivraison ligne:entity.getLignes()){
            if(ligne.getId()<=0){
                ligne.setId(-1L);
            }//end if(ligne.getId()<=0){
            ligne.setTotalht(ligne.getPuht()*ligne.getQuantite());
            totalht+=ligne.getTotalht();
        }
        entity.setTotalht(totalht);
    }
    
    /**
     * Parcour les articles et verifie que 
     * @param entity 
     */
    
    private void canSatisfied(BonLivraison entity){
        for(LIgneBonLivraison ligne:entity.getLignes()){
            if(ligne.getArticle().getPolitiquestock()==null||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("3")
                    ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("0")||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("4")){
                if(ligne.getEmplacement().getStock()==null
                        || ligne.getEmplacement().getStock().compareTo(ligne.getQuantite())<0){
                    throw new KerenExecption("Le stock est insuffisant pour satisfaire votre requête\nVous ne disposez que de "+ligne.getEmplacement().getStock()+" pour l'article "+ligne.getArticle().getDesignation());
                }//end  if(ligne.getEmplacement().getStock()==null
            }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("1")
                    ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("5")){
                   if(ligne.getLot()==null){
                       throw new KerenExecption("Veuillez saisir le lot/Serie concerné");
                   }else if(ligne.getLot().disponible().compareTo(ligne.getQuantite())<0){
                       throw new KerenExecption("Le lot sélectionné ne contient que "+ligne.getLot().disponible()+" articles "+ligne.getArticle().getDesignation()+"\nVous pouvez selectionner plusieurs lots pour couvrire la quantité souhaitée");
                   }//end if(ligne.getLot()==null){
            }//end if(ligne.getArticle().getPolitiquestock()==null||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("3")
        }//end  for(LigneSortie ligne:obj.getLignes()){
    }//end private Boolean canSatisfied(Sortie obj)

    @Override
    public BonLivraison confirme(HttpHeaders headers, BonLivraison entity) {
       //To change body of generated methods, choose Tools | Templates.
        canSatisfied(entity);
        entity = manager.confirmer(entity);
        return entity;
    }
    

    @Override
    public List<BonLivraison> imprimer(HttpHeaders headers, BonLivraison entity) {
        //To change body of generated methods, choose Tools | Templates.
        List<BonLivraison> datas = new ArrayList<BonLivraison>();
        datas.add(entity);
        return datas;
    }

}
