
package com.core.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import java.util.List;

@TransactionAttribute
@Stateless(mappedName = "ServiceRegistryManager")
public class ServiceRegistryManagerImpl
    extends AbstractGenericManager<ServiceRegistry, Long>
    implements ServiceRegistryManagerLocal, ServiceRegistryManagerRemote
{

    @EJB(name = "ServiceRegistryDAO")
    protected ServiceRegistryDAOLocal dao;

    public ServiceRegistryManagerImpl() {
    }

    @Override
    public GenericDAO<ServiceRegistry, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public ServiceRegistry getService(String servicename) {
        //To change body of generated methods, choose Tools | Templates.
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("code", servicename);
        List<ServiceRegistry> entities = dao.filter(container.getPredicats(), null, null, 0, -1);
        return entities.isEmpty() ? null : entities.get(0);
    }

}
