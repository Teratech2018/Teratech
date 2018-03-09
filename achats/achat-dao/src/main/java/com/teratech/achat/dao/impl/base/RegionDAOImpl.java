
package com.teratech.achat.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.base.RegionDAOLocal;
import com.teratech.achat.dao.ifaces.base.RegionDAORemote;
import com.teratech.achat.model.base.Region;

@Stateless(mappedName = "RegionDAO")
public class RegionDAOImpl
    extends AbstractGenericDAO<Region, Long>
    implements RegionDAOLocal, RegionDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
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
