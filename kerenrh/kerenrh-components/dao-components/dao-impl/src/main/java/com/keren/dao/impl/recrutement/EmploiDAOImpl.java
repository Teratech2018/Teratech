
package com.keren.dao.impl.recrutement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.recrutement.EmploiDAOLocal;
import com.keren.dao.ifaces.recrutement.EmploiDAORemote;
import com.keren.model.recrutement.Emploi;

@Stateless(mappedName = "EmploiDAO")
public class EmploiDAOImpl
    extends AbstractGenericDAO<Emploi, Long>
    implements EmploiDAOLocal, EmploiDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EmploiDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Emploi> getManagedEntityClass() {
        return (Emploi.class);
    }

}
