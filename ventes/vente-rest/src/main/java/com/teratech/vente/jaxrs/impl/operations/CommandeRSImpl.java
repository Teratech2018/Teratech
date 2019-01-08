
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
import com.teratech.vente.core.ifaces.operations.CommandeManagerRemote;
import com.teratech.vente.jaxrs.ifaces.operations.CommandeRS;
import com.teratech.vente.model.comptabilite.Taxe;
import com.teratech.vente.model.operations.Commande;
import com.teratech.vente.model.operations.LigneCommande;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Jan 04 12:32:07 WAT 2019
 * 
 */
@Path("/commande")
public class CommandeRSImpl
    extends AbstractGenericService<Commande, Long>
    implements CommandeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechvente", name = "CommandeManagerImpl", interf = CommandeManagerRemote.class)
    protected CommandeManagerRemote manager;

    public CommandeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Commande, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechvente");
    }

    @Override
    protected void processBeforeUpdate(Commande entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ reference est obligatoire");
        }else if(entity.getClient()==null){
            throw new KerenExecption("Veuillez selectionner le client concerné");
        }else if(entity.getDatecommande()==null){
            throw new KerenExecption("Le champ Date est obligatoire");
        }
        entity.setState("etabli");
        compute(entity);
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(Commande entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ reference est obligatoire");
        }else if(entity.getClient()==null){
            throw new KerenExecption("Veuillez selectionner le client concerné");
        }else if(entity.getDatecommande()==null){
            throw new KerenExecption("Le champ Date est obligatoire");
        }
        entity.setState("etabli");
        compute(entity);
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param entity 
     */
     private void compute(Commande entity){
        for(LigneCommande ligne:entity.getLignes()){
            if(ligne.getId()<=0){
                ligne.setId(-1L);
            }//end if(ligne.getId()<=0){
            if(ligne.getQuantite()<=0){
                throw new KerenExecption("Veuillez fournir la quantité commandée pour l'article "+ligne.getArticle().getDesignation());
            }
        }//end for(LigneDevis ligne:entity.getLignes()){      
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new Commande(), new HashMap<String, MetaData>(), new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work1", "Imprimer le bon de commande", false, "report", null);
            workbtn.setValue("{'name':'commandevte_report01','model':'teratechvente','entity':'commande','method':'imprime'}");
            workbtn.setStates(new String[]{"etabli","confirme","termine"});
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work1", "Confirmer la commande", false, "workflow", null);
            workbtn.setValue("{'model':'teratechvente','entity':'commande','method':'confirme','critical':true,'alert':'Cette action confirmera votre commande \nÊtes vous sûr de vouloir continuer?'}");
            workbtn.setStates(new String[]{"etabli"});workbtn.setPattern("btn btn-danger");
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work1", "Géréner les livraisons", false, "link", null);
            workbtn.setValue("{'name':'teratech_vente_ope_3',template:{'client':'object.client','lieu':'object.lieu','reference':'object.codeclient','date':'object.datecommande','commande':'object'},'header':['commande']}");
            workbtn.setStates(new String[]{"confirme"});
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work1", "Géréner les factures", false, "link", null);
            workbtn.setValue("{'name':'teratech_vente_ope_4',template:{'client':'object.client','reference':'object.reference','lieu':'object.lieu','livraison':'object.livraison','commande':'object'},'header':['commande']}");
            workbtn.setStates(new String[]{"confirme"});
            meta.getHeader().add(workbtn);
            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
            meta.getHeader().add(stautsbar);
        } catch (InstantiationException ex) {
            Logger.getLogger(CommandeRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CommandeRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public List<Commande> filter(HttpHeaders headers, int firstResult, int maxResult) {
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
//        if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
//             _dpid = gson.fromJson(headers.getRequestHeader("commande").get(0), Long.class);
//              container.addEq("commande.id", _dpid);        
//         }//end if(headers.getRequestHeader("commande")!=null&&!headers.getRequestHeader("commande").isEmpty()){
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
//        System.out.println(CommandeRSImpl.class.toString()+" ==================================================== "+headers.getRequestHeader("devis"));
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
    public List<Commande> imprimer(HttpHeaders headers, Commande entity) {
        //To change body of generated methods, choose Tools | Templates.
        List<Commande> datas = new ArrayList<Commande>();
        datas.add(entity);
        return datas;
    }

    @Override
    public Commande confirme(HttpHeaders headers, Commande entity) {
        //To change body of generated methods, choose Tools | Templates.
        entity.setState("confirme");
        manager.update(entity.getId(), entity);
        return entity;
    }
    

}
