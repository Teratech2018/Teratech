
package com.kerenedu.solde;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "LigneConvensionManager")
public class LigneConvensionManagerImpl
    extends AbstractGenericManager<LigneConvension, Long>
    implements LigneConvensionManagerLocal, LigneConvensionManagerRemote
{

    @EJB(name = "LigneConvensionDAO")
    protected LigneConvensionDAOLocal dao;

    public LigneConvensionManagerImpl() {
    }

    @Override
    public GenericDAO<LigneConvension, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
