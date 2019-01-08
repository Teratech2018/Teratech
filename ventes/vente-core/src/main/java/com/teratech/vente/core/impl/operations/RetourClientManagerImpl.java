
package com.teratech.vente.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.vente.core.ifaces.operations.RetourClientManagerLocal;
import com.teratech.vente.core.ifaces.operations.RetourClientManagerRemote;
import com.teratech.vente.dao.ifaces.base.ArticleDAOLocal;
import com.teratech.vente.dao.ifaces.base.LienEmplacementDAOLocal;
import com.teratech.vente.dao.ifaces.operations.BonLivraisonDAOLocal;
import com.teratech.vente.dao.ifaces.operations.LotDAOLocal;
import com.teratech.vente.dao.ifaces.operations.RetourClientDAOLocal;
import com.teratech.vente.model.base.Article;
import com.teratech.vente.model.base.LienEmplacement;
import com.teratech.vente.model.operations.BonLivraison;
import com.teratech.vente.model.operations.LIgneBonLivraison;
import com.teratech.vente.model.operations.LIgneRetourClient;
import com.teratech.vente.model.operations.Lot;
import com.teratech.vente.model.operations.RetourClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "RetourClientManager")
public class RetourClientManagerImpl
    extends AbstractGenericManager<RetourClient, Long>
    implements RetourClientManagerLocal, RetourClientManagerRemote
{

    @EJB(name = "RetourClientDAO")
    protected RetourClientDAOLocal dao;
    
     @EJB(name = "ArticleDAO")
    protected ArticleDAOLocal articledao;
    
    @EJB(name = "LotDAO")
    protected LotDAOLocal lotdao;
    
    @EJB(name = "LienEmplacementDAO")
    protected LienEmplacementDAOLocal liendao;
    
    @EJB(name = "BonLivraisonDAO")
    protected BonLivraisonDAOLocal bldao;
    

    public RetourClientManagerImpl() {
    }

    @Override
    public GenericDAO<RetourClient, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<RetourClient> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<RetourClient> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<RetourClient> result = new ArrayList<RetourClient>();
        for(RetourClient data:datas){
            result.add(new RetourClient(data));
        }
        return result;
    }

    @Override
    public RetourClient find(String propertyName, Long entityID) {
        RetourClient data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        RetourClient entity = new RetourClient(data);
        for(LIgneRetourClient ligne:data.getLignes()){
            entity.getLignes().add(new LIgneRetourClient(ligne));
        }
        return entity;
    }

    @Override
    public RetourClient delete(Long id) {
        RetourClient data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        compute(data, null, Operation.DELETE);
        return new RetourClient(data);
    }

    /**
     * 
     * @param entity
     * @param old
     * @param oper 
     */
    private void compute(RetourClient entity,RetourClient old ,Operation oper){
        Map<Long,LIgneRetourClient> map = new HashMap<Long,LIgneRetourClient>();
        Map<Long ,LIgneBonLivraison> map2= new HashMap<Long ,LIgneBonLivraison>();
        BonLivraison bl = bldao.findByPrimaryKey("id", entity.getLivraison().getId());
        for(LIgneBonLivraison ligne:bl.getLignes()){
            map2.put(ligne.getId(), ligne);
        }//end for(LIgneBonLivraison ligne:bl.getLignes()){
        if(old!=null){
            for(LIgneRetourClient ligne:old.getLignes()){
               map.put(ligne.getId(), ligne);
            }//end for(LIgneRetourClient ligne:old.getLignes()){
        }//end if(old!=null){
        Double totalht = 0.0;
        for(LIgneRetourClient ligne:entity.getLignes()){
            LIgneBonLivraison lignebl = map2.get(ligne.getSource().getId());
            totalht+=ligne.getQuantite()*ligne.getPuht();
            LIgneRetourClient oldligne = map.get(ligne.getId());
            LienEmplacement lien = ligne.getEmplacement();
            lien = liendao.findByPrimaryKey("id", lien.getId());
            if(ligne.getLot()!=null){
                Double qte = ligne.getQuantite()-(oldligne==null ? 0.0:oldligne.getQuantite());
                if(oper.equals(Operation.DELETE)){
                    ligne.getLot().addSortie(qte);           
                }else{
                    ligne.getLot().addSortie(qte*-1);
                
                }//end if(oper.equals(Operation.DELETE)){
                lotdao.update(ligne.getLot().getId(), ligne.getLot());
            }//end if(ligne.getLot()!=null){
            Double qte = ligne.getQuantite()-(oldligne==null ? 0.0:oldligne.getQuantite());
            if(oper.equals(Operation.DELETE)){
                lien.addStock(qte*-1);
                lignebl.addRetour(qte*-1);
                
            }else{
                lien.addStock(qte);
                lignebl.addRetour(qte);                
            }//end if(oper.equals(Operation.DELETE)){     
            liendao.update(lien.getId(), lien);
        }//end for(LIgneRetourClient ligne:entity.getLignes()){
        entity.setTotalht(totalht);
        bldao.update(bl.getId(), bl);
    }//end private void computeLigne(LigneDocumentStock ligne , Emplacement empl){

    @Override
    public void processBeforeUpdate(RetourClient entity) {
        RetourClient old = dao.findByPrimaryKey("id", entity.getId());
        compute(entity,old,Operation.UPDATE);
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processBeforeSave(RetourClient entity) {
        compute(entity,null,Operation.NEW);
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    public enum Operation{
        NEW,
        UPDATE,
        DELETE
    }
    
}
