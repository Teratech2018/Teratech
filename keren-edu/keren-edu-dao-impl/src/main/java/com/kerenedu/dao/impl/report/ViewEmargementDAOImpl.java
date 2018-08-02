
package com.kerenedu.dao.impl.report;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.dao.ifaces.report.ViewEmargementDAOLocal;
import com.kerenedu.dao.ifaces.report.ViewEmargementDAORemote;
import com.kerenedu.model.report.ViewEmargement;

@Stateless(mappedName = "ViewEmargementDAO")
public class ViewEmargementDAOImpl
    extends AbstractGenericDAO<ViewEmargement, Long>
    implements ViewEmargementDAOLocal, ViewEmargementDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ViewEmargementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewEmargement> getManagedEntityClass() {
        return (ViewEmargement.class);
    }

}
