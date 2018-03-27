
package com.keren.dao.impl.structures;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.structures.DepartementDAOLocal;
import com.keren.dao.ifaces.structures.DepartementDAORemote;
import com.keren.model.structures.Departement;

@Stateless(mappedName = "DepartementDAO")
public class DepartementDAOImpl
    extends AbstractGenericDAO<Departement, Long>
    implements DepartementDAOLocal, DepartementDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public DepartementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Departement> getManagedEntityClass() {
        return (Departement.class);
    }

}
