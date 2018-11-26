
package com.kerenedu.personnel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "EnseignantPMDAO")
public class EnseignantPMDAOImpl
    extends AbstractGenericDAO<EnseignantPM, Long>
    implements EnseignantPMDAOLocal, EnseignantPMDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EnseignantPMDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<EnseignantPM> getManagedEntityClass() {
        return (EnseignantPM.class);
    }

}
