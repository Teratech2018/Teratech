
package com.keren.dao.impl.structures;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.structures.DeviseDAOLocal;
import com.keren.dao.ifaces.structures.DeviseDAORemote;
import com.keren.model.structures.Devise;

@Stateless(mappedName = "DeviseDAO")
public class DeviseDAOImpl
    extends AbstractGenericDAO<Devise, Long>
    implements DeviseDAOLocal, DeviseDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public DeviseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Devise> getManagedEntityClass() {
        return (Devise.class);
    }

}
