
package com.keren.courrier.dao.impl.traitement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.traitement.ClassementActionDAOLocal;
import com.keren.courrier.dao.ifaces.traitement.ClassementActionDAORemote;
import com.keren.courrier.model.traitement.ClassementAction;

@Stateless(mappedName = "ClassementActionDAO")
public class ClassementActionDAOImpl
    extends AbstractGenericDAO<ClassementAction, Long>
    implements ClassementActionDAOLocal, ClassementActionDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public ClassementActionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ClassementAction> getManagedEntityClass() {
        return (ClassementAction.class);
    }

}
