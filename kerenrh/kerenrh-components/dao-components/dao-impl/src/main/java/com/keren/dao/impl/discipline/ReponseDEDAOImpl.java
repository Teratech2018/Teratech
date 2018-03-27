
package com.keren.dao.impl.discipline;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.discipline.ReponseDEDAOLocal;
import com.keren.dao.ifaces.discipline.ReponseDEDAORemote;
import com.keren.model.discipline.ReponseDE;

@Stateless(mappedName = "ReponseDEDAO")
public class ReponseDEDAOImpl
    extends AbstractGenericDAO<ReponseDE, Long>
    implements ReponseDEDAOLocal, ReponseDEDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ReponseDEDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ReponseDE> getManagedEntityClass() {
        return (ReponseDE.class);
    }

}
