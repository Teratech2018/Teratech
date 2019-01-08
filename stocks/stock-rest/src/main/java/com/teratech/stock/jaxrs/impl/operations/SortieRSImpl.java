
package com.teratech.stock.jaxrs.impl.operations;

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
import com.teratech.stock.core.ifaces.base.ArticleManagerRemote;
import com.teratech.stock.core.ifaces.operations.LotManagerRemote;
import com.teratech.stock.core.ifaces.operations.SortieManagerRemote;
import com.teratech.stock.jaxrs.ifaces.operations.SortieRS;
import com.teratech.stock.model.operations.LigneSortie;
import com.teratech.stock.model.operations.Sortie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Feb 20 13:26:04 GMT+01:00 2018
 * 
 */
@Path("/sortie")
public class SortieRSImpl
    extends AbstractGenericService<Sortie, Long>
    implements SortieRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechstock", name = "SortieManagerImpl", interf = SortieManagerRemote.class)
    protected SortieManagerRemote manager;
    
    @Manager(application = "teratechstock", name = "ArticleManagerImpl", interf = ArticleManagerRemote.class)
    protected ArticleManagerRemote articlemanager;
    
    @Manager(application = "teratechstock", name = "LotManagerImpl", interf = LotManagerRemote.class)
    protected LotManagerRemote lotmanager;
    

    public SortieRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Sortie, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechstock");
    }
    
      @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            MetaData meta = MetaDataUtil.getMetaData(new Sortie(), new HashMap<String, MetaData>(), new ArrayList<String>());
             MetaColumn workbtn = new MetaColumn("button", "work1", "Imprimer la fiche de sortie", false, "report", null);
            workbtn.setValue("{'name':'sortie_report01','model':'teratechstock','entity':'sortie','method':'imprime'}");
            workbtn.setStates(new String[]{"etabli","attente","retourne"});
            meta.getHeader().add(workbtn);
//            workbtn = new MetaColumn("button", "work2", "Valider le retour location", false, "workflow", null);
//            workbtn.setValue("{'model':'teratechstock','entity':'sortie','method':'location'}");
//            workbtn.setStates(new String[]{"attente"});
//            meta.getHeader().add(workbtn);
//            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
//            meta.getHeader().add(stautsbar);
            return meta;
        } catch (Exception ex) {
            throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
        }
       
    }
    
      @Override
    public List<Sortie> filter(HttpHeaders headers, int firstResult, int maxResult) {
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
        if(headers.getRequestHeader("entree")!=null&&!headers.getRequestHeader("entree").isEmpty()){
             _dpid = gson.fromJson(headers.getRequestHeader("entree").get(0), Long.class);
              container.addEq("entree.id", _dpid);        
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
         if(headers.getRequestHeader("entree")!=null&&!headers.getRequestHeader("entree").isEmpty()){
             _dpid = gson.fromJson(headers.getRequestHeader("entree").get(0), Long.class);
              container.addEq("entree.id", _dpid);        
         }//end if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
         RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }

    @Override
    protected void processBeforeUpdate(Sortie entity) {
        if(entity.getState().equalsIgnoreCase("valider")){
            throw new KerenExecption("Impossible mettre à jour une opération validé");
        }
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir le n° de pièce");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Veuillez saisir la date ");
        }else if(entity.getEntrepot()==null){
            throw new KerenExecption("Veuillez saisir l'entrepôt"); 
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir la ligne du document"); 
        }
        //Verification 
        canSatisfied(entity);
        //Traitement des ligne
        for(LigneSortie ligne : entity.getLignes()){  
            //Controle de validité de la ligne
            if(ligne.getId()<0){
                ligne.setId(-1);
            }//end if(ligne.getId()<0){            
//            ligne.setTotalht(ligne.get()*ligne.getQuantite());
        }//end for(LigneDocumentStock ligne : entity.getLignes()){
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(Sortie entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir le n° de pièce");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Veuillez saisir la date ");
        }else if(entity.getEntrepot()==null){
            throw new KerenExecption("Veuillez saisir l'entrepôt"); 
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir la ligne du document"); 
        }
        //Verification 
        canSatisfied(entity);
        //Traitement des ligne     
         for(LigneSortie ligne : entity.getLignes()){  
            //Controle de validité de la ligne
            if(ligne.getId()<0){
                ligne.setId(-1);
            }//end if(ligne.getId()<0){            
//            ligne.setTotalht(ligne.get()*ligne.getQuantite());
        }//end for(LigneDocumentStock ligne : entity.getLignes()){
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    protected void processBeforeDelete(Object entity) {
        Long id = (Long) entity;
        Sortie entree = manager.find("id",id) ;
        if(entree.getState().equalsIgnoreCase("valider")){
            throw new KerenExecption("Impossible de supprimer une opération validé");
        }
        super.processBeforeDelete(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @param obj 
     */   
    private void canSatisfied(Sortie obj){
        for(LigneSortie ligne:obj.getLignes()){
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
    public Sortie confirmer(HttpHeaders headers, Sortie object) {
         //To change body of generated methods, choose Tools | Templates.
//         if(object.getState().equalsIgnoreCase("valider")){
//            throw new KerenExecption("Impossible mettre à jour une opération validé");
//        }
//        if(object.getCode()==null||object.getCode().trim().isEmpty()){
//            throw new KerenExecption("Veuillez saisir le n° de pièce");
//        }else if(object.getDate()==null){
//            throw new KerenExecption("Veuillez saisir la date ");
//        }else if(object.getEmplacement()==null){
//            throw new KerenExecption("Veuillez saisir l'emplacement"); 
//        }else if(object.getLignes()==null||object.getLignes().isEmpty()){
//            throw new KerenExecption("Veuillez saisir la ligne du document"); 
//        }
//        //Verification 
//        canSatisfied(object);
//        //Traitement des ligne
//        for(LigneDocumentStock ligne : object.getLignes()){  
//            //Controle de validité de la ligne
////            System.out.println(SortieRSImpl.class.toString()+" === "+ligne);     
//            lignecompute(ligne,object.getEmplacement());
//            ligne.setTotalht(ligne.getPuht()*ligne.getQuantite());
//        }//end for(LigneDocumentStock ligne : entity.getLignes()){
//        //Confirmation de l'operation
        return manager.confirmer(object);
    }

    @Override
    public List<Sortie> imprime(HttpHeaders headers, Sortie entity) {
        //To change body of generated methods, choose Tools | Templates.
        List<Sortie> datas = new ArrayList<Sortie>();
        datas.add(entity);
        return datas;
    }
    
    

}
