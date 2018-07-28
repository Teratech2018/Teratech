
package com.teratech.gmao.dao.impl.budget;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.budget.BudgetDivisionDAOLocal;
import com.teratech.gmao.dao.ifaces.budget.BudgetDivisionDAORemote;
import com.teratech.gmao.model.budget.BudgetDivision;

@Stateless(mappedName = "BudgetDivisionDAO")
public class BudgetDivisionDAOImpl
    extends AbstractGenericDAO<BudgetDivision, Long>
    implements BudgetDivisionDAOLocal, BudgetDivisionDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public BudgetDivisionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BudgetDivision> getManagedEntityClass() {
        return (BudgetDivision.class);
    }

}
