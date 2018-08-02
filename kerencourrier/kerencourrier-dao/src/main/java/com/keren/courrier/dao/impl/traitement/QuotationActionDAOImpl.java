
package com.keren.courrier.dao.impl.traitement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.traitement.QuotationActionDAOLocal;
import com.keren.courrier.dao.ifaces.traitement.QuotationActionDAORemote;
import com.keren.courrier.model.traitement.QuotationAction;

@Stateless(mappedName = "QuotationActionDAO")
public class QuotationActionDAOImpl
    extends AbstractGenericDAO<QuotationAction, Long>
    implements QuotationActionDAOLocal, QuotationActionDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public QuotationActionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<QuotationAction> getManagedEntityClass() {
        return (QuotationAction.class);
    }

}
