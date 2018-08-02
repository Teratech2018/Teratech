
package com.teratech.gmao.core.impl.budget;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.budget.BudgetEquipementManagerLocal;
import com.teratech.gmao.core.ifaces.budget.BudgetEquipementManagerRemote;
import com.teratech.gmao.dao.ifaces.budget.BudgetEquipementDAOLocal;
import com.teratech.gmao.model.budget.BudgetEquipement;
import com.teratech.gmao.model.budget.LigneBudget;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "BudgetEquipementManager")
public class BudgetEquipementManagerImpl
    extends AbstractGenericManager<BudgetEquipement, Long>
    implements BudgetEquipementManagerLocal, BudgetEquipementManagerRemote
{

    @EJB(name = "BudgetEquipementDAO")
    protected BudgetEquipementDAOLocal dao;

    public BudgetEquipementManagerImpl() {
    }

    @Override
    public GenericDAO<BudgetEquipement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<BudgetEquipement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addNotNull("equipement", null);
        predicats.addAll(container.getPredicats());
        List<BudgetEquipement> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<BudgetEquipement> results = new ArrayList<BudgetEquipement>();
        for(BudgetEquipement data:datas){
            results.add(new BudgetEquipement(data));
        }//end for(BudgetEquipement data:datas){
        return results;
    }

    @Override
    public List<BudgetEquipement> findAll() {
        List<BudgetEquipement> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<BudgetEquipement> results = new ArrayList<BudgetEquipement>();
        for(BudgetEquipement data:datas){
            results.add(new BudgetEquipement(data));
        }//end for(BudgetEquipement data:datas){
        return results;
    }

    @Override
    public BudgetEquipement find(String propertyName, Long entityID) {
         //To change body of generated methods, choose Tools | Templates.
        BudgetEquipement data =super.find(propertyName, entityID);
        BudgetEquipement entity = new BudgetEquipement(data);
        for(LigneBudget ligne:data.getLignes()){
            entity.getLignes().add(new LigneBudget(ligne));
        }//end for(LigneBudget ligne:data.getLignes()){
        return entity;
    }

    @Override
    public BudgetEquipement delete(Long id) {
        BudgetEquipement data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        BudgetEquipement entity = new BudgetEquipement(data);
        return entity;
    }

    @Override
    public Long count(List<Predicat> predicats) {
         RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addNotNull("equipement", null);
        predicats.addAll(container.getPredicats());
        return super.count(predicats); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
