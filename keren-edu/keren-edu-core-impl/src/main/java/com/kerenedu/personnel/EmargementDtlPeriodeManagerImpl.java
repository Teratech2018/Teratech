
package com.kerenedu.personnel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "EmargementDtlPeriodeManager")
public class EmargementDtlPeriodeManagerImpl
    extends AbstractGenericManager<EmargementDtlPeriode, Long>
    implements EmargementDtlPeriodeManagerLocal, EmargementDtlPeriodeManagerRemote
{

    @EJB(name = "EmargementDtlPeriodeDAO")
    protected EmargementDtlPeriodeDAOLocal dao;

    public EmargementDtlPeriodeManagerImpl() {
    }

    @Override
    public GenericDAO<EmargementDtlPeriode, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
