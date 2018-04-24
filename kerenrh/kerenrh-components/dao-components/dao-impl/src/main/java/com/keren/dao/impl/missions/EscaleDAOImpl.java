
package com.keren.dao.impl.missions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.missions.EscaleDAOLocal;
import com.keren.dao.ifaces.missions.EscaleDAORemote;
import com.keren.model.missions.Escale;

@Stateless(mappedName = "EscaleDAO")
public class EscaleDAOImpl
    extends AbstractGenericDAO<Escale, Long>
    implements EscaleDAOLocal, EscaleDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EscaleDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Escale> getManagedEntityClass() {
        return (Escale.class);
    }

}
