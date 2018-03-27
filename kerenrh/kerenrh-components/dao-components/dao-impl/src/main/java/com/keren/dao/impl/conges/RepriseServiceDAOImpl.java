
package com.keren.dao.impl.conges;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.conges.RepriseServiceDAOLocal;
import com.keren.dao.ifaces.conges.RepriseServiceDAORemote;
import com.keren.model.conges.RepriseService;

@Stateless(mappedName = "RepriseServiceDAO")
public class RepriseServiceDAOImpl
    extends AbstractGenericDAO<RepriseService, Long>
    implements RepriseServiceDAOLocal, RepriseServiceDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public RepriseServiceDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<RepriseService> getManagedEntityClass() {
        return (RepriseService.class);
    }

}
