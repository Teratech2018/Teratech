
package com.teratech.gmao.core.impl.budget;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.budget.BudgetCentreManagerLocal;
import com.teratech.gmao.core.ifaces.budget.BudgetCentreManagerRemote;
import com.teratech.gmao.dao.ifaces.budget.BudgetCentreDAOLocal;
import com.teratech.gmao.model.budget.BudgetCentre;
import com.teratech.gmao.model.budget.LigneBudget;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "BudgetCentreManager")
public class BudgetCentreManagerImpl
    extends AbstractGenericManager<BudgetCentre, Long>
    implements BudgetCentreManagerLocal, BudgetCentreManagerRemote
{

    @EJB(name = "BudgetCentreDAO")
    protected BudgetCentreDAOLocal dao;

    public BudgetCentreManagerImpl() {
    }

    @Override
    public GenericDAO<BudgetCentre, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<BudgetCentre> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addNotNull("centre", null);
        predicats.addAll(container.getPredicats());
        List<BudgetCentre> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<BudgetCentre> results = new ArrayList<BudgetCentre>();
        for(BudgetCentre data:datas){
            results.add(new BudgetCentre(data));
        }//end  for(BudgetCentre data:datas){
        return results;
    }

    @Override
    public List<BudgetCentre> findAll() {
        List<BudgetCentre> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<BudgetCentre> results = new ArrayList<BudgetCentre>();
        for(BudgetCentre data:datas){
            results.add(new BudgetCentre(data));
        }//end  for(BudgetCentre data:datas){
        return results;
    }

    @Override
    public BudgetCentre find(String propertyName, Long entityID) {
        BudgetCentre data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        BudgetCentre entity = new BudgetCentre(data);
        for(LigneBudget ligne:data.getLignes()){
            entity.getLignes().add(new LigneBudget(ligne));
        }//end for(LigneBudget ligne:data.getLignes()){
        return entity;
    }

    @Override
    public BudgetCentre delete(Long id) {
        BudgetCentre data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new BudgetCentre(data);
    }

    @Override
    public Long count(List<Predicat> predicats) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addNotNull("centre", null);
        predicats.addAll(container.getPredicats());
        return super.count(predicats); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
