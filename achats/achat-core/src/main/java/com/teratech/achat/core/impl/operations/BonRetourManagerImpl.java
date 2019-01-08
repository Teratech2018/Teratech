
package com.teratech.achat.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.achat.core.ifaces.operations.BonRetourManagerLocal;
import com.teratech.achat.core.ifaces.operations.BonRetourManagerRemote;
import com.teratech.achat.dao.ifaces.base.LienEmplacementDAOLocal;
import com.teratech.achat.dao.ifaces.operations.BonReceptionDAOLocal;
import com.teratech.achat.dao.ifaces.operations.BonRetourDAOLocal;
import com.teratech.achat.dao.ifaces.operations.LotDAOLocal;
import com.teratech.achat.model.base.LienEmplacement;
import com.teratech.achat.model.operations.BonReception;
import com.teratech.achat.model.operations.BonRetour;
import com.teratech.achat.model.operations.LigneEntree;
import com.teratech.achat.model.operations.LigneSortie;
import com.teratech.achat.model.operations.Lot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "BonRetourManager")
public class BonRetourManagerImpl
    extends AbstractGenericManager<BonRetour, Long>
    implements BonRetourManagerLocal, BonRetourManagerRemote
{

    @EJB(name = "BonRetourDAO")
    protected BonRetourDAOLocal dao;
    
    @EJB(name = "LotDAO")
    protected LotDAOLocal lotdao;
    
    @EJB(name = "LienEmplacementDAO")
    protected LienEmplacementDAOLocal liendao;
    
    @EJB(name = "BonReceptionDAO")
    protected BonReceptionDAOLocal brdao;
    
    public BonRetourManagerImpl() {
    }

    @Override
    public GenericDAO<BonRetour, Long> getDao() {
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
    public List<BonRetour> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<BonRetour> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<BonRetour> result = new ArrayList<BonRetour>();
        for(BonRetour data:datas){
            result.add(new BonRetour(data));
        }
        return result;
    }

    @Override
    public BonRetour find(String propertyName, Long entityID) {
        BonRetour data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        BonRetour result = new BonRetour(data);
        for(LigneSortie ligne:data.getLignes()){
            result.getLignes().add(new LigneSortie(ligne));
        }
        return result;
    }

    @Override
    public BonRetour delete(Long id) {
        BonRetour entity = dao.findByPrimaryKey("id", id);
        compute(entity, null, Operation.DELETE);
        BonRetour data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new BonRetour(data);
    }

    @Override
    public void processBeforeUpdate(BonRetour entity) {
        BonRetour old = dao.findByPrimaryKey("id", entity.getId());
        compute(entity, old,Operation.UPDATE);
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processBeforeSave(BonRetour entity) {
        compute(entity, null,Operation.NEW);
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    /**
     * 
     * @param entity
     * @param old
     * @param oper 
     */
    private void compute(BonRetour entity,BonRetour old,Operation oper){
        Map<Long,LigneEntree> brmap = new HashMap<Long, LigneEntree>();
        Map<Long,LigneSortie> map = new HashMap<Long, LigneSortie>();
        BonReception bon = entity.getBonlivraison();
        if(entity.getBonlivraison()!=null){
             bon = brdao.findByPrimaryKey("id", bon.getId());
            for(LigneEntree ligne:bon.getLignes()){
                brmap.put(ligne.getId(), ligne);
            }//end for(LigneEntree ligne:bon.getLignes()){
        }//end if(entity.getBonlivraison()!=null){
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
                    if(oper.equals(Operation.DELETE)){
                        lot.addSortie(qte*-1);
                    }else{
                        lot.addSortie(qte);
                    }//end if(oper.equals(Operation.DELETE)){
                    lotdao.update(lot.getId(), lot);
            }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("3")){//FIFO
                  
            }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("4")){//FIFO
                  
            }//end if(ligne.getArticle().getPolitiquestock()==null
            LienEmplacement lien = ligne.getEmplacement();
            Double qte = (oldligne!=null ? oldligne.getQuantite():0.0)-ligne.getQuantite();
            if(oper.equals(Operation.DELETE)){
                lien.addStock(qte*-1);
            }else{
                lien.addStock(qte);
            }//end if(oper.equals(Operation.DELETE)){
            liendao.update(lien.getId(), lien);
            if(ligne.getSource()!=null){
                LigneEntree entree = brmap.get(ligne.getSource().getId());
                if(oper.equals(Operation.DELETE)){
                    entree.addQteRetourne(qte);
                }else{
                    entree.addQteRetourne(qte*-1);
                }//end if(oper.equals(Operation.DELETE)){
            }//end if(ligne.getSource()!=null){
        }//end for(LigneSortie ligne:entity.getLignes()){
        brdao.update(bon.getId(), bon);
    }//end private void computeLigne(LigneDocumentStock ligne , Emplacement empl){

    

    private enum Operation{
        NEW,
        UPDATE,
        DELETE
    }
}
