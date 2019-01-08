
package com.teratech.stock.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.stock.core.ifaces.operations.TransfertManagerLocal;
import com.teratech.stock.core.ifaces.operations.TransfertManagerRemote;
import com.teratech.stock.dao.ifaces.base.ArticleDAOLocal;
import com.teratech.stock.dao.ifaces.base.LienEmplacementDAOLocal;
import com.teratech.stock.dao.ifaces.operations.LotDAOLocal;
import com.teratech.stock.dao.ifaces.operations.TransfertDAOLocal;
import com.teratech.stock.model.base.Emplacement;
import com.teratech.stock.model.base.LienEmplacement;
import com.teratech.stock.model.operations.LigneDocumentStock;
import com.teratech.stock.model.operations.LigneTransfert;
import com.teratech.stock.model.operations.Lot;
import com.teratech.stock.model.operations.Transfert;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "TransfertManager")
public class TransfertManagerImpl
    extends AbstractGenericManager<Transfert, Long>
    implements TransfertManagerLocal, TransfertManagerRemote
{

    @EJB(name = "TransfertDAO")
    protected TransfertDAOLocal dao;
    
    @EJB(name = "ArticleDAO")
    protected ArticleDAOLocal articledao;
    
    @EJB(name = "LotDAO")
    protected LotDAOLocal lotdao;
    
    @EJB(name = "LienEmplacementDAO")
    protected LienEmplacementDAOLocal liendao;

    public TransfertManagerImpl() {
    }

    @Override
    public GenericDAO<Transfert, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Transfert> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Transfert> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Transfert> result = new ArrayList<Transfert>();
        for(Transfert tra:datas){
            result.add(new Transfert(tra));
        }
        return result;
    }

    @Override
    public List<Transfert> findAll() {
        List<Transfert> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Transfert> result = new ArrayList<Transfert>();
        for(Transfert tra:datas){
            result.add(new Transfert(tra));
        }
        return result;
    }

    @Override
    public Transfert find(String propertyName, Long entityID) {
        Transfert data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Transfert result = new Transfert(data);
        for(LigneTransfert lign:data.getLignes()){
            result.getLignes().add(new LigneTransfert(lign));
        }
        return result;
    }

    @Override
    public Transfert delete(Long id) {
        Transfert entity = dao.findByPrimaryKey("id", id);
        for(LigneTransfert ligne:entity.getLignes()){
            if(ligne.getArticle().getPolitiquestock()==null
                    ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("0")
                    ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("2")){
                
            }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("1")
                    ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("5")){    
                    Lot cible = ligne.getLotcible();                    
                    Lot lot = ligne.getLot();
                    Double qte = ligne.getQuantite();
                    lot.addSortie(qte*-1);
                    cible.addEntree(qte*-1);
                    if(cible.disponible().compareTo(0.0)==0){
                        lotdao.delete(cible.getId());
                    }else{
                        lotdao.update(cible.getId(), cible);
                    }//end if(cible.disponible().compareTo(0.0)<=0){
                    lotdao.update(lot.getId(), lot);                    
            }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("3")){//FIFO
                  
            }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("4")){//FIFO
                  
            }//end if(ligne.getArticle().getPolitiquestock()==null
            LienEmplacement source = ligne.getEmpsource();
            LienEmplacement cible = ligne.getEmpcible();
            Double qte = ligne.getQuantite();
            source.addStock(qte);
            cible.addStock(qte*-1);
            liendao.update(source.getId(), source);
            liendao.update(cible.getId(), cible);
        }//end for(LigneSortie ligne:entity.getLignes()){
        Transfert data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Transfert(data);
    }
    
   /**
    * 
    * @param entity
    * @param old 
    */
    private void compute(Transfert entity , Transfert old){
        Map<Long,LigneTransfert> map = new HashMap<Long, LigneTransfert>();
        if(old!=null){
            for(LigneTransfert ligne:old.getLignes()){
                map.put(ligne.getId(), ligne);
            }//end for(LigneSortie ligne:old.getLignes()){
        }//end if(old!=null){
        //Traitement des lignes 
        for(LigneTransfert ligne:entity.getLignes()){
            LigneTransfert oldligne = map.get(ligne.getId());
            if(ligne.getArticle().getPolitiquestock()==null
                    ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("0")
                    ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("2")){
                
            }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("1")
                    ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("5")){    
                    Lot cible = ligne.getLotcible();
                    if(cible==null){
                        cible = new Lot(ligne.getLot());
                        cible.setId(-1);cible.setLien(ligne.getEmpcible());
                        cible.setEntree(null);
                        cible.setEncours(0.0);
                        cible.setQuantite(ligne.getQuantite());
                        Date today = new Date();
                        cible.setCompareid(today.getTime());
                    }//end if(cible==null){
                    Lot lot = ligne.getLot();
                    Double qte = ligne.getQuantite()-(oldligne!=null ? oldligne.getQuantite():0.0);
                    lot.addSortie(qte);
                    cible.addEntree(qte);
                    if(cible.getId()<0){
                        lotdao.save(cible);
                        //Liaison du cible avec la ligne transfert
                        cible = lotdao.findByPrimaryKey("compareid", cible.getCompareid());
                        ligne.setLotcible(cible);
                    }else{
                        lotdao.update(cible.getId(), cible);
                    }//end if(cible.getId()<0){
                    lotdao.update(lot.getId(), lot);                    
            }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("3")){//FIFO
                  
            }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("4")){//FIFO
                  
            }//end if(ligne.getArticle().getPolitiquestock()==null
            LienEmplacement source = ligne.getEmpsource();
            LienEmplacement cible = ligne.getEmpcible();
            Double qte = ligne.getQuantite()-(oldligne!=null ? oldligne.getQuantite():0.0);
            source.addStock(qte*-1);
            cible.addStock(qte);
            liendao.update(source.getId(), source);
            liendao.update(cible.getId(), cible);
        }//end for(LigneSortie ligne:entity.getLignes()){
    }//end private void computeLigne(LigneDocumentStock ligne , Emplacement empl){

    @Override
    public void processBeforeUpdate(Transfert entity) {
        Transfert old = dao.findByPrimaryKey("id", entity.getId());
        compute(entity, old);
        super.processAfterUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processBeforeSave(Transfert entity) {
        compute(entity, null);
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    
    /**
     * 
     * @param entity
     * @return 
     */
    public Transfert confirmer(Transfert entity) {
        //To change body of generated methods, choose Tools | Templates.
        return entity;
    }
    
    

}
