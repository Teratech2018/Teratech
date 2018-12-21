
package com.core.templates;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "TemplateManager")
public class TemplateManagerImpl
    extends AbstractGenericManager<Template, Long>
    implements TemplateManagerLocal, TemplateManagerRemote
{

    @EJB(name = "TemplateDAO")
    protected TemplateDAOLocal dao;

    public TemplateManagerImpl() {
    }

    @Override
    public GenericDAO<Template, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
