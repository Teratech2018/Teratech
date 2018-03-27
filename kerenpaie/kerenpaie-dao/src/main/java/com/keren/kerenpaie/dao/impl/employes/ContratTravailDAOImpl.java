
package com.keren.kerenpaie.dao.impl.employes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.employes.ContratTravailDAOLocal;
import com.keren.kerenpaie.dao.ifaces.employes.ContratTravailDAORemote;
import com.keren.kerenpaie.model.employes.ContratTravail;

@Stateless(mappedName = "ContratTravailDAO")
public class ContratTravailDAOImpl
    extends AbstractGenericDAO<ContratTravail, Long>
    implements ContratTravailDAOLocal, ContratTravailDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
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
