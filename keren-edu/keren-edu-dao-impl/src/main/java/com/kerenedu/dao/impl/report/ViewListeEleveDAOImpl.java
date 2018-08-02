
package com.kerenedu.dao.impl.report;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.dao.ifaces.report.ViewListeEleveDAOLocal;
import com.kerenedu.dao.ifaces.report.ViewListeEleveDAORemote;
import com.kerenedu.model.report.ViewListeEleve;

@Stateless(mappedName = "ViewListeEleveDAO")
public class ViewListeEleveDAOImpl
    extends AbstractGenericDAO<ViewListeEleve, Long>
    implements ViewListeEleveDAOLocal, ViewListeEleveDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ViewListeEleveDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewListeEleve> getManagedEntityClass() {
        return (ViewListeEleve.class);
    }

}
