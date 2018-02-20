
package com.kerenedu.dao.impl.report;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.dao.ifaces.report.ViewBulletinDAOLocal;
import com.kerenedu.dao.ifaces.report.ViewBulletinDAORemote;
import com.kerenedu.model.report.ViewBulletin;

@Stateless(mappedName = "ViewBulletinDAO")
public class ViewBulletinDAOImpl
    extends AbstractGenericDAO<ViewBulletin, Long>
    implements ViewBulletinDAOLocal, ViewBulletinDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ViewBulletinDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewBulletin> getManagedEntityClass() {
        return (ViewBulletin.class);
    }

}
