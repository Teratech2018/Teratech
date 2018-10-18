
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "LignePonderationTypeContratDAO")
public class LignePonderationTypeContratDAOImpl
    extends AbstractGenericDAO<LignePonderationTypeContrat, Long>
    implements LignePonderationTypeContratDAOLocal, LignePonderationTypeContratDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LignePonderationTypeContratDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LignePonderationTypeContrat> getManagedEntityClass() {
        return (LignePonderationTypeContrat.class);
    }

}
