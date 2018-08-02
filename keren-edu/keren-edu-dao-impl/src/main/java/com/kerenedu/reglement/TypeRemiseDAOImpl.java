
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "TypeRemiseDAO")
public class TypeRemiseDAOImpl
    extends AbstractGenericDAO<TypeRemise, Long>
    implements TypeRemiseDAOLocal, TypeRemiseDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public TypeRemiseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TypeRemise> getManagedEntityClass() {
        return (TypeRemise.class);
    }

}
