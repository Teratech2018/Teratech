
package com.keren.dao.impl.carrieres;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.carrieres.CessationDAOLocal;
import com.keren.dao.ifaces.carrieres.CessationDAORemote;
import com.keren.model.carrieres.Cessation;

@Stateless(mappedName = "CessationDAO")
public class CessationDAOImpl
    extends AbstractGenericDAO<Cessation, Long>
    implements CessationDAOLocal, CessationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public CessationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Cessation> getManagedEntityClass() {
        return (Cessation.class);
    }

}
