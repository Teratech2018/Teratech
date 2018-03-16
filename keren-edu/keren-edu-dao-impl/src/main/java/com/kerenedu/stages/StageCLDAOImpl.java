
package com.kerenedu.stages;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "StageCLDAO")
public class StageCLDAOImpl
    extends AbstractGenericDAO<StageCL, Long>
    implements StageCLDAOLocal, StageCLDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public StageCLDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<StageCL> getManagedEntityClass() {
        return (StageCL.class);
    }

}
