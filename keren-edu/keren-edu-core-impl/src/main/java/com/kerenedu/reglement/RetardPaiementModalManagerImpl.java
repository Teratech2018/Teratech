
package com.kerenedu.reglement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "RetardPaiementModalManager")
public class RetardPaiementModalManagerImpl
    extends AbstractGenericManager<RetardPaiementModal, Long>
    implements RetardPaiementModalManagerLocal, RetardPaiementModalManagerRemote
{

    @EJB(name = "RetardPaiementModalDAO")
    protected RetardPaiementModalDAOLocal dao;

    public RetardPaiementModalManagerImpl() {
    }

    @Override
    public GenericDAO<RetardPaiementModal, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
