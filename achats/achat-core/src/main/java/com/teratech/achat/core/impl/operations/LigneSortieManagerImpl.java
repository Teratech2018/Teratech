
package com.teratech.achat.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.achat.core.ifaces.operations.LigneSortieManagerLocal;
import com.teratech.achat.core.ifaces.operations.LigneSortieManagerRemote;
import com.teratech.achat.dao.ifaces.operations.LigneSortieDAOLocal;
import com.teratech.achat.model.operations.LigneSortie;

@TransactionAttribute
@Stateless(mappedName = "LigneSortieManager")
public class LigneSortieManagerImpl
    extends AbstractGenericManager<LigneSortie, Long>
    implements LigneSortieManagerLocal, LigneSortieManagerRemote
{

    @EJB(name = "LigneSortieDAO")
    protected LigneSortieDAOLocal dao;

    public LigneSortieManagerImpl() {
    }

    @Override
    public GenericDAO<LigneSortie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
