
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.MarqueDAOLocal;
import com.teratech.gmao.dao.ifaces.base.MarqueDAORemote;
import com.teratech.gmao.model.base.Marque;

@Stateless(mappedName = "MarqueDAO")
public class MarqueDAOImpl
    extends AbstractGenericDAO<Marque, Long>
    implements MarqueDAOLocal, MarqueDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public MarqueDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Marque> getManagedEntityClass() {
        return (Marque.class);
    }

}
