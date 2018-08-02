
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.base.RegionManagerLocal;
import com.teratech.gmao.core.ifaces.base.RegionManagerRemote;
import com.teratech.gmao.dao.ifaces.base.RegionDAOLocal;
import com.teratech.gmao.model.base.Region;

@TransactionAttribute
@Stateless(mappedName = "RegionManager")
public class RegionManagerImpl
    extends AbstractGenericManager<Region, Long>
    implements RegionManagerLocal, RegionManagerRemote
{

    @EJB(name = "RegionDAO")
    protected RegionDAOLocal dao;

    public RegionManagerImpl() {
    }

    @Override
    public GenericDAO<Region, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
