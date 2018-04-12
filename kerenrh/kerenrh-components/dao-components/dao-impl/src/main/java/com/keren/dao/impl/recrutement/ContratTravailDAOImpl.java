
package com.keren.dao.impl.recrutement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.recrutement.ContratTravailDAOLocal;
import com.keren.dao.ifaces.recrutement.ContratTravailDAORemote;
import com.keren.model.recrutement.ContratTravail;

@Stateless(mappedName = "ContratTravailDAO")
public class ContratTravailDAOImpl
    extends AbstractGenericDAO<ContratTravail, Long>
    implements ContratTravailDAOLocal, ContratTravailDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ContratTravailDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ContratTravail> getManagedEntityClass() {
        return (ContratTravail.class);
    }

}
