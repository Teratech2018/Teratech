
package com.teratech.achat.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.achat.core.ifaces.operations.BonReceptionManagerLocal;
import com.teratech.achat.core.ifaces.operations.BonReceptionManagerRemote;
import com.teratech.achat.dao.ifaces.base.ArticleDAOLocal;
import com.teratech.achat.dao.ifaces.operations.BonReceptionDAOLocal;
import com.teratech.achat.dao.ifaces.operations.EntreeDAOLocal;
import com.teratech.achat.dao.ifaces.operations.LotDAOLocal;
import com.teratech.achat.model.base.Article;
import com.teratech.achat.model.base.Emplacement;
import com.teratech.achat.model.base.LienEmplacement;
import com.teratech.achat.model.operations.BonReception;
import com.teratech.achat.model.operations.DocumentAchatState;
import com.teratech.achat.model.operations.Entree;
import com.teratech.achat.model.operations.LigneDocumentAchat;
import com.teratech.achat.model.operations.LigneDocumentStock;
import com.teratech.achat.model.operations.Lot;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "BonReceptionManager")
public class BonReceptionManagerImpl
    extends AbstractGenericManager<BonReception, Long>
    implements BonReceptionManagerLocal, BonReceptionManagerRemote
{

    @EJB(name = "BonReceptionDAO")
    protected BonReceptionDAOLocal dao;
    
     @EJB(name = "EntreeDAO")
    protected EntreeDAOLocal entreedao;    
    
    @EJB(name = "ArticleDAO")
    protected ArticleDAOLocal articledao;
    
    @EJB(name = "LotDAO")
    protected LotDAOLocal lotdao;

    public BonReceptionManagerImpl() {
    }

    @Override
    public GenericDAO<BonReception, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<BonReception> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("typedocument", DocumentAchatState.BONLIVRAISON);
        predicats.addAll(container.getPredicats());
        List<BonReception> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<BonReception> result = new ArrayList<BonReception>();
        for(BonReception bon:datas){
            result.add(new BonReception(bon));
        }
        return result;
    }

    @Override
    public List<BonReception> findAll() {
        List<BonReception> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates
        List<BonReception> result = new ArrayList<BonReception>();
        for(BonReception bon:datas){
            result.add(new BonReception(bon));
        }
        return result;
    }

    @Override
    public BonReception find(String propertyName, Long entityID) {
        BonReception data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        BonReception result = new BonReception(data);
        for(LigneDocumentAchat lign:data.getLignes()){
            result.getLignes().add(new LigneDocumentAchat(lign));
        }
        return result;
    }

    @Override
    public BonReception delete(Long id) {
        BonReception data= super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new BonReception(data);
    }

    /**
     * 
     * @param entity
     * @return 
     */
    @Override
    public BonReception confirmer(BonReception entity) {
        //To change body of generated methods, choose Tools | Templates.
        if(entity.getState().equalsIgnoreCase("etabli")){
            entity.setState("confirme");
        }//end if(entity.getState().equalsIgnoreCase("etabli"))
        dao.update(entity.getId(), entity);
        return entity;
    }

    @Override
    public BonReception rejeter(BonReception entity) {
        //To change body of generated methods, choose Tools | Templates.
        entity.setState("rejete");
        dao.update(entity.getId(), entity);
        return entity;
    }

    @Override
    public BonReception transferer(BonReception entity) {
        //To change body of generated methods, choose Tools | Templates.
        entity.setState("transfere");
        dao.update(entity.getId(), entity);
        Entree entree = new Entree(entity);
        entreedao.save(entree);
        entree = entreedao.findByPrimaryKey("code", entree.getCode());
         confirmer(entree);
         return entity;
    }

    @Override
    public BonReception annuler(BonReception entity) {
        //To change body of generated methods, choose Tools | Templates.
         entity.setState("annule");
        dao.update(entity.getId(), entity);
        return entity;
    }
    
    /**
     * 
     * @param ligne
     * @param empl 
     */
    private void computeLigne(LigneDocumentStock ligne , Emplacement empl){
        Article article = articledao.findByPrimaryKey("id", ligne.getArticle().getId());
        for(LienEmplacement lien : article.getStockages()){
            if(lien.getEmplacement().compareTo(empl)==0){
                if(article.getPolitiquestock()==null||article.getPolitiquestock().equalsIgnoreCase("0")){
                    //Nothing to do
                }else if(article.getPolitiquestock().equalsIgnoreCase("1")||article.getPolitiquestock().equalsIgnoreCase("5")){
                    Lot lot = new Lot(ligne.getCode(), ligne.getQuantite(), ligne.getPeremption(), ligne.getFabrication());
                    lot.setLien(lien);lot.getReference();
                    lotdao.save(lot);
                }else if(article.getPolitiquestock().equalsIgnoreCase("2")){
                    
                }else if(article.getPolitiquestock().equalsIgnoreCase("3")||article.getPolitiquestock().equalsIgnoreCase("4")){
//                    Date date = new Date();
//                    Lot lot = new Lot(Long.toString(date.getTime()), ligne.getQuantite(), ligne.getPeremption(), ligne.getFabrication());
//                    lot.setLien(lien);
//                    lotdao.save(lot);
                }//end if(article.getPolitiquestock()==null||article.getPolitiquestock().equalsIgnoreCase("0"))
                lien.addStock(ligne.getQuantite());
            }//end if(lien.getEmplacement().compareTo(empl)==0){
        }//end for(LienEmplacement lien : article.getStockages()){
        articledao.update(article.getId(), article);
    }//end private void computeLigne(LigneDocumentStock ligne , Emplacement empl){
    
   
    /**
     * 
     * @param obj
     * @return 
     */
    public Entree confirmer(Entree obj) {
        //To change body of generated methods, choose Tools | Templates.
       //        EntreeV entree = new EntreeV(obj);
//        entree.setId(-1);
        //Copie des ligne
        for(LigneDocumentStock lign:obj.getLignes()){
//            LigneDocumentStock li = new LigneDocumentStock(lign);
//            li.setId(-1);
//            entree.getLignes().add(li);
            //Mise a jour du stock en BD
            computeLigne(lign, obj.getEmplacement());
        }//end for(LigneDocumentStock lign:obj.getLignes())
        //Suppression 
//        dao.delete(obj.getId());
        //Creation de l'entree valide
//        dao2.save(entree);
        obj.setState("valider");
        entreedao.update(obj.getId(), obj);
        return obj;
    }

}
