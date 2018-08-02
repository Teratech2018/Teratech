
package com.teratech.gmao.core.impl.budget;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.budget.LigneBudgetSaisieManagerLocal;
import com.teratech.gmao.core.ifaces.budget.LigneBudgetSaisieManagerRemote;
import com.teratech.gmao.dao.ifaces.budget.LigneBudgetSaisieDAOLocal;
import com.teratech.gmao.model.budget.LigneBudgetSaisie;

@TransactionAttribute
@Stateless(mappedName = "LigneBudgetSaisieManager")
public class LigneBudgetSaisieManagerImpl
    extends AbstractGenericManager<LigneBudgetSaisie, Long>
    implements LigneBudgetSaisieManagerLocal, LigneBudgetSaisieManagerRemote
{

    @EJB(name = "LigneBudgetSaisieDAO")
    protected LigneBudgetSaisieDAOLocal dao;

    public LigneBudgetSaisieManagerImpl() {
    }

    @Override
    public GenericDAO<LigneBudgetSaisie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
