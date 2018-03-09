
package com.teratech.achat.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.base.EmplacementDAOLocal;
import com.teratech.achat.dao.ifaces.base.EmplacementDAORemote;
import com.teratech.achat.model.base.Emplacement;

@Stateless(mappedName = "EmplacementDAO")
public class EmplacementDAOImpl
    extends AbstractGenericDAO<Emplacement, Long>
    implements EmplacementDAOLocal, EmplacementDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
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
