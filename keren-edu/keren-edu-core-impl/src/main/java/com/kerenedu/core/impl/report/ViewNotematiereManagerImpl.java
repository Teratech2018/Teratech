
package com.kerenedu.core.impl.report;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerenedu.core.ifaces.report.ViewNotematiereManagerLocal;
import com.kerenedu.core.ifaces.report.ViewNotematiereManagerRemote;
import com.kerenedu.dao.ifaces.report.ViewNotematiereDAOLocal;
import com.kerenedu.model.report.ViewNotematiere;

@TransactionAttribute
@Stateless(mappedName = "ViewNotematiereManager")
public class ViewNotematiereManagerImpl
    extends AbstractGenericManager<ViewNotematiere, Long>
    implements ViewNotematiereManagerLocal, ViewNotematiereManagerRemote
{

    @EJB(name = "ViewNotematiereDAO")
    protected ViewNotematiereDAOLocal dao;

    public ViewNotematiereManagerImpl() {
    }

    @Override
    public GenericDAO<ViewNotematiere, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
