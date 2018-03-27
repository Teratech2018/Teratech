
package com.keren.core.impl.presences;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.presences.FichePointageManagerLocal;
import com.keren.core.ifaces.presences.FichePointageManagerRemote;
import com.keren.dao.ifaces.presences.FichePointageDAOLocal;
import com.keren.model.presences.FichePointage;

@TransactionAttribute
@Stateless(mappedName = "FichePointageManager")
public class FichePointageManagerImpl
    extends AbstractGenericManager<FichePointage, Long>
    implements FichePointageManagerLocal, FichePointageManagerRemote
{

    @EJB(name = "FichePointageDAO")
    protected FichePointageDAOLocal dao;

    public FichePointageManagerImpl() {
    }

    @Override
    public GenericDAO<FichePointage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
