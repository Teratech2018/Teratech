
package com.kerenedu.core.impl.report;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerenedu.core.ifaces.report.ViewNoteHelperManagerLocal;
import com.kerenedu.core.ifaces.report.ViewNoteHelperManagerRemote;
import com.kerenedu.dao.ifaces.report.ViewNoteHelperDAOLocal;
import com.kerenedu.model.report.ViewNoteHelper;

@TransactionAttribute
@Stateless(mappedName = "ViewNoteHelperManager")
public class ViewNoteHelperManagerImpl
    extends AbstractGenericManager<ViewNoteHelper, Long>
    implements ViewNoteHelperManagerLocal, ViewNoteHelperManagerRemote
{

    @EJB(name = "ViewNoteHelperDAO")
    protected ViewNoteHelperDAOLocal dao;

    public ViewNoteHelperManagerImpl() {
    }

    @Override
    public GenericDAO<ViewNoteHelper, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
