
package com.keren.dao.impl.carrieres;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.carrieres.RetrogradationDAOLocal;
import com.keren.dao.ifaces.carrieres.RetrogradationDAORemote;
import com.keren.model.carrieres.Retrogradation;

@Stateless(mappedName = "RetrogradationDAO")
public class RetrogradationDAOImpl
    extends AbstractGenericDAO<Retrogradation, Long>
    implements RetrogradationDAOLocal, RetrogradationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public RetrogradationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Retrogradation> getManagedEntityClass() {
        return (Retrogradation.class);
    }

}
