
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "LigneHelperDAO")
public class LigneHelperDAOImpl
    extends AbstractGenericDAO<LigneHelper, Long>
    implements LigneHelperDAOLocal, LigneHelperDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LigneHelperDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneHelper> getManagedEntityClass() {
        return (LigneHelper.class);
    }

}
