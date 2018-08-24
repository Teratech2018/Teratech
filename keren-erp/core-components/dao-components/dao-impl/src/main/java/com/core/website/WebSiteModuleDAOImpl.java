
package com.core.website;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "WebSiteModuleDAO")
public class WebSiteModuleDAOImpl
    extends AbstractGenericDAO<WebSiteModule, Long>
    implements WebSiteModuleDAOLocal, WebSiteModuleDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public WebSiteModuleDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<WebSiteModule> getManagedEntityClass() {
        return (WebSiteModule.class);
    }

}
