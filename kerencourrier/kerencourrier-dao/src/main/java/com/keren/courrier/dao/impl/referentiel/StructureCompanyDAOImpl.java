
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.StructureCompanyDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.StructureCompanyDAORemote;
import com.keren.courrier.model.referentiel.StructureCompany;

@Stateless(mappedName = "StructureCompanyDAO")
public class StructureCompanyDAOImpl
    extends AbstractGenericDAO<StructureCompany, Long>
    implements StructureCompanyDAOLocal, StructureCompanyDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public StructureCompanyDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<StructureCompany> getManagedEntityClass() {
        return (StructureCompany.class);
    }

}
