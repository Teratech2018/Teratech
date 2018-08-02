
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.PrioriteDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.PrioriteDAORemote;
import com.keren.courrier.model.referentiel.Priorite;

@Stateless(mappedName = "PrioriteDAO")
public class PrioriteDAOImpl
    extends AbstractGenericDAO<Priorite, Long>
    implements PrioriteDAOLocal, PrioriteDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public PrioriteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Priorite> getManagedEntityClass() {
        return (Priorite.class);
    }

}
