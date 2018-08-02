
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.PaysDAOLocal;
import com.teratech.gmao.dao.ifaces.base.PaysDAORemote;
import com.teratech.gmao.model.base.Pays;

@Stateless(mappedName = "PaysDAO")
public class PaysDAOImpl
    extends AbstractGenericDAO<Pays, Long>
    implements PaysDAOLocal, PaysDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
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
