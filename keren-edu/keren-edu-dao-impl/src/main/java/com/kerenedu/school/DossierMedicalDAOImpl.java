
package com.kerenedu.school;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "DossierMedicalDAO")
public class DossierMedicalDAOImpl
    extends AbstractGenericDAO<DossierMedical, Long>
    implements DossierMedicalDAOLocal, DossierMedicalDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public DossierMedicalDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DossierMedical> getManagedEntityClass() {
        return (DossierMedical.class);
    }

}
