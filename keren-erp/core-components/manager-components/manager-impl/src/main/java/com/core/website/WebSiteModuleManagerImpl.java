
package com.core.website;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "WebSiteModuleManager")
public class WebSiteModuleManagerImpl
    extends AbstractGenericManager<WebSiteModule, Long>
    implements WebSiteModuleManagerLocal, WebSiteModuleManagerRemote
{

    @EJB(name = "WebSiteModuleDAO")
    protected WebSiteModuleDAOLocal dao;

    public WebSiteModuleManagerImpl() {
    }

    @Override
    public GenericDAO<WebSiteModule, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
