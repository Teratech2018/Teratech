
package com.keren.posweb.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.posweb.dao.ifaces.StructureDAOLocal;
import com.keren.posweb.dao.ifaces.StructureDAORemote;
import com.keren.posweb.model.Structure;

@Stateless(mappedName = "StructureDAO")
public class StructureDAOImpl
    extends AbstractGenericDAO<Structure, Long>
    implements StructureDAOLocal, StructureDAORemote
{

    @PersistenceContext(unitName = "posweb")
    protected EntityManager em;

    public StructureDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Structure> getManagedEntityClass() {
        return (Structure.class);
    }

}
