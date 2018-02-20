
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "NoteSMSDAO")
public class NoteSMSDAOImpl
    extends AbstractGenericDAO<NoteSMS, Long>
    implements NoteSMSDAOLocal, NoteSMSDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public NoteSMSDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<NoteSMS> getManagedEntityClass() {
        return (NoteSMS.class);
    }

}
