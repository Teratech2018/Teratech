
package com.keren.dao.impl.formations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.formations.PlanningFormationDAOLocal;
import com.keren.dao.ifaces.formations.PlanningFormationDAORemote;
import com.keren.model.formations.PlanningFormation;

@Stateless(mappedName = "PlanningFormationDAO")
public class PlanningFormationDAOImpl
    extends AbstractGenericDAO<PlanningFormation, Long>
    implements PlanningFormationDAOLocal, PlanningFormationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public PlanningFormationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PlanningFormation> getManagedEntityClass() {
        return (PlanningFormation.class);
    }

}
