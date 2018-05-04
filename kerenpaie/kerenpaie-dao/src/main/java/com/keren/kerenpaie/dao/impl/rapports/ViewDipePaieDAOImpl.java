
package com.keren.kerenpaie.dao.impl.rapports;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.rapports.ViewDipePaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.rapports.ViewDipePaieDAORemote;
import com.keren.kerenpaie.model.rapports.ViewDipePaie;

@Stateless(mappedName = "ViewDipePaieDAO")
public class ViewDipePaieDAOImpl
    extends AbstractGenericDAO<ViewDipePaie, Long>
    implements ViewDipePaieDAOLocal, ViewDipePaieDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public ViewDipePaieDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewDipePaie> getManagedEntityClass() {
        return (ViewDipePaie.class);
    }

}
