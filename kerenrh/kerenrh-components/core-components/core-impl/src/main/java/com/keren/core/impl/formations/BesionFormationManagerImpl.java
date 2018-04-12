
package com.keren.core.impl.formations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.formations.BesionFormationManagerLocal;
import com.keren.core.ifaces.formations.BesionFormationManagerRemote;
import com.keren.dao.ifaces.formations.BesionFormationDAOLocal;
import com.keren.model.formations.BesionFormation;

@TransactionAttribute
@Stateless(mappedName = "BesionFormationManager")
public class BesionFormationManagerImpl
    extends AbstractGenericManager<BesionFormation, Long>
    implements BesionFormationManagerLocal, BesionFormationManagerRemote
{

    @EJB(name = "BesionFormationDAO")
    protected BesionFormationDAOLocal dao;

    public BesionFormationManagerImpl() {
    }

    @Override
    public GenericDAO<BesionFormation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
