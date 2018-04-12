
package com.keren.dao.impl.recrutement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.recrutement.CandidatureSpontaneDAOLocal;
import com.keren.dao.ifaces.recrutement.CandidatureSpontaneDAORemote;
import com.keren.model.recrutement.CandidatureSpontane;

@Stateless(mappedName = "CandidatureSpontaneDAO")
public class CandidatureSpontaneDAOImpl
    extends AbstractGenericDAO<CandidatureSpontane, Long>
    implements CandidatureSpontaneDAOLocal, CandidatureSpontaneDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public CandidatureSpontaneDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CandidatureSpontane> getManagedEntityClass() {
        return (CandidatureSpontane.class);
    }

}
