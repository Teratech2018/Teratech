
package com.kerenedu.personnel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "EmargementProfDetailsManager")
public class EmargementProfDetailsManagerImpl
    extends AbstractGenericManager<EmargementProfDetails, Long>
    implements EmargementProfDetailsManagerLocal, EmargementProfDetailsManagerRemote
{

    @EJB(name = "EmargementProfDetailsDAO")
    protected EmargementProfDetailsDAOLocal dao;

    public EmargementProfDetailsManagerImpl() {
    }

    @Override
    public GenericDAO<EmargementProfDetails, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
