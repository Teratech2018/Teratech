
package com.kerenedu.personnel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "EmargementProfDAO")
public class EmargementProfDAOImpl
    extends AbstractGenericDAO<EmargementProf, Long>
    implements EmargementProfDAOLocal, EmargementProfDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EmargementProfDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<EmargementProf> getManagedEntityClass() {
        return (EmargementProf.class);
    }

}
