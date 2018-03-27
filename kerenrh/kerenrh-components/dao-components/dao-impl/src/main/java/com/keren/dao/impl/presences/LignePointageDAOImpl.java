
package com.keren.dao.impl.presences;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.presences.LignePointageDAOLocal;
import com.keren.dao.ifaces.presences.LignePointageDAORemote;
import com.keren.model.presences.LignePointage;

@Stateless(mappedName = "LignePointageDAO")
public class LignePointageDAOImpl
    extends AbstractGenericDAO<LignePointage, Long>
    implements LignePointageDAOLocal, LignePointageDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LignePointageDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LignePointage> getManagedEntityClass() {
        return (LignePointage.class);
    }

}
