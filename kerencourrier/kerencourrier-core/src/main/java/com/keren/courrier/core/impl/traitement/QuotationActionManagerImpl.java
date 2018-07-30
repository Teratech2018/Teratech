
package com.keren.courrier.core.impl.traitement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.traitement.QuotationActionManagerLocal;
import com.keren.courrier.core.ifaces.traitement.QuotationActionManagerRemote;
import com.keren.courrier.dao.ifaces.traitement.QuotationActionDAOLocal;
import com.keren.courrier.model.traitement.QuotationAction;

@TransactionAttribute
@Stateless(mappedName = "QuotationActionManager")
public class QuotationActionManagerImpl
    extends AbstractGenericManager<QuotationAction, Long>
    implements QuotationActionManagerLocal, QuotationActionManagerRemote
{

    @EJB(name = "QuotationActionDAO")
    protected QuotationActionDAOLocal dao;

    public QuotationActionManagerImpl() {
    }

    @Override
    public GenericDAO<QuotationAction, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
