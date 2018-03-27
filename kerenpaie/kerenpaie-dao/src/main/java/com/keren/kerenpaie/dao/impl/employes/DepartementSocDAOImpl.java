
package com.keren.kerenpaie.dao.impl.employes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.employes.DepartementSocDAOLocal;
import com.keren.kerenpaie.dao.ifaces.employes.DepartementSocDAORemote;
import com.keren.kerenpaie.model.employes.DepartementSoc;

@Stateless(mappedName = "DepartementSocDAO")
public class DepartementSocDAOImpl
    extends AbstractGenericDAO<DepartementSoc, Long>
    implements DepartementSocDAOLocal, DepartementSocDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
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
