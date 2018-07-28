
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.RegionDAOLocal;
import com.teratech.gmao.dao.ifaces.base.RegionDAORemote;
import com.teratech.gmao.model.base.Region;

@Stateless(mappedName = "RegionDAO")
public class RegionDAOImpl
    extends AbstractGenericDAO<Region, Long>
    implements RegionDAOLocal, RegionDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public RegionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Region> getManagedEntityClass() {
        return (Region.class);
    }

}
