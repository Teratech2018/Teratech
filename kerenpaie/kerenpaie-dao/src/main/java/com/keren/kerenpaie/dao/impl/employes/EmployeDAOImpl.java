
package com.keren.kerenpaie.dao.impl.employes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.employes.EmployeDAOLocal;
import com.keren.kerenpaie.dao.ifaces.employes.EmployeDAORemote;
import com.keren.kerenpaie.model.employes.Employe;

@Stateless(mappedName = "EmployeDAO")
public class EmployeDAOImpl
    extends AbstractGenericDAO<Employe, Long>
    implements EmployeDAOLocal, EmployeDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
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
