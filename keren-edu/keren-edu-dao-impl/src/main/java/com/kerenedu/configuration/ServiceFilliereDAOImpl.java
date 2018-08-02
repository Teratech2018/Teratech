
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ServiceFilliereDAO")
public class ServiceFilliereDAOImpl
    extends AbstractGenericDAO<ServiceFilliere, Long>
    implements ServiceFilliereDAOLocal, ServiceFilliereDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ServiceFilliereDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ServiceFilliere> getManagedEntityClass() {
        return (ServiceFilliere.class);
    }

}
