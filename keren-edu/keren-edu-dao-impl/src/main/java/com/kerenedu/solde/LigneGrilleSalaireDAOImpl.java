
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "LigneGrilleSalaireDAO")
public class LigneGrilleSalaireDAOImpl
    extends AbstractGenericDAO<LigneGrilleSalaire, Long>
    implements LigneGrilleSalaireDAOLocal, LigneGrilleSalaireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LigneGrilleSalaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneGrilleSalaire> getManagedEntityClass() {
        return (LigneGrilleSalaire.class);
    }

}
