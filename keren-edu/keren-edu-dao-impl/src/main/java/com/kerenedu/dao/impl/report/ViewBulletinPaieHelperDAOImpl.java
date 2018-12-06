
package com.kerenedu.dao.impl.report;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.dao.ifaces.report.ViewBulletinPaieHelperDAOLocal;
import com.kerenedu.dao.ifaces.report.ViewBulletinPaieHelperDAORemote;
import com.kerenedu.model.report.ViewBulletinPaieHelper;

@Stateless(mappedName = "ViewBulletinPaieHelperDAO")
public class ViewBulletinPaieHelperDAOImpl
    extends AbstractGenericDAO<ViewBulletinPaieHelper, Long>
    implements ViewBulletinPaieHelperDAOLocal, ViewBulletinPaieHelperDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ViewBulletinPaieHelperDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewBulletinPaieHelper> getManagedEntityClass() {
        return (ViewBulletinPaieHelper.class);
    }

}
