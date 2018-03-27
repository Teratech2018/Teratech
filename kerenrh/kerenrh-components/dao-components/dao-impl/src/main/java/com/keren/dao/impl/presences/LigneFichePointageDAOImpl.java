
package com.keren.dao.impl.presences;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.presences.LigneFichePointageDAOLocal;
import com.keren.dao.ifaces.presences.LigneFichePointageDAORemote;
import com.keren.model.presences.LigneFichePointage;

@Stateless(mappedName = "LigneFichePointageDAO")
public class LigneFichePointageDAOImpl
    extends AbstractGenericDAO<LigneFichePointage, Long>
    implements LigneFichePointageDAOLocal, LigneFichePointageDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LigneFichePointageDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneFichePointage> getManagedEntityClass() {
        return (LigneFichePointage.class);
    }

}
