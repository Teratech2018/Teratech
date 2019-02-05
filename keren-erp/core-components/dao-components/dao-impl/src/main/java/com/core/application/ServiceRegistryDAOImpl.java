
package com.core.application;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ServiceRegistryDAO")
public class ServiceRegistryDAOImpl
    extends AbstractGenericDAO<ServiceRegistry, Long>
    implements ServiceRegistryDAOLocal, ServiceRegistryDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ServiceRegistryDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ServiceRegistry> getManagedEntityClass() {
        return (ServiceRegistry.class);
    }

//    @Override
//    public ServiceRegistry getService(String servicename) {
//        //To change body of generated methods, choose Tools | Templates.
//         RestrictionsContainer container = RestrictionsContainer.newInstance();
//        container.addEq("code", servicename);
//        List<ServiceRegistry> entities = super.filter(container.getPredicats(), null, null, 0, -1);
//        return entities.isEmpty() ? null : entities.get(0);
//    }

}
