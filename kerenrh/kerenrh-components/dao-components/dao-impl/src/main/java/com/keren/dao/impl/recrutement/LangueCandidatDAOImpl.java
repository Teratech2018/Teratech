
package com.keren.dao.impl.recrutement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.recrutement.LangueCandidatDAOLocal;
import com.keren.dao.ifaces.recrutement.LangueCandidatDAORemote;
import com.keren.model.recrutement.LangueCandidat;

@Stateless(mappedName = "LangueCandidatDAO")
public class LangueCandidatDAOImpl
    extends AbstractGenericDAO<LangueCandidat, Long>
    implements LangueCandidatDAOLocal, LangueCandidatDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LangueCandidatDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LangueCandidat> getManagedEntityClass() {
        return (LangueCandidat.class);
    }

}
