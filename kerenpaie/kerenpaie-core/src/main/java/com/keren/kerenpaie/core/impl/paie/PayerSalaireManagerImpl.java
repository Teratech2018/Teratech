
package com.keren.kerenpaie.core.impl.paie;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.paie.PayerSalaireManagerLocal;
import com.keren.kerenpaie.core.ifaces.paie.PayerSalaireManagerRemote;
import com.keren.kerenpaie.dao.ifaces.paie.PayerSalaireDAOLocal;
import com.keren.kerenpaie.model.paie.PayerSalaire;

@TransactionAttribute
@Stateless(mappedName = "PayerSalaireManager")
public class PayerSalaireManagerImpl
    extends AbstractGenericManager<PayerSalaire, Long>
    implements PayerSalaireManagerLocal, PayerSalaireManagerRemote
{

    @EJB(name = "PayerSalaireDAO")
    protected PayerSalaireDAOLocal dao;

    public PayerSalaireManagerImpl() {
    }

    @Override
    public GenericDAO<PayerSalaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
