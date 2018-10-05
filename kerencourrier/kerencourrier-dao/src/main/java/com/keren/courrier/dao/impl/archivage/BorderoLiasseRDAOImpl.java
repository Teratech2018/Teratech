
package com.keren.courrier.dao.impl.archivage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.archivage.BorderoLiasseRDAOLocal;
import com.keren.courrier.dao.ifaces.archivage.BorderoLiasseRDAORemote;
import com.keren.courrier.model.archivage.BorderoLiasseR;

@Stateless(mappedName = "BorderoLiasseRDAO")
public class BorderoLiasseRDAOImpl
    extends AbstractGenericDAO<BorderoLiasseR, Long>
    implements BorderoLiasseRDAOLocal, BorderoLiasseRDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public BorderoLiasseRDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BorderoLiasseR> getManagedEntityClass() {
        return (BorderoLiasseR.class);
    }

}
