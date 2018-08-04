
package com.kerenedu.dao.impl.report;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.dao.ifaces.report.ViewNoteHelperDAOLocal;
import com.kerenedu.dao.ifaces.report.ViewNoteHelperDAORemote;
import com.kerenedu.model.report.ViewNoteHelper;

@Stateless(mappedName = "ViewNoteHelperDAO")
public class ViewNoteHelperDAOImpl
    extends AbstractGenericDAO<ViewNoteHelper, Long>
    implements ViewNoteHelperDAOLocal, ViewNoteHelperDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ViewNoteHelperDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewNoteHelper> getManagedEntityClass() {
        return (ViewNoteHelper.class);
    }

}
