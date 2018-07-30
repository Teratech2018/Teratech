
package com.keren.courrier.dao.impl.traitement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.traitement.AnnotationActionDAOLocal;
import com.keren.courrier.dao.ifaces.traitement.AnnotationActionDAORemote;
import com.keren.courrier.model.traitement.AnnotationAction;

@Stateless(mappedName = "AnnotationActionDAO")
public class AnnotationActionDAOImpl
    extends AbstractGenericDAO<AnnotationAction, Long>
    implements AnnotationActionDAOLocal, AnnotationActionDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public AnnotationActionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<AnnotationAction> getManagedEntityClass() {
        return (AnnotationAction.class);
    }

}
