
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "LigneRappelDAO")
public class LigneRappelDAOImpl
    extends AbstractGenericDAO<LigneRappel, Long>
    implements LigneRappelDAOLocal, LigneRappelDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LigneRappelDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneRappel> getManagedEntityClass() {
        return (LigneRappel.class);
    }

}
