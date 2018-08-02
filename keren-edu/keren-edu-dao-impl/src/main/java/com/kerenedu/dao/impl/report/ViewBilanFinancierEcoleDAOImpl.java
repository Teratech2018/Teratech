
package com.kerenedu.dao.impl.report;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.dao.ifaces.report.ViewBilanFinancierEcoleDAOLocal;
import com.kerenedu.dao.ifaces.report.ViewBilanFinancierEcoleDAORemote;
import com.kerenedu.model.report.ViewBilanFinancierEcole;

@Stateless(mappedName = "ViewBilanFinancierEcoleDAO")
public class ViewBilanFinancierEcoleDAOImpl
    extends AbstractGenericDAO<ViewBilanFinancierEcole, Long>
    implements ViewBilanFinancierEcoleDAOLocal, ViewBilanFinancierEcoleDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ViewBilanFinancierEcoleDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewBilanFinancierEcole> getManagedEntityClass() {
        return (ViewBilanFinancierEcole.class);
    }

}
