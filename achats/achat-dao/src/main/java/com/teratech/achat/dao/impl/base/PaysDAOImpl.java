
package com.teratech.achat.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.base.PaysDAOLocal;
import com.teratech.achat.dao.ifaces.base.PaysDAORemote;
import com.teratech.achat.model.base.Pays;

@Stateless(mappedName = "PaysDAO")
public class PaysDAOImpl
    extends AbstractGenericDAO<Pays, Long>
    implements PaysDAOLocal, PaysDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public PaysDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Pays> getManagedEntityClass() {
        return (Pays.class);
    }

}
