
package com.keren.dao.impl.employes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.employes.EmployeDAOLocal;
import com.keren.dao.ifaces.employes.EmployeDAORemote;
import com.keren.model.employes.Employe;

@Stateless(mappedName = "EmployeDAO")
public class EmployeDAOImpl
    extends AbstractGenericDAO<Employe, Long>
    implements EmployeDAOLocal, EmployeDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EmployeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Employe> getManagedEntityClass() {
        return (Employe.class);
    }

}
