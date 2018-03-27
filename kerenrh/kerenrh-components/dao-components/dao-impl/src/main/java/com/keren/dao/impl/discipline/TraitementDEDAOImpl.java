
package com.keren.dao.impl.discipline;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.discipline.TraitementDEDAOLocal;
import com.keren.dao.ifaces.discipline.TraitementDEDAORemote;
import com.keren.model.discipline.TraitementDE;

@Stateless(mappedName = "TraitementDEDAO")
public class TraitementDEDAOImpl
    extends AbstractGenericDAO<TraitementDE, Long>
    implements TraitementDEDAOLocal, TraitementDEDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public TraitementDEDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TraitementDE> getManagedEntityClass() {
        return (TraitementDE.class);
    }

}
