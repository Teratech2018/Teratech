
package com.keren.kerenpaie.dao.impl.prets;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.prets.DemandePretDAOLocal;
import com.keren.kerenpaie.dao.ifaces.prets.DemandePretDAORemote;
import com.keren.kerenpaie.model.prets.DemandePret;

@Stateless(mappedName = "DemandePretDAO")
public class DemandePretDAOImpl
    extends AbstractGenericDAO<DemandePret, Long>
    implements DemandePretDAOLocal, DemandePretDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public DemandePretDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DemandePret> getManagedEntityClass() {
        return (DemandePret.class);
    }

}
