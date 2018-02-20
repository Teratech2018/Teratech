
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ConfigMailDAO")
public class ConfigMailDAOImpl
    extends AbstractGenericDAO<ConfigMail, Long>
    implements ConfigMailDAOLocal, ConfigMailDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ConfigMailDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ConfigMail> getManagedEntityClass() {
        return (ConfigMail.class);
    }

}
