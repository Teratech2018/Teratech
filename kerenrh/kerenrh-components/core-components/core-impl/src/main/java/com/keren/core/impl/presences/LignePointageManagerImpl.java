
package com.keren.core.impl.presences;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.presences.LignePointageManagerLocal;
import com.keren.core.ifaces.presences.LignePointageManagerRemote;
import com.keren.dao.ifaces.presences.LignePointageDAOLocal;
import com.keren.model.presences.LignePointage;

@TransactionAttribute
@Stateless(mappedName = "LignePointageManager")
public class LignePointageManagerImpl
    extends AbstractGenericManager<LignePointage, Long>
    implements LignePointageManagerLocal, LignePointageManagerRemote
{

    @EJB(name = "LignePointageDAO")
    protected LignePointageDAOLocal dao;

    public LignePointageManagerImpl() {
    }

    @Override
    public GenericDAO<LignePointage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
