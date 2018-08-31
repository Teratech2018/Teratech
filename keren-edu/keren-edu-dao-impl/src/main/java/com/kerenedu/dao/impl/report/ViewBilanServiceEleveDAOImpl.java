
package com.kerenedu.dao.impl.report;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.dao.ifaces.report.ViewBilanServiceEleveDAOLocal;
import com.kerenedu.dao.ifaces.report.ViewBilanServiceEleveDAORemote;
import com.kerenedu.model.report.ViewBilanServiceEleve;

@Stateless(mappedName = "ViewBilanServiceEleveDAO")
public class ViewBilanServiceEleveDAOImpl
    extends AbstractGenericDAO<ViewBilanServiceEleve, Long>
    implements ViewBilanServiceEleveDAOLocal, ViewBilanServiceEleveDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ViewBilanServiceEleveDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewBilanServiceEleve> getManagedEntityClass() {
        return (ViewBilanServiceEleve.class);
    }

}
