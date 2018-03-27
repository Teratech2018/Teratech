
package com.keren.dao.impl.conges;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.conges.DemandeCongeCDAOLocal;
import com.keren.dao.ifaces.conges.DemandeCongeCDAORemote;
import com.keren.model.conges.DemandeCongeC;

@Stateless(mappedName = "DemandeCongeCDAO")
public class DemandeCongeCDAOImpl
    extends AbstractGenericDAO<DemandeCongeC, Long>
    implements DemandeCongeCDAOLocal, DemandeCongeCDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public DemandeCongeCDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DemandeCongeC> getManagedEntityClass() {
        return (DemandeCongeC.class);
    }

}
