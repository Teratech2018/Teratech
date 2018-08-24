
package com.core.website;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "WebSiteComponentDAO")
public class WebSiteComponentDAOImpl
    extends AbstractGenericDAO<WebSiteComponent, Long>
    implements WebSiteComponentDAOLocal, WebSiteComponentDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public WebSiteComponentDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<WebSiteComponent> getManagedEntityClass() {
        return (WebSiteComponent.class);
    }

}
