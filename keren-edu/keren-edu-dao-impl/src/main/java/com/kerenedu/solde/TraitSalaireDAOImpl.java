
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "TraitSalaireDAO")
public class TraitSalaireDAOImpl
    extends AbstractGenericDAO<TraitSalaire, Long>
    implements TraitSalaireDAOLocal, TraitSalaireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public TraitSalaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TraitSalaire> getManagedEntityClass() {
        return (TraitSalaire.class);
    }

}
