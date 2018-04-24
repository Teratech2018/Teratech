
package com.keren.dao.impl.recrutement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.recrutement.RecrutementDAOLocal;
import com.keren.dao.ifaces.recrutement.RecrutementDAORemote;
import com.keren.model.recrutement.Recrutement;

@Stateless(mappedName = "RecrutementDAO")
public class RecrutementDAOImpl
    extends AbstractGenericDAO<Recrutement, Long>
    implements RecrutementDAOLocal, RecrutementDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public RecrutementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Recrutement> getManagedEntityClass() {
        return (Recrutement.class);
    }

}
