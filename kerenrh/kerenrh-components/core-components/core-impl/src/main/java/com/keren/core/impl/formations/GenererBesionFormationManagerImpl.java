
package com.keren.core.impl.formations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.formations.GenererBesionFormationManagerLocal;
import com.keren.core.ifaces.formations.GenererBesionFormationManagerRemote;
import com.keren.dao.ifaces.formations.GenererBesionFormationDAOLocal;
import com.keren.model.formations.GenererBesionFormation;

@TransactionAttribute
@Stateless(mappedName = "GenererBesionFormationManager")
public class GenererBesionFormationManagerImpl
    extends AbstractGenericManager<GenererBesionFormation, Long>
    implements GenererBesionFormationManagerLocal, GenererBesionFormationManagerRemote
{

    @EJB(name = "GenererBesionFormationDAO")
    protected GenererBesionFormationDAOLocal dao;

    public GenererBesionFormationManagerImpl() {
    }

    @Override
    public GenericDAO<GenererBesionFormation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
