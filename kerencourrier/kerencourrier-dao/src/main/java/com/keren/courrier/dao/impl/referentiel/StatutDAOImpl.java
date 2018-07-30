
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.StatutDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.StatutDAORemote;
import com.keren.courrier.model.referentiel.Statut;

@Stateless(mappedName = "StatutDAO")
public class StatutDAOImpl
    extends AbstractGenericDAO<Statut, Long>
    implements StatutDAOLocal, StatutDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public StatutDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Statut> getManagedEntityClass() {
        return (Statut.class);
    }

}
