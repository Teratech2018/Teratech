
package com.kerenedu.configuration;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "ReductionManager")
public class ReductionManagerImpl
    extends AbstractGenericManager<Reduction, Long>
    implements ReductionManagerLocal, ReductionManagerRemote
{

    @EJB(name = "ReductionDAO")
    protected ReductionDAOLocal dao;

    public ReductionManagerImpl() {
    }

    @Override
    public GenericDAO<Reduction, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
