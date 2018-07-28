
package com.teratech.gmao.core.impl.budget;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.budget.BudgetDivisionManagerLocal;
import com.teratech.gmao.core.ifaces.budget.BudgetDivisionManagerRemote;
import com.teratech.gmao.dao.ifaces.budget.BudgetDivisionDAOLocal;
import com.teratech.gmao.model.budget.BudgetDivision;
import com.teratech.gmao.model.budget.LigneBudget;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "BudgetDivisionManager")
public class BudgetDivisionManagerImpl
    extends AbstractGenericManager<BudgetDivision, Long>
    implements BudgetDivisionManagerLocal, BudgetDivisionManagerRemote
{

    @EJB(name = "BudgetDivisionDAO")
    protected BudgetDivisionDAOLocal dao;

    public BudgetDivisionManagerImpl() {
    }

    @Override
    public GenericDAO<BudgetDivision, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<BudgetDivision> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addNotNull("division", null);
        predicats.addAll(container.getPredicats());
        List<BudgetDivision> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<BudgetDivision> results = new ArrayList<BudgetDivision>();
        for(BudgetDivision data:datas){
            results.add(new BudgetDivision(data));
        }//end for(BudgetDivision data:datas){
        return results;
    }

    @Override
    public List<BudgetDivision> findAll() {
        List<BudgetDivision> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<BudgetDivision> results = new ArrayList<BudgetDivision>();
        for(BudgetDivision data:datas){
            results.add(new BudgetDivision(data));
        }//end for(BudgetDivision data:datas){
        return results;
    }

    @Override
    public BudgetDivision find(String propertyName, Long entityID) {
        //To change body of generated methods, choose Tools | Templates.
        BudgetDivision data = super.find(propertyName, entityID); 
        BudgetDivision result = new BudgetDivision(data);
        for(LigneBudget ligne:data.getLignes()){
            result.getLignes().add(new LigneBudget(ligne));
        }//end for(LigneBudget ligne:data.getLignes()){
        return result;
    }

    @Override
    public BudgetDivision delete(Long id) {
        BudgetDivision data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        BudgetDivision result = new BudgetDivision(data);
        return result;
    }

    @Override
    public Long count(List<Predicat> predicats) {
         RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addNotNull("division", null);
        predicats.addAll(container.getPredicats());
        return super.count(predicats); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
