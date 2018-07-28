
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.EntrepotDAOLocal;
import com.teratech.gmao.dao.ifaces.base.EntrepotDAORemote;
import com.teratech.gmao.model.base.Entrepot;

@Stateless(mappedName = "EntrepotDAO")
public class EntrepotDAOImpl
    extends AbstractGenericDAO<Entrepot, Long>
    implements EntrepotDAOLocal, EntrepotDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public EntrepotDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Entrepot> getManagedEntityClass() {
        return (Entrepot.class);
    }

}
