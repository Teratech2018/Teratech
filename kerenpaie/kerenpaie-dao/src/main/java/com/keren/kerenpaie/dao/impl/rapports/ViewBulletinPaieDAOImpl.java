
package com.keren.kerenpaie.dao.impl.rapports;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.rapports.ViewBulletinPaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.rapports.ViewBulletinPaieDAORemote;
import com.keren.kerenpaie.model.rapports.ViewBulletinPaie;

@Stateless(mappedName = "ViewBulletinPaieDAO")
public class ViewBulletinPaieDAOImpl
    extends AbstractGenericDAO<ViewBulletinPaie, Long>
    implements ViewBulletinPaieDAOLocal, ViewBulletinPaieDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public ViewBulletinPaieDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewBulletinPaie> getManagedEntityClass() {
        return (ViewBulletinPaie.class);
    }

}
