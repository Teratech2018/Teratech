
package com.keren.core.impl.presences;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.presences.LigneFichePointageManagerLocal;
import com.keren.core.ifaces.presences.LigneFichePointageManagerRemote;
import com.keren.dao.ifaces.presences.LigneFichePointageDAOLocal;
import com.keren.model.presences.LigneFichePointage;

@TransactionAttribute
@Stateless(mappedName = "LigneFichePointageManager")
public class LigneFichePointageManagerImpl
    extends AbstractGenericManager<LigneFichePointage, Long>
    implements LigneFichePointageManagerLocal, LigneFichePointageManagerRemote
{

    @EJB(name = "LigneFichePointageDAO")
    protected LigneFichePointageDAOLocal dao;

    public LigneFichePointageManagerImpl() {
    }

    @Override
    public GenericDAO<LigneFichePointage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
