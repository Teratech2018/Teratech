
package com.keren.kerenpaie.dao.impl.structures;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.structures.RegionDAOLocal;
import com.keren.kerenpaie.dao.ifaces.structures.RegionDAORemote;
import com.keren.kerenpaie.model.structures.Region;

@Stateless(mappedName = "RegionDAO")
public class RegionDAOImpl
    extends AbstractGenericDAO<Region, Long>
    implements RegionDAOLocal, RegionDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
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
