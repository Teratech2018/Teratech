
package com.keren.dao.impl.carrieres;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.carrieres.BonificationDAOLocal;
import com.keren.dao.ifaces.carrieres.BonificationDAORemote;
import com.keren.model.carrieres.Bonification;
import com.keren.model.carrieres.Reclassement;

@Stateless(mappedName = "BonificationDAO")
public class BonificationDAOImpl
    extends AbstractGenericDAO<Bonification, Long>
    implements BonificationDAOLocal, BonificationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public BonificationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Bonification> getManagedEntityClass() {
        return (Bonification.class);
    }

}
