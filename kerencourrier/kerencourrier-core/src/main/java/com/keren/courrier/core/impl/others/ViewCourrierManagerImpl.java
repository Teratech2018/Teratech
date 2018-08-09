
package com.keren.courrier.core.impl.others;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.others.ViewCourrierManagerLocal;
import com.keren.courrier.core.ifaces.others.ViewCourrierManagerRemote;
import com.keren.courrier.dao.ifaces.others.ViewCourrierDAOLocal;
import com.keren.courrier.model.others.ViewCourrier;

@TransactionAttribute
@Stateless(mappedName = "ViewCourrierManager")
public class ViewCourrierManagerImpl
    extends AbstractGenericManager<ViewCourrier, Long>
    implements ViewCourrierManagerLocal, ViewCourrierManagerRemote
{

    @EJB(name = "ViewCourrierDAO")
    protected ViewCourrierDAOLocal dao;

    public ViewCourrierManagerImpl() {
    }

    @Override
    public GenericDAO<ViewCourrier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
