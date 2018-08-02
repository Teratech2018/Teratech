
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.CourrierAQuoteDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierAQuoteDAORemote;
import com.keren.courrier.model.courrier.CourrierAQuote;

@Stateless(mappedName = "CourrierAQuoteDAO")
public class CourrierAQuoteDAOImpl
    extends AbstractGenericDAO<CourrierAQuote, Long>
    implements CourrierAQuoteDAOLocal, CourrierAQuoteDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CourrierAQuoteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CourrierAQuote> getManagedEntityClass() {
        return (CourrierAQuote.class);
    }

}
