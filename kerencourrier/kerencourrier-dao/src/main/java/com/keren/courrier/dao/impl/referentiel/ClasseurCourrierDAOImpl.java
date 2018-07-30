
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.ClasseurCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.ClasseurCourrierDAORemote;
import com.keren.courrier.model.referentiel.ClasseurCourrier;

@Stateless(mappedName = "ClasseurCourrierDAO")
public class ClasseurCourrierDAOImpl
    extends AbstractGenericDAO<ClasseurCourrier, Long>
    implements ClasseurCourrierDAOLocal, ClasseurCourrierDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public ClasseurCourrierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ClasseurCourrier> getManagedEntityClass() {
        return (ClasseurCourrier.class);
    }

}
