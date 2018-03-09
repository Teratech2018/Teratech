
package com.kerenedu.stages;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "BesionStageVDAO")
public class BesionStageVDAOImpl
    extends AbstractGenericDAO<BesionStageV, Long>
    implements BesionStageVDAOLocal, BesionStageVDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public BesionStageVDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BesionStageV> getManagedEntityClass() {
        return (BesionStageV.class);
    }

}
