
package com.kerenedu.dao.impl.report;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.dao.ifaces.report.ViewEtatPretDAOLocal;
import com.kerenedu.dao.ifaces.report.ViewEtatPretDAORemote;
import com.kerenedu.model.report.ViewEtatPret;

@Stateless(mappedName = "ViewEtatPretDAO")
public class ViewEtatPretDAOImpl
    extends AbstractGenericDAO<ViewEtatPret, Long>
    implements ViewEtatPretDAOLocal, ViewEtatPretDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ViewEtatPretDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewEtatPret> getManagedEntityClass() {
        return (ViewEtatPret.class);
    }

}
