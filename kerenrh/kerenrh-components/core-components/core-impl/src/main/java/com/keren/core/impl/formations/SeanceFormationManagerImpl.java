
package com.keren.core.impl.formations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.formations.SeanceFormationManagerLocal;
import com.keren.core.ifaces.formations.SeanceFormationManagerRemote;
import com.keren.dao.ifaces.formations.SeanceFormationDAOLocal;
import com.keren.model.formations.SeanceFormation;

@TransactionAttribute
@Stateless(mappedName = "SeanceFormationManager")
public class SeanceFormationManagerImpl
    extends AbstractGenericManager<SeanceFormation, Long>
    implements SeanceFormationManagerLocal, SeanceFormationManagerRemote
{

    @EJB(name = "SeanceFormationDAO")
    protected SeanceFormationDAOLocal dao;

    public SeanceFormationManagerImpl() {
    }

    @Override
    public GenericDAO<SeanceFormation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
