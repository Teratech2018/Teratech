
package com.teratech.gmao.dao.impl.budget;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.budget.BudgetEquipementDAOLocal;
import com.teratech.gmao.dao.ifaces.budget.BudgetEquipementDAORemote;
import com.teratech.gmao.model.budget.BudgetEquipement;

@Stateless(mappedName = "BudgetEquipementDAO")
public class BudgetEquipementDAOImpl
    extends AbstractGenericDAO<BudgetEquipement, Long>
    implements BudgetEquipementDAOLocal, BudgetEquipementDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public BudgetEquipementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BudgetEquipement> getManagedEntityClass() {
        return (BudgetEquipement.class);
    }

}
