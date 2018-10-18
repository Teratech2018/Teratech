
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "LignePonderationSalaireDAO")
public class LignePonderationSalaireDAOImpl
    extends AbstractGenericDAO<LignePonderationSalaire, Long>
    implements LignePonderationSalaireDAOLocal, LignePonderationSalaireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LignePonderationSalaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LignePonderationSalaire> getManagedEntityClass() {
        return (LignePonderationSalaire.class);
    }

}
