
package com.core.website;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "WebSiteComponentManager")
public class WebSiteComponentManagerImpl
    extends AbstractGenericManager<WebSiteComponent, Long>
    implements WebSiteComponentManagerLocal, WebSiteComponentManagerRemote
{

    @EJB(name = "WebSiteComponentDAO")
    protected WebSiteComponentDAOLocal dao;

    public WebSiteComponentManagerImpl() {
    }

    @Override
    public GenericDAO<WebSiteComponent, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
