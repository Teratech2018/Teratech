
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ServiceDAO")
public class ServiceDAOImpl
    extends AbstractGenericDAO<Service, Long>
    implements ServiceDAOLocal, ServiceDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ServiceDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Service> getManagedEntityClass() {
        return (Service.class);
    }

}
