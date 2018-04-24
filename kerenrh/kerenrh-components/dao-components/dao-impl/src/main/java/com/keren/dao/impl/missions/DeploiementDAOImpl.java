
package com.keren.dao.impl.missions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.missions.DeploiementDAOLocal;
import com.keren.dao.ifaces.missions.DeploiementDAORemote;
import com.keren.model.missions.Deploiement;

@Stateless(mappedName = "DeploiementDAO")
public class DeploiementDAOImpl
    extends AbstractGenericDAO<Deploiement, Long>
    implements DeploiementDAOLocal, DeploiementDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public DeploiementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Deploiement> getManagedEntityClass() {
        return (Deploiement.class);
    }

}
