
package com.core.application;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ResourceRegistryDAO")
public class ResourceRegistryDAOImpl
    extends AbstractGenericDAO<ResourceRegistry, Long>
    implements ResourceRegistryDAOLocal, ResourceRegistryDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ResourceRegistryDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ResourceRegistry> getManagedEntityClass() {
        return (ResourceRegistry.class);
    }

}
