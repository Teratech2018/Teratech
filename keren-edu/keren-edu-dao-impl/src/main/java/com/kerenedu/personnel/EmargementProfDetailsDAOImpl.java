
package com.kerenedu.personnel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "EmargementProfDetailsDAO")
public class EmargementProfDetailsDAOImpl
    extends AbstractGenericDAO<EmargementProfDetails, Long>
    implements EmargementProfDetailsDAOLocal, EmargementProfDetailsDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EmargementProfDetailsDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<EmargementProfDetails> getManagedEntityClass() {
        return (EmargementProfDetails.class);
    }

}
