
package com.teratech.vente.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.vente.core.ifaces.operations.BonLivraisonManagerLocal;
import com.teratech.vente.core.ifaces.operations.BonLivraisonManagerRemote;
import com.teratech.vente.dao.ifaces.base.ArticleDAOLocal;
import com.teratech.vente.dao.ifaces.base.LienEmplacementDAOLocal;
import com.teratech.vente.dao.ifaces.operations.BonLivraisonDAOLocal;
import com.teratech.vente.dao.ifaces.operations.LotDAOLocal;
import com.teratech.vente.model.base.LienEmplacement;
import com.teratech.vente.model.operations.BonLivraison;
import com.teratech.vente.model.operations.LIgneBonLivraison;
import com.teratech.vente.model.operations.Lot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "BonLivraisonManager")
public class BonLivraisonManagerImpl
    extends AbstractGenericManager<BonLivraison, Long>
    implements BonLivraisonManagerLocal, BonLivraisonManagerRemote
{

    @EJB(name = "BonLivraisonDAO")
    protected BonLivraisonDAOLocal dao;
    
    
    @EJB(name = "ArticleDAO")
    protected ArticleDAOLocal articledao;
    
    @EJB(name = "LotDAO")
    protected LotDAOLocal lotdao;
    
    @EJB(name = "LienEmplacementDAO")
    protected LienEmplacementDAOLocal liendao;
    

    public BonLivraisonManagerImpl() {
    }

    @Override
    public GenericDAO<BonLivraison, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public Long count(List<Predicat> predicats) {
        return super.count(predicats); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BonLivraison> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<BonLivraison> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<BonLivraison> result = new ArrayList<BonLivraison>();
        for(BonLivraison data:datas){
            result.add(new BonLivraison(data));
        }
        return result;
    }

    @Override
    public BonLivraison find(String propertyName, Long entityID) {
        BonLivraison data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        BonLivraison entity = new BonLivraison(data);
        for(LIgneBonLivraison ligne:data.getLignes()){
            entity.getLignes().add(new LIgneBonLivraison(ligne));
        }
        return entity;
    }

    @Override
    public BonLivraison delete(Long id) {
        BonLivraison data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new BonLivraison(data);
    }

    @Override
    public BonLivraison confirmer(BonLivraison entity) {
        compute(entity, null);
        //To change body of generated methods, choose Tools | Templates.
        entity.setState("confirme");
        entity = dao.update(entity.getId(), entity);
        return new BonLivraison(entity);
    }
    
     /**
     * 
     * @param entity
     * @param old 
     */
    private void compute(BonLivraison entity,BonLivraison old){
        Map<Long,LIgneBonLivraison> map = new HashMap<Long, LIgneBonLivraison>();
        if(old!=null){
            for(LIgneBonLivraison ligne:old.getLignes()){
                map.put(ligne.getId(), ligne);
            }//end for(LigneSortie ligne:old.getLignes()){
        }//end if(old!=null){
        //Traitement des lignes 
        for(LIgneBonLivraison ligne:entity.getLignes()){
            LIgneBonLivraison oldligne = map.get(ligne.getId());
            if(ligne.getArticle().getPolitiquestock()==null
                    ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("0")
                    ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("2")){
                
            }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("1")
                    ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("5")){                    
                    Lot lot = ligne.getLot();
                    Double qte = ligne.getQuantite()-(oldligne!=null ? oldligne.getQuantite():0.0);
                    lot.addSortie(qte);
                    lotdao.update(lot.getId(), lot);
            }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("3")){//FIFO
                  
            }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("4")){//FIFO
                  
            }//end if(ligne.getArticle().getPolitiquestock()==null
            LienEmplacement lien = ligne.getEmplacement();
            Double qte = (oldligne!=null ? oldligne.getQuantite():0.0)-ligne.getQuantite();
            lien.addStock(qte);
            liendao.update(lien.getId(), lien);
        }//end for(LigneSortie ligne:entity.getLignes()){
    }//end private void computeLigne(LigneDocumentStock ligne , Emplacement empl){

}
