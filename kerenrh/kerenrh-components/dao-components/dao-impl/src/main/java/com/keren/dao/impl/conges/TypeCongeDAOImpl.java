
package com.keren.dao.impl.conges;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.conges.TypeCongeDAOLocal;
import com.keren.dao.ifaces.conges.TypeCongeDAORemote;
import com.keren.model.conges.TypeConge;

@Stateless(mappedName = "TypeCongeDAO")
public class TypeCongeDAOImpl
    extends AbstractGenericDAO<TypeConge, Long>
    implements TypeCongeDAOLocal, TypeCongeDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public TypeCongeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TypeConge> getManagedEntityClass() {
        return (TypeConge.class);
    }

}
