
package com.kerenedu.dao.impl.report;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.dao.ifaces.report.ViewNotematiereDAOLocal;
import com.kerenedu.dao.ifaces.report.ViewNotematiereDAORemote;
import com.kerenedu.model.report.ViewNotematiere;

@Stateless(mappedName = "ViewNotematiereDAO")
public class ViewNotematiereDAOImpl
    extends AbstractGenericDAO<ViewNotematiere, Long>
    implements ViewNotematiereDAOLocal, ViewNotematiereDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ViewNotematiereDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewNotematiere> getManagedEntityClass() {
        return (ViewNotematiere.class);
    }

}
