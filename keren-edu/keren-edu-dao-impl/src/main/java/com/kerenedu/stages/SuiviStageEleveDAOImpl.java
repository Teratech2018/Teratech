
package com.kerenedu.stages;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "SuiviStageEleveDAO")
public class SuiviStageEleveDAOImpl
    extends AbstractGenericDAO<SuiviStageEleve, Long>
    implements SuiviStageEleveDAOLocal, SuiviStageEleveDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public SuiviStageEleveDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<SuiviStageEleve> getManagedEntityClass() {
        return (SuiviStageEleve.class);
    }

}
