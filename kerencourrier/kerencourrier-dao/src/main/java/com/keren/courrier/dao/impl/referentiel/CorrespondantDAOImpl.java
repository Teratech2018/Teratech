
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.CorrespondantDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.CorrespondantDAORemote;
import com.keren.courrier.model.referentiel.Correspondant;

@Stateless(mappedName = "CorrespondantDAO")
public class CorrespondantDAOImpl
    extends AbstractGenericDAO<Correspondant, Long>
    implements CorrespondantDAOLocal, CorrespondantDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CorrespondantDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Correspondant> getManagedEntityClass() {
        return (Correspondant.class);
    }

}
