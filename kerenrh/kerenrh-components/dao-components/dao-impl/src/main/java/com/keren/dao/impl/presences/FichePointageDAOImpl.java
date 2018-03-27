
package com.keren.dao.impl.presences;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.presences.FichePointageDAOLocal;
import com.keren.dao.ifaces.presences.FichePointageDAORemote;
import com.keren.model.presences.FichePointage;

@Stateless(mappedName = "FichePointageDAO")
public class FichePointageDAOImpl
    extends AbstractGenericDAO<FichePointage, Long>
    implements FichePointageDAOLocal, FichePointageDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public FichePointageDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<FichePointage> getManagedEntityClass() {
        return (FichePointage.class);
    }

}
