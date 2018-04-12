
package com.keren.dao.impl.missions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.missions.FraisMissionDAOLocal;
import com.keren.dao.ifaces.missions.FraisMissionDAORemote;
import com.keren.model.missions.FraisMission;

@Stateless(mappedName = "FraisMissionDAO")
public class FraisMissionDAOImpl
    extends AbstractGenericDAO<FraisMission, Long>
    implements FraisMissionDAOLocal, FraisMissionDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public FraisMissionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<FraisMission> getManagedEntityClass() {
        return (FraisMission.class);
    }

}
