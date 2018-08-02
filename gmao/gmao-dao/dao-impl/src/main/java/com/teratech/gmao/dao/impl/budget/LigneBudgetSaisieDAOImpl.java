
package com.teratech.gmao.dao.impl.budget;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.budget.LigneBudgetSaisieDAOLocal;
import com.teratech.gmao.dao.ifaces.budget.LigneBudgetSaisieDAORemote;
import com.teratech.gmao.model.budget.LigneBudgetSaisie;

@Stateless(mappedName = "LigneBudgetSaisieDAO")
public class LigneBudgetSaisieDAOImpl
    extends AbstractGenericDAO<LigneBudgetSaisie, Long>
    implements LigneBudgetSaisieDAOLocal, LigneBudgetSaisieDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public LigneBudgetSaisieDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneBudgetSaisie> getManagedEntityClass() {
        return (LigneBudgetSaisie.class);
    }

}
