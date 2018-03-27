
package com.keren.kerenpaie.core.impl.structures;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.structures.RegionManagerLocal;
import com.keren.kerenpaie.core.ifaces.structures.RegionManagerRemote;
import com.keren.kerenpaie.dao.ifaces.structures.RegionDAOLocal;
import com.keren.kerenpaie.model.structures.Region;

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
