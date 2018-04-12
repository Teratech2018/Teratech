
package com.keren.dao.impl.recrutement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.recrutement.ExperienceCandidatDAOLocal;
import com.keren.dao.ifaces.recrutement.ExperienceCandidatDAORemote;
import com.keren.model.recrutement.ExperienceCandidat;

@Stateless(mappedName = "ExperienceCandidatDAO")
public class ExperienceCandidatDAOImpl
    extends AbstractGenericDAO<ExperienceCandidat, Long>
    implements ExperienceCandidatDAOLocal, ExperienceCandidatDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ExperienceCandidatDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ExperienceCandidat> getManagedEntityClass() {
        return (ExperienceCandidat.class);
    }

}
