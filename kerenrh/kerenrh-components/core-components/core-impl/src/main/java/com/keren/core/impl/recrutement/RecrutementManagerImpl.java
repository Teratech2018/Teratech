
package com.keren.core.impl.recrutement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.recrutement.RecrutementManagerLocal;
import com.keren.core.ifaces.recrutement.RecrutementManagerRemote;
import com.keren.dao.ifaces.recrutement.RecrutementDAOLocal;
import com.keren.model.recrutement.Recrutement;

@TransactionAttribute
@Stateless(mappedName = "RecrutementManager")
public class RecrutementManagerImpl
    extends AbstractGenericManager<Recrutement, Long>
    implements RecrutementManagerLocal, RecrutementManagerRemote
{

    @EJB(name = "RecrutementDAO")
    protected RecrutementDAOLocal dao;

    public RecrutementManagerImpl() {
    }

    @Override
    public GenericDAO<Recrutement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
