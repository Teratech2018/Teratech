
package com.kerenedu.discipline;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "TypeAbscenceDAO")
public class TypeAbscenceDAOImpl
    extends AbstractGenericDAO<TypeAbscence, Long>
    implements TypeAbscenceDAOLocal, TypeAbscenceDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public TypeAbscenceDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TypeAbscence> getManagedEntityClass() {
        return (TypeAbscence.class);
    }

}
