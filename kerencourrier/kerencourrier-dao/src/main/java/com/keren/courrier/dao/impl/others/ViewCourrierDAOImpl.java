
package com.keren.courrier.dao.impl.others;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.others.ViewCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.others.ViewCourrierDAORemote;
import com.keren.courrier.model.others.ViewCourrier;

@Stateless(mappedName = "ViewCourrierDAO")
public class ViewCourrierDAOImpl
    extends AbstractGenericDAO<ViewCourrier, Long>
    implements ViewCourrierDAOLocal, ViewCourrierDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public ViewCourrierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewCourrier> getManagedEntityClass() {
        return (ViewCourrier.class);
    }

}
