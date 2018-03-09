
package com.teratech.achat.core.impl.comptabilite;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.achat.core.ifaces.comptabilite.ModeReglementManagerLocal;
import com.teratech.achat.core.ifaces.comptabilite.ModeReglementManagerRemote;
import com.teratech.achat.dao.ifaces.comptabilite.ModeReglementDAOLocal;
import com.teratech.achat.model.comptabilite.ModeReglement;

@TransactionAttribute
@Stateless(mappedName = "ModeReglementManager")
public class ModeReglementManagerImpl
    extends AbstractGenericManager<ModeReglement, Long>
    implements ModeReglementManagerLocal, ModeReglementManagerRemote
{

    @EJB(name = "ModeReglementDAO")
    protected ModeReglementDAOLocal dao;

    public ModeReglementManagerImpl() {
    }

    @Override
    public GenericDAO<ModeReglement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
