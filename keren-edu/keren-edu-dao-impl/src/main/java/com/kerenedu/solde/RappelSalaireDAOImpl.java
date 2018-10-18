
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "RappelSalaireDAO")
public class RappelSalaireDAOImpl
    extends AbstractGenericDAO<RappelSalaire, Long>
    implements RappelSalaireDAOLocal, RappelSalaireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public RappelSalaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<RappelSalaire> getManagedEntityClass() {
        return (RappelSalaire.class);
    }

}
