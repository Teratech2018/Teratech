
package com.keren.kerenpaie.core.impl.presences;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.presences.LignePointageManagerLocal;
import com.keren.kerenpaie.core.ifaces.presences.LignePointageManagerRemote;
import com.keren.kerenpaie.dao.ifaces.presences.LignePointageDAOLocal;
import com.keren.kerenpaie.model.presences.LignePointage;

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
