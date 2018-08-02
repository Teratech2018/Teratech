
package com.teratech.gmao.dao.impl.budget;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.budget.BudgetCentreDAOLocal;
import com.teratech.gmao.dao.ifaces.budget.BudgetCentreDAORemote;
import com.teratech.gmao.model.budget.BudgetCentre;

@Stateless(mappedName = "BudgetCentreDAO")
public class BudgetCentreDAOImpl
    extends AbstractGenericDAO<BudgetCentre, Long>
    implements BudgetCentreDAOLocal, BudgetCentreDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public BudgetCentreDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BudgetCentre> getManagedEntityClass() {
        return (BudgetCentre.class);
    }

}
