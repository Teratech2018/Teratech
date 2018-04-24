
package com.keren.dao.impl.formations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.formations.LignePlanningFormationDAOLocal;
import com.keren.dao.ifaces.formations.LignePlanningFormationDAORemote;
import com.keren.model.formations.LignePlanningFormation;

@Stateless(mappedName = "LignePlanningFormationDAO")
public class LignePlanningFormationDAOImpl
    extends AbstractGenericDAO<LignePlanningFormation, Long>
    implements LignePlanningFormationDAOLocal, LignePlanningFormationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LignePlanningFormationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LignePlanningFormation> getManagedEntityClass() {
        return (LignePlanningFormation.class);
    }

}
