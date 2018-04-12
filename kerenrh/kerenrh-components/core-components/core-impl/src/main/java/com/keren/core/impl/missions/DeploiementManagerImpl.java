
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.DeploiementManagerLocal;
import com.keren.core.ifaces.missions.DeploiementManagerRemote;
import com.keren.dao.ifaces.missions.DeploiementDAOLocal;
import com.keren.model.missions.Deploiement;

@TransactionAttribute
@Stateless(mappedName = "DeploiementManager")
public class DeploiementManagerImpl
    extends AbstractGenericManager<Deploiement, Long>
    implements DeploiementManagerLocal, DeploiementManagerRemote
{

    @EJB(name = "DeploiementDAO")
    protected DeploiementDAOLocal dao;

    public DeploiementManagerImpl() {
    }

    @Override
    public GenericDAO<Deploiement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
