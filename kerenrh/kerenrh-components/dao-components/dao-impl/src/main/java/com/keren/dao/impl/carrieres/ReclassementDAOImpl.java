
package com.keren.dao.impl.carrieres;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.carrieres.ReclassementDAOLocal;
import com.keren.dao.ifaces.carrieres.ReclassementDAORemote;
import com.keren.model.carrieres.Reclassement;

@Stateless(mappedName = "ReclassementDAO")
public class ReclassementDAOImpl
    extends AbstractGenericDAO<Reclassement, Long>
    implements ReclassementDAOLocal, ReclassementDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ReclassementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Reclassement> getManagedEntityClass() {
        return (Reclassement.class);
    }

}
