
package com.keren.dao.impl.discipline;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.discipline.DemandeExplicationDAOLocal;
import com.keren.dao.ifaces.discipline.DemandeExplicationDAORemote;
import com.keren.model.discipline.DemandeExplication;

@Stateless(mappedName = "DemandeExplicationDAO")
public class DemandeExplicationDAOImpl
    extends AbstractGenericDAO<DemandeExplication, Long>
    implements DemandeExplicationDAOLocal, DemandeExplicationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public DemandeExplicationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DemandeExplication> getManagedEntityClass() {
        return (DemandeExplication.class);
    }

}
