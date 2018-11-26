
package com.kerenedu.discipline;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "ViewAbscenceManager")
public class ViewAbscenceManagerImpl
    extends AbstractGenericManager<ViewAbscence, Long>
    implements ViewAbscenceManagerLocal, ViewAbscenceManagerRemote
{

    @EJB(name = "ViewAbscenceDAO")
    protected ViewAbscenceDAOLocal dao;

    public ViewAbscenceManagerImpl() {
    }

    @Override
    public GenericDAO<ViewAbscence, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
