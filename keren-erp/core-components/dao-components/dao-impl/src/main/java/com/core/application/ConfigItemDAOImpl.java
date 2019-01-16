
package com.core.application;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ConfigItemDAO")
public class ConfigItemDAOImpl
    extends AbstractGenericDAO<ConfigItem, Long>
    implements ConfigItemDAOLocal, ConfigItemDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ConfigItemDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ConfigItem> getManagedEntityClass() {
        return (ConfigItem.class);
    }

}
