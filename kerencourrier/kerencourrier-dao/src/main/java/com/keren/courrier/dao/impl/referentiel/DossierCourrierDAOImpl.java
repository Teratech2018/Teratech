
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.DossierCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.DossierCourrierDAORemote;
import com.keren.courrier.model.referentiel.DossierCourrier;

@Stateless(mappedName = "DossierCourrierDAO")
public class DossierCourrierDAOImpl
    extends AbstractGenericDAO<DossierCourrier, Long>
    implements DossierCourrierDAOLocal, DossierCourrierDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public DossierCourrierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DossierCourrier> getManagedEntityClass() {
        return (DossierCourrier.class);
    }

}
