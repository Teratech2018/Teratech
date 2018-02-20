
package com.kerenedu.personnel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ProfMatiereEnsDAO")
public class ProfMatiereEnsDAOImpl
    extends AbstractGenericDAO<ProfMatiereEns, Long>
    implements ProfMatiereEnsDAOLocal, ProfMatiereEnsDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ProfMatiereEnsDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ProfMatiereEns> getManagedEntityClass() {
        return (ProfMatiereEns.class);
    }

}
