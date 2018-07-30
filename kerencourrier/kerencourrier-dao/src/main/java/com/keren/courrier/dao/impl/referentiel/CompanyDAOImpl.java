
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.CompanyDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.CompanyDAORemote;
import com.keren.courrier.model.referentiel.Company;

@Stateless(mappedName = "CompanyDAO")
public class CompanyDAOImpl
    extends AbstractGenericDAO<Company, Long>
    implements CompanyDAOLocal, CompanyDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CompanyDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Company> getManagedEntityClass() {
        return (Company.class);
    }

}
