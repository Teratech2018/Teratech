
package com.teratech.vente.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.vente.dao.ifaces.base.DeviseDAOLocal;
import com.teratech.vente.dao.ifaces.base.DeviseDAORemote;
import com.teratech.vente.model.base.Devise;

@Stateless(mappedName = "DeviseDAO")
public class DeviseDAOImpl
    extends AbstractGenericDAO<Devise, Long>
    implements DeviseDAOLocal, DeviseDAORemote
{

    @PersistenceContext(unitName = "teratechvente")
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
