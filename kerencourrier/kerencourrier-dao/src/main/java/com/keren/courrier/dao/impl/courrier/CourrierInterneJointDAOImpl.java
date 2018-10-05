
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.CourrierInterneJointDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierInterneJointDAORemote;
import com.keren.courrier.model.courrier.CourrierInterneJoint;

@Stateless(mappedName = "CourrierInterneJointDAO")
public class CourrierInterneJointDAOImpl
    extends AbstractGenericDAO<CourrierInterneJoint, Long>
    implements CourrierInterneJointDAOLocal, CourrierInterneJointDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CourrierInterneJointDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CourrierInterneJoint> getManagedEntityClass() {
        return (CourrierInterneJoint.class);
    }

}
