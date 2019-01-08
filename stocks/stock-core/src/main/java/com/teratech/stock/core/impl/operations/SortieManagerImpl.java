
package com.teratech.stock.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.stock.core.ifaces.operations.SortieManagerLocal;
import com.teratech.stock.core.ifaces.operations.SortieManagerRemote;
import com.teratech.stock.dao.ifaces.base.ArticleDAOLocal;
import com.teratech.stock.dao.ifaces.base.LienEmplacementDAOLocal;
import com.teratech.stock.dao.ifaces.operations.LotDAOLocal;
import com.teratech.stock.dao.ifaces.operations.SortieDAOLocal;
import com.teratech.stock.model.base.LienEmplacement;
import com.teratech.stock.model.operations.LigneSortie;
import com.teratech.stock.model.operations.Lot;
import com.teratech.stock.model.operations.Sortie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "SortieManager")
public class SortieManagerImpl
    extends AbstractGenericManager<Sortie, Long>
    implements SortieManagerLocal, SortieManagerRemote
{

    @EJB(name = "SortieDAO")
    protected SortieDAOLocal dao;
    
    @EJB(name = "ArticleDAO")
    protected ArticleDAOLocal articledao;
    
    @EJB(name = "LotDAO")
    protected LotDAOLocal lotdao;
    
    @EJB(name = "LienEmplacementDAO")
    protected LienEmplacementDAOLocal liendao;
    
    
    public SortieManagerImpl() {
    }

    @Override
    public GenericDAO<Sortie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Sortie> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Sortie> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Sortie> result = new ArrayList<Sortie>();
        for(Sortie sor:datas){
            result.add(new Sortie(sor));
        }
        return result;
    }

    @Override
    public List<Sortie> findAll() {        
        List<Sortie> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Sortie> result = new ArrayList<Sortie>();
        for(Sortie sor:datas){
            result.add(new Sortie(sor));
        }
        return result;
    }

    @Override
    public Sortie find(String propertyName, Long entityID) {
        Sortie data= super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Sortie result = new Sortie(data);
        for(LigneSortie lign:data.getLignes()){
            result.getLignes().add(new LigneSortie(lign));
        }//end for(LigneSortie lign:data.getLignes()){
        return result;
    }

    @Override
    public Sortie delete(Long id) {
          Sortie entity = dao.findByPrimaryKey("id", id);
          for(LigneSortie ligne:entity.getLignes()){
            if(ligne.getArticle().getPolitiquestock()==null
                    ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("0")
                    ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("2")){
                
            }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("1")
                    ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("5")){                    
                    Lot lot = ligne.getLot();
                    Double qte = ligne.getQuantite();
                    lot.addSortie(qte*-1);
                    lotdao.update(lot.getId(), lot);
            }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("3")){//FIFO
                  
            }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("4")){//FIFO
                  
            }//end if(ligne.getArticle().getPolitiquestock()==null
            LienEmplacement lien = ligne.getEmplacement();
            Double qte = ligne.getQuantite();
            lien.addStock(qte);
            liendao.update(lien.getId(), lien);
        }//end for(LigneSortie ligne:entity.getLignes()){
        Sortie data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Sortie(data);
    }
    
    @Override
    public Sortie confirmer(Sortie object){
        object.setState("valider");
//        for(LigneDocumentStock ligne:object.getLignes()){
//            computeLigne(ligne, object.getEmplacement());
//        }//end for(LigneDocumentStock ligne:object.getLignes())
        //Mise a jour
        dao.update(object.getId(), object);
        return object;
    }

    @Override
    public void processBeforeUpdate(Sortie entity) {
        Sortie old = dao.findByPrimaryKey("id", entity.getId());
        compute(entity, old);  
        entity.setState("etabli");
        if(entity.getLocation()!=null
                &&entity.getLocation().equals(Boolean.TRUE)){
            entity.setState("attente");
        }//end if(entity.getLocation()!=null
        super.processAfterUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processBeforeSave(Sortie entity) {
        entity.setState("etabli");
        if(entity.getLocation()!=null
                &&entity.getLocation().equals(Boolean.TRUE)){
            entity.setState("attente");
        }//end if(entity.getLocation()!=null
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    public void processAfterSave(Sortie entity) {
        compute(entity, null);
        super.processAfterSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    /**
     * 
     * @param entity
     * @param old 
     */
    private void compute(Sortie entity,Sortie old){
        Map<Long,LigneSortie> map = new HashMap<Long, LigneSortie>();
        if(old!=null){
            for(LigneSortie ligne:old.getLignes()){
                map.put(ligne.getId(), ligne);
            }//end for(LigneSortie ligne:old.getLignes()){
        }//end if(old!=null){
        //Traitement des lignes 
        for(LigneSortie ligne:entity.getLignes()){
            LigneSortie oldligne = map.get(ligne.getId());
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
