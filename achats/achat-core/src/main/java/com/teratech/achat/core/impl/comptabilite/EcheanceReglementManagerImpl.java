
package com.teratech.achat.core.impl.comptabilite;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.achat.core.ifaces.comptabilite.EcheanceReglementManagerLocal;
import com.teratech.achat.core.ifaces.comptabilite.EcheanceReglementManagerRemote;
import com.teratech.achat.dao.ifaces.comptabilite.EcheanceReglementDAOLocal;
import com.teratech.achat.model.comptabilite.EcheanceReglement;

@TransactionAttribute
@Stateless(mappedName = "EcheanceReglementManager")
public class EcheanceReglementManagerImpl
    extends AbstractGenericManager<EcheanceReglement, Long>
    implements EcheanceReglementManagerLocal, EcheanceReglementManagerRemote
{

    @EJB(name = "EcheanceReglementDAO")
    protected EcheanceReglementDAOLocal dao;

    public EcheanceReglementManagerImpl() {
    }

    @Override
    public GenericDAO<EcheanceReglement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
