
package com.keren.dao.impl.carrieres;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.carrieres.AvancementDAOLocal;
import com.keren.dao.ifaces.carrieres.AvancementDAORemote;
import com.keren.model.carrieres.Avancement;

@Stateless(mappedName = "AvancementDAO")
public class AvancementDAOImpl
    extends AbstractGenericDAO<Avancement, Long>
    implements AvancementDAOLocal, AvancementDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public AvancementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Avancement> getManagedEntityClass() {
        return (Avancement.class);
    }

}
