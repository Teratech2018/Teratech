
package com.kerenedu.dao.impl.report;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.dao.ifaces.report.ViewBilanFinancierDAOLocal;
import com.kerenedu.dao.ifaces.report.ViewBilanFinancierDAORemote;
import com.kerenedu.model.report.ViewBilanFinancier;

@Stateless(mappedName = "ViewBilanFinancierDAO")
public class ViewBilanFinancierDAOImpl
    extends AbstractGenericDAO<ViewBilanFinancier, Long>
    implements ViewBilanFinancierDAOLocal, ViewBilanFinancierDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ViewBilanFinancierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewBilanFinancier> getManagedEntityClass() {
        return (ViewBilanFinancier.class);
    }

}
