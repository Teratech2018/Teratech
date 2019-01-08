
package com.teratech.vente.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.vente.core.ifaces.base.ConditionPaiementManagerLocal;
import com.teratech.vente.core.ifaces.base.ConditionPaiementManagerRemote;
import com.teratech.vente.dao.ifaces.base.ConditionPaiementDAOLocal;
import com.teratech.vente.model.base.ConditionPaiement;

@TransactionAttribute
@Stateless(mappedName = "ConditionPaiementManager")
public class ConditionPaiementManagerImpl
    extends AbstractGenericManager<ConditionPaiement, Long>
    implements ConditionPaiementManagerLocal, ConditionPaiementManagerRemote
{

    @EJB(name = "ConditionPaiementDAO")
    protected ConditionPaiementDAOLocal dao;

    public ConditionPaiementManagerImpl() {
    }

    @Override
    public GenericDAO<ConditionPaiement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
