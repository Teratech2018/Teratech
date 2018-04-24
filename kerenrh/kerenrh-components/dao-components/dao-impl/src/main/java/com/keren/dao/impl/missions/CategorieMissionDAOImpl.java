
package com.keren.dao.impl.missions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.missions.CategorieMissionDAOLocal;
import com.keren.dao.ifaces.missions.CategorieMissionDAORemote;
import com.keren.model.missions.CategorieMission;

@Stateless(mappedName = "CategorieMissionDAO")
public class CategorieMissionDAOImpl
    extends AbstractGenericDAO<CategorieMission, Long>
    implements CategorieMissionDAOLocal, CategorieMissionDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public CategorieMissionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CategorieMission> getManagedEntityClass() {
        return (CategorieMission.class);
    }

}
