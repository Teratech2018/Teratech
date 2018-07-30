
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.BorderoCourrierRDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.BorderoCourrierRDAORemote;
import com.keren.courrier.model.courrier.BorderoCourrierR;

@Stateless(mappedName = "BorderoCourrierRDAO")
public class BorderoCourrierRDAOImpl
    extends AbstractGenericDAO<BorderoCourrierR, Long>
    implements BorderoCourrierRDAOLocal, BorderoCourrierRDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public BorderoCourrierRDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BorderoCourrierR> getManagedEntityClass() {
        return (BorderoCourrierR.class);
    }

}
