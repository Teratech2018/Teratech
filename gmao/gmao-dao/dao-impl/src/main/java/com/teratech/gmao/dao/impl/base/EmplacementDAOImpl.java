
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.EmplacementDAOLocal;
import com.teratech.gmao.dao.ifaces.base.EmplacementDAORemote;
import com.teratech.gmao.model.base.Emplacement;

@Stateless(mappedName = "EmplacementDAO")
public class EmplacementDAOImpl
    extends AbstractGenericDAO<Emplacement, Long>
    implements EmplacementDAOLocal, EmplacementDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public EmplacementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Emplacement> getManagedEntityClass() {
        return (Emplacement.class);
    }

}
