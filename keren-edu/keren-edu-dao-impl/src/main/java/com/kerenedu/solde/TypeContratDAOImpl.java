
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "TypeContratDAO")
public class TypeContratDAOImpl
    extends AbstractGenericDAO<TypeContrat, Long>
    implements TypeContratDAOLocal, TypeContratDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public TypeContratDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TypeContrat> getManagedEntityClass() {
        return (TypeContrat.class);
    }

}
