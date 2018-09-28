
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "GrilleSalaireDAO")
public class GrilleSalaireDAOImpl
    extends AbstractGenericDAO<GrilleSalaire, Long>
    implements GrilleSalaireDAOLocal, GrilleSalaireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public GrilleSalaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<GrilleSalaire> getManagedEntityClass() {
        return (GrilleSalaire.class);
    }

}
