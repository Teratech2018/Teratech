
package com.keren.core.impl.discipline;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.discipline.LigneResolutionManagerLocal;
import com.keren.core.ifaces.discipline.LigneResolutionManagerRemote;
import com.keren.dao.ifaces.discipline.LigneResolutionDAOLocal;
import com.keren.model.discipline.LigneResolution;

@TransactionAttribute
@Stateless(mappedName = "LigneResolutionManager")
public class LigneResolutionManagerImpl
    extends AbstractGenericManager<LigneResolution, Long>
    implements LigneResolutionManagerLocal, LigneResolutionManagerRemote
{

    @EJB(name = "LigneResolutionDAO")
    protected LigneResolutionDAOLocal dao;

    public LigneResolutionManagerImpl() {
    }

    @Override
    public GenericDAO<LigneResolution, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
