
package com.keren.dao.impl.formations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.formations.BesionFormationDAOLocal;
import com.keren.dao.ifaces.formations.BesionFormationDAORemote;
import com.keren.model.formations.BesionFormation;

@Stateless(mappedName = "BesionFormationDAO")
public class BesionFormationDAOImpl
    extends AbstractGenericDAO<BesionFormation, Long>
    implements BesionFormationDAOLocal, BesionFormationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public BesionFormationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BesionFormation> getManagedEntityClass() {
        return (BesionFormation.class);
    }

}
