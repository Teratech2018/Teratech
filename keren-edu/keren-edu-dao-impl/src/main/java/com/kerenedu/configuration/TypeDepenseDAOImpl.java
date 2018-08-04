
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "TypeDepenseDAO")
public class TypeDepenseDAOImpl
    extends AbstractGenericDAO<TypeDepense, Long>
    implements TypeDepenseDAOLocal, TypeDepenseDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public TypeDepenseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TypeDepense> getManagedEntityClass() {
        return (TypeDepense.class);
    }

}
