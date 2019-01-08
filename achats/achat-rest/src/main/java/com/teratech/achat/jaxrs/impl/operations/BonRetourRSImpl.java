
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
import com.teratech.achat.core.ifaces.base.LienEmplacementManagerRemote;
import com.teratech.achat.core.ifaces.operations.BonReceptionManagerRemote;
import com.teratech.achat.core.ifaces.operations.BonRetourManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.BonRetourRS;
import com.teratech.achat.model.base.LienEmplacement;
import com.teratech.achat.model.operations.BonReception;
import com.teratech.achat.model.operations.BonRetour;
import com.teratech.achat.model.operations.LigneEntree;
import com.teratech.achat.model.operations.LigneSortie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Jan 03 09:08:06 WAT 2019
 * 
 */
@Path("/bonretour")
public class BonRetourRSImpl
    extends AbstractGenericService<BonRetour, Long>
    implements BonRetourRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "BonRetourManagerImpl", interf = BonRetourManagerRemote.class)
    protected BonRetourManagerRemote manager;
    
    @Manager(application = "teratechachat", name = "BonReceptionManagerImpl", interf = BonReceptionManagerRemote.class)
    protected BonReceptionManagerRemote brmanager;
    
    @Manager(application = "teratechachat", name = "LienEmplacementManagerImpl", interf = LienEmplacementManagerRemote.class)
    protected LienEmplacementManagerRemote lienmanager;

    public BonRetourRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BonRetour, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new BonRetour(), new HashMap<String, MetaData>(), new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work2", "Imprimer le bon", false, "report", null);
            workbtn.setValue("{'name':'bretourach_report01','model':'teratechachat','entity':'bonretour','method':'imprime'}");
            workbtn.setStates(new String[]{"etabli"});
            meta.getHeader().add(workbtn);
        } catch (InstantiationException ex) {
            Logger.getLogger(BonRetourRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BonRetourRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

     @Override
    public List<BonRetour> filter(HttpHeaders headers, int firstResult, int maxResult) {
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
        if(headers.getRequestHeader("bonlivraison")!=null&&!headers.getRequestHeader("bonlivraison").isEmpty()){
             _dpid = gson.fromJson(headers.getRequestHeader("bonlivraison").get(0), Long.class);
              container.addEq("bonlivraison.id", _dpid);        
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
         if(headers.getRequestHeader("bonlivraison")!=null&&!headers.getRequestHeader("bonlivraison").isEmpty()){
             _dpid = gson.fromJson(headers.getRequestHeader("bonlivraison").get(0), Long.class);
              container.addEq("bonlivraison.id", _dpid);        
         }//end if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
         RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }

    @Override
    protected void processBeforeDelete(Object entity) {
        super.processBeforeDelete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeUpdate(BonRetour entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ N° de Pièce est obligatoire");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Le champ Date document est obligatoire");
        }else if(entity.getCommentaire()==null){
            throw new KerenExecption("Le champ commentaire est obligatoire");
        }
        canSatisfied(entity);
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(BonRetour entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ N° de Pièce est obligatoire");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Le champ Date document est obligatoire");
        }else if(entity.getCommentaire()==null){
            throw new KerenExecption("Le champ commentaire est obligatoire");
        }
        canSatisfied(entity);
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BonRetour save(HttpHeaders headers, BonRetour entity) {
         Gson gson =new Gson();
         Long _dpid = null;
         if(headers.getRequestHeader("bonlivraison")!=null&&!headers.getRequestHeader("bonlivraison").isEmpty()){
             _dpid = gson.fromJson(headers.getRequestHeader("bonlivraison").get(0), Long.class);
            BonReception bon = brmanager.find("id", _dpid);
            entity.setEntrepot(bon.getEntrepot());
         }//end if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
        return super.save(headers, entity); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    /**
     * 
     * @param entity
     * @return 
     */
    private void canSatisfied(BonRetour entity){        
      for(LigneSortie ligne:entity.getLignes()){
          if(ligne.getSource()!=null){
              if(ligne.getSource().disponible().compareTo(ligne.getQuantite())<0){
                  throw new KerenExecption("La quantité disponible est de "+ligne.getSource().disponible()+"\nVeuillez ajuster la quantité pour l'article "+ligne.getArticle().getDesignation());
              }//end if(ligne.getSource().disponible().compareTo(ligne.getQuantite())<0){
          }//end if(ligne.getSource()!=null){
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
       }//end for(LigneSortie ligne:entity.getLignes()){
    }

    @Override
    public List<BonRetour> imprimer(HttpHeaders headers, BonRetour entity) {
        //To change body of generated methods, choose Tools | Templates.
        List<BonRetour> datas = new ArrayList<BonRetour>();
        datas.add(entity);
        return datas;
    }
    

}
