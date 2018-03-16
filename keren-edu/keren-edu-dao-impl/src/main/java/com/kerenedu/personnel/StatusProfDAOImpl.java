
package com.kerenedu.personnel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "StatusProfDAO")
public class StatusProfDAOImpl
    extends AbstractGenericDAO<StatusProf, Long>
    implements StatusProfDAOLocal, StatusProfDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public StatusProfDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<StatusProf> getManagedEntityClass() {
        return (StatusProf.class);
    }

}
