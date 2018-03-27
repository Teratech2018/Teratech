
package com.keren.dao.impl.discipline;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.discipline.SanctionDAOLocal;
import com.keren.dao.ifaces.discipline.SanctionDAORemote;
import com.keren.model.discipline.Sanction;

@Stateless(mappedName = "SanctionDAO")
public class SanctionDAOImpl
    extends AbstractGenericDAO<Sanction, Long>
    implements SanctionDAOLocal, SanctionDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public SanctionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Sanction> getManagedEntityClass() {
        return (Sanction.class);
    }

}
