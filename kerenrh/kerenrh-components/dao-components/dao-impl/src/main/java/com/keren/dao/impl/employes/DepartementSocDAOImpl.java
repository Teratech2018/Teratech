
package com.keren.dao.impl.employes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.employes.DepartementSocDAOLocal;
import com.keren.dao.ifaces.employes.DepartementSocDAORemote;
import com.keren.model.employes.DepartementSoc;

@Stateless(mappedName = "DepartementSocDAO")
public class DepartementSocDAOImpl
    extends AbstractGenericDAO<DepartementSoc, Long>
    implements DepartementSocDAOLocal, DepartementSocDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public DepartementSocDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DepartementSoc> getManagedEntityClass() {
        return (DepartementSoc.class);
    }

}
