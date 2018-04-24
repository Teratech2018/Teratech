
package com.keren.dao.impl.recrutement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.recrutement.AffectationCandidatDAOLocal;
import com.keren.dao.ifaces.recrutement.AffectationCandidatDAORemote;
import com.keren.model.recrutement.AffectationCandidat;

@Stateless(mappedName = "AffectationCandidatDAO")
public class AffectationCandidatDAOImpl
    extends AbstractGenericDAO<AffectationCandidat, Long>
    implements AffectationCandidatDAOLocal, AffectationCandidatDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public AffectationCandidatDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<AffectationCandidat> getManagedEntityClass() {
        return (AffectationCandidat.class);
    }

}
