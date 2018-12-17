
package com.kerenedu.notes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "LigneHelperManager")
public class LigneHelperManagerImpl
    extends AbstractGenericManager<LigneHelper, Long>
    implements LigneHelperManagerLocal, LigneHelperManagerRemote
{

    @EJB(name = "LigneHelperDAO")
    protected LigneHelperDAOLocal dao;

    public LigneHelperManagerImpl() {
    }

    @Override
    public GenericDAO<LigneHelper, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
