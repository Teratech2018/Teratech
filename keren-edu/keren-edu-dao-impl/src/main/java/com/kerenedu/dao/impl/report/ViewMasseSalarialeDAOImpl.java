
package com.kerenedu.dao.impl.report;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.dao.ifaces.report.ViewMasseSalarialeDAOLocal;
import com.kerenedu.dao.ifaces.report.ViewMasseSalarialeDAORemote;
import com.kerenedu.model.report.ViewMasseSalariale;

@Stateless(mappedName = "ViewMasseSalarialeDAO")
public class ViewMasseSalarialeDAOImpl
    extends AbstractGenericDAO<ViewMasseSalariale, Long>
    implements ViewMasseSalarialeDAOLocal, ViewMasseSalarialeDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ViewMasseSalarialeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewMasseSalariale> getManagedEntityClass() {
        return (ViewMasseSalariale.class);
    }

}
