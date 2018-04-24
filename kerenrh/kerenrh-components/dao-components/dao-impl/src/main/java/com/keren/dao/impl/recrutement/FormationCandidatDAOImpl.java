
package com.keren.dao.impl.recrutement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.recrutement.FormationCandidatDAOLocal;
import com.keren.dao.ifaces.recrutement.FormationCandidatDAORemote;
import com.keren.model.recrutement.FormationCandidat;

@Stateless(mappedName = "FormationCandidatDAO")
public class FormationCandidatDAOImpl
    extends AbstractGenericDAO<FormationCandidat, Long>
    implements FormationCandidatDAOLocal, FormationCandidatDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public FormationCandidatDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<FormationCandidat> getManagedEntityClass() {
        return (FormationCandidat.class);
    }

}
